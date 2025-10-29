package pe.edu.pucp.squirlearn.daoImpl.inciNoti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.inciNoti.NotificacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class NotificacionDaoImpl extends DAOImplBase implements NotificacionDao{

    private NotificacionDto notificacion;

    public NotificacionDaoImpl() {
        super("notificaciones");
        this.notificacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("NOTIFICACION_ID", true, true));
        this.listaColumnas.add(new Columna("FECHA", false, false));
        this.listaColumnas.add(new Columna("MENSAJE", false, false));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("MOTIVO_ID", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int personaId = safeFkId(
            (this.notificacion.getPersona() == null ? null : this.notificacion.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );
        int motivoId = safeFkId(
            (this.notificacion.getMotivo() == null ? null : this.notificacion.getMotivo().getMotivoId()),
            "motivos", "MOTIVO_ID"
        );

        int i = 1;
        this.statement.setDate(i++, this.notificacion.getFecha());
        this.statement.setString(i++, this.notificacion.getMensaje());
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, motivoId);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.notificacion = new NotificacionDto();

        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.notificacion.setPersona(persona);

        MotivoDto motivo = new MotivoDto();
        motivo.setMotivoId(this.resultSet.getInt("MOTIVO_ID_MOTIVO"));
        this.notificacion.setMotivo(motivo);

        this.notificacion.setNotificacionId(this.resultSet.getInt("NOTIFICACION_ID"));
        this.notificacion.setFecha(this.resultSet.getDate("FECHA"));
        this.notificacion.setMensaje(this.resultSet.getString("MENSAJE"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.notificacion.getNotificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.notificacion.getNotificacionId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.notificacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.notificacion);
    }
    
    @Override
    public Integer insertar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
        return super.insertar();
    }
    @Override
    public NotificacionDto obtenerPorId(Integer id) {
        this.notificacion = new NotificacionDto();
        this.notificacion.setNotificacionId(id);
        super.obtenerPorId();
        return this.notificacion;
    }

    @Override
    public ArrayList<NotificacionDto> listarTodos() {
        return (ArrayList<NotificacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
        return super.eliminar();
    }

    @Override
    public ArrayList<NotificacionDto> listarPorPersona(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE PERSONA_ID=?";
        Consumer<PreparedStatement> incluir = ps -> { 
            try { ps.setInt(1, personaId); 
            } catch (SQLException e) { 
                throw new RuntimeException(e); 
            } 
        };
        return (ArrayList<NotificacionDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

}
