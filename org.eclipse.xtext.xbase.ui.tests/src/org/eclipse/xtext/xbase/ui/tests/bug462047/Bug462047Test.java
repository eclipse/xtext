/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.bug462047;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.testlanguages.bug462047.ui.tests.Bug462047LangUiInjectorProvider;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(Bug462047LangUiInjectorProvider.class)
public class Bug462047Test extends AbstractEditorTest {
	
	@BeforeClass
	public static void setupTargetPlatform() throws Exception {
		TargetPlatformUtil.setTargetPlatform(Bug462047Test.class);
	}
	
	@Before
	public void createProjects() throws Exception {
		AbstractXbaseUITestCase.createPluginProject("bug462047");
	}
	
	@Test
	public void testNoErrors() throws Exception {
		IResourcesSetupUtil.createFile("bug462047/src/a.bug462047lang", "element CORE ref CORE.b");
		IFile file = IResourcesSetupUtil.createFile("bug462047/src/b.bug462047lang", "element b ref CORE.c");
		IResourcesSetupUtil.createFile("bug462047/src/c.bug462047lang", "element c");
		IResourcesSetupUtil.waitForBuild();
		IResourcesSetupUtil.assertNoErrorsInWorkspace();
		LoggingTester.captureLogging(Level.ERROR, BatchLinkableResource.class, ()-> {
			
			try {
				XtextEditor editor = openEditor(file);
				IXtextDocument document = editor.getDocument();
				document.readOnly((XtextResource res)->{
					EcoreUtil.resolveAll(res);
					ResourceSet resourceSet = res.getResourceSet();
					assertNull(resourceSet.getResource(URI.createURI("java:/Objects/CORE.CORE"), false));
					return null;
				});
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).assertNoLogEntries();
	}
}