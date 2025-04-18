package com.hotel.hotel.repository;

import com.hotel.hotel.model.Empleado;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import oracle.jdbc.OracleTypes;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmpleadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
public void init() {
    this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
        .withCatalogName("EMPLEADO_PKG")
        .withProcedureName("LISTAR_EMPLEADOS_SP")
        .withoutProcedureColumnMetaDataAccess()
        .declareParameters(new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR))
        .returningResultSet("P_CURSOR", new RowMapper<Empleado>() {
            @Override
            public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getLong("ID_EMPLEADO"));
                e.setNombre(rs.getString("NOMBRE"));
                e.setCedula(rs.getInt("CEDULA"));
                e.setCorreo(rs.getString("CORREO"));
                e.setTelefono(rs.getInt("TELEFONO"));
                e.setFechaIngreso(rs.getDate("FECHA_INGRESO"));
                e.setFkHotel(rs.getInt("FK_HOTEL"));
                e.setFkPuesto(rs.getInt("FK_PUESTO"));
                return e;
            }
        });

    this.simpleJdbcCall.compile();
}

    public List<Empleado> listarEmpleados() {
    Map<String, Object> result = simpleJdbcCall.execute();
    return (List<Empleado>) result.get("P_CURSOR");
}

}

