package com.ejemplo.agenda.dao;

import com.ejemplo.agenda.model.Contacto;
import com.ejemplo.agenda.util.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para operaciones CRUD de Contacto
 */
public class ContactoDAO {

    /**
     * Listar todos los contactos
     */
    public List<Contacto> listarTodos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos ORDER BY id DESC";
        
        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Contacto contacto = new Contacto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("sexo"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("tipo_contacto")
                );
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar contactos: " + e.getMessage());
            e.printStackTrace();
        }
        return contactos;
    }

    /**
     * Obtener un contacto por ID
     */
    public Contacto obtenerPorId(int id) {
        Contacto contacto = null;
        String sql = "SELECT * FROM contactos WHERE id = ?";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                contacto = new Contacto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("sexo"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("tipo_contacto")
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener contacto: " + e.getMessage());
            e.printStackTrace();
        }
        return contacto;
    }

    /**
     * Insertar un nuevo contacto
     */
    public boolean insertar(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, apellido_paterno, apellido_materno, " +
                     "sexo, telefono, direccion, tipo_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidoPaterno());
            pstmt.setString(3, contacto.getApellidoMaterno());
            pstmt.setString(4, contacto.getSexo());
            pstmt.setString(5, contacto.getTelefono());
            pstmt.setString(6, contacto.getDireccion());
            pstmt.setString(7, contacto.getTipoContacto());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar contacto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Actualizar un contacto existente
     */
    public boolean actualizar(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre=?, apellido_paterno=?, apellido_materno=?, " +
                     "sexo=?, telefono=?, direccion=?, tipo_contacto=? WHERE id=?";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidoPaterno());
            pstmt.setString(3, contacto.getApellidoMaterno());
            pstmt.setString(4, contacto.getSexo());
            pstmt.setString(5, contacto.getTelefono());
            pstmt.setString(6, contacto.getDireccion());
            pstmt.setString(7, contacto.getTipoContacto());
            pstmt.setInt(8, contacto.getId());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar contacto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Eliminar un contacto por ID
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar contacto: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
