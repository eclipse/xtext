package org.eclipse.xtext.ui.tests.quickfix.validation;

import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
 

public class QuickfixCrossrefTestLanguageJavaValidator extends AbstractQuickfixCrossrefTestLanguageJavaValidator {

	public static final String TRIGGER_VALIDATION_ISSUE = "triggerValidationIssue";
	
	public static final String ISSUE_DATA_0 = "data0";
	
	public static final String ISSUE_DATA_1 = "data1";

	@Check(CheckType.FAST)
	public void checkAndPopulateIssueData(Element element) {
		if(element.getName().equals(TRIGGER_VALIDATION_ISSUE)) {
			error(TRIGGER_VALIDATION_ISSUE, element, QuickfixCrossrefPackage.ELEMENT__NAME, TRIGGER_VALIDATION_ISSUE, ISSUE_DATA_0, ISSUE_DATA_1);
		}
	}

}
