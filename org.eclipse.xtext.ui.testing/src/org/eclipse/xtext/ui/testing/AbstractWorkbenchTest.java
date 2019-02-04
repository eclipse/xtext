/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract base class for test classes that need access to the workbench.
 * 
 * @author Peter Friese - Initial contribution and API
 * 
 * @since 2.12
 */
public abstract class AbstractWorkbenchTest extends Assert {

	@BeforeClass
	@BeforeAll
	public static void prepareWorkbench() throws Exception {
		closeWelcomePage();
		closeEditors();
	}
	
	@Before @BeforeEach
	public void setUp() throws Exception {
		cleanWorkspace();
		waitForBuild();
	}
	
	@After @AfterEach
	public void tearDown() throws Exception {
		closeEditors();
		cleanWorkspace();
		waitForBuild();
	}
	
	protected static void closeEditors() {
		getActivePage().closeAllEditors(false);
	}

	protected static void closeWelcomePage() throws InterruptedException {
		IIntroManager introManager = getWorkbench().getIntroManager();
		IIntroPart intro = introManager.getIntro();
		if (intro != null) {
			introManager.closeIntro(intro);
		}
	}

	@Deprecated
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

	protected static IWorkbenchPage getActivePage() {
		return getWorkbenchWindow().getActivePage();
	}

	protected static IWorkbenchWindow getWorkbenchWindow() {
		return getWorkbench().getActiveWorkbenchWindow();
	}

	protected static IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

}
