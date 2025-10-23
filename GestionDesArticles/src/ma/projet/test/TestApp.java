package ma.projet.test;

import ma.projet.bean.Article;
import ma.projet.bean.Categorie;

public class TestApp {

	public static void main(String[] args) {

		Categorie ord1 = new Categorie("Ordinateur Portable", "O PR");
		Categorie ord2 = new Categorie("Ordinateur Poste ", "O PO");

		Categorie[] t1 = { ord1, ord2 };

		Article art1 = new Article(14, "DELL INSPIRON", ord1);
		Article art2 = new Article(4, "SONY VAIO", ord1);
		Article art3 = new Article(74, "TERRA", ord2);
		Article art4 = new Article(785, "HP Compaq", ord2);

		Article[] t2 = { art1, art2, art3, art4 };

		for (Categorie categorie : t1) {
			System.out.println(categorie.getLibelle() + " : ");
			for (Article article : t2) {
				if (article.getCategorie().getId() == categorie.getId()) {
					System.out.println(article);
				}
			}
		}
	}

}
