package world.ucode.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Заполните поле имя")
    private String firstname;
    @NotBlank(message = "Заполните поле фамилия")
    private String surname;
    @NotBlank(message = "Заполните поле дата рождения")
    private String birthDate;
    private String sex;
    @NotBlank(message = "Заполните поле город проживания")
    private String city;
    private String photoName;
    @NotBlank(message = "Заполните поле место работы")
    private String workPlace;
    @NotBlank(message = "Заполните поле занимаемая должность")
    private String position;
    @NotBlank(message = "Заполните поле опишите себя")
    private String bio;
    @ManyToMany
    @JoinTable(name = "followed_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
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
