package com.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lector {

    private InputStreamReader isr = new InputStreamReader(System.in);
    private BufferedReader br = new BufferedReader(isr);
    private String dato;
    private int num;
    private float numero;

    public String leeDato(){
        try{
            dato = br.readLine();
        }catch(IOException e){}
        return dato;
    }

    public int leeNum(){
        try{
            dato = br.readLine();
            num = Integer.parseInt(dato);
        }catch(IOException e){}
        return num;
    }

    public float leeFloat(){
        try{
            dato = br.readLine();
            numero = Float.parseFloat(dato);
        }catch (IOException e){}
        return numero;
    }

}
