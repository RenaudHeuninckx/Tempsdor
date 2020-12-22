package org.larnak.Tempsdor.exception.report;

public class BookingAlreadyExistReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public BookingAlreadyExistReport(int index, String methodUsed, String forRequest) {
        this.message = "Cette réservation existe déjà";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
