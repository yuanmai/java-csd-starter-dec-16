package csd.starter.ppt;

public class FeeRateLookUp {
	
	

	private FeeRateLookUp() {
		super();
	}

	public static Integer[] getFeerates() {
		return feeRates;
	}

	private static  final Integer[] feeRates = { 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 0, 10, 10, 10, 10,
			0, 20, 20, 20, 20, 0, 0 };

}
