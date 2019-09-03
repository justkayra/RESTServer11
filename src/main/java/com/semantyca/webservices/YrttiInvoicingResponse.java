
package com.semantyca.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="invoicingResponseList"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="invoiceResponse" type="{http://www.prh.fi/YrttiInvoicing}invoiceResponseType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "invoicingResponseList"
})
@XmlRootElement(name = "YrttiInvoicingResponse")
public class YrttiInvoicingResponse {

    @XmlElement(required = true)
    protected InvoicingResponseList invoicingResponseList;

    /**
     * Gets the value of the invoicingResponseList property.
     *
     * @return
     *     possible object is
     *     {@link YrttiInvoicingResponse.InvoicingResponseList }
     *
     */
    public InvoicingResponseList getInvoicingResponseList() {
        return invoicingResponseList;
    }

    /**
     * Sets the value of the invoicingResponseList property.
     *
     * @param value
     *     allowed object is
     *     {@link YrttiInvoicingResponse.InvoicingResponseList }
     *
     */
    public void setInvoicingResponseList(InvoicingResponseList value) {
        this.invoicingResponseList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="invoiceResponse" type="{http://www.prh.fi/YrttiInvoicing}invoiceResponseType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "invoiceResponse"
    })
    public static class InvoicingResponseList {

        @XmlElement(required = true)
        protected List<InvoiceResponseType> invoiceResponse;

        /**
         * Gets the value of the invoiceResponse property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the invoiceResponse property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInvoiceResponse().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InvoiceResponseType }
         * 
         * 
         */
        public List<InvoiceResponseType> getInvoiceResponse() {
            if (invoiceResponse == null) {
                invoiceResponse = new ArrayList<InvoiceResponseType>();
            }
            return this.invoiceResponse;
        }

    }

}
