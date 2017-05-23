package Controleurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HeurePPE 
{
	private Date uneHeure;
	private SimpleDateFormat unFormat1=null;
	
	public HeurePPE (Date uneHeure, String format )
	{
		this.uneHeure = uneHeure;
		this.unFormat1 = new SimpleDateFormat(format);
	}
	
	public HeurePPE (String format )
	{
		this.uneHeure = null;
		this.unFormat1 = new SimpleDateFormat(format);
	}
	
	public HeurePPE (String uneHeure, String format )
	{
		this.unFormat1 = new SimpleDateFormat(format);
		
		try
		{
			this.uneHeure = this.unFormat1.parse(uneHeure);	
		}
		catch (ParseException exp)
		{
			exp.printStackTrace();
		}
	}
	
	public String toString  ()
	{
		if(this.unFormat1 == null)
		{
			this.unFormat1 = new SimpleDateFormat("hh:mm:ss");
		}
		return this.unFormat1.format(this.uneHeure);
	}
	
	
	
	public void setDate (Date uneHeure)
	{
		this.uneHeure = uneHeure;
	}
	
	public void setFormat (String format)
	{
		this.unFormat1 =  new SimpleDateFormat(format);
	}
}
