package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Jugador;
import utils.MySQLConexion8;

public class GestionJugadorDAO {

	/////////////////////   REGISTRO -  INSERT	////////////////////////////////////
	public int registrarJugador(Jugador j) {
		int res = 0;
		Connection con = null; 
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//		
			String sql = "insert into tb_jugadores values ( ?, ?, ?, ?, ?, ?, ?)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setInt(1,  j.getIdjugador());
			pstm.setString(2,  j.getNombre());
			pstm.setString(3,  j.getApellido());
			pstm.setString(4,  j.getDni());
			pstm.setString(5,  j.getFechaNacimiento());
			pstm.setDouble(6,  j.getSueldo());
			pstm.setInt(7,  j.getIdequipo());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucci�n del registro " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas pr�cticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e2) { 
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	///////////////////////  ACTUALIZAR  -  UPDATE  	////////////////////////////////////
	
	public int actualizarJugador(Jugador j) {
		int res = 0;
		Connection con = null; 
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//		
			String sql = "update tb_jugadores set  nombre = ? , apellido = ?,  dni = ?, fechaNacimiento = ?, sueldo = ?, idequipo = ? where idjugador = ?";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			
			pstm.setString(1,  j.getNombre());
			pstm.setString(2,  j.getApellido());
			pstm.setString(3,  j.getDni());
			pstm.setString(4,  j.getFechaNacimiento());
			pstm.setDouble(5,  j.getSueldo());
			pstm.setInt(6,  j.getIdequipo());
			pstm.setInt(7,  j.getIdjugador());
			
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucci�n de la actualizaci�n " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas pr�cticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e2) {  //importar
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	

	///////////////////////  ELIMINAR  -  DELETE 	////////////////////////////////////
	
	public int eliminarJugador(int idJugador) {
		int res = 0;
		Connection con = null; 
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//		
			String sql = "delete from  tb_jugadores where idjugador = ?"; 
			// PASO 3 : Obtener los comandos QL --> Enviar la instruccion al objeto pstm
			   pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
				pstm.setInt(1, idJugador );			
			// PASO 5 : ejecucion de la instruccion
				res = pstm.executeUpdate();   
			
		} catch (Exception e) {
			System.out.println(">>>>  Error en la instrucci�n SQL - eliminar <<<< " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas pr�cticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e2) {  
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	
	
	
	
	
    /////////////////////  cargar la data de Jugadores a la tabla ///////////////////////
	public ArrayList<Jugador> listarJugadores() {
		ArrayList<Jugador> listaJug = new ArrayList<Jugador>();  
		Connection con = null; 
		PreparedStatement pstm = null;
		ResultSet res = null;
		Jugador j = null;  //inicializamos en null un objeto Jugador para asignarle valores
		
		try {
			//La parte l�gica de la conexi�n
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			   con = MySQLConexion8.getConexion();
			/* PASO 2 : Consultar ->Definir la instruccion SQL */
			   String sql = "select *  from  tb_jugadores";
			// PASO 3 : Enviar la instruccion al objeto pstm --> Obtener los comandos SQL
			   pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros --no hay
			// PASO 5 : ejecucion de la instruccion
				res = pstm.executeQuery();   //el resultado de la consulta lo obtiene el objeto res
			//**PASO 6 : Bucle --> Realizar el recorrido al objeto res
				while(res.next()) {
					// Crear objeto de tipo Usuario
					j = new Jugador();
					// setear --> Asignar los valores obtenidos del obj res a los atrib. privados
					j.setIdjugador(res.getInt(1));
					j.setNombre(res.getString(2)); 
					j.setApellido(res.getString(3));
					j.setDni(res.getString(4));
					j.setFechaNacimiento(res.getString(5));
					j.setSueldo(res.getDouble(6));
					j.setIdequipo(res.getInt(7));
				
			// A�adir el objeto a la lista
					listaJug.add(j);
				}
		
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucci�n SQL - Consultar " + e.getMessage());
		} finally {
			try {
				if(pstm !=null) pstm.close();
				if(res !=null) res.close();
				if(con !=null) con.close();
					
			} catch (SQLException e2) {
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
	   }
		
		return listaJug;
	}
	
	
}
