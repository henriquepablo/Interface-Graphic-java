package application;

import view.FormRegisterBook;

public class Program {

	public static void main(String[] args) {
		
		FormRegisterBook frb = new FormRegisterBook();
		
		frb.setVisible(true);
		frb.setDefaultCloseOperation(frb.EXIT_ON_CLOSE);
	}

}
