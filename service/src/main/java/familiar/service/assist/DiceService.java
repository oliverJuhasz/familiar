package familiar.service.assist;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {

    public int evaluateDiceExpression(String diceExpression) {
        if (!validateDice(diceExpression)) {
            throw new IllegalArgumentException("Incorrect dice format entered!");
        }
        return diceExpressionParser(diceExpression);


    }

    private boolean validateDice(String diceExpression) {
        return diceExpression.matches("^(([0-9]{1,3}[dD][0-9]{1,3}[\\+\\-](?=[0-9]))|((?<=.)[0-9]{1,3}[\\+\\-]?)|([0-9]{1,3}[dD][0-9]{1,3}))+$");
    }

    private int diceExpressionParser(String diceExpression) {
        int total = 0;
        StringBuilder parsed = new StringBuilder();
        for (char character : diceExpression.toCharArray()) {
            if (character == '+' || character == '-') {
                total += evaluatePart(parsed.toString());
                parsed = new StringBuilder();
            } else {
                parsed.append(character);
            }
        }
        total += rollDice(parsed.toString());
        return total;

    }

    private int evaluatePart(String diceExpressionPart) {
        int result;
        if (diceExpressionPart.matches("[0-9]+[dD][0-9]+")) {
            result = rollDice(diceExpressionPart);
        } else {
            result = Integer.parseInt(diceExpressionPart);
        }
        return result;
    }

    private int rollDice(String dice) {
        Random random = new Random();
        int total = 0;
        String[] split = dice.split("[dD]");
        int multiplier = Integer.parseInt(split[0]);
        int max = Integer.parseInt(split[1]);
        for (int i = 0; i < multiplier; i++) {
            total += random.nextInt(max) + 1;
        }
        return total;
    }

}
