package br.com.josenildo.airportmanagement.converter;

import br.com.josenildo.airportmanagement.domain.Aircraft;

public class AircraftDbReadConverter implements Converter<String, Aircraft> {
    @Override
    public Aircraft convert(String source) {
        String[] strings = source.split("/");
        return new Aircraft(strings[0], Integer.parseInt(strings[1]));
    }
}