package domain.model;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private int userid;
    private String email;
    private String password;
    private String firstname;
    private String lastName;
    private Team team;
    private Role role;


    public User(int id , String email, String password, String firstName, String lastName, String role, String team) {
        this(email, password, firstName, lastName, role, team);
        setUserid(id);
    }


    public User(){
    }



    public User(String email, String password, String firstName, String lastName, String role, String team) {
        setEmail(email);
        setPassword(password);
        setFirstname(firstName);
        setLastName(lastName);
        setRole(role);
        setTeam(team);
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCorrectPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        return getPassword().equals(password);
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("No password given");
        }
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname == null || firstname.isEmpty()) {
            throw new IllegalArgumentException("No firstname given");
        }
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("No last name given");
        }
        this.lastName = lastName;
    }

    public String getTeam() {
        String t = this.team.getStringValue();
        return t.substring(0,1).toUpperCase() + t.substring(1).toLowerCase();
    }


    public void setTeam(String team){
        try {
            this.team = Team.valueOf(team.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("There is no team with value " + team);
        }
    }

    public String getRole() {
        String r = this.role.getStringValue();
        return r.substring(0,1).toUpperCase() + r.substring(1).toLowerCase();
    }




    public void setRole(String role){
        try {
            this.role = Role.valueOf(role.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("There is no role with value " + role);
        }
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastName() + ": " + getUserid() + ", " + getEmail() + ", " + getRole() + ", " + getTeam();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


    public void update(User user){
        setFirstname(user.getFirstname());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setTeam(user.getTeam());
    }
}
