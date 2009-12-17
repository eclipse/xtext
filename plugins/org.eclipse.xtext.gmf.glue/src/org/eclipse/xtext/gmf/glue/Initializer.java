package org.eclipse.xtext.gmf.glue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.gmf.glue.concurrency.ConcurrentModificationObserver;

public class Initializer implements IStartup {

	public void earlyStartup() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				activePage.addPartListener(new ConcurrentModificationObserver(activePage));
			}
		});
	}

}
