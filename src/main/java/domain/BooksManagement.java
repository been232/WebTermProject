package domain;

public class BooksManagement {
    public String id;
    public String place;
    public int cnt;

    public BooksManagement(){

    }

    public BooksManagement(String id, String place, int cnt) {
        this.id = id;
        this.place = place;
        this.cnt = cnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "BooksManagement{" +
                "id='" + id + '\'' +
                ", place='" + place + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
