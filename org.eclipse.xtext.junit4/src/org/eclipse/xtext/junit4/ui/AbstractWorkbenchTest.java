/*******************************************************************************
 * Copyright (c) 2008, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * Abstract base class for test classes that need access to the workbench.
 * 
 * @author Peter Friese - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.ui.testing.AbstractWorkbenchTest instead
 */
@Deprecated(forRemoval = true)
public abstract class AbstractWorkbenchTest extends Assert {

	@Before
	public void setUp() throws Exception {
		waitForEventProcessing();
		closeWelcomePage();
		closeEditors();
		cleanWorkspace();
		waitForBuild();
		waitForEventProcessing();
	}
	
	@After
	public void tearDown() throws Exception {
		waitForEventProcessing();
		closeEditors();
		cleanWorkspace();
		waitForBuild();
		waitForEventProcessing();
	}

	/**
	 * @since 2.24
	 */
	protected void waitForEventProcessing() {
		while (Display.getDefault().readAndDispatch()) {
		}
	}

	protected void closeEditors() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}

	protected void closeWelcomePage() throws InterruptedException {
		if (PlatformUI.getWorkbench().getIntroManager().getIntro() != null) {
			PlatformUI.getWorkbench().getIntroManager().closeIntro(PlatformUI.getWorkbench().getIntroManager().getIntro());
		}
	}

	protected void sleep(long i) throws InterruptedException {
		Display displ = Display.getCurrent();
		if (displ != null) {
			long timeToGo = System.currentTimeMillis() + i;
			while (System.currentTimeMillis() < timeToGo) {
				if (!displ.readAndDispatch()) {
					displ.sleep();
				}
			}
			displ.update();
		}
		else {
			Thread.sleep(i);
		}
	}

	protected IWorkbenchPage getActivePage() {
		return getWorkbenchWindow().getActivePage();
	}

	protected IWorkbenchWindow getWorkbenchWindow() {
		return getWorkbench().getActiveWorkbenchWindow();
	}

	protected IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

}
