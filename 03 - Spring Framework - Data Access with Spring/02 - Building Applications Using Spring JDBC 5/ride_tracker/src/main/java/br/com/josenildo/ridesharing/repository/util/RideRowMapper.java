package br.com.josenildo.ridesharing.repository.util;

import br.com.josenildo.ridesharing.model.Ride;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RideRowMapper implements RowMapper<Ride> {
    @Override
    public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ride ride = new Ride();
        ride.setId(rs.getInt("id"));
        ride.setName(rs.getString("name"));
        ride.setDuration(rs.getInt("duration"));
        return ride;
    }
}