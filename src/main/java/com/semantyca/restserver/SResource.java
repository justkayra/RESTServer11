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
public class SResource {

    @POST
    @Path("/ESBSAKOFindDocumentWithContentService")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postBodyInList() {
        System.out.println("POST");
        return Response.ok().build();
    }

    @POST
    @Path("/ESBSAKOFindDocumentMetadataQueryService")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postToGetMetadata() {

        System.out.println("POST");
        return Response.ok().build();
    }

}

/*<soap:Envelope
        xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
<soap:Body>
<ContentQueryResponse
      xmlns:ns2="webservices.sako.prh.fi"
              xmlns="http://www.prh.fi/ecl/esb/webservices/sako/">
<RequestOid>1.2.246.10.02446831.10.1.11001.23.20190321180901012</RequestOid>
<ResultDetails>
<ResultCode>0</ResultCode>
</ResultDetails>
<ns2:DocumentOut>
<ns2:ContentData>*********************************
</ns2:ContentData>
<ns2:MainTitle>84360_2016_510169Y_20160607_statute.pdf</ns2:MainTitle>
<ns2:Agent>
<ns2:Publisher>
<ns2:CorporateName>PRH</ns2:CorporateName>
</ns2:Publisher>
<ns2:Sender>
<ns2:PersonalName>YREK</ns2:PersonalName>
</ns2:Sender>
</ns2:Agent>
<ns2:MainDescription>Järjestelmästä tulostettu rekisteröity statuutti</ns2:MainDescription>
<ns2:DocumentType>STAT</ns2:DocumentType>
<ns2:Language>FI</ns2:Language>
<ns2:Identifier>
<ns2:NativeId>1.2.246.10.02446831.10.1.11001.2019.188559</ns2:NativeId>
<ns2:Ryhmatunnus>YR</ns2:Ryhmatunnus>
<ns2:Diaarinumero>2016/510169Y</ns2:Diaarinumero>
<ns2:YTunnus>0155628-9</ns2:YTunnus>
<ns2:Yhdistysrekisterinumero>84360</ns2:Yhdistysrekisterinumero>
</ns2:Identifier>
<ns2:Date>
<ns2:Created>2019-03-15T09:35:54</ns2:Created>
<ns2:Modified>2019-03-15T09:35:54</ns2:Modified>
<ns2:Valid>
<ns2:Start>2016-06-07T00:00:00</ns2:Start>
</ns2:Valid>
</ns2:Date>
<ns2:Version>1.0</ns2:Version>
<ns2:Restriction>
<ns2:PublicityClass>AJ</ns2:PublicityClass>
<ns2:PersonalData>true</ns2:PersonalData>
</ns2:Restriction>
<ns2:Preservation>
<ns2:Date>2019-03-15T09:35:54</ns2:Date>
<ns2:Creator>Järjestelmä</ns2:Creator>
<ns2:Authorization>Järjestelmä</ns2:Authorization>
<ns2:ActionType>YREKA-konversio</ns2:ActionType>
<ns2:ChangeReason>Järjestemän vaihdos</ns2:ChangeReason>
<ns2:Konvertoitu>true</ns2:Konvertoitu>
</ns2:Preservation>
<ns2:FileFormat>application/pdf</ns2:FileFormat>
<ns2:AuditTrail>
<ns2:Date>2019-03-15T09:35:54</ns2:Date>
<ns2:Creator>Järjestelmä</ns2:Creator>
<ns2:Action>Muokkaus</ns2:Action>
</ns2:AuditTrail>
</ns2:DocumentOut>
</ContentQueryResponse>
</soap:Body>
</soap:Envelope>*/

/*
<SOAP-ENV:Envelope
        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
<ns4:ContentQueryRequest
        xmlns:ns2="http://www.semantyca.com/spring-boot-soap-example"
        xmlns:ns3="webservices.sako.prh.fi"
        xmlns:ns4="http://www.prh.fi/ecl/esb/webservices/sako/">
<ns4:QueryRequestDetails>
<ns4:ClientId>23</ns4:ClientId>
<ns4:ClientMessageId>5555456</ns4:ClientMessageId>
</ns4:QueryRequestDetails>
<ns3:QueryByParameterContent>
<ns3:NativeId>1.2.246.10.02446831.10.1.11001.2019.188559</ns3:NativeId>
<ns3:FileFormat>application/pdf</ns3:FileFormat>
</ns3:QueryByParameterContent>
</ns4:ContentQueryRequest>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>*/