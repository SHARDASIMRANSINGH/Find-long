package com.jdbc.expensemgtsys;


import java.io.IOException;

/**
 * Hello world!
 * THIS IS EXPENSE MNAGEMENT SYSTEM
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        System.out.println( "~EXPENSE MANAGEMENT SYSTEM~" );
        Menu menu=new Menu();
        menu.displayMainMenu();
    }
}
