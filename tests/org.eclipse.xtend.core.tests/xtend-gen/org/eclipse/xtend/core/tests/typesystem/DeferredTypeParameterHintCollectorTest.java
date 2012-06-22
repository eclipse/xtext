package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.typesystem.AbstractDeferredTypeParameterHintCollectorTest;
import org.eclipse.xtend.core.tests.typesystem.MockTypeParameterSubstitutor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.junit.After;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class DeferredTypeParameterHintCollectorTest extends AbstractDeferredTypeParameterHintCollectorTest implements TypeReferenceOwner {
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  private DefaultReentrantTypeResolver resolver;
  
  private ResourceSet contextResourceSet;
  
  private OwnedConverter _ownedConverter = new Function0<OwnedConverter>() {
    public OwnedConverter apply() {
      OwnedConverter _ownedConverter = new OwnedConverter(DeferredTypeParameterHintCollectorTest.this);
      return _ownedConverter;
    }
  }.apply();
  
  private ListMultimap<Object,LightweightBoundTypeArgument> hints = new Function0<ListMultimap<Object,LightweightBoundTypeArgument>>() {
    public ListMultimap<Object,LightweightBoundTypeArgument> apply() {
      ListMultimap<Object,LightweightBoundTypeArgument> _newLinkedHashListMultimap = Multimaps2.<Object, LightweightBoundTypeArgument>newLinkedHashListMultimap();
      return _newLinkedHashListMultimap;
    }
  }.apply();
  
  public Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> in(final String typeParameters, final String expectedType, final String actualType) {
    final JvmOperation operation = this.operation(typeParameters, expectedType, actualType);
    DeferredTypeParameterHintCollector _deferredTypeParameterHintCollector = new DeferredTypeParameterHintCollector(this);
    final DeferredTypeParameterHintCollector collector = _deferredTypeParameterHintCollector;
    PublicResolvedTypes _publicResolvedTypes = new PublicResolvedTypes(this.resolver);
    MockTypeParameterSubstitutor _mockTypeParameterSubstitutor = new MockTypeParameterSubstitutor(this, _publicResolvedTypes);
    final MockTypeParameterSubstitutor substitutor = _mockTypeParameterSubstitutor;
    EList<JvmFormalParameter> _parameters = operation.getParameters();
    JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
    JvmTypeReference _parameterType = _head.getParameterType();
    LightweightTypeReference _lightweightReference = this._ownedConverter.toLightweightReference(_parameterType);
    final LightweightTypeReference hasUnbounds = substitutor.substitute(_lightweightReference);
    EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
    JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
    JvmTypeReference _parameterType_1 = _last.getParameterType();
    final LightweightTypeReference isActual = this._ownedConverter.toLightweightReference(_parameterType_1);
    collector.processPairedReferences(hasUnbounds, isActual);
    return substitutor.getTypeParameterMapping();
  }
  
  public List<LightweightBoundTypeArgument> hasHintsFor(final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        LightweightMergedBoundTypeArgument _get = mapping.get(key);
        LightweightTypeReference _typeReference = ((LightweightMergedBoundTypeArgument) _get).getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        List<LightweightBoundTypeArgument> _allHints = unbound.getAllHints();
        final Procedure1<LightweightBoundTypeArgument> _function = new Procedure1<LightweightBoundTypeArgument>() {
            public void apply(final LightweightBoundTypeArgument it) {
              BoundTypeArgumentSource _source = it.getSource();
              Assert.assertEquals(BoundTypeArgumentSource.INFERRED_LATER, _source);
            }
          };
        IterableExtensions.<LightweightBoundTypeArgument>forEach(_allHints, _function);
        return unbound.getAllHints();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No mapping for ");
    _builder.append(typeParamName, "");
    _builder.append(" in ");
    Set<JvmTypeParameter> _keySet = mapping.keySet();
    final Function1<JvmTypeParameter,String> _function_1 = new Function1<JvmTypeParameter,String>() {
        public String apply(final JvmTypeParameter it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function_1);
    _builder.append(_map, "");
    String _string = _builder.toString();
    Assert.fail(_string);
    return null;
  }
  
  public void hasNoHintsFor(final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping, final String typeParamName) {
    final Set<JvmTypeParameter> allKeys = mapping.keySet();
    for (final JvmTypeParameter key : allKeys) {
      String _simpleName = key.getSimpleName();
      boolean _equals = Objects.equal(_simpleName, typeParamName);
      if (_equals) {
        LightweightMergedBoundTypeArgument _get = mapping.get(key);
        LightweightTypeReference _typeReference = ((LightweightMergedBoundTypeArgument) _get).getTypeReference();
        final UnboundTypeReference unbound = ((UnboundTypeReference) _typeReference);
        List<LightweightBoundTypeArgument> _allHints = unbound.getAllHints();
        boolean _isEmpty = _allHints.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Unexpected mapping for ");
          _builder.append(typeParamName, "");
          _builder.append(" in ");
          Set<JvmTypeParameter> _keySet = mapping.keySet();
          final Function1<JvmTypeParameter,String> _function = new Function1<JvmTypeParameter,String>() {
              public String apply(final JvmTypeParameter it) {
                String _simpleName = it.getSimpleName();
                return _simpleName;
              }
            };
          Iterable<String> _map = IterableExtensions.<JvmTypeParameter, String>map(_keySet, _function);
          _builder.append(_map, "");
          String _string = _builder.toString();
          Assert.fail(_string);
        }
      }
    }
  }
  
  public List<LightweightBoundTypeArgument> like(final List<LightweightBoundTypeArgument> mappingData, final Triple<String,VarianceInfo,VarianceInfo>... mappedTypes) {
    final Function1<LightweightBoundTypeArgument,CharSequence> _function = new Function1<LightweightBoundTypeArgument,CharSequence>() {
        public CharSequence apply(final LightweightBoundTypeArgument o) {
          CharSequence _xblockexpression = null;
          {
            final LightweightBoundTypeArgument it = ((LightweightBoundTypeArgument) o);
            StringConcatenation _builder = new StringConcatenation();
            LightweightTypeReference _typeReference = it.getTypeReference();
            String _string = _typeReference.toString();
            _builder.append(_string, "");
            _builder.append("(");
            VarianceInfo _declaredVariance = it.getDeclaredVariance();
            _builder.append(_declaredVariance, "");
            _builder.append("/");
            VarianceInfo _actualVariance = it.getActualVariance();
            _builder.append(_actualVariance, "");
            _builder.append(")");
            _xblockexpression = (_builder);
          }
          return _xblockexpression;
        }
      };
    List<CharSequence> _map = ListExtensions.<LightweightBoundTypeArgument, CharSequence>map(mappingData, _function);
    String _string = _map.toString();
    int _size = ((List<Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)).size();
    int _size_1 = mappingData.size();
    Assert.assertEquals(_string, _size, _size_1);
    List<Triple<String,VarianceInfo,VarianceInfo>> _list = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(((Iterable<? extends Triple<String,VarianceInfo,VarianceInfo>>)Conversions.doWrapArray(mappedTypes)));
    final Function1<LightweightBoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>> _function_1 = new Function1<LightweightBoundTypeArgument,Triple<String,VarianceInfo,VarianceInfo>>() {
        public Triple<String,VarianceInfo,VarianceInfo> apply(final LightweightBoundTypeArgument o) {
          Triple<String,VarianceInfo,VarianceInfo> _xblockexpression = null;
          {
            final LightweightBoundTypeArgument it = ((LightweightBoundTypeArgument) o);
            LightweightTypeReference _typeReference = it.getTypeReference();
            String _string = _typeReference.toString();
            VarianceInfo _declaredVariance = it.getDeclaredVariance();
            VarianceInfo _actualVariance = it.getActualVariance();
            Triple<String,VarianceInfo,VarianceInfo> _create = Tuples.<String, VarianceInfo, VarianceInfo>create(_string, _declaredVariance, _actualVariance);
            _xblockexpression = (_create);
          }
          return _xblockexpression;
        }
      };
    List<Triple<String,VarianceInfo,VarianceInfo>> _map_1 = ListExtensions.<LightweightBoundTypeArgument, Triple<String,VarianceInfo,VarianceInfo>>map(mappingData, _function_1);
    List<Triple<String,VarianceInfo,VarianceInfo>> _list_1 = IterableExtensions.<Triple<String,VarianceInfo,VarianceInfo>>toList(_map_1);
    Assert.assertEquals(((Object) _list), _list_1);
    return mappingData;
  }
  
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    this.hints.put(handle, boundTypeArgument);
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    List<LightweightBoundTypeArgument> _get = this.hints.get(handle);
    return _get;
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
  
  public CommonTypeComputationServices getServices() {
    return this.services;
  }
}
