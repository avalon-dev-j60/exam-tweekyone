package ru.avalon.java.blog.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.avalon.java.blog.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-10T20:39:30")
@StaticMetamodel(Publication.class)
public class Publication_ { 

    public static volatile SingularAttribute<Publication, User> author;
    public static volatile SingularAttribute<Publication, Date> created;
    public static volatile SingularAttribute<Publication, Long> id;
    public static volatile SingularAttribute<Publication, String> title;
    public static volatile SingularAttribute<Publication, String> content;

}