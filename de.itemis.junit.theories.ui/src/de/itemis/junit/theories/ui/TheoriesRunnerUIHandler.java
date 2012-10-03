package de.itemis.junit.theories.ui;

import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.ui.TestRunnerViewPart;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.eclipse.jdt.junit.runners.IRunnerUIHandler;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.part.ViewPart;

@SuppressWarnings("restriction")
public class TheoriesRunnerUIHandler implements IRunnerUIHandler {

	@Override
	public boolean contextMenuAboutToShow(ViewPart part, ITestElement element, IMenuManager menu) {
		if (element instanceof TestCaseElement) {
			menu.add(new OpenTestTheoryAction((TestRunnerViewPart) part, (TestCaseElement) element));
			return true;
		}
		return false;
	}

	@Override
	public boolean handleDoubleClick(ViewPart part, ITestElement element) {
		if (element instanceof TestCaseElement) {
			Action action = new OpenTestTheoryAction((TestRunnerViewPart) part, (TestCaseElement) element);
			if (action.isEnabled()) {
				action.run();
				return true;
			}
		}
		return false;
	}

	@Override
	public String getSimpleLabel(ViewPart part, ITestElement element) {
		if (element instanceof ITestCaseElement)
			return ((ITestCaseElement) element).getTestMethodName() + " theory";
		if (element instanceof ITestSuiteElement)
			return ((ITestSuiteElement) element).getSuiteTypeName();
		return "unknown";
	}

}
