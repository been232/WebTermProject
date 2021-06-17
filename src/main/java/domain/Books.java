package domain;

import java.time.LocalDateTime;

public class Books {
    private int num;
    private String id;
    private String name;
    private String writer;
    private String publisher;
    private LocalDateTime registration;

    public Books(){

    }

    public Books(int num, String id, String name, String writer, String publisher, LocalDateTime registraion) {
        this.num = num;
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.publisher = publisher;
        this.registration = registraion;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getRegistraion() {
        return registration;
    }

    public void setRegistraion(LocalDateTime registraion) {
        this.registration = registraion;
    }

    @Override
    public String toString() {
        return "Books{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", registraion='" + registration + '\'' +
                '}';
    }
}
