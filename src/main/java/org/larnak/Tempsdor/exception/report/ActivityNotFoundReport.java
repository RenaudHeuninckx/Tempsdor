package org.larnak.Tempsdor.exception.report;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActivityNotFoundReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public ActivityNotFoundReport(int index, String methodUsed, String forRequest) {
        this.message = "L'activité avec l'index " + index +" n'a pas été trouvée";
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;
    }
}
