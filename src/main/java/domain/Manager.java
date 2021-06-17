package domain;

public class Manager {
    public int num;
    public String name;
    public String id;
    public String password;

    public Manager(){

    }

    public Manager(int num, String name, String id, String password) {
        this.num = num;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passward) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
