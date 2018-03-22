import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapToStringTest {

    @Test
    public void mapToStringTest(){
        Map<String, String> map = Collections.unmodifiableMap(new HashMap<String, String>(){
            {
                put("param1", "value1");
                put("param2", "value2");
                put("param3", "value3");
                put("param4", "value4");
            }
        });

        String expected = "param1=value1&param2=value2&param3=value3&param4=value4";

        assertEquals(expected, MapToString.mapToString(map));
    }
}
