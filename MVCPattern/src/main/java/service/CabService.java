package service;

public class CabService {

	public double calMini(double cabKM) {
		
		
		double count=cabKM*10;
		double count1=count+(count*0.05);
		
		return count1;
	}

	public double cabPrime(double cabKM) {
		
		double count=cabKM*20;
		double count1=count+(count*0.1);
		
		return count1;
	}

	public double cabMicro(double cabKM) {
		
		double count=cabKM*15;
		double count1=count+(count*0.08);
		
		return count1;
	}

}
