//package world.ucode.domain;
//
//import org.omg.CORBA.PUBLIC_MEMBER;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "tag")
//public class Tag {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String tagName;
//    @ManyToMany (fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private Registration username;
//
//    public Tag() {}
//
//    public Tag(String tagName, Registration username) {
//        this.tagName = tagName;
//        this.username = username;
//    }
//
//    public String getTagName() {
//        return tagName;
//    }
//
//    public void setTagName(String tagName) {
//        this.tagName = tagName;
//    }
//
//    public Registration getUsername() {
//        return username;
//    }
//
//    public void setUsername(Registration username) {
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
