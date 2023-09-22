package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserNameBySomeImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isImproper))
                .map(User::getName);
    }
    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::add).orElse(null);
    }
    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(frac -> frac.getDenominator() != 0)
                .max(Fraction::compareTo).orElse(null);
    }
    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.getNumerator() < 0 ||
                        fraction.getDenominator() < 0)
                .map(Fraction::decimal);
    }
}
