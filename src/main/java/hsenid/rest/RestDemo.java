package hsenid.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo")
public class RestDemo {

	@GET
	@Path("/test/{name}/{age}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testPParam(@PathParam("name") String name, @PathParam("age") int age) {
		return "Hello " + name+", your age is: "+age;
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String testQParam(@QueryParam("name") String name, @QueryParam("age") int age) {
		return "Hello " + name+", your age is: "+age;
	}

	@GET
	@Path("/students/{id}/{name}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("id") int id, @PathParam("name") String name, @PathParam("age") int age) {
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		return Response.status(200).entity(student).build();
	}
	
	@POST
	@Path("/form")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFormData(@FormParam("name") String name, @FormParam("age") int age) {
		return "Name: "+name+"\nAge: "+age;
	}

}
