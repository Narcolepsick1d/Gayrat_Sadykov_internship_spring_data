package ru.sadikov.dz.magafondz.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Роль не должно быть пустым")
    @Size(min = 2, max = 100, message = "Роль должно быть от 2 до 100 символов длиной")
    @Column(name = "email")
    private String email;
    @NotEmpty(message = "Имя должности не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должности должно быть от 2 до 100 символов длиной")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Имя должности не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должности должно быть от 2 до 100 символов длиной")
    @Column(name = "surname")
    private String surname;
    @Min(value = 0,message = "Возраст должен быть больше 0")
    @Column(name = "age")
    private int age;

    @Column(name = "isactive")
    private boolean isActive;
    @Column(name = "password")
    private String password;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns=@JoinColumn(name = "user_id"),
    inverseJoinColumns=@JoinColumn(name = "role_id"))
    private Set<Role> ownerRole = new HashSet<>() ;

    public Set<Role> getOwnerRole() {
        return ownerRole;
    }
    public void addRole(Role role){
        this.ownerRole.add(role);

    }
    public void setOwnerRole(Set<Role> ownerRole) {
        this.ownerRole = ownerRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Users() {
    }

    public Users( String name,String surname, int age, String email,String password,boolean isActive) {
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.password = password;
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", password='" + password + '\'' +
                ", ownerRole=" + ownerRole +
                '}';
    }
}
