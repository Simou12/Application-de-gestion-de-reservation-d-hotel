package com.hotel.service;

import java.time.LocalDate;

import com.model.hotel.Hotel;
import com.resHotel.grpc.Reservation.ApiRes;
import com.resHotel.grpc.Reservation.CritereReservation;
import com.resHotel.grpc.Reservation.c;
import com.resHotel.grpc.Reservation.deleteRef;
import com.resHotel.grpc.Reservation.deleteResultat;
import com.resHotel.grpc.Reservation.resultRes;
import com.resHotel.grpc.reservationGrpc.reservationImplBase;

import io.grpc.stub.StreamObserver;

public class HotelService extends reservationImplBase   {
	Hotel hotel;
	public HotelService() {
		hotel=new Hotel();	
	}
	@Override
	public void afficherChambreDispo(c request, StreamObserver<resultRes> responseObserver) {		
		resultRes.Builder response= resultRes.newBuilder();
		response.setChambreDispo(hotel.getChambreDispo(LocalDate.parse(request.getDateDeb()+""), LocalDate.parse(request.getDateFin()+""), request.getNbPersonne(),request.getPrix()));
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void reserverChambre(CritereReservation request, StreamObserver<ApiRes> responseObserver) {
		ApiRes.Builder response= ApiRes.newBuilder();
		String ref="";
		if(hotel.verifyChambreDispo(request.getNumChambre(), LocalDate.parse(request.getDateDeb()+""), LocalDate.parse(request.getDateFin()+""))){			
			ref =hotel.createReservation(request.getNomClient(), request.getPrenomClient(), request.getNumChambre(), LocalDate.parse(request.getDateDeb()+""), LocalDate.parse(request.getDateFin()+""));
			response.setReponseCode(0).setResMessage("reservation crée avec succès.\nRéférence de réservation "+ref+ " Veuillez la gardez SVP, vous en aurez besoins en cas d'annulation");			
		}else response.setReponseCode(1).setResMessage("echec de reservatrion")	;	
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

	@Override
	public void deleteReservation(deleteRef request, StreamObserver<deleteResultat> responseObserver) {
		deleteResultat.Builder response = deleteResultat.newBuilder();
		if(hotel.deleteReservation(request.getRefReservation())) response.setReponseCode(0).setResMessage("Reservation "+request.getRefReservation()+" supprimée");
		else response.setReponseCode(0).setResMessage("Echec de suppression de la Reservation "+request.getRefReservation());
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}


}
