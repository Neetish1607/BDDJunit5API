package starter.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;

public class PetApiActions extends UIInteractions {

    @Given("Kitty is available in the Pet store")
    public long givenKittyIsAvailableInPetStore(){

        Pet pet = new Pet("Kitty","available");
        return given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet, ObjectMapperType.GSON).log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post()
                .getBody().as(Pet.class,ObjectMapperType.GSON).getId();
    }

    @When("I ask for a pet using Kitty's ID: {0}")
    public void whenIAskForAPetWithId(Long id){
        when().get("/"+id);
    }

    @Then("I get Kitty as a result")
    public void thenISeeKittyAsResult(){
        then().body("name", Matchers.equalTo("Kitty"));
    }

}
