package com.dasgin.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import static example.simple.Simple.SimpleMessage;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        SimpleMessage simpleMessage = builder.setName("mustafa").setId(123).setIsSimple(true).build();

        String jsonString = JsonFormat.printer().includingDefaultValueFields().print(builder);
        System.out.println(jsonString);


        // parse json into protobuf
        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();

        JsonFormat.parser().ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2);
    }
}
