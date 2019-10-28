package com.monika;

import java.io.*;

import java.net.*;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServer {



    static ArrayList<String> userNames = new ArrayList<String>();

    static ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();



    public static void main(String[] args) throws Exception{

        // TODO Auto-generated method stub

        System.out.println("Waiting for clients...");

        ServerSocket ss = new ServerSocket(9806);

        while (true)

        {

            Socket soc = ss.accept();

            System.out.println("Connection established");

            ConversationHandler handler = new ConversationHandler(soc);

            handler.start();

        }



    }

}

class ConversationHandler extends Thread

{

    Socket socket;

    BufferedReader in;

    PrintWriter out;

    String name;

    PrintWriter pw;

    static FileWriter fw;

    static BufferedWriter bw;



    public ConversationHandler(Socket socket) throws IOException {

        this.socket = socket;

        fw = new FileWriter("/home/monika/table/abc.txt",true);

        bw = new BufferedWriter(fw);

        pw = new PrintWriter(bw,true);

    }

    public void run()

    {   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        try

        {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);



            int count = 0;

            while (true)

            {

                if(count > 0)

                {

                    out.println("NAMEALREADYEXISTS");

                }

                else

                {

                    out.println("NAMEREQUIRED");

                }



                name = in.readLine();



                if (name == null)

                {

                    return;

                }



                if (!ChatServer.userNames.contains(name))

                {

                    ChatServer.userNames.add(name);

                    break;

                }

                count++;

            }



            out.println("NAMEACCEPTED"+name);

            ChatServer.printWriters.add(out);



            while (true)

            {

                String message = in.readLine();



                if (message == null)

                {

                    return;

                }



                pw.println(name + ", [ " + formatter.format(date) + " ] ," + message);

                for (PrintWriter writer : ChatServer.printWriters) {

                    writer.println(name + ", [ " + formatter.format(date) + " ] ," + message);

                }

            }



        }

        catch (Exception e)

        {

            System.out.println(e);

        }

    }

}