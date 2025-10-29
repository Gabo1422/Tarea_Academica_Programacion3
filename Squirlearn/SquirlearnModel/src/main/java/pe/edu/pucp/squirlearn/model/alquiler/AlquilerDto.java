package pe.edu.pucp.squirlearn.model.alquiler;

import java.sql.Date;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class AlquilerDto {
    
    private Integer alquilerId;
    private PersonaDto persona;
    private ItemDto item;
    private Date fechaInicio;
    private Date fechaFin;
    private Double monto;
    private Boolean devuelto;
    private Date fechaCreacion;
    private String usuario;

    private String usuarioCreacion;
    
    // Constructor vacío (inicializa en null)
    public AlquilerDto() {
        this.alquilerId = null;
        this.persona = null;
        this.item = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.devuelto = null;
        this.monto = null;
        this.fechaCreacion = null;
        this.usuario = null;
        this.usuarioCreacion = null;
    }

    // Constructor con parámetros
    public AlquilerDto(Integer alquilerId, PersonaDto persona, ItemDto item,
                       Date fechaInicio, Date fechaFin, Boolean devuelto, Double monto,
                       Date fechaCreacion, String usuario, String usuarioCreacion) {
        this.alquilerId = alquilerId;
        this.persona = persona;
        this.item = item;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.devuelto = devuelto;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.usuarioCreacion = usuarioCreacion;
    }

    // Getters y Setters
    public Integer getAlquilerId() {
        return alquilerId;
    }

    public void setAlquilerId(Integer alquilerId) {
        this.alquilerId = alquilerId;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
}
