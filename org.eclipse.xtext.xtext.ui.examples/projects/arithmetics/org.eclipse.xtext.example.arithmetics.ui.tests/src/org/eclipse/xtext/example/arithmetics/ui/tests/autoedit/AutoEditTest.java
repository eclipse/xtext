/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.autoedit;

import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractAutoEditTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
public class AutoEditTest extends AbstractAutoEditTest {

	@Inject
	private FileExtensionProvider extensionProvider;

	@Inject
	private PluginProjectFactory projectFactory;

	@Before
	public void doSetup() {
		createPluginProject("foo");
	}

	@Override
	protected String getFileExtension() {
		return extensionProvider.getPrimaryFileExtension();
	}

	@Test
	public void testCalculatorAutoEdit() throws Exception {
		String model = "module MyModule\n" + "\n" + "1 + 2;|\n";
		XtextEditor editor = openEditor(model);
		pressKey(editor, '\n');
		String expectation = "module MyModule\n" + "\n" + "1 + 2;\n" + "// = 3\n" + "|\n";
		assertState(editor, expectation);
	}

	private IProject createPluginProject(String name) {
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(XtextProjectHelper.NATURE_ID);
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		JavaProjectSetupUtil.setUnixLineEndings(result);
		return result;
	}
}
