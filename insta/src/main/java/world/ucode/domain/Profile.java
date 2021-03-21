package world.ucode.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Registration username;
    private String firstname;
    private String surname;
    private String birthDate;
    private String sex;
    private String city;
    private String photoName;
    private String workPlace;
    private String position;
    private String bio;
    @ManyToMany
    @JoinTable(
            name = "followed_streams",
            joinColumns = @JoinColumn(name = "vier_id"),
            inverseJoinColumns = @JoinColumn(name = "stream_id"))
    private List<Tag> followedTag = new ArrayList<>();

    public Profile() {}

    public Profile(Registration username, String firstname, String surname, String birthDate,
                   String sex, String city, String photoName, String workPlace,
                   String position, String bio) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.birthDate = birthDate;
        this.sex = sex;
        this.city = city;
        this.photoName = photoName;
        this.workPlace = workPlace;
        this.position = position;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public Registration getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getPhotoName() {
        return photoName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getPosition() {
        return position;
    }

    public String getBio() {
        return bio;
    }

    public void setUsername(Registration username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void followTag(Tag tag) {
        followedTag.add(tag);
    }
}
