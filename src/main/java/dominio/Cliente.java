package dominio;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellidos;
    private String dni;
    private String pasaporte;
    private String nacionalidad;
    private String telefono;
    private String email;
    private int idUsuario;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String dni, String pasaporte, String nacionalidad, String telefono, String email, int idUsuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.idUsuario = idUsuario;
    }

    public Cliente(int idCliente, String nombre, String apellidos, String dni, String pasaporte, String nacionalidad, String telefono, String email, int idUsuario) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.idUsuario = idUsuario;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
