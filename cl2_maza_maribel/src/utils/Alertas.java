package utils;

import javax.swing.JOptionPane;

public class Alertas {
	//metodo de alerta error
		public static void mensajeError(String msj) {
			JOptionPane.showMessageDialog(null,msj,"Error!!!",0);
			
		}
		//metodo de alerta exitoso
			public static void mensajeExitoso(String msj) {
				JOptionPane.showMessageDialog(null,msj,"Sistema",1);
				
			}
		//metodo de alerta yes-no
			public static void mensajeYesNo(String msj) {
				JOptionPane.showMessageDialog(null,msj,"Warning",JOptionPane.YES_NO_OPTION);
				
			}	
			
}
