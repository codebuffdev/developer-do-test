package in.codebuffdev.unittesting;

public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }

    public double computeCircleArea(double radius){
        return Math.PI * radius * radius;
    }

    public double divide(int divisible, int divider){
        return divisible / divider;
    }

    public double multiply(int x, int y){
        return x * y;
    }
}
