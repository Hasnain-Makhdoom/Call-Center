package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.user;

import at.ac.tuwien.sepm.groupphase.backend.datatype.UserType;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CalendarDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.EmailDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.RoleDto;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.TimeSheetDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.CalendarEntity;
import at.ac.tuwien.sepm.groupphase.backend.entity.EmailsEntity;
import at.ac.tuwien.sepm.groupphase.backend.entity.RoleEntity;
import at.ac.tuwien.sepm.groupphase.backend.entity.TimeSheetEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;


import java.io.File;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel(value = "UserDTO", description = "A DTO for user entries via rest")
public class UserDTO {

	  private Long id;


	    private String firstName;


	    private String lastNname;


	    private LocalDateTime birthday;


	    private String street;


	    private String location;


	    private String country;


	    private String username;


	    private Integer Zip;


	    private String houseNo;


	    private String phneNo;


	    private String[] pdfs;


	    private String profilephoto;



	    private Boolean online_status;


	    private Time counter;


	    private String password;


	    private UserType type;


	    private LocalDateTime userSince;

	    private LocalDateTime lastLogin;

	    private List<EmailsEntity> emails;

	    private List<CalendarEntity> appointments;

	    private RoleEntity role;

	    private List<TimeSheetEntity> sheets;

    public static UserDTOBuilder builder() {
        return new UserDTOBuilder();
    }


    public static final class UserDTOBuilder {

        private Long id;
        private String username;
        private String password;
        private UserType type;
        private LocalDateTime userSince;
        private LocalDateTime lastLogin;

        public UserDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder type(UserType type) {
            this.type = type;
            return this;
        }

        public UserDTOBuilder userSince(LocalDateTime userSince) {
            this.userSince = userSince;
            return this;
        }

        public UserDTOBuilder lastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(id);
            userDTO.setUsername(username);
            userDTO.setPassword(password);
            userDTO.setType(type);
            userDTO.setUserSince(userSince);
            userDTO.setLastLogin(lastLogin);
           // userDTO.setReadNews(readNews);
            return userDTO;
        }
    }

}
