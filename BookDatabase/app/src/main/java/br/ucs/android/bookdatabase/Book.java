package br.ucs.android.bookdatabase;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    public Book() { }
    public Book(String title, String author, int ano) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitulo(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAutor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setAno(int year) {
        this.year = year;
    }
}
