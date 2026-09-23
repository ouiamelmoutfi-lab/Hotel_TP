/*

* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
/**
 *
 * @author ouiam
 */
@Entity
public class Chambre {
      @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ; 
   private double prix;
   
   @Enumerated(EnumType.STRING)
    private TypeChambre type;
   
   @Enumerated(EnumType.STRING)
private Etat etat;
   @ManyToOne
    private Hotel hotel;
    public Chambre(){
        
    }
    public Chambre(double prix, TypeChambre type, Etat etat, Hotel hotel) {
        this.prix = prix;
        this.type = type;
        this.etat = etat;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public TypeChambre getType() {
        return type;
    }

    public void setType(TypeChambre type) {
        this.type = type;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
   
   @Override
    public String toString() {
        return "Chambre{" + "id=" + id + " prix=" + prix + " type= " + type + " etat= " + etat + '}';
    }
   
   
}
