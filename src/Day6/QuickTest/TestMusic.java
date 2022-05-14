package Day6.QuickTest;

import java.sql.*;
import java.util.Scanner;

/*
    @author: Dinh Quang Anh
    Date   : 5/14/2022
    Project: Java2
*/
public class TestMusic {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "");
                Statement stmt = conn.createStatement();
                ){
            // Insert dữ liệu
            Integer songID;
            String songName;
            String author;
            Integer releaseYear;
            System.out.println("Enter 1 to insert!\n Enter 2 to update! \n Enter 3 to dalete! \n Enter 4 to search!");
            Scanner inp = new Scanner(System.in);
            int choice = inp.nextInt();
            switch (choice) {
                case 1 : // insert du lieu
                    System.out.println("ban da chon insert du lieu!");
                    Scanner inInsert = new Scanner(System.in);
                    System.out.println("Nhap songID: ");
                    songID = inInsert.nextInt();
                    inInsert.nextLine();
                    System.out.println("Nhap songName: ");
                    songName = inInsert.next();
                    inInsert.nextLine();
                    System.out.println("Nhap author name: ");
                    author = inInsert.next();
                    inInsert.nextLine();
                    System.out.println("Nhap release year: ");
                    releaseYear = inInsert.nextInt();
                    String stmInsert = "insert into music values " + "(" + songID + "," + songName + "," + author + "," + releaseYear + ")";
                    int countInsert = stmt.executeUpdate(stmInsert);
                    System.out.println(countInsert + " records inserted.");
                    break;
                case 2: // update du lieu
                    System.out.println("Ban da chon update du lieu!");
                    Scanner inUpdate = new Scanner(System.in);
                    System.out.println("Nhap ID bai hat ban muon update: ");
                    int oldSongID = inUpdate.nextInt();
                    inUpdate.nextLine();
                    System.out.println("Nhap songID moi: ");
                    songID = inUpdate.nextInt();
                    inUpdate.nextLine();
                    System.out.println("Nhap songName moi: ");
                    songName = inUpdate.next();
                    System.out.println("Nhap author name moi: ");
                    author = inUpdate.next();
                    System.out.println("Nhap release year moi: ");
                    releaseYear = inUpdate.nextInt();
                    String stmUpdate = "update music set" + "songID = " + songID + "," + "songName = " + songName + "," +
                            "author = " + author + "," + "releaseYear = " + releaseYear + " where songID = "  + oldSongID;
                    int countUpdate = stmt.executeUpdate(stmUpdate);
                    System.out.println(countUpdate + "records updated");
                    break;
                case 3: // delete
                    System.out.println("Ban da chon xoa du lieu!");
                    Scanner inDelete = new Scanner(System.in);
                    System.out.println("Nhap ID bai hat ban muon xoa: ");
                    int deleteSongID = inDelete.nextInt();
                    inDelete.nextLine();
                    String stmDelete = "detele from music where songID = " + deleteSongID;
                    int countDelete = stmt.executeUpdate(stmDelete);
                    System.out.println(countDelete + "records deleted");
                    break;
                case 4: // search theo songName
                    System.out.println("Ban da chon search bai hat!");
                    Scanner inSearch = new Scanner(System.in);
                    System.out.println("Nhap ten bai hat ban muon tim: ");
                    String searchName = inSearch.next();
                    String stmSearch = "Select * from music where songName = " + searchName;
                    ResultSet rset = stmt.executeQuery(stmSearch);
                    System.out.println("The result are: \n");
                    int rowCount = 0;
                    while(rset.next()) {
                        int searchSongID = rset.getInt("songID");
                        String searchSongName = rset.getString("songName");
                        String searchAuthor = rset.getString("author");
                        int    searchReleaseYear   = rset.getInt("releaseYear");
                        System.out.println(searchSongID + ", " + searchSongName + ", " + searchAuthor + "," + searchReleaseYear);
                        ++rowCount;
                    }
                    System.out.println("Total number of records = " + rowCount);
                    break;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
