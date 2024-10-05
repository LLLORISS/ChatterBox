package Users;

public class User {
    private String username;
    private String id;
    private String pathPic;

    public User(String username,String id,String pathPic){
        this.username = username;
        this.id = id;
        this.pathPic = pathPic;
    }

    public String getUsername(){
        return this.username;
    }
}
