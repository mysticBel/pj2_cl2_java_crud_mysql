package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Equipo;
import interfaces.EquipoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionEquipoDAO implements EquipoInterfacesDAO {

	@Override
	public ArrayList<Equipo> listarEquipos() {
		ArrayList<Equipo> lista = new ArrayList<Equipo>();
		Equipo eq = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// PASO 1 :  Establecer la conexion a la BD
						con = MySQLConexion8.getConexion();
						// PASO 2 : Registro ->Definir la instruccion SQL 		
						String sql = " SELECT * FROM tb_equipos";
						// PASO 3 : Obtener los comandos QL 
						pstm = con.prepareStatement(sql);
						// PASO 4 : Obtener los parametros (no hay)
						// PASO 5 : ejecucion de la instruccion
						res = pstm.executeQuery();   
						//PASO 6 :
						while(res.next()){
							eq = new Equipo();
							//setear
							eq.setIdequipo(res.getInt(1));
							eq.setNombre(res.getString(2));
							//enviar a la lista
							lista.add(eq);
						}
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(res != null) res.close();
				if(con!= null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD " + e2.getMessage());
			}finally {
			}
		}
		return lista;
	}

}
