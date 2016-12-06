package con.hsenid.scientificCalculator.model;

/**
 * Created by Vidushka on 11/30/16.
 */
public class Calculator {
    int addTotal;
    public void add(int leftOparend, int rightOperend){
        addTotal = leftOparend;
        addTotal = addTotal + rightOperend;
    }
}

