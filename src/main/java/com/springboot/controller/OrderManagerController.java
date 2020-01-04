package com.springboot.controller;


import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.bean.Order;
import com.springboot.bean.ShopCart;
import com.springboot.service.CartService;
import com.springboot.service.GoodsService;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderManagerController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    GoodsService goodsService;

    //获取所有订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallorders")
    @ResponseBody
    public Msg getAllOrders() {
        List<Order> ordersList = orderService.getAll();
        //将订单的所有购物网条目取出
        for (Order order:ordersList) {
            String[] cartIds = order.getDetail().split(",");
            for(int i=0;i<cartIds.length;i++){
                ShopCart cart = cartService.selectByCartId(Integer.parseInt(cartIds[i]));
                cart.setGood(goodsService.selectByGoodsId(cart.getGoodsId()));
                order.getCartList().add(cart);
            }
        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Order order:ordersList) {
            order.setStr_gmtCreate(sdf.format(order.getGmtCreate()));
        }
        return Msg.success().add("orders", ordersList);
    }

    //增加订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/addorder")
    @ResponseBody
    public Msg addOrder(@RequestBody Order order){
        order.setOrderCode(String.valueOf(new Date().getTime()));
        if(orderService.insert(order)!=0){
            List<Order> ordersList = orderService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Order ordertemp:ordersList) {
                ordertemp.setStr_gmtCreate(sdf.format(ordertemp.getGmtCreate()));
            }
            return Msg.success().add("orders", ordersList);
        }else{
            return Msg.fail();
        }
    }

    //删除订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deleteorder")
    @ResponseBody
    public Msg deleteOrder(@RequestParam("id") Integer orderId){
        if(orderService.deleteById(orderId)!=0){
            List<Order> ordersList = orderService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Order order:ordersList) {
                order.setStr_gmtCreate(sdf.format(order.getGmtCreate()));
            }
            return Msg.success().add("orders", ordersList);
        }else{
            return Msg.fail();
        }
    }

    //修改订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updateorder")
    @ResponseBody
    public Msg updateOrder(@RequestBody Order order){
        if(orderService.updateByIdSelective(order)!=0){
            List<Order> ordersList = orderService.getAll();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Order ordertemp:ordersList) {
                ordertemp.setStr_gmtCreate(sdf.format(ordertemp.getGmtCreate()));
            }
            return Msg.success().add("orders", ordersList);
        }else{
            return Msg.fail();
        }
    }

    //根据订单Id查订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/searchorder")
    @ResponseBody
    public Msg searchOrderById(@RequestParam("orderId") Integer orderId){
        Order order = orderService.selectByOrderId(orderId);
        //将订单的所有购物网条目取出
        String[] cartIds = order.getDetail().split(",");
        for(int i=0;i<cartIds.length;i++){
            ShopCart cart = cartService.selectByCartId(Integer.parseInt(cartIds[i]));
            cart.setGood(goodsService.selectByGoodsId(cart.getGoodsId()));
            order.getCartList().add(cart);
        }
        return Msg.success().add("order",order);
    }

    //根据userId获得该用户的所有订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/orderofuser")
    @ResponseBody
    public Msg searchOrder(@RequestParam("userId") Integer userId){
        List<Order> ordersList = orderService.selectByUserId(userId);
        //将订单的所有购物网条目取出
        for (Order order:ordersList) {
            String[] cartIds = order.getDetail().split(",");
            for(int i=0;i<cartIds.length;i++){
                ShopCart cart = cartService.selectByCartId(Integer.parseInt(cartIds[i]));
                cart.setGood(goodsService.selectByGoodsId(cart.getGoodsId()));
                order.getCartList().add(cart);
            }
        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Order order: ordersList) {
            order.setStr_gmtCreate(sdf.format(order.getGmtCreate()));
        }
        return Msg.success().add("orders",ordersList);
    }
}
