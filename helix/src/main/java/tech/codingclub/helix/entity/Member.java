package tech.codingclub.helix.entity;

/**
 * Created by hackme on 2/7/18.
 */
public class Member extends MemberBase {

    public boolean isIs_followed() {
        return is_followed;
    }

    public boolean is_followed;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getToken() {
        return token;
    }

    public Boolean getIs_verified() {
        return is_verified;
    }
    public Long getId() {
        return id;
    }
    public String name;
    public String email;
    public String role;
    public String password;
    public String image;
    public String token;
    public Boolean is_verified;

    public Member(){

    }

}
