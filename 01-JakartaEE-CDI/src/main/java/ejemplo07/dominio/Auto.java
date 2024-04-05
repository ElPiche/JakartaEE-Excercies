package ejemplo07.dominio;

public class Auto {
		
	private Integer id;
	private String marca;
	private String modelo;
	
	public Auto(Integer id, String marca, String modelo) {
		this.id = id; this.marca = marca; this.modelo = modelo;}
	
	public String getModelo() {
		return "Cliente [Identificador ="+ id + " Marca = " + marca + " Modelo = " + modelo + "]";
	}
	
}
