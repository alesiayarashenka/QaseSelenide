package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestCase {
    private String caseTitle;
    private String caseDescription;
    private String casePreConditions;
    private String casePostConditions;
    private String caseStatus;
    private String caseSeverity;
    private String casePriority;
    private String caseType;
    private String caseLayer;
    private String caseBehavior;
    private String caseAutomationStatus;
    private String caseTag;
}
