/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingCalculator;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHighlightingCalculatorTest extends AbstractXtendTestCase implements IHighlightedPositionAcceptor, XtendHighlightingStyles {

	public static final String DEFAULT_CLASS_DEF = "class Foo";
	
	private static final String DEPRECATED_TEST_CLASS = "org.eclipse.xtend.ide.tests.data.highlighting.TestClassDeprecated";

	String classDefString = DEFAULT_CLASS_DEF;

	@Inject
	private XtendHighlightingCalculator calculator;
	
	private Multimap<TextRegion, String> expectedRegions;
	
	private Multimap<TextRegion, String> explicitNotExpectedRegions;
	
	private Set<String> imports;
	
	private Set<String> injects;
	
	/**
	 * whether every accepted region must be expected
	 */
	private boolean strictMode = false;

	private boolean logEnabled = false;
	
	@Before
	public void setUp() throws Exception {
		expectedRegions = HashMultimap.create();
		explicitNotExpectedRegions = HashMultimap.create();
		imports = Sets.newHashSet();
		injects = Sets.newHashSet();
		classDefString = DEFAULT_CLASS_DEF;
		waitForBuild();
	}
	
	@After
	public void tearDown() throws Exception {
		expectedRegions = null;
		explicitNotExpectedRegions = null;
		imports = null;
		injects = null;
		calculator = null;
	}
	
	@Override
	protected XtextResourceSet getResourceSet() {
		XtextResourceSet result = super.getResourceSet();
		result.setClasspathURIContext(getClass().getClassLoader());
		return result;
	}
	
	protected String getPrefix() {
		String prefix = "";
		for(String importDef : imports)
			prefix += importDef + " ";
		prefix += classDefString + " { "; 
		for(String injectDef : injects)
			prefix += injectDef + " ";	
		prefix += "def foo() ";
		return prefix;
	}
	
	protected int getPrefixLength() {
		return getPrefix().length();
	}
	
	protected XtendTypeDeclaration member(String string) throws Exception {
		return typeDecl(getPrefix()+string+"}");
	}
	
	protected XtendTypeDeclaration secondMember(String string) throws Exception {
		return file(getPrefix()+string+"}").getXtendTypes().get(1);
	}
	
	protected XtendTypeDeclaration typeDecl(String string) throws Exception {
		return file(string).getXtendTypes().get(0);
	}
	
	@Test public void testEmptyString() {
		expectInsignificant(0, 3);
		expectInsignificant(3, 3);
		highlight("''''''");
	}
	
	@Test public void testStringWithWS() {
		expectInsignificant(0, 3);
		expectInsignificant(5, 3);
		highlight("'''  '''");
	}
	
	@Test public void testSingleLineLiteral() {
		strictMode = true;
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(9, 3);
		highlight(
				"'''foobar'''");
	}
	
	@Test public void testLiteral() {
		strictMode = true;
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(3, 2);
		expectInsignificant(5, 1);
		expectInsignificant(6, 1);
		expectSemanticLineBreak(14, 1);
		expectInsignificant(15,3);
		highlight(
				"'''  \n" +
				" foobar \n" +
				"'''");
	}
	
	@Test public void testLiteralsWithComments() {
		strictMode = true;
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(3, 2);
		expectInsignificant(5, 1);
		expectInsignificant(6, 2);
		expectSemanticLineBreak(18, 1); 
		expectInsignificant(19, 1);
		expectInsignificant(37, 1);
		expectSemanticLineBreak(50, 1); 
		expectInsignificant(51, 2);
		expectSemanticLineBreak(86, 1);
		expectInsignificant(87, 3);
		highlight(
				"'''  \n" +
				"  first line\n" +
				" « /* comment */ » second line \n" +
				"  third«\n" +
				"   /* comment */ \n" +
				" » line \n" +
				"'''");
	}
	
	@Test public void testBug375272_01() {
		strictMode = true;
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(3, 1);
		expectInsignificant(4, 6);
		expectInsignificant(19, 1);
		expectAbsolute(20, 11, HighlightingStyles.COMMENT_ID);
		expectInsignificant(32, 6);
		expectInsignificant(45, 1);
		expectInsignificant(46, 3);
		highlight(
				"'''\n" + 
				"      «IF true»\n" + 
				"««« comment\n" + 
				"      «ENDIF»\n" + 
				"'''");
	}
	
	@Test public void testBug375272_02() {
		strictMode = true;
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(3, 2);
		expectInsignificant(5, 6);
		expectInsignificant(20, 2);
		expectAbsolute(22, 11, HighlightingStyles.COMMENT_ID);
		expectInsignificant(35, 6);
		expectInsignificant(48, 2);
		expectInsignificant(50, 3);
		highlight(
				"'''\r\n" + 
				"      «IF true»\r\n" + 
				"««« comment\r\n" + 
				"      «ENDIF»\r\n" + 
				"'''");
	}
	
	@Test public void testExpression() {
		strictMode = true;
		String model = 
			"'''\n" +
			"\t\t«'foobar'» \n" +
			"  '''";
		expectClass(6, 3);
		expectMethod(16, 3);
		expectInsignificant(0, 3);
		expectInsignificant(3, 1);
		expectInsignificant(model.indexOf('\t'), 2);
		expectInsignificant(model.indexOf("  "), 2);
		expectInsignificant(model.lastIndexOf("'''"), 3);
		expectAbsolute(17,1,POTENTIAL_LINE_BREAK);
		highlight(model);
	}
	
	@Test public void testSingleLineExpression() {
		String model = "'''«'literal'»'''";
		expectInsignificant(0, 3);
		expectInsignificant(14, 3);
		highlight(model);
	}
	
	@Test public void testVoid() {
		String model = "{ var void v = null }";
		expectAbsolute(model.indexOf("void"), 4, HighlightingStyles.KEYWORD_ID);
		highlight(model);
	}
	
	@Test public void testThis() {
		String model = "{ var f = this }";
		expectAbsolute(model.indexOf("this"), 4, HighlightingStyles.KEYWORD_ID);
		highlight(model);
	}
	
	@Test public void testSelf() {
		String model = "val Runnable runnable = [| self.run ]";
		expectAbsolute(model.indexOf("self"), 4, HighlightingStyles.KEYWORD_ID);
		highlight(model);
	}
	
	@Test public void testSelf_2() {
		String model = "{ val self = 1 }";
		expectAbsolute(model.indexOf("self"), 4, HighlightingStyles.KEYWORD_ID);
		expectAbsolute(model.indexOf('1'), 1, HighlightingStyles.NUMBER_ID);
		highlight(model);
	}
	
	@Test public void testInt() {
		String model = "{ var int i = 1 }";
		expectAbsolute(model.indexOf("int"), 3, HighlightingStyles.KEYWORD_ID);
		expectAbsolute(model.lastIndexOf("1"), 1, HighlightingStyles.NUMBER_ID);
		highlight(model);
	}
	
	@Test public void testCreateAsIdentifier() {
		String model = "{ var String create = '' }";
		expectAbsolute(model.indexOf("create"), 6, HighlightingStyles.DEFAULT_ID);
		highlight(model);
	}
	
	@Test public void testCreateKeyword() {
		String model = "{} def create result: new Object() create() {}";
		expectAbsolute(model.lastIndexOf("create"), 6, HighlightingStyles.DEFAULT_ID);
		highlight(model);
	}
	
	@Test public void testStaticFieldAccess() throws Exception {
		String model = "{ Integer::MAX_VALUE }";
		expectAbsolute(model.lastIndexOf("MAX_VALUE"), 9, XbaseHighlightingStyles.STATIC_FINAL_FIELD);
		highlight(model);
	}
	
	@Test public void testStaticOperationInvocation() throws Exception {
		addImport("java.util.Collections");
		String model = "{ Collections::emptySet  }";
		expectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	@Test public void testQualifiedStaticOperationInvocation() throws Exception {
		String model = "{ java::util::Collections::emptySet  }";
		expectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	@Test public void testQualifiedStaticOperationInvocationWithDot() throws Exception {
		String model = "{ java.util.Collections::emptySet  }";
		expectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	@Test public void testQualifiedStaticOperationInvocationWithInstanceNotation() throws Exception {
		String model = "{ java.util.Collections.emptySet  }";
		expectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	@Test public void testStaticExtensionOperationInvocation() throws Exception {
		String model = "{ 'FOO'.toFirstLower   }";
		expectAbsolute(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testNonStaticExtensionOperationInvocation() throws Exception {
		addImport("com.google.inject.Inject");
		addInject("extension StringBuilder");
		String model = "{ 'Foo'.append   }";
		expectAbsolute(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testStaticImportedExtensionOperationInvocation() throws Exception {
		addImport("static extension java.util.Collections.*");
		String model = "{ newArrayList.shuffle   }";
		expectAbsolute(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testStaticExtensionOperationWithNoImplicitArguments() throws Exception {
		addImport("java.util.List");
		String model = "def toUpperCase(List<String> it) { map [ toUpperCase ]}";
		expectAbsolute(model.lastIndexOf("map"), 3, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("map"), 3, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testLocalExtensionOperation() throws Exception {
		addImport("java.util.List");
		String model = "def void zonk(List<String> it) { zonk }";
		expectAbsolute(model.lastIndexOf("zonk"), 4, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}

	@Test public void testBug377413(){
		addImport("java.util.List");
		String model = "def void bar(Foo it){ zonk = '42' } def setZonk(String x){} def void fooBar(List<String> it) { fooBar }";
		notExpectAbsolute(model.indexOf("zonk"),4,XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("fooBar"), 6, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testAnnotaton() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject extension StringBuilder";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	@Test public void testAnnotatonWithValues() throws Exception {
		addImport("com.google.inject.name.Named");
		String model = "@Named(value='bar') def foo()";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.lastIndexOf("Named"), 5, XbaseHighlightingConfiguration.ANNOTATION);
		notExpectAbsolute(model.indexOf("(value=42)"),10 , XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	@Test public void testReferencedJvmAnnotatonType() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{ val bar = typeof(Inject) } ";
		expectAbsolute(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	@Test public void testXtendFieldDeclaration() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		notExpectAbsolute(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	@Test public void testNonStaticFieldAccess() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar def testFunction() { bar.append('foo') }";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolute(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolute(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	
	@Test public void testDeprecatedXtendClass() throws Exception {
		classDefString = "@Deprecated class Bar";
		String model = "{}";
		expect(getPrefix().lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expect(getPrefix().lastIndexOf("Deprecated"), 10, XbaseHighlightingConfiguration.ANNOTATION);
		expectClass(getPrefix().indexOf("Bar"), 3);
		expect(getPrefix().indexOf("Bar"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeprecatedParentClass() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		classDefString = "class Bar extends TestClassDeprecated";
		String model = "{}";
		expect(getPrefix().lastIndexOf("TestClassDeprecated"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}

	@Test public void testDeprecatedStaticFieldAccess() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		String model = "{TestClassDeprecated::DEPRECATED_CONSTANT}";
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	@Test public void testQualifiedDeprecatedStaticFieldAccess() throws Exception {
		String model = "{org::eclipse::xtend::ide::tests::data::highlighting::TestClassDeprecated::DEPRECATED_CONSTANT}";
		expectDeprecatedPackageFragment(model, "org", 2);
		expectDeprecatedPackageFragment(model, "eclipse", 2);
		expectDeprecatedPackageFragment(model, "xtend", 2);
		expectDeprecatedPackageFragment(model, "ide", 2);
		expectDeprecatedPackageFragment(model, "tests", 2);
		expectDeprecatedPackageFragment(model, "data", 2);
		expectDeprecatedPackageFragment(model, "highlighting", 2);
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	@Test public void testQualifiedDeprecatedStaticFieldAccessWithDot() throws Exception {
		String model = "{org.eclipse.xtend.ide.tests.data.highlighting.TestClassDeprecated::DEPRECATED_CONSTANT}";
		expectDeprecatedPackageFragment(model, "org", 1);
		expectDeprecatedPackageFragment(model, "eclipse", 1);
		expectDeprecatedPackageFragment(model, "xtend", 1);
		expectDeprecatedPackageFragment(model, "ide", 1);
		expectDeprecatedPackageFragment(model, "tests", 1);
		expectDeprecatedPackageFragment(model, "data", 1);
		expectDeprecatedPackageFragment(model, "highlighting", 1);
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	@Test public void testQualifiedDeprecatedStaticFieldAccessWithInstanceAccess() throws Exception {
		String model = "{org.eclipse.xtend.ide.tests.data.highlighting.TestClassDeprecated.DEPRECATED_CONSTANT}";
		expectDeprecatedPackageFragment(model, "org", 1);
		expectDeprecatedPackageFragment(model, "eclipse", 1);
		expectDeprecatedPackageFragment(model, "xtend", 1);
		expectDeprecatedPackageFragment(model, "ide", 1);
		expectDeprecatedPackageFragment(model, "tests", 1);
		expectDeprecatedPackageFragment(model, "data", 1);
		expectDeprecatedPackageFragment(model, "highlighting", 1);
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	private void expectDeprecatedPackageFragment(String model, String packageName, int delimiterLength) {
		int idx = model.lastIndexOf(packageName);
		int length = packageName.length();
		expectAbsolute(idx, length, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(idx + length, delimiterLength, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
	}
	
	@Test public void testDeprecatedMethodAccess() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		addImport("com.google.inject.Inject");
		String model = "{} @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodDeprecated() }";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Inject"), 6,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolute(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectMethod(model.lastIndexOf("testMethodDeprecated") + getPrefixLength(), 20);
		expectAbsolute(model.lastIndexOf("testMethodDeprecated"), 20, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeprecatedContructor_439885() throws Exception {
		String model = "@Deprecated new(){}";
		expectAbsolute(model.lastIndexOf("@"), 1, XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Deprecated"), 10,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("new"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testNotDeprecatedMethodAccess() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		addImport("com.google.inject.Inject");
		String model = "{} @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodNotDeprecated() }";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Inject"), 6,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolute(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolute(model.indexOf("testMethodNotDeprecated"), 23, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeprecatedStaticMethodAccess() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		String model = "{TestClassDeprecated::testMethodStaticDeprecated() }";
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("testMethodStaticDeprecated"), 26, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("testMethodStaticDeprecated"), 26, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testNotDeprecatedStaticMethodAccess() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		String model = "{TestClassDeprecated::testMethodStaticNotDeprecated() }";
		expectAbsolute(model.lastIndexOf("TestClassDeprecated"), "TestClassDeprecated".length(), XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("testMethodStaticNotDeprecated"), 29, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolute(model.lastIndexOf("testMethodStaticNotDeprecated"), 29, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeprecatedXtendField() throws Exception {
		addImport(DEPRECATED_TEST_CLASS);
		addImport("com.google.inject.Inject");
		String model = "{} @Deprecated @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodNotDeprecated() }";
		expectAbsolute(model.indexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Deprecated"), 10,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Inject"), 6,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolute(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolute(model.lastIndexOf("clazz"), 5,XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		notExpectAbsolute(model.indexOf("testMethodNotDeprecated"), 23, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeprecatedXtendFunction() throws Exception {
		String model = "{} @Deprecated def baz(){} def bar(){ baz()}";
		expectAbsolute(model.lastIndexOf("@"), 1,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolute(model.indexOf("Deprecated"), 10,XbaseHighlightingConfiguration.ANNOTATION);
		int prefixLength = getPrefixLength();
		expectMethod(model.indexOf("baz") + prefixLength, 3);
		expectMethod(model.lastIndexOf("baz") + prefixLength, 3);
		expectMethod(model.indexOf("bar") + prefixLength, 3);
		expectAbsolute(model.indexOf("baz"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolute(model.lastIndexOf("baz"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	@Test public void testDeclaredStaticField() throws Exception {
		String model = "{} private static String foo def bar() {foo}";
		expectAbsolute(model.indexOf("foo"), 3,XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolute(model.lastIndexOf("foo"), 3,XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	@Test public void testKeywordsInFeatureCalls() throws Exception {
		for(String keyword: newArrayList("abstract", "annotation", "class", "create",
					"def", "dispatch", "enum", "extends", "extension", "final", "implements", "import", "interface", 
					"override", "package", "public", "private", "protected", "static", "throws")) {
			String model = "{} def get" + toFirstUpper(keyword) + "() {} def bar(Foo it) { "+ keyword + "}";
			expectAbsolute(model.lastIndexOf(keyword), keyword.length(), HighlightingStyles.DEFAULT_ID);
		}
	}
	
	@Test public void testActiveAnnotation_Type() throws Exception {
		addImport("org.eclipse.xtend.lib.macro.Active");
		addImport("java.lang.annotation.ElementType");
		addImport("java.lang.annotation.Target");
		addImport("org.eclipse.xtend.lib.macro.AbstractClassProcessor");
		addImport("org.eclipse.xtend.lib.macro.TransformationContext");
		addImport("org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
		classDefString = "@Target(ElementType.TYPE) @Active(ObservableCompilationParticipant) annotation Observable {} class ObservableCompilationParticipant extends AbstractClassProcessor { override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {}}";
		classDefString = classDefString + " @Observable class Bar ";
		String model = "{}";
		expect(565, 1, ACTIVE_ANNOTATION);
		expect(566, 10, ACTIVE_ANNOTATION);
		highlightActiveAnnotation(model);
	}

	@Test public void testActiveAnnotation_Field() throws Exception {
		addImport("org.eclipse.xtend.lib.macro.Active");
		addImport("java.lang.annotation.ElementType");
		addImport("java.lang.annotation.Target");
		addImport("org.eclipse.xtend.lib.macro.AbstractClassProcessor");
		addImport("org.eclipse.xtend.lib.macro.TransformationContext");
		addImport("org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration");
		classDefString = "@Target(ElementType.FIELD) @Active(ObservableCompilationParticipant) annotation Observable {} class ObservableCompilationParticipant extends AbstractFieldProcessor { override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {}}";
		classDefString = classDefString + "class Bar ";
		String model = "{} @Observable String myAnnotatedString ";
		expect(591, 1, ACTIVE_ANNOTATION);
		expect(592, 10, ACTIVE_ANNOTATION);
		highlightActiveAnnotation(model);
	}
	
	@Test
	public void testBug455188() throws Exception {
		StringBuilder a = new StringBuilder();
		a.append("class Bar {");
		a.append("	def String getProperty(){}");
		a.append("	def void setProperty(String s){}");
		a.append("}");
		
		classDefString = a.toString() + classDefString;
		
		StringBuilder b = new StringBuilder();
		
		b.append("{");
		b.append("	if(property != null){");
		b.append("		property = ''");
		b.append("	} ");
		b.append("} extension Bar = new Bar{} ");
		String model = b.toString();
		
		expectAbsolute(model.indexOf("property"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.lastIndexOf("property"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test
	public void testBug455188_2() throws Exception {
		StringBuilder a = new StringBuilder();
		a.append("class Bar {");
		a.append("	def void setContents(String s, int i){}");
		a.append("}");
		
		classDefString = a.toString() + classDefString;
		
		StringBuilder b = new StringBuilder();
		
		b.append("{");
		b.append("	's'.contents = 1");
		b.append("} extension Bar = new Bar{} ");
		String model = b.toString();
		
		expectAbsolute(model.indexOf("contents"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.indexOf("1"), 1, HighlightingStyles.NUMBER_ID);
		highlight(model);
	}

	@Test public void testBug455188_3() throws Exception {
		String model = "{ true && true } ";

		notExpectAbsolute(model.indexOf("&&"), 2, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test public void testBug455188_4() throws Exception {
		String model = "{ 1 + 2 } ";

		notExpectAbsolute(model.indexOf("+"), 1, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.indexOf("1"), 1, HighlightingStyles.NUMBER_ID);
		expectAbsolute(model.indexOf("2"), 1, HighlightingStyles.NUMBER_ID);
		highlight(model);
	}
	
	@Test
	public void testBug455188_5() throws Exception {
		StringBuilder a = new StringBuilder();
		a.append("import java.util.List ");
		a.append("class Bar {");
		a.append("	def operator_add(List<String> l, String e){}");
		a.append("}");
		
		classDefString = a.toString() + classDefString;
		
		StringBuilder b = new StringBuilder();
		
		b.append("{");
		b.append("	val List<String> l = #[]");
		b.append(" l += ''");
		b.append("} extension Bar = new Bar{} ");
		String model = b.toString();

		notExpectAbsolute(model.indexOf("+="), 1, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	@Test
	public void testBug466702() throws Exception {
		String model = "{ var i = 1 i++ } ";

		notExpectAbsolute(model.indexOf("++"), 2, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolute(model.indexOf("1"), 1, HighlightingStyles.NUMBER_ID);
		highlight(model);
	}

	protected void highlight(String functionBody) {
		try {
			EObject model = member(functionBody);
			calculator.provideHighlightingFor((XtextResource) model.eResource(), this, CancelIndicator.NullImpl);
			assertTrue(expectedRegions.toString(), expectedRegions.isEmpty());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void highlightActiveAnnotation(String functionBody) {
		try {
			EObject model = secondMember(functionBody);
			calculator.provideHighlightingFor((XtextResource) model.eResource(), this, CancelIndicator.NullImpl);
			assertTrue(expectedRegions.toString(), expectedRegions.isEmpty());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void addImport(String importString){
		imports.add("import " + importString);
	}
	
	protected void addInject(String injectString) {
		injects.add("@Inject " + injectString);
	}

	protected void expectClass(int offset, int length) {
		expect(offset, length, CLASS);
	}
	
	protected void expectMethod(int offset, int length) {
		expect(offset, length, METHOD);
	}
	
	protected void expectInsignificant(int offset, int length) {
		expectAbsolute(offset, length, INSIGNIFICANT_TEMPLATE_TEXT);
	}
	
	protected void expectSemanticLineBreak(int offset, int length) {
		expectAbsolute(offset, length, SEMANTIC_LINE_BREAK);
	}

	protected void expect(int offset, int length, String highlightID) {
		expectedRegions.put(new TextRegion(offset, length), highlightID);
	}
	
	protected void expectAbsolute(int offset, int length, String highlightID) {
		expect(offset + getPrefixLength(), length, highlightID);
	}
	
	protected void notExpect(int offset, int length, String highlightID){
		explicitNotExpectedRegions.put(new TextRegion(offset, length), highlightID);
	}
	
	protected void notExpectAbsolute(int offset, int length, String highlightID){
		notExpect(offset + getPrefixLength(), length, highlightID);
	}

	@Override
	public void addPosition(int offset, int length, String... ids) {
		if (logEnabled ) {
			System.out.print("acceptor.addPosition(" + (offset-22) + ", " + length);
			for(String id: ids) {
				System.out.print(", \"" + id + "\"");	
			}
			System.out.println(");");
		}
		assertTrue("length = " + length, length >= 0);
		TextRegion region = new TextRegion(offset, length);
		assertEquals(1, ids.length);
		// I deactivated the following check as it is to strict/to simple in the face of the new fine-grained coloring 
		//  assertFalse(region.toString() + " is not contained in " + expectedRegions, expectedRegions.isEmpty());
		Collection<String> expectedIds = expectedRegions.get(region);
		if(strictMode && expectedIds.isEmpty())
			fail("No Region for (offset: "+offset+", length : "+length+", id : "+ids[0]+") expected.");
		if(expectedIds.size() > 0)
			assertTrue("expected: " + expectedRegions.toString() + " but was: " + region + " (" + ids[0] + ")", expectedIds.contains(ids[0]));
		if(expectedIds.contains(ids[0]))
			expectedRegions.remove(region, ids[0]);
		Collection<String> unexpectedIds = explicitNotExpectedRegions.get(region);
		assertFalse("unexpected highlighting as position: " + region + " (" + ids[0] + ")", unexpectedIds.contains(ids[0]));
	}
}
