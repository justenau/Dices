package application.domain;

public class Player {

    private static int COUNT = 0;
    private int id;
    private int totalResult;
    private int previousThrowResult;

    public Player(){
        this.id = ++COUNT;
    }

    public int getId() {
        return id;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getPreviousThrowResult() {
        return previousThrowResult;
    }

    public void setPreviousThrowResult(int previousThrowResult) {
        this.previousThrowResult = previousThrowResult;
    }
}
