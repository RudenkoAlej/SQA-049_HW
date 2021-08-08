package hw_5.model.money;

public class Currency {
    private String name;
    protected float usdCource;

    public Currency(String name, float usdCource) {
        this.name = name;
        this.usdCource = usdCource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUsdCource() {
        return usdCource;
    }

    public void setUsdCource(float usdCource) {
        this.usdCource = usdCource;
    }
}
