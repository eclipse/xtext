package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.typesystem.AbstractTypeArgumentCollectorTest;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.After;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class LightweightActualTypeArgumentCollectorTest extends AbstractTypeArgumentCollectorTest implements TypeReferenceOwner {
  @Inject
  private CommonTypeComputationServices services;
  
  private ResourceSet contextResourceSet;
  
  private OwnedConverter _ownedConverter = new Function0<OwnedConverter>() {
    public OwnedConverter apply() {
      OwnedConverter _ownedConverter = new OwnedConverter(LightweightActualTypeArgumentCollectorTest.this);
      return _ownedConverter;
    }
  }.apply();
  
  public Multimap<JvmTypeParameter,? extends Object> mappedBy(final String typeParameters, final String... alternatingTypeReferences) {
    final JvmOperation operation = this.operation(typeParameters, alternatingTypeReferences);
    EList<JvmTypeParameter> _typeParameters = operation.getTypeParameters();
    ActualTypeArgumentCollector _actualTypeArgumentCollector = new ActualTypeArgumentCollector(_typeParameters, BoundTypeArgumentSource.INFERRED, this);
    final ActualTypeArgumentCollector collector = _actualTypeArgumentCollector;
    int _size = ((List<String>)Conversions.doWrapArray(alternatingTypeReferences)).size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    IntegerRange _withStep = _upTo.withStep(2);
    for (final Integer i : _withStep) {
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _get = _parameters.get((i).intValue());
      JvmTypeReference _parameterType = _get.getParameterType();
      LightweightTypeReference _lightweightReference = this._ownedConverter.toLightweightReference(_parameterType);
      EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
      int _plus = ((i).intValue() + 1);
      JvmFormalParameter _get_1 = _parameters_1.get(_plus);
      JvmTypeReference _parameterType_1 = _get_1.getParameterType();
      LightweightTypeReference _lightweightReference_1 = this._ownedConverter.toLightweightReference(_parameterType_1);
      collector.populateTypeParameterMapping(_lightweightReference, _lightweightReference_1);
    }
    return collector.getTypeParameterMapping();
  }
  
  protected XtendFunction function(final String string) throws Exception {
    final XtendFunction result = super.function(string);
    Resource _eResource = result.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    this.contextResourceSet = _resourceSet;
    return result;
  }
  
  @After
  public void tearDown() {
    this.contextResourceSet = null;
  }
  
  public ResourceSet getContextResourceSet() {
    return this.contextResourceSet;
  }
  
  public Multimap<JvmTypeParameter,? extends Object> assertMapping(final Multimap<JvmTypeParameter,? extends Object> mapping, final String typeParamName, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        Assert.assertNotNull(mappedTypes);
        Collection<? extends Object> _get = mapping.get(key);
        final Collection<LightweightBoundTypeArgument> mappingData = ((Collection<LightweightBoundTypeArgument>) _get);
        final Function1<LightweightBoundTypeArgument,CharSequence> _function = new Function1<LightweightBoundTypeArgument,CharSequence>() {
            public CharSequence apply(final LightweightBoundTypeArgument it) {
              StringConcatenation _builder = new StringConcatenation();
              LightweightTypeReference _typeReference = it.getTypeReference();
              _builder.append(_typeReference, "");
              _builder.append("(");
              VarianceInfo _declaredVariance = it.getDeclaredVariance();
              _builder.append(_declaredVariance, "");
              _builder.append("/");
              VarianceInfo _actualVariance = it.getActualVariance();
              _builder.append(_actualVariance, "");
              _builder.append(")");
              return _builder;
            }
          };
        Iterable<CharSequence> _map = IterableExtensions.<LightweightBoundTypeArgument, CharSequence>map(mappingData, _function);
        String _string = _map.toString();
        int _size = ((List<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)).size();
        int _size_1 = mappingData.size();
        Assert.assertEquals(_string, _size, _size_1);
        List<Triple<String,VarianceInfo,VarianceInfo>> _list = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(((Iterable<? extends Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)));
        final Function1<LightweightBoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>> _function_1 = new Function1<LightweightBoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>>() {
            public Triple<String,VarianceInfo,VarianceInfo> apply(final LightweightBoundTypeArgument it) {
              LightweightTypeReference _typeReference = it.getTypeReference();
              String _string = _typeReference.toString();
              VarianceInfo _declaredVariance = it.getDeclaredVariance();
              VarianceInfo _actualVariance = it.getActualVariance();
              Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_string, _declaredVariance, _actualVariance);
              return _create;
            }
          };
        Iterable<Triple<String,VarianceInfo,VarianceInfo>> _map_1 = IterableExtensions.<LightweightBoundTypeArgument, Triple<String,VarianceInfo,VarianceInfo>>map(mappingData, _function_1);
        List<Triple<String,VarianceInfo,VarianceInfo>> _list_1 = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(_map_1);
        Assert.assertEquals(((Object) _list), _list_1);
        return mapping;
      }
    }
    boolean _notEquals = (!Objects.equal(mappedTypes, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No mapping for ");
      _builder.append(typeParamName, "");
      _builder.append(" in ");
      Set<JvmTypeParameter> _keySet = mapping.keySet();
      final Function1<JvmTypeParameter,String> _function_2 = new Function1<JvmTypeParameter,String>() {
          public String apply(final JvmTypeParameter it) {
            String _simpleName = it.getSimpleName();
            return _simpleName;
          }
        };
      Iterable<String> _map_2 = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function_2);
      _builder.append(_map_2, "");
      String _string_1 = _builder.toString();
      Assert.fail(_string_1);
    }
    return mapping;
  }
  
  public Multimap<JvmTypeParameter,? extends Object> assertOrigins(final Multimap<JvmTypeParameter,? extends Object> mapping, final String typeParamName, final int count) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        Collection<? extends Object> _get = mapping.get(key);
        final Collection<LightweightBoundTypeArgument> mappingData = ((Collection<LightweightBoundTypeArgument>) _get);
        final Function1<LightweightBoundTypeArgument,Object> _function = new Function1<LightweightBoundTypeArgument,Object>() {
            public Object apply(final LightweightBoundTypeArgument it) {
              Object _origin = it.getOrigin();
              return _origin;
            }
          };
        Iterable<Object> _map = IterableExtensions.<LightweightBoundTypeArgument, Object>map(mappingData, _function);
        Set _set = IterableExtensions.<Object>toSet(_map);
        int _size = _set.size();
        Assert.assertEquals(count, _size);
        return mapping;
      }
    }
    return mapping;
  }
  
  public CommonTypeComputationServices getServices() {
    return this.services;
  }
  
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Should not be invoked");
    throw _unsupportedOperationException;
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Should not be invoked");
    throw _unsupportedOperationException;
  }
}
