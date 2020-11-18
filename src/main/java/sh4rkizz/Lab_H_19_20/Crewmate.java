package sh4rkizz.Lab_H_19_20;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Crewmate {
    private static int customPort = 1500;

    public static void main(String[] args) throws InterruptedException {
        messenger();
    }

    private static void messenger() throws InterruptedException {
        System.out.println("Вы вошли в sharkizz`s chat");

        SendMessageThread sendMessageThread = new SendMessageThread();
        ReceiveMessageThread receiveMessageThread = new ReceiveMessageThread();

        sendMessageThread.start();
        receiveMessageThread.start();

        sendMessageThread.join();
        receiveMessageThread.join();
    }

    private static class SendMessageThread extends Thread {
        @Override
        public void run() {
            final String serverAddress = "192.168.0.3"; // Hub
            final Scanner scn = new Scanner(System.in);
            AtomicReference<String> message = new AtomicReference<>();

            while (true)
                try {
                    message.set(scn.nextLine());
                    sendMessage(message.toString(), new DatagramSocket(), serverAddress);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    break;
                }
        }
    }

    private static class ReceiveMessageThread extends Thread {
        @Override
        public void run() {
            while (true)
                try {
                    checkMail();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    break;
                }
        }
    }

    private static void sendMessage(String line, DatagramSocket socket, String address) throws IOException {
        final int port = 1337;

        socket.send(new DatagramPacket(line.getBytes(), 0, line.length(), InetAddress.getByName(address), port));
    }

    private static void checkMail() throws IOException {
        byte[] buffer = new byte[4096];

        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        new DatagramSocket(customPort).receive(packet);

        System.out.println(new String(buffer, 0, packet.getLength()));
        customPort++;
    }
}