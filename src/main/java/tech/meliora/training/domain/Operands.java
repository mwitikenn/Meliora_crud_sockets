package tech.meliora.training.domain;

/**
 *
 * @author kamochu
 */
public class Operands {

    private String operation;
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Operands{" +
                "operation='" + operation + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

}
