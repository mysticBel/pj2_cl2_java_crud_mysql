package interfaces;

import java.util.ArrayList;

import entidad.Jugador;

public interface JugadorInterfacesDAO {
	// 1. Definimos los procesos
		public int registrarJugador(Jugador j); 
		public int actualizarJugador(Jugador j);
		public int eliminarJugador(int idJugador);
			
		//Proceso de consulta -  Buscar un jugador por codigo
		public Jugador buscarJugador(int idJugador);
		//Proceso de Listado - tblJugadores
		public ArrayList<Jugador> listarJugador();  //import ArrayList
}
