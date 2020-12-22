package org.larnak.Tempsdor.exception.report;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActivityAlreadyExistReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public ActivityAlreadyExistReport(int index, String methodUsed, String forRequest) {
        this.message = "Cette activité existe déjà";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
