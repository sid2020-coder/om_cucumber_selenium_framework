package constants;

public enum EndPoint {
    STORE("/store"),
    CART("/cart");

public final String url;

    EndPoint(String url) {
        this.url =url;
    }
}
