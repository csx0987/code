package com.shengxin.controller;

import com.shengxin.domain.Girl;
import com.shengxin.domain.Result;
import com.shengxin.repository.GirlRepository;
import com.shengxin.service.GirlService;
import com.shengxin.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by chenshengxin on 2017/3/11.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        } else {
            return ResultUtil.success(girlRepository.save(girl));
        }
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查找
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
