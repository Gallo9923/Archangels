package model;

public class Archangel
{

	//Atributes
	
	private String name; 
	private String picture;
	private String prayer;
	private int day;
	private int month;
	
	
	//Relationships
	
	private Power power; 
	private Candle candle; 
	
	//Constructors
	
	/**
	* Constructs a new archangel
	* <b>pos:</b> a new archangel is instantiated
	* @param name Name of the archangel
	* @param picture Name of the picture file
	* @param prayer Prayer of the archangel
	* @param day Day of celebration for the archangel
	* @param month Month of celebration for the archangel
	* @param power Power of the archangel
	* @param candle Candle of the archangel
	* @return String information about the ejecution status
	*/
	public Archangel(String name, String picture, String prayer, int day, int month, Power power, Candle candle)
	{
		
		this.name = name;
		
		
		if(day >= 1 && day<=30)
		{
			this.day = day;
		}
		
		if( month>=1 && month <=12)
		{
			this.month = month;
		}
		
		picture = picture.toUpperCase();
		this.picture = picture;
		
		prayer = prayer.toUpperCase();
		this.prayer = prayer;
		
		this.power = power;
		this.candle = candle;
		
	}
	
	
	// Setters & Getters
	
	public Power getPower()
	{
		return power;
	}
	
	public String getPowerName()
	{
		return power.getName();
	}
	
	public String getCandleColor()
	{
		return candle.getColor();
	}
	
	public String getCandleSize()
	{
		return candle.getSize();
	}
	
	public String getCandleBrightness()
	{
		return candle.getBrightness();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public String getPicture()
	{
		return picture;
	}
	
	public String getPrayer()
	{
		return prayer;
	}
}