/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.refactoring;

import java.util.List;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein
 */
public class ExpressionUtilTest extends AbstractXbaseTestCase {
	@Inject
	private ExpressionUtil util;

	@Inject
	private ParseHelper<XExpression> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Test
	public void testSelectedExpression() throws Exception {
		assertExpressionSelected("$$123+456", "123");
		assertExpressionSelected("$1$23+456", "123");
		assertExpressionSelected("$12$3+456", "123");
		assertExpressionSelected("$123$+456", "123");
		assertExpressionSelected("1$$23+456", "123");
		assertExpressionSelected("12$$3+456", "123");
		assertExpressionSelected("123$$+456", "123");
		assertExpressionSelected("123+$$456", "456");
		assertExpressionSelected("123$+$456", "123+456");
		assertExpressionSelected("12$3+$456", "123+456");
		assertExpressionSelected("123$+4$56", "123+456");
		assertExpressionSelected("if(Boolean.TRUE$$) null", "Boolean.TRUE");
		assertExpressionSelected("if(Boolean.TRUE)$$ null", "if(Boolean.TRUE) null");
		assertExpressionSelected("if(Boolean.TRUE) null$$ else null", "null");
		assertExpressionSelected("if(Boolean.TRUE) null $$else null", "if(Boolean.TRUE) null else null");
		assertExpressionSelected("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[$it|toFirstUpper]$", "[it|toFirstUpper]");
		assertExpressionSelected("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[it$|$toFirstUpper]", "[it|toFirstUpper]");
		assertExpressionSelected("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map$[it|toFirstUpper]$", "[it|toFirstUpper]");
		assertExpressionSelected("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map$[it|toFirstUpper$]", "[it|toFirstUpper]");
		assertExpressionSelected("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map$[it|toFirstUpper$]", "[it|toFirstUpper]");
	}

	@Test
	public void testSelectedExpression_01() throws Exception {
		assertExpressionSelected("newArrayList($$true)", "true");
		assertExpressionSelected("newArrayList($$\'ru\')", "\'ru\'");
		assertExpressionSelected("newArrayList($\'ru\'$)", "\'ru\'");
		assertExpressionSelected("newArrayList(\'ru\'$$)", "\'ru\'");
		assertExpressionSelected("newArrayList(\'ru$$\')", "\'ru\'");
		assertExpressionSelected("newArrayList(\'$ru$\')", "\'ru\'");
	}

	@Test
	public void testSelectedExpression_02() throws Exception {
		assertExpressionSelected("if(Boolean.$$TRUE) null", "Boolean.TRUE");
	}

	@Test
	public void testSelectedExpression_03() throws Exception {
		assertExpressionSelected("newArrayList($$#[42])", "#[42]");
	}

	@Test
	public void testSelectedExpression_04() throws Exception {
		assertExpressionSelected("newArrayList($$#{42})", "#{42}");
	}

	@Test
	public void testSelectedExpression_05() throws Exception {
		assertExpressionSelected("newArrayList($${42})", "{42}");
	}

	@Test
	public void testSelectedExpression_06() throws Exception {
		assertExpressionSelected("newArrayList($ {$42})", "{42}");
	}

	@Test
	public void testBug401082() throws Exception {
		assertExpressionSelected("{ var Object x val result = ($(x as String).toString$ ?:\"foo\") }", "(x as String).toString");
		assertExpressionSelected("{ var Object x val result = ($(x as String).$toString ?:\"foo\") }", "(x as String).toString");
		assertExpressionSelected("{ var Object x val result = ($(x as String)$.toString ?:\"foo\") }", "x as String");
	}

	@Test
	public void testSelectedExpressions() throws Exception {
		assertSiblingExpressionsSelected("$$123+456", "123");
		assertSiblingExpressionsSelected("$1$23+456", "123");
		assertSiblingExpressionsSelected("$12$3+456", "123");
		assertSiblingExpressionsSelected("$123$+456", "123");
		assertSiblingExpressionsSelected("1$$23+456", "123");
		assertSiblingExpressionsSelected("12$$3+456", "123");
		assertSiblingExpressionsSelected("123$$+456", "123");
		assertSiblingExpressionsSelected("123+$$456", "456");
		assertSiblingExpressionsSelected("123$+$456", "123+456");
		assertSiblingExpressionsSelected("12$3+$456", "123+456");
		assertSiblingExpressionsSelected("123$+4$56", "123+456");
		assertSiblingExpressionsSelected("if(Boolean.$$TRUE) null", "Boolean.TRUE");
		assertSiblingExpressionsSelected("if(Boolean.TRUE$$) null", "Boolean.TRUE");
		assertSiblingExpressionsSelected("if(Boolean.TRUE)$$ null", "if(Boolean.TRUE) null");
		assertSiblingExpressionsSelected("if(Boolean.TRUE) $$null", "null");
		assertSiblingExpressionsSelected("if(Boolean.TRUE) null$$ else null", "null");
		assertSiblingExpressionsSelected("if(Boolean.TRUE) null $$else null", "if(Boolean.TRUE) null else null");
	}

	@Test
	public void testSelectedExpressions_1() throws Exception {
		assertSiblingExpressionsSelected("{ val x=$1 val y=3$ val z=5 }", "val x=1 val y=3");
		assertSiblingExpressionsSelected("{ val x=1$ val y=3 $val z=5 }", "val y=3");
		assertSiblingExpressionsSelected("{ val x=1 $val y=3$ val z=5 }", "val y=3");
		assertSiblingExpressionsSelected("{ val x=1 $val y=3 $val z=5 }", "val y=3");
		assertSiblingExpressionsSelected("{ val x=1 $val y=3 v$al z=5 }", "val y=3 val z=5");
	}

