/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.ui.refactoring.participant.CompositeRefactoringProcessor;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
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
	protected IRenameContextFactory renameContextFactory;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IWorkbench workbench;

	@Inject 
	private FileAsserts fileAsserts;
	
	@Inject 
	private SyncUtil syncUtil;
	
	@Inject 
	private CompositeRefactoringProcessor.Access compositeRefactoringProcessorAccess;
	
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
			fileAsserts.assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaClassReferenceToStaticField() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { public static int staticField; }");
			String xtendModel = "class XtendClass { int foo = JavaClass::staticField }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, "int foo = NewJavaClass::staticField");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaClassAndImport() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass {}");
			String xtendModel = "import java.util.List\n"
					+ "import test.JavaClass\n"
					+ "\n"
					+ "class XtendClass { List<JavaClass> x }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("test.JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, "import test.NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, xtendModel.replace("JavaClass", "NewJavaClass"));
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaClassAndImportReferenceToStaticField() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass {  public static int staticField; }");
			String xtendModel = "import java.util.List\n"
					+ "import test.JavaClass\n"
					+ "\n"
					+ "class XtendClass { int foo = JavaClass::staticField }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("test.JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, "import test.NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, xtendModel.replace("JavaClass", "NewJavaClass"));
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameRefToJavaClass() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass extends JavaClass {}";
			XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.indexOf("JavaClass"), "NewJavaClass");
			fileAsserts.assertFileExists("src/NewJavaClass.java");
			assertDocumentContains(editor, "NewJavaClass");
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
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			fileAsserts.assertFileExists("src/test/NewJavaClass.java");
			assertDocumentContainsIgnoreWhitespace(editor, xtendModel.replace("JavaClass", "NewJavaClass"));
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameOuterJavaClass() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Inner {} }");
			String xtendModel = "import test.JavaClass\n"
					+ "\n"
					+ "class XtendClass extends JavaClass$Inner {  }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaClass = findJavaType("test.JavaClass");
			assertNotNull(javaClass);
			renameJavaElement(javaClass, "NewJavaClass");
			fileAsserts.assertFileContains(xtendClass, xtendModel.replace("JavaClass", "NewJavaClass").replace('$', '.'));
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameInnerJavaClassImportOuter() throws Exception {
		testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Inner {} }");
		String xtendModel = "import test.JavaClass\n"
				+ "\n"
				+ "class XtendClass extends JavaClass$Inner {  }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IType javaClass = findJavaType("test.JavaClass.Inner");
		assertNotNull(javaClass);
		renameJavaElement(javaClass, "NewInner");
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("Inner", "NewInner").replace('$', '.'));
	}

	@Test
	public void testRenameInnerJavaClassImportInner() throws Exception {
		testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Inner {} }");
		String xtendModel = "import test.JavaClass$Inner\n"
				+ "\n"
				+ "class XtendClass extends Inner {  }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IType javaClass = findJavaType("test.JavaClass.Inner");
		assertNotNull(javaClass);
		renameJavaElement(javaClass, "NewInner");
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("Inner", "NewInner").replace('$', '.'));
	}

	@Test
	public void testRenameMiddleJavaClass() throws Exception {
		testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Middle { public static class Inner {} } }");
		String xtendModel = "import test.JavaClass\n"
				+ "\n"
				+ "class XtendClass extends JavaClass$Middle$Inner {  }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IType javaClass = findJavaType("test.JavaClass.Middle");
		assertNotNull(javaClass);
		renameJavaElement(javaClass, "NewMiddle");
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("Middle", "NewMiddle").replace('$', '.'));
	}

	@Test
	public void testRenameJavaTypeInferred() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass { val foo = new JavaClass() }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			XtextEditor editor = openEditorSafely(xtendClass);
			renameJavaElement(findJavaType("JavaClass"), "NewJavaClass");
			assertDocumentContains(editor, xtendModel.replace("JavaClass", "NewJavaClass"));
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
			fileAsserts.assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
		
	@Test
	public void testRenameRefToJavaConstructor() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public JavaClass() {} }");
			String xtendModel = "import test.JavaClass class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			fileAsserts.assertFileExists("src/test/NewJavaClass.java");
			assertDocumentContains(editor, "{ NewJavaClass x = new NewJavaClass() }");
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameRefToJavaConstructorSamePackage() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public JavaClass() {} }");
			String xtendModel = "package test class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			fileAsserts.assertFileExists("src/test/NewJavaClass.java");
			assertDocumentContains(editor, "NewJavaClass x = new NewJavaClass()");
		} finally {
			testHelper.getProject().getFile("src/test/NewJavaClass.java").delete(true, new NullProgressMonitor());
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
			fileAsserts.assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
		
	@Test
	public void testRenameRefToJavaImplicitConstructor() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			fileAsserts.assertFileExists("src/NewJavaClass.java");
			assertDocumentContains(editor, "NewJavaClass x = new NewJavaClass()");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameJavaConstructorOfInnerClass() throws Exception {
		testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Inner {} }");
		String xtendModel = "import test.JavaClass\n"
				+ "\n"
				+ "class XtendClass { def foo() { new JavaClass$Inner() }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IType javaType = findJavaType("test.JavaClass.Inner");
		assertNotNull(javaType);
		renameJavaElement(javaType, "NewInner");
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("Inner",  "NewInner").replace('$', '.'));
	}
		
	@Test
	public void testRenameJavaConstructorOfImportedInnerClass() throws Exception {
		testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public static class Inner {} }");
		String xtendModel = "import test.JavaClass$Inner\n"
				+ "\n"
				+ "class XtendClass { def foo() { new Inner() }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IType javaType = findJavaType("test.JavaClass.Inner");
		assertNotNull(javaType);
		renameJavaElement(javaType, "NewInner");
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("Inner",  "NewInner").replace('$', '.'));
	}
		
	@Test
	public void testRenameJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IField javaField = findJavaType("JavaClass").getField("foo");
		assertNotNull(javaField);
		renameJavaElement(javaField, "baz");
		fileAsserts.assertFileContains(xtendClass, "int bar = baz");
	}

	@Test
	public void testRenameStaticJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected static int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = JavaClass::foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IField javaField = findJavaType("JavaClass").getField("foo");
		assertNotNull(javaField);
		renameJavaElement(javaField, "baz");
		fileAsserts.assertFileContains(xtendClass, "int bar = JavaClass::baz");
	}

	@Test
	public void testRenameRefToJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = foo }";
		XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertDocumentContains(editor, "bar = baz");
	}

	@Test
	public void testRenameJavaEnum() throws Exception {
		try {
			testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
			String xtendModel = "class XtendClass { JavaEnum fooBar }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IType javaEnum = findJavaType("JavaEnum");
			assertNotNull(javaEnum);
			renameJavaElement(javaEnum, "NewJavaEnum");
			fileAsserts.assertFileContains(xtendClass, "NewJavaEnum fooBar");
		} finally {
			testHelper.getProject().getFile("src/NewJavaEnum.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameRefToJavaEnum() throws Exception {
		try {
			testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
			String xtendModel = "class XtendClass { JavaEnum fooBar }";
			XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.indexOf("JavaEnum"), "NewJavaEnum");
			fileAsserts.assertFileExists("src/NewJavaEnum.java");
			assertDocumentContains(editor, "NewJavaEnum fooBar");
		} finally {
			testHelper.getProject().getFile("src/NewJavaEnum.java").delete(true, new NullProgressMonitor());
		}
	}

	@Test
	public void testRenameJavaEnumLiteral() throws Exception {
		testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
		String xtendModel = "class XtendClass { JavaEnum fooBar = JavaEnum::BAR }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IField javaEnumLiteral = findJavaType("JavaEnum").getField("BAR");
		assertNotNull(javaEnumLiteral);
		renameJavaElement(javaEnumLiteral, "BAZ");
		fileAsserts.assertFileContains(xtendClass, "JavaEnum fooBar = JavaEnum::BAZ");
	}

	@Test
	public void testRenameRefToJavaEnumLiteral() throws Exception {
		testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
		String xtendModel = "class XtendClass { JavaEnum fooBar = JavaEnum::BAR }";
		XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
		renameXtendElement(editor, xtendModel.indexOf("BAR"), "BAZ");
		assertDocumentContains(editor, "JavaEnum fooBar = JavaEnum::BAZ");
	}

	@Test
	public void testRenameJavaMethod() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
		String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IMethod foo = findJavaType("JavaClass").getMethod("foo", new String[0]);
		assertNotNull(foo);
		renameJavaElement(foo, "baz");
		fileAsserts.assertFileContains(xtendClass, "new JavaClass().baz()");
	}

	@Test
	public void testRenameJavaMethodCall() throws Exception {
		IFile javaFile = testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
		String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		fileAsserts.assertFileContains(javaFile, "public void baz()");
	}

	@Test
	public void testRenameMethodCallNextToConstructor() throws Exception {
		IFile xtendClass0 = testHelper.createFile("XtendClass0.xtend", "class XtendClass0 { def foo() {} }");
		String xtendModel1 = "class XtendClass1 { def bar() { val x = new XtendClass0() x.foo() } }";
		IFile xtendClass1 = testHelper.createFile("XtendClass1.xtend", xtendModel1);
		final XtextEditor editor = openEditorSafely(xtendClass1);
		renameXtendElement(editor, xtendModel1.indexOf("foo"), "baz");
		assertEquals(xtendModel1.replace("foo", "baz"), editor.getDocument().get());
		fileAsserts.assertFileContains(xtendClass0, "def baz()");
	}

	@Test
	public void testRenameMethodCall_Getters_0() throws Exception {
		String xtendModel = "class XtendClass { def getFoo() {null} def bar() { foo getFoo getFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("getFoo"), "getBaz");
		assertDocumentContains(editor, xtendModel.replace("getFoo", "getBaz").replace("foo", "baz"));
	}

	@Test
	public void testRenameMethodCall_Getters_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = 1 def getFoo() {null} def bar() { foo getFoo getFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("getFoo"), "getBaz");
		assertDocumentContains(editor, xtendModel.replace("getFoo", "getBaz").replace("foo", "getBaz"));
	}

	@Test
	public void testRenameMethodCall_Getters_2() throws Exception {
		String xtendModel = "class XtendClass { def getFoo(String x) {} def bar() { ''.foo ''.getFoo ''.getFoo() getFoo('') } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("getFoo"), "getBaz");
		assertDocumentContains(editor, xtendModel.replace("getFoo", "getBaz").replace("foo", "baz"));
	}

	@Test
	public void testRenameMethodCall_BooleanIs_0() throws Exception {
		String xtendModel = "class XtendClass { def isFoo() {false} def bar() { foo isFoo isFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("isFoo"), "isBaz");
		assertDocumentContains(editor, xtendModel.replace("isFoo", "isBaz").replace("foo", "baz"));
	}
	
	@Test
	public void testRenameMethodCall_BooleanIs_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = false def isFoo() {false} def bar() { foo isFoo isFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("isFoo"), "isBaz");
		assertDocumentContains(editor, xtendModel.replace("isFoo", "isBaz").replace("foo", "isBaz"));
	}
	
	@Test
	public void testRenameMethodCall_Setters_0() throws Exception {
		String xtendModel = "class XtendClass { def setFoo(Object x) {} def bar() { foo=null setFoo(null) } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("setFoo"), "setBaz");
		assertDocumentContains(editor, xtendModel.replace("setFoo", "setBaz").replace("foo", "baz"));
	}

	@Test
	public void testRenameMethodCall_Setters_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = null def setFoo(Object x) {} def bar() { foo=null } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElementWithError(editor, xtendModel.indexOf("setFoo"), "setBaz");
	}

	@Test
	public void testRenameMethodCall_Setters_2() throws Exception {
		String xtendModel = "class XtendClass { def setBaz(Object x) {} def setFoo(Object x) {} def bar() { setFoo(null) } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElementWithError(editor, xtendModel.indexOf("setFoo"), "setBaz");
	}

	@Test
	public void bug394655() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { public void setFoo() {} public void addFoo(int x) {} }");
		String xtendModel = "class XtendClass { def bar(JavaClass java) { java.addFoo(1) java.setFoo()  }";
		XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
		renameXtendElement(editor, xtendModel.indexOf("addFoo"), "setFoo");
		assertDocumentContains(editor, xtendModel.replace("addFoo", "setFoo"));
	}

	@Ignore("TODO")
	@Test
	public void bug394655_2() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { public void setFoo() {} public void addFoo(int x) {} }");
		String xtendModel = "class XtendClass { def bar(JavaClass java) { java.addFoo(1) java.setFoo()  }";
		XtextEditor editor = openEditorSafely("XtendClass.xtend", xtendModel);
		renameXtendElement(editor, xtendModel.indexOf("setFoo"), "addFoo");
		assertDocumentContains(editor, xtendModel.replace("setFoo", "addFoo"));
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
		XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "foobar");
		fileAsserts.assertFileContains(javaInterface, "void foobar()");
		fileAsserts.assertFileContains(javaClass, "void foobar()");
		fileAsserts.assertFileContains(referringJavaClass, "new XtendClass().foobar()");
		assertDocumentContains(editor, "foobar()");
	}

	@Test
	public void testRenameXtendDispatchMethod() throws Exception {
		String xtendModel = "class XtendClass { def dispatch foo(String x) {} def dispatch foo(Object x) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		String javaCallerModel = "public class JavaCaller { void bar(XtendClass x) { x.foo(null); x._foo(\"\"); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(XtendClass x) { x.foo(null) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendDispatchMethod_1() throws Exception {
		String superModel = "class Super { def dispatch foo(Integer x) {} }";
		IFile superClass = testHelper.createFile("Super.xtend", superModel);
		String subModel = "class Sub extends Super { def dispatch foo(String x) {} }";
		IFile subClass = testHelper.createFile("Sub.xtend", subModel);
		String javaCallerModel = "public class JavaCaller { void bar(Sub x) { x.foo(new Object()); x._foo(\"\"); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(Super x) { x.foo(1) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		final XtextEditor editor = openEditorSafely(superClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, superModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, superModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(subClass, subModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendDispatchMethod_2() throws Exception {
		String superModel = "class Super { def dispatch foo(Integer x) {} }";
		IFile superClass = testHelper.createFile("Super.xtend", superModel);
		String subModel = "class Sub extends Super { def dispatch foo(String x) {} }";
		IFile subClass = testHelper.createFile("Sub.xtend", subModel);
		String javaCallerModel = "public class JavaCaller { void bar(Sub x) { x.foo(new Object()); x._foo(\"\"); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(Super x) { x.foo(1) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		final XtextEditor editor = openEditorSafely(subClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, subModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, subModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(superClass, superModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendDispatchMethod_3() throws Exception {
		String superModel = "public class Super { public void _foo(Integer x) {} }";
		IFile superClass = testHelper.createFile("Super.java", superModel);
		String subModel = "class Sub extends Super { def dispatch foo(String x) {} }";
		IFile subClass = testHelper.createFile("Sub.xtend", subModel);
		String javaCallerModel = "public class JavaCaller { void bar(Super x) { x._foo(1); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(Sub x) { x.foo(1) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		final XtextEditor editor = openEditorSafely(subClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, subModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, subModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(superClass, superModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendDispatchMethod_4() throws Exception {
		String superModel = "public class Super { public void _foo(Integer x) {} }";
		IFile superClass = testHelper.createFile("Super.java", superModel);
		testHelper.createFile("Sub.xtend", "class Sub extends Super {}");
		String subsub0Model = "class SubSub0 extends Sub { def dispatch foo(String x) {} }";
		IFile subsub0Class = testHelper.createFile("SubSub0.xtend", subsub0Model);
		String subsub1Model = "class SubSub1 extends Sub { def dispatch foo(String x) {} }";
		IFile subsub1Class = testHelper.createFile("SubSub1.xtend", subsub1Model);
		final XtextEditor editor = openEditorSafely(subsub0Class);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, subsub0Model.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, subsub0Model.replace("foo", "baz"));
		fileAsserts.assertFileContains(superClass, superModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(subsub1Class, subsub1Model.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendDispatchMethod_5() throws Exception {
		String superModel = "class Super { def dispatch foo(Integer x) {} }";
		IFile superClass = testHelper.createFile("Super", superModel);
		testHelper.createFile("Sub.java", "public class Sub extends Super {}");
		String subsub0Model = "class SubSub0 extends Sub { def dispatch foo(String x) {} }";
		IFile subsub0Class = testHelper.createFile("SubSub0.xtend", subsub0Model);
		String subsub1Model = "class SubSub1 extends Sub { def dispatch foo(String x) {} }";
		IFile subsub1Class = testHelper.createFile("SubSub1.xtend", subsub1Model);
		final XtextEditor editor = openEditorSafely(subsub0Class);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, subsub0Model.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, subsub0Model.replace("foo", "baz"));
		fileAsserts.assertFileContains(superClass, superModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(subsub1Class, subsub1Model.replace("foo", "baz"));
	}

	@Test
	public void testRenameRefToXtendDispatchMethod() throws Exception {
		String xtendModel = "class XtendClass { def dispatch foo(Object x) {} def dispatch foo(String x) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		String javaCallerModel = "public class JavaCaller { void bar(XtendClass x) { x.foo(null); x._foo(\"\"); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(XtendClass x) { x.foo(null) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		final XtextEditor editor = openEditorSafely(xtendCaller);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, xtendCallerModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, xtendCallerModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(xtendClass, xtendModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
	}

	@Test
	public void testDontRenameOperatorCall() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("+");
		renameXtendElementWithError(editor, offset, "operator_doesNotExist");
	}

	@Test
	public void testRenameOperatorDef() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElement(editor, offset, "operator_minus");
		assertDocumentContains(editor, xtendModel.replace("operator_plus", "operator_minus").replace("+", "-"));
	}
	
	@Test
	public void testRenameOperatorDefToOperator() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElement(editor, offset, "-");
		assertDocumentContains(editor, xtendModel.replace("operator_plus", "-").replace("+", "-"));
	}
	
	@Test
	public void testRenameOperatorDefOnCallsite() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("+");
		renameXtendElement(editor, offset, "operator_minus");
		assertDocumentContains(editor, xtendModel.replace("operator_plus", "operator_minus").replace("+", "-"));
	}
	
	@Test
	public void testDontRenameOperatorDefWhenNewNameIsUnmappedOperator() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElementWithError(editor, offset, "operator_doesNotExist");
	}

	@Test
	public void testRenameOperatorDefWhenNotReferenced() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElement(editor, offset, "operator_minus");
		assertDocumentContains(editor, xtendModel.replace("operator_plus", "operator_minus"));
	}

	@Test
	public void testRenameXtendParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("foo");
		renameXtendElement(editor, offset, "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameRefToParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.lastIndexOf("foo");
		renameXtendElement(editor, offset, "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.indexOf("T");
		renameXtendElement(editor, offset, "U");
		assertDocumentContains(editor, xtendModel.replace("T", "U"));
	}

	@Test
	public void testRenameRefToTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		final int offset = xtendModel.lastIndexOf("T");
		renameXtendElement(editor, offset, "U");
		assertDocumentContains(editor, xtendModel.replace("T", "U"));
	}

	@Test
	public void testCrissCrossReferences_0() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
		fileAsserts.assertFileContains(javaBase, "public void bar()");
		fileAsserts.assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testCrissCrossReferences_1() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.lastIndexOf("foo"), "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
		fileAsserts.assertFileContains(javaBase, "public void bar()");
		fileAsserts.assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testCrissCrossReferences_2() throws Exception {
		IFile javaBase = testHelper.createFile("JavaBase.java", "public interface JavaBase { public void foo(); }");
		IFile javaSub = testHelper.createFile("JavaSub.java",
				"public class JavaSub implements JavaBase { public void foo() {} }");
		String xtendModel = "class XtendClass implements JavaBase { override foo() { new JavaSub().foo }}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		IMethod fooMethod = findJavaType("JavaBase").getMethod("foo", new String[] {});
		renameJavaElement(fooMethod, "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
		fileAsserts.assertFileContains(javaBase, "public void bar()");
		fileAsserts.assertFileContains(javaSub, "public void bar()");
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
		final XtextEditor editor = openEditorSafely(xtendClass);
		IMethod fooMethod = findJavaType("JavaSub").getMethod("foo", new String[] {});
		renameJavaElement(fooMethod, "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
		fileAsserts.assertFileContains(javaBase, "public void bar()");
		fileAsserts.assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testRenameXtendClass() throws Exception {
		try {
			String xtendModel = "class XtendClass { }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "public class JavaClass extends XtendClass { }");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			fileAsserts.assertFileExists("src/NewXtendClass.xtend");
			fileAsserts.assertFileContains(javaClass, "JavaClass extends NewXtendClass");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendClassStaticImport() throws Exception {
		try {
			String xtendModel = "package test; class XtendClass { static def foo() {} }";
			IFile xtendClass = testHelper.createFile("test/XtendClass.xtend", xtendModel);
			IFile xtendClass2 = testHelper.createFile("test/XtendClass2.xtend", 
					"package test; import static test.XtendClass.* class XtendClass2 { def bar() { foo } }");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			fileAsserts.assertFileExists("src/test/NewXtendClass.xtend");
			fileAsserts.assertFileContains(xtendClass2, "import static test.NewXtendClass.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendClassStaticExtensionImport() throws Exception {
		try {
			String xtendModel = "package test; class XtendClass { static def foo(String s) {} }";
			IFile xtendClass = testHelper.createFile("test/XtendClass.xtend", xtendModel);
			IFile xtendClass2 = testHelper.createFile("test/XtendClass2.xtend", 
					"package test; import static extension test.XtendClass.* class XtendClass2 { def bar() { ''.foo } }");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			fileAsserts.assertFileExists("src/test/NewXtendClass.xtend");
			fileAsserts.assertFileContains(xtendClass2, "import static extension test.NewXtendClass.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendClassWithDelegateConstructorCall_1() throws Exception {
		try {
			String xtendModel = "class XtendClass { new() { this(1) } new(int foo) {} }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			fileAsserts.assertFileExists("src/NewXtendClass.xtend");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendClassWithDelegateConstructorCall_2() throws Exception {
		try {
			String xtendModel = "class XtendClass { } class SubClass { new() { super() } }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			fileAsserts.assertFileExists("src/NewXtendClass.xtend");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendClass() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { XtendClass foo }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = fileAsserts.assertFileExists("src/NewXtendClass.xtend");
			fileAsserts.assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendDefaultConstructor() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { def foo() { val bar = new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = fileAsserts.assertFileExists("src/NewXtendClass.xtend");
			fileAsserts.assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendDefinedConstructor() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass { new() {} }");
			String xtendModel = "class XtendRef { def foo() { val bar = new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = fileAsserts.assertFileExists("src/NewXtendClass.xtend");
			fileAsserts.assertFileContains(newXtendClass, "class NewXtendClass {");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=402916
	public void testRenameRefToXtendDefinedConstructorSameFile() throws Exception {
		try {
			String xtendModel = "class XtendClass { new() {} def foo() { new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendClass.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.lastIndexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			editor.doSave(new NullProgressMonitor());
			IFile newXtendClass = fileAsserts.assertFileExists("src/NewXtendClass.xtend");
			fileAsserts.assertFileContains(newXtendClass, "class NewXtendClass {");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendInterface() throws Exception {
		try {
			String xtendModel = "interface XtendInterface { }";
			IFile xtendClass = testHelper.createFile("XtendInterface.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "public class JavaClass implements XtendInterface { }");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendInterface"), "NewXtendInterface");
			fileAsserts.assertFileExists("src/NewXtendInterface.xtend");
			fileAsserts.assertFileContains(javaClass, "JavaClass implements NewXtendInterface");
		} finally {
			testHelper.getProject().getFile("src/NewXtendInterface.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendInterface() throws Exception {
		try {
			testHelper.createFile("XtendInterface.xtend", "interface XtendInterface {}");
			String xtendModel = "class XtendRef { XtendInterface foo }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendInterface"), "NewXtendInterface");
			assertDocumentContains(editor, xtendModel.replace("XtendInterface", "NewXtendInterface"));
			IFile newXtendInterface = fileAsserts.assertFileExists("src/NewXtendInterface.xtend");
			fileAsserts.assertFileContains(newXtendInterface, "interface NewXtendInterface {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendInterface.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendEnum() throws Exception {
		try {
			String xtendModel = "enum XtendEnum { FOO, BAR }";
			IFile xtendClass = testHelper.createFile("XtendEnum.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "public class JavaClass { XtendEnum e; }");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendEnum"), "NewXtendEnum");
			fileAsserts.assertFileExists("src/NewXtendEnum.xtend");
			fileAsserts.assertFileContains(javaClass, "{ NewXtendEnum e; }");
		} finally {
			testHelper.getProject().getFile("src/NewXtendEnum.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendEnum() throws Exception {
		try {
			testHelper.createFile("XtendEnum.xtend", "enum XtendEnum { FOO, BAR }");
			String xtendModel = "class XtendRef { XtendEnum foo }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendEnum"), "NewXtendEnum");
			assertDocumentContains(editor, xtendModel.replace("XtendEnum", "NewXtendEnum"));
			IFile newXtendInterface = fileAsserts.assertFileExists("src/NewXtendEnum.xtend");
			fileAsserts.assertFileContains(newXtendInterface, "enum NewXtendEnum { FOO, BAR }");
		} finally {
			testHelper.getProject().getFile("src/NewXtendEnum.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendAnnotationType() throws Exception {
		try {
			String xtendModel = "annotation XtendAnnotation {}";
			IFile xtendClass = testHelper.createFile("XtendAnnotation.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "@XtendAnnotation public class JavaClass {}");
			final XtextEditor editor = openEditorSafely(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendAnnotation"), "NewXtendAnnotation");
			fileAsserts.assertFileExists("src/NewXtendAnnotation.xtend");
			fileAsserts.assertFileContains(javaClass, "@NewXtendAnnotation public class JavaClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendAnnotation.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameRefToXtendAnnotation() throws Exception {
		try {
			testHelper.createFile("XtendAnnotation.xtend", "annotation XtendAnnotation {}");
			String xtendModel = "@XtendAnnotation class XtendRef {}";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			final XtextEditor editor = openEditorSafely(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendAnnotation"), "NewXtendAnnotation");
			assertDocumentContains(editor, xtendModel.replace("XtendAnnotation", "NewXtendAnnotation"));
			IFile newXtendInterface = fileAsserts.assertFileExists("src/NewXtendAnnotation.xtend");
			fileAsserts.assertFileContains(newXtendInterface, "annotation NewXtendAnnotation {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendAnnotation.xtend").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}

	@Test
	public void testRenameXtendField() throws Exception {
		String xtendModel = "class XtendClass { protected int foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { int bar = foo; }");
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaClass, "int bar = baz");
	}

	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=408201
	@Test
	public void testRenameSecondXtendField() throws Exception {
		String xtendModel = "class XtendClass { int foo int bar }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		assertDocumentContains(editor, xtendModel.replace("bar", "baz"));
	}

	@Test
	public void testRenameXtendEnumLiteral() throws Exception {
		String xtendModel = "enum XtendEnum { FOO }";
		IFile xtendClass = testHelper.createFile("XtendEnum.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass { XtendEnum bar = XtendEnum.FOO; }");
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("FOO"), "BAZ");
		assertDocumentContains(editor, xtendModel.replace("FOO", "BAZ"));
		fileAsserts.assertFileContains(javaClass, "XtendEnum bar = XtendEnum.BAZ");
	}

	@Test
	public void testRenameXtendMethod() throws Exception {
		String xtendModel = "class XtendClass { def foo() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { public void bar() { foo(); } }");
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaClass, "{ baz(); }");
	}

	@Test
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=383102
	public void testRenameExtensionMethodFromSuper() throws Exception {
		String superModel = "public class Super { public void foo(String it) {} }";
		IFile superClass = testHelper.createFile("Super.java", superModel);
		String subModel = "class Sub extends Super { def bar() { ''.foo } }";
		IFile subClass = testHelper.createFile("Sub.xtend", subModel);
		final XtextEditor editor = openEditorSafely(subClass);
		renameXtendElement(editor, subModel.indexOf("foo"), "newFoo");
		assertDocumentContains(editor, subModel.replace("foo", "newFoo"));
		fileAsserts.assertFileContains(superClass, "public void newFoo(");
	}

	@Test
	public void testRenameJavaClassStaticImport() throws Exception {
		try {
			String extensionModel = "package test; public class Extension { public static void foo(String it) {} }";
			testHelper.createFile("test/Extension.java", extensionModel);
			String refModel = "import static test.Extension.* class XtendRef { def bar() { foo('') } }";
			IFile refXtendClass = testHelper.createFile("XtendRef.xtend", refModel);
			renameJavaElement(findJavaType("test.Extension"), "NewExtension");
			fileAsserts.assertFileExists("src/test/NewExtension.java");
			fileAsserts.assertFileContains(refXtendClass, "import static test.NewExtension");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}
	
	@Test
	public void testRenameJavaClassStaticExtensionImport() throws Exception {
		try {
			String extensionModel = "package test; public class Extension { public static void foo(String it) {} }";
			testHelper.createFile("test/Extension.java", extensionModel);
			String refModel = "import static extension test.Extension.* class XtendRef { def bar() { ''.foo } }";
			IFile refXtendClass = testHelper.createFile("XtendRef.xtend", refModel);
			renameJavaElement(findJavaType("test.Extension"), "NewExtension");
			fileAsserts.assertFileExists("src/test/NewExtension.java");
			fileAsserts.assertFileContains(refXtendClass, "import static extension test.NewExtension.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}
	
	@Test
	public void testRenameJavaClassStaticImportSamePackage() throws Exception {
		try {
			String extensionModel = "package test; public class Extension { public static void foo(String it) {} }";
			testHelper.createFile("test/Extension.java", extensionModel);
			String refModel = "package test import static test.Extension.* class XtendRef { def bar() { foo('') } }";
			IFile refXtendClass = testHelper.createFile("test/XtendRef.xtend", refModel);
			renameJavaElement(findJavaType("test.Extension"), "NewExtension");
			fileAsserts.assertFileExists("src/test/NewExtension.java");
			fileAsserts.assertFileContains(refXtendClass, "import static test.NewExtension.*",  "class XtendRef { def bar() { foo('') } }");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}
	
	@Test
	public void testRenameJavaClassStaticExtensionImportSamePackage() throws Exception {
		try {
			String extensionModel = "package test; public class Extension { public static void foo(String it) {} }";
			testHelper.createFile("test/Extension.java", extensionModel);
			String refModel = "package test import static extension test.Extension.* class XtendRef { def bar() { ''.foo } }";
			IFile refXtendClass = testHelper.createFile("test/XtendRef.xtend", refModel);
			renameJavaElement(findJavaType("test.Extension"), "NewExtension");
			fileAsserts.assertFileExists("src/test/NewExtension.java");
			fileAsserts.assertFileContains(refXtendClass, "import static extension test.NewExtension.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			syncUtil.waitForBuild(null);
		}
	}
	
	@Test
	public void testRenameXtendProperty() throws Exception {
		String xtendModel = "import org.eclipse.xtend.lib.Property class XtendClass { @Property int foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { public void bar() { setFoo(getFoo()); } }");
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		fileAsserts.assertFileContains(javaClass, "{ setBaz(getBaz()); }");
	}

	@Test
	public void testRenameXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("class Secondary") + 6, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameRefToXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("Secondary"), "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefaultConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefinedConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary { new() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameStaticImportStable() throws Exception {
		String xtendModel = "import static java.util.Collections.* class XtendClass { def foo() { val bar = new Object() singleton(bar)}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		assertDocumentContains(editor, "import static java.util.Collections.*");
	}

	@Test
	public void testRenameStaticExtensionImportStable() throws Exception {
		String xtendModel = "import static extension java.util.Collections.* class XtendClass { def foo() { val bar = new Object() bar.singleton()}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = openEditorSafely(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		assertDocumentContains(editor, "import static extension java.util.Collections.*");
	}

	protected void assertDocumentContains(XtextEditor editor, String expectedContent) throws CoreException {
		String editorContent = editor.getDocument().get();
		assertTrue("'" + expectedContent + "' not found in \n" + editorContent, editorContent.contains(expectedContent));
	}

	protected void assertDocumentContainsIgnoreWhitespace(XtextEditor editor, String expectedContent) throws CoreException {
		String editorContent = editor.getDocument().get();
		assertTrue("'" + expectedContent + "' not found in \n" + editorContent, 
				editorContent.replaceAll("\\s*", " ").contains(expectedContent.replaceAll("\\s*",  " ")));
	}

	protected XtextEditor openEditorSafely(IFile file) throws Exception {
		syncUtil.waitForBuild(null);
		syncUtil.yieldToQueuedDisplayJobs(null);
		XtextEditor editor = testHelper.openEditor(file);
		syncUtil.waitForReconciler(editor);
		syncUtil.yieldToQueuedDisplayJobs(null);
		return editor;
	}
	
	protected XtextEditor openEditorSafely(String fileName, String contents) throws Exception {
		IFile file = testHelper.createFile(fileName, contents);
		return openEditorSafely(file);
	}
	
	protected void renameXtendElement(final XtextEditor editor, final int offset, final String newName, final int allowedSeverity) throws Exception {
		syncUtil.totalSync(false);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
				RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
				assertTrue(status.toString(), status.getSeverity() <= allowedSeverity);
				Change change = renameRefactoring.createChange(new NullProgressMonitor());
				change.perform(new NullProgressMonitor());
			}
		}.run(new NullProgressMonitor());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected void renameXtendElement(final XtextEditor editor, final int offset, String newName) throws Exception {
		renameXtendElement(editor, offset, newName, RefactoringStatus.OK);
	}

	protected RefactoringStatus renameXtendElementWithError(final XtextEditor editor, final int offset, String newName) throws Exception {
		syncUtil.totalSync(false);
		ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
		RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
		assertFalse("Expected an error", status.isOK());
		return status;
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
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, offset);
						return renameContextFactory.createRenameElementContext(element, editor, new TextSelection(
								offset, 1), state);
					}
				});
		return renameElementContext;
	}

	protected void renameJavaElement(IType javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected void renameJavaElement(IMethod javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected void renameJavaElement(IField javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected IType findJavaType(String typeName) throws Exception {
		syncUtil.totalSync(false);
		IJavaProject javaProject = JavaCore.create(testHelper.getProject());
		IType javaClass = javaProject.findType(typeName);
		return javaClass;
	}
}
