package dao;

import conexion.Conexion;
import modelo.ModeloMateria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMateria implements DAOGeneral<Integer, ModeloMateria> {
    private Conexion conexion;
    public DAOMateria(){

        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ModeloMateria elemento) {
        if(conexion.abrir()){
            String sql = "INSERT INTO materia(id_materia, nombre) VALUES (?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, elemento.getId_materia());
                pstm.setString(2, elemento.getNombre());
                pstm.execute();
                return true;
            }catch (SQLException e){
                return false;
            }finally{
                conexion.cerrar();
            }
        }
        return false;
    }

    @Override
    public List<ModeloMateria> consultar() {
        List<ModeloMateria> lista = new ArrayList<>();
        if(conexion.abrir()){
            String sql = "SELECT * FROM materia";
            Connection enlace = conexion.obtener();
            try{
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while(resultados.next()){
                    ModeloMateria materia = new ModeloMateria();
                    materia.setId_materia(resultados.getInt("id"));
                    materia.setNombre(resultados.getString("nombre"));
                    lista.add(materia);
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally{
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }

    @Override
    public boolean actualizar(Integer id, ModeloMateria nuevo) {
        if (conexion.abrir()){
            String sql = "UPDATE materia SET nombre = ? WHERE id_materia = ?";
            Connection enlace = conexion.obtener();
            try{
                PreparedStatement stnt = enlace.prepareStatement(sql);
                stnt.setString(1, nuevo.getNombre());
                stnt.setInt(2, nuevo.getId_materia());
                stnt.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally{
                conexion.cerrar();
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer id_materia) {
        if(conexion.abrir()){
            String sql = "DELETE FROM materia WHERE id_materia = ?";
            Connection con = conexion.obtener();
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, id_materia);
                statement.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally{
                conexion.cerrar();
            }
        }
        return false;
    }

}