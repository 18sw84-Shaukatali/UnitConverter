package com.sha66.unitconverter;

public class Converter2
{
    public enum Unit
    {
        Milligrams,
        Centigrams,
        Grams,
        Kilograms,
        POUND,
        Ounce,
        Grain,

         Converter2;

        static Unit fromString(String text)
        {
            if(text!=null)
            {
                for(Unit unit:Unit.values())
                {
                    if(text.equalsIgnoreCase(unit.toString()))
                    {
                        return unit;
                    }
                }

            }

            throw new IllegalArgumentException("Cannot find a value for "+text);
        }

    }

    private final double multiplier;

    public Converter2(Unit from, Unit to) {

        multiplier = getRate(from,to);
    }

    public double getRate(Unit from,Unit to){
        double constant = 1;

        switch(from){
            case Milligrams:
                constant = (1/getRate(Unit.Kilograms,Unit.Milligrams))*getRate(Unit.Kilograms,to);
                break;
            case Centigrams:
                constant = (1/getRate(Unit.Kilograms,Unit.Centigrams))*getRate(Unit.Kilograms,to);
                break;
            case Grams:
                constant = (1/getRate(Unit.Kilograms,Unit.Grams))*getRate(Unit.Kilograms,to);
                break;
            case Kilograms:
                if (to == Unit.Milligrams) {
                    constant = 1000000;
                } else if (to == Unit.Centigrams) {
                    constant = 100000;
                }else if (to == Unit.Grams) {
                    constant = 1000;

                } else if (to == Unit.POUND) {
                    constant = 2.205;
                } else if (to == Unit.Ounce) {
                    constant = 35.274;
                }else if (to == Unit.Grain) {
                    constant = 15432.358;
                }
                break;

            case Grain:
                constant = (1/getRate(Unit.POUND,Unit.Grain))*getRate(Unit.POUND,to);
                break;
            case Ounce:
                constant = (1/getRate(Unit.POUND,Unit.Ounce))*getRate(Unit.POUND,to);
                break;
            case POUND:
                if (to == Unit.Milligrams) {
                    constant = 453592.37;
                } else if (to == Unit.Centigrams) {
                    constant = 45359.237;
                }else if (to == Unit.Grams) {
                    constant =453.592;
                }else if (to == Unit.Kilograms) {
                    constant = 0.454;
                }
                 else if (to == Unit.Grain) {
                    constant = 7000;
                } else if (to == Unit.Ounce) {
                    constant = 16.0753;
                }
                break;
        }

        return constant;
    }

    public double convert(double input) {
        return input * multiplier;
    }
}
