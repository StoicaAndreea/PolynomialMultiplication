package com.company;
import java.util.ArrayList;

public class Polinom {

    private ArrayList<Integer> polynomial;
    private int degree;

    public Polinom(){       //implicit constructor
        degree=-1;
        polynomial=new ArrayList<Integer>();
    }
/*
    public Polinom(ArrayList<Integer> p, int n){        //constructor with parameters
        degree=n;
        polynomial= new ArrayList<Integer>(p);

    }*/

    public Polinom(Polinom p){      //copy constructor
        degree=p.getDegree();
        polynomial=new ArrayList<>(p.getPolynomial());
        this.arrange();
    }

    public Polinom(ArrayList<Integer> p){       //constructor with one parameter
        degree=p.size()-1;
        polynomial= new ArrayList<Integer>(p);
        this.arrange();

    }

    public void arrange(){      //function that cleans a polynomial(gets rid of null values)
        int i=getDegree();
        while(i>=0 && polynomial.get(i)==0){
            polynomial.remove(i);
            i--;
        }
        degree=i;

    }
    public ArrayList<Integer> getPolynomial(){        //function that retrieves the array
        return polynomial;
    }

     public Integer getEl(int i){       //function that retrieves an element from a position
        return polynomial.get(i);
     }

    public int getDegree(){     //function that retrieves the degree
        return degree;
    }
    public void setEmptyPolynomial(Polinom p){      //function to change the polynomial
        this.clearPolynomial();
        for(int i=0;i<=p.getDegree();i++){
            this.addEl(p.getEl(i));
        }
        degree=p.getDegree();

    }
    public void setEl(int i, Integer val){      //function that changes an element from index
        polynomial.set(i,val);
    }

    public void addEl(Integer val){     //function that adds an element
        polynomial.add(val);
        degree++;
    }

    public void clearPolynomial(){      //function that clears a polynomial
        polynomial.clear();
        degree=-1;
    }


    public int maxDegree(int n){     // function to return the maximum of two integers
        if(n>this.getDegree()) return n;
        return this.getDegree();
    }

    public Polinom addPolynomials(Polinom p){        //function that adds two polynomials
        int size= this.maxDegree(p.getDegree());
        int el;
        Polinom polin=new Polinom(this);
        if (size == this.getDegree()) {
            for (int i=0; i<=p.getDegree(); i++){
                el=polin.getEl(i);
                polin.setEl(i,el+p.getEl(i));
            }
        }
        else if (size!=this.getDegree()) {
                for(int i=this.getDegree();i<=size;i++) {
                    polin.addEl(0);
                }
                for (int i=0; i<=p.getDegree(); i++){
                    el=polin.getEl(i);
                    polin.setEl(i,el+p.getEl(i));
                 }
        }
        polin.arrange();
        return polin;
    }

    public Polinom multiplyPolynomials(Polinom p){       //function that multiplies two polynomials
        int size= this.getDegree()+ p.getDegree();
        Polinom polynomial=new Polinom();
        for(int i=0; i<=size; i++) {
            polynomial.addEl(0);
        }
        int el;
        for (int i=0; i<=this.getDegree(); i++){
            for(int j=0; j<=p.getDegree(); j++){
                el=polynomial.getEl(i+j);
                polynomial.setEl(i+j,el+this.getEl(i)*p.getEl(j));}
        }
        polynomial.arrange();
        return polynomial;
    }





/*
    public void printPolynomial(){       //function to print a polynomial
        System.out.print("P= ");
        if(this.getDegree()==-1)System.out.print(0);
        else
            for (int i=0; i<=this.getDegree(); i++) {
                //if (polynomial[i] != 0) {
                System.out.print(this.getEl(i));
                if (i != 0) {
                    System.out.print("x^" + i);
                }
                if (i != this.getDegree()) {
                    System.out.print(" + ");
                }
            }
        System.out.println();
    }*/
}