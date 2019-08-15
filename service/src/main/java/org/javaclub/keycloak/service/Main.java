package org.javaclub.keycloak.service;

import io.javalin.Javalin;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello world"));

        AuthzClient authzClient = AuthzClient.create();
        AuthorizationRequest request = new AuthorizationRequest();

        AuthorizationResponse response = authzClient.authorization("yura", "jclub")
                .authorize(request);
        String rpt = response.getToken();

        System.out.println("You got an RPT: " + rpt);
    }
}
