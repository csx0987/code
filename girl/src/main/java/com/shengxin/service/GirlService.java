package com.shengxin.service;

import com.shengxin.domain.Girl;
import com.shengxin.enums.ResultEnum;
import com.shengxin.exception.GirlException;
import com.shengxin.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenshengxin on 2017/3/11.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(12);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("D");
        girlB.setAge(13);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <= 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
