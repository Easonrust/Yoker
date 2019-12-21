package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Mapper
//@Component(value="userMapper")
@Component
public interface UserMapper {


        List<User> findUserByName(String name);

        public List<User> ListUser();

        public int insertUser(User user);

        public int delete(String id);

        public int Update(User user);

        public List<Cardbag_user> findBagByName(String name);

        public List<Cardbag_user> ListBag();

        public List<Card> ListCardByBag(String user_name,String cardbag_id);

        public List<Cardbag_card> FindBagDescribe(String user_name,String cardbag_id);

        public int insertCard2bag(Cardbag_card cardbag_card);


        public int insertBag(Cardbag_user cardbag_user);

        public int insertCard(Card card);

        public List<Card> findCardByname(String name);

        public List<Card> findCardByword(String word);

        public int deleteBag_user(Cardbag_user cardbag_user);
        public int deleteBag_card(Cardbag_user cardbag_user);

        public List<Describe_name> ListBagDescribe(String user_name, String cardbag_id);
        public List<Describe_name> ListCardname(String user_name, String cardbag_id);

        public List<Cardbag_user> ListBagWithoutCard(String user_name, String card_name);

        public int insertCard2bagName(Cardbag_cardname cardbag_cardname);
}

