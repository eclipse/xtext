package org.xpect.ui.util;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.xpect.util.TestDataUtil;

/**
 * 
 * @author Moritz Eysholdt
 */
public class TestDataUIUtil {
	public static Map<String, String> parse(ITestElement element) {
		if (element instanceof ITestCaseElement)
			return TestDataUtil.decode(((ITestCaseElement) element).getTestMethodName());
		if (element instanceof ITestSuiteElement)
			return TestDataUtil.decode(((ITestSuiteElement) element).getSuiteTypeName());
		return Collections.emptyMap();
	}
}
