package com.example.tp;

public class Filiere {
	private static int compteur = 0;
	private final int id;
	private String nom;
	private Étudiant[] etudiants;
	private int nbEtudiants;

	public Filiere(String nom) {
		this.id = ++compteur;
		this.nom = nom;
		this.etudiants = new Étudiant[5];
		this.nbEtudiants = 0;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getNbEtudiants() {
		return nbEtudiants;
	}

	public void ajouterEtudiant(Étudiant e) {
		if (nbEtudiants == etudiants.length) {
			Étudiant[] tmp = new Étudiant[etudiants.length * 2];
			System.arraycopy(etudiants, 0, tmp, 0, nbEtudiants);
			etudiants = tmp;
		}
		etudiants[nbEtudiants++] = e;
		e.setFiliere(this);
	}

	public void afficherEtudiants() {
		System.out.println("Filière " + nom + " (id=" + id + ") → " + nbEtudiants + " étudiants :");
		for (int i = 0; i < nbEtudiants; i++) {
			System.out.println("  • " + etudiants[i].getNom() + " " + etudiants[i].getPrenom() + " (id="
					+ etudiants[i].getId() + ")");
		}
	}

	public void supprimerEtudiant(Étudiant e) {
		for (int i = 0; i < nbEtudiants; i++) {
			if (etudiants[i] == e) {
				for (int j = i; j < nbEtudiants; j++) {
					etudiants[j] = etudiants[j + 1];
				}
				etudiants[--nbEtudiants] = null;
				e.setFiliere(null);
				System.out.println("Étudiant supprimé de la filière.");
				return;
			}
		}
		System.out.println("Étudiant non trouvé dans cette filière.");
	}

	@Override
	public String toString() {
		return "Filiere[id=" + id + ", nom=" + nom + ", nbEtudiants=" + nbEtudiants + "]";
	}
}
