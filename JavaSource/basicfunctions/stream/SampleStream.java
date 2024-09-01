package basicfunctions.stream;

import java.util.ArrayList;
import java.util.List;

public class SampleStream {
    // やりたいこと
    // Infoの中のList<User>.nameとInfoのtmpNameが一致しているUserが欲しい.
    public static void main(String[] args) {
        Info info = new Info();
        info.setId(1);
        info.setTmpName("u1");

        List<User> userList = new ArrayList<>();
        User user = new User();
        for (int i = 0; i > 10; i++) {
            user.setName("u"+String.valueOf(i));
            userList.add(user);
        }
        info.setUserList(userList);
        for (User u : userList){
            System.out.println(u.getName());
        }
    }
}