	@Test
	public void testInsertionPoint() throws Exception {
		assertInsertionPoint("{ val x = 1 $2+3 }", "2+3");
		assertInsertionPoint("{ val x = 1 2$+3 }", "2+3");
		assertInsertionPoint("{ val x = 1 2+$3 }", "2+3");
		assertInsertionPoint("{ val x = $1 2+$3 }", "val x = 1");
		assertInsertionPoint("{ val x = 1$ 2+$3 }", "val x = 1");
	}

	@Test
	public void testInsertionPointIf() throws Exception {
		assertInsertionPoint("if($1==2.intValue) true", null);
		assertInsertionPoint("{ if($1==2.intValue) true }", "if(1==2.intValue) true");
		assertInsertionPoint("if(1==2.intValue) $true", "true");
		assertInsertionPoint("if(1==2.intValue) true else $false", "false");
		assertInsertionPoint("if(1==2.intValue) { val x = 7 + $8 }", "val x = 7 + 8");
	}

	@Test
	public void testInsertionPointSwitch() throws Exception {
		assertInsertionPoint("switch 1 { case 1: 2+$3 }", "2+3");
		assertInsertionPoint("switch 1 { case 2: true default: 2+$3 }", "2+3");
	}

	@Test
	public void testInsertionPointWhile() throws Exception {
		assertInsertionPoint("while(true) new $String()", "new String()");
		assertInsertionPoint("while($true) new $String()", null);
		assertInsertionPoint("do new $String() while(true)", "new String()");
		assertInsertionPoint("do new String() while($true)", null);
	}

	@Test
	public void testInsertionPointFor() throws Exception {
		assertInsertionPoint("for(i: 1..2) new $String()", "new String()");
		assertInsertionPoint("for(i: $1..2) new $String()", null);
	}

	@Test
	public void testInsertionPointClosure() throws Exception {
		assertInsertionPoint("[|2+$3]", "2+3");
		assertInsertionPoint("[|2$+3]", "2+3");
		assertInsertionPoint("[|$2+3]", "2+3");
	}

	@Test
	public void testInsertionPointTry() throws Exception {
		assertInsertionPoint("try 2+$3 catch(Exception e) true", "2+3");
		assertInsertionPoint("try true catch(Exception e) new $String()", "new String()");
		assertInsertionPoint("try true finally new $String()", "new String()");
	}

	protected void assertExpressionSelected(String modelWithSelectionMarkup, String expectedSelection) throws Exception {
		String cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "");
		XExpression expression = parse(cleanedModel);
		int selectionOffset = modelWithSelectionMarkup.indexOf("$");
		int selectionLength = modelWithSelectionMarkup.lastIndexOf("$") - selectionOffset - 1;
		XExpression selectedExpression = util.findSelectedExpression((XtextResource) expression.eResource(),
				new TextSelection(selectionOffset, selectionLength));
		ITextRegion selectedRegion = locationInFileProvider.getFullTextRegion(selectedExpression);
		assertEquals(expectedSelection,
				cleanedModel.substring(selectedRegion.getOffset(), selectedRegion.getOffset() + selectedRegion.getLength()));
	}

	protected void assertSiblingExpressionsSelected(String modelWithSelectionMarkup, String expectedSelection) throws Exception {
		String cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "");
		XExpression expression = parse(cleanedModel);
		int selectionOffset = modelWithSelectionMarkup.indexOf("$");
		int selectionLength = modelWithSelectionMarkup.lastIndexOf("$") - selectionOffset - 1;
		List<XExpression> selectedExpressions = util.findSelectedSiblingExpressions((XtextResource) expression.eResource(),
				new TextSelection(selectionOffset, selectionLength));
		List<ITextRegion> regions = ListExtensions.map(selectedExpressions, it -> locationInFileProvider.getFullTextRegion(it));
		ITextRegion selectedRegion = IterableExtensions.reduce(regions, (a, b) -> a.merge(b));
		assertEquals(expectedSelection,
				cleanedModel.substring(selectedRegion.getOffset(), selectedRegion.getOffset() + selectedRegion.getLength()));
	}

	protected void assertInsertionPoint(String modelWithInsertionMarkup, String expectedSuccessor) throws Exception {
		String cleanedModel = modelWithInsertionMarkup.replaceAll("\\$", "");
		XExpression expression = parse(cleanedModel);
		int selectionOffset = modelWithInsertionMarkup.indexOf("$");
		XExpression selectedExpression = util.findSelectedExpression((XtextResource) expression.eResource(),
				new TextSelection(selectionOffset, 0));
		XExpression successor = util.findSuccessorExpressionForVariableDeclaration(selectedExpression);
		if (expectedSuccessor == null) {
			assertNull(successor);
		} else {
			assertNotNull(successor);
			ITextRegion selectedRegion = locationInFileProvider.getFullTextRegion(successor);
			assertEquals(expectedSuccessor,
					cleanedModel.substring(selectedRegion.getOffset(), selectedRegion.getOffset() + selectedRegion.getLength()));
		}
	}

	protected XExpression parse(CharSequence string) throws Exception {
		XExpression expression = parseHelper.parse(string);
		validationHelper.assertNoErrors(expression);
		return expression;
	}
}
