package model;

public class Legion
{
	
	//Constants
	public static final String LAST2WORDS = "EL";
	
	//Atributes
	
	private String name; 
	
	//Relationships
	
	private Archangel[] archangels; 
	private Candle[] candles;
	private Power[] powers;
	
	
	//Constructor
	
	/**
	* Constructs a new Legion
	* <b>pre: </b> archangels must be inicialized, candles must be inicialized, powers must be inicialized
	* <b>pos: The arrays archangels, candles, powers are instantiated and the name of the legion is instantiated </b> 
	* @param name The name of the Legion
	*/
	public Legion(String name)
	{
		this.name = name;
		
		archangels = new Archangel[10];
		candles = new Candle[10];
		powers = new Power[10];
		
		
	}
	
	/**
	* Constructs a new Power
	* <b>pre:</b> The array powers is instantiated
	* <b>pos:</b> The new power has been instantiated
	* @param  name The name of the power
	* @return String information about the ejecution status
	*/
	public String createPower(String name)
	{
		boolean createPower = true;
		String ans = "";
		
		if(checkPowerExist(name) != true)
		{
			
			
			for(int i=0; i<powers.length && createPower == true; i++)
			{
				
				if(powers[i] == null)
				{
					name = name.toUpperCase();
					powers[i] = new Power(name);
					createPower = false;
					ans = "Se ha creado el poder"; 
				}
			}
		}
		
		if (createPower == true)
		{
			ans = "Error: Se ha creado el máximo de poderes";
		}
		
		return ans; 
		
	}
	
	/**
	* Checks if a given power name exist in the array powers
	* <b>pre:</b> array powers must be instantiated
	* @param name Name of the power to check if it exist
	* @return boolean True if the given power name exist
	*/
	public boolean checkPowerExist(String name)
	{
		boolean checkPowerExist = false; // doesnt exist
		
		for(int i=0; i<powers.length && checkPowerExist == false; i++)
		{
			if (powers[i] != null && powers[i].getName().equalsIgnoreCase(name))
			{
				checkPowerExist = true;
			}
		}
		
		return checkPowerExist;
	}
	
	/**
	* Constructs a new archangel
	* <b>pre:</b> Array archangels must be instantiated
	* <b>pos:</b> new archangel instantiated
	* @param name Name of the archangel
	* @param picture Name of the picture file
	* @param prayer Prayer of the archangel
	* @param day Day of celebration for the archangel
	* @param month Month of celebration for the archangel
	* @param power Power of the archangel
	* @param candle Candle of the archangel
	* @return String information about the ejecution status
	*/
	public String createArchangel(String name, String picture, String prayer, int day, int month, Power power, Candle candle)
	{
		boolean createArchangel = false;
		String ans = "";
		
		String last2Words = subString(name, name.length()-2, name.length());
		
		if (last2Words.equalsIgnoreCase(LAST2WORDS) && !existArchangelByName(name))
		{
			name = name.toUpperCase();
			for(int i=0; i<archangels.length && createArchangel == false; i++)
			{
				if (archangels[i] == null && !existArchangelByPower(power))
				{
					archangels[i] = new Archangel(name, picture, prayer, day, month, power, candle);
					createArchangel = true;
					ans = "Se ha creado el arcangel.";
				}
			}
		} else
		{
			ans += "Error: El nombre del arcangel no termina con la silaba EL o ya existe un arcangel con ese nombre";
		}
		
		if (createArchangel == false)
		{
			ans += "\nError: Se ha creado el maximo de arcangeles o el poder ya existe o la vela no es valida";
		}
		
		
		return ans;
		
	}
	
	/**
	*	Generates a subString from a String
	* 	<b> pre: </b> The length of the String str must be bigger or equal than indexStart and indexEnd
	* 	<b> pos: </b> subString is generated
	*	@param str String of which substring will be obtain
	*	@param indexStart start index inclusive to form the substring from the String
	*	@param indexEnd final index non-inclusive to form the substring from the String
	*	@return String subString
	*/
	public String subString(String str, int indexStart, int indexEnd)
	{
		String result = "";
		
		for(int i=indexStart; i < indexEnd; i++)			
		{	
			result = result + String.valueOf(str.charAt(i));
		}
		
		return result;
	}
	
