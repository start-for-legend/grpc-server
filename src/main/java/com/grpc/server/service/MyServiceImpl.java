package com.grpc.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.chb.examples.lib.HelloReply;
import org.chb.examples.lib.HelloRequest;
import org.chb.examples.lib.SimpleGrpc;

@GrpcService
public class MyServiceImpl extends SimpleGrpc.SimpleImplBase{

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> response) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        response.onNext(reply);
        response.onCompleted();
    }
}
