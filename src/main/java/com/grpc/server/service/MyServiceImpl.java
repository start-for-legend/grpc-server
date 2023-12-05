package com.grpc.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.chb.examples.lib.HelloReply;
import org.chb.examples.lib.HelloRequest;

@GrpcService
public class MyServiceImpl {

    public void sayHello(HelloRequest request, StreamObserver<HelloReply> response) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        response.onNext(reply);
        response.onCompleted();
    }
}
