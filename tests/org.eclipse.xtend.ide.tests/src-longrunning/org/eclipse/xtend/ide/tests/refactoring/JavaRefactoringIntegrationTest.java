/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

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
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.texteditor.IDocumentProviderExtension;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
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
			final XtextEditor editor = testHelper.openEditor(xtendClass);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/test/NewJavaClass.java");
			assertDocumentContainsIgnoreWhitespace(editor, xtendModel.replace("JavaClass", "NewJavaClass"));
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
			assertFileContains(xtendClass, "extends NewJavaClass");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
		
	@Test
	public void testRenameRefToJavaConstructor() throws Exception {
		try {
			testHelper.createFile("test/JavaClass.java", "package test; public class JavaClass { public JavaClass() {} }");
			String xtendModel = "import test.JavaClass class XtendClass { JavaClass x = new JavaClass() }";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/test/NewJavaClass.java");
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
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			renameXtendElement(editor, xtendModel.lastIndexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/test/NewJavaClass.java");
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
			assertDocumentContains(editor, "NewJavaClass x = new NewJavaClass()");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}
	
	@Test
	public void testRenameJavaField() throws Exception {
		testHelper.createFile("JavaClass.java", "public class JavaClass { protected int foo; }");
		String xtendModel = "class XtendClass extends JavaClass { int bar = foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
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
			renameXtendElement(editor, xtendModel.indexOf("JavaEnum"), "NewJavaEnum");
			assertFileExists("src/NewJavaEnum.java");
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
		assertFileContains(xtendClass, "JavaEnum fooBar = JavaEnum::BAZ");
	}

	@Test
	public void testRenameRefToJavaEnumLiteral() throws Exception {
		testHelper.createFile("JavaEnum.java", "public enum JavaEnum { FOO, BAR }");
		String xtendModel = "class XtendClass { JavaEnum fooBar = JavaEnum::BAR }";
		XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
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
		assertFileContains(xtendClass, "new JavaClass().baz()");
	}

	@Test
	public void testRenameJavaMethodCall() throws Exception {
		IFile javaFile = testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
		String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertEquals(xtendModel.replace("foo", "baz"), editor.getDocument().get());
		assertFileContains(javaFile, "public void baz()");
	}

	@Test
	public void testRenameMethodCall_Getters_0() throws Exception {
		String xtendModel = "class XtendClass { def getFoo() {null} def bar() { foo getFoo getFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("getFoo"), "getBaz");
		assertDocumentContains(editor, xtendModel.replace("getFoo", "getBaz").replace("foo", "baz"));
	}

	@Test
	public void testRenameMethodCall_Getters_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = 1 def getFoo() {null} def bar() { foo getFoo getFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("getFoo"), "getBaz");
		assertDocumentContains(editor, xtendModel.replace("getFoo", "getBaz").replace("foo", "getBaz"));
	}

	@Test
	public void testRenameMethodCall_BooleanIs_0() throws Exception {
		String xtendModel = "class XtendClass { def isFoo() {false} def bar() { foo isFoo isFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("isFoo"), "isBaz");
		assertDocumentContains(editor, xtendModel.replace("isFoo", "isBaz").replace("foo", "baz"));
	}
	
	@Test
	public void testRenameMethodCall_BooleanIs_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = false def isFoo() {false} def bar() { foo isFoo isFoo() } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("isFoo"), "isBaz");
		assertDocumentContains(editor, xtendModel.replace("isFoo", "isBaz").replace("foo", "isBaz"));
	}
	
	@Test
	public void testRenameMethodCall_Setters_0() throws Exception {
		String xtendModel = "class XtendClass { def setFoo(Object x) {} def bar() { foo=null setFoo(null) } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("setFoo"), "setBaz");
		assertDocumentContains(editor, xtendModel.replace("setFoo", "setBaz").replace("foo", "baz"));
	}

	@Test
	public void testRenameMethodCall_Setters_1() throws Exception {
		String xtendModel = "class XtendClass { val baz = null def setFoo(Object x) {} def bar() { foo=null } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElementWithError(editor, xtendModel.indexOf("setFoo"), "setBaz");
	}

	@Test
	public void testRenameMethodCall_Setters_2() throws Exception {
		String xtendModel = "class XtendClass { def setBaz(Object x) {} def setFoo(Object x) {} def bar() { setFoo(null) } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElementWithError(editor, xtendModel.indexOf("setFoo"), "setBaz");
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
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
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
		final XtextEditor editor = testHelper.openEditor(superClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, superModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, superModel.replace("foo", "baz"));
		assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
		assertFileContains(subClass, subModel.replace("foo", "baz"));
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
		final XtextEditor editor = testHelper.openEditor(subClass);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, subModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, subModel.replace("foo", "baz"));
		assertFileContains(xtendCaller, xtendCallerModel.replace("foo", "baz"));
		assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
		assertFileContains(superClass, superModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameRefToXtendDispatchMethod() throws Exception {
		String xtendModel = "class XtendClass { def dispatch foo(Object x) {} def dispatch foo(String x) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		String javaCallerModel = "public class JavaCaller { void bar(XtendClass x) { x.foo(null); x._foo(\"\"); } }";
		IFile javaCaller = testHelper.createFile("JavaCaller.java", javaCallerModel);
		String xtendCallerModel = "class XtendCaller { def bar(XtendClass x) { x.foo(null) } }";
		IFile xtendCaller = testHelper.createFile("XtendCaller.xtend", xtendCallerModel);
		waitForAutoBuild();
		final XtextEditor editor = testHelper.openEditor(xtendCaller);
		// on Galileo, _foo is a discouraged method name
		renameXtendElement(editor, xtendCallerModel.indexOf("foo"), "baz", RefactoringStatus.WARNING);
		assertDocumentContains(editor, xtendCallerModel.replace("foo", "baz"));
		assertFileContains(xtendClass, xtendModel.replace("foo", "baz"));
		assertFileContains(javaCaller, javaCallerModel.replace("foo", "baz"));
	}

	@Test
	public void testDontRenameOperatorCall() throws Exception {
		String xtendModel = "class XtendClass { def bar() { 1 + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf('+');
		waitForAutoBuild();
		IRenameElementContext renameElementContext = createRenameElementContext(editor, offset);
		assertNull(renameElementContext);
	}

	@Test
	public void testDontRenameOperatorDefWhenReferenced() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} def bar() { this + 2 } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElementWithError(editor, offset, "operator_minus");
	}

	@Test
	public void testRenameOperatorDefWhenNotReferenced() throws Exception {
		String xtendModel = "class XtendClass { def operator_plus(int i) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("operator_plus");
		renameXtendElement(editor, offset, "operator_minus");
		assertDocumentContains(editor, xtendModel.replace("operator_plus", "operator_minus"));
	}

	@Test
	public void testRenameXtendParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("foo");
		renameXtendElement(editor, offset, "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameRefToParameter() throws Exception {
		String xtendModel = "class XtendClass { def bar(int foo) { foo } }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.lastIndexOf("foo");
		renameXtendElement(editor, offset, "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
	}

	@Test
	public void testRenameXtendTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		final int offset = xtendModel.indexOf("T");
		renameXtendElement(editor, offset, "U");
		assertDocumentContains(editor, xtendModel.replace("T", "U"));
	}

	@Test
	public void testRenameRefToTypeParameter() throws Exception {
		String xtendModel = "class XtendClass <T> { def bar(T foo) {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
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
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
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
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
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
		waitForAutoBuild();
		IMethod fooMethod = findJavaType("JavaBase").getMethod("foo", new String[] {});
		renameJavaElement(fooMethod, "bar");
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
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
		assertDocumentContains(editor, xtendModel.replace("foo", "bar"));
		assertFileContains(javaBase, "public void bar()");
		assertFileContains(javaSub, "public void bar()");
	}

	@Test
	public void testRenameXtendClass() throws Exception {
		try {
			String xtendModel = "class XtendClass { }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IFile javaClass = testHelper.createFile("JavaClass.java", "public class JavaClass extends XtendClass { }");
			final XtextEditor editor = testHelper.openEditor(xtendClass);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(javaClass, "JavaClass extends NewXtendClass");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
		}
	}

	@Test
	public void testRenameRefToXtendClass() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { XtendClass foo }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			waitForAutoBuild();
			final XtextEditor editor = testHelper.openEditor(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
		}
	}

	@Test
	public void testRenameRefToXtendDefaultConstructor() throws Exception {
		try {
			testHelper.createFile("XtendClass.xtend", "class XtendClass {}");
			String xtendModel = "class XtendRef { def foo() { val bar = new XtendClass } }";
			IFile xtendRef = testHelper.createFile("XtendRef.xtend", xtendModel);
			waitForAutoBuild();
			final XtextEditor editor = testHelper.openEditor(xtendRef);
			renameXtendElement(editor, xtendModel.indexOf("XtendClass"), "NewXtendClass");
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {}");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
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
			assertDocumentContains(editor, xtendModel.replace("XtendClass", "NewXtendClass"));
			IFile newXtendClass = assertFileExists("src/NewXtendClass.xtend");
			assertFileContains(newXtendClass, "class NewXtendClass {");
		} finally {
			testHelper.getProject().getFile("src/NewXtendClass.xtend").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
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
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
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
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
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
		renameXtendElement(editor, subModel.indexOf("foo"), "newFoo");
		assertDocumentContains(editor, subModel.replace("foo", "newFoo"));
		assertFileContains(superClass, "public void newFoo(");
	}

	@Test
	public void testRenameJavaClassStaticImport() throws Exception {
		try {
			String extensionModel = "package test; public class Extension { public static void foo(String it) {} }";
			testHelper.createFile("test/Extension.java", extensionModel);
			String refModel = "import static test.Extension.* class XtendRef { def bar() { foo('') } }";
			IFile refXtendClass = testHelper.createFile("XtendRef.xtend", refModel);
			renameJavaElement(findJavaType("test.Extension"), "NewExtension");
			assertFileExists("src/test/NewExtension.java");
			assertFileContains(refXtendClass, refModel.replace("Extension", "NewExtension"));
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
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
			assertFileExists("src/test/NewExtension.java");
			assertFileContains(refXtendClass, refModel.replace("Extension", "NewExtension"));
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
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
			assertFileExists("src/test/NewExtension.java");
			assertFileContains(refXtendClass, "import static test.NewExtension.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
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
			assertFileExists("src/test/NewExtension.java");
			assertFileContains(refXtendClass, "import static extension test.NewExtension.*");
		} finally {
			testHelper.getProject().getFile("src/test/NewExtension.java").delete(true, new NullProgressMonitor());
			waitForAutoBuild();
		}
	}
	
	@Test
	public void testRenameXtendProperty() throws Exception {
		String xtendModel = "import org.eclipse.xtend.lib.Property class XtendClass { @Property int foo }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass extends XtendClass { public void bar() { setFoo(getFoo()); } }");
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("foo"), "baz");
		assertDocumentContains(editor, xtendModel.replace("foo", "baz"));
		assertFileContains(javaClass, "{ setBaz(getBaz()); }");
	}

	@Test
	public void testRenameXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("class Secondary") + 6, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameRefToXtendSecondaryType() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("Secondary"), "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefaultConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary {}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameXtendSecondaryTypeByDefinedConstructor() throws Exception {
		String xtendModel = "class XtendClass { Secondary foo = new Secondary() } class Secondary { new() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("new Secondary") + 5, "NewSecondary");
		assertDocumentContains(editor, xtendModel.replace("Secondary", "NewSecondary"));
	}

	@Test
	public void testRenameStaticImportStable() throws Exception {
		String xtendModel = "import static java.util.Collections.* class XtendClass { def foo() { val bar = new Object() singleton(bar)}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		assertDocumentContains(editor, xtendModel.replace("bar", "baz"));
	}

	@Test
	public void testRenameStaticExtensionImportStable() throws Exception {
		String xtendModel = "import static extension java.util.Collections.* class XtendClass { def foo() { val bar = new Object() bar.singleton()}}";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		final XtextEditor editor = testHelper.openEditor(xtendClass);
		renameXtendElement(editor, xtendModel.indexOf("bar"), "baz");
		assertDocumentContains(editor, xtendModel.replace("bar", "baz"));
	}

	protected IFile assertFileExists(String fileName) throws Exception {
		IResource file = testHelper.getProject().findMember(fileName);
		assertTrue(file instanceof IFile);
		assertTrue(file.exists());
		return (IFile) file;
	}

	protected void assertFileContains(IFile file, String contents) throws Exception {
		file.refreshLocal(IResource.DEPTH_ZERO, null);
		String fileContents = testHelper.getContents(file);
		assertTrue(fileContents, fileContents.contains(contents));
	}
	
	protected void assertDocumentContains(XtextEditor editor, String expectedContent) throws CoreException {
		((IDocumentProviderExtension) editor.getDocumentProvider()).synchronize(editor.getEditorInput());
		String editorContent = editor.getDocument().get();
		assertTrue("'" + expectedContent + "' not found in \n" + editorContent, editorContent.contains(expectedContent));
	}

	protected void assertDocumentContainsIgnoreWhitespace(XtextEditor editor, String expectedContent) throws CoreException {
		((IDocumentProviderExtension) editor.getDocumentProvider()).synchronize(editor.getEditorInput());
		String editorContent = editor.getDocument().get();
		assertTrue("'" + expectedContent + "' not found in \n" + editorContent, 
				editorContent.replaceAll("\\s*", " ").contains(expectedContent.replaceAll("\\s*",  " ")));
	}

	protected void executeAsyncDisplayJobs() {
		while(Display.getCurrent().readAndDispatch()) {}
	}

	protected Change renameXtendElement(final XtextEditor editor, final int offset, String newName, int allowedSeverity) throws Exception {
		waitForAutoBuild();
		executeAsyncDisplayJobs();
		ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
		RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
		assertTrue(status.toString(), status.getSeverity() <= allowedSeverity);
		Change change = renameRefactoring.createChange(new NullProgressMonitor());
		Change undoChange = change.perform(new NullProgressMonitor());
		waitForAutoBuild();
		executeAsyncDisplayJobs();
		return undoChange;
	}

	protected Change renameXtendElement(final XtextEditor editor, final int offset, String newName) throws Exception {
		return renameXtendElement(editor, offset, newName, RefactoringStatus.OK);
	}

	protected RefactoringStatus renameXtendElementWithError(final XtextEditor editor, final int offset, String newName) throws Exception {
		waitForAutoBuild();
		executeAsyncDisplayJobs();
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
		waitForAutoBuild();
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		waitForAutoBuild();
	}

	protected void renameJavaElement(IMethod javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		waitForAutoBuild();
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		waitForAutoBuild();
	}

	protected void renameJavaElement(IField javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		waitForAutoBuild();
	}

	protected IType findJavaType(String typeName) throws JavaModelException {
		waitForAutoBuild();
		IJavaProject javaProject = JavaCore.create(testHelper.getProject());
		IType javaClass = javaProject.findType(typeName);
		return javaClass;
	}

}
