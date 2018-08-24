package com.interview.kone.equipment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.interview.kone.equipment.api.EqipmentController;


@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {

	@InjectMocks
    private EqipmentController controllerUT = new EqipmentController();

    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

}
