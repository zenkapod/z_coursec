package fin.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "user_table", uniqueConstraints =
       @UniqueConstraint(columnNames = "userName"))
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "user_name")
   private String userName;

   @Column(name = "full_name")
   private String fullName;

   private String city;
   @Column(name = "phone_Number")
   private String phoneNumber;
   private String password;

   @ManyToMany(fetch = FetchType.EAGER, 
                   cascade = CascadeType.ALL)
   @JoinTable(name = "users_roles", 
       joinColumns = @JoinColumn(name = "user_id", 
         referencedColumnName = "id"), 
           inverseJoinColumns = @JoinColumn
              (name = "role_id", 
                 referencedColumnName = "id"))
   private Collection<Role> roles;

   public User() {
   }

   public User(String userName, String fullName,
          String city, String phoneNumber, String password,
                   Collection<Role> roles) {

      this.userName = userName;
      this.fullName = fullName;
      this.city = city;
      this.phoneNumber = phoneNumber;
      this.password = password;
      this.roles = roles;
   }
}