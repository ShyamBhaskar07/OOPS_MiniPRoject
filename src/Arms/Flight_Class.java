package Arms;

import java.sql.*;
import java.util.Scanner;

class Flight_Class extends Flight_Search{

    Flight_Search f;
    public static void Economy() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";
        Scanner sin = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query4 = "select Economy_Class from class where Flight_ID = ? ";
        PreparedStatement st4 = con.prepareStatement(query4);
        st4.setInt(1,Flight_ID);
        ResultSet rs4 = st4.executeQuery();

        while(rs4.next()) {
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                String p = "                                                                 " + "Price of Economy Class : " + rs4.getInt("Economy_Class");
                System.out.println(p);
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
        }
        st4.close();

        String query = "select * from class where Flight_ID = ? ";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,Flight_ID);
        ResultSet rs = st.executeQuery();

        System.out.println("Enter no. of tickets want to buy : ");
        int m = sin.nextInt();
        while(rs.next()) {
            if (rs.getInt("Eco_count") > m) {
                int a = m * rs.getInt("Economy_Class");
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                String n = "                                                                 " + "Total amount to be paid (Economy Class) : " + a;
                System.out.println(n);
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");

                System.out.println("Do u want to make a payment[y/n] :");
                String k = sin.next();
                if (k.matches("y")) {
                    int p = Payment.pay();
                    if (p == 1) {
                        String query1 = "update class set Eco_count = Eco_count - ? where Flight_ID = ?";
                        PreparedStatement st1 = con.prepareStatement(query1);
                        st1.setInt(1, m);
                        st1.setInt(2, Flight_ID);
                        int count = st1.executeUpdate();
                        st1.close();
                        String s = Login.username;
                        String query2 = "update login set tickets_purchased = tickets_purchased + ? where userid = ?";
                        PreparedStatement st2 = con.prepareStatement(query2);
                        st2.setInt(1, m);
                        st2.setString(2, s);
                        int count1 = st2.executeUpdate();
                        st2.close();

                        String query3 = "update login set amount_paid = amount_paid + ? where userid = ?";
                        PreparedStatement st3 = con.prepareStatement(query3);
                        st3.setInt(1, a);
                        st3.setString(2, s);
                        int count3 = st3.executeUpdate();
                        st3.close();

                        Flight_Search.flight();
                    }
                    else {
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                        System.out.println("                                                        *      Tickets not purchased    *    ");
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                    }
                }
                else {
                    Flight_Search.flight();
                }
            }
            else {
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                System.out.println("                                                        *   Tickets are not available   *   ");
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            }
        }

        st.close();
        con.close();
    }
    public static void Bussiness() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";
        Scanner sin = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query4 = "select * from class where Flight_ID = ? ";
        PreparedStatement st4 = con.prepareStatement(query4);
        st4.setInt(1,Flight_ID);
        ResultSet rs4 = st4.executeQuery();

        st4.close();
        while(rs4.next()) {
            System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
            String p = "                                                                 "+"Price of Business Class : " + rs4.getInt("Bussiness_Class");
            System.out.println(p);
            System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
        }


        String query = "select * from class where Flight_ID = ? ";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,Flight_ID);
        ResultSet rs = st.executeQuery();

        System.out.println("Enter no. of tickets want to buy : ");
        int m = sin.nextInt();
        while(rs.next()) {
            if(rs.getInt("Buss_count")>m) {
                int a = m * rs.getInt("Bussiness_Class");
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                String n = "                                                                 "+"Total amount to be paid (Business Class) : " + a;
                System.out.println(n);
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                System.out.println("Do u want to make a payment[y/n] :");
                String k = sin.next();
                if(k.matches("y")) {
                    int p = Payment.pay();
                    if(p==1) {
                        String query1 = "update class set Buss_count = Buss_count - ? where Flight_ID = ?";
                        PreparedStatement st1 = con.prepareStatement(query1);
                        st1.setInt(1, m);
                        st1.setInt(2, Flight_ID);
                        int count = st1.executeUpdate();
                        st1.close();
                        String s = Login.username;
                        String query2 = "update login set tickets_purchased = tickets_purchased + ? where userid = ?";
                        PreparedStatement st2 = con.prepareStatement(query2);
                        st2.setInt(1, m);
                        st2.setString(2, s);
                        int count1 = st2.executeUpdate();
                        st2.close();

                        String query3 = "update login set amount_paid = amount_paid + ? where userid = ?";
                        PreparedStatement st3 = con.prepareStatement(query3);
                        st3.setInt(1, a);
                        st3.setString(2, s);
                        int count3 = st3.executeUpdate();
                        st3.close();

                        Flight_Search.flight();
                    }
                    else {
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                        System.out.println("                                                        *      Tickets not purchased    *    ");
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                    }
                }
                else
                    return;
            }
            else {
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                System.out.println("                                                        *   Tickets are not available   *   ");
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            }
        }

        st.close();
        con.close();
    }

    public static void FirstClass() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";
        Scanner sin = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        String query4 = "select * from class where Flight_ID = ? ";
        PreparedStatement st4 = con.prepareStatement(query4);
        st4.setInt(1,Flight_ID);
        ResultSet rs4 = st4.executeQuery();

        while(rs4.next()) {
            System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
            String p = "                                                                 "+"Price of First Class : " + rs4.getInt("First_Class");
            System.out.println(p);
            System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
        }

        st4.close();
        String query = "select * from class where Flight_ID = ? ";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,Flight_ID);
        ResultSet rs = st.executeQuery();

        System.out.println("Enter no. of tickets want to buy : ");
        int m = sin.nextInt();
        while(rs.next()) {
            if(rs.getInt("First_count")>m) {
                int a = m * rs.getInt("First_Class");
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                String n = "                                                                 "+"Total amount to be paid (First Class) : " + a;
                System.out.println(n);
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                System.out.println("Do u want to make a payment[y/n] :");
                String k = sin.next();
                if(k.matches("y")) {
                    int p = Payment.pay();
                    if(p==1) {
                        String query1 = "update class set First_count = First_count - ? where Flight_ID = ?";
                        PreparedStatement st1 = con.prepareStatement(query1);
                        st1.setInt(1, m);
                        st1.setInt(2, Flight_ID);
                        int count = st1.executeUpdate();
                        st1.close();
                        String s = Login.username;
                        String query2 = "update login set tickets_purchased = tickets_purchased + ? where userid = ?";
                        PreparedStatement st2 = con.prepareStatement(query2);
                        st2.setInt(1, m);
                        st2.setString(2, s);
                        int count1 = st2.executeUpdate();
                        st2.close();

                        String query3 = "update login set amount_paid = amount_paid + ? where userid = ?";
                        PreparedStatement st3 = con.prepareStatement(query3);
                        st3.setInt(1, a);
                        st3.setString(2, s);
                        int count3 = st3.executeUpdate();
                        st3.close();

                        Flight_Search.flight();
                    }
                    else {
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                        System.out.println("                                                        *      Tickets not purchased    *    ");
                        System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                    }
                }
            }
            else {
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                System.out.println("                                                        *   Tickets are not available   *   ");
                System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            }
        }

        st.close();
        con.close();

    }
}
