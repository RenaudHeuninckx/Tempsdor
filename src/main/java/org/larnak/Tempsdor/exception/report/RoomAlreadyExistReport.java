package org.larnak.Tempsdor.exception.report;

public class RoomAlreadyExistReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public RoomAlreadyExistReport(int index, String methodUsed, String forRequest) {
        this.message = "Cette chambre existe déjà";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
