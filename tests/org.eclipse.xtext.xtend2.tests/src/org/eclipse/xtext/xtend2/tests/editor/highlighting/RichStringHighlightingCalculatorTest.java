/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.editor.highlighting;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtend2.tests.richstring.AbstractRichStringTest;
import org.eclipse.xtext.xtend2.ui.highlighting.HighlightingConfiguration;
import org.eclipse.xtext.xtend2.ui.highlighting.RichStringHighlightingCalculator;
import org.eclipse.xtext.xtend2.xtend2.RichString;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringHighlightingCalculatorTest extends AbstractRichStringTest implements IHighlightedPositionAcceptor {

	@Inject
	private RichStringHighlightingCalculator calculator;
	
	private Map<TextRegion, String> expectedRegions;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expectedRegions = newHashMap();
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
	
	public void testExpression() {
		String model = 
			"'''\n" +
			"\t\t«'foobar'» \n" +
			"  '''";
		expect(0, 3);
		expect(model.indexOf('\t'), 2);
		expect(model.indexOf(' '), 1);
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
	
	protected void highlight(String richString) {
		try {
			RichString model = richString(richString);
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
		assertNotNull("expected: " + expectedRegions.toString() + " but was: " + region, expectedID);
		assertEquals(expectedID, id[0]);
	}
	
}
