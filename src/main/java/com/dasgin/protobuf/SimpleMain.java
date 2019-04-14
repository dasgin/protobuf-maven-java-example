package com.dasgin.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        SimpleMessage message = builder.build();
        // System.out.println(builder);
        System.out.println(message);

        writerMessageToFile(message);
        readMessageFromFile();

        // send as byte array
        // byte[] bytes = message.toByteArray();
    }

    private static void writerMessageToFile(SimpleMessage message) {
        try{
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMessageFromFile() {
        try {
            System.out.println("Reading from file..");
            FileInputStream inputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);
            System.out.println(messageFromFile);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
