package com.semantyca.restserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PDFResponseAlt {

    private String responseCode;

    private String errorText;

    private String extractPdf;

    public PDFResponseAlt(int responseCode, String errorText, String extractPdf) {
        this.responseCode = Integer.toString(responseCode);
        this.errorText = errorText;
        this.extractPdf = extractPdf;
    }

    public PDFResponseAlt() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getExtractPdf() {
        return extractPdf;
    }

    public void setExtractPdf(String extractPdf) {
        this.extractPdf = extractPdf;
    }
}
