package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.junit.Assert;
import org.junit.Ignore;
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
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(xExpression);
    final JvmTypeReference resolvedType = resolvedTypes.getActualType(xExpression);
    String _simpleName = resolvedType.getSimpleName();
    Assert.assertEquals(type, _simpleName);
    TreeIterator<EObject> _eAllContents = xExpression.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    for (final EObject content : _iterable) {
      if ((content instanceof XExpression)) {
        resolvedTypes.getActualType(((XExpression) content));
      }
    }
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
  public void testTypeLiteral() throws Exception {
    this.resolvesTo("typeof(String)", "Class<String>");
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
    this.resolvesTo("throw new Exception()", "void");
  }
  
  @Test
  public void testTryCatchFinallyExpression_0() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_1() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\'", "String");
  }
  
  @Test
  public void testTryCatchFinallyExpression_2() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) \'baz\' finally true", "String");
  }
  
  @Test
  public void testForExpression_01() throws Exception {
    this.resolvesTo("for(String x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(String x : newArrayList(\'foo\')) x.length", "void");
    this.resolvesTo("for(String x : <String>newArrayList()) x.length", "void");
  }
  
  @Test
  public void testForExpression_02() throws Exception {
    this.resolvesTo("for(x : new java.util.ArrayList<String>()) x.length", "void");
    this.resolvesTo("for(x : <String>newArrayList()) x.length", "void");
    this.resolvesTo("for(x : newArrayList(\'foo\')) x.length", "void");
  }
  
  @Test
  public void testForExpression_03() throws Exception {
    this.resolvesTo("for(String x : null as String[]) x.length", "void");
  }
  
  @Test
  public void testForExpression_04() throws Exception {
    this.resolvesTo("for(x : null as String[]) x.length", "void");
  }
  
  @Test
  public void testNull() throws Exception {
    final IResolvedTypes typeResolution = this.typeResolver.resolveTypes(null);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
  
  @Test
  public void testProxy() throws Exception {
    final XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
    URI _createURI = URI.createURI("path#fragment");
    ((InternalEObject) proxy).eSetProxyURI(_createURI);
    final IResolvedTypes typeResolution = this.typeResolver.resolveTypes(proxy);
    Assert.assertNotNull(typeResolution);
    Assert.assertEquals(IResolvedTypes.NULL, typeResolution);
  }
  
  @Test
  public void testImplicitImportPrintln() throws Exception {
    this.resolvesTo("<String>println(null)", "String");
    this.resolvesTo("println(null)", "Object");
  }
  
  @Test
  public void testImplicitImportEmptyList() throws Exception {
    this.resolvesTo("<String>emptyList", "List<String>");
    this.resolvesTo("emptyList", "List<Object>");
  }
  
  @Test
  public void testMethodTypeParamInference_00() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().findFirst(e | true)", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_01() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testMethodTypeParamInference_02() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>().<String>findFirst(e|e == \'foo\')", "String");
  }
  
  @Test
  public void testInstanceof() throws Exception {
    this.resolvesTo("null instanceof String", "boolean");
  }
  
  @Ignore
  @Test
  public void testFeatureCallWithArrayToIterableConversion() throws Exception {
    this.resolvesTo("\'foo\'.toCharArray.iterator", "Iterator<Character>");
  }
  
  @Test
  public void testReturnType() throws Exception {
    this.resolvesTo("return \'foo\'", "void");
  }
  
  @Test
  public void testClosure_00() throws Exception {
    this.resolvesTo("[|\'literal\'].apply()", "String");
  }
  
  @Test
  public void testClosure_01() throws Exception {
    this.resolvesTo("{ var closure = [|\'literal\']\n\t\t  new testdata.ClosureClient().invoke0(closure)\t}", "String");
  }
  
  @Test
  public void testClosure_02() throws Exception {
    this.resolvesTo("[String x| true]", "(String)=>boolean");
  }
  
  @Test
  public void testClosure_05() throws Exception {
    this.resolvesTo("[x| true]", "(Object)=>boolean");
  }
  
  @Test
  public void testClosure_06() throws Exception {
    this.resolvesTo("[x| null]", "(Object)=>Object");
  }
  
  @Ignore
  @Test
  public void testClosure_07() throws Exception {
    this.resolvesTo("[String x, String y| x + y ]", "(String, String)=>String");
  }
  
  @Test
  public void testClosure_08() throws Exception {
    this.resolvesTo("[x| x]", "(Object)=>Object");
  }
  
  @Test
  public void testClosure_09() throws Exception {
    this.resolvesTo("[String x, String y| x.substring(y.length)]", "(String, String)=>String");
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
    this.resolvesTo("switch true { case true : \'s\' case false : new Object() default: \'bar\'}", "Object");
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
    this.resolvesTo("switch s: new Object() { String: s StringBuffer: s}", "Serializable & CharSequence");
  }
  
  @Test
  public void testTypeGuardedCase_1() throws Exception {
    this.resolvesTo("switch s: \'\' as CharSequence { Cloneable: s String: s }", "CharSequence");
  }
  
  @Test
  public void testSwitchExpression_Bug343100() throws Exception {
    this.resolvesTo("switch \'a\' {\n\t\t  case null: typeof(String) \n\t\t  case \'a\': typeof(Void)\n\t\t}", "Class<?>");
  }
  
  @Test
  public void testBlockExpression_01() throws Exception {
    this.resolvesTo("{null}", "null");
    this.resolvesTo("{\'\'.toString 4}", "int");
    this.resolvesTo("{\'\'.toString true}", "boolean");
  }
  
  @Test
  public void testBlockExpression_02() throws Exception {
    this.resolvesTo("{val s = \'\' s}", "String");
  }
  
  @Test
  public void testBlockExpression_03() throws Exception {
    String input = "{ val s1 = \'\'\n";
    final int max = 1000;
    IntegerRange _upTo = new IntegerRange(1, max);
    for (final Integer i : _upTo) {
      String _plus = (input + " val s");
      int _plus_1 = ((i).intValue() + 1);
      String _plus_2 = (_plus + Integer.valueOf(_plus_1));
      String _plus_3 = (_plus_2 + " = s");
      String _plus_4 = (_plus_3 + i);
      String _plus_5 = (_plus_4 + "\n");
      input = _plus_5;
    }
    String _plus_6 = (input + " s");
    int _plus_7 = (max + 1);
    String _plus_8 = (_plus_6 + Integer.valueOf(_plus_7));
    String _plus_9 = (_plus_8 + "}");
    input = _plus_9;
    this.resolvesTo(input, "String");
  }
  
  @Test
  public void testConstructorCall() throws Exception {
    this.resolvesTo("new java.util.ArrayList<String>()", "ArrayList<String>");
    this.resolvesTo("new java.util.HashMap<String,Boolean>", "HashMap<String, Boolean>");
    this.resolvesTo("new java.util.ArrayList()", "ArrayList<Object>");
  }
  
  @Test
  public void testConstructorTypeInference_01() throws Exception {
    this.resolvesTo("new testdata.GenericType1(\'\')", "GenericType1<String>");
  }
  
  @Test
  public void testConstructorTypeInference_02() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().add(new java.util.ArrayList())", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_03() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().add(0, new java.util.ArrayList())", "void");
  }
  
  @Test
  public void testConstructorTypeInference_04() throws Exception {
    this.resolvesTo("newArrayList.add(new java.util.ArrayList())", "boolean");
  }
  
  @Test
  public void testConstructorTypeInference_05() throws Exception {
    this.resolvesTo("new testdata.GenericType2", "GenericType2<Number>");
  }
  
  @Test
  public void testConstructorTypeInference_06() throws Exception {
    this.resolvesTo("new testdata.GenericType2(0)", "GenericType2<Integer>");
  }
  
  @Test
  public void testConstructorTypeInference_07() throws Exception {
    this.resolvesTo("new testdata.GenericType2(0, 1)", "GenericType2<Integer>");
  }
  
  @Test
  public void testConstructorTypeInference_08() throws Exception {
    this.resolvesTo("new testdata.GenericType2(new Integer(0), new Integer(0).doubleValue)", "GenericType2<Number & Comparable<?>>");
  }
  
  @Test
  public void testClassNewInstance() throws Exception {
    this.resolvesTo("typeof(String).newInstance", "String");
  }
  
  @Test
  public void testFeatureCall_01() throws Exception {
    this.resolvesTo("\'foo\'.length", "int");
  }
  
  @Test
  public void testFeatureCall_02() throws Exception {
    this.resolvesTo("\'foo\'.getBytes()", "byte[]");
    this.resolvesTo("new java.util.ArrayList<String>().get(23)", "String");
  }
  
  @Test
  public void testFeatureCall_03() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList()", "List<Object>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\')", "List<String>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\', \'\')", "List<String>");
  }
  
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    this.resolvesTo("newArrayList(\'\').get(0)", "String");
    this.resolvesTo("<String>newArrayList().get(0)", "String");
  }
  
  @Test
  public void testFeatureCall_04() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toList(\'\', 1)", "List<Comparable<?> & Serializable>");
  }
  
  @Test
  public void testFeatureCall_05() throws Exception {
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList()", "List<Number>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0)", "List<Integer>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(0, 1)", "List<Integer>");
    this.resolvesTo("new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)", "List<Number & Comparable<?>>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_06() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s)", "List<String>");
  }
  
  @Test
  public void testFeatureCall_06_01() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s).head", "String");
  }
  
  @Test
  public void testFeatureCall_06_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.toString).head", "String");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_06_03() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_06_04() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).head", "Integer");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_07() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_07_01() throws Exception {
    this.resolvesTo("<String>newArrayList.map(s|s.length)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_07_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_07_03() throws Exception {
    this.resolvesTo("<String>newArrayList.map(s|s.length).head", "Integer");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_08() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s != null)", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_09() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length+1)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_10() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).map(i|i+1)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_11() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList()", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_12() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList().map(i|i)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_13() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).toList().map(i|i+1)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_13_2() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_13_3() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() map(i|i+1) }", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_13_4() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() it.map(i|i+1) }", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_13_5() throws Exception {
    this.resolvesTo("{ var it = newArrayList(\'\').map(s|1).toList() it }", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_14() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1))", "ArrayList<List<Integer>>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_a() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_b() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_c() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_d() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_e() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_f() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_g() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_h() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_i() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)).map(e|e).map(iterable|iterable.size())", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_i_2() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e)).map(iterable|iterable.size()).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_j() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_k() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_15_l() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)", "List<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_m() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(String s|1).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t).map(iterable|iterable.size()).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e)\n\t\t.map(Integer e|e).map(Integer e|e).map(Integer e|e).map(Integer e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_n() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\').map(s|1).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t).map(iterable|iterable.size()).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).map(e|e).map(e|e)\n\t\t.map(e|e).map(e|e).map(e|e).map(e|e).head", "Integer");
  }
  
  @Test
  public void testFeatureCall_15_o() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size())", "Iterable<Integer>");
  }
  
  @Test
  public void testFeatureCall_15_p() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).map(iterable|iterable.size()).map(e|e)", "Iterable<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_16() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|1).map(i|1)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_17() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length).map(i|i)", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_18() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b|b)", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_19() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { \'length\'.length b })", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_20() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(Boolean b|!b)", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_21() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| ! b )", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_22() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { !b } )", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_23() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 == 5).map(b| { b.operator_not } )", "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_24() throws Exception {
    String _plus = ("newArrayList(\'\').map(s|" + 
      "org::eclipse::xtext::xbase::lib::ObjectExtensions::operator_equals(");
    String _plus_1 = (_plus + 
      "\torg::eclipse::xtext::xbase::lib::IntegerExtensions::operator_plus(s.length,1), 5)");
    String _plus_2 = (_plus_1 + 
      ").map(b| org::eclipse::xtext::xbase::lib::BooleanExtensions::operator_not(b) )");
    this.resolvesTo(_plus_2, "List<Boolean>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_25() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(s|s.length + 1 * 5).map(b| b / 5 )", "List<Integer>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_Bug342134_01() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e)).flatten", "List<String>");
  }
  
  @Ignore
  @Test
  public void testFeatureCall_Bug342134_02() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|newArrayList(e))", "List<ArrayList<String>>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_03() throws Exception {
    this.resolvesTo("<String>newArrayList.map(e|newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_04() throws Exception {
    this.resolvesTo("newArrayList(\'\').map(e|<String>newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_05() throws Exception {
    this.resolvesTo("newArrayList.map(String e|<String>newArrayList(e)).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_06() throws Exception {
    this.resolvesTo("newArrayList(newArrayList(\'\')).flatten", "Iterable<String>");
  }
  
  @Test
  public void testFeatureCall_Bug342134_07() throws Exception {
    this.resolvesTo("<java.util.List<String>>newArrayList().flatten", "Iterable<String>");
  }
  
  @Test
  public void testReceiverIsPartiallyResolved_01() throws Exception {
    this.resolvesTo("newArrayList.get(0)", "Object");
  }
  
  @Test
  public void testReceiverIsPartiallyResolved_02() throws Exception {
    this.resolvesTo("newArrayList.toString", "String");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_01() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.flatten.head", "Object");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_02() throws Exception {
    this.resolvesTo("newArrayList.subList(1,1).subList(1,1).head", "Object");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_03() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.<Number>flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_04() throws Exception {
    this.resolvesTo("newArrayList.<java.util.Set<Number>>flatten.toList.flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_05() throws Exception {
    this.resolvesTo("newArrayList.flatten.<java.util.Set<Number>>toList.flatten.head", "Number");
  }
  
  @Test
  public void testTypeByTransitiveExpectation_06() throws Exception {
    this.resolvesTo("newArrayList.flatten.toList.flatten.<Number>head", "Number");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_01() throws Exception {
    this.resolvesTo("newArrayList", "ArrayList<Object>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_02() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = list.get(0)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_03() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval String s = list.head\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_04() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_05() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(newArrayList(\'\'))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_06() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.addAll(secondList)\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_07() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval secondList = newArrayList\n\t\t\tlist.addAll(secondList)\n\t\t\tlist.add(\'\')\n\t\t\tsecondList\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_08() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval Iterable<String> sublist = list.subList(1, 1)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Ignore(value = "TODO: figure out why the common super type is something like Number & Comparable<? extends Number & Comparable<?>>")
  @Test
  public void testDeferredTypeArgumentResolution_09() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Number & Comparable<?>>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_10() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(new Integer(0))\n\t\t\tlist.get(0).toString\n\t\t\tlist.add(new Integer(0).doubleValue)\n\t\t\tlist\n\t\t}", "ArrayList<Integer>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_11() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_12() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_13() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_14() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tlist.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_15() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_16() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_17() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_18() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_19() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_20() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_21() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_22() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tlist.add(second.head)\n\t\t\tsecond.add(\'\')\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_23() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_24() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.get(0))\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_25() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_26() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList\n\t\t\tsecond.add(\'\')\n\t\t\tlist.add(second.head)\n\t\t\tsecond\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_27() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_28() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval Iterable<String> s = list.flatten\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_29() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList(newArrayList)\n\t\t\tval String s = list.flatten.head\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testDeferredTypeArgumentResolution_30() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tval second = newArrayList(newArrayList)\n\t\t\tval String s = second.flatten.head\n\t\t\tlist.add(second.head)\n\t\t\tlist.head\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_01() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_02() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist\n\t\t}", "ArrayList<Object>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_03() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.addAll(list)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Test
  public void testRecursiveTypeArgumentResolution_04() throws Exception {
    this.resolvesTo("{\n\t\t\tval list = newArrayList\n\t\t\tlist.add(list.head)\n\t\t\tlist.add(\'\')\n\t\t\tlist\n\t\t}", "ArrayList<String>");
  }
  
  @Ignore
  @Test
  public void testFeatureCallWithOperatorOverloading_2() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes().iterator.next", "boolean");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_3() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += null", "boolean");
  }
  
  @Ignore
  @Test
  public void testFeatureCallWithOperatorOverloading_4() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += newArrayList(\'x\'.getBytes().iterator.next)", "boolean");
  }
  
  @Test
  public void testFeatureCallWithOperatorOverloading_5() throws Exception {
    this.resolvesTo("new java.util.ArrayList<Byte>() += \'x\'.getBytes()", "boolean");
  }
  
  @Test
  public void testFeatureCallOnIt() throws Exception {
    this.resolvesTo("{ val it = \'foo\'; length == 3;}", "boolean");
  }
  
  @Test
  public void testStaticMethods_01() throws Exception {
    this.resolvesTo("newArrayList(\'\')", "ArrayList<String>");
  }
  
  @Test
  public void testStaticMethods_02() throws Exception {
    this.resolvesTo("newArrayList(\'\', \'\')", "ArrayList<String>");
  }
  
  @Test
  public void testStaticMethods_03() throws Exception {
    this.resolvesTo("newArrayList(newHashSet(\'\'))", "ArrayList<HashSet<String>>");
  }
  
  @Test
  public void testStaticMethods_04() throws Exception {
    this.resolvesTo("newArrayList()", "ArrayList<Object>");
  }
  
  @Test
  public void testStaticMethods_05() throws Exception {
    this.resolvesTo("newHashMap()", "HashMap<Object, Object>");
  }
  
  @Test
  public void testStaticMethods_06() throws Exception {
    this.resolvesTo("String::CASE_INSENSITIVE_ORDER", "Comparator<String>");
  }
}
