
package ru.avalon.java.blog.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(
            name = "list-publications",
            query = "SELECT p FROM Publication AS p"),
    @NamedQuery(
            name = "find-publication-by-id",
            query = "SELECT item FROM Publication AS item WHERE item.id = :id"),
    @NamedQuery(
            name = "find-publications-by-user",
            query = "SELECT p FROM Publication AS p WHERE p.author = :user"
    )
})
@Entity
public class Publication implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false) // no ManyToOne
    private String title;
    
    @Column(columnDefinition = "long varchar") //что бы было больше 255 символов
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false) //because ManyToOne
    private User author;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    protected Publication() {}

    public Publication(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
        created = new Date();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreated() {
        return created;
    }    
    
}
