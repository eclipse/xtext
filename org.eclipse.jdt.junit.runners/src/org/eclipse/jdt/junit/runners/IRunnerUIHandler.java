package org.eclipse.jdt.junit.runners;

import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jface.action.IMenuManager;

public interface IRunnerUIHandler {

	public void contextMenuAboutToShow(ITestElement element, IMenuManager menu);

	public boolean handleDoubleClick(ITestElement element);

	public String getSimpleLabel(ITestElement element);

}
