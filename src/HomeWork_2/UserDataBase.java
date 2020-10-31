package HomeWork_2;

import java.sql.*;

public class UserDataBase {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;

    public UserDataBase(String fileName) {
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + fileName + ".s3db");
            statement = conn.createStatement();
            statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'login' text, 'password' text);");

            statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Sergey', 'l1', 'p1');");
            statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Anna', 'l2', 'p2');");
            statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Alex', 'l3', 'p3');");
            statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Ivan', 'l4', 'p4');");
            statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Mary', 'l5', 'p5');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DialogueApp.DataItem findData(DialogueApp.Pair<String, String> pair) {
        try {
            resultSet = statement.executeQuery( "SELECT * FROM users WHERE login = " + "\"" + pair.login + "\"" + " AND password = " + "\"" + pair.password + "\"" + ";");
            if(resultSet != null) {
                if(resultSet.next()) {
                    String name = resultSet.getString("name");
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    return new DialogueApp.DataItem(name, login, password);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addData(DialogueApp.DataItem item) {
        DialogueApp.Pair<String, String> pair = new DialogueApp.Pair<>(item.login, item.password);
        if(findData(pair) == null) {
            try {
                statement.execute("INSERT INTO  'users'  ('name', 'login', 'password')  VALUES  ( '" + item.name + "' ,  '" + item.login + "' , '" + item.password + "' );");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void printData() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                System.out.println(id + " " + name + " " + login + " " + password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void changeData(DialogueApp.Pair<String, String> pair, String name) {
        if(findData(pair) != null) {
            try {
                statement.execute("UPDATE users SET name =  '" + name + "'  WHERE login = '" + pair.login + "' AND password = '" + pair.password + "' ;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
