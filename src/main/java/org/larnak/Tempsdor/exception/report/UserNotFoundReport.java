package org.larnak.Tempsdor.exception.report;

public class UserNotFoundReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public UserNotFoundReport(int index, String methodUsed, String forRequest) {
        this.message = "L'utilisateur avec l'index " + index + " n'a pas été trouvé";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
