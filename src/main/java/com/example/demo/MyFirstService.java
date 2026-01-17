package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {
    private MySpringClass mySpringClass;

    @Value("${prop}")
    private String propertyFromFile;


    public MyFirstService(MySpringClass mySpringClass) {
        this.mySpringClass = mySpringClass;
    }

    public String serve() {
        return "Service is serving: " + mySpringClass.sayHiToSpring();
    }

    @Autowired
    public String getFileFromProp() {
        return propertyFromFile;
    }

}
