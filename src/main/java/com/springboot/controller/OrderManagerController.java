package com.springboot.controller;


import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.bean.Order;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class OrderManagerController {

    @Autowired
    OrderService orderService;

    //获取所有订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallorders")
    @ResponseBody
    public Msg getAllOrders() {
        List<Order> ordersList = orderService.getAll();
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

    //查找订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchorder")
    @ResponseBody
    public Msg searchOrder(@RequestParam("orderCode") String orderCode){
        List<Order> ordersList = orderService.selectByOrderCode(orderCode);
        return Msg.success().add("orders",ordersList);
    }

    //根据userId获得该用户的所有订单
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/orderofuser")
    @ResponseBody
    public Msg searchOrder(@RequestParam("userId") Integer userId){
        List<Order> ordersList = orderService.selectByUserId(userId);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Order order: ordersList) {
            order.setStr_gmtCreate(sdf.format(order.getGmtCreate()));
        }
        return Msg.success().add("orders",ordersList);
    }
}
