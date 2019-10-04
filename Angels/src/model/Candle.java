package model;

public class Candle
{
	// Constants
	
	public static final String BIG = "BIG";
	public static final String MEDIUM = "MEDIUM";
	public static final String SMALL = "SMALL"; 
	
	public static final String BANANA = "BANANA"; 
	public static final String MILK = "MILK"; 
	public static final String SUGAR = "SUGAR"; 
	
	
	
	public static final String HIGH = "HIGH";
	public static final String BMEDIUM = "MEDIUM";
	public static final String LOW = "LOW";
	
	// Atributos 
	
	private String color;
	private String size; 
	private String essence; 
	private String brightness; 
	
	//Constructor
	
	/**
	* Constructs a new Candle
	* <b>pos:</b> A new candle is instantiated
	* @param color Color of the candle
	* @param size Size of the candle
	* @param essence Essence of the candle
	* @param brightness Brightness of the candle
	*/
	public Candle(String color, String size, String essence, String brightness)
	{
		
		color = color.toUpperCase();
		
		this.color = color;
		this.size = size;
		this.essence = essence;
		this.brightness = brightness;
		
	}
	
	
	// Getters & Setters
	
	public String getColor()
	{
		return color;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public String getEssence()
	{
		return essence;
	}
	
	public String getBrightness()
	{
		return brightness;
	}
	
}


