package br.com.josenildo.ridesharing.repository.impl;

import br.com.josenildo.ridesharing.model.Ride;
import br.com.josenildo.ridesharing.repository.RideRepository;
import br.com.josenildo.ridesharing.repository.util.RideRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

    private final JdbcTemplate jdbcTemplate;

    public RideRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<Ride> getRides() {
//        String sql = "SELECT * FROM ride";
//        return jdbcTemplate.query(sql, new RowMapper<Ride>() {
//            @Override
//            public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Ride ride = new Ride();
//                ride.setId(rs.getInt("id"));
//                ride.setName(rs.getString("name"));
//                ride.setDuration(rs.getInt("duration"));
//                return ride;
//            }
//        });
//    }
//
//    @Override
//    public List<Ride> getRides() {
//        String sql = "SELECT * FROM ride";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Ride ride = new Ride();
//            ride.setId(rs.getInt("id"));
//            ride.setName(rs.getString("name"));
//            ride.setDuration(rs.getInt("duration"));
//            return ride;
//        });
//    }

    @Override
    public List<Ride> getRides() {
        String sql = "SELECT * FROM ride";
        return jdbcTemplate.query(sql, new RideRowMapper());
    }

//    @Override
//    public Ride createRide(Ride ride) {
//        String sql = "INSERT INTO ride (name, duration) values (?,?)";
//        jdbcTemplate.update(sql, ride.getName(), ride.getDuration());
//        return ride;
//    }
//
//    @Override
//    public Ride createRide(Ride ride) {
//        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
//        
//        List<String> columns = new ArrayList<>();
//        columns.add("name");
//        columns.add("duration");
//        
//        insert.setTableName("ride");
//        insert.setColumnNames(columns);
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("name", ride.getName());
//        data.put("duration", ride.getDuration());
//        
//        insert.setGeneratedKeyName("id");
//        Number key = insert.executeAndReturnKey(data);
//        ride.setId(key.intValue());
//        
//        return ride;
//    }

    @Override
    public Ride createRide(Ride ride) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "INSERT INTO ride (name, duration) values (?,?)";
                PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, ride.getName());
                ps.setInt(2, ride.getDuration());
                return ps;
            }
        }, keyHolder);
        
        Number id = keyHolder.getKey();
        
        return getRide(id.intValue());
    }
    
    @Override
    public Ride getRide(Integer id) {
        String sql = "SELECT * FROM ride WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RideRowMapper(), id);
    }

    @Override
    public Ride updateRide(Ride ride) {
        String sql = "UPDATE ride SET name = ?, duration = ? WHERE id = ?";
        jdbcTemplate.update(sql, ride.getName(), ride.getDuration(), ride.getId());
        return ride;
    }
    
    // ALTER TABLE ride ADD ride_date DATETIME AFTER duration;

    @Override
    public void updateRides(List<Object[]> pairs) {
        String sql = "UPDATE ride SET ride_date = ? WHERE id = ?";
        jdbcTemplate.batchUpdate(sql, pairs);
    }

    @Override
    public void deleteRide(Integer id) {
//        String sql = "DELETE FROM ride WHERE id = ?";
//        jdbcTemplate.update(sql, id);
        NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        String sql = "DELETE FROM ride WHERE id = :id";
        namedTemplate.update(sql, paramMap);
    }
}