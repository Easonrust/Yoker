package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;
//import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findByName(String name) {
        return userMapper.findUserByName(name);
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
    public List<User> ListUser(){
        return userMapper.ListUser();
    }

    public int Update(User user){
        return userMapper.Update(user);
    }

    public int delete(String id){
        return userMapper.delete(id);
    }

    public List<Cardbag_user> findbagByName(String name) {return userMapper.findBagByName(name); }

    public List<Cardbag_user> ListBag() {return userMapper.ListBag(); }

    public List<Card> ListCardByBag(String user_name,String cardbag_id) { return userMapper.ListCardByBag(user_name,cardbag_id);
    }

    public List<Describe_name> ListBagDescribe(String user_name, String cardbag_id){return userMapper.ListBagDescribe(user_name,cardbag_id);}
    public List<Describe_name> ListCardNameByBag(String user_name, String cardbag_id){return userMapper.ListCardname(user_name,cardbag_id);}

    public int insertCard2bag(Cardbag_card cardbag_card) { return userMapper.insertCard2bag(cardbag_card);}


    public int insertBag(Cardbag_user cardbag_user) { return userMapper.insertBag(cardbag_user);
    }

    public int insertCard(Card card) {return userMapper.insertCard(card);
    }

    public List<Card> findCardByName(String name) {return userMapper.findCardByname(name);
    }

    public List<Card> findCardByword(String word) {return userMapper.findCardByword(word);
    }

    public int deleteBag(Cardbag_user cardbag_user) {return  userMapper.deleteBag_card(cardbag_user)+userMapper.deleteBag_user(cardbag_user);
    }

    public List<Cardbag_user> ListBagWithoutCard(String user_name, String card_name) {return userMapper.ListBagWithoutCard(user_name,card_name);
    }

    public int insertCard2bagName(Cardbag_cardname cardbag_cardname) {return userMapper.insertCard2bagName(cardbag_cardname);
    }
}