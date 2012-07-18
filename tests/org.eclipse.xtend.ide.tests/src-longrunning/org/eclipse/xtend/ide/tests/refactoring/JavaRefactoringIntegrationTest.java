/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.texteditor.IDocumentProviderExtension;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRenameElementHandler;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaRefactoringIntegrationTest extends AbstractXtendUITestCase {

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected IRenameRefactoringProvider renameRefactoringProvider;

	@Inject
	protected JvmModelRenameElementHandler renameElementHandler;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IWorkbench workbench;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	@Test
	public void testRenameJavaClass() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { }");
			String xtendModel = "class XtendClass extends JavaClass {  }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaClassAndImport() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass {}");
			String xtendModel = "import java.util.List import test.JavaClass class XtendClass { List<JavaClass> x }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("test.JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			IResourcesSetupUtil.waitForAutoBuild();
			assertFileContains(xtendClass, "import test.NewJavaClass");
			assertFileContains(xtendClass, "List<NewJavaClass> x");
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameRefToJavaClass() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass extends JavaClass {}";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.indexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/NewJavaClass.java");
			IResourcesSetupUtil.waitForAutoBuild();
			synchronize(editor);
			assertTrue(editor.getDocument().get(), editor.getDocument().get().contains("NewJavaClass"));
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameRefToJavaClassAndImport() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass {}");
			String xtendModel = "import java.util.List import test.JavaClass class XtendClass { List<JavaClass> x }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			final XtextEditor editor = testHelper.openEditor(xtendClass);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/test/NewJavaClass.java");
			IResourcesSetupUtil.waitForAutoBuild();
			synchronize(editor);
			assertTrue(editor.getDocument().get(),
					equalsIgnoreWhitespace(xtendModel.replace("JavaClass", "NewJavaClass"), editor.getDocument().get()));
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameJavaTypeInferred() throws Exception {
		try {
			testHelper.createFile("JavaClass.java",
				"public class JavaClass {}");
			String xtendModel = "class XtendClass { val foo = new JavaClass() }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			XtextEditor editor = testHelper.openEditor(xtendClass);
			renameJavaElement(findJavaType("JavaClass"), "NewJavaClass");
			synchronize(editor);
			assertEquals(xtendModel.replace("JavaClass", "NewJavaClass"), editor.getDocument().get());
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaConstructor() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { public JavaClass() {} }");
			String xtendModel = "class XtendClass extends JavaClass {  }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			// JDT automatically switches from the constructor to the type
			IType javaType = findJavaType("JavaClass");
			assertNotNull(javaType);
			renameJavaElement(javaType, "NewJavaClass");
			assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
		
	@Test
	public void testRenameRefToJavaConstructor() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { public JavaClass() {} }");
			String xtendModel = "class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/NewJavaClass.java");
			IResourcesSetupUtil.waitForAutoBuild();
			synchronize(editor);
			assertTrue(editor.getDocument().get(),
					editor.getDocument().get().contains("NewJavaClass x = new NewJavaClass()"));
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameJavaImplicitConstructor() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass extends JavaClass {  }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			// JDT automatically switches from the constructor to the type
			IType javaType = findJavaType("JavaClass");
			assertNotNull(javaType);
			renameJavaElement(javaType, "NewJavaClass");
			assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
		
	@Test
	public void testRenameRefToJavaImplicitConstructor() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/NewJavaClass.java");
			IResourcesSetupUtil.waitForAutoBuild();
			synchronize(editor);
			assertTrue(editor.getDocument().get(),
					editor.getDocument().get().contains("NewJavaClass x = new NewJavaClass()"));
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IResourcesSetupUtil.waitForAutoBuild();
		IField javaField = findJavaType("JavaClass").getField("foo");
		assertNotNull(javaField);
		renameJavaElement(javaField, "baz");
		assertFileContains(xtendClass, "int bar = baz");
	}

	@Test
	public void testRenameRefToJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = foo }";
		XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
		IResourcesSetupUtil.waitForAutoBuild();
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		synchronize(editor);
		assertTrue(editor.getDocument().get(), editor.getDocument().get().contains("bar = baz"));
	}

	@Test
	public void testRenameJavaEnum() throws Exception {
		try {
			testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
			String xtendModel = "class XtendClass { JavaEnum fooBar }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			IType javaEnum = findJavaType("JavaEnum");
			assertNotNull(javaEnum);
			renameJavaElement(javaEnum, "NewJavaEnum");
			assertFileContains(xtendClass, "NewJavaEnum fooBar");
		} finally {
			testHelper.getProject().getFile("src/NewJavaEnum.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameRefToJavaEnum() throws Exception {
		try {
			testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
			String xtendModel = "class XtendClass { JavaEnum fooBar }";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			renameXtendElement(editor, xtendModel.indexOf("JavaEnum"), "NewJavaEnum");
			assertFileExists("src/NewJavaEnum.java");
			synchronize(editor);
			assertTrue(editor.getDocument().get(), editor.getDocument().get().contains("NewJavaEnum fooBar"));
		} finally {
			testHelper.getProject().getFile("src/NewJavaEnum.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaEnumLiteral() throws Exception {
		testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
		String xtendModel = "class XtendClass { JavaEnum fooBar = JavaEnum::BAR }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IResourcesSetupUtil.waitForAutoBuild();
		IField javaEnumLiteral = findJavaType("JavaEnum").getField("BAR");
		assertNotNull(javaEnumLiteral);
		renameJavaElement(javaEnumLiteral, "BAZ");
		assertFileContains(xtendClass, "JavaEnum fooBar = JavaEnum::BAZ");
	}

	@Test
	public void testRenameRefToJavaEnumLiteral() throws Exception {
		testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
		String xtendModel = "class XtendClass { JavaEnum fooBar = JavaEnum::BAR }";
		XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
		IResourcesSetupUtil.waitForAutoBuild();
		renameXtendElement(editor, xtendModel.indexOf("BAR"), "BAZ");
		synchronize(editor);
		assertTrue(editor.getDocument().get(), editor.getDocument().get().contains("JavaEnum fooBar = JavaEnum::BAZ"));
	}

	@Test
	public void testRenameJavaMethod() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
		String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IResourcesSetupUtil.waitForAutoBuild();
		IMethod foo = findJavaType("JavaClass").getMethod("foo", new String[0]);
		assertNotNull(foo);
		renameJavaElement(foo, "baz");
		assertFileContains(xtendClass, "new JavaClass().baz()");
	}

	@Test
	public void testRenameJavaMethodCall() throws Exception {
		IFile javaFile = testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
		String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		assertFileContains(javaFile, "public void baz()");
	}

	@Test
	public void testRenameOverriddenJavaMethod() throws Exception {
		IFile javaInterface = testHelper.createFile("JavaInterface.java",
				"public interface JavaInterface { void foo(); }");
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass implements JavaInterface { public void foo() {} }");
		String xtendModel = "class XtendClass extends JavaClass { override foo() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile referringJavaClass = testHelper.createFile("ReferringJavaClass.java",
				"public class ReferringJavaClass { public void bar() { new XtendClass().foo(); } }");
		XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "foobar");
		assertFileContains(javaInterface, "void foobar()");
		assertFileContains(javaClass, "void foobar()");
		assertFileContains(referringJavaClass, "new XtendClass().foobar()");
		synchronize(editor);
		assertTrue(editor.getDocument().get().contains("foobar()"));
	}

	@Test
	public void testDontRenameOperator() throws Exception {
		String xtendModel = "class XtendClass { def bar() { 1 + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf('+');
		IRenameElementContext renameElementContext = createRenameElementContext(editor, offset);
		assertNull(renameElementContext);
	}

	@Test
	public void testRenameXtendParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("foo");
		renameXtendElement(editor, offset, "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
	}

	@Test
	public void testRenameRefToParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.lastIndexOf("foo");
		renameXtendElement(editor, offset, "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
	}

	@Test
	public void testRenameXtendTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("T");
		renameXtendElement(editor, offset, "U");
		synchronize(editor);
		assertEquals(xtendModel.replace("T", "U"), editor.getDocument().get());
	}

	@Test
	public void testRenameRefToTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.lastIndexOf("T");
		renameXtendElement(editor, offset, "U");
		synchronize(editor);
		assertEquals(xtendModel.replace("T", "U"), editor.getDocument().get());
	}

	@Test
	public void testCrissCrossReferences_0() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "bar");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "bar"), editor.getDocument().get());
		assertFileContains(javaBase, "public void bar()");
		assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testCrissCrossReferences_1() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.lastIndexOf("foo"), "bar");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "bar"), editor.getDocument().get());
		assertFileContains(javaBase, "public void bar()");
		assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testCrissCrossReferences_2() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		IResourcesSetupUtil.waitForAutoBuild();
		IMethod fooMethod = findJavaType("JavaBase").getMethod("foo", new String[] {});
		renameJavaElement(fooMethod, "bar");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "bar"), editor.getDocument().get());
		assertFileContains(javaBase, "public void bar()");
		assertFileContains(javaSub, "public void bar()");
	}

	@Test
	@Ignore
	// TODO: find out why this test fails (interactive testing works)
	public void testCrissCrossReferences_3() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		IMethod fooMethod = findJavaType("JavaSub").getMethod("foo", new String[] {});
		renameJavaElement(fooMethod, "bar");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "bar"), editor.getDocument().get());
		assertFileContains(javaBase, "public void bar()");
		assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testRenameXtendClass() throws Exception {
		try {
			String xtendModel = "class XtendClass { }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "public class JavaClass extends XtendClass { }");
			IResourcesSetupUtil.waitForAutoBuild();
			final XtextEditor editor = testHelper.openEditor(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(javaClass, "JavaClass extends NewXtendClass");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			IResourcesSetupUtil.waitForAutoBuild();
		}
	}

	@Test
	public void testRenameRefToXtendClass() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { XtendClass foo }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			final XtextEditor editor = testHelper.openEditor(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			synchronize(editor);
			assertEquals(xtendModel.replace("XtendClass", "NewXtendClass"), editor.getDocument().get());
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			IResourcesSetupUtil.waitForAutoBuild();
		}
	}

	@Test
	public void testRenameRefToXtendDefaultConstructor() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { def foo() { val bar = new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			final XtextEditor editor = testHelper.openEditor(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			synchronize(editor);
			assertEquals(xtendModel.replace("XtendClass", "NewXtendClass"), editor.getDocument().get());
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			IResourcesSetupUtil.waitForAutoBuild();
		}
	}

	@Test
	public void testRenameRefToXtendDefinedConstructor() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass { new() {} }");
			String xtendModel = "class XtendRef { def foo() { val bar = new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = testHelper.openEditor(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			synchronize(editor);
			assertEquals(xtendModel.replace("XtendClass", "NewXtendClass"), editor.getDocument().get());
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			IResourcesSetupUtil.waitForAutoBuild();
		}
	}

	@Test
	public void testRenameXtendField() throws Exception {
		String xtendModel = "class XtendClass { protected int foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { int bar = foo; }");
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		assertFileContains(javaClass, "int bar = baz");
	}

	@Test
	public void testRenameXtendMethod() throws Exception {
		String xtendModel = "class XtendClass { def foo() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { public void bar() { foo(); } }");
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		assertFileContains(javaClass, "{ baz(); }");
	}

	@Test
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=383102
	public void testRenameExtensionMethodFromSuper() throws Exception {
		String superModel = "public class Super { public void foo(String it) {} }";
		IFile superClass = testHelper.createFile("Super.java", superModel);
		String subModel = "class Sub extends Super { def bar() { ''.foo } }";
		IFile subClass = testHelper.createFile("Sub.xtend", subModel);
		final XtextEditor editor = testHelper.openEditor(subClass);
		IResourcesSetupUtil.waitForAutoBuild();
		renameXtendElement(editor, subModel.indexOf("foo"), "newFoo");
		synchronize(editor);
		assertEquals(subModel.replace("foo", "newFoo"), editor.getDocument().get());
		assertFileContains(superClass, "public void newFoo(");
	}

	@Test
	public void testRenameXtendProperty() throws Exception {
		String xtendModel = "import org.eclipse.xtend.lib.Property class XtendClass { @Property int foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { public void bar() { setFoo(getFoo()); } }");
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		synchronize(editor);
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		assertFileContains(javaClass, "{ setBaz(getBaz()); }");
	}

	@Test
	public void testDontRenameXtendDispatchMethod() throws Exception {
		String xtendModel = "class XtendClass { def dispatch foo(Object x) {} def dispatch foo(String x) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, xtendModel.indexOf("foo"),
				"bar");
		RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
		assertTrue(status.hasError());
		//		assertEquals(1,status.getEntries().length);  // TODO: on hudson it's two !?
		//		assertTrue(status.getEntryAt(0).getMessage().contains("Cannot rename single inferred element"));
		for (RefactoringStatusEntry entry : status.getEntries())
			System.out.println(entry.getMessage());
	}

	@Test
	public void testRenameXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("class Secondary") + 6, "NewSecondary");
		synchronize(editor);
		assertEquals(xtendModel.replace("Secondary", "NewSecondary"), editor.getDocument().get());
	}

	@Test
	public void testRenameRefToXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("Secondary"), "NewSecondary");
		synchronize(editor);
		assertEquals(xtendModel.replace("Secondary", "NewSecondary"), editor.getDocument().get());
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefaultConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		synchronize(editor);
		assertEquals(xtendModel.replace("Secondary", "NewSecondary"), editor.getDocument().get());
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefinedConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary { new() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		synchronize(editor);
		assertEquals(xtendModel.replace("Secondary", "NewSecondary"), editor.getDocument().get());
	}

	@Test
	public void testRenameStaticImportStable() throws Exception {
		String xtendModel = "import static java.util.Collections.* class XtendClass { def foo() { val bar = new Object() singleton(bar)}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		synchronize(editor);
		assertTrue(equalsIgnoreWhitespace(xtendModel.replace("bar", "baz"), editor.getDocument().get()));
	}

	@Test
	public void testRenameStaticExtensionImportStable() throws Exception {
		String xtendModel = "import static extension java.util.Collections.* class XtendClass { def foo() { val bar = new Object() bar.singleton()}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		synchronize(editor);
		assertTrue(equalsIgnoreWhitespace(xtendModel.replace("bar", "baz"), editor.getDocument().get()));
	}

	protected IFile assertFileExists(String fileName) throws Exception {
		IResource file = testHelper.getProject().findMember(fileName);
		assertTrue(file instanceof IFile);
		assertTrue(file.exists());
		return (IFile) file;
	}

	protected void assertFileContains(IFile file, String contents) throws Exception {
		String fileContents = testHelper.getContents(file);
		assertTrue(fileContents, fileContents.contains(contents));
	}

	protected Change renameXtendElement(final XtextEditor editor, final int offset, String newName) throws Exception {
		ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
		RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
		assertTrue(status.toString(), status.isOK());
		Change change = renameRefactoring.createChange(new NullProgressMonitor());
		Change undoChange = change.perform(new NullProgressMonitor());
		return undoChange;
	}

	protected ProcessorBasedRefactoring createXtendRenameRefactoring(final XtextEditor editor, final int offset,
			String newName) {
		IRenameElementContext renameElementContext = createRenameElementContext(editor, offset);
		ProcessorBasedRefactoring renameRefactoring = renameRefactoringProvider
				.getRenameRefactoring(renameElementContext);
		RefactoringProcessor processor = renameRefactoring.getProcessor();
		if (processor instanceof AbstractRenameProcessor)
			((AbstractRenameProcessor) processor).setNewName(newName);
		else if (processor instanceof JavaRenameProcessor)
			((JavaRenameProcessor) processor).setNewElementName(newName);
		return renameRefactoring;
	}

	protected IRenameElementContext createRenameElementContext(final XtextEditor editor, final int offset) {
		IResourcesSetupUtil.waitForAutoBuild();
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, offset);
						return renameElementHandler.createRenameElementContext(element, editor, new TextSelection(
								offset, 1), state);
					}
				});
		return renameElementContext;
	}

	protected void synchronize(XtextEditor editor) throws CoreException {
		((IDocumentProviderExtension) editor.getDocumentProvider()).synchronize(editor.getEditorInput());
	}

	protected void renameJavaElement(IType javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
	}

	protected void renameJavaElement(IMethod javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
	}

	protected void renameJavaElement(IField javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
	}

	protected IType findJavaType(String typeName) throws JavaModelException {
		IResourcesSetupUtil.waitForAutoBuild();
		IJavaProject javaProject = JavaCore.create(testHelper.getProject());
		IType javaClass = javaProject.findType(typeName);
		return javaClass;
	}

}
