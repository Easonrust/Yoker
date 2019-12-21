package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class CRUD {

    @Autowired
    private UserService userservice;

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser(){
        return userservice.ListUser();
    }

    @RequestMapping("/ListBag")
    @ResponseBody
    public List<Cardbag_user> ListBag(){
        return userservice.ListBag();
    }

    @RequestMapping("/ListCardByBag/{user_name}/{cardbag_id}")
    @ResponseBody
    public List<Card> ListCardByBag(@PathVariable String user_name, @PathVariable String cardbag_id){
        return userservice.ListCardByBag(user_name,cardbag_id);
    }

    @RequestMapping("/ListBagWithoutCard/{user_name}/{card_name}")
    @ResponseBody
    public List<Cardbag_user> ListBagWithoutCard(@PathVariable String user_name, @PathVariable String card_name){
        return userservice.ListBagWithoutCard(user_name,card_name);
    }

    @RequestMapping("/ListDescribeCardByBag/{user_name}/{cardbag_id}")
    @ResponseBody
    public List<Describe_name> ListDescribeCardByBag(@PathVariable String user_name, @PathVariable String cardbag_id){
        List<Describe_name> a=userservice.ListBagDescribe(user_name,cardbag_id);
        List<Describe_name> b=userservice.ListCardNameByBag(user_name,cardbag_id);
        a.addAll(b);

        return a;
    }

    @RequestMapping("/ListUserByname/{name}")
    @ResponseBody
    public List<User> ListUserByname(@PathVariable("name")String name){
        return userservice.findByName(name);
    }

    @RequestMapping("/FindCardByname/{name}")
    @ResponseBody
    public List<Card> FindCardByname(@PathVariable("name")String name){
        return userservice.findCardByName(name);
    }

    @RequestMapping("/FindCardByword/{word}")
    @ResponseBody
    public List<Card> FindCardByword(@PathVariable("word")String word){
        return userservice.findCardByword(word);
    }

    @RequestMapping("/ListBagByname/{name}")
    @ResponseBody
    public List<Cardbag_user> ListBagByname(@PathVariable("name")String name){return userservice.findbagByName(name);}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public int delete(@PathVariable("id") String id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "bag/delete", method = RequestMethod.POST)
    public int deleteBag(@RequestBody Cardbag_user cardbag_user) {
        int result = userservice.deleteBag(cardbag_user);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(@RequestBody User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }

    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public int insert(@RequestBody User user) {
        //return userservice.insertUser(user);
        int result = userservice.insertUser(user);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/Card/insert2bagID", method = RequestMethod.POST)
    public int insertCard2bag(@RequestBody Cardbag_card cardbag_card) {
        //return userservice.insertUser(user);
        int result = userservice.insertCard2bag(cardbag_card);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/Card/insert2bagName", method = RequestMethod.POST)
    public int insert2bagName(@RequestBody Cardbag_cardname cardbag_cardname) {
        //return userservice.insertUser(user);
        int result = userservice.insertCard2bagName(cardbag_cardname);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/Card/insert", method = RequestMethod.POST)
    public int insertCard(@RequestBody Card card) {
        //return userservice.insertUser(user);
        int result = userservice.insertCard(card);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/Bag/insert", method = RequestMethod.POST)
    public int insertBag(@RequestBody Cardbag_user cardbag_user) {
        //return userservice.insertUser(user);
        int result = userservice.insertBag(cardbag_user);
        if (result >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

}