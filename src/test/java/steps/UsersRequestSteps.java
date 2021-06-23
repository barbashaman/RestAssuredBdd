package steps;

import api.UsersResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class UsersRequestSteps {

    private UsersResponse usersResponse;
    private Response response;

    private static int pagina;

    @Dado("^que desejo buscar os dados de Users$")
    public void queDesejoBuscarOsDadosDeUsers() {
        usersResponse = new UsersResponse();
    }

    @Quando("^informo a página (\\d+)$")
    public void informoAPágina(int pagina) {
        this.pagina = pagina;
        response = usersResponse.getUsers("/api/users?pagina="+pagina);
    }

    @Então("^recebo uma resposta com status (\\d+)$")
    public void receboUmaRespostaComStatus(int status) {

        int acctualStatusCode = response.getStatusCode();
        System.out.println("Request retornou status: "+ acctualStatusCode);
        assertEquals(acctualStatusCode, status);
    }

    @Quando("^informo que desejo os dados do user de id (\\d+)$")
    public void informoQueDesejoOsDadosDoUserDeIdPágina(int id) {
        response = usersResponse.getUsers("/api/users/"+id);
    }
}
