package ba.academy.game;

import ba.academy.game.dto.PlayerDto;
import ba.academy.game.services.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/player")
public class PlayerResource {
    @Inject
    PlayerService service;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
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
    public Response create(PlayerDto dtoAtribute, @Context UriInfo uriInfo)
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
    public Response updateDiary(PlayerDto dtoAtribute, @PathParam("id") int id, @Context UriInfo uriInfo) {
        var updateDiaryDto = service.updateById(id, dtoAtribute);
        if(updateDiaryDto != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            return Response.created(uriBuilder.build()).entity(updateDiaryDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
