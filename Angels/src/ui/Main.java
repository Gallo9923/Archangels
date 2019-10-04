package ui;
import model.*;

import java.util.Scanner;

public class Main
{
	
	//Atributes
	
	private Legion legion; 
	private Scanner scStr;
	private Scanner scNum;
	
	//MAIN
	
	public static void main(String[] args)
	{
		
		//inicializo a la legion
		Main obj = new Main("Maxima Superior");
		
		// Inicializo los primeros poderes
		obj.createPower("Proteccion");
		obj.createPower("SALUD");
		obj.createPower("ABUNDANCIA");
		obj.createPower("JUSTICIA");
		obj.createPower("LEALTAD");
		
		obj.createCandle("AZUL", Candle.BIG, Candle.BANANA, Candle.LOW);
		
		obj.createArchangel("Rafael", "foto1.jpg", "Alabado seas", 1, 1, obj.legion.getPower(0), obj.legion.getCandle(0));
		//obj.createArchangel("Miguel", "foto2.jpg", "Alabado seas", 15, 1, obj.legion.getPower(1), obj.legion.getCandle(0));
		
		// Inicilizo los Scanner
		
		boolean mainMenu = true;
		
		
		int userInput = 0;
		
		while(mainMenu)
		{
			System.out.println("-------------------- MENU --------------------");
			System.out.println("1: Ingresar Arcangeles \n2: Contar Arcangeles"
			+ " \n3: Desplegar informacion del arcangel dado su nombre" 
			+ " \n4: Desplegar informacion del arcangel dado su poder"
			+ " \n5: Desplegar todas las celebraciones"
			+ " \n6: Desplegar las celebraciones dado un mes"
			+ " \n7: Crear una vela"
			+ " \n8: Salir \nEscoja una opcion");
			
			
			userInput = obj.scNum.nextInt();
			
			switch (userInput)
			{
				case 1:
					obj.createArchangel();
					break;
				case 2: 
					obj.countArchangels();
					break;
				case 3:
					obj.searchArchByName();
					break;
				case 4: 
					obj.searchArchByPower();
					break;
				case 5: 
					obj.displayCelebs();
					break;
				case 6: 
					obj.displayCelebsByMonth();
					break;
				case 7: 
					obj.createCandle();
					break;
				case 8:
					System.out.println("El programa ha finalizado");
					mainMenu = false;
					break;
			}
			
		}
		
	}
	
	// Constructor
	
	public Main(String name)
	{
		legion = new Legion(name);
		scStr = new Scanner(System.in);
		scNum = new Scanner(System.in);
	}
	
	//Methods 
	
	public void displayCelebs()
	{
		String celebs = legion.displayCelebs();
		System.out.println(celebs);
	
	}
	
	public void displayCelebsByMonth()
	{
		System.out.println("Digite el mes de la celebracion");
		int month = scNum.nextInt();
		
		String celebs = legion.displayCelebsByMonth(month);
		
		System.out.println(celebs);
		
	}

	
	public void searchArchByName()
	{	
		System.out.println("Digite el nombre del arcangel");
		String name2find = scStr.nextLine();
		
		Archangel arch = legion.searchArchByName(name2find);
		
		String ans = legion.displayArchInfo(arch);
		System.out.println(ans);
	}
	
	public void searchArchByPower()
	{
		System.out.println("Los poderes son: " + legion.displayPowers());
		
		System.out.println("Digite el numero del poder del arcangel");
		int intInput= scNum.nextInt();
		
		Power power = null;
		
		switch (intInput)
		{
			case 1:
			case 2: 
			case 3: 
			case 4:
			case 5:
			case 6: 
			case 7:
			case 8: 
			case 9: 
			case 10:
				power = legion.getPower(intInput-1);
				break;
			default:
				break;
		}		
		
		Archangel arch = legion.searchArchByPower(power);
		
		String ans = legion.displayArchInfo(arch);
		System.out.println(ans);
	}
	
	public void countArchangels()
	{
		System.out.println("El numero de arcangeles es: " + legion.countArchangels());
	
	}
	
	public void createCandle(String color, String size, String essence, String brightness)
	{
		legion.createCandle(color, size, essence, brightness);
		
	}
	
