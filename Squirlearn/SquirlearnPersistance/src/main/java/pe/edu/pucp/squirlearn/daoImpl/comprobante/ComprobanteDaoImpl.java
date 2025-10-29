package pe.edu.pucp.squirlearn.daoImpl.comprobante;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.comprobante.ComprobanteDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;

public class ComprobanteDaoImpl extends DAOImplBase implements ComprobanteDao{

    private ComprobanteDto comprobante;

    public ComprobanteDaoImpl() {
        super("comprobantes");
        this.comprobante = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("COMPROBANTE_ID", true, true));
        this.listaColumnas.add(new Columna("MONTO", false, false));
        this.listaColumnas.add(new Columna("TRANSACCION", false, false));
        this.listaColumnas.add(new Columna("FECHA_EMISION", false, false));
        this.listaColumnas.add(new Columna("IMPUESTO", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("FORMA_PAGO", false, false));
        this.listaColumnas.add(new Columna("MONEDA", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int personaId = safeFkId(
            (this.comprobante.getPersona() == null ? null : this.comprobante.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );
        int formaPagoId = safeFkId(
            (this.comprobante.getFormaPago() == null ? null : this.comprobante.getFormaPago().getFormaPagoId()),
            "formas_pago", "FORMAPAGO_ID"
        );
        int monedaId = safeFkId(
            (this.comprobante.getMoneda() == null ? null : this.comprobante.getMoneda().getMonedaId()),
            "monedas", "MONEDA_ID"
        );

        int i = 1;
        this.statement.setDouble(i++, this.comprobante.getMonto());
        this.statement.setString(i++, this.comprobante.getTransaccion());
        this.statement.setDate(i++, this.comprobante.getFechaEmision());
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, formaPagoId);
        this.statement.setInt(i++, monedaId);
        this.statement.setDouble(i++, this.comprobante.getImpuesto()); // puede ser null
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int personaId = safeFkId(
            (this.comprobante.getPersona() == null ? null : this.comprobante.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );
        int formaPagoId = safeFkId(
            (this.comprobante.getFormaPago() == null ? null : this.comprobante.getFormaPago().getFormaPagoId()),
            "formas_pago", "FORMAPAGO_ID"
        );
        int monedaId = safeFkId(
            (this.comprobante.getMoneda() == null ? null : this.comprobante.getMoneda().getMonedaId()),
            "monedas", "MONEDA_ID"
        );

        int i = 1;
        this.statement.setDouble(i++, this.comprobante.getMonto());
        this.statement.setString(i++, this.comprobante.getTransaccion());
        this.statement.setDate(i++, this.comprobante.getFechaEmision());
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, formaPagoId);
        this.statement.setInt(i++, monedaId);
        this.statement.setDouble(i++, this.comprobante.getImpuesto());
        this.statement.setInt(i++, this.comprobante.getComprobanteId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.comprobante = new pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto();

        // Persona
        pe.edu.pucp.squirlearn.model.persona.PersonaDto persona = new pe.edu.pucp.squirlearn.model.persona.PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID_PERSONA"));
        this.comprobante.setPersona(persona);

        // FormaPago
        pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto fp = new pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto();
        fp.setFormaPagoId(this.resultSet.getInt("FORMA_PAGO_ID_FORMAPAGO"));
        this.comprobante.setFormaPago(fp);

        // Moneda
        MonedaPagoDto mon = new MonedaPagoDto();
        mon.setMonedaId(this.resultSet.getInt("MONEDA_ID_MONEDA"));
        this.comprobante.setMoneda(mon);

        // Escalares
        this.comprobante.setComprobanteId(this.resultSet.getInt("COMPROBANTE_ID"));
        this.comprobante.setMonto(this.resultSet.getDouble("MONTO"));
        this.comprobante.setTransaccion(this.resultSet.getString("TRANSACCION_ID"));
        this.comprobante.setFechaEmision(this.resultSet.getDate("FECHA_EMISION"));
        this.comprobante.setImpuesto(this.resultSet.getDouble("IMPUESTO"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.comprobante.getComprobanteId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.comprobante.getComprobanteId());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.comprobante = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.comprobante);
    }
    
    @Override
    public Integer insertar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
        return super.insertar();
    }
    @Override
    public ComprobanteDto obtenerPorId(Integer id) {
        this.comprobante = new ComprobanteDto();
        this.comprobante.setComprobanteId(id);
        super.obtenerPorId();
        return this.comprobante;
    }

    @Override
    public ArrayList<ComprobanteDto> listarTodos() {
        return (ArrayList<ComprobanteDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ComprobanteDto comprobante) {
        this.comprobante = comprobante;
        return super.eliminar();
    }

    @Override
    public ArrayList<ComprobanteDto> listarPorDueno(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE PERSONA_ID_PERSONA=?";
        Consumer<PreparedStatement> incluir = ps -> { 
            try { ps.setInt(1, personaId); 
            } catch (SQLException e) 
            { throw new RuntimeException(e); 
            }
        };
        return (ArrayList<ComprobanteDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

}
