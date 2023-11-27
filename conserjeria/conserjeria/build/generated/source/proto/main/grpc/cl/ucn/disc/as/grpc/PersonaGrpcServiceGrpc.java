package cl.ucn.disc.as.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: persona.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PersonaGrpcServiceGrpc {

  private PersonaGrpcServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "conserjeria.PersonaGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cl.ucn.disc.as.grpc.PersonaGrpcRequest,
      cl.ucn.disc.as.grpc.PersonaGrpcResponse> getRetrieveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "retrieve",
      requestType = cl.ucn.disc.as.grpc.PersonaGrpcRequest.class,
      responseType = cl.ucn.disc.as.grpc.PersonaGrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cl.ucn.disc.as.grpc.PersonaGrpcRequest,
      cl.ucn.disc.as.grpc.PersonaGrpcResponse> getRetrieveMethod() {
    io.grpc.MethodDescriptor<cl.ucn.disc.as.grpc.PersonaGrpcRequest, cl.ucn.disc.as.grpc.PersonaGrpcResponse> getRetrieveMethod;
    if ((getRetrieveMethod = PersonaGrpcServiceGrpc.getRetrieveMethod) == null) {
      synchronized (PersonaGrpcServiceGrpc.class) {
        if ((getRetrieveMethod = PersonaGrpcServiceGrpc.getRetrieveMethod) == null) {
          PersonaGrpcServiceGrpc.getRetrieveMethod = getRetrieveMethod =
              io.grpc.MethodDescriptor.<cl.ucn.disc.as.grpc.PersonaGrpcRequest, cl.ucn.disc.as.grpc.PersonaGrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "retrieve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cl.ucn.disc.as.grpc.PersonaGrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cl.ucn.disc.as.grpc.PersonaGrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PersonaGrpcServiceMethodDescriptorSupplier("retrieve"))
              .build();
        }
      }
    }
    return getRetrieveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonaGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceStub>() {
        @java.lang.Override
        public PersonaGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonaGrpcServiceStub(channel, callOptions);
        }
      };
    return PersonaGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonaGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceBlockingStub>() {
        @java.lang.Override
        public PersonaGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonaGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return PersonaGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonaGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PersonaGrpcServiceFutureStub>() {
        @java.lang.Override
        public PersonaGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PersonaGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return PersonaGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void retrieve(cl.ucn.disc.as.grpc.PersonaGrpcRequest request,
        io.grpc.stub.StreamObserver<cl.ucn.disc.as.grpc.PersonaGrpcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PersonaGrpcService.
   */
  public static abstract class PersonaGrpcServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PersonaGrpcServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PersonaGrpcService.
   */
  public static final class PersonaGrpcServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PersonaGrpcServiceStub> {
    private PersonaGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonaGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonaGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void retrieve(cl.ucn.disc.as.grpc.PersonaGrpcRequest request,
        io.grpc.stub.StreamObserver<cl.ucn.disc.as.grpc.PersonaGrpcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PersonaGrpcService.
   */
  public static final class PersonaGrpcServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PersonaGrpcServiceBlockingStub> {
    private PersonaGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonaGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonaGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cl.ucn.disc.as.grpc.PersonaGrpcResponse retrieve(cl.ucn.disc.as.grpc.PersonaGrpcRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PersonaGrpcService.
   */
  public static final class PersonaGrpcServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PersonaGrpcServiceFutureStub> {
    private PersonaGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersonaGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersonaGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cl.ucn.disc.as.grpc.PersonaGrpcResponse> retrieve(
        cl.ucn.disc.as.grpc.PersonaGrpcRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RETRIEVE:
          serviceImpl.retrieve((cl.ucn.disc.as.grpc.PersonaGrpcRequest) request,
              (io.grpc.stub.StreamObserver<cl.ucn.disc.as.grpc.PersonaGrpcResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRetrieveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cl.ucn.disc.as.grpc.PersonaGrpcRequest,
              cl.ucn.disc.as.grpc.PersonaGrpcResponse>(
                service, METHODID_RETRIEVE)))
        .build();
  }

  private static abstract class PersonaGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonaGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cl.ucn.disc.as.grpc.Persona.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonaGrpcService");
    }
  }

  private static final class PersonaGrpcServiceFileDescriptorSupplier
      extends PersonaGrpcServiceBaseDescriptorSupplier {
    PersonaGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class PersonaGrpcServiceMethodDescriptorSupplier
      extends PersonaGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PersonaGrpcServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PersonaGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonaGrpcServiceFileDescriptorSupplier())
              .addMethod(getRetrieveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
