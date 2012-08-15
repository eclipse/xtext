package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTestingTypeComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExpectationTest extends AbstractXbaseTestCase {
  @Inject
  private PublicReentrantTypeResolver resolver;
  
  @Inject
  private ExpectationTestingTypeComputer typeComputer;
  
  private List<LightweightTypeExpectation> expectations;
  
  private boolean pendingAssert = false;
  
  public ExpectationTest expects(final String input) {
    try {
      final XExpression expression = this.expression(input, false);
      this.resolver.initializeFrom(expression);
      this.resolver.reentrantResolve();
      this.pendingAssert = true;
      return this;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ExpectationTest types(final String... names) {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    final Function1<LightweightTypeExpectation,String> _function = new Function1<LightweightTypeExpectation,String>() {
        public String apply(final LightweightTypeExpectation it) {
          LightweightTypeReference _expectedType = it.getExpectedType();
          String _simpleName = _expectedType==null?(String)null:_expectedType.getSimpleName();
          return _simpleName;
        }
      };
    List<String> _map = ListExtensions.<LightweightTypeExpectation, String>map(this.expectations, _function);
    String _string = _map.toString();
    int _size = ((List<String>)Conversions.doWrapArray(names)).size();
    int _size_1 = this.expectations.size();
    Assert.assertEquals(_string, _size, _size_1);
    Set<String> _set = IterableExtensions.<String>toSet(((Iterable<? extends String>)Conversions.doWrapArray(names)));
    final Function1<LightweightTypeExpectation,String> _function_1 = new Function1<LightweightTypeExpectation,String>() {
        public String apply(final LightweightTypeExpectation it) {
          LightweightTypeReference _expectedType = it.getExpectedType();
          String _simpleName = _expectedType==null?(String)null:_expectedType.getSimpleName();
          return _simpleName;
        }
      };
    List<String> _map_1 = ListExtensions.<LightweightTypeExpectation, String>map(this.expectations, _function_1);
    Set<String> _set_1 = IterableExtensions.<String>toSet(_map_1);
    Assert.assertEquals(((Object) _set), _set_1);
    return this;
  }
  
  public ExpectationTest nothing() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    int _size = this.expectations.size();
    Assert.assertEquals(1, _size);
    final LightweightTypeExpectation expectation = IterableExtensions.<LightweightTypeExpectation>head(this.expectations);
    boolean _isNoTypeExpectation = expectation.isNoTypeExpectation();
    Assert.assertTrue(_isNoTypeExpectation);
    boolean _isVoidTypeAllowed = expectation.isVoidTypeAllowed();
    Assert.assertTrue(_isVoidTypeAllowed);
    LightweightTypeReference _expectedType = expectation.getExpectedType();
    Assert.assertNull(_expectedType);
    return this;
  }
  
  public ExpectationTest notVoid() {
    Assert.assertTrue(this.pendingAssert);
    this.pendingAssert = false;
    int _size = this.expectations.size();
    Assert.assertEquals(1, _size);
    final LightweightTypeExpectation expectation = IterableExtensions.<LightweightTypeExpectation>head(this.expectations);
    boolean _isNoTypeExpectation = expectation.isNoTypeExpectation();
    Assert.assertFalse(_isNoTypeExpectation);
    boolean _isVoidTypeAllowed = expectation.isVoidTypeAllowed();
    Assert.assertFalse(_isVoidTypeAllowed);
    LightweightTypeReference _expectedType = expectation.getExpectedType();
    Assert.assertNull(_expectedType);
    return this;
  }
  
  public void setUp() throws Exception {
    super.setUp();
    this.typeComputer.setTest(this);
    this.pendingAssert = false;
    this.resolver.setTypeComputer(this.typeComputer);
    ArrayList<LightweightTypeExpectation> _newArrayList = CollectionLiterals.<LightweightTypeExpectation>newArrayList();
    this.expectations = _newArrayList;
  }
  
  @After
  public void tearDown() throws Exception {
    Assert.assertFalse(this.pendingAssert);
    this.pendingAssert = false;
    this.expectations = null;
    this.typeComputer.setTest(null);
    this.resolver.setTypeComputer(null);
  }
  
  public void recordExpectation(final LightweightTypeComputationState state) {
    List<? extends LightweightTypeExpectation> _immediateExpectations = state.getImmediateExpectations();
    Iterables.<LightweightTypeExpectation>addAll(this.expectations, _immediateExpectations);
  }
  
  @Test
  public void testIfCondition() {
    ExpectationTest _expects = this.expects("if (null) true");
    _expects.types("boolean");
  }
  
  @Test
  public void testNotLastExpressionInBlock() {
    ExpectationTest _expects = this.expects("{ null true }");
    _expects.nothing();
  }
  
  @Test
  public void testSwitchValue() {
    ExpectationTest _expects = this.expects("switch null case true: true");
    _expects.notVoid();
  }
  
  @Test
  public void testAssignment() {
    ExpectationTest _expects = this.expects("{ val String s = null }");
    _expects.types("String");
  }
  
  @Test
  public void testTransitiveAssignment() {
    ExpectationTest _expects = this.expects("{ val StringBuilder s = if (true) null }");
    _expects.types("StringBuilder");
  }
  
  @Test
  public void testFeatureCallArgument_01() {
    ExpectationTest _expects = this.expects("\'\'.substring(null)");
    _expects.types("int");
  }
  
  @Test
  public void testFeatureCallArgument_02() {
    ExpectationTest _expects = this.expects("newArrayList.<String>findFirst(null)");
    _expects.types("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_03() {
    ExpectationTest _expects = this.expects("newArrayList.findFirst(null)");
    _expects.types("Function1<? super Unbound[T], Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_04() {
    ExpectationTest _expects = this.expects("<String>newArrayList.findFirst(null)");
    _expects.types("Function1<? super String, Boolean>");
  }
  
  @Test
  public void testFeatureCallArgument_05() {
    ExpectationTest _expects = this.expects("newArrayList(\'\').findFirst(null)");
    _expects.types("Function1<? super String, Boolean>");
  }
  
  @Test
  @Ignore(value = "TODO null type is bound differently")
  public void testExtensionReceiver_01() {
    ExpectationTest _expects = this.expects("null.isNullOrEmpty()");
    _expects.types("String");
  }
  
  @Test
  @Ignore(value = "TODO Add synonyms to expectation, resolve")
  public void testFeatureCallVarArgument_01() {
    ExpectationTest _expects = this.expects("newArrayList(null)");
    _expects.types("unbound/T");
  }
  
  @Test
  public void testFeatureCallVarArgument_02() {
    ExpectationTest _expects = this.expects("newArrayList(null, \'\')");
    _expects.types("String");
  }
  
  @Test
  @Ignore(value = "TODO Propagate expectation")
  public void testFeatureCallVarArgument_03() {
    ExpectationTest _expects = this.expects("{ val Iterable<String> iterable = newArrayList(null) }");
    _expects.types("String[]", "String");
  }
  
  @Test
  @Ignore(value = "TODO Add synonyms to expectation")
  public void testForLoop_01() {
    ExpectationTest _expects = this.expects("for(int x: null) {}");
    _expects.types("int[]", "Iterable<Integer>");
  }
}
