/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.util.Collections;

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
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xbase.ui.internal.XtypeActivator;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistInBlockTest extends ContentAssistTest implements IJavaProjectProvider {

	private static final String PROJECT_NAME = "ContentAssistTestProject";

	private IProject demandCreateProject;
	
	@Override
	protected void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}

	@Override
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(getInjector(), this) {
			@Override
			public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition,
					String... expectedText) throws Exception {
				append("\n}");
				return super.assertTextAtCursorPosition(cursorPosition, expectedText);
			}
		};
		return builder.appendNl("{");
	}
	
	protected static String[] VARIABLE_DECL = {"val", "var"};
	
	@Override
	public void testEmptyInput() throws Exception {
		newBuilder().assertText(expect(KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_01() throws Exception {
		newBuilder().append("''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_03() throws Exception {
		newBuilder().append("''.").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_04() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_10() throws Exception {
		newBuilder().append("'' ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_12() throws Exception {
		newBuilder().append("'' .").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_13() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_28() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_30() throws Exception {
		newBuilder().append("('')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_32() throws Exception {
		newBuilder().append("(''.toString)").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testOnStringLiteral_34() throws Exception {
		newBuilder().append("''.toString ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
//TODO
//	@Override
//	public void testOnStringLiteral_35() throws Exception {
//		newBuilder().append("''.toString .").assertTextAtCursorPosition("g .", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS, VARIABLE_DECL));
//	}
	
	@Override
	public void testOnStringLiteral_36() throws Exception {
		newBuilder().append("''.toString +''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testAfterBinaryOperation_01() throws Exception {
		newBuilder().append("''+''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testAfterBinaryOperation_02() throws Exception {
		newBuilder().append("'' + ''+''").assertTextAtCursorPosition("''+", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testAfterBinaryOperation_03() throws Exception {
		newBuilder().append("(''+'')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	@Override
	public void testAfterBinaryOperation_05() throws Exception {
		newBuilder().append("((''+''))").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	public void testForLoop_04() throws Exception {
		super.newBuilder().append("for (String this: null) ").assertText(expect(new String[]{"this"}, STRING_FEATURES, KEYWORDS_AND_STATICS));
	}
	
	public void testForLoop_05() throws Exception {
		newBuilder().append("for (String this: null) ").assertText(expect(new String[]{"this"}, STRING_FEATURES, KEYWORDS_AND_STATICS));
	}
	
	public void testAfterVariableDeclaration_01() throws Exception {
		newBuilder().appendNl("var x = '';").assertText(expect(new String[] {"x"}, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	public void testAfterVariableDeclaration_02() throws Exception {
		newBuilder().appendNl("var x = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, KEYWORDS_AND_STATICS, VARIABLE_DECL));
	}
	
	public void testAfterVariableDeclaration_03() throws Exception {
		newBuilder().appendNl("var x = ''").assertText(expect(new String[] {"x"}, KEYWORDS_AND_STATICS, CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	public void testAfterVariableDeclaration_04() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, KEYWORDS_AND_STATICS, CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	public void testAfterVariableDeclaration_05() throws Exception {
		newBuilder().appendNl("var this = '';").assertText(expect(new String[] {"this"}, KEYWORDS_AND_STATICS, VARIABLE_DECL, STRING_FEATURES));
	}
	
	public void testAfterVariableDeclaration_06() throws Exception {
		newBuilder().appendNl("var this = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"this"}, KEYWORDS_AND_STATICS, VARIABLE_DECL, STRING_FEATURES));
	}
	
	public void testAfterVariableDeclaration_07() throws Exception {
		newBuilder().appendNl("var this = ''").assertText(expect(new String[] {"this"}, KEYWORDS_AND_STATICS, CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS, STRING_FEATURES));
	}
	
	public void testAfterVariableDeclaration_08() throws Exception {
		newBuilder().appendNl("var this = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"this"}, KEYWORDS_AND_STATICS, CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS, STRING_FEATURES));
	}
	
	public void testAfterVariableDeclaration_09() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ").assertText(expect(new String[] {"x"}, KEYWORDS_AND_STATICS));
	}
	
	public void testAfterVariableDeclaration_10() throws Exception {
		newBuilder().appendNl("var this = ''").appendNl("var y = ").assertText(expect(new String[] {"this"}, KEYWORDS_AND_STATICS, STRING_FEATURES));
	}
	
	@Override
	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
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
	
	public static Test suite() {
		return new TestSetup(new TestSuite(ContentAssistInBlockTest.class)) {
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
	
	protected static IProject createPluginProject(String name) throws CoreException {
		Injector injector = XtypeActivator.getInstance().getInjector("org.eclipse.xtext.xbase.Xbase");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder",
			XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(Collections.singletonList("org.eclipse.xtext.xbase.lib"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}

}
