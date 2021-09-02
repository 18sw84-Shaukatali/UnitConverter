package com.sha66.unitconverter;

public class Converter3 {
    public enum Unit {

        Celsius,
        Fahrenheit,
        Kelvin,

        Converter3;

        static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }

            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }

    }

    private final double multiplier;

    public Converter3(Unit from, Unit to) {

        multiplier = getRate(from, to);
    }

    public double getRate(Unit from, Unit to) {
        double constant = 1;

        switch (from) {

            case Celsius:
                constant = ( -32 + getRate(Unit.Fahrenheit, Unit.Celsius)) * getRate(Unit.Fahrenheit, to);
                break;
            case Kelvin:
                constant = (1 / getRate(Unit.Fahrenheit, Unit.Kelvin)) * getRate(Unit.Fahrenheit, to);
                break;
            case Fahrenheit:
                if (to == Unit.Celsius) {
                    constant = 5/9;
                } else if (to == Unit.Kelvin) {
                    constant = 255.928;

                }
                break;
                }

                return constant;
        }

        public double convert(double input) {
            return input * multiplier;
        }
    }



