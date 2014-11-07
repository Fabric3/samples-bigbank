
package org.fabric3.samples.bigbank.api.loan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanApplicationStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loanApplicationStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientCorrelation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanApplicationStatus", propOrder = {
    "clientCorrelation",
    "status"
})
public class LoanApplicationStatus {

    protected String clientCorrelation;
    protected String status;

    /**
     * Gets the value of the clientCorrelation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCorrelation() {
        return clientCorrelation;
    }

    /**
     * Sets the value of the clientCorrelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCorrelation(String value) {
        this.clientCorrelation = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
