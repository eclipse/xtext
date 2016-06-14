/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.common.io.CharStreams;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnicodeEscapeTest extends AbstractXtendUITestCase {
	
	@Inject
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Override
	public void tearDown() throws Exception {
		workbenchTestHelper.tearDown();
		super.tearDown();
	}
	
	@Test public void testUTF8Project() throws Exception {
		IProject project = getProject("UTF-8");
		createFile(project, 
				"@A('\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7')\n"+
				"@B('\\u03b1')\n"+
 				"class C { String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = '\\u03b1' + '''\u03c1\u03b5\u03c4\u03b7''' }\n" +
				"annotation A { String value }\n" +
				"annotation B { char value }");
		String contents = getGeneratedClass(project);
		String expectedContents = 
				"import org.eclipse.xtend2.lib.StringConcatenation;\n" + 
				"import org.eclipse.xtext.xbase.lib.Functions.Function0;\n" + 
				"\n" + 
				"@A(\"\u03b1\u03c1\u03b5\u03c4\u03b7\")\n"+ 
				"@B('\u03b1')\n"+ 
				"@SuppressWarnings(\"all\")\n" + 
				"public class C {\n" + 
				"  private String \u03b1\u03c1\u03b5\u03c4\u03b7 = new Function0<String>() {\n" + 
				"    public String apply() {\n" + 
				"      StringConcatenation _builder = new StringConcatenation();\n" + 
				"      _builder.append(\"\u03c1\u03b5\u03c4\u03b7\");\n" + 
				"      String _plus = (\"\u03b1\" + _builder);\n" + 
				"      return _plus;\n" + 
				"    }\n" + 
				"  }.apply();\n" + 
				"}\n" + 
				"";
		assertEquals(expectedContents, contents);
	}

	@Test public void testISO88591Project() throws Exception {
		IProject project = getProject("ISO-8859-1");
		createFile(project,
				"@A('\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7')\n"+
				"@B('\\u03b1')\n"+
 				"class C { String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = '\\u03b1' + '''\\u03c1\\u03b5\\u03c4\\u03b7''' }\n" +
				"annotation A { String value }\n" +
				"annotation B { char value }");
		String contents = getGeneratedClass(project);
		String expectedContents = 
				"import org.eclipse.xtend2.lib.StringConcatenation;\n" + 
				"import org.eclipse.xtext.xbase.lib.Functions.Function0;\n" + 
				"\n" + 
				"@A(\"\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7\")\n"+ 
				"@B('\\u03b1')\n"+ 
				"@SuppressWarnings(\"all\")\n" + 
				"public class C {\n" + 
				"  private String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = new Function0<String>() {\n" + 
				"    public String apply() {\n" + 
				"      StringConcatenation _builder = new StringConcatenation();\n" + 
				"      _builder.append(\"\\\\u03c1\\\\u03b5\\\\u03c4\\\\u03b7\");\n" + 
				"      String _plus = (\"\\u03b1\" + _builder);\n" + 
				"      return _plus;\n" + 
				"    }\n" + 
				"  }.apply();\n" + 
				"}\n" + 
				"";
		assertEquals(expectedContents, contents);
	}
	
	@Test public void testUTF8SourceISOTarget() throws Exception {
		IProject project = getProject("ISO-8859-1");
		createFile(project,
				"@A('\u03b1\u03c1\u03b5\u03c4\u03b7')\n"+
				"@B('\u03b1')\n"+
				"class C { /** comment \u03b1\u03c1\u03b5\u03c4\u03b7 */ String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = '\\u03b1' + '''\u03c1\u03b5\u03c4\u03b7''' }\n" +
				"annotation A { String value }\n" +
				"annotation B { char value }", "UTF-8");
		String contents = getGeneratedClass(project);
		String expectedContents = 
				"import org.eclipse.xtend2.lib.StringConcatenation;\n" + 
				"import org.eclipse.xtext.xbase.lib.Functions.Function0;\n" + 
				"\n" + 
				"@A(\"\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7\")\n"+ 
				"@B('\\u03b1')\n"+ 
				"@SuppressWarnings(\"all\")\n" + 
				"public class C {\n" + 
				"  /**\n" + 
				"   * comment \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7\n" + 
				"   */\n" +
				"  private String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = new Function0<String>() {\n" + 
				"    public String apply() {\n" + 
				"      StringConcatenation _builder = new StringConcatenation();\n" + 
				"      _builder.append(\"\\u03c1\\u03b5\\u03c4\\u03b7\");\n" + 
				"      String _plus = (\"\\u03b1\" + _builder);\n" + 
				"      return _plus;\n" + 
				"    }\n" + 
				"  }.apply();\n" + 
				"}\n" + 
				"";
		assertEquals(expectedContents, contents);
	}
	
	@Test public void testISOSourceUTF8Target() throws Exception {
		IProject project = getProject("UTF-8");
		createFile(project,
				"@A('\\u03b1\\u03c1\\u03b5\\u03c4\\u03b7')\n"+
				"@B('\\u03b1')\n"+
 				"class C { String \\u03b1\\u03c1\\u03b5\\u03c4\\u03b7 = '\\u03b1' + '''\\u03c1\\u03b5\\u03c4\\u03b7''' }\n" +
				"annotation A { String value }\n" +
				"annotation B { char value }", "ISO-8859-1");
		String contents = getGeneratedClass(project);
		String expectedContents = 
				"import org.eclipse.xtend2.lib.StringConcatenation;\n" + 
				"import org.eclipse.xtext.xbase.lib.Functions.Function0;\n" + 
				"\n" + 
				"@A(\"\u03b1\u03c1\u03b5\u03c4\u03b7\")\n"+ 
				"@B('\u03b1')\n"+ 
				"@SuppressWarnings(\"all\")\n" + 
				"public class C {\n" + 
				"  private String \u03b1\u03c1\u03b5\u03c4\u03b7 = new Function0<String>() {\n" + 
				"    public String apply() {\n" + 
				"      StringConcatenation _builder = new StringConcatenation();\n" + 
				"      _builder.append(\"\\\\u03c1\\\\u03b5\\\\u03c4\\\\u03b7\");\n" + 
				"      String _plus = (\"\u03b1\" + _builder);\n" + 
				"      return _plus;\n" + 
				"    }\n" + 
				"  }.apply();\n" + 
				"}\n" + 
				"";
		assertEquals(expectedContents, contents);
	}

	private IProject getProject(String encoding) throws CoreException {
		IProject project = workbenchTestHelper.getProject();
		ScopedPreferenceStore projectPreferenceStore = new ScopedPreferenceStore(new ProjectScope(project),	Platform.PI_RUNTIME);
		projectPreferenceStore.setValue(Platform.PREF_LINE_SEPARATOR, "\n");
		project.setDefaultCharset(encoding, null);
		return project;
	}

	private String getGeneratedClass(IProject project) throws IOException, CoreException {
		IFile compiledFile = project.getFile("xtend-gen/C.java");
		InputStream stream = compiledFile.getContents();
		try {
			String contents = CharStreams.toString(
					new InputStreamReader(stream, project.getDefaultCharset()));
			return contents;
		} finally {
			stream.close();
		}
	}

	private void createFile(IProject project, String content, String encoding) throws Exception {
		IFile file = workbenchTestHelper.createFile("Example.xtend", "");
		if (encoding == null)
			encoding = project.getDefaultCharset();
		else
			file.setCharset(encoding, null);
		file.setContents(new StringInputStream(content, encoding), true, true, null);
		project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, null);
	}

	private void createFile(IProject project, String content) throws Exception {
		createFile(project, content, null);
	}
}
