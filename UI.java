package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public UI(){}

    public void printPolynomial(Polinom p){       //function to print a polynomial
        System.out.print("P= ");
        if(p.getDegree()==-1)System.out.print(0);
        else
            for (int i=0; i<=p.getDegree(); i++) {
                //if (polynomial[i] != 0) {
                System.out.print(p.getEl(i));
                if (i != 0) {
                    System.out.print("x^" + i);
                }
                if (i != p.getDegree()) {
                    System.out.print(" + ");
                }
            }
        System.out.println();
    }
    public static int printMenu(){      //function that prints the menu and receives the option
        System.out.println("\n MENU:");
        System.out.println("    1) give the first polynomial");
        System.out.println("    2) give the second polynomial");
        System.out.println("    3) see the sum");
        System.out.println("    4) see the product");
        System.out.println("    0) Exit \n");
        Scanner s=new Scanner(System.in);
        int option;
        try{option=s.nextInt();
            return option;}
        catch(Exception var) {
            System.out.println("Wrong! give integer");
            return printMenu();}
    }

    public Polinom getPolynomial(){     //function that gets a  polynomial
        ArrayList<Integer> p1 = new ArrayList<>();
        try{
            System.out.println("what degree will the polynomial have?");
            Scanner scn = new Scanner(System.in);
            int degr = scn.nextInt();
            for(int i=0;i<=degr;i++){
                System.out.print("val for the elem with the degree "+i);
                p1.add(scn.nextInt());
            }
            Polinom polin=new Polinom(p1);
            return polin;
        }
        catch(Exception var) {
            System.out.println("Wrong! give integer");
            return getPolynomial();}
    }

    public void Main(){     //control
        int opt=printMenu();
        Polinom polin1=new Polinom();
        Polinom polin2=new Polinom();
        Polinom polin3=new Polinom();
        Polinom polin4=new Polinom();
        while(opt!=0){
            switch(opt){
                //case 0: {System.out.println("bye..."); break;}
                case 1: {polin1.setEmptyPolynomial(getPolynomial()); printPolynomial(polin1);break;}
                case 2: {polin2.setEmptyPolynomial(getPolynomial());printPolynomial(polin2);break;}
                case 3: {polin3.setEmptyPolynomial(polin1.addPolynomials(polin2));printPolynomial(polin3);break;}
                case 4: {polin4.setEmptyPolynomial(polin1.multiplyPolynomials(polin2));printPolynomial(polin4);break;}
                default: {System.out.println("wrong option");}
                }
            opt=printMenu();
            }
        System.out.println("bye...");

        }
}
