package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.MensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class MensajeDaoImpl extends DAOImplBase implements MensajeDao{

    private MensajeDto mensaje;

    public MensajeDaoImpl() {
        super("mensajes");
        this.mensaje = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("MENSAJE_ID", true, true));
        this.listaColumnas.add(new Columna("CHAT", false, false));
        this.listaColumnas.add(new Columna("FECHA_ENVIO", false, false));
        this.listaColumnas.add(new Columna("FECHA_LEIDO", false, false));
        this.listaColumnas.add(new Columna("MENSAJE", false, false));
        this.listaColumnas.add(new Columna("ESTADO_MENSAJE", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int chatId = safeFkId(
            (this.mensaje.getChat() == null ? null : this.mensaje.getChat().getChatId()),
            "chats", "CHAT_ID"
        );
        int estadoMsjId = safeFkId(
            (this.mensaje.getEstadoMensaje() == null ? null : this.mensaje.getEstadoMensaje().getEstadoMsjId()),
            "estados_mensajes", "ESTADOMSJ_ID"
        );
        int personaId = safeFkId(
            (this.mensaje.getPersona() == null ? null : this.mensaje.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );

        int i = 1;
        this.statement.setInt(i++, chatId);
        this.statement.setDate(i++, this.mensaje.getFechaEnvio());
        this.statement.setDate(i++, this.mensaje.getFechaLeido());
        this.statement.setString(i++, this.mensaje.getMensaje());
        this.statement.setInt(i++, estadoMsjId);
        this.statement.setInt(i++, personaId);
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int chatId = safeFkId(
            (this.mensaje.getChat() == null ? null : this.mensaje.getChat().getChatId()),
            "chats", "CHAT_ID"
        );
        int estadoMsjId = safeFkId(
            (this.mensaje.getEstadoMensaje() == null ? null : this.mensaje.getEstadoMensaje().getEstadoMsjId()),
            "estados_mensajes", "ESTADOMSJ_ID"
        );
        int personaId = safeFkId(
            (this.mensaje.getPersona() == null ? null : this.mensaje.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );

        int i = 1;
        this.statement.setInt(i++, chatId);
        this.statement.setDate(i++, this.mensaje.getFechaEnvio());
        this.statement.setDate(i++, this.mensaje.getFechaLeido());
        this.statement.setString(i++, this.mensaje.getMensaje());
        this.statement.setInt(i++, estadoMsjId);
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, this.mensaje.getMensajeId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.mensaje = new pe.edu.pucp.squirlearn.model.chat.MensajeDto();

        // Chat
        ChatDto chat = new ChatDto();
        chat.setChatId(this.resultSet.getInt("CHAT_ID_CHAT"));
        this.mensaje.setChat(chat);

        // EstadoMensaje
        EstadoMensajeDto em = new EstadoMensajeDto();
        em.setEstadoMsjId(this.resultSet.getInt("ESTADO_MSJ_ID"));
        this.mensaje.setEstadoMensaje(em);

        // Persona
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.mensaje.setPersona(persona);

        // Escalares
        this.mensaje.setMensajeId(this.resultSet.getInt("MENSAJE_ID"));
        this.mensaje.setFechaEnvio(this.resultSet.getDate("FECHA_ENVIO"));
        this.mensaje.setFechaLeido(this.resultSet.getDate("FECHA_LEIDO"));
        this.mensaje.setMensaje(this.resultSet.getString("MENSAJE"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.mensaje.getMensajeId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.mensaje.getMensajeId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.mensaje = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.mensaje);
    }
    
    @Override
    public Integer insertar(MensajeDto mensaje) {
        this.mensaje = mensaje;
        return super.insertar();
    }
    @Override
    public MensajeDto obtenerPorId(Integer id) {
        this.mensaje = new MensajeDto();
        this.mensaje.setMensajeId(id);
        super.obtenerPorId();
        return this.mensaje;
    }

    @Override
    public ArrayList<MensajeDto> listarTodos() {
        return (ArrayList<MensajeDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(MensajeDto mensaje) {
        this.mensaje = mensaje;
        return super.modificar();
    }

    @Override
    public Integer eliminar(MensajeDto mensaje) {
        this.mensaje = mensaje;
        return super.eliminar();
    }


}
