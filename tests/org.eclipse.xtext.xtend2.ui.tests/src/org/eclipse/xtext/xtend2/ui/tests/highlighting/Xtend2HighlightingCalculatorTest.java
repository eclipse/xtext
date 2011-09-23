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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class Xtend2HighlightingCalculatorTest extends AbstractXtend2UITestCase implements IHighlightedPositionAcceptor {

	public static Test suite() {
		return WorkbenchTestHelper.suite(Xtend2HighlightingCalculatorTest.class);
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
		String classString = "";
		for(String importDef : imports)
			classString += importDef + " ";
		classString += "class Foo { "; 
		for(String injectDef : injects)
			classString += injectDef + " ";	
		classString += "def foo() ";
		return classString;
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
		ResourceSet set = testHelper.getResourceSet();
		Resource resource = set.createResource(URI.createURI("Foo.xtend"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
	public void testEmptyString() {
		expect(0, 3);
		expect(3, 3);
		highlight("''''''");
	}
	
	public void testStringWithWS() {
		expect(0, 3);
		expect(5, 3);
		highlight("'''  '''");
	}
	
	public void testSingleLineLiteral() {
		expect(0, 3);
		expect(9, 3);
		highlight(
				"'''foobar'''");
	}
	
	public void testLiteral() {
		expect(0, 3);
		expect(3, 2);
		expect(6, 1);
		expect(15,3);
		expect(14,1,XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		highlight(
				"'''  \n" +
				" foobar \n" +
				"'''");
	}
	
	public void testLiteralsWithComments() {
		expect(0, 3);
		expect(3, 2);
		expect(6, 2);
		expect(18, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expect(19, 1);
		expect(37, 1);
		expect(50, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expect(51, 2);
		expect(86, 1, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expect(87, 3);
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
		expect(0, 3);
		expect(model.indexOf('\t'), 2);
		expect(model.indexOf("  "), 2);
		expect(model.lastIndexOf("'''"), 3);
		expect(17,1,XtendHighlightingConfiguration.POTENTIAL_LINE_BREAK);
		highlight(model);
	}
	
	public void testSingleLineExpression() {
		String model = "'''«'literal'»'''";
		expect(0, 3);
		expect(14, 3);
		highlight(model);
	}
	
	public void testVoid() {
		String model = "{ var void v = null }";
		expect(model.indexOf("void"), 4, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testThis() {
		String model = "{ var f = this }";
		expect(model.indexOf("this"), 4, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testInt() {
		String model = "{ var int i = 1 }";
		expect(model.indexOf("int"), 3, DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	public void testCreateAsIdentifier() {
		String model = "{ var String create = '' }";
		expect(model.indexOf("create"), 6, DefaultHighlightingConfiguration.DEFAULT_ID);
		highlight(model);
	}
	
	public void testCreateKeyword() {
		String model = "{} def create result: new Object() create() {}";
		expect(model.lastIndexOf("create"), 6, DefaultHighlightingConfiguration.DEFAULT_ID);
		highlight(model);
	}
	
	public void testStaticFieldAccess() throws Exception {
		String model = "{ Integer::MAX_VALUE }";
		expect(model.lastIndexOf("MAX_VALUE"), 9, XbaseHighlightingConfiguration.STATIC_FIELD);
		notExpect(model.lastIndexOf("MAX_VALUE"), 9, XbaseHighlightingConfiguration.FIELD);
		highlight(model);
	}
	
	public void testStaticOperationInvocation() throws Exception {
		addImport("java.util.Collections");
		String model = "{ Collections::emptySet  }";
		expect(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpect(model.lastIndexOf("emptySet"), 8, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	public void testStaticExtensionOperationInvocation() throws Exception {
		String model = "{ 'FOO'.toFirstLower   }";
		expect(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		expect(model.lastIndexOf("toFirstLower"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testNonStaticExtensionOperationInvocation() throws Exception {
		addImport("com.google.inject.Inject");
		addInject("extension StringBuilder");
		String model = "{ 'Foo'.append   }";
		expect(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		notExpect(model.lastIndexOf("append"), 6, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testStaticImportedExtensionOperationInvocation() throws Exception {
		addImport("static extension java.util.Collections.*");
		String model = "{ newArrayList.shuffle   }";
		expect(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		notExpect(model.lastIndexOf("newArrayList"), 12, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expect(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
		expect(model.lastIndexOf("shuffle"), 7, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
		highlight(model);
	}
	
	public void testAnnotaton() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject extension StringBuilder";
		expect(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	public void testReferencedJvmAnnotatonType() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{ val bar = typeof(Inject) } ";
		expect(model.lastIndexOf("Inject"), 6, XbaseHighlightingConfiguration.ANNOTATION);
		highlight(model);
	}
	
	public void testXtendFieldDeclaration() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar";
		expect(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		expect(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpect(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		highlight(model);
	}
	
	public void testNonStaticFieldAccess() throws Exception {
		addImport("com.google.inject.Inject");
		String model = "{} @Inject StringBuilder bar def testFunction() { bar.append('foo') }";
		expect(model.lastIndexOf("@Inject"), 7, XbaseHighlightingConfiguration.ANNOTATION);
		expect(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpect(model.indexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
		expect(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.FIELD);
		notExpect(model.lastIndexOf("bar"), 3, XbaseHighlightingConfiguration.STATIC_FIELD);
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

	protected void expect(int offset, int length) {
		expect(offset, length, XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
	}

	protected void expect(int offset, int length, String highlightID) {
		expectedRegions.put(new TextRegion(offset, length), highlightID);
	}
	
	protected void notExpect(int offset, int length, String highlighID){
		explicitNotExpectedRegions.put(new TextRegion(offset, length), highlighID);
	}

	public void addPosition(int offset, int length, String... id) {
		TextRegion region = new TextRegion(offset - getPrefixLength(), length);
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
