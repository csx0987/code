package com.shengxin.repository;

import com.shengxin.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenshengxin on 2017/3/11.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
