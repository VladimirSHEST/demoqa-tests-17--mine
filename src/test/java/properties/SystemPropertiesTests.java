package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void  systemPropertyTest(){
        String browserName = System.getProperty("browser");
        System.out.println(browserName);  //null
    }

    @Test
    void  systemPropertyTest2(){
        System.setProperty("browser","opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);  //opera
    }

    @Test
    void  systemPropertyTest3(){
        System.setProperty("browser","opera");
        String browserName = System.getProperty("browser","google");
        System.out.println(browserName);  //opera
    }

    @Test
    @Tag("one_property")
    void  systemPropertyTest4(){
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
        System.out.println(browserName);
        // gradle clean one_property_test
        //
        // gradle clean one_property_test -Dbrowser=safari
    }

}
