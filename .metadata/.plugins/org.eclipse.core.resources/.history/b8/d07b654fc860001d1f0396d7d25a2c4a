package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	//Metodo estatico encargado de realizar la conexión a la bd "ciberfarma"
	public static Connection getConexion() {
		Connection con = null;
		try {
			// Establecer la ruta del driver de conexion --> nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//datos para establecer la conecion a la bd
			//		driver:protocoloDriver://ubicacion&puertodeConexion/nombreBD?datos de actualizacion-timezone
			String url = "jdbc:mysql://localhost:3306/ciberfarma?serverTimezone=UTC";
			String usr = "root";
			String psw = "1234";
			// se envia los datos, si son correctos, cambia este objeto a 1, y se establece la conexion
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {   //mensajes de error de conexion
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
