package entidad;

public class Usuario {
	private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    
    public Usuario() {}
    
	public Usuario(int idUsuario, String nombreUsuario, String contrasena) {
		this.idUsuario = idUsuario;
		
		// aquí agrego los setters para que al construir el objeto se valide
		// de una vez, reutilizando las validaciones y evitando crear objetos
		// en estaod inválido
        setNombreUsuario(nombreUsuario);
        setContrasena(contrasena);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío.");
        }
        this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        this.contrasena = contrasena;
	}
		
}
