package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.typesystem.MockResolvedTypes;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.typesystem.internal.RootUnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XtypeFactory;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class MockTypeParameterSubstitutor extends TypeParameterSubstitutor {
  private final MockResolvedTypes resolvedTypes;
  
  public MockTypeParameterSubstitutor(final CommonTypeComputationServices services, final MockResolvedTypes resolvedTypes) {
    super(new Function0<Map<JvmTypeParameter,MergedBoundTypeArgument>>() {
      public Map<JvmTypeParameter,MergedBoundTypeArgument> apply() {
        Map<JvmTypeParameter,MergedBoundTypeArgument> _emptyMap = CollectionLiterals.<JvmTypeParameter, MergedBoundTypeArgument>emptyMap();
        return _emptyMap;
      }
    }.apply(), services);
    this.resolvedTypes = resolvedTypes;
  }
  
  public Map<JvmTypeParameter,MergedBoundTypeArgument> getTypeParameterMapping() {
    Map<JvmTypeParameter,MergedBoundTypeArgument> _typeParameterMapping = super.getTypeParameterMapping();
    return _typeParameterMapping;
  }
  
  public JvmTypeReference doVisitParameterizedTypeReference(final JvmParameterizedTypeReference reference, final Set<JvmTypeParameter> visiting) {
    final JvmType type = reference.getType();
    if ((type instanceof JvmTypeParameter)) {
      boolean _add = visiting.add(((JvmTypeParameter) type));
      boolean _not = (!_add);
      if (_not) {
        return null;
      }
      try {
        Map<JvmTypeParameter,MergedBoundTypeArgument> _typeParameterMapping = this.getTypeParameterMapping();
        final MergedBoundTypeArgument mappedReference = _typeParameterMapping.get(type);
        boolean _notEquals = (!Objects.equal(mappedReference, null));
        if (_notEquals) {
          JvmTypeReference _typeReference = mappedReference.getTypeReference();
          return this.visit(_typeReference, visiting);
        } else {
          CommonTypeComputationServices _services = this.getServices();
          XtypeFactory _xtypeFactory = _services.getXtypeFactory();
          final XComputedTypeReference result = _xtypeFactory.createXComputedTypeReference();
          XFeatureCall _createXFeatureCall = XbaseFactory.eINSTANCE.createXFeatureCall();
          RootUnboundTypeParameter _createUnboundTypeParameter = this.resolvedTypes.createUnboundTypeParameter(_createXFeatureCall, ((JvmTypeParameter) type));
          result.setTypeProvider(_createUnboundTypeParameter);
          Map<JvmTypeParameter,MergedBoundTypeArgument> _typeParameterMapping_1 = this.getTypeParameterMapping();
          MergedBoundTypeArgument _mergedBoundTypeArgument = new MergedBoundTypeArgument(result, VarianceInfo.INVARIANT);
          _typeParameterMapping_1.put(((JvmTypeParameter) type), _mergedBoundTypeArgument);
          return result;
        }
      } finally {
        visiting.remove(type);
      }
    }
    CommonTypeComputationServices _services_1 = this.getServices();
    TypesFactory _typesFactory = _services_1.getTypesFactory();
    final JvmParameterizedTypeReference result_1 = _typesFactory.createJvmParameterizedTypeReference();
    result_1.setType(type);
    int i = 0;
    EList<JvmTypeReference> _arguments = reference.getArguments();
    int _size = _arguments.size();
    boolean _lessThan = (i < _size);
    boolean _while = _lessThan;
    while (_while) {
      {
        EList<JvmTypeReference> _arguments_1 = reference.getArguments();
        final JvmTypeReference argument = _arguments_1.get(i);
        JvmTypeReference copiedArgument = this.visit(argument, visiting);
        boolean _equals = Objects.equal(copiedArgument, null);
        if (_equals) {
          IllegalStateException _illegalStateException = new IllegalStateException("copied argument may not be null");
          throw _illegalStateException;
        }
        EList<JvmTypeReference> _arguments_2 = result_1.getArguments();
        _arguments_2.add(copiedArgument);
        int _plus = (i + 1);
        i = _plus;
      }
      EList<JvmTypeReference> _arguments_1 = reference.getArguments();
      int _size_1 = _arguments_1.size();
      boolean _lessThan_1 = (i < _size_1);
      _while = _lessThan_1;
    }
    return result_1;
  }
  
  public JvmTypeReference doVisitComputedTypeReference(final XComputedTypeReference reference, final Set<JvmTypeParameter> param) {
    IJvmTypeReferenceProvider _typeProvider = reference.getTypeProvider();
    if ((_typeProvider instanceof UnboundTypeParameter)) {
      CommonTypeComputationServices _services = this.getServices();
      XtypeFactory _xtypeFactory = _services.getXtypeFactory();
      final XComputedTypeReference result = _xtypeFactory.createXComputedTypeReference();
      IJvmTypeReferenceProvider _typeProvider_1 = reference.getTypeProvider();
      result.setTypeProvider(_typeProvider_1);
      return result;
    }
    return super.doVisitComputedTypeReference(reference, param);
  }
  
  public JvmTypeReference substitute(final JvmTypeReference original) {
    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet();
    JvmTypeReference _visit = this.visit(original, _newHashSet);
    return _visit;
  }
}
