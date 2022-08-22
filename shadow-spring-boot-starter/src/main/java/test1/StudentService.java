package test1;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    private HelloProperties properties;

    public void testStudent(){
        String suffix = properties.getPrefix() + "+" + properties.getSuffix();
        System.out.println(suffix);
    }
}
