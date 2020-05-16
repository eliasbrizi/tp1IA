package coronaTracker.Domain;

public class Ciudadano {
	
	private String home;
	private String position;
	private Boolean infected;
	
	public Ciudadano(String home, String position, Boolean infected) {
		super();
		this.home = home;
		this.position = position;
		this.infected = infected;
	}

	public Ciudadano(String home, String position) {
		super();
		this.home = home;
		this.position = position;
		if ( (Math.round((Math.random()*100))% 4) != 0) infected = true;
		else infected = false;
	}
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getInfected() {
		return infected;
	}

	public void setInfected(Boolean infected) {
		this.infected = infected;
	}

	@Override
	public String toString() {
		return "Ciudadano [home=" + home + ", position=" + position + ", infected=" + infected + "]";
	}
	
}
