package de.itemis.junit.parameterizedcsv.ui;

import org.eclipse.compare.CompareUI;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.eclipse.jdt.junit.runners.IRunnerUIHandler;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;

@SuppressWarnings("restriction")
public class ParameterizedCSVUIHandler implements IRunnerUIHandler {

	private static class CompareAction extends Action {

		private ITestElement ctx;

		public CompareAction(ITestElement ctx) {
			super();
			this.ctx = ctx;
			setText("Compare");
			setToolTipText("Compare test expecation with actual test result.");
		}

		@Override
		public boolean isEnabled() {
			return ctx instanceof TestElement && ((TestElement) ctx).isComparisonFailure();
		}

		@Override
		public void run() {
			FailureCompareEditorInput inp = new FailureCompareEditorInput(ctx);
			CompareUI.openCompareEditor(inp);
		}
	}

	@Override
	public void contextMenuAboutToShow(ITestElement ctx, IMenuManager menu) {
		menu.add(new CompareAction(ctx));
	}

	@Override
	public boolean handleDoubleClick(ITestElement ctx) {
		if (ctx instanceof TestElement && ((TestElement) ctx).isComparisonFailure()) {
			FailureCompareEditorInput inp = new FailureCompareEditorInput(ctx);
			CompareUI.openCompareEditor(inp);
			return true;
		}
		return false;
	}

	@Override
	public String getSimpleLabel(ITestElement element) {
		if (element instanceof ITestCaseElement)
			return ((ITestCaseElement) element).getTestMethodName();
		if (element instanceof ITestSuiteElement)
			return ((ITestSuiteElement) element).getSuiteTypeName();
		return "unknown type:" + element.getClass();
	}

}
