package hotelModel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebService;

import hotelModel.Chambre.typeChambre;

public class Hotel {
	public enum nombreEtoile{
		ZeroEtoile, uneEtoile, deuxEtoiles, troisEtoile, quatreEtoile, cinqEtoile
	};
	
	private String nom;
	private String pays;
	private String ville;
	private String rue ;
	private int numRue;
	private String lieu ;
	private String positionGPS;
	private int prixMin;
	private int prixMax;
	private nombreEtoile categorie ;
	private ArrayList<Chambre> chambreList= new ArrayList<Chambre>();
	private HashMap<String, String> listAgencePartenaire;
	
	
	public Hotel() {}
	public Hotel(String nom, String pays, String ville, String rue, int numRue, String lieu,String position, int prixMin, int prixMax,
			nombreEtoile categorie) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numRue = numRue;
		this.lieu = lieu;
		this.prixMin = prixMin;
		this.prixMax=prixMax;
		this.positionGPS=position;
		this.categorie = categorie;
		this.chambreList =new  ArrayList<Chambre>();
		listAgencePartenaire= new HashMap<String,String>();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPays() {
		return pays;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public int getNumRue() {
		return numRue;
	}
	
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	
	public String getLieu() {
		return lieu;
	}
	
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public float getPrixMin() {
		return prixMin;
	}
	public void setPrixMin(int prixMin) {
		this.prixMin = prixMin;
	}
	public float getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(int prixMax) {
		this.prixMax = prixMax;
	}
	public nombreEtoile getCategorie() {
		return categorie;
	}
	
	public void setCategorie(nombreEtoile categorie) {
		this.categorie = categorie;
	}
	
	public ArrayList<Chambre> getChambreList() {
		return chambreList;
	}

	public void setChambreList(ArrayList<Chambre> chambreList) {
		this.chambreList = chambreList;
	}
	
	 
	public String getPositionGPS() {
		return positionGPS;
	}
	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}
	public HashMap<String, String> getListAgencePartenaire() {
		return listAgencePartenaire;
	}
	public void setListAgencePartenaire(HashMap<String, String> listAgencePartenaire) {
		this.listAgencePartenaire = listAgencePartenaire;
	}
	
	public boolean isAgencePartenaire(String id, String code) {
		if(listAgencePartenaire.containsKey(id)) {
		 String value=listAgencePartenaire.get(id);
		 return value.equals(code);
		}
		System.err.println("Malheureusement, il ne vous est pas possible d'accéder au service de l'hotel "+this.getNom());
		return false;
	}
	
	public boolean addAgencePartenaire(String id, String code) {
		if(listAgencePartenaire.containsKey(id)) {
			System.out.println("Cette agence existe deja dans la liste des agences partenaires");	
			return false;
		}else {
			listAgencePartenaire.put(id, code);
			return true;
		}	
	}
	
	public boolean deleteAgencePartenaire(String id) {
		if(listAgencePartenaire.containsKey(id)) {
			listAgencePartenaire.remove(id);
			return true;
		}else{
			System.out.println("Cette agence existe deja dans la liste des agences partenaires");	
			return false;	
		}
	}
	
	public String afficherChambreDispo(String dateD, String dateF, int nbrPersonne, int prixMin, int prixMax, int pourcentage) {
		String chambres="";
		for(Chambre chambre: chambreList) {
			int prixChambre= chambre.getPrix();
			int prix=prixChambre + (prixChambre*(pourcentage/100));
			if(!chambre.isReserve(dateD,dateF) && (chambre.getTypeNbrPersonne(nbrPersonne)).equals(chambre.getType()) && prix>=prixMin && prix<=prixMax) chambres+="Chambre numero :" +chambre.getNumeroChambre()+" de type : "+chambre.getType()+" au prix de : "+prix+" €\n";
		}
		return chambres;
	}
	
	public boolean ReserverChambre(int numChambre, int nbrPersonne,  String dateD, String dateF, int pourcentage) {
		for(Chambre chambre : chambreList) {
			if(chambre.getNumeroChambre()==numChambre) {
				int prix=chambre.getPrix();
				float prixTot=prix+(prix*(pourcentage/100));
					if(!chambre.isReserve(dateD,dateF)) {
						switch (nbrPersonne) {
						case 1:
							if(chambre.getType().equals(typeChambre.simple)) { chambre.addDate(dateD,dateF);  return true;	}
							break;
						case 2:
							if(chambre.getType().equals(typeChambre.DoubleConfort)) {chambre.addDate(dateD,dateF);  return true;	}	
							break;
						case 3:
							if(chambre.getType().equals(typeChambre.TripleFamiliale)) {chambre.addDate(dateD,dateF);  return true;	}	
							break;
						case 4:
							if(chambre.getType().equals(typeChambre.QuadrupleFamiliale)) {chambre.addDate(dateD,dateF);  return true;		}
							break;
						case 5:
							if(chambre.getType().equals(typeChambre.quintuple)) {chambre.addDate(dateD,dateF);  return true;	}
							break;
						default:
							return false;
						}	
					}	
			}	
	}
		return false;
	}
	
	public boolean annulerReservationChambre(int numChambre, String dateDeb, String dateFin) {
		LocalDate today=LocalDate.now();
		LocalDate dateDebut= LocalDate.parse(dateDeb);	
		long dif=ChronoUnit.DAYS.between(today, dateDebut);
		if(dif>=2) {
		 LocalDate dateF= LocalDate.parse(dateFin);
		 long nbrJours=ChronoUnit.DAYS.between(dateDebut, dateF); 
		 for(Chambre chambre: this.chambreList) {
			 if(chambre.getNumeroChambre()==numChambre) {
				 if( chambre.dateReserve.contains(dateDebut)) chambre.deleteDate(dateDebut);
				 for(int i=0;i<nbrJours;i++) {
					 LocalDate date = dateDebut.plusDays(1);
					 dateDebut = date;
					 if( chambre.dateReserve.contains(date)) chambre.deleteDate(date);
					}
				 return true;
			  }
		  }
		}else System.out.println("Annulation possible uniquement sous 48h");
		return false;
	}
	
	public boolean checkChambreType(int nbrPersonne) {
		switch (nbrPersonne) {
			case 1:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.simple)) return true;
				}
				break;
			case 2:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.DoubleConfort)) return true;
				}
				break;
			case 3:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.TripleFamiliale)) return true;
				}
				break;
			case 4:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.QuadrupleFamiliale)) return true;
				}
				break;
			case 5:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.quintuple)) return true;
				}
				break;
			default:
				return false;
			}
		return false;
		}
	
	public boolean checkChambreDispo(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF) {
		for(Chambre chambre : chambreList) {
			if(chambre.getPrix()>=prixMin && chambre.getPrix()<=prixMax && !chambre.isReserve(dateD, dateF) && checkChambreType(nbrPersonne)) 
				return true;
		}
		return false;
	}
	
	public ArrayList<String> listChambreDispo(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF){
		ArrayList<String> list=new ArrayList<String>();
		for(Chambre chambre : chambreList) {
			if(chambre.getPrix()>=prixMin && chambre.getPrix()<=prixMax && !chambre.isReserve(dateD, dateF) && checkChambreType(nbrPersonne)) 
				list.add(this.getNom()+chambre.getNumeroChambre());
		}
		return list;
		
	}

	
	
	
}