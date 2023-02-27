package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.BookInfo;
import cn.kgc.ssm.pojo.LendList;
import cn.kgc.ssm.pojo.ReaderInfo;
import cn.kgc.ssm.service.BookInfoService;
import cn.kgc.ssm.service.LendListService;
import cn.kgc.ssm.service.ReaderInfoService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.controller
 * @DESCRIPTION:
 * @DATE: 2023/2/22 14:09
 * @Version:1.0
 */
@Controller
public class LendListController {
    @Autowired
    private LendListService lendListService;

    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private BookInfoService bookInfoService;

    @RequestMapping("/lendListIndex")
    public String lendListIndex(){
        return "lend/lendListIndex";
    }

    @RequestMapping("/lendListIndex2")
    public String lendListIndex2(){
        return "lend/lendListIndex2";
    }

    @RequestMapping("/lendListAll")
    @ResponseBody
    public DataInfo lendListAll(Integer type, String readerNumber, String name, Integer status,
                                @RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "15")Integer limit){
        LendList lendList = new LendList();
        lendList.setBackType(type);
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderNumber(readerNumber);
        lendList.setReaderInfo(readerInfo);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setName(name);
        bookInfo.setStatus(status);
        lendList.setBookInfo(bookInfo);
        PageInfo<LendList> pageInfo =lendListService.queryLendListAll(lendList,pageNum,limit);
        return DataInfo.ok("ok",pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping("/backLendListByIds")
    @ResponseBody
    public int backLendListByIds(String ids,String bookIds){
        List<String> list = Arrays.asList(ids.split(","));
        List<String> blist = Arrays.asList(bookIds.split(","));

        int i = lendListService.updateLendListByIds(list,blist);
        return i;
    }


    @RequestMapping("/excBackBook")
    public String excBackBook(Integer id, Integer bookId, Model model){
        System.out.println("id = " + id);
        System.out.println("bookId = " + bookId);
        model.addAttribute("id", id);
        model.addAttribute("bid", bookId);
        return "lend/excBackBook";
    }

    @PostMapping("/updateLendListById")
    @ResponseBody
    public int updateLendList(Integer id,Integer bookId,Integer backType){
        LendList lendList = lendListService.selectByPrimaryKey(id);
        lendList.setBookId(bookId);
        lendList.setBackType(backType);
        int i = lendListService.updateLendListById(lendList);
        return i;
    }

    @RequestMapping("/addLendList")
    public String addLendList(){
        return "lend/addLendList";
    }

    @RequestMapping("/queryLookBookList")
    public String queryLookBookList(String flag,Integer id,Model model){
        List<LendList> lendLists = null;
        if (flag.equals("book")){
            lendLists=lendListService.queryLookBookList(null, id);
        }else {
            lendLists=lendListService.queryLookBookList(id, null);
        }
        model.addAttribute("info", lendLists);
        return "lend/lookBookList";
    }

    @RequestMapping("/deleteLendListById")
    @ResponseBody
    public int deleteLendListById(Integer id,Integer bookId){
        int i = lendListService.deleteLendListById(id,bookId);
        return i;
    }

    @RequestMapping("/deleteLendListByIds")
    @ResponseBody
    public int deleteLendListByIds(String ids,String bookIds){
        List<String> list = Arrays.asList(ids.split(","));
        List<String> blist = Arrays.asList(bookIds.split(","));
        int i = lendListService.deleteLendListByIds(list, blist);
        return i;
    }

    @RequestMapping("/addLend")
    @ResponseBody
    public DataInfo addLendList(String readerNumber,String ids){
        List<String> bookIds = Arrays.asList(ids.split(","));

        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderNumber(readerNumber);
        PageInfo<ReaderInfo> readerInfoPageInfo = readerInfoService.queryAllReaderInfo(readerInfo, 1, 1);
        if (readerInfoPageInfo.getList().size()==0){
            return DataInfo.fail("卡号信息不存在!");
        }else{
            ReaderInfo readerCard = readerInfoPageInfo.getList().get(0);
            for (String bookId : bookIds) {
                BookInfo bookInfo = bookInfoService.findbookInfoById(Integer.valueOf(bookId));
                if (bookInfo.getStatus()==0){
                    bookInfo.setStatus(1);
                    LendList lendList = new LendList();
                    lendList.setReaderId(readerCard.getId());
                    lendList.setReaderInfo(readerCard);
                    lendList.setLendDate(new Date());
                    lendList.setBookId(Integer.valueOf(bookId));
                    lendListService.addLendList(lendList);
                    bookInfoService.updatebookInfo(bookInfo);
                }else{
                    return DataInfo.fail("该图书不可借阅");
                }

            }
        }

        return DataInfo.ok();
    }


}