	/**
	* Evaluates if an archangel exist by name
	* <b>pre:</b> array archangels must be instantiated
	* @param name Name of the archangel
	* @return boolean True if the archangel exist 
	*/
	public boolean existArchangelByName(String name)
	{
		boolean existArchangelByName = false; //doesnt exist
		
		for(int i=0; i<archangels.length && existArchangelByName == false; i++)
		{
			if( archangels[i] != null && archangels[i].getName().equalsIgnoreCase(name))
			{
				existArchangelByName = true;
			}
		}
		
		return existArchangelByName;
	}
	
	/**
	* Evaluates if an archangel exist by its power
	* <b>pre:</b> array arcangel must be instantiated
	* @param power Power of the archangel to look
	* @return boolean True if the archangel exist
	*/
	public boolean existArchangelByPower(Power power)
	{
		boolean existArchangelByPower = false; //Doesnt Exist
		
		for(int i=0; i<archangels.length && existArchangelByPower == false; i++)
		{
			if(archangels[i] != null && archangels[i].getPower() == power)
			{
				existArchangelByPower = true; // Exist
			}
		}
		
		return existArchangelByPower;
	}
	
	/**
	* Constructs a new Candle
	* <b>pre:</b> array candles must be instantiated
	* <b>pos:</b> a new candle is instantiated
	* @param color Color of the candle
	* @param size Size of the candle
	* @param essence Essence of the candle
	* @param brightness Brightness of the candle
	* @return String Constains information about the ejecution status
	*/
	public String createCandle(String color, String  size, String essence, String brightness)
	{
		
		String  ans = "";
		boolean createCandle = false;
		
		for (int i=0; i<candles.length && createCandle == false; i++)
		{
			if(candles[i] == null) 
			{
				candles[i] = new Candle(color, size, essence, brightness);
				createCandle = true;
				ans = "La vela se ha creado";
			}
		}
		
		if(createCandle == false)
		{
			ans = "Se ha creado el maximo numero de velas";
		}
		
		return ans;
	}
	
	/**
	* Counts the amount of archangels in the legion
	* <b>pre:</b> array archangles must be instantiated
	* @return int Amount of archangels in the legion
	*/
	public int countArchangels()
	{
		int countArchangels = 0;
		
		for(int i=0; i<archangels.length; i++)
		{
			if (archangels[i] != null)
			{
				countArchangels++;
			}
		}
		
		return countArchangels;
	}
	
	/**
	* Displays all the information related to an archangel
	* @param arch Archangel to be displayed its information
	* @return String Contains all the information about the archangel
	*/
	public String displayArchInfo(Archangel arch)
	{
		String info = "";
		
		if (arch == null)
		{
			info = "El arcangel no se ha encontrado";
		} else
		{
			info = "---- Informacion del arcangel ---- \nNombre: " + arch.getName() + "\nFoto: " + arch.getPicture() 
					+ "\nOracion: " + arch.getPrayer() + "\nDia: " + arch.getDay() + "\nMes: " + arch.getMonth()
					+ "\nPoder: " + arch.getPowerName() + "\nInformacion Vela: \n    Color:" + arch.getCandleColor()
					+ "\n    Tamano: " + arch.getCandleSize() + "\n    Brillo: " + arch.getCandleBrightness();					
		}
		
		return info;
	}
	
	/**
	* Returns an archangel by its name
	* <b>pre:</b> array archangel must be instantiated
	* @param name Name of the archangel to look for
	* @return Archangel Archangel
	*/
	public Archangel searchArchByName(String name)
	{
		
		Archangel archangel = null;
		
		for(int i=0; i<archangels.length; i++)
		{
			if (archangels[i] != null && archangels[i].getName().equalsIgnoreCase(name))
			{
				archangel = archangels[i];
			}
		}
		return archangel;
	}
	
