package org.larnak.Tempsdor.exception.report;

public class RoomNotFoundReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public RoomNotFoundReport(int index, String methodUsed, String forRequest) {
        this.message = "La chambre avec l'index " + index + " n'a pas été trouvée";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
