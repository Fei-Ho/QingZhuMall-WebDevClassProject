package com.springboot.controller;

import com.springboot.bean.Admin;
import com.springboot.bean.Msg;
import com.springboot.bean.ShopCart;
import com.springboot.bean.User;
import com.springboot.service.CartService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CartShopController {

    @Autowired
    CartService cartService;

    //获取所有购物车
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallcarts")
    @ResponseBody
    public Msg getAllCarts(){
        List<ShopCart> shopCartList = cartService.getAll();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ShopCart shopcart: shopCartList) {
            shopcart.setStr_gmtCreate(sdf.format(shopcart.getGmtCreate()));
            shopcart.getGood().setStr_createTime(sdf.format(shopcart.getGood().getCreateTime()));
        }
        return Msg.success().add("carts",shopCartList);
    }

    //获取某用户的所有购物车
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/getcartsofuser")
    @ResponseBody
    public Msg getCartsOfUser(@RequestParam("userId") Integer userId){
        List<ShopCart> shopCartList = cartService.selectByUserId(userId);
        return Msg.success().add("carts",shopCartList);
    }

}