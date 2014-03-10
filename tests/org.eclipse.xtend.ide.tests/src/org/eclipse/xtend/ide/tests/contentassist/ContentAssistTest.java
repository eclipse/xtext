/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xbase.junit.ui.AbstractXbaseContentAssistInBlockTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractXbaseContentAssistInBlockTest {
	
	protected static String[] VARIABLE_DECL = {"val", "var", "extension"};

	private static IProject project;
	
	@BeforeClass
	public static void setUpProject() throws Exception {
		project = createPluginProject(PROJECT_NAME);
		doInitFeatures(JavaCore.create(project));
	}

	@AfterClass
	public static void tearDownProject() throws Exception {
		WorkbenchTestHelper.deleteProject(project);
		project = null;
	}
	
	@Override
	protected String[] getVariableDeclarationKeywords() {
		return VARIABLE_DECL;
	}
	
	// all these test cases declared a local variable 'this' which is not allowed in Xtend
	@Override
	@Test public void testForLoop_06() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, getKeywordsAndStatics()));
	}
	
	@Override
	@Test public void testForLoop_07() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, getKeywordsAndStatics()));
	}
	
	@Override
	@Test public void testAfterVariableDeclaration_05() throws Exception {
		newBuilder().appendNl("var x = '';").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterVariableDeclaration_06() throws Exception {
		newBuilder().appendNl("var x = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterVariableDeclaration_07() throws Exception {
		newBuilder().appendNl("var x = ''").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Override
	@Test public void testAfterVariableDeclaration_08() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Override
	@Test public void testAfterVariableDeclaration_10() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ").assertText(expect(new String[] {"x"}, getKeywordsAndStatics()));
	}
	
	@Test public void testRichString_01() throws Exception {
		newBuilder().append("'''foobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_02() throws Exception {
		newBuilder().append("'''foobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_03() throws Exception {
		newBuilder().append("'''«null»zonkfoobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_04() throws Exception {
		newBuilder().append("'''«null»zonkfoobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_05() throws Exception {
		newBuilder().append("'''\n««« comment \nfoobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_06() throws Exception {
		newBuilder().append("'''\n««« comment \nfoobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	@Test public void testRichString_07() throws Exception {
		newBuilder().append("'''\n««« comment foobar'''").assertTextAtCursorPosition("foobar");
	}
	
	@Test public void testRichString_08() throws Exception {
		newBuilder().append("'''\n««« comment foobar«null»'''").assertTextAtCursorPosition("foobar");
	}
	
	@Override
	@Test
	public void testClosure_01() throws Exception {
		newBuilder().append("[String a, String b|").assertText(expect(new String[]{"a", "b"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
		
	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("super");
		result.add("this");
		result.add("class");
		result.add("clone");
		result.add("hashCode");
		result.add("toString");
		result.add("finalize");
		result.add("notify");
		result.add("notifyAll");
		result.add("equals()");
		result.add("wait");
		result.add("wait()");
		result.add("wait()");
		// ObjectExtensions
		result.add("identityEquals()");
		return result.toArray(new String[result.size()]);
	}
	
	@Override
	public String[] getStringFeatures() {
		ArrayList<String> features = newArrayList(super.getStringFeatures());
		return features.toArray(new String[features.size()]);
	}
	
	@Override
	protected String getSuffix() {
		return "\n}\n}";
	}
	
	@Override
	protected String getPrefix() {
		return "class Name { def _operation() {";
	}
	
	protected static final String PROJECT_NAME = "ContentAssistTestProject";

	private IProject demandCreateProject;
	
	@Override
	protected Injector getInjector() {
		return XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend");
	}
	
	@Override
	public void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}

	@Override
	protected boolean doCleanWorkspace() {
		return false;
	}
	
	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		IJavaProject javaProject = findJavaProject(PROJECT_NAME);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = createPluginProject(PROJECT_NAME);
				javaProject = findJavaProject(PROJECT_NAME);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	public static IProject createPluginProject(String name) throws CoreException {
		Injector injector = XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder",
			XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(Lists.newArrayList(
				"org.eclipse.xtext.xbase.lib"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		JavaProjectSetupUtil.makeJava5Compliant(JavaCore.create(result));
		return result;
	}
}
