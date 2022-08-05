package ru.sadikov.dz.magafondz.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addRole(Role role){
        this.role.setRole(role.getRole());

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
                  role+
                '}';
    }
}
