	package com.example.tp;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Etudiant {
	private static int compteur = 0;
	
	private final int id;
	
	private String nom;
	
	private String prenom;
	
	private double[] notes;
	
	private int nbNotes;
	
	private static final int MAX_NOTES = 8;
	
	public Etudiant(String nom, String prenom) {
		this.id = ++compteur;
		this.nom = nom;
		this.prenom = prenom;
		this.notes = new double[5];
		this.nbNotes = 0;
	}
	
	public void ajouterNote(double note){
		if (nbNotes >= MAX_NOTES) {
			System.out.println("Nombre maximal de notes atteint !");
			return;
		}
		
		if(nbNotes == notes.length) {
			double[] tmp = new double[notes.length*2];
			System.arraycopy(notes, 0, tmp, 0, notes.length);
			notes = tmp;
		}
		notes[nbNotes++] = note;
	}
	
	public double calculerMoyenne() {
		if(nbNotes == 0 ) return 0.0;
		
		double somme = 0;
		for (int i = 0; i < nbNotes; i++) {
			somme+=notes[i];
		}
		
		return somme/nbNotes;
	}
	
	public void afficherNotes() {
		System.out.print("Notes de " +nom+" "+prenom+" : ");
		for (int i = 0; i < nbNotes; i++) {
			System.out.print(notes[i]);
			if(i<nbNotes-1) System.out.print(", ");
		}
		System.out.println();
	}
	
	public void trierNotes() {
		Arrays.sort(notes,0,nbNotes);
		System.out.println("Notes tries!");
	}
	
	public void supprimmerDerniereNotes() {
		if(nbNotes>0) {
			notes[nbNotes]=0.0;
			nbNotes--;
			System.out.println("la derniere note supprimee!");
		}else {
			System.out.println("Aucune note à supprimee!");
		}
	}
	
	public void ecriturFichier(String fichier) {
		try (PrintWriter ecriteur = new PrintWriter(fichier)){
			ecriteur.println(id+";"+nom+";"+prenom);
			for (int i = 0; i < nbNotes; i++) {
				ecriteur.print(notes[i]+" ");
			}
			System.out.println("les information sont enregestrer dans "+fichier);
			ecriteur.println();
			
			
		}catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}
	}
	
	public static Etudiant lireFichier(String nomFichier) {
		try(Scanner sc = new Scanner(new File(nomFichier))) {
			String[] infos = sc.nextLine().split(";");
			Etudiant e = new Etudiant(infos[1], infos[2]);
			String[] notesStr = sc.nextLine().split(" ");
			for (String n : notesStr) {
				e.ajouterNote(Double.parseDouble(n));
			}
			System.out.println("les donner sont charger de "+nomFichier+"!");
			return e;
			
		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Etudiant [id="+id+
				", nom="+nom+
				", prenom="+prenom+
				",moyenne="+String.format("%.2f",calculerMoyenne())+
				"]";
	}
}
