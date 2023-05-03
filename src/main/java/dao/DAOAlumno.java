package dao;

import conexion.Conexion;
import modelo.ModeloAlumno;
import modelo.ModeloEspecialidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAlumno implements DAOGeneral<Integer, ModeloAlumno> {
    private Conexion conexion;
    public DAOAlumno(){

        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ModeloAlumno elemento) {
        if(conexion.abrir()){
            String sql = "INSERT INTO alumno(numControl, nombre, id_especialidad) VALUES (?,?,?)";
            Connection enlace = conexion.obtener();
            ModeloAlumno alu = new ModeloAlumno();

            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, elemento.getNumControl());
                pstm.setString(2, elemento.getNombre());
                pstm.setInt(3, elemento.getEspecialidad());

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
    public List<ModeloAlumno> consultar() {
        List<ModeloAlumno> lista = new ArrayList<>();
        if(conexion.abrir()){
            String sql = "SELECT * FROM alumno";
            Connection enlace = conexion.obtener();
            try{
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while(resultados.next()){
                    ModeloAlumno alumno = new ModeloAlumno();
                    alumno.setNumControl(resultados.getInt("Numero de Control"));
                    alumno.setNombre(resultados.getString("nombre"));
                    alumno.setEspecialidad(resultados.getInt("Id especialidad"));
                    lista.add(alumno);
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
    public boolean actualizar(Integer id, ModeloAlumno nuevo) {
        if (conexion.abrir()){
            String sql = "UPDATE alumno SET nombre = ? SET id_especialidad = ? WHERE numControl = ?";
            Connection enlace = conexion.obtener();
            try{
                PreparedStatement stnt = enlace.prepareStatement(sql);
                stnt.setString(1, nuevo.getNombre());
                stnt.setInt(2,nuevo.getEspecialidad());
                stnt.setInt(3,nuevo.getNumControl());
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
            String sql = "DELETE FROM alumno WHERE numControl = ?";
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

}