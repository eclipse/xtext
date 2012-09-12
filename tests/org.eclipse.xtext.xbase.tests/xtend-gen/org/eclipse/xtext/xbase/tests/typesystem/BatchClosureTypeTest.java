package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchClosureTypeTest extends AbstractClosureTypeTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public List<Object> resolvesClosuresTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XClosure> closures = this.findClosures(expressionWithQualifiedNames);
    boolean _isEmpty = closures.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = closures.size();
    Assert.assertEquals(_size, _size_1);
    XClosure _head = IterableExtensions.<XClosure>head(closures);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure,Integer> _function = new Procedure2<XClosure,Integer>() {
        public void apply(final XClosure closure, final Integer index) {
          final LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for closure at ");
          _builder.append(index, "");
          _builder.append(": ");
          _builder.append(closureType, "");
          Assert.assertTrue(_builder.toString(), (closureType instanceof FunctionTypeReference));
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
          Assert.assertTrue((reference instanceof FunctionTypeReference));
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _equivalent = BatchClosureTypeTest.this.getEquivalent(((FunctionTypeReference) reference));
          Assert.assertEquals(_get, _equivalent);
        }
      };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    List<LightweightTypeReference> _typeArguments = type.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    if (_isEmpty) {
      JvmType _type = type.getType();
      return _type.getSimpleName();
    }
    StringConcatenation _builder = new StringConcatenation();
    JvmType _type_1 = type.getType();
    String _simpleName = _type_1.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("<");
    List<LightweightTypeReference> _typeArguments_1 = type.getTypeArguments();
    final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
        public String apply(final LightweightTypeReference it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    String _join = IterableExtensions.<LightweightTypeReference>join(_typeArguments_1, ", ", _function);
    _builder.append(_join, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testClosure_02() throws Exception {
    Assert.fail("temporarily disabled");
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testClosure_03() throws Exception {
    Assert.fail("temporarily disabled");
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testClosure_23() throws Exception {
    Assert.fail("temporarily disabled");
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testClosure_24() throws Exception {
    Assert.fail("temporarily disabled");
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testFeatureCall_23() throws Exception {
    Assert.fail("temporarily disabled");
  }
  
  @Test
  @Ignore(value = "Temporarily")
  public void testFeatureCall_24() throws Exception {
    Assert.fail("temporarily disabled");
  }
}
