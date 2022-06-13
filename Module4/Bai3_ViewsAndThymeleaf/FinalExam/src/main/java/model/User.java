package model;

public class User {
    private int id;
    private String fullName;
    private String email;
    private int password;
    private int exp_in_year;
    private String pro_skill;
    private int projectId;
    private String role;

    public User() {
    }

    public User(int id, String fullName, String email, int password, String pro_skill, int projectId, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.pro_skill = pro_skill;
        this.projectId = projectId;
        this.role = role;
    }

    public User(int id, String fullName, String email, int password, int exp_in_year, int projectId, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.exp_in_year = exp_in_year;
        this.projectId = projectId;
        this.role = role;
    }

    public User(String email, int password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getExp_in_year() {
        return exp_in_year;
    }

    public void setExp_in_year(int exp_in_year) {
        this.exp_in_year = exp_in_year;
    }

    public String getPro_skill() {
        return pro_skill;
    }

    public void setPro_skill(String pro_skill) {
        this.pro_skill = pro_skill;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
