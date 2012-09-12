package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIClosureTypeTest extends AbstractClosureTypeTest {
  @Inject
  private ITypeProvider typeProvider;
  
  public List<Object> resolvesClosuresTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XClosure> closures = this.findClosures(expressionWithQualifiedNames);
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure,Integer> _function = new Procedure2<XClosure,Integer>() {
        public void apply(final XClosure closure, final Integer index) {
          final JvmTypeReference closureType = OldAPIClosureTypeTest.this.typeProvider.getType(closure);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for closure at ");
          _builder.append(index, "");
          _builder.append(": ");
          _builder.append(closureType, "");
          Assert.assertTrue(_builder.toString(), (closureType instanceof XFunctionTypeRef));
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("failed for closure at ");
          _builder_1.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = closureType.getSimpleName();
          Assert.assertEquals(_builder_1.toString(), _get, _simpleName);
          result.add(closureType);
        }
      };
    IterableExtensions.<XClosure>forEach(closures, _function);
    return result;
  }
  
  public void withEquivalents(final List<Object> references, final String... types) {
    final Procedure2<Object,Integer> _function = new Procedure2<Object,Integer>() {
        public void apply(final Object reference, final Integer index) {
          Assert.assertTrue((reference instanceof XFunctionTypeRef));
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          JvmTypeReference _equivalent = ((XFunctionTypeRef) reference).getEquivalent();
          String _simpleName = _equivalent.getSimpleName();
          Assert.assertEquals(_get, _simpleName);
        }
      };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_03() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_04() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_12() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_13() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_14() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_16() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_17() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_19() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testOverloadedOperators_20() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_02() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_03() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_04() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_05() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_06() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_08() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_09() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_10() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_11() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_12() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_13() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_14() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_15() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_16() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_17() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_18() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_19() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_20() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_21() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_22() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_23() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_24() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testClosure_26() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testMemberFeatureCall_01() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testNumberLiteralInClosure() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testFeatureCall_16() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testFeatureCall_19() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testFeatureCall_65() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testIfExpression_05() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testIfExpression_07() throws Exception {
    Assert.fail("fails in old impl");
  }
  
  @Ignore(value = "fails in old impl")
  @Test
  public void testIfExpression_09() throws Exception {
    Assert.fail("fails in old impl");
  }
}
