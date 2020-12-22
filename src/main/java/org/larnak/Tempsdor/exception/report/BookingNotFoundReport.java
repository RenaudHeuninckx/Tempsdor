package org.larnak.Tempsdor.exception.report;

public class BookingNotFoundReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public BookingNotFoundReport(int index, String methodUsed, String forRequest) {
        this.message = "La réservation avec l'index " + index + " n'a pas été trouvée";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
