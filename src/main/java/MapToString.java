import java.util.Map;
import java.util.stream.Collectors;

public class MapToString {

    public static String mapToString(Map<String, String> inputMap){

        return inputMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e->e.getValue()!=null)
                .map(e->e.getKey()+'='+e.getValue())
                .collect(Collectors.joining("&"));
    }
}
