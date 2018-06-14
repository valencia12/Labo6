/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos<Filtro>{
    private static final String SQL_INSERT = "INSERT INTO filtros_aceite(codFiltro,marca,stock,existencia) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE filtros_aceite SET marca = ? ,stock = ?,existencia = ? WHERE codFIltro=?";
    private static final String SQL_DELETE = "DELETE FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READ = "SELECT * FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READALL = "SELECT * FROM filtros_aceite";
    private static final Conexion con = Conexion.conectar();
    @Override
    public boolean create(Filtro g) {
        PreparedStatement ps;
    try {
        ps = con.getCnx().prepareStatement(SQL_INSERT);
        ps.setString(1, g.getCodigo());
        ps.setString(1, g.getMarca());
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
            ps.setString(1, c.getMarca());
            ps.setInt(2, c.getStock());
            ps.setBoolean(3, c.getExistencia());
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
        try{
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            while(rs.next()){
                f = new Filtro(rs.getInt(1), rs.getString(3), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return null;
    }

    @Override
    public ArrayList<Filtro> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
