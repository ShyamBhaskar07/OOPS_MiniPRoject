package Arms_Load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class LoadCSV {

    public static void load_Login() throws SQLException, ClassNotFoundException, IOException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table login";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists login(userid varchar(20) , password varchar(20) , tickets_purchased int , amount_paid int)";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();
        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\login.csv";
        int batch = 20;
            String query3 = "insert into login (userid,password,tickets_purchased,amount_paid) values (?,?,?,?)";
            PreparedStatement st2 = con.prepareStatement(query3);

            BufferedReader line = new BufferedReader(new FileReader(filepath));
            String lineText = null;

            int count =0;

            line.readLine();
            while((lineText=line.readLine())!=null) {
                String [] data = lineText.split(",");

                String userid = data[0];
                String password = data[1];
                String tickets = data[2];
                String amount = data[3];

                st2.setString(1,userid);
                st2.setString(2,password);
                st2.setInt(3,parseInt(tickets));
                st2.setInt(4,parseInt(amount));

                st2.addBatch();

                if(count%batch==0) {
                    st2.executeBatch();
                }
            }
            line.close();
            st2.executeBatch();
            con.commit();
            st2.close();
            con.close();
    }

    public static void load_Flight_Search() throws SQLException, IOException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table flight_search";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists flight_search(Flight_ID int,Boarding varchar(30),Destination varchar(30),Date varchar(30),Time varchar(30));";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();

        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\flight_search.csv";
        int batch = 20;
        String query3 = "insert into flight_search (Flight_ID,Boarding,Destination,Date,Time) values (?,?,?,?,?)";
        PreparedStatement st2 = con.prepareStatement(query3);

        BufferedReader line = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        int count =0;

        line.readLine();
        while((lineText=line.readLine())!=null) {
            String [] data = lineText.split(",");

            int Flight_ID = Integer.parseInt(data[0]);
            String Boarding = data[1];
            String Destination = data[2];
            String Date = data[3];
            String Time = data[4];

            st2.setInt(1,Flight_ID);
            st2.setString(2,Boarding);
            st2.setString(3,Destination);
            st2.setString(4,Date);
            st2.setString(5,Time);

            st2.addBatch();

            if(count%batch==0) {
                st2.executeBatch();
            }
        }
        line.close();
        st2.executeBatch();
        con.commit();
        st2.close();
        con.close();
    }

    public static void load_class() throws SQLException, IOException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table class";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists class(Flight_ID int ,Economy_Class int , Bussiness_Class int ,First_Class int ,Eco_count int,Buss_count int,First_count int);";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();

        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\class.csv";
        int batch = 20;
        String query3 = "insert into class (Flight_ID,Economy_Class,Bussiness_Class,First_Class,Eco_count,Buss_count,First_count) values (?,?,?,?,?,?,?)";
        PreparedStatement st2 = con.prepareStatement(query3);

        BufferedReader line = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        int count =0;

        line.readLine();
        while((lineText=line.readLine())!=null) {
            String [] data = lineText.split(",");

            String Flight_ID = data[0];
            String Economy_Class = data[1];
            String Bussiness_Class = data[2];
            String First_Class = data[3];
            String Eco_count = data[4];
            String Buss_count = data[5];
            String First_count = data[6];

            st2.setInt(1,parseInt(Flight_ID));
            st2.setInt(2,parseInt(Economy_Class));
            st2.setInt(3,parseInt(Bussiness_Class));
            st2.setInt(4,parseInt(First_Class));
            st2.setInt(5,parseInt(Eco_count));
            st2.setInt(6,parseInt(Buss_count));
            st2.setInt(7,parseInt(First_count));

            st2.addBatch();

            if(count%batch==0) {
                st2.executeBatch();
            }
        }
        line.close();
        st2.executeBatch();
        con.commit();
        st2.close();
        con.close();
    }
    public static void load_debit() throws SQLException, ClassNotFoundException, IOException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table debit";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists debit(account_no int , password varchar(20));";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();

        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\debit.csv";
        int batch = 20;
        String query3 = "insert into debit (account_no,password) values (?,?)";
        PreparedStatement st2 = con.prepareStatement(query3);

        BufferedReader line = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        int count =0;

        line.readLine();
        while((lineText=line.readLine())!=null) {
            String [] data = lineText.split(",");

            String account_no = data[0];
            String password = data[1];

            st2.setInt(1,parseInt(account_no));
            st2.setString(2,password);

            st2.addBatch();

            if(count%batch==0) {
                st2.executeBatch();
            }
        }
        line.close();
        st2.executeBatch();
        con.commit();
        st2.close();
        con.close();
    }

    public static void load_credit() throws IOException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table credit";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists credit(account_no int , password varchar(20));";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();

        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\credit.csv";
        int batch = 20;
        String query3 = "insert into credit (account_no,password) values (?,?)";
        PreparedStatement st2 = con.prepareStatement(query3);

        BufferedReader line = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        int count =0;

        line.readLine();
        while((lineText=line.readLine())!=null) {
            String [] data = lineText.split(",");

            String account_no = data[0];
            String password = data[1];

            st2.setInt(1,parseInt(account_no));
            st2.setString(2,password);

            st2.addBatch();

            if(count%batch==0) {
                st2.executeBatch();
            }
        }
        line.close();
        st2.executeBatch();
        con.commit();
        st2.close();
        con.close();

    }

    public static void load_upi() throws SQLException, IOException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        con.setAutoCommit(false);

//        String query5 = "drop table upi";
//        PreparedStatement st5 = con.prepareStatement(query5);
//        st5.executeUpdate();
//        st5.close();

        String query1 = "create table if not exists upi(upi_id varchar(20),upi_pin int);";
        PreparedStatement st1 = con.prepareStatement(query1);
        st1.executeUpdate();
        st1.close();

        String filepath = "C:\\Users\\DELL\\IdeaProjects\\ARMS\\src\\Arms_Load\\upi.csv";
        int batch = 20;
        String query3 = "insert into upi(upi_id,upi_pin) values (?,?)";
        PreparedStatement st2 = con.prepareStatement(query3);

        BufferedReader line = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        int count =0;

        line.readLine();
        while((lineText=line.readLine())!=null) {
            String [] data = lineText.split(",");

            String upi_id = data[0];
            String upi_pin = data[1];

            st2.setString(1,upi_id);
            st2.setInt(2,parseInt(upi_pin));

            st2.addBatch();

            if(count%batch==0) {
                st2.executeBatch();
            }
        }
        line.close();
        st2.executeBatch();
        con.commit();
        st2.close();
        con.close();
    }

    public static void load() throws SQLException, IOException, ClassNotFoundException {
        LoadCSV.load_Login();
        //LoadCSV.load_Flight_Search();
        LoadCSV.load_class();
        LoadCSV.load_debit();
        LoadCSV.load_credit();
        LoadCSV.load_upi();
    }
}
