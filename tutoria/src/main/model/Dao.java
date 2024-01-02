package main.model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
    ConectionDB conectionDB = new ConectionDB();
    public void testarConexao(){
        try {
            Connection con = conectionDB.conectar();
            System.out.println(con);
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void criarContato(Javabeans contato){
        String create = "INSERT INTO contatos (name_cont,phone,email) VALUES (?, ?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newC = con.prepareStatement(create);
            newC.setString(1,contato.getName());
            newC.setString(2,contato.getNumber());
            if (contato.getEmail() != null){
                newC.setString(3,contato.getEmail());
            }
            newC.execute();
            newC.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<Javabeans> listarContatos(){
        String cmd = "SELECT * FROM contatos ORDER BY name_cont ASC";
        ArrayList<Javabeans> contatos = new ArrayList<>();
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(cmd);
            ResultSet re = ps.executeQuery();
            while (re.next()){
                Javabeans contato = new Javabeans();
                contato.setIdnumber(re.getInt(1));
                contato.setName(re.getString(2));
                contato.setNumber(re.getString(3));
                contato.setEmail(re.getString(4));
                contatos.add(contato);
            }
            con.close();
            return contatos;

        }catch (Exception e){
            System.out.println(e);
            return null;

        }
    }
    public void selecionarContato(Javabeans contato){
        String comando = "SELECT * FROM contatos WHERE idnumber = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(comando);
            ps.setInt(1,contato.getIdnumber());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                contato.setIdnumber(rs.getInt(1));
                contato.setName(rs.getString(2));
                contato.setNumber(rs.getString(3));
                contato.setEmail(rs.getString(4));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editarContato(Javabeans contato){
        String comando = "UPDATE contatos SET name_cont = ?, phone = ?, email = ? WHERE idnumber = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(comando);
            ps.setString(1, contato.getName());
            ps.setString(2, contato.getNumber());
            ps.setString(3, contato.getEmail());
            ps.setInt(4, contato.getIdnumber());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletarContato(Javabeans contato){
        String comando = "DELETE FROM contatos WHERE idnumber = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(comando);
            ps.setInt(1, contato.getIdnumber());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
