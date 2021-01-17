package application;

public class Chocolate {

	private int id;
	private String type;
	private int cacao;
	private int sugar;
	private String dairy;
	private String vanilla;
	
	public Chocolate(int id, String type, int cacao, int sugar, String dairy, String vanilla) {
		this.setId(id);
		this.setType(type);
		this.setCacao(cacao);
		this.setSugar(sugar);
		this.setDairy(dairy);
		this.setVanilla(vanilla);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getCacao() {
		return cacao;
	}
	
	public void setCacao(int cacao) {
		this.cacao = cacao;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public String getDairy() {
		return dairy;
	}

	public void setDairy(String dairy) {
		this.dairy = dairy;
	}

	public String getVanilla() {
		return vanilla;
	}

	public void setVanilla(String vanilla) {
		this.vanilla = vanilla;
	}
}
