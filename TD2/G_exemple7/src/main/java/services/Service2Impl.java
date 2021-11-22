package services;

public class Service2Impl implements Service2{
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
