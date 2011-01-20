/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.ui;

import junit.framework.TestCase;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractXtend2WorkspaceTestCase extends TestCase {

	@Inject
	protected IWorkspace workspace;

	protected String fileExtension;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
		injector.injectMembers(this);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Inject
	protected void setExtensions(@Named(Constants.FILE_EXTENSIONS) String extensions) {
		this.fileExtension = extensions.split(",")[0];
	}
}
