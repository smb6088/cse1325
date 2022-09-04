public class Clock{
	public Clock(int hours, int min, int sec)
	{
		this.hours = hours;
		this.min = min;
		this.sec =sec;
	}

	
	
	@Override
	public String toString(){
		return String.format("%02d", hours) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
	}

	private int hours;
	private int min;
	private int sec;	

}