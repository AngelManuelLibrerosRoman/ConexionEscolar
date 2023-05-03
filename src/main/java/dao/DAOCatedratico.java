package dao;

import conexion.Conexion;
import modelo.ModeloCatedratico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCatedratico implements DAOGeneral<Integer, ModeloCatedratico> {
    private Conexion conexion;
    public DAOCatedratico(){

        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ModeloCatedratico elemento) {
        if(conexion.abrir()){
            String sql = "INSERT INTO catedratico(RFC, nombre) VALUES (?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setString(1, elemento.getRFC());
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
    public List<ModeloCatedratico> consultar() {
        List<ModeloCatedratico> lista = new ArrayList<>();
        if(conexion.abrir()){
            String sql = "SELECT * FROM catedratico";
            Connection enlace = conexion.obtener();
            try{
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while(resultados.next()){
                    ModeloCatedratico catedratico = new ModeloCatedratico();
                    catedratico.setRFC(resultados.getString("RFC"));
                    catedratico.setNombre(resultados.getString("nombre"));
                    lista.add(catedratico);
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
    public boolean actualizar(Integer RFC, ModeloCatedratico nuevo) {
        if (conexion.abrir()){
            String sql = "UPDATE catedratico SET nombre = ? WHERE RFC = ?";
            Connection enlace = conexion.obtener();
            try{
                PreparedStatement stnt = enlace.prepareStatement(sql);
                stnt.setString(1, nuevo.getNombre());
                stnt.setString(2, nuevo.getRFC());
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
    public boolean eliminar(Integer id) {
        return false;
    }

    public boolean eliminarRFC(String id) {
        if(conexion.abrir()){
            String sql = "DELETE FROM catedratico WHERE RFC = ?";
            Connection con = conexion.obtener();
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,id);
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