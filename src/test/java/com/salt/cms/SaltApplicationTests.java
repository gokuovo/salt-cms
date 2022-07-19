package com.salt.cms;

import com.salt.cms.module.file.FileProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class SaltApplicationTests {

    @Autowired
    private FileProperties fileProperties;

    @Test
    public void contextLoads() {
        System.out.println();
    }

}
