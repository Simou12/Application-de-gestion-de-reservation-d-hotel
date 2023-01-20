package com.hotel.server;



import java.io.IOException;

import com.hotel.service.HotelService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HotelServer {

	public static void main(String[] args) throws InterruptedException {
		Server server = ServerBuilder.forPort(9090).addService(new HotelService()).build();
		try {
			server.start();
			System.out.println("Hotel server started at "+server.getPort());
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
