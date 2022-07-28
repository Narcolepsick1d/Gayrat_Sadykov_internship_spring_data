package ru.sadikov.dz.magafondz.models;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Роль не должно быть пустым")
    @Size(min = 2, max = 100, message = "Роль должно быть от 2 до 100 символов длиной")
    @Column(name = "role")
    private String role;
    @NotEmpty(message = "Имя должности не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должности должно быть от 2 до 100 символов длиной")
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "ownerRole")
    private List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(String role, String name) {
        this.role = role;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
