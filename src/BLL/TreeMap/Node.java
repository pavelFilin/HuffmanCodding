package BLL.TreeMap;

public class Node {
    protected final Integer sum;

    private String code;

    public Node(Integer sum) {
        this.sum = sum;
    }

    public void buildCode(String code) {
        this.code = code;
    }

    public Integer getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
