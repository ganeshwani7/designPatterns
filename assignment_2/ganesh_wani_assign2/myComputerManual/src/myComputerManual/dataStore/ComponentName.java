package myComputerManual.dataStore;

public enum ComponentName{
	AMDCPU("AMDCPU"),
	IntelCPU("IntelCPU"),
	DDR3RAM("DDR3RAM"),
	DDR4RAM("DDR4RAM"),
	HardDrive("HardDrive"),
	SolidState("SolidState"),
	IntelGraphics("IntelGraphics"),
	NvidiaGraphics("NvidiaGraphics"),
	DVD("DVD"),
	BlueRay("BlueRay"),
	LCD("LCD"),
	LED("LED"),
	Mac("Mac"),
	Windows("Windows"),
	YearSupport("YearSupport"),
	BiennialSupport("BiennialSupport");

	private final String name;

	/**
	* Component constructor which takes the String name and initializes enum
	* Return void
	*/
	ComponentName( String inName){
		name = inName;
	}
}
