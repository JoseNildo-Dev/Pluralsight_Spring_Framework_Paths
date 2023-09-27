package br.com.josenildo.airportmanagement.converter;

import br.com.josenildo.airportmanagement.domain.Aircraft;
import org.bson.json.Converter;

public class AircraftDbWriteConverter implements Converter<Aircraft, String> {
    @Override
    public String convert(Aircraft source) {
        return source.getModel() + "/" + source.getNbSeats();
    }
}
