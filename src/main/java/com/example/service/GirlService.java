package com.example.service;

import com.example.domain.Girl;
import com.example.enums.ResultEnums;
import com.example.exception.GirlException;
import com.example.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cw on 2017/5/10.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        Girl girlB = new Girl();

        girlA.setName("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        girlB.setName("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if(age < 10) {
            throw new GirlException(ResultEnums.AGE_LOWER_TEN);

        }else if (age > 10 && age < 20) {
            throw new GirlException(ResultEnums.TEN_AND_TWENT);

        }
    }
}
