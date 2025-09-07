package customTypes;

import domainObjects.ProductDetails;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public ProductDetails product(String name){
        return new ProductDetails(name.replace("\"",""));
    }
}
