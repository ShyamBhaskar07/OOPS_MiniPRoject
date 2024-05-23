package Arms;

import Arms_Load.*;

import java.nio.channels.FileLock;
import java.sql.*;
import java.util.Scanner;

class Flight_Search {
        static int Flight_ID;
    public static void flight() throws SQLException, ClassNotFoundException {

            while(true) {
                System.out.println("                                                      * * * * * * * * * * * * * * * * * * *                  ");
                System.out.println("                                                      *     1.Flight Search               *     ");
                System.out.println("                                                      *     2.Book Tickets                *   ");
                System.out.println("                                                      *     3.Search Flight By Price      *    ");
                System.out.println("                                                      *     4.Cancellation                *      ");
                System.out.println("                                                      *     5.Go Back                     *     ");
                System.out.println("                                                      * * * * * * * * * * * * * * * * * * *                   ");
                System.out.println("Enter your choice from above options:-");
                Scanner sin = new Scanner(System.in);
                try {
                    int k = sin.nextInt();

                    if (k == 1) {
                        Flight_Search.search();
                    }
                    if (k == 2) {
                        Flight_Search.book();
                    }
                    if (k == 3) {
                        SearchByPrice.search();
                    }
                    if (k == 4) {
                        Refund.refund();
                    }
                    else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                    System.out.println("                                                        * Please Enter a valid Integer  *      ");
                    System.out.println("                                                        * * * * * * * * * * * * * * * * *");
                }
            }
        }
    public static void search() throws ClassNotFoundException,SQLException {

        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";
        Scanner sin = new Scanner(System.in);

        System.out.println("Enter Boarding ");
        String Boarding = sin.nextLine();
        System.out.println("Enter Destination");
        String Destination = sin.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query = "select * from flight_search where boarding = ? and destination = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,Boarding);
        st.setString(2,Destination);
        ResultSet rs = st.executeQuery();
        int m =0;
        while(rs.next()) {
            if(rs.getString("Boarding").contains(Boarding) && rs.getString("Destination").contains(Destination)) {
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                String n = "                                       " +"Flight_Id : " + rs.getInt(1) + "|" +"  Boarding : " + rs.getString(2) +"|"+ "  Destination :" + rs.getString(3) +"|"+ "  Date :" + rs.getString(4) + "|"+"  Time :" + rs.getString(5);
                System.out.println(n);
                System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");

                m = 1;
            }
        }

        st.close();
        con.close();
        if(m==1) {
            System.out.println("Do u want to book Tickets [y/n]");
            Scanner s = new Scanner(System.in);
            String k = s.next();

            if (k.matches("y")) {
                Flight_Search.book();
            }
            else {
                System.out.println("                                                              * * * * * * * * * * * * *                                     ");
                System.out.println("                                                              *    Redirecting ...    *");
                System.out.println("                                                              * * * * * * * * * * * * *                                     ");
                Flight_Search.flight();
            }
        }
        else {
            System.out.println("                                                 * * * * * * * * * * * * * * * * * * * * * * * * *                                                         ");
            System.out.println("                                                 *   Flights are not available for these places  *      ");
            System.out.println("                                                 * * * * * * * * * * * * * * * * * * * * * * * * *                                                          ");
            Flight_Search.flight();
        }
    }

    public static void book() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/arms";
        String uname = "root";
        String pass = "Shyam@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Scanner sin = new Scanner(System.in);

        try {
            System.out.println("Enter a Flight_ID");
            Flight_ID = sin.nextInt();

            if (Flight_ID <= 300) {
                String query = "select * from flight_search where Flight_ID = ? ";
                PreparedStatement st = con.prepareStatement(query);
                st.setInt(1, Flight_ID);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");
                    String p = "                                       " + "Flight_Id : " + rs.getInt(1) + "  Boarding : " + rs.getString(2) + "  Destination :" + rs.getString(3) + "  Date :" + rs.getString(4) + "  Time :" + rs.getString(5);
                    System.out.println(p);
                    System.out.println("                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                                                                                                                                                                                 ");

                }
                st.close();
                System.out.println("Do u want to proceed [y/n]");
                String k = sin.next();
                if (k.matches("y")) {
                    variant();
                }
                else {
                    System.out.println("                                                           * * * * * * * * * * * * *                                     ");
                    System.out.println("                                                           *    Redirecting ...    *");
                    System.out.println("                                                           * * * * * * * * * * * * *                                     ");
                    Flight_Search.flight();
                }
            }
            else {
                System.out.println("                                                             * * * * * * * * * * *                                  ");
                System.out.println("                                                             * Invalid Flight_ID *      ");
                System.out.println("                                                             * * * * * * * * * * *                                  ");
                Flight_Search.flight();
            }
        }
        catch(Exception e) {
            System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            System.out.println("                                                        * Please Enter a valid Integer  *      ");
            System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            Flight_Search.book();
        }
        con.close();

    }

    public static void variant() throws SQLException, ClassNotFoundException {
        System.out.println("                                                             * * * * * * * * * * *                                  ");
        System.out.println("                                                             *  1.Economy class  *                       ");
        System.out.println("                                                             *  2.Business class *                               "   );
        System.out.println("                                                             *  3.First class    *                       ");
        System.out.println("                                                             *  4.Exit           *                   ");
        System.out.println("                                                             * * * * * * * * * * *                                  ");
        System.out.println("Choose your preferable class to proceed:-");

        Scanner sin = new Scanner(System.in);
        try{
         int k = sin.nextInt();
         while(true) {
             if (k == 1) {
                 Flight_Class.Economy();
             }
             else if (k == 2) {
                 Flight_Class.Bussiness();
             }
             else if (k == 3) {
                 Flight_Class.FirstClass();
                 return;
             }

             else {
                 Flight_Search.flight();
                 break;
             }
         }
         }
        catch (Exception e) {
            System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            System.out.println("                                                        * Please Enter a valid Integer  *      ");
            System.out.println("                                                        * * * * * * * * * * * * * * * * *");
            variant();
        }
    }

}
