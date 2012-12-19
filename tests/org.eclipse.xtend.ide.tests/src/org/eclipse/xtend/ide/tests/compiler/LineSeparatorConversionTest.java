/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LineSeparatorConversionTest extends AbstractXtendUITestCase {
	
	@Inject
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Override
	public void tearDown() throws Exception {
		workbenchTestHelper.tearDown();
		super.tearDown();
	}
	
	@Test public void testLineSeparator() throws Exception {
		IProject project = workbenchTestHelper.getProject();
		ScopedPreferenceStore projectPreferenceStore = new ScopedPreferenceStore(new ProjectScope(project), Platform.PI_RUNTIME);
		projectPreferenceStore.setValue(Platform.PREF_LINE_SEPARATOR, "\n\n");
		workbenchTestHelper.createFile("Foo.xtend", "class Foo {}");
		waitForAutoBuild();
		IFile compiledFile = project.getFile("xtend-gen/Foo.java");
		String contents = workbenchTestHelper.getContents(compiledFile);
		boolean expectAnotherNewline = false;
		for(char c : contents.toCharArray()) {
			if(c == '\n') 
				expectAnotherNewline = !expectAnotherNewline;
			else if(expectAnotherNewline) 
				fail("Invalid line separator: Expected double newlines only but got '" + contents + "'");
		}
	}
}
