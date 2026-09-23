/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.test;

import java.util.List;
import java.util.Scanner;

import exemple1.Chambre;
import exemple1.Etat;
import exemple1.Hotel;
import exemple1.TypeChambre;

import ma.services.ChambreServices;
import ma.services.HotelServices;

public class Test {

    public static void main(String[] args) {

        HotelServices hs = new HotelServices();
        ChambreServices cs = new ChambreServices();

        Hotel hotel1 = new Hotel(
                "Hotel mimona",
                "Marrakech"
        );

        hs.create(hotel1);

        Chambre c1 = new Chambre(
                400f,
                TypeChambre.simple,
                Etat.libre,
                hotel1
        );

        Chambre c2 = new Chambre(
                700f,
                TypeChambre.doublechambre,
                Etat.occupee,
                hotel1
        );

        Chambre c3 = new Chambre(
                1000f,
                TypeChambre.suite,
                Etat.occupee,
                hotel1
        );

        cs.create(c1);
        cs.create(c2);
        cs.create(c3);


        Hotel hotel2 = new Hotel(
                "Hotel barsilo",
                "fes"
        );

        hs.create(hotel2);

        Chambre c4 = new Chambre(
                500f,
                TypeChambre.simple,
                Etat.libre,
                hotel2
        );

        Chambre c5 = new Chambre(
                800f,
                TypeChambre.f2,
                Etat.occupee,
                hotel2
        );

        cs.create(c4);
        cs.create(c5);


        // Hotel 3 : 4 chambres
        Hotel hotel3 = new Hotel(
                "Hotel zalage",
                "fes"
        );

        hs.create(hotel3);

        Chambre c6 = new Chambre(
                450f,
                TypeChambre.simple,
                Etat.libre,
                hotel3
        );

        Chambre c7 = new Chambre(
                650f,
                TypeChambre.doublechambre,
                Etat.occupee,
                hotel3
        );

        Chambre c8 = new Chambre(
                900f,
                TypeChambre.F1,
                Etat.libre,
                hotel3
        );

        Chambre c9 = new Chambre(
                1200f,
                TypeChambre.suite,
                Etat.occupee,
                hotel3
        );

        cs.create(c6);
        cs.create(c7);
        cs.create(c8);
        cs.create(c9);


        // Afficher les chambres par hôtel
        List<Chambre> chambresHotel = cs.findAll();

        System.out.println("===== CHAMBRES DE L'HOTEL =====");
               
        for (Chambre c : chambresHotel) {
               Hotel h = c.getHotel();    
            System.out.println(
                     "Hotel : " + h.getNom()
                    + "  Adresse : " + h.getAdresse()
                    + "Id : " + c.getId()
                    + " Prix : " + c.getPrix()
                    + " Type : " + c.getType()
                    + " Etat : " + c.getEtat()
            );
        }


        // Rechercher les chambres par état et par prix

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEntrer l'état (libre / occupee) : ");
        String etatSaisi = sc.nextLine();

        System.out.print("Entrer le prix maximum : ");
        double prixSaisi = sc.nextDouble();

        Etat etat = Etat.valueOf(etatSaisi);

        List<Chambre> chambresRecherche =
                cs.findByEtatAndPrix(etat, prixSaisi);

        System.out.println("\n===== RESULTAT DE LA RECHERCHE =====");

for (Chambre c : chambresRecherche) {

    Hotel h = c.getHotel();
    System.out.println("\n");
    System.out.println("Hotel    : " + h.getNom());
    System.out.println("Adresse  : " + h.getAdresse());
    System.out.println("Chambre  : " + c.getId());
    System.out.println("Prix     : " + c.getPrix());
    System.out.println("Type     : " + c.getType());
    System.out.println("Etat     : " + c.getEtat());
}

        sc.close();
    }
}