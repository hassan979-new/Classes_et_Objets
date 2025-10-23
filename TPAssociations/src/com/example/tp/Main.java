package com.example.tp;

public class Main {
	public static void main(String[] args) {
		Etudiant e1 = new Etudiant("Dupont", "Alice");
		Etudiant e2 = new Etudiant("Martin", "Bob");
		Etudiant e3 = new Etudiant("Hassan", "Agouram");
		Etudiant e4 = new Etudiant("Rida", "Tahouni");

		e1.ajouterNote(14.5);
		e1.ajouterNote(12.0);
		e1.ajouterNote(16.0);
		e1.ajouterNote(9.0);
		e1.ajouterNote(16.0);
		e1.ajouterNote(12.0);
		

		e2.ajouterNote(10.0);
		e2.ajouterNote(13.5);
		

		e3.ajouterNote(10.0);
		e3.ajouterNote(13.5);
		

		e4.ajouterNote(10.0);
		e4.ajouterNote(13.5);
		e4.ajouterNote(10.0);
		e4.ajouterNote(13.5);
		e4.ajouterNote(10.0);
		e4.ajouterNote(13.5);
		e4.ajouterNote(10.0);
		e4.ajouterNote(13.5);
		e4.ajouterNote(10.0);
		e4.ajouterNote(13.5);
		
		System.out.println();

		e1.afficherNotes();
		System.out.println(e1);
		
		System.out.println();

		e2.afficherNotes();
		System.out.println(e2);
		
		System.out.println();

		e3.afficherNotes();
		System.out.println(e3);
		
		System.out.println();

		e4.afficherNotes();
		System.out.println(e4);
		
		System.out.println();

		e1.trierNotes();
		e1.supprimmerDerniereNotes();
		e1.ecriturFichier("etudiant1.txt");
		e1.afficherNotes();
		System.out.println(e1);

		System.out.println();
			
		Etudiant e5 = Etudiant.lireFichier("etudiant1.txt");
		if (e5 != null) {
			e5.afficherNotes();
			System.out.println(e5);
		}

	}
}
