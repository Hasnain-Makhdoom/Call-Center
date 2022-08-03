package at.ac.tuwien.sepm.groupphase.backend.entity;

import at.ac.tuwien.sepm.groupphase.backend.datatype.UserType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = true, unique = true)
    @Size(max = 255)
    private String firstName;

    @Column(nullable = true, unique = true)
    @Size(max = 255)
    private String lastName;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(nullable = true)
    @Size(max = 255)
    private String street;

    @Column(nullable = true)
    @Size(max = 255)
    private String location;


    @Column(nullable = true)
    @Size(max = 255)
    private String country;

    @Column(nullable = false)
    private String username;


    @Column(nullable = true)
    private Integer Zip;


    @Column(nullable = true)
    @Size(max = 255)
    private String houseNo;

    @Column(nullable = true)
    private String phoneNo;

    @Column(nullable = true)
    private String[] pdfs;

    @Column(nullable = true)
    private String profilephoto;


    @Column(nullable = true)
    private Boolean online_status;

    @Column(nullable = true)
    private Time counter;

    @Column(nullable = false)
    @Size(max = 255)
    private String password;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(nullable = true, name = "user_since")
    private LocalDateTime userSince;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToOne(mappedBy =  "user",cascade = { CascadeType.ALL}, orphanRemoval = true, optional = false)
    private LoginAttempts loginAttempts;

     @OneToMany(mappedBy = "user",cascade = { CascadeType.ALL})
	 @JsonManagedReference
	 private List<EmailsEntity> emails;


     @OneToMany(mappedBy = "user",cascade = { CascadeType.ALL})
	 @JsonManagedReference
	 private List<CalendarEntity> appointments;



     @OneToMany(mappedBy = "user",cascade = { CascadeType.ALL})
	 @JsonManagedReference
	 private List<TimeSheetEntity> sheets;


     @ManyToOne
	  @JoinColumn(name = "role_id")
	  @JsonBackReference
	  private RoleEntity role;

      public User() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public LocalDateTime getUserSince() {
        return userSince;
    }

    public void setUserSince(LocalDateTime userSince) {
        this.userSince = userSince;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LoginAttempts getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(LoginAttempts loginAttempts) {
        this.loginAttempts = loginAttempts;
    }


/*
    public static final class UserBuilder {

        private Long id;
        private String username;
        private String password;
        private UserType type;
        private LocalDateTime userSince;
        private LocalDateTime lastLogin;
        private List<News> readNews;
        private LoginAttempts loginAttempts;

        private UserBuilder() {
            this.readNews = new ArrayList<News>();
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder type(UserType type) {
            this.type = type;
            return this;
        }

        public UserBuilder userSince(LocalDateTime userSince) {
            this.userSince = userSince;
            return this;
        }

        public UserBuilder lastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public UserBuilder readNews(List<News> readNews) {
            this.readNews = readNews;
            return this;
        }
        public UserBuilder loginAttempts(LoginAttempts loginAttempts){
            this.loginAttempts = loginAttempts;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setType(type);
            user.setUserSince(userSince);
            user.setLastLogin(lastLogin);
            user.setReadNews(readNews);
            user.setLoginAttempts(loginAttempts);
            return user;
        }
    }
 */
}