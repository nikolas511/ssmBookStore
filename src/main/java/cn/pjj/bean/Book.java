package cn.pjj.bean;

/**
 * Created by Administrator on 2017/6/10.
 */
public class Book {
    private String id;
    private String bookname;
    private String price;
    private String author;
    private String image;
    private String description;
    private Category category;//书本所属分类

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;

    }
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
