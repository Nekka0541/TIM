package basicfunctions.stream;

import java.util.List;

public class Info {
    private int id;
    private String tmpName;
    private List<User> userList;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTmpName(){
        return this.tmpName;
    }
    public void setTmpName(String tmpName){
        this.tmpName = tmpName;
    }
    public List<User> getuserList(){
        return this.userList;
    }
    public void setUserList(List<User> userList){
        this.userList = userList;
    }

}
