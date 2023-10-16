
public class MKKlub {
	private int ID;
	private String IME_KLUBA;
	private String ADRESA_KLUBA;
	private int BR_MACEVAOCA;
	
	
	
	
	public MKKlub(int iD, String iME_KLUBA, String aDRESA_KLUBA, int bR_MACEVAOCA) {
		super();
		ID = iD;
		IME_KLUBA = iME_KLUBA;
		ADRESA_KLUBA = aDRESA_KLUBA;
		BR_MACEVAOCA = bR_MACEVAOCA;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIME_KLUBA() {
		return IME_KLUBA;
	}
	public void setIME_KLUBA(String iME_KLUBA) {
		IME_KLUBA = iME_KLUBA;
	}
	public String getADRESA_KLUBA() {
		return ADRESA_KLUBA;
	}
	public void setADRESA_KLUBA(String aDRESA_KLUBA) {
		ADRESA_KLUBA = aDRESA_KLUBA;
	}
	public int getBR_MACEVAOCA() {
		return BR_MACEVAOCA;
	}
	public void setBR_MACEVAOCA(int bR_MACEVAOCA) {
		BR_MACEVAOCA = bR_MACEVAOCA;
	}
	@Override
	public String toString() {
		return "MKKlub [ID=" + ID + ", IME_KLUBA=" + IME_KLUBA + ", ADRESA_KLUBA=" + ADRESA_KLUBA + ", BR_MACEVAOCA="
				+ BR_MACEVAOCA + "]";
	}
	
	}
	
	
	
	
	
	