	/**
	* Returns an archangel by its power 
	* <b>pre:</b> array powers must be instiantiated
	* @param power Power of the archangel to look for
	* @return Archangel Archangel
	*/
	public Archangel searchArchByPower(Power power)
	{
		Archangel archangel = null;
		
		for(int i=0; i<archangels.length; i++)
		{
			if (archangels[i] != null && archangels[i].getPower() == power)
			{
				archangel = archangels[i];
			}
		}
		
		return archangel;
		
	}
	
	/**
	* Displays all the celebrations of all the archangels
	* <b>pre:</b> array archangel must be instiantiated
	* @return String List of all archangel celebrations
	*/
	public String displayCelebs()
	{
		String displayCelebs = "";
		Archangel archangel = null;
		
		for(int i=0; i<archangels.length; i++)
		{
			if (archangels[i] != null)
			{
				archangel = archangels[i];
				
				displayCelebs += "\n--- Celebracion " + (i+1) + " ---";
				displayCelebs += "\nNombre : " + archangel.getName();
				displayCelebs += "\n Dia: " + Integer.toString(archangel.getDay());
				displayCelebs += "\n Mes: " + Integer.toString(archangel.getMonth());
				
			}
		}
		
		if (archangel == null)
		{
			displayCelebs = "No se han encontrado arcangeles";
		}
		
		return displayCelebs;
	}
	
	/**
	* Displays all the celebrations of archangels in a given month of the year
	* <b>pre:</b> array archangels must be instantiated 
	* @param month Month to look for celebrations
	* @return String List of all archangel celebrations in the month
	*/
	public String displayCelebsByMonth(int month)
	{
		String displayCelebs = "";
		Archangel archangel = null;
		
		for(int i=0; i<archangels.length; i++)
		{
			if (archangels[i] != null && archangels[i].getMonth() == month)
			{
				archangel = archangels[i];
				
				displayCelebs += "\n--- Celebracion " + (i+1) + " ---"; 
				displayCelebs += "\n Nombre:" + archangel.getName();
				displayCelebs += "\n Dia: " + Integer.toString(archangel.getDay());
				displayCelebs += "\n Mes:" + Integer.toString(archangel.getMonth());
				
			}
		}
		
		if (archangel == null)
		{
			displayCelebs = "No se han encontrado arcangeles";
		}
		
		return displayCelebs;
		
	}
	
	/**
	* Displays all the powers created
	* <b>pre:</b> array powers must be instantiated
	* @return String List of all the powers created
	*/
	public String displayPowers()
	{
	
		String displayPowers = "";
		
		for(int i=0; i<powers.length; i++)
		{
			if(powers[i] != null)
			{
				displayPowers += (i+1) + ": " + powers[i].getName() + ", " ; 
			}
		}
		
		return displayPowers;
	}
	
	/**
	* Gets the power from the array powers
	* <b>pre:</b> array powers must be instantiated
	* @param pos postion of the array powers
	* @return Power Power
	*/
	public Power getPower(int pos)
	{
		Power power = null;
		
		if(powers[pos] != null)
		{
			power = powers[pos];
		}
		
		return power;
		
	}
	
	/**
	* Displays all the candles created 
	* <b>pre:</b>  array candles must be instantiated
	* @return String List of all the candles created
	*/
	public String displayCandles()
	{
		String displayCandles = "";
		
		for(int i=0; i<candles.length; i++)
		{
			if(candles[i] != null)
			{
				displayCandles += (i+1) + ": " + candles[i].getColor() + ", " ; 
			}
		}
		
		return displayCandles;
	}
	
	/**
	* Gets a candle given a position in the array candles
	* <b>pre:</b> array candles must be instantiated
	* @param pos Postion in the array candles
	* @return Candle Candle 
	*/
	public Candle getCandle(int pos)
	{
		Candle candle = null;
		
		if(candles[pos] != null)
		{
			candle = candles[pos];
		}
		
		return candle;
	}
	
}