/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.highlighting;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import junit.framework.Test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtend2.ui.highlighting.HighlightingConfiguration;
import org.eclipse.xtext.xtend2.ui.highlighting.RichStringAwareHighlightingCalculator;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Xtend2HighlightingCalculatorTest extends AbstractXtend2UITestCase implements IHighlightedPositionAcceptor {

	public static Test suite() {
		return WorkbenchTestHelper.suite(Xtend2HighlightingCalculatorTest.class);
	}
	
	@Inject
	private RichStringAwareHighlightingCalculator calculator;
	
	@Inject
	private WorkbenchTestHelper testHelper;
	
	private Map<TextRegion, String> expectedRegions;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expectedRegions = newHashMap();
	}
	
	@Override
	protected void tearDown() throws Exception {
		expectedRegions = null;
		testHelper = null;
		calculator = null;
		super.tearDown();
	}
	
	protected String getPrefix() {
		return "class Foo { def foo() ";
	}
	
	protected int getPrefixLength() {
		return getPrefix().length();
	}
	
	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz(getPrefix()+string+"}");
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		return function;
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
		expect(14,1,HighlightingConfiguration.TEMPLATE_LINE_BREAK);
		highlight(
				"'''  \n" +
				" foobar \n" +
				"'''");
	}
	
	public void testLiteralsWithComments() {
		expect(0, 3);
		expect(3, 2);
		expect(6, 2);
		expect(18, 1, HighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expect(19, 1);
		expect(37, 1);
		expect(50, 1, HighlightingConfiguration.TEMPLATE_LINE_BREAK);
		expect(51, 2);
		expect(86, 1, HighlightingConfiguration.TEMPLATE_LINE_BREAK);
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
		expect(17,1,HighlightingConfiguration.POTENTIAL_LINE_BREAK);
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
	
	@SuppressWarnings("restriction")
	protected void highlight(String functionBody) {
		try {
			XtendFunction model = function(functionBody);
			calculator.provideHighlightingFor((XtextResource) model.eResource(), this);
			assertTrue(expectedRegions.toString(), expectedRegions.isEmpty());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void expect(int offset, int length) {
		expect(offset, length, HighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
	}

	protected void expect(int offset, int length, String highlightID) {
		expectedRegions.put(new TextRegion(offset, length), highlightID);
	}

	public void addPosition(int offset, int length, String... id) {
		TextRegion region = new TextRegion(offset - getPrefixLength(), length);
		assertEquals(1, id.length);
		assertFalse(region.toString(), expectedRegions.isEmpty());
		String expectedID = expectedRegions.remove(region);
		assertNotNull("expected: " + expectedRegions.toString() + " but was: " + region + " (" + id[0] + ")", expectedID);
		assertEquals(expectedID, id[0]);
	}
	
}
