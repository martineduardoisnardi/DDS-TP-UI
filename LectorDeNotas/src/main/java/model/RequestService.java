package model;

import model.Asignacion;
import excepciones.ExcepcionEstudiante;
import repositorios.RepositorioAsignaciones;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

import javax.ws.rs.core.MediaType;

public class RequestService {
	private Gson gson = new Gson();
	private Client client;
	private static final String SERVIDOR_DE_NOTAS = "http://notitas.herokuapp.com";
	private static final String RESOURCE_DATOS = "student";
	private static final String RESOURCE_NOTAS = "student/assignments";

	public RequestService() {
		this.client = Client.create();
	}

	public Estudiante getAutenticacion(String token) {
		WebResource resource = this.client.resource(SERVIDOR_DE_NOTAS).path(RESOURCE_DATOS);
		WebResource.Builder builder = resource.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = builder.get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new ExcepcionEstudiante(response.getStatus() + ": " + response.getClientResponseStatus().toString());
		}
		String jsonResponse = response.getEntity(String.class);
		Estudiante respuestaEstudiante = gson.fromJson(jsonResponse, Estudiante.class);
		return respuestaEstudiante;
	}

	public List<Asignacion> getAsignacionesDelEstudiante(String token) {
		WebResource resource = this.client.resource(SERVIDOR_DE_NOTAS).path(RESOURCE_NOTAS);
		WebResource.Builder builder = resource.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON);
		ClientResponse response = builder.get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new ExcepcionEstudiante(response.getStatus() + ": " + response.getClientResponseStatus().toString());
		}
		String jsonResponse = response.getEntity(String.class);
		RepositorioAsignaciones asignaciones = gson.fromJson(jsonResponse, RepositorioAsignaciones.class);
		return asignaciones.todos();
	}

	public String putActualizarDatosEstudiante(Estudiante unEstudiante) {
		JsonObject datos = new JsonObject();
		datos.addProperty("code", unEstudiante.getLegajo());
		datos.addProperty("first_name", unEstudiante.getNombre());
		datos.addProperty("last_name", unEstudiante.getApellido());
		datos.addProperty("github_user", unEstudiante.getUsuarioGithub());
		WebResource resource = this.client.resource(SERVIDOR_DE_NOTAS).path(RESOURCE_DATOS);
		WebResource.Builder builder = resource.header("Authorization", "Bearer " + unEstudiante.getToken())
				.accept(MediaType.APPLICATION_JSON);
		ClientResponse respuesta = builder.accept("application/json").type("application/json").put(ClientResponse.class,
				gson.toJson(datos));
		String respuestaJson = respuesta.getEntity(String.class);
		return respuestaJson;
	}
}
