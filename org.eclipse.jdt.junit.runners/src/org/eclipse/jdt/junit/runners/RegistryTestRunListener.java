package org.eclipse.jdt.junit.runners;

import org.eclipse.jdt.junit.TestRunListener;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.swt.widgets.Display;

public class RegistryTestRunListener extends TestRunListener {

	@Override
	public void testCaseStarted(final ITestCaseElement testCaseElement) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				RunnerUIHandlerRegistry.getHandler(testCaseElement);
			}
		});
	}
}
