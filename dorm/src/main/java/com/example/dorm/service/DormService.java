package com.example.dorm.service;

import com.example.dorm.dao.DormDao;
import com.example.dorm.entity.Dorm;
import com.example.dorm.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/19 16:28
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class DormService {
    @Autowired
    DormDao dormDao;

    public Msg getDorms(HttpServletRequest request,HttpServletResponse response){
        String phoneNumber = new String();
        Msg msg = new Msg();
        List<Dorm> dormList;
        Map<String,Object> data = new HashMap<>();

        //获取客户端cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie item:cookies){
                if ("phoneNumber".equals(item.getName())){
                    phoneNumber = item.getValue();
                    break;
                }
            }
        }
        //如果未获取到登录的phoneNumber，重定向到“/login”
        if (phoneNumber.isEmpty()){
               try {
                   response.sendRedirect("/login");
               }catch (Exception e){
                   e.printStackTrace();
               }
        }

        try {
            dormList = dormDao.getDorms();
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(500);
            msg.setMsg("服务器错误");
            return msg;
        }

        data.put("dormList",dormList);
        msg.setData(data);
        msg.setStatus(200);
        msg.setMsg("宿舍数量为："+dormList.size());
        return msg;
    }

}
