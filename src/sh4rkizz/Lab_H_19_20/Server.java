package sh4rkizz.Lab_H_19_20;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;

public class Server {
    private static int customPort = 1500;
    private final static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        messenger();
    }

    private static void messenger() throws IOException {
        int port = 1337;
        String packetAddress;
        final String messageHistoryAddress = "src/sh4rkizz/Lab_H_19_20/history.txt";
        final String serverBackupAddress = "src/sh4rkizz/Lab_H_19_20/serverBackup.txt";
        byte[] buffer = new byte[8191];
        DatagramSocket socket = new DatagramSocket(port);
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        // Recover users from serverBackup.txt
        usersRecovery(serverBackupAddress);

        // Start the chat
        try (PrintWriter writer = new PrintWriter(messageHistoryAddress)) {
            writer.write("sharkizz`s group chat\n");
        } catch (Exception e) {
            System.out.println("Char is not working properly");
        }

        while (true) {
            socket.receive(packet);
            packetAddress = packet.getAddress().toString();

            if (isNewUser(packetAddress))
                try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(serverBackupAddress, true))) {
                    users.put(packetAddress, new String(buffer, 0, packet.getLength()));
                    bufferWriter.write(users.get(packetAddress) + " " + packetAddress + "\n");
                    System.out.println(dateCheck() + "\n" + users.get(packetAddress) + " присоединился к чату");
                } catch (IOException ioException) {
                    System.out.println("An error occurred when the serverBackup.txt editing conducted");
                    ioException.printStackTrace();
                }
            else
                try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(messageHistoryAddress, true))) {
                    String message = dateCheck() + "\n" + users.get(packetAddress)
                            + ": " + new String(buffer, 0, packet.getLength());

                    bufferWriter.write(message + "\n");
                    userReply(message, socket);
                } catch (IOException ioException) {
                    System.out.println("An error occurred when the history.txt editing conducted");
                    ioException.printStackTrace();
                    break;
                }
        }
    }

    private static void usersRecovery(String serverBackupAddress) throws IOException {
        String buffLine;
        String[] line;

        try (BufferedReader reader = new BufferedReader(new FileReader(serverBackupAddress))) {
            buffLine = reader.readLine();

            while (buffLine != null) {
                line = buffLine.split(" ");
                users.put(line[1], line[0]);

                buffLine = reader.readLine();
            }

            System.out.println("Former chat participants:");
            for (String str : users.keySet())
                System.out.println(users.get(str));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Recovery file was not found");
        }
    }

    private static void userReply(String message, DatagramSocket socket) throws IOException {
        final String sendTo = "255.255.255.255";
        DatagramPacket outPacket = new DatagramPacket(message.getBytes(), 0, message.length(),
                InetAddress.getByName(sendTo), customPort);

        socket.send(outPacket);
        customPort++;
    }

    private static boolean isNewUser(String address) {
        return !users.containsKey(address);
    }

    private static String dateCheck() {
        String[] date = new Date().toString().split(" ");
        String[] time = date[3].split(":");

        return "\n" + date[2] + " " + date[1] + " " + date[5] + " " + time[0] + "." + time[1];
    }
}