package sample;

import java.util.Random;

public class JailCell {

    private Prisoner Prisoner;

    public JailCell(sample.Prisoner prisoner) {
        Prisoner = prisoner;
    }

    public sample.Prisoner getPrisoner() {
        return Prisoner;
    }

    public void setPrisoner(sample.Prisoner prisoner) {
        Prisoner = prisoner;
    }

    public String getJailCellNumber(Prisoner prisoner) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength).collect(StringBuilder
                        ::new, StringBuilder::appendCodePoint,
                        StringBuilder::append).toString();

        return generatedString;
    }
}

