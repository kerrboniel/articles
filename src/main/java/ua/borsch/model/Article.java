package ua.borsch.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable, Comparable<Article> {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column(length = 10000000)
    @Lob
    private String content;

    @Column
    private long creationTimestamp;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.creationTimestamp = System.currentTimeMillis();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int compareTo(Article that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }
}
