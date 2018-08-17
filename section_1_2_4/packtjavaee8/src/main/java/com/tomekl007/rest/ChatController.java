package com.tomekl007.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chat")
public class ChatController {

    private final ChatService chatService = new ChatService();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/{user-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLastMessae(@PathParam("user-id") String userId) {
        String msg = chatService.getLastMessage(userId);

        return Response.ok()
                .entity(msg)
                .build();
    }

    @POST
    @Path("/{user-id}/{msg}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(@PathParam("user-id") String userId,
                                     @PathParam("msg") String message) {
        chatService.sendMessageTo(
                userId,
                message
        );
        return Response.status(201).entity(message).build();
    }
}

