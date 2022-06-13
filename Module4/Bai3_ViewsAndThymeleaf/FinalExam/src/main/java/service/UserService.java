package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public UserService() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalexam?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException ignored) {

        }
        return connection;
    }

    public List<User> searchEmpByIdProject(int id) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user where project_id = ? and role = 'employee'");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                int password = rs.getInt("password");
                String pro_skill = rs.getString("pro_skill");
                int projectId = id;
                String role = rs.getString("role");
                users.add(new User(idUser, fullName, email, password, pro_skill, projectId, role));
            }
        } catch (SQLException ignored) {
            System.out.println(ignored);
        }
        return users;
    }

    public List<User> findAllManage() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user where role = 'manage'");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                int password = rs.getInt("password");
                int exp_in_year = rs.getInt("exp_in_year");
                int projectId = rs.getInt("project_id");
                String role = rs.getString("role");
                users.add(new User(idUser, fullName, email, password, exp_in_year, projectId, role));
            }
        } catch (SQLException ignored) {
            System.out.println(ignored);
        }
        return users;
    }

    public boolean findAccount(String email, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select email , password from user where email = ? and password = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String emailU = rs.getString("email");
                int passwordU = rs.getInt("password");
                user = new User(emailU, passwordU);
            }
        } catch (SQLException ignored) {
            System.out.println(ignored);
        }
        return user != null;
    }
}
