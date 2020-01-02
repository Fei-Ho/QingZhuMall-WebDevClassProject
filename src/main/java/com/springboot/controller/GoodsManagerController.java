package com.springboot.controller;


import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.GoodsService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Controller
public class GoodsManagerController {

    @Autowired
    GoodsService goodsService;

    //获取所有商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallgoods")
    @ResponseBody
    public Msg getAllGoods() {
        List<Goods> goodsList = goodsService.getAll();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Goods good:goodsList) {
            good.setStr_createTime(sdf.format(good.getCreateTime()));
        }
        return Msg.success().add("goods", goodsList);
    }

    //增加商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/addgood")
    @ResponseBody
    public Msg deleteGood(Goods good){
        if(goodsService.insert(good)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    //删除商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deletegood")
    @ResponseBody
    public Msg addGood(@RequestParam("id") Integer goodId){
        if(goodsService.deleteById(goodId)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    //修改商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updategood")
    @ResponseBody
    public Msg updateGood(Goods good){
        if(goodsService.updateByIdSelective(good)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    //查找商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchgood")
    @ResponseBody
    public Msg searchGood(@RequestParam("goodname") String goodname){
        List<Goods> goodsList = goodsService.selectByGoodsName(goodname);
        return Msg.success().add("users",goodsList);
    }

    //上传商品图片-1
    /*@RequestMapping("/imageUpload.do")
    public Msg imageUpload_1(@RequestParam("file") MultipartFile multipartFile)  {
        String fileSavePath=shoesImagePath;
        if (null == multipartFile || multipartFile.getSize() <= 0) {
            return new HashMap<String,Object>(){{put("code",400);put("msg","请选择上传文件。");}};
        }
        //文件名
        String originalName = multipartFile.getOriginalFilename();
        String fileName= UUID.randomUUID().toString().replace("-", "");
        String picNewName = fileName + originalName.substring(originalName.lastIndexOf("."));
        String imgRealPath = fileSavePath + picNewName;
        try {
            //保存图片-将multipartFile对象装入image文件中
            File imageFile=new File(imgRealPath);
            multipartFile.transferTo(imageFile);
        } catch (Exception e) {
            return new HashMap<String,Object>(){{put("code",400);put("msg","图片保存异常:"+e);}};
        }
        return new HashMap<String,Object>(){{put("code",200);put("msg",picNewName);}};
    }*/

    //上传商品图片-2

}
