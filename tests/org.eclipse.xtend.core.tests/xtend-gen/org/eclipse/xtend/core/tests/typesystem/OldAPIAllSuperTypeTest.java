package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AllSuperTypesTest;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIAllSuperTypeTest extends AllSuperTypesTest {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private SuperTypeCollector superTypeCollector;
  
  public void assertSuperTypes(final Pair<String,String> type, final String... superTypes) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = type.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = type.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = type.getKey();
      _builder.append(_key, "");
      _builder.append(" type) {}");
      final CharSequence signature = _builder;
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      final JvmTypeReference subtype = _head.getParameterType();
      final Set<JvmTypeReference> computedSuperTypes = this.superTypeCollector.collectSuperTypes(subtype);
      Set<String> _set = IterableExtensions.<String>toSet(((Iterable<? extends String>)Conversions.doWrapArray(superTypes)));
      final Function1<JvmTypeReference,String> _function = new Function1<JvmTypeReference,String>() {
          public String apply(final JvmTypeReference it) {
            String _simpleName = it.getSimpleName();
            return _simpleName;
          }
        };
      Iterable<String> _map = IterableExtensions.<JvmTypeReference, String>map(computedSuperTypes, _function);
      Set<String> _set_1 = IterableExtensions.<String>toSet(_map);
      Assert.assertEquals(_set, ((Object) _set_1));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void testRawCollection() {
    super.testRawCollection();
  }
  
  @Ignore
  @Test
  public void testStringCollection() {
    super.testStringCollection();
  }
  
  @Ignore
  @Test
  public void testRawList() {
    super.testRawList();
  }
  
  @Ignore
  @Test
  public void testStringList() {
    super.testStringList();
  }
  
  @Ignore
  @Test
  public void testStringArrayArrayList() {
    super.testStringArrayArrayList();
  }
}
