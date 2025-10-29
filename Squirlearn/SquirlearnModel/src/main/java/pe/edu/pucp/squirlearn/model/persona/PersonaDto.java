package pe.edu.pucp.squirlearn.model.persona;

import java.sql.Date;
import java.util.List;

public class PersonaDto {
    
    private Integer personaId;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String codigo;
    private String correo;
    private String contrasena;
    private String usuario;
    private String usuarioCreacion;
    private EstadoPersonaDto estadoPersona;
    private Date ultimaActividad;
    private List<RolPersonaDto> rolesPersona;
    
    // Constructor vacío
    public PersonaDto() {
        this.personaId = null;
        this.nombres = null;
        this.primerApellido = null;
        this.segundoApellido = null;
        this.codigo = null;
        this.correo = null;
        this.contrasena = null;
        this.usuario = null;
        this.ultimaActividad = null;
        this.estadoPersona = null;
        this.rolesPersona = null;
        this.usuarioCreacion = null;
    }

    // Constructor con parámetros
    public PersonaDto(Integer personaId, String nombres, String primerApellido, String segundoApellido,
                      String codigo, String correo, String contrasena, String usuario, 
                      Date ultimaActividad, EstadoPersonaDto estadoPersona,List<RolPersonaDto> rolPersona,
                      String usuarioCreacion) {
        this.personaId = personaId;
        this.nombres = nombres;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.codigo = codigo;
        this.correo = correo;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.rolesPersona = rolPersona;
        this.estadoPersona = estadoPersona;
        this.ultimaActividad = ultimaActividad;
        this.usuarioCreacion = usuarioCreacion;
    }
    
    // Getters y Setters
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<RolPersonaDto> getRolPersona() {
        return rolesPersona;
    }

    public void setRolPersona(List<RolPersonaDto> rolPersona) {
        this.rolesPersona = rolPersona;
    }

    public EstadoPersonaDto getEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(EstadoPersonaDto estadoPersona) {
        this.estadoPersona = estadoPersona;
    }
    
    public Date getUltimaActividad() {
        return ultimaActividad;
    }
    

    public void setUltimaActividad(Date ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }
    
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}
