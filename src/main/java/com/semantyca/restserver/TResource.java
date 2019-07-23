package com.semantyca.restserver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/")
public class TResource {
    private static final String API_VERSION = "0.0.1-SNAPSHOT";

    @POST
    @Path(API_VERSION + "/generate-extract")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postBodyInList(Object message) {
        List<Object> list = new ArrayList<>();
        list.add(getPDF());
        //PDFResponse pdfResponse = new PDFResponse(0, "", list);
        PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
        return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
    }

    @POST
    @Path(API_VERSION + "/generate-electronic-extract")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response generateElectronicExtract(Object message) {
        List<Object> list = new ArrayList<>();
        list.add(getPDF());
        //PDFResponse pdfResponse = new PDFResponse(0, "", list);
        PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
        return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
    }

    @POST
    @Path("/generate-decision-extract")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response genDecisionExtract(Map message) {
        String bizId = (String) message.get("businessId");
        if (bizId.equals("3368478-7")) {
            PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
            return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
        } else if (bizId.equals("3368478-8")) { //Association <business identification> can’t be found.
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/generate-history-extract")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response genHistoryExtract(Map message) {
        String bizId = (String) message.get("businessId");
        if (bizId.equals("3368478-7")) {
            PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
            return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
        } else if (bizId.equals("3368478-8")) { //Association <business identification> can’t be found.
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/generate-extract1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response genExtract(Map message) {
        String bizId = (String) message.get("businessId");
        if (bizId.equals("3368478-7")) {
            PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
            return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
        } else if (bizId.equals("3368478-8")) { //Association <business identification> can’t be found.
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    @POST
    @Path("/pdf11")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postBody(Map message) {
        String bizId = (String) message.get("businessId");
        if (bizId.equals("3368478-7")) {
            PDFResponseAlt pdfResponse = new PDFResponseAlt(0, "", getPDF());
            return Response.ok().header("Content-Type", "application/json").entity(pdfResponse).build();
        } else if (bizId.equals("3368478-8")) { //Association <business identification> can’t be found.
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/pdf")
    @Produces({"application/pdf"})
    public Response write(OutputStream output) throws IOException, WebApplicationException {
        File file = new File("C:/Users/kairat.kuliyev/Documents/Notthingam/1.txt");
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                .build();

    }


    private String getPDF() {
        try {
            //File file = new File("C:/Users/kairat.kuliyev/Documents/Notthingam/1.txt");
            File file = new File("C:/Users/kairat.kuliyev/Documents/Notthingam/53.65.pdf");
            byte[] bytes = Files.readAllBytes(file.toPath());
            return DatatypeConverter.printBase64Binary(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}