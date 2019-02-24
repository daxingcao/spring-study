package entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author daxing.cao
 */
public class Person {

    @Value("${hello}")
    private String propertyValue;
    @Value("${password}")
    private String password;
    @Value("${mobile}")
    private String mobile;

    public Person(){
        System.out.println("我被实例化了!!!");
    }

    public void say(){
        System.out.println("我是Person类,我从配置文件拿出了->"+propertyValue);
        System.out.println("password:"+this.password+",mobile:"+this.mobile);
    }

    public void setPropertyValue(String propertyValue){
        this.propertyValue = propertyValue;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
