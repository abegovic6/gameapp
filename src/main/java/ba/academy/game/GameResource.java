package ba.academy.game;

import ba.academy.game.dto.GameDto;
import ba.academy.game.dto.Status;
import ba.academy.game.services.GameService;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/game")
@NoCache
public class GameResource {

    @Inject
    GameService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response getAll()
    {
        var allDtos = service.getAll();
        if(allDtos == null || allDtos.isEmpty()) {
            return Response.noContent().build();
        }
        return  Response.ok(allDtos).build();
    }

    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id)
    {
        var dto = service.getById(id);
        if(dto == null) {
            return Response.noContent().build();
        }
        return  Response.ok(dto).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response create(GameDto dtoAtribute, @Context UriInfo uriInfo)
    {
        var dto = service.create(dtoAtribute);
        if(dto != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            //uriBuilder.path(Integer.toString(storedDiary.getId()));
            return Response.created(uriBuilder.build()).entity(dto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response deleteById(@PathParam("id") int id) {
        var dto = service.deleteById(id);
        if(dto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }


    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response updateDiary(GameDto dtoAtribute, @PathParam("id") int id, @Context UriInfo uriInfo) {
        var updateDiaryDto = service.updateById(id, dtoAtribute);
        if(updateDiaryDto != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            return Response.created(uriBuilder.build()).entity(updateDiaryDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("{id}/move")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response move(@PathParam("id") int id, @Context UriInfo uriInfo) {
        var status = service.move(id);
        if(!status.isOk()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("{id}/fight")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response fight(@PathParam("id") int id, @Context UriInfo uriInfo) {
        var status = service.fight(id);
        if(!status.isOk()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("{id}/flee")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response flee(@PathParam("id") int id, @Context UriInfo uriInfo) {
        var status = service.flee(id);
        if(!status.isOk()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Path("{id}/collect")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response collect(@PathParam("id") int id, @Context UriInfo uriInfo) {
        var status = service.collect(id);
        if(!status.isOk()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.noContent().build();
    }
}
