package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XInstanceOfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest

@FinalFieldsConstructor
class IdeaXbaseParserTest extends XbaseParserTest {
	
	val ModelChecker expresssionChecker

	override protected expression(CharSequence string) throws Exception {
		expresssionChecker.checkModel(string.toString, false)
	}
	
	override protected expression(CharSequence string, boolean resolve) throws Exception {
		expression(string)
	}

	override protected void doTestStaticFeatureCall_ValueOf(XMemberFeatureCall call) {
		assertNotNull(call.getMemberCallTarget())
	}

	override protected void doTestStaticFeatureCall_CaseInsensitiveOrder(XMemberFeatureCall call) {
		assertNotNull(call.getMemberCallTarget())
	}
	
	override protected doTestConstructorCall_0(XConstructorCall cc) {
		assertNotNull(cc.getConstructor());
		assertEquals(0, cc.getArguments().size());
	}
	
	override protected void doTestConstructorCall_1(XConstructorCall cc) {
		assertNotNull(cc.getConstructor())
		assertEquals(1, cc.getArguments().size())
		assertEquals("1", (cc.getArguments().get(0) as XNumberLiteral).getValue())
	}

	override protected void doTestConstructorCall_2(XConstructorCall cc) {
		assertNotNull(cc.getConstructor())
		assertEquals(1, cc.getArguments().size())
		assertEquals("13", (cc.getArguments().get(0) as XNumberLiteral).getValue())
	}

	override protected void doTestTryCatchExpression(XTryCatchFinallyExpression tryEx) {
		assertFeatureCall("foo", (tryEx.getExpression() as XThrowExpression).getExpression())
		assertFeatureCall("baz", tryEx.getFinallyExpression())
		
		assertEquals(1, tryEx.getCatchClauses().size())
		var XCatchClause clause = tryEx.getCatchClauses().get(0)
		assertFeatureCall("bar", clause.getExpression())
		assertEquals("e", clause.getDeclaredParam().getName())
	}

	override protected void doTestTryCatchExpression_2(XTryCatchFinallyExpression tryEx) {
		assertFeatureCall("foo", tryEx.getExpression())
		assertNull(tryEx.getFinallyExpression())

		assertEquals(1, tryEx.getCatchClauses().size())
		var XCatchClause clause = tryEx.getCatchClauses().get(0)
		assertFeatureCall("bar", clause.getExpression())
		assertEquals("e", clause.getDeclaredParam().getName())
	}

	override protected void doTestInstanceOf(XInstanceOfExpression expression) {
		assertTrue(expression.getExpression() instanceof XBooleanLiteral)
	}

	override protected void doTestTypeLiteral(XTypeLiteral expression) {
	}

	override protected void doTestSwitch_2(XSwitchExpression se) {
		assertEquals(2, se.getCases().size())
		assertNull(se.getDefault())
		var XCasePart c1 = se.getCases().get(0)
		assertFeatureCall("length", c1.getCase())
		assertFeatureCall("foo", (c1.getCase() as XMemberFeatureCall).getMemberCallTarget())
		assertFeatureCall("bar", c1.getThen())
		
		var XCasePart c2 = se.getCases().get(1)
		assertNull(c2.getCase())
		assertFeatureCall("baz", (c2.getThen() as XBlockExpression).getExpressions().get(0))
	}

	override protected void doTestForLoopExpression_1(XForLoopExpression forExp) {
		assertFeatureCall("foo", forExp.getForExpression())
		assertEquals("s", forExp.getDeclaredParam().getName())
		assertFeatureCall("bar", forExp.getEachExpression())
	}

}