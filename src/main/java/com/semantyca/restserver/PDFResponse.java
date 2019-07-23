package com.semantyca.restserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PDFResponse {

    private int responseCode;

    private String errorTxt;

    private List<Object> extractPdf;

    public PDFResponse(int responseCode, String errorText, List extractPdf) {
        this.responseCode = responseCode;
        this.errorTxt = errorText;
        this.extractPdf = extractPdf;
    }

    public PDFResponse() {
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorTxt() {
        return errorTxt;
    }

    public void setErrorTxt(String errorTxt) {
        this.errorTxt = errorTxt;
    }

    public List<Object> getExtractPdf() {
        return extractPdf;
    }

    public void setExtractPdf(List<Object> extractPdf) {
        this.extractPdf = extractPdf;
    }
}
