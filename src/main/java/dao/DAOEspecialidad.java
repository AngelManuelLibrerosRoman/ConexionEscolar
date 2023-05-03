package dao;

import conexion.Conexion;
import modelo.ModeloEspecialidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEspecialidad implements DAOGeneral<Integer,ModeloEspecialidad> {
    private Conexion conexion;
    public DAOEspecialidad(){

        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ModeloEspecialidad elemento) {
        if(conexion.abrir()){
            String sql = "INSERT INTO especialidad(id_especialidad, nombre) VALUES (?,?)";
            Connection enlace = conexion.obtener();
            ModeloEspecialidad me = new ModeloEspecialidad();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, elemento.getId());
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
    public List<ModeloEspecialidad> consultar() {
        List<ModeloEspecialidad> lista = new ArrayList<>();
        if(conexion.abrir()){
            String sql = "SELECT * FROM especialidad";
            Connection enlace = conexion.obtener();
            try{
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while(resultados.next()){
                    ModeloEspecialidad especialidad = new ModeloEspecialidad();
                    especialidad.setId(resultados.getInt("id"));
                    especialidad.setNombre(resultados.getString("nombre"));
                    lista.add(especialidad);
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
    public boolean actualizar(Integer id, ModeloEspecialidad nuevo) {
        if (conexion.abrir()){
            String sql = "UPDATE especialidad SET nombre = ? WHERE id_especialidad = ?";
            Connection enlace = conexion.obtener();
            try{
                PreparedStatement stnt = enlace.prepareStatement(sql);
                stnt.setString(1, nuevo.getNombre());
                stnt.setInt(2, id);
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
        if(conexion.abrir()){
            String sql = "DELETE FROM especialidad WHERE id_especialidad = ?";
            Connection con = conexion.obtener();
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1,id);
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


    public static ModeloEspecialidad busquedaEspecialidad(int id){
        String n_id = String.valueOf(id);
        ModeloEspecialidad resultado = null;
        DAOEspecialidad daoe = new DAOEspecialidad();
        for (ModeloEspecialidad espe : daoe.consultar()) {
            if (String.valueOf(espe.getId()).equals(n_id)) {
                resultado = espe;
                break;
            }
        }
        return resultado;
    }


}
