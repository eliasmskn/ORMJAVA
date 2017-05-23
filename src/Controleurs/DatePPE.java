package Controleurs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePPE
{
	private Date uneDate ;
	private SimpleDateFormat unFormat;
	
	public DatePPE (Date uneDate, String format )
	{
		this.uneDate = uneDate;
		this.unFormat = new SimpleDateFormat(format);
	}
	
	public DatePPE (String format )
	{
		this.uneDate = null;
		this.unFormat = new SimpleDateFormat(format);
	}
	
	public DatePPE (String uneDate, String format )
	{
		this.unFormat = new SimpleDateFormat(format);
		
		try
		{
			this.uneDate = this.unFormat.parse(uneDate);	
		}
		catch (ParseException exp)
		{
			exp.printStackTrace();
		}
	}
	
	public String toString  ()
	{
		return this.unFormat.format(this.uneDate);
	}
	
	public void setDate (Date uneDate)
	{
		this.uneDate = uneDate;
	}
	
	public void setFormat (String format)
	{
		this.unFormat =  new SimpleDateFormat(format);
	}
}
