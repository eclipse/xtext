/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.highlighting;

import java.util.Collection;
import java.util.Set;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xtend2.ui.highlighting.XtendHighlightingCalculator;
import org.eclipse.xtext.xtend2.ui.highlighting.XtendHighlightingConfiguration;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHighlightingCalculatorTest extends AbstractXtend2UITestCase implements IHighlightedPositionAcceptor {

	public static final String DEFAULT_CLASS_DEF = "class Foo";
	
	private  static final String TEST_HELP_CLASS_STRING = "package test; @Deprecated " +
			"public class TestClassDeprecated { " +
			"@Deprecated public static String DEPRECATED_CONSTANT = 'foo'" +
			"@Deprecated public static String CONSTANT = 'foo'" +
			"@Deprecated public void testMethodDeprecated(){} " +
			"public void testMethodNotDeprecated(){} " +
			"@Deprecated public static void testMethodStaticDeprecated(){} " +
			"public static void testMethodStaticNotDeprecated(){}}";
	
	private String classDefString = DEFAULT_CLASS_DEF;

	public static Test suite() {
		return WorkbenchTestHelper.suite(XtendHighlightingCalculatorTest.class);
	}
	
	@Inject
	private XtendHighlightingCalculator calculator;
	
	@Inject
	private WorkbenchTestHelper testHelper;
	
	private Multimap<TextRegion, String> expectedRegions;
	
	private Multimap<TextRegion, String> explicitNotExpectedRegions;
	
	private Set<String> imports;
	
	private Set<String> injects;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expectedRegions = HashMultimap.create();
		explicitNotExpectedRegions = HashMultimap.create();
		imports = Sets.newHashSet();
		injects = Sets.newHashSet();
		classDefString = DEFAULT_CLASS_DEF;
	}
	
	@Override
	protected void tearDown() throws Exception {
		expectedRegions = null;
		explicitNotExpectedRegions = null;
		imports = null;
		injects = null;
		testHelper = null;
		calculator = null;
		super.tearDown();
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
	
	protected XtendClass member(String string) throws Exception {
		return clazz(getPrefix()+string+"}");
	}
	
	protected XtendClass clazz(String string) throws Exception {
		return file(string).getXtendClass();
	}

	protected XtendFile file(String string) throws Exception {
		createFile(testHelper.getProject().getName() + "/src/test/TestClassDeprecated.java",TEST_HELP_CLASS_STRING);
		waitForAutoBuild();
		ResourceSet set = testHelper.getResourceSet();
		Resource resource = set.createResource(URI.createURI("Foo.xtend"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
	public void testEmptyString() {
		expectAbsolut(0, 3);
		expectAbsolut(3, 3);
		highlight("''''''");
	}
	
	public void testStringWithWS() {
		expectAbsolut(0, 3);
		expectAbsolut(5, 3);
		highlight("'''  '''");
	}
	
	public void testSingleLineLiteral() {
		expectAbsolut(0, 3);
		expectAbsolut(9, 3);
		highlight(
				"'''foobar'''");
	}
	
	public void testLiteral() {
		expectAbsolut(0, 3);
		expectAbsolut(3, 2);
		expectAbsolut(6, 1);
		expectAbsolut(15,3);
		expectAbsolut(14,1,XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		highlight(
				"'''  \n" +
				" foobar \n" +
				"'''");
	}
	
	public void testLiteralsWithComments() {
		expectAbsolut(0, 3);
		expectAbsolut(3, 2);
		expectAbsolut(6, 2);
		expectAbsolut(18, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expectAbsolut(19, 1);
		expectAbsolut(37, 1);
		expectAbsolut(50, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expectAbsolut(51, 2);
		expectAbsolut(86, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expectAbsolut(87, 3);
		highlight(
				"'''  \n" +
				"  first line\n" +
				" « /* comment */ » second line \n" +
				"  third«\n" +
				"   /* comment */ \n" +
				" » line \n" +
				"'''");
	}
	
	public void testExpression() {
		String model = 
			"'''\n" +
			"\t\t«'foobar'» \n" +
			"  '''";
		expectAbsolut(0, 3);
		expectAbsolut(model.indexOf('\t'), 2);
		expectAbsolut(model.indexOf("  "), 2);
		expectAbsolut(model.lastIndexOf("'''"), 3);
		expectAbsolut(17,1,XtendHighlightingConfiguration.POTENTIAL_LINE_BREAK);
		highlight(model);
	}
	
	public void testSingleLineExpression() {
		String model = "'''«'literal'»'''";
		expectAbsolut(0, 3);
		expectAbsolut(14, 3);
		highlight(model);
	}
	
	public void testVoid() {
		String model = "{ var void v = null }";
		expectAbsolut(model.indexOf("void"), 4, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testThis() {
		String model = "{ var f = this }";
		expectAbsolut(model.indexOf("this"), 4, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testInt() {
		String model = "{ var int i = 1 }";
		expectAbsolut(model.indexOf("int"), 3, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testCreateAsIdentifier() {
		String model = "{ var String create = '' }";
		expectAbsolut(model.indexOf("create"), 6, DefaultHighlightingConfiguration.DEFAULT_ID);
		highlight(model);
	}
	
	public void testCreateKeyword() {
		String model = "{} def create result: new Object() create() {}";
		expectAbsolut(model.lastIndexOf("create"), 6, DefaultHighlightingConfiguration.DEFAULT_ID);
		highlight(model);
	}
	
	public void testStaticFieldAccess() throws Exception {
		String model = "{ Integer::MAX_VALUE }";
		expectAbsolut(model.lastIndexOf("MAX_VALUE"), 9, XbaseHighlightingConfiguration.STATIC_FIELD);
		notExpectAbsolut(model.lastIndexOf("MAX_VALUE"), 9, XbaseHighlightingConfiguration.FIELD);
		highlight(model);
	}
	
	public void testStaticOperationInvocation() throws Exception {
		addImport("java.util.Collections");
		String model = "{ Collections::emptySet  }";
		expectAbsolut(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolut(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	public void testStaticExtensionOperationInvocation() throws Exception {
		String model = "{ 'FOO'.toFirstLower   }";
		expectAbsolut(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		expectAbsolut(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testNonStaticExtensionOperationInvocation() throws Exception {
		addImport("com.google.inject.Inject");
		addInject("extension StringBuilder");
		String model = "{ 'Foo'.append   }";
		expectAbsolut(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		notExpectAbsolut(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testStaticImportedExtensionOperationInvocation() throws Exception {
		addImport("static extension java.util.Collections.*");
		String model = "{ newArrayList.shuffle   }";
		expectAbsolut(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolut(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolut(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolut(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testStaticExtensionOperationWithNoImplicitArguments() throws Exception {
		addImport("java.util.List");
		String model = "def toUpperCase(List<String> it) { map [ toUpperCase ]}";
		expectAbsolut(model.lastIndexOf("map"), 3, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expectAbsolut(model.lastIndexOf("map"), 3, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
	}
	
	public void testAnnotaton() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject extension StringBuilder";
		expectAbsolut(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	public void testReferencedJvmAnnotatonType() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{ val bar = typeof(Inject) } ";
		expectAbsolut(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	public void testXtendFieldDeclaration() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar";
		expectAbsolut(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolut(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	public void testNonStaticFieldAccess() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar def testFunction() { bar.append('foo') }";
		expectAbsolut(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolut(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolut(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolut(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	
	public void testDeprecatedXtendClass() throws Exception {
		classDefString = "@Deprecated class Bar";
		String model = "{}";
		expect(getPrefix().lastIndexOf("@Deprecated"), 11, XbaseHighlightingConfiguration.ANNOTATION);
		expect(getPrefix().indexOf("Bar"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testDeprecatedParentClass() throws Exception {
		addImport("test.TestClassDeprecated");
		classDefString = "class Bar extends TestClassDeprecated";
		String model = "{}";
		expect(getPrefix().lastIndexOf("TestClassDeprecated"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}

	public void testDeprecatedStaticFieldAccess() throws Exception {
		addImport("test.TestClassDeprecated");
		String model = "{TestClassDeprecated::DEPRECATED_CONSTANT}";
		expectAbsolut(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.STATIC_FIELD);
		expectAbsolut(model.lastIndexOf("DEPRECATED_CONSTANT"), 19, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testDeprecatedMethodAccess() throws Exception {
		addImport("test.TestClassDeprecated");
		addImport("com.google.inject.Inject");
		String model = "{} @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodDeprecated() }";
		expectAbsolut(model.indexOf("@Inject"), 7,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolut(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolut(model.lastIndexOf("testMethodDeprecated"), 20, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testNotDeprecatedMethodAccess() throws Exception {
		addImport("test.TestClassDeprecated");
		addImport("com.google.inject.Inject");
		String model = "{} @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodNotDeprecated() }";
		expectAbsolut(model.indexOf("@Inject"), 7,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolut(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		notExpectAbsolut(model.indexOf("testMethodNotDeprecated"), 23, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testDeprecatedStaticMethodAccess() throws Exception {
		addImport("test.TestClassDeprecated");
		String model = "{TestClassDeprecated::testMethodStaticDeprecated() }";
		expectAbsolut(model.lastIndexOf("testMethodStaticDeprecated"), 26, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		expectAbsolut(model.lastIndexOf("testMethodStaticDeprecated"), 26, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testNotDeprecatedStaticMethodAccess() throws Exception {
		addImport("test.TestClassDeprecated");
		String model = "{TestClassDeprecated::testMethodStaticNotDeprecated() }";
		expectAbsolut(model.lastIndexOf("testMethodStaticNotDeprecated"), 29, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpectAbsolut(model.lastIndexOf("testMethodStaticNotDeprecated"), 29, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testDeprecatedXtendField() throws Exception {
		addImport("test.TestClassDeprecated");
		addImport("com.google.inject.Inject");
		String model = "{} @Deprecated @Inject TestClassDeprecated clazz def baz(){ clazz.testMethodNotDeprecated() }";
		expectAbsolut(model.indexOf("@Deprecated"), 11,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("@Inject"), 7,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolut(model.indexOf("clazz"), 5, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolut(model.lastIndexOf("clazz"), 5, XbaseHighlightingConfiguration.FIELD);
		expectAbsolut(model.lastIndexOf("clazz"), 5,XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		notExpectAbsolut(model.indexOf("testMethodNotDeprecated"), 23, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	public void testDeprecatedXtendFunction() throws Exception {
		String model = "{} @Deprecated def baz(){} def bar(){ baz()}";
		expectAbsolut(model.indexOf("@Deprecated"), 11,XbaseHighlightingConfiguration.ANNOTATION);
		expectAbsolut(model.indexOf("baz"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		expectAbsolut(model.lastIndexOf("baz"), 3, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		highlight(model);
	}
	
	
	protected void highlight(String functionBody) {
		try {
			XtendClass model = member(functionBody);
			calculator.provideHighlightingFor((XtextResource) model.eResource(), this);
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

	protected void expectAbsolut(int offset, int length) {
		expectAbsolut(offset, length, XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
	}

	protected void expect(int offset, int length, String highlightID) {
		expectedRegions.put(new TextRegion(offset, length), highlightID);
	}
	
	protected void expectAbsolut(int offset, int length, String highlightID) {
		expect(offset + getPrefixLength(), length, highlightID);
	}
	
	protected void notExpect(int offset, int length, String highlighID){
		explicitNotExpectedRegions.put(new TextRegion(offset, length), highlighID);
	}
	
	protected void notExpectAbsolut(int offset, int length, String highlighID){
		notExpect(offset + getPrefixLength(), length, highlighID);
	}

	public void addPosition(int offset, int length, String... id) {
		TextRegion region = new TextRegion(offset, length);
		assertEquals(1, id.length);
		assertFalse(region.toString(), expectedRegions.isEmpty());
		Collection<String> exprectedIds = expectedRegions.get(region);
		if(exprectedIds.size() > 0)
			assertTrue("expected: " + expectedRegions.toString() + " but was: " + region + " (" + id[0] + ")", exprectedIds.contains(id[0]));
		if(exprectedIds.contains(id[0]))
			expectedRegions.remove(region, id[0]);
		Collection<String> notExprectedIds = explicitNotExpectedRegions.get(region);
		assertFalse("not exspected highlighting as position: " + region + " (" + id[0] + ")", notExprectedIds.contains(id[0]));
	}
}
