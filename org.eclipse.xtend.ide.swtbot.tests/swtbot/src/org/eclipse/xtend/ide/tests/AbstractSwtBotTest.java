/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests;

import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Arne Deutsch - Initial contribution and API
 * @author Karsten Thoms
 */
public class AbstractSwtBotTest {

	@BeforeClass
	public static void initialize() throws Exception {
		TargetPlatformUtil.setTargetPlatform(AbstractSwtBotTest.class);
		IResourcesSetupUtil.cleanWorkspace();
		UIThreadRunnable.syncExec(new VoidResult() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});
	}
	
	@Before
	public final void checkNotRunninginUiThread () {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench.getDisplay().getThread() == Thread.currentThread()) {
			Assert.fail("This test MUST NOT RUN in SWT's UI thread. Please check the 'Run in UI thread' option of your launch config or build configuration!");
		}
	}
}
