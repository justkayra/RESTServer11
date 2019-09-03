
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
 *         &lt;element name="invoiceRequestList"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="invoiceRequest" type="{http://www.prh.fi/YrttiInvoicing}invoiceRequestType" maxOccurs="unbounded"/&gt;
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
    "invoiceRequestList"
})
@XmlRootElement(name = "YrttiInvoicingRequest")
public class YrttiInvoicingRequest {

    @XmlElement(required = true)
    protected InvoiceRequestList invoiceRequestList;

    /**
     * Gets the value of the invoiceRequestList property.
     *
     * @return
     *     possible object is
     *     {@link YrttiInvoicingRequest.InvoiceRequestList }
     *
     */
    public InvoiceRequestList getInvoiceRequestList() {
        return invoiceRequestList;
    }

    /**
     * Sets the value of the invoiceRequestList property.
     *
     * @param value
     *     allowed object is
     *     {@link YrttiInvoicingRequest.InvoiceRequestList }
     *
     */
    public void setInvoiceRequestList(InvoiceRequestList value) {
        this.invoiceRequestList = value;
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
     *         &lt;element name="invoiceRequest" type="{http://www.prh.fi/YrttiInvoicing}invoiceRequestType" maxOccurs="unbounded"/&gt;
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
        "invoiceRequest"
    })
    public static class InvoiceRequestList {

        @XmlElement(required = true)
        protected List<InvoiceRequestType> invoiceRequest;

        /**
         * Gets the value of the invoiceRequest property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the invoiceRequest property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInvoiceRequest().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InvoiceRequestType }
         * 
         * 
         */
        public List<InvoiceRequestType> getInvoiceRequest() {
            if (invoiceRequest == null) {
                invoiceRequest = new ArrayList<InvoiceRequestType>();
            }
            return this.invoiceRequest;
        }

    }

}
