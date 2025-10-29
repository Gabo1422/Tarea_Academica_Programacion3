
package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import java.sql.Date;
import pe.edu.pucp.squirlearn.dao.persona.PersonaDao;
import pe.edu.pucp.squirlearn.daoImpl.persona.PersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;
import pe.pucp.edu.squirlearn.business.util.Cifrado;

/**
 *
 * @author gabri
 */
public class PersonaBo {
    
    private PersonaDao personaDao;
    
    public PersonaBo(){
        personaDao = new PersonaDaoImpl();
    }
    
    public Integer insertar(String nombres, String primerApellido, String segundoApellido, 
            String codigo, String correo, String contrasena, String usuario,Date actividad){
        PersonaDto personaDto = new PersonaDto();
     
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(1);
        //aqui se cebe hacer el insert del rol de la persona
        personaDto.setNombres(nombres);
        personaDto.setPrimerApellido(primerApellido);
        personaDto.setSegundoApellido(segundoApellido);
        personaDto.setCodigo(codigo);
        personaDto.setCorreo(correo);
        personaDto.setContrasena(Cifrado.cifrarMD5(contrasena));        personaDto.setEstadoPersona(estado);
        personaDto.setUsuario(usuario);
        personaDto.setUltimaActividad(actividad);
        
        return this.personaDao.insertar(personaDto);
    }
    
    public Integer modificar(Integer id, String nombres, String primerApellido, String segundoApellido, 
            String codigo, String correo, String contrasena,Integer estadoId ,
            String usuario, String usuarioCreacion, Date actividad){
        PersonaDto personaDto = new PersonaDto();
        
        personaDto.setContrasena(Cifrado.cifrarMD5(contrasena));
        EstadoPersonaDto estado = new EstadoPersonaDto();
        estado.setEstadoPersonaId(estadoId);
        
        personaDto.setPersonaId(id);
        personaDto.setNombres(nombres);
        personaDto.setPrimerApellido(primerApellido);
        personaDto.setSegundoApellido(segundoApellido);
        personaDto.setCodigo(codigo);
        personaDto.setCorreo(correo);
        personaDto.setEstadoPersona(estado);
        personaDto.setUsuario(usuario);
        personaDto.setUsuarioCreacion(usuarioCreacion);
        personaDto.setUltimaActividad(actividad);
        
        return this.personaDao.modificar(personaDto);
    }
    
    public PersonaDto logIn(String correo, String contrasena){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setCorreo(correo);
        PersonaDto perDto = this.personaDao.buscarPorCorreo(correo);//necesita implementación
        if(Cifrado.descifrarMD5(perDto.getContrasena()).equals(contrasena))
            return personaDto;
        else
            return null;
    }
    
    public PersonaDto obtenerPorId(Integer id){
        return this.personaDao.obtenerPorId(id);
    }
    
    public PersonaDto obtenerPorCodigo(String codigo){
        return this.personaDao.obtenerPorCodigo(codigo); //necesita implementación 
    }
}
