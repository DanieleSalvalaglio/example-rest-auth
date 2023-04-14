package it.vidiemme.boilerplate.resource;

import io.quarkus.security.Authenticated;
import it.vidiemme.boilerplate.dto.auth.AuthRequestDTO;
import it.vidiemme.boilerplate.dto.auth.AuthResponseDTO;
import it.vidiemme.boilerplate.dto.UserResponseDTO;
import it.vidiemme.boilerplate.service.AuthService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Path("/auth")
public class AuthResource {
	@Inject
	AuthService authService;

	@Inject
	JsonWebToken jwt;

	@PermitAll
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(AuthRequestDTO authRequestDTO) {
		AuthResponseDTO auth = authService.login(authRequestDTO);
		if(auth == null) {
			return Response.status(Status.UNAUTHORIZED).build();
		} else {
			return Response.ok(auth).build();
		}
	}

	@GET
	@Path("/profile")
	@Authenticated
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Get profile", description = "Get profile", operationId = "profile")
	@Parameter(name = HttpHeaders.AUTHORIZATION, in = ParameterIn.HEADER, description = "Bearer token")
	@APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserResponseDTO.class)))
	@APIResponse(responseCode = "404", description = "Not Found",content = @Content(mediaType = MediaType.APPLICATION_JSON))
	public Response profile(@Context SecurityContext ctx) {
		UserResponseDTO ur = authService.profile(ctx.getUserPrincipal().getName());
		if(ur == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(ur).build();
		}
	}
}