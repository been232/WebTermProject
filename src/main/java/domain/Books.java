package domain;

public class Books {
    private int num;
    private String id;
    private String writer;
    private String publisher;
    private String registraion;

    public Books(){

    }

    public Books(int num, String id, String writer, String publisher, String registraion) {
        this.num = num;
        this.id = id;
        this.writer = writer;
        this.publisher = publisher;
        this.registraion = registraion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRegistraion() {
        return registraion;
    }

    public void setRegistraion(String registraion) {
        this.registraion = registraion;
    }

    @Override
    public String toString() {
        return "Books{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", registraion='" + registraion + '\'' +
                '}';
    }
}
