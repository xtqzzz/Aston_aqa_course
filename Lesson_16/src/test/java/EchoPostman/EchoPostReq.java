package EchoPostman;

public class EchoPostReq {
    private String foo1;
    private String foo2;

    public EchoPostReq(String foo1, String foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }
}