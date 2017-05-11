package com.example.controller;

import com.example.domain.Girl;
import com.example.domain.Result;
import com.example.repository.GirlRepository;
import com.example.service.GirlService;
import com.example.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by cw on 2017/5/10.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girls() {

        return girlRepository.findAll();
    }


    /**
     * 添加一个女生

     * @return
     */
    @PostMapping("/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setName(girl.getName());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl getOneGirl(@PathVariable("id") Integer id) {

        return girlRepository.findOne(id);
    }

    /**
     * 更新
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);

        return girlRepository.save(girl);
    }


    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelelete(@PathVariable("id") Integer id) {

        girlRepository.delete(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
