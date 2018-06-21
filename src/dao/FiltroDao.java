/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
//import com.sun.istack.internal.logging.Logger;
import Conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;


/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos<Filtro>{
    private static final String SQL_INSERT = "INSERT INTO productos(nombre,codigo,tipo,cantidad,precio,disponibilidad) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productos SET nombre = ? ,tipo = ?,cantidad = ?, precio = ?, disponibilidad = ? WHERE codigo=?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE codigo=?";
    private static final String SQL_READ = "SELECT * FROM productos WHERE codigo=?";
    private static final String SQL_READALL = "SELECT * FROM productos";
    private static final Conexion con = Conexion.conectar();
    @Override
    public boolean create(Filtro g) {
        PreparedStatement ps;
    try {
        ps = con.getCnx().prepareStatement(SQL_INSERT);
        ps.setString(1, g.getCodigo());
        ps.setString(1, g.getNombre());
        ps.setBoolean(4, true);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
      return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Filtro c) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCantidad());
            ps.setBoolean(3, c.getDisponibilidad());
            ps.setString(4, c.getCodigo());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Filtro read(Object key) {
       Filtro f = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                f = new Filtro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Filtro> readAll() {
        ArrayList<Filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;

        try {
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);

            while (rs.next()) {
                all.add(new Filtro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    
}
