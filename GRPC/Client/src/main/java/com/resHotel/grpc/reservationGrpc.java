package com.resHotel.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: reservation.proto")
public final class reservationGrpc {

  private reservationGrpc() {}

  public static final String SERVICE_NAME = "reservation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.c,
      com.resHotel.grpc.Reservation.resultRes> getAfficherChambreDispoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "afficherChambreDispo",
      requestType = com.resHotel.grpc.Reservation.c.class,
      responseType = com.resHotel.grpc.Reservation.resultRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.c,
      com.resHotel.grpc.Reservation.resultRes> getAfficherChambreDispoMethod() {
    io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.c, com.resHotel.grpc.Reservation.resultRes> getAfficherChambreDispoMethod;
    if ((getAfficherChambreDispoMethod = reservationGrpc.getAfficherChambreDispoMethod) == null) {
      synchronized (reservationGrpc.class) {
        if ((getAfficherChambreDispoMethod = reservationGrpc.getAfficherChambreDispoMethod) == null) {
          reservationGrpc.getAfficherChambreDispoMethod = getAfficherChambreDispoMethod = 
              io.grpc.MethodDescriptor.<com.resHotel.grpc.Reservation.c, com.resHotel.grpc.Reservation.resultRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation", "afficherChambreDispo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.c.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.resultRes.getDefaultInstance()))
                  .setSchemaDescriptor(new reservationMethodDescriptorSupplier("afficherChambreDispo"))
                  .build();
          }
        }
     }
     return getAfficherChambreDispoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.CritereReservation,
      com.resHotel.grpc.Reservation.ApiRes> getReserverChambreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reserverChambre",
      requestType = com.resHotel.grpc.Reservation.CritereReservation.class,
      responseType = com.resHotel.grpc.Reservation.ApiRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.CritereReservation,
      com.resHotel.grpc.Reservation.ApiRes> getReserverChambreMethod() {
    io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.CritereReservation, com.resHotel.grpc.Reservation.ApiRes> getReserverChambreMethod;
    if ((getReserverChambreMethod = reservationGrpc.getReserverChambreMethod) == null) {
      synchronized (reservationGrpc.class) {
        if ((getReserverChambreMethod = reservationGrpc.getReserverChambreMethod) == null) {
          reservationGrpc.getReserverChambreMethod = getReserverChambreMethod = 
              io.grpc.MethodDescriptor.<com.resHotel.grpc.Reservation.CritereReservation, com.resHotel.grpc.Reservation.ApiRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation", "reserverChambre"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.CritereReservation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.ApiRes.getDefaultInstance()))
                  .setSchemaDescriptor(new reservationMethodDescriptorSupplier("reserverChambre"))
                  .build();
          }
        }
     }
     return getReserverChambreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.deleteRef,
      com.resHotel.grpc.Reservation.deleteResultat> getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteReservation",
      requestType = com.resHotel.grpc.Reservation.deleteRef.class,
      responseType = com.resHotel.grpc.Reservation.deleteResultat.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.deleteRef,
      com.resHotel.grpc.Reservation.deleteResultat> getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<com.resHotel.grpc.Reservation.deleteRef, com.resHotel.grpc.Reservation.deleteResultat> getDeleteReservationMethod;
    if ((getDeleteReservationMethod = reservationGrpc.getDeleteReservationMethod) == null) {
      synchronized (reservationGrpc.class) {
        if ((getDeleteReservationMethod = reservationGrpc.getDeleteReservationMethod) == null) {
          reservationGrpc.getDeleteReservationMethod = getDeleteReservationMethod = 
              io.grpc.MethodDescriptor.<com.resHotel.grpc.Reservation.deleteRef, com.resHotel.grpc.Reservation.deleteResultat>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "reservation", "deleteReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.deleteRef.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.resHotel.grpc.Reservation.deleteResultat.getDefaultInstance()))
                  .setSchemaDescriptor(new reservationMethodDescriptorSupplier("deleteReservation"))
                  .build();
          }
        }
     }
     return getDeleteReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static reservationStub newStub(io.grpc.Channel channel) {
    return new reservationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static reservationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new reservationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static reservationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new reservationFutureStub(channel);
  }

  /**
   */
  public static abstract class reservationImplBase implements io.grpc.BindableService {

    /**
     */
    public void afficherChambreDispo(com.resHotel.grpc.Reservation.c request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.resultRes> responseObserver) {
      asyncUnimplementedUnaryCall(getAfficherChambreDispoMethod(), responseObserver);
    }

    /**
     */
    public void reserverChambre(com.resHotel.grpc.Reservation.CritereReservation request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.ApiRes> responseObserver) {
      asyncUnimplementedUnaryCall(getReserverChambreMethod(), responseObserver);
    }

    /**
     */
    public void deleteReservation(com.resHotel.grpc.Reservation.deleteRef request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.deleteResultat> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAfficherChambreDispoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.resHotel.grpc.Reservation.c,
                com.resHotel.grpc.Reservation.resultRes>(
                  this, METHODID_AFFICHER_CHAMBRE_DISPO)))
          .addMethod(
            getReserverChambreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.resHotel.grpc.Reservation.CritereReservation,
                com.resHotel.grpc.Reservation.ApiRes>(
                  this, METHODID_RESERVER_CHAMBRE)))
          .addMethod(
            getDeleteReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.resHotel.grpc.Reservation.deleteRef,
                com.resHotel.grpc.Reservation.deleteResultat>(
                  this, METHODID_DELETE_RESERVATION)))
          .build();
    }
  }

  /**
   */
  public static final class reservationStub extends io.grpc.stub.AbstractStub<reservationStub> {
    private reservationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private reservationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected reservationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new reservationStub(channel, callOptions);
    }

    /**
     */
    public void afficherChambreDispo(com.resHotel.grpc.Reservation.c request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.resultRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAfficherChambreDispoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reserverChambre(com.resHotel.grpc.Reservation.CritereReservation request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.ApiRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReserverChambreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteReservation(com.resHotel.grpc.Reservation.deleteRef request,
        io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.deleteResultat> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class reservationBlockingStub extends io.grpc.stub.AbstractStub<reservationBlockingStub> {
    private reservationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private reservationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected reservationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new reservationBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.resHotel.grpc.Reservation.resultRes afficherChambreDispo(com.resHotel.grpc.Reservation.c request) {
      return blockingUnaryCall(
          getChannel(), getAfficherChambreDispoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.resHotel.grpc.Reservation.ApiRes reserverChambre(com.resHotel.grpc.Reservation.CritereReservation request) {
      return blockingUnaryCall(
          getChannel(), getReserverChambreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.resHotel.grpc.Reservation.deleteResultat deleteReservation(com.resHotel.grpc.Reservation.deleteRef request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class reservationFutureStub extends io.grpc.stub.AbstractStub<reservationFutureStub> {
    private reservationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private reservationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected reservationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new reservationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.resHotel.grpc.Reservation.resultRes> afficherChambreDispo(
        com.resHotel.grpc.Reservation.c request) {
      return futureUnaryCall(
          getChannel().newCall(getAfficherChambreDispoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.resHotel.grpc.Reservation.ApiRes> reserverChambre(
        com.resHotel.grpc.Reservation.CritereReservation request) {
      return futureUnaryCall(
          getChannel().newCall(getReserverChambreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.resHotel.grpc.Reservation.deleteResultat> deleteReservation(
        com.resHotel.grpc.Reservation.deleteRef request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AFFICHER_CHAMBRE_DISPO = 0;
  private static final int METHODID_RESERVER_CHAMBRE = 1;
  private static final int METHODID_DELETE_RESERVATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final reservationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(reservationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AFFICHER_CHAMBRE_DISPO:
          serviceImpl.afficherChambreDispo((com.resHotel.grpc.Reservation.c) request,
              (io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.resultRes>) responseObserver);
          break;
        case METHODID_RESERVER_CHAMBRE:
          serviceImpl.reserverChambre((com.resHotel.grpc.Reservation.CritereReservation) request,
              (io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.ApiRes>) responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation((com.resHotel.grpc.Reservation.deleteRef) request,
              (io.grpc.stub.StreamObserver<com.resHotel.grpc.Reservation.deleteResultat>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class reservationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    reservationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.resHotel.grpc.Reservation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("reservation");
    }
  }

  private static final class reservationFileDescriptorSupplier
      extends reservationBaseDescriptorSupplier {
    reservationFileDescriptorSupplier() {}
  }

  private static final class reservationMethodDescriptorSupplier
      extends reservationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    reservationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (reservationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new reservationFileDescriptorSupplier())
              .addMethod(getAfficherChambreDispoMethod())
              .addMethod(getReserverChambreMethod())
              .addMethod(getDeleteReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
