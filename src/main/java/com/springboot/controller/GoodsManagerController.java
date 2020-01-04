package com.springboot.controller;


import com.springboot.bean.AddAct;
import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.GoodsService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class GoodsManagerController {

    @Autowired
    GoodsService goodsService;

    //获取所有商品
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallgoods")
    @ResponseBody
    public Msg getAllGoods() {
        List<Goods> goodsList = goodsService.getAll();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Goods good : goodsList) {
            good.setStr_createTime(sdf.format(good.getCreateTime()));
        }
        return Msg.success().add("goods", goodsList);
    }

    //增加商品
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/addgood")
    @ResponseBody
    public Msg addGood(@RequestBody Goods good) {
        if (goodsService.insert(good) != 0) {
            List<Goods> goodsList = goodsService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Goods goodtemp : goodsList) {
                goodtemp.setStr_createTime(sdf.format(goodtemp.getCreateTime()));
            }
            return Msg.success().add("goods", goodsList);
        } else {
            return Msg.fail();
        }
    }

    //删除商品
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deletegood")
    @ResponseBody
    public Msg deleteGood(@RequestParam("id") Integer goodId) {
        if (goodsService.deleteById(goodId) != 0) {
            List<Goods> goodsList = goodsService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Goods goodtemp : goodsList) {
                goodtemp.setStr_createTime(sdf.format(goodtemp.getCreateTime()));
            }
            return Msg.success().add("goods", goodsList);
        } else {
            return Msg.fail();
        }
    }

    //修改商品
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updategood")
    @ResponseBody
    public Msg updateGood(@RequestBody Goods good) {
        if (goodsService.updateByIdSelective(good) != 0) {
            List<Goods> goodsList = goodsService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Goods goodtemp : goodsList) {
                goodtemp.setStr_createTime(sdf.format(goodtemp.getCreateTime()));
            }
            return Msg.success().add("goods", goodsList);
        } else {
            return Msg.fail();
        }
    }

    //查找商品
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchgood")
    @ResponseBody
    public Msg searchGood(@RequestParam("goodname") String goodname) {
        List<Goods> goodsList = goodsService.selectByGoodsName(goodname);
        return Msg.success().add("users", goodsList);
    }

    //查找商品ById
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/getgoodbyid")
    @ResponseBody
    public Msg searchGoodId(@RequestParam("goodId") Integer goodId) {
        Goods goods = goodsService.selectByGoodsId(goodId);
        return Msg.success().add("good", goods);
    }

    //上传商品图片-1
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping(value = "/admin/imgupload")
    @ResponseBody
    public Msg imgUpload(@RequestParam(value="img",required = false) MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
            return Msg.fail();
        }
        String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(File.separator) + 1);  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        //图片访问的URI
        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/imgs/";
        //文件临时存储位置,项目重启后会消失，因为是spring boot内置的Tomcat容器
        String path = request.getSession().getServletContext().getRealPath("") + "upload" + File.separator + "imgs";
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        String destFileName = path + File.separator+fileName;
        System.out.println("文件路径为:"+destFileName);
        File dest = new File(destFileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            //文件复制
            String projectPath = System.getProperty("user.dir");
            String src = destFileName;
            //根据自己系统的resource 目录所在位置进行自行配置
            String destDir = "E:"+File.separator+"IntellijProject"+File.separator+"qingzhu_mall"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"upload"+File.separator+"imgs"+File.separator;
            copyFile(src,destDir,fileName);
            //将图片url写入数据库
            String url = "/qingzhu/upload/imgs/" + fileName;
            Goods good = new Goods();
            good.setId(Integer.parseInt(request.getParameter("id")));
            good.setPicURLone(url);
            goodsService.updateByIdSelective(good);
            return Msg.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    //将商品添加进某个活动
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/goodaddtoact")
    @ResponseBody
    public Msg goodAddToAct(AddAct addAct, Integer activityId) {
        for (Integer id: addAct.getGoodIds()) {
            if(goodsService.addGood2Activity(id,activityId)==0){
                return Msg.fail();
            }
        }
        return Msg.success();
    }

    //将商品从某个活动取消
    @CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/rmvgoodfromact")
    @ResponseBody
    public Msg rmvGoodFromAct(@RequestParam("goodId") Integer goodId,@RequestParam("activityId") Integer activityId) {
        if(goodsService.rmvGoodFromAct(goodId,activityId)!=0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    public void copyFile(String src,String destDir,String fileName) throws IOException{
        FileInputStream in=new FileInputStream(src);
        File fileDir = new File(destDir);
        if(!fileDir.isDirectory()){
            fileDir.mkdirs();
        }
        File file = new File(fileDir,fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++){
                out.write(buffer[i]);
            }
        }
        in.close();
        out.close();
    }

}
