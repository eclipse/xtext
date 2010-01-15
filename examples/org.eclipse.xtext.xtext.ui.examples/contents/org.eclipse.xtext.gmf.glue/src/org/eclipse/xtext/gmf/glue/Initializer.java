/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.gmf.glue.concurrency.ConcurrentModificationObserver;

/**
 * @author koehnlein
 */
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
