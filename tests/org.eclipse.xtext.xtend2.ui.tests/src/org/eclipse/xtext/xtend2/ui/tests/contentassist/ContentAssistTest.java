/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.contentassist;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xbase.junit.ui.AbstractXbaseContentAssistInBlockTest;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractXbaseContentAssistInBlockTest implements IJavaProjectProvider {
	
	@Override
	public void testForLoop_02() throws Exception {
		//TODO fails
	}

	// all these test cases declared a local variable 'this' which is not allowed in Xtend
	@Override
	public void testForLoop_06() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, getKeywordsAndStatics()));
	}
	
	@Override
	public void testForLoop_07() throws Exception {
		newBuilder().append("for (String s: null) ").assertText(expect(new String[]{"s"}, getKeywordsAndStatics()));
	}
	
	@Override
	public void testAfterVariableDeclaration_05() throws Exception {
		newBuilder().appendNl("var x = '';").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	public void testAfterVariableDeclaration_06() throws Exception {
		newBuilder().appendNl("var x = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	public void testAfterVariableDeclaration_07() throws Exception {
		newBuilder().appendNl("var x = ''").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Override
	public void testAfterVariableDeclaration_08() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Override
	public void testAfterVariableDeclaration_10() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ").assertText(expect(new String[] {"x"}, getKeywordsAndStatics()));
	}
	
	public void testRichString_01() throws Exception {
		newBuilder().append("'''foobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_02() throws Exception {
		newBuilder().append("'''foobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''foobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_03() throws Exception {
		newBuilder().append("'''«null»zonkfoobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_04() throws Exception {
		newBuilder().append("'''«null»zonkfoobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''«null»zonkfoobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_05() throws Exception {
		newBuilder().append("'''\n««« comment \nfoobar'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_06() throws Exception {
		newBuilder().append("'''\n««« comment \nfoobar«null»'''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»''").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»'").assertTextAtCursorPosition("foobar", "«»");
		newBuilder().append("'''\n««« comment \nfoobar«null»").assertTextAtCursorPosition("foobar", "«»");
	}
	
	public void testRichString_07() throws Exception {
		newBuilder().append("'''\n««« comment foobar'''").assertTextAtCursorPosition("foobar");
	}
	
	public void testRichString_08() throws Exception {
		newBuilder().append("'''\n««« comment foobar«null»'''").assertTextAtCursorPosition("foobar");
	}
	
	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("super");
		result.add("this");
//		result.add("clone");
		result.add("hashCode");
		result.add("toString");
//		result.add("finalize");
		result.add("notify");
		result.add("notifyAll");
		result.add("equals()");
		result.add("wait");
		result.add("wait()");
		result.add("wait()");
		return result.toArray(new String[result.size()]);
	}
	
	@Override
	public String[] getStringFeatures() {
		ArrayList<String> features = newArrayList(super.getStringFeatures());
		features.remove("class");
		return features.toArray(new String[features.size()]);
	}
	
	
	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		final String prefix = "class Name { def _operation() {";
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(getInjector(), this) {
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition,
					String... expectedText) throws Exception {
				append("\n}\n}");
				return super.assertTextAtCursorPosition(cursorPosition, expectedText);
			}
			
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(String cursorPosition, int offset,
					String... expectedText) throws Exception {
				return assertTextAtCursorPosition(getModel().indexOf(cursorPosition, prefix.length()) + offset, expectedText);
			}
			
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(String cursorPosition,
					String... expectedText) throws Exception {
				return assertTextAtCursorPosition(getModel().indexOf(cursorPosition, prefix.length()), expectedText);
			}
			
		};
		return builder.appendNl(prefix);
	}
	
	protected static final String PROJECT_NAME = "ContentAssistTestProject";

	private IProject demandCreateProject;
	
	@Override
	protected Injector getInjector() {
		return Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
	}
	
	@Override
	protected void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}

	@Override
	protected boolean doCleanWorkspace() {
		return false;
	}
	
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

	@Override
	protected XtextResourceSet getResourceSet() {
		XtextResourceSet resourceSet = super.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		return resourceSet;
	}
	
	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}
	
	@Override
	public XtextResource getResourceFor(InputStream stream) {
		XtextResource result = super.getResourceFor(stream);
		initializeTypeProvider(result);
		return result;
	}
	
	public static Test suite() {
		return new TestSetup(new TestSuite(ContentAssistTest.class)) {
			private IProject project;

			@Override
			protected void setUp() throws Exception {
				super.setUp();
				project = createPluginProject(PROJECT_NAME);
				
			}
			
			@Override
			protected void tearDown() throws Exception {
				deleteProject(project);
				super.tearDown();
			}
		};
	}
	
	public static IProject createPluginProject(String name) throws CoreException {
		Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
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
				"org.eclipse.xtext.xbase.lib", "org.eclipse.xtend2.lib"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		JavaProjectSetupUtil.makeJava5Compliant(JavaCore.create(result));
		return result;
	}
}
