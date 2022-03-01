/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.crud_assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Payal
 */
@RestController
public class crud_controller {
    @Autowired
    student_repo s;
    @RequestMapping(value="/create",method=POST)
    public String create(student ob){
        s.save(ob);
        int id=ob.id;
        return "{\"Your id is \":"+id+"}";
    }
    @RequestMapping(value="/get",method=GET)
    public String get(int id){
        student a=s.findById(id).get();
        return ""+a.toString();
    }
    @RequestMapping(value="/update",method=PUT)
    public String update(int id,String name){
        s.setStudentName(id, name);
        return "updated name :"+s.findById(id).get().name;
    }
    @RequestMapping(value="/delete",method=DELETE)
    public String delete(int id){
        s.deleteById(id);
        return "deleted";
    }
    @RequestMapping(value="/getall",method=GET)
    public String getall(){
        
        List<student> a=new ArrayList();
        Iterator ob=s.findAll().iterator();
        while(ob.hasNext()){
            a.add((student)ob.next());
        }
        JSONObject st=new JSONObject();
        st.put("All Students", a.toString());
        System.out.println(st.toString());
        return st.toString();
    }
}
