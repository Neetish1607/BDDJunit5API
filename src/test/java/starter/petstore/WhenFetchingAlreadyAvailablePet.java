package starter.petstore;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingAlreadyAvailablePet {

    PetApiActions petApi;
    Long newPetId = null;

    @Test
    public void fetchAlreadyAvailablePet(){
        newPetId = petApi.givenKittyIsAvailableInPetStore();
        System.out.println(newPetId);
        petApi.whenIAskForAPetWithId(newPetId);
        petApi.thenISeeKittyAsResult();

    }
}
