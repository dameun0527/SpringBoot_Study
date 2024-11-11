package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    // 범용적으로 사용되는 Bean -> @Primary
    // 지엽적으로 사용되는 Bean -> @Qualifier
    @Autowired // 1차 Food(bean) 타입 > 2차 Bean 이름
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("Primary와 Qualifier 우선순위 확인")
    void test1() {
        food.eat();

    }

}
