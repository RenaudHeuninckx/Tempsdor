package org.larnak.Tempsdor.exception.report;

public class UserAlreadyExistReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public UserAlreadyExistReport(int index, String methodUsed, String forRequest) {
        this.message = "Cette utilisateur existe déjà";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
