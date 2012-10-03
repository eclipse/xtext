package org.eclipse.jdt.junit.runners;

import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.part.ViewPart;

public interface IRunnerUIHandler {

	public boolean contextMenuAboutToShow(ViewPart part, ITestElement element, IMenuManager menu);

	public boolean handleDoubleClick(ViewPart part, ITestElement element);

	public String getSimpleLabel(ViewPart part, ITestElement element);

}
