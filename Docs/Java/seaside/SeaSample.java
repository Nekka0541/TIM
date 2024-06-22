import java.util.ArrayList;
import java.util.List;

public class SeaSample<T> {

    private static final String first = "first";
    private static final String second = "second";

    public void refTest(Object obj) {
        Class clazz = obj.getClass();
        System.out.println(clazz.getName());
    }

    private static <T> List<T> getLIst(Class<T> clazz){
        List<T> result = new ArrayList<T>();
        return result;
    }

    // public List<T> listTest(String code) {
    //     if (first.equals(code)) {
    //         list = (List<T>) new List<EntityFirst>();
    //     }
    //     return null;
    // }

}