	public void createCandle()
	{
		System.out.println("--- Inicio creacion de vela ---");
		
		System.out.println("Escriba el color de la vela");
		String color = scStr.nextLine();
		
		System.out.println("Escriba el tamano de la vela (1: " + Candle.BIG + "; 2: " + Candle.MEDIUM + "; 3: " + Candle.SMALL + ")");
		int input = scNum.nextInt();
		String size = "";
		
		switch (input)
		{
			case 1: 
				size = Candle.BIG; 
				break;
			case 2:
				size = Candle.MEDIUM;
				break;
			case 3: 
				size = Candle.SMALL;
				break; 
		}	
		
		System.out.println("Escriba el Esencia de la vela (1: " + Candle.BANANA + "; 2: " + Candle.MILK + "; 3: " + Candle.SUGAR + ")");
		input = scNum.nextInt();
		String essence = "";
		
		switch (input)
		{
			case 1: 
				essence = Candle.BANANA; 
				break;
			case 2:
				essence = Candle.MILK;
				break;
			case 3: 
				essence = Candle.SUGAR;
				break; 
		}	
		
		System.out.println("Escriba el brillo de la vela (1: " + Candle.HIGH + "; 2: " + Candle.BMEDIUM + "; 3: " + Candle.LOW + ")");
		input = scNum.nextInt();
		String brightness = "";
		
		switch (input)
		{
			case 1: 
				brightness = Candle.BIG; 
				break;
			case 2:
				brightness = Candle.MEDIUM;
				break;
			case 3: 
				brightness = Candle.SMALL;
				break; 
		}	
		
		legion.createCandle(color, size, essence, brightness);
		
	}
	
	public void createArchangel(String name, String picture, String prayer, int day, int month, Power power, Candle candle)
	{
		legion.createArchangel(name, picture, prayer, day, month, power, candle);
	}

	public void createArchangel()
	{
		int intInput = 0;
		
		
		System.out.println("--- Inicio creacion del arcangel ---");
		
		System.out.println("Digite el nombre del arcangel");
		String name = scStr.nextLine();
		
		System.out.println("Digite la ruta de la imagen del arcangel");
		String picture = scStr.nextLine();
		
		System.out.println("Digite la oracion del arcangel");
		String prayer = scStr.nextLine();
		
		System.out.println("Digite el dia de la celebracion del arcangel");
		int day = scNum.nextInt();
		
		System.out.println("Digite el mes de la celebracion del arcangel");
		int month = scNum.nextInt();
		
		System.out.println("Escoja una de los siguientes poderes:");
		System.out.println(legion.displayPowers());
		intInput = scNum.nextInt();
		Power power = null;
		
		switch (intInput)
		{
			case 1:
			case 2: 
			case 3: 
			case 4:
			case 5:
			case 6: 
			case 7:
			case 8: 
			case 9: 
			case 10:
				power = legion.getPower(intInput-1);
				break;
			default:
				break;
		}		
		
		System.out.println("Escoja una de las siguientes velas:");
		System.out.println(legion.displayCandles());
		intInput = scNum.nextInt();
		Candle candle = null;
		
		switch (intInput)
		{
			case 1:
			case 2: 
			case 3: 
			case 4:
			case 5:
			case 6: 
			case 7:
			case 8: 
			case 9: 
			case 10:
				candle = legion.getCandle(intInput-1);
				break;
			default:
				break;
		}		
		
		String ans = legion.createArchangel(name, picture, prayer, day, month, power, candle);
		System.out.println(ans);
		
	}
	
	
	public Power getPower(int integer)
	{
		return legion.getPower(integer);
	}
	
	public void displayPowers()
	{
		System.out.println(legion.displayPowers());
	}
	
	
	public String createPower()
	{
		System.out.println("--- Inicio creacion del poder ---");
		
		System.out.println("Digite el nombre del poder");
		String name= scStr.nextLine();
		
		String ans = legion.createPower(name);
		
		return ans;

	}
	
	public String createPower(String name)
	{
		legion.createPower(name);
		
		return "";
		
	}
	
	
	
}