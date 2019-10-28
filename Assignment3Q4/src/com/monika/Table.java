package com.monika;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Table extends JFrame
{
    int i=0;
    int j=0,k=0;
    Object data[][]=new Object[5][3];
    Object list[][]=new Object[5][3];
    JButton save;
    JTable table1;
    FileInputStream fis;
    DataInputStream dis;
    public Table()
    {
        String d= " ";
        Container con=getContentPane();
        con.setLayout(new BorderLayout());
        final String[] colHeads={"ClientName","ArrivalTime","MessageText"};
        try
        {
            String s=JOptionPane.showInputDialog("Enter the File name present in the current directory");
            FileInputStream fis=new FileInputStream(s);
            DataInputStream dis = new DataInputStream(fis);
            while ((d=dis.readLine())!=null)
            {
                StringTokenizer st1=new StringTokenizer(d,",");
                while (st1.hasMoreTokens())
                {
                    for (j=0;j<3;j++)
                    {
                        data[i][j]=st1.nextToken();
                        System.out.println(data[i][j]);
                    }
                    i++;
                }
                System.out.println ("______________");
            }
        } catch (Exception e)
        {
            System.out.println ("Exception raised" +e.toString());
        }
        table1=new JTable(data,colHeads);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane scroll=new JScrollPane(table1,v,h);
        con.add(scroll,BorderLayout.CENTER);
    }
    public static void main(String args[])
    {
        Table t=new Table();
        t.setBackground(Color.green);
        t.setTitle("Display Data");
        t.setSize(500,300);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } }