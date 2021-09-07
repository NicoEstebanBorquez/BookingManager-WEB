package dominio;

public class Alojamiento {

    private int idAlojamiento;
    private String nombre;
    private int plazas;
    private int dormitorios;
    private int banos;
    private String terraza;
    private String piscina;
    private String aparcamiento;
    private String direccion;
    private String poblacion;
    private String provincia;
    private int idPropietario;
    private int idUsuario;

    public Alojamiento() {
    }

    public Alojamiento(String nombre, int plazas, int dormitorios, int banos, String terraza, String piscina, String aparcamiento, String direccion, String poblacion, String provincia, int idPropietario, int idUsuario) {
        this.nombre = nombre;
        this.plazas = plazas;
        this.dormitorios = dormitorios;
        this.banos = banos;
        this.terraza = terraza;
        this.piscina = piscina;
        this.aparcamiento = aparcamiento;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.idPropietario = idPropietario;
        this.idUsuario = idUsuario;
    }
    
    

    public Alojamiento(int idAlojamiento, String nombre, int plazas, int dormitorios, int banos, String terraza, String piscina, String aparcamiento, String direccion, String poblacion, String provincia, int idPropietario, int idUsuario) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.plazas = plazas;
        this.dormitorios = dormitorios;
        this.banos = banos;
        this.terraza = terraza;
        this.piscina = piscina;
        this.aparcamiento = aparcamiento;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.idPropietario = idPropietario;
        this.idUsuario = idUsuario;
    }
               
    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public String getTerraza() {
        return terraza;
    }

    public void setTerraza(String terraza) {
        this.terraza = terraza;
    }

    public String getPiscina() {
        return piscina;
    }

    public void setPiscina(String piscina) {
        this.piscina = piscina;
    }

    public String getAparcamiento() {
        return aparcamiento;
    }

    public void setAparcamiento(String aparcamiento) {
        this.aparcamiento = aparcamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    
    
}
