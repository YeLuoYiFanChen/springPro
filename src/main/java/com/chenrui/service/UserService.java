package com.chenrui.service;

import com.chenrui.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by chenr on 2017/5/12.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getAllTbUsers(){
        return jdbcTemplate.queryForList("select * from tb_user");
    }

    public Map getUserForMap(Integer id) {
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from tb_user where id=? ",id);
        return map;
    }

    public TbUser findUserById(Integer id) {
        TbUser tbUser = jdbcTemplate.queryForObject("select * from tb_user where id=" + id, new BeanPropertyRowMapper<TbUser>(TbUser.class));
        return tbUser;
    }


    public void save(TbUser user) {
        jdbcTemplate.update("insert into tb_user(username,password,sex,age) values(?,?,?,?)", user.getUsername(), user.getPassword(), user.getSex(), user.getAge());
    }

    public void delete(Integer id){
        jdbcTemplate.update("delete from tb_user where id=?",id);
    }


}
