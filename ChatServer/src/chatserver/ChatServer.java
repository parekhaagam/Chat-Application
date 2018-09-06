package chatserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class  ChatServer{
    public static MessageQueue<String> q = new MessageQueue<>();
    public static MessageQueue<String> allMessage = new MessageQueue<>();
    public static ArrayList<PrintWriter> noslist = new ArrayList<>();
    static String name;
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8096);
        
        MessageDispacther md = new MessageDispacther();
        md.setDaemon(true);
        md.start();
        for( int i = 0 ; i < 10 ; i++)
        {
            Socket soc = ss.accept();
            System.out.println("Connection established");
            
            
            BufferedReader nis = new BufferedReader(
                        new InputStreamReader(
                                 soc.getInputStream()
                        )
            );
            
            
            PrintWriter nos = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    soc.getOutputStream()
                                                            )
                    ), true
            );
            
            
                Conversation c = new Conversation(soc,nis,nos);
                c.start();
            }
    }
    
}


class Conversation extends Thread {
    BufferedReader nis;
    PrintWriter nos;
    Socket soc;
    Conversation(Socket soc,BufferedReader nis,PrintWriter nos) {
        this.soc = soc;
        this.nos=nos;
        this.nis=nis;
    }

    @Override
    public void run() {
        try {
            ChatServer.noslist.add(nos);
            //if user enter into room chat following is the code 
            // to send 50 previous messages sent by others
            //that messages are stored in messageQueue generic class
            if(ChatServer.allMessage.getSize() > 0){
                ArrayList<String> al=ChatServer.allMessage.getAll();
                for(String msg : al){
                    nos.println(msg);
                }
            }
            String str = nis.readLine();
            String[] retval=str.split(":");
            while (!retval[1].equalsIgnoreCase("logout")) {
                ChatServer.q.enqueue(str);
                ChatServer.allMessage.insert(str);
                str = nis.readLine();
                retval=str.split(":");
            }
            ChatServer.q.enqueue(retval[0] + " left this room");
            ChatServer.allMessage.insert(retval[0] + " left this room");
            ChatServer.noslist.remove(nos);
            soc.close();
            System.out.println("socket closed");
        } catch (Exception e) {
        }
    }
}

class MessageDispacther extends Thread {
    
    @Override
    public void run() {
        while (true) {
            try {
                String str = ChatServer.q.dequeue();
                
                for (PrintWriter o : ChatServer.noslist) {
                    o.println(str);
                }
            } catch (Exception e) {
            }
        }
    }
}    



class MessageQueue<T>{
    ArrayList<T> al=new ArrayList<>();
    ArrayList<T> messageBuffere = new ArrayList<>();
    
    synchronized public void enqueue(T i){
        al.add(i);
        notify();
            
    }
    
    synchronized public T dequeue(){
        if(al.isEmpty()){
            try{
                wait();
            }catch(Exception e){}
        }
        return al.remove(0);
    }
    
    synchronized public void insert(T i){
        if(messageBuffere.size() == 50){
            messageBuffere.remove(0);
        }
            messageBuffere.add(i);
    }
    
    synchronized public int getSize(){
        return messageBuffere.size();
    }
    
    synchronized public ArrayList<T> getAll(){
        if(!messageBuffere.isEmpty())
            return messageBuffere;
        else
            return null;
    }
    
    
    synchronized public void print(){
        for(T i:al){
            System.out.println("-->"+i);
        }
    }
    
    synchronized public String toString(){
        String str=null;
        for(T s:al){
            str+="::"+s;
        }
        return str;   
    }
    
}