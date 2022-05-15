package Day6.QuickTest;

import java.security.spec.RSAOtherPrimeInfo;
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
                ){
            System.out.println(" Enter 1 de insert!\n Enter 2 de update!\n Enter 3 de delete!\n Enter 4 de Search! \n");
            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();

            switch (choice) {
                case 1: // insert
                    System.out.println("Ban da chon muc insert!");
                    Scanner inputInsert = new Scanner(System.in);
                    System.out.println("Nhap ID bai hat: ");
                    Integer insertSongID = inputInsert.nextInt();
                    inputInsert.nextLine();
                    System.out.println("Nhap ten bai hat: ");
                    String insertSong = inputInsert.nextLine();
                    System.out.println("Nhap ten tac gia: ");
                    String insertAuthor = inputInsert.nextLine();
                    System.out.println("Nhap nam phat hanh: ");
                    Integer insertReleaseYear = inputInsert.nextInt();

                    String insertStm = "insert into music(songID, songName, author, releaseYear) values (?, ?, ?, ?)";
                    PreparedStatement prpstmInsert = conn.prepareStatement(insertStm);

                    prpstmInsert.setInt(1, insertSongID);
                    prpstmInsert.setString(2, insertSong);
                    prpstmInsert.setString(3, insertAuthor);
                    prpstmInsert.setInt(4, insertReleaseYear);

                    prpstmInsert.executeUpdate();
                    break;
                case 2: // update
                    System.out.println("Ban da lua chon muc update!");
                    System.out.println("Nhap ID bai hat ban muon update: ");
                    Scanner inputUpdate = new Scanner(System.in);
                    Integer updateSongID = inputUpdate.nextInt();
                    inputUpdate.nextLine();
                    System.out.println("Nhap ID moi: ");
                    Integer newSongID = inputUpdate.nextInt();
                    inputUpdate.nextLine();
                    System.out.println("Nhap ten moi: ");
                    String newSongName = inputUpdate.nextLine();
                    System.out.println("Nhap ten tac gia moi: ");
                    String newAuthor = inputUpdate.nextLine();
                    System.out.println("Nhap nam phat hanh moi: ");
                    Integer newReleaseYear = inputUpdate.nextInt();

                    String updateStm = "update music set songID = ?, songName = ?, author = ?, releaseYear = ? where songID = ?";
                    PreparedStatement prpstmUpdate = conn.prepareStatement(updateStm);
                    prpstmUpdate.setInt(1, newSongID);
                    prpstmUpdate.setString(2, newSongName);
                    prpstmUpdate.setString(3, newAuthor);
                    prpstmUpdate.setInt(4, newReleaseYear);
                    prpstmUpdate.setInt(5, updateSongID);
                    prpstmUpdate.executeUpdate();
                    break;
                case 3: // delete theo ten bai hat
                    System.out.println("Ban da chon muc delete!");
                    Scanner inputDelete = new Scanner(System.in);
                    System.out.println("Nhap ten bai hat ban muon xoa: ");
                    String deleteSongName = inputDelete.next();

                    String deleteStm = "delete from music where songID = ?";
                    PreparedStatement prpstmDelete = conn.prepareStatement(deleteStm);
                    prpstmDelete.setString(1, deleteSongName);
                    prpstmDelete.executeUpdate();
                    break;
                case 4: // Search theo ten bai hat
                    System.out.println("Ban da lua chon muc tim kiem!");
                    Scanner inputSearch = new Scanner(System.in);
                    System.out.println("Nhap ten bai hat ban muon tim");
                    String searchSongName = inputSearch.nextLine();

                    String searchStm = "select * from music where songName = ?";
                    PreparedStatement prpstmSearch = conn.prepareStatement(searchStm);
                    prpstmSearch.setString(1, searchSongName);
                    ResultSet rset = prpstmSearch.executeQuery();
                    ResultSetMetaData rsetMD = rset.getMetaData();
                    int numColumns = rsetMD.getColumnCount();
                    for (int i = 1; i <= numColumns; ++i) {
                        System.out.printf("%-30s", rsetMD.getColumnName(i));
                    }
                    System.out.println();
                    for (int i = 1; i <= numColumns; ++i) {
                        System.out.printf("%-30s",
                                "(" + rsetMD.getColumnClassName(i) + ")");
                    }
                    System.out.println();
                    while (rset.next()) {
                        for (int i = 1; i <= numColumns; ++i) {
                            // getString() can be used for all column types
                            System.out.printf("%-30s", rset.getString(i));
                        }
                        System.out.println();
                    }
                    break;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
