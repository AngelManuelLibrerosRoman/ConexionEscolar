package dao;

import conexion.Conexion;
import modelo.ModeloCatedratico;
import modelo.ModeloEspecialidad;
import modelo.ModeloGrupo;
import modelo.ModeloMateria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOGrupo implements DAOGeneral<Integer,ModeloGrupo> {
    private Conexion conexion;
    public DAOGrupo(){

        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ModeloGrupo elemento) {
        if(conexion.abrir()){
            String sql = "INSERT INTO grupo(clave, id_materia, id_catedratico, hora, salon) VALUES (?,?,?,?,?)";
            Connection enlace = conexion.obtener();
            ModeloGrupo mg = new ModeloGrupo();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setString(1, elemento.getClave());
                pstm.setInt(2, elemento.getMateria());
                pstm.setString(3, elemento.getCatedratico());
                pstm.setInt(4, elemento.getHora());
                pstm.setInt(5, elemento.getSalon());
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
    public List<ModeloGrupo> consultar() {
        List<ModeloGrupo> lista = new ArrayList<>();
        if(conexion.abrir()){
            String sql = "SELECT * FROM grupo";
            Connection enlace = conexion.obtener();
            try{
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while(resultados.next()){
                    ModeloGrupo grupo = new ModeloGrupo();
                    grupo.setClave(resultados.getString("clave"));
                    grupo.setMateria(resultados.getInt("materia"));
                    grupo.setCatedratico(resultados.getString("catedratico"));
                    grupo.setHora(resultados.getInt("hora"));
                    grupo.setSalon(resultados.getInt("salon"));
                    lista.add(grupo);
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
    public boolean actualizar(Integer id, ModeloGrupo nuevo) {
        if (conexion.abrir()){
            String sql = "UPDATE grupo SET clave = ? SET materia = ? SET catedratico = ? SET hora = ? WHERE salon = ?";
            Connection enlace = conexion.obtener();
            try{
                PreparedStatement stnt = enlace.prepareStatement(sql);
                stnt.setInt(5, nuevo.getSalon());
                stnt.setInt(4, nuevo.getHora());
                stnt.setString(3, nuevo.getCatedratico());
                stnt.setInt(2, nuevo.getMateria());
                stnt.setString(1, nuevo.getClave());

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

    public boolean eliminarClave(String id) {
        if(conexion.abrir()){
            String sql = "DELETE FROM grupo WHERE Clave  = ?";
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
