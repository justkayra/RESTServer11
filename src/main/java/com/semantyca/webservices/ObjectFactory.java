
package com.semantyca.webservices;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.semantyca.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.semantyca.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link YrttiInvoicingRequest }
     * 
     */
    public YrttiInvoicingRequest createYrttiInvoicingRequest() {
        return new YrttiInvoicingRequest();
    }

    /**
     * Create an instance of {@link YrttiInvoicingResponse }
     * 
     */
    public YrttiInvoicingResponse createYrttiInvoicingResponse() {
        return new YrttiInvoicingResponse();
    }

    /**
     * Create an instance of {@link InvoiceRequestType }
     * 
     */
    public InvoiceRequestType createInvoiceRequestType() {
        return new InvoiceRequestType();
    }

    /**
     * Create an instance of {@link YrttiInvoicingRequest.InvoiceRequestList }
     * 
     */
    public YrttiInvoicingRequest.InvoiceRequestList createYrttiInvoicingRequestInvoiceRequestList() {
        return new YrttiInvoicingRequest.InvoiceRequestList();
    }

    /**
     * Create an instance of {@link YrttiInvoicingResponse.InvoicingResponseList }
     * 
     */
    public YrttiInvoicingResponse.InvoicingResponseList createYrttiInvoicingResponseInvoicingResponseList() {
        return new YrttiInvoicingResponse.InvoicingResponseList();
    }

    /**
     * Create an instance of {@link InvoiceResponseType }
     * 
     */
    public InvoiceResponseType createInvoiceResponseType() {
        return new InvoiceResponseType();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link InvoiceRequestType.ProductsList }
     * 
     */
    public InvoiceRequestType.ProductsList createInvoiceRequestTypeProductsList() {
        return new InvoiceRequestType.ProductsList();
    }

}
