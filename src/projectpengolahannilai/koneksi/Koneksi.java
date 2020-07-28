/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpengolahannilai.koneksi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author msi
 */
public class Koneksi {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public String query;
    public int count;
    public PreparedStatement ps;

    private String port, ip, db, user, pass;

    public void setDB(String _ip,String _port,String _db,String _user,String _pass) {
        ip = _ip;
        port = _port;
        db = _db;
        user = _user;
        pass = _pass;
    }

    public void konek() {
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db+"", user, pass);
            st = (Statement) con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e, "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ambil(){
        try {
            konek();
            rs=st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("error di method ambil "+e);
        }
    }

    public void crud(){
        try {
            konek();
            count = st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Ada error di crud "+e);
        }
    }

    public void crudstatement() throws SQLException{
        try{
            ps = con.prepareStatement(query);
        } catch(SQLException e){
            System.out.println("Error "+ e);
        }
    }
}
