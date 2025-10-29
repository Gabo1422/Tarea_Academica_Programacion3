package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.ChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class ChatDaoImpl extends DAOImplBase implements ChatDao{

    private ChatDto chat;

    public ChatDaoImpl() {
        super("chats");
        this.chat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CHAT_ID", true, true));
        this.listaColumnas.add(new Columna("estado_chat_ID_ESTADOCHAT", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int estadoId = safeFkId(
            (this.chat.getEstadoChat() == null ? null : this.chat.getEstadoChat().getEstadoChatId()),
            "estados_chats", "ESTADOCHAT_ID"
        );
        int i = 1;
        this.statement.setInt(i++, estadoId);                                    // estado_chat_ID_ESTADOCHAT
        this.statement.setString(i++, this.chat.getUsuario());              // USUARIO_CREACION
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int estadoId = safeFkId(
            (this.chat.getEstadoChat() == null ? null : this.chat.getEstadoChat().getEstadoChatId()),
            "estados_chats", "ESTADOCHAT_ID"
        );
        int i = 1;
        this.statement.setInt(i++, estadoId);
        this.statement.setInt(i++, this.chat.getChatId()); // WHERE CHAT_ID=?
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.chat.getChatId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.chat.getChatId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.chat = new pe.edu.pucp.squirlearn.model.chat.ChatDto();

        EstadoChatDto ec = new EstadoChatDto();
        ec.setEstadoChatId(this.resultSet.getInt("estado_chat_ID_ESTADOCHAT"));
        this.chat.setEstadoChat(ec);

        this.chat.setChatId(this.resultSet.getInt("CHAT_ID"));
        this.chat.setUsuario(this.resultSet.getString("USUARIO"));
    }


    @Override
    protected void limpiarObjetoDelResultSet() {
        this.chat = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.chat);
    }
    
    @Override
    public Integer insertar(ChatDto chat) {
        this.chat = chat;
        return super.insertar();
    }
    @Override
    public ChatDto obtenerPorId(Integer id) {
        this.chat = new ChatDto();
        this.chat.setChatId(id);
        super.obtenerPorId();
        return this.chat;
    }

    @Override
    public ArrayList<ChatDto> listarTodos() {
        return (ArrayList<ChatDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ChatDto chat) {
        this.chat = chat;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ChatDto chat) {
        this.chat = chat;
        return super.eliminar();
    }

}
