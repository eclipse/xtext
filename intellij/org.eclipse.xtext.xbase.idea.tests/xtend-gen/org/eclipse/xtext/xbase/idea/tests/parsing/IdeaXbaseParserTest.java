package org.eclipse.xtext.xbase.idea.tests.parsing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.idea.tests.parsing.XExpressionChecker;
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest;
import org.junit.Assert;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaXbaseParserTest extends XbaseParserTest {
  private final XExpressionChecker expresssionChecker;
  
  protected XExpression expression(final CharSequence string) throws Exception {
    String _string = string.toString();
    return this.expresssionChecker.testExpression(_string, false);
  }
  
  protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
    return this.expression(string);
  }
  
  protected void doTestStaticFeatureCall_ValueOf(final XMemberFeatureCall call) {
    XExpression _memberCallTarget = call.getMemberCallTarget();
    Assert.assertNotNull(_memberCallTarget);
  }
  
  protected void doTestStaticFeatureCall_CaseInsensitiveOrder(final XMemberFeatureCall call) {
    XExpression _memberCallTarget = call.getMemberCallTarget();
    Assert.assertNotNull(_memberCallTarget);
  }
  
  protected void doTestConstructorCall_0(final XConstructorCall cc) {
    JvmConstructor _constructor = cc.getConstructor();
    Assert.assertNotNull(_constructor);
    EList<XExpression> _arguments = cc.getArguments();
    int _size = _arguments.size();
    Assert.assertEquals(0, _size);
  }
  
  protected void doTestConstructorCall_1(final XConstructorCall cc) {
    JvmConstructor _constructor = cc.getConstructor();
    Assert.assertNotNull(_constructor);
    EList<XExpression> _arguments = cc.getArguments();
    int _size = _arguments.size();
    Assert.assertEquals(1, _size);
    EList<XExpression> _arguments_1 = cc.getArguments();
    XExpression _get = _arguments_1.get(0);
    String _value = ((XNumberLiteral) _get).getValue();
    Assert.assertEquals("1", _value);
  }
  
  protected void doTestConstructorCall_2(final XConstructorCall cc) {
    JvmConstructor _constructor = cc.getConstructor();
    Assert.assertNotNull(_constructor);
    EList<XExpression> _arguments = cc.getArguments();
    int _size = _arguments.size();
    Assert.assertEquals(1, _size);
    EList<XExpression> _arguments_1 = cc.getArguments();
    XExpression _get = _arguments_1.get(0);
    String _value = ((XNumberLiteral) _get).getValue();
    Assert.assertEquals("13", _value);
  }
  
  protected void doTestTryCatchExpression(final XTryCatchFinallyExpression tryEx) {
    XExpression _expression = tryEx.getExpression();
    XExpression _expression_1 = ((XThrowExpression) _expression).getExpression();
    this.assertFeatureCall("foo", _expression_1);
    XExpression _finallyExpression = tryEx.getFinallyExpression();
    this.assertFeatureCall("baz", _finallyExpression);
    EList<XCatchClause> _catchClauses = tryEx.getCatchClauses();
    int _size = _catchClauses.size();
    Assert.assertEquals(1, _size);
    EList<XCatchClause> _catchClauses_1 = tryEx.getCatchClauses();
    XCatchClause clause = _catchClauses_1.get(0);
    XExpression _expression_2 = clause.getExpression();
    this.assertFeatureCall("bar", _expression_2);
    JvmFormalParameter _declaredParam = clause.getDeclaredParam();
    String _name = _declaredParam.getName();
    Assert.assertEquals("e", _name);
  }
  
  protected void doTestTryCatchExpression_2(final XTryCatchFinallyExpression tryEx) {
    XExpression _expression = tryEx.getExpression();
    this.assertFeatureCall("foo", _expression);
    XExpression _finallyExpression = tryEx.getFinallyExpression();
    Assert.assertNull(_finallyExpression);
    EList<XCatchClause> _catchClauses = tryEx.getCatchClauses();
    int _size = _catchClauses.size();
    Assert.assertEquals(1, _size);
    EList<XCatchClause> _catchClauses_1 = tryEx.getCatchClauses();
    XCatchClause clause = _catchClauses_1.get(0);
    XExpression _expression_1 = clause.getExpression();
    this.assertFeatureCall("bar", _expression_1);
    JvmFormalParameter _declaredParam = clause.getDeclaredParam();
    String _name = _declaredParam.getName();
    Assert.assertEquals("e", _name);
  }
  
  protected void doTestInstanceOf(final XInstanceOfExpression expression) {
    XExpression _expression = expression.getExpression();
    Assert.assertTrue((_expression instanceof XBooleanLiteral));
  }
  
  protected void doTestTypeLiteral(final XTypeLiteral expression) {
  }
  
  protected void doTestSwitch_2(final XSwitchExpression se) {
    EList<XCasePart> _cases = se.getCases();
    int _size = _cases.size();
    Assert.assertEquals(2, _size);
    XExpression _default = se.getDefault();
    Assert.assertNull(_default);
    EList<XCasePart> _cases_1 = se.getCases();
    XCasePart c1 = _cases_1.get(0);
    XExpression _case = c1.getCase();
    this.assertFeatureCall("length", _case);
    XExpression _case_1 = c1.getCase();
    XExpression _memberCallTarget = ((XMemberFeatureCall) _case_1).getMemberCallTarget();
    this.assertFeatureCall("foo", _memberCallTarget);
    XExpression _then = c1.getThen();
    this.assertFeatureCall("bar", _then);
    EList<XCasePart> _cases_2 = se.getCases();
    XCasePart c2 = _cases_2.get(1);
    XExpression _case_2 = c2.getCase();
    Assert.assertNull(_case_2);
    XExpression _then_1 = c2.getThen();
    EList<XExpression> _expressions = ((XBlockExpression) _then_1).getExpressions();
    XExpression _get = _expressions.get(0);
    this.assertFeatureCall("baz", _get);
  }
  
  protected void doTestForLoopExpression_1(final XForLoopExpression forExp) {
    XExpression _forExpression = forExp.getForExpression();
    this.assertFeatureCall("foo", _forExpression);
    JvmFormalParameter _declaredParam = forExp.getDeclaredParam();
    String _name = _declaredParam.getName();
    Assert.assertEquals("s", _name);
    XExpression _eachExpression = forExp.getEachExpression();
    this.assertFeatureCall("bar", _eachExpression);
  }
  
  public IdeaXbaseParserTest(final XExpressionChecker expresssionChecker) {
    super();
    this.expresssionChecker = expresssionChecker;
  }
}
