package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.ITypeResolution;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class BatchTypeResolverTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public void resolvesTo(final String expression, final String type) throws Exception {
    final XExpression xExpression = this.expression(expression, false);
    final ITypeResolution typeResolution = this.typeResolver.resolveTypes(xExpression);
    final JvmTypeReference resolvedType = typeResolution.getActualType(xExpression);
    String _simpleName = resolvedType.getSimpleName();
    Assert.assertEquals(type, _simpleName);
  }
  
  public void resolvesTo(final String expression, final Class<?> type) throws Exception {
    String _simpleName = type.getSimpleName();
    this.resolvesTo(expression, _simpleName);
  }
  
  @Test
  public void testNullLiteral() throws Exception {
    this.resolvesTo("null", "null");
  }
  
  @Test
  public void testBooleanLiteral() throws Exception {
    this.resolvesTo("true", "boolean");
    this.resolvesTo("false", "boolean");
  }
  
  @Test
  public void testStringLiteral() throws Exception {
    this.resolvesTo("\'foo\'", "String");
    this.resolvesTo("\"foo\"", "String");
  }
  
  @Test
  public void testNumberLiteral_0() throws Exception {
    this.resolvesTo("3", "int");
  }
  
  @Test
  public void testNumberLiteral_1() throws Exception {
    this.resolvesTo("0x42", "int");
  }
  
  @Test
  public void testNumberLiteral_2() throws Exception {
    this.resolvesTo("1L", "long");
  }
  
  @Test
  public void testNumberLiteral_3() throws Exception {
    this.resolvesTo("0x42#l", "long");
  }
  
  @Test
  public void testNumberLiteral_4() throws Exception {
    this.resolvesTo("1f", "float");
  }
  
  @Test
  public void testNumberLiteral_5() throws Exception {
    this.resolvesTo("1.0f", "float");
  }
  
  @Test
  public void testNumberLiteral_6() throws Exception {
    this.resolvesTo("1.0E10f", "float");
  }
  
  @Test
  public void testNumberLiteral_7() throws Exception {
    this.resolvesTo("1.0e-10f", "float");
  }
  
  @Test
  public void testNumberLiteral_8() throws Exception {
    this.resolvesTo("1.0E+10f", "float");
  }
  
  @Test
  public void testNumberLiteral_9() throws Exception {
    this.resolvesTo("1.0", "double");
  }
  
  @Test
  public void testNumberLiteral_10() throws Exception {
    this.resolvesTo("1.0E10", "double");
  }
  
  @Test
  public void testNumberLiteral_11() throws Exception {
    this.resolvesTo("1.0e-10", "double");
  }
  
  @Test
  public void testNumberLiteral_12() throws Exception {
    this.resolvesTo("1.0E+10", "double");
  }
  
  @Test
  public void testNumberLiteral_13() throws Exception {
    this.resolvesTo("1.0d", "double");
  }
  
  @Test
  public void testNumberLiteral_14() throws Exception {
    this.resolvesTo("1.0E10d", "double");
  }
  
  @Test
  public void testNumberLiteral_15() throws Exception {
    this.resolvesTo("1.0e-10d", "double");
  }
  
  @Test
  public void testNumberLiteral_16() throws Exception {
    this.resolvesTo("1.0E+10d", "double");
  }
  
  @Test
  public void testNumberLiteral_17() throws Exception {
    this.resolvesTo("1234567890123456789012345678901234567890bi", "BigInteger");
  }
  
  @Test
  public void testNumberLiteral_17a() throws Exception {
    this.resolvesTo("0x1234567890123456789012345678901234567890#bi", "BigInteger");
  }
  
  @Test
  public void testNumberLiteral_18() throws Exception {
    this.resolvesTo("1.0bD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_19() throws Exception {
    this.resolvesTo("1.0E10Bd", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_20() throws Exception {
    this.resolvesTo("1.0e-10bd", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_21() throws Exception {
    this.resolvesTo("1.0E+10BD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_22() throws Exception {
    this.resolvesTo("1E+10BD", "BigDecimal");
  }
  
  @Test
  public void testNumberLiteral_23() throws Exception {
    this.resolvesTo("1E-10", "double");
  }
  
  @Test
  public void testNumberLiteral_24() throws Exception {
    this.resolvesTo("1E10f", "float");
  }
  
  @Test
  public void testCastExpression() throws Exception {
    this.resolvesTo("null as String", "String");
    this.resolvesTo("null as Boolean", "Boolean");
  }
  
  @Test
  public void testThrowExpression() throws Exception {
    this.resolvesTo("throw new java.lang.Exception()", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_0() throws Exception {
    this.resolvesTo("try \'foo\' catch (java.lang.Exception e) \'bar\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_1() throws Exception {
    this.resolvesTo("try \'foo\' catch (java.lang.Exception e) \'bar\' catch(java.lang.RuntimeException e) \'baz\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_2() throws Exception {
    this.resolvesTo("try \'foo\' catch (java.lang.Exception e) \'bar\' catch(java.lang.RuntimeException e) \'baz\' finally true", "String");
  }
  
  @Test
  public void testForExpression_01() throws Exception {
    this.resolvesTo("for(java.lang.String x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(java.lang.String x : newArrayList(\'foo\')) x.length", "void");
    this.resolvesTo("for(java.lang.String x : <String>newArrayList()) x.length", "void");
  }
  
  @Test
  public void testForExpression_02() throws Exception {
    this.resolvesTo("for(x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(x : newArrayList(\'foo\')) x.length", "void");
    this.resolvesTo("for(x : <String>newArrayList()) x.length", "void");
  }
  
  @Test
  public void testNull() throws Exception {
    final ITypeResolution typeResolution = this.typeResolver.resolveTypes(null);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(ITypeResolution.NULL, typeResolution);
  }
  
  @Test
  public void testProxy() throws Exception {
    final XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
    URI _createURI = URI.createURI("path#fragment");
    ((InternalEObject) proxy).eSetProxyURI(_createURI);
    final ITypeResolution typeResolution = this.typeResolver.resolveTypes(proxy);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(ITypeResolution.NULL, typeResolution);
  }
  
  @Test
  public void testInstanceof() throws Exception {
    this.resolvesTo("null instanceof java.lang.String", "boolean");
  }
  
  @Test
  public void testReturnType() throws Exception {
    this.resolvesTo("return \'foo\'", "void");
  }
  
  @Test
  public void testTypeArgs() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>() += \'foo\'", "boolean");
  }
  
  @Test
  public void testIfExpression() throws Exception {
    this.resolvesTo("if (true) \'foo\' else null", "String");
    this.resolvesTo("if (true) \'foo\' else \'bar\'", "String");
    this.resolvesTo("if (true) \'foo\'", "String");
  }
  
  @Test
  public void testIfExpression_02() throws Exception {
    this.resolvesTo("if (true) new StringBuilder() else new StringBuffer()", "AbstractStringBuilder & Serializable");
  }
  
  @Test
  public void testIfExpression_03() throws Exception {
    this.resolvesTo("if (true) return \'foo\'", "null");
  }
  
  @Test
  public void testSwitchExpression() throws Exception {
    this.resolvesTo("switch true { case true : \'s\' case false : \'foo\' default: \'bar\'}", "String");
    this.resolvesTo("switch true { case true : \'s\' case false : new java.lang.Object() default: \'bar\'}", "Object");
  }
  
  @Test
  public void testSwitchExpression_1() throws Exception {
    this.resolvesTo("switch true { case true : return \'s\' default: null}", "null");
  }
  
  @Test
  public void testSwitchExpression_2() throws Exception {
    this.resolvesTo("switch null {\n\t\t  Object : return null \n\t\t}", "null");
  }
  
  @Test
  public void testTypeGuardedCase_0() throws Exception {
    this.resolvesTo("switch  s: new Object() { String: s StringBuffer: s}", "Serializable & CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_1() throws Exception {
    this.resolvesTo("switch s: \'\' as CharSequence { Cloneable: s String: s }", "CharSequence");
  }
  
  @Test
  public void testSwitchExpression_Bug343100() throws Exception {
    this.resolvesTo("switch \'a\' {\n\t\t  case null: typeof(java.lang.String) \n\t\t  case \'a\': typeof(java.lang.Void)\n\t\t}", "Class<?>");
  }
  
  @Test
  public void testBlockExpression() throws Exception {
    this.resolvesTo("{null}", "null");
    this.resolvesTo("{\'\'.toString 4}", "int");
    this.resolvesTo("{\'\'.toString true}", "boolean");
  }
  
  @Test
  public void testFeatureCall_01() throws Exception {
    this.resolvesTo("\'foo\'.length", "int");
  }
  
  @Test
  public void testFeatureCallOnIt() throws Exception {
    this.resolvesTo("{ val it = \'foo\'; length == 3;}", "boolean");
  }
}
