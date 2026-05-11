package entidad;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Cliente {
	private int idCliente;
    private String dni;
    private String cuil;
    private String nombre;
    private String apellido;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String nacionalidad;
    private String localidad;
    private String provincia;
    private String correoElectronico;
    private String telefono;
    
    public Cliente() {
    }
    
    public Cliente(int idCliente, String dni, String cuil, String nombre, String apellido, String sexo, 
            LocalDate fechaNacimiento, String direccion, String nacionalidad, 
            String localidad, String provincia, String correoElectronico, String telefono) {
    	this.idCliente = idCliente;
    	setDni(dni);
    	setCuil(cuil);
		setNombre(nombre);
		setApellido(apellido);
		setSexo(sexo);
		setFechaNacimiento(fechaNacimiento);
		setDireccion(direccion);
		setNacionalidad(nacionalidad);
		setLocalidad(localidad);
		setProvincia(provincia);
		setCorreoElectronico(correoElectronico);
		setTelefono(telefono);
    }

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null || !dni.matches("\\d{6,8}")) {
            throw new IllegalArgumentException("El DNI debe ser numérico y contener entre 6 y 8 dígitos.");
        }
        this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		if (cuil == null || !cuil.matches("\\d{11}")) {
            throw new IllegalArgumentException("El CUIL debe ser numérico y contener exactamente 11 dígitos.");
        }
        this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }
        this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido == null || !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El apellido solo puede contener letras y espacios.");
        }
        this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if (sexo == null || (!sexo.equals("M") && !sexo.equals("F") && !sexo.equals("Otro"))) {
            throw new IllegalArgumentException("El sexo debe ser 'M', 'F' u 'Otro'.");
        }
        this.sexo = sexo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria y no puede ser futura.");
        }
        this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || !direccion.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.,ºª-]+")) {
            throw new IllegalArgumentException("La dirección solo puede contener letras, números y caracteres básicos de puntuación.");
        }
        this.direccion = direccion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		if (nacionalidad == null || !nacionalidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("La nacionalidad solo puede contener letras y espacios.");
        }
        this.nacionalidad = nacionalidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		if (localidad == null || !localidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("La localidad solo puede contener letras y espacios.");
        }
        this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		if (provincia == null || !provincia.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("La provincia solo puede contener letras y espacios.");
        }
        this.provincia = provincia;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (correoElectronico == null || !Pattern.compile(regexPattern).matcher(correoElectronico).matches()) {
            throw new IllegalArgumentException("El formato del correo electrónico es inválido.");
        }
        this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null || !telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe ser numérico y contener exactamente 10 dígitos.");
        }
        this.telefono = telefono;
	}
        
}
