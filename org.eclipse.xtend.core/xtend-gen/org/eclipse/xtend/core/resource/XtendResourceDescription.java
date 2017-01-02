package org.eclipse.xtend.core.resource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class XtendResourceDescription extends DefaultResourceDescription {
  private final static Set<String> primitivesFilter = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("boolean", "int", "char", "byte", "short", "long", "double", "float", "void"));
  
  private IBatchTypeResolver typeResolver;
  
  private IQualifiedNameConverter nameConverter;
  
  private Set<QualifiedName> importedNames;
  
  public XtendResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy, final IResourceScopeCache cache, final IBatchTypeResolver typeResolver, final IQualifiedNameConverter nameConverter) {
    super(resource, strategy, cache);
    this.typeResolver = typeResolver;
    this.nameConverter = nameConverter;
  }
  
  @Override
  protected EObjectDescriptionLookUp getLookUp() {
    if ((this.lookup == null)) {
      List<IEObjectDescription> _computeExportedObjects = this.computeExportedObjects();
      EObjectDescriptionLookUp _eObjectDescriptionLookUp = new EObjectDescriptionLookUp(_computeExportedObjects);
      this.lookup = _eObjectDescriptionLookUp;
    }
    return this.lookup;
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return Collections.<IReferenceDescription>emptyList();
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    if ((this.importedNames != null)) {
      return this.importedNames;
    }
    final HashSet<QualifiedName> result = CollectionLiterals.<QualifiedName>newHashSet();
    final EObject astRoot = IterableExtensions.<EObject>head(this.getResource().getContents());
    if ((astRoot != null)) {
      final IResolvedTypes types = this.typeResolver.resolveTypes(astRoot);
      Iterable<XExpression> _filter = Iterables.<XExpression>filter(IteratorExtensions.<Object>toIterable(EcoreUtil.<Object>getAllContents(astRoot, true)), XExpression.class);
      for (final XExpression expression : _filter) {
        {
          boolean _matched = false;
          if (expression instanceof XMemberFeatureCall) {
            if ((((((XMemberFeatureCall)expression).getFeature() != null) && ((XMemberFeatureCall)expression).getFeature().eIsProxy()) && (!((XMemberFeatureCall)expression).isExplicitOperationCallOrBuilderSyntax()))) {
              _matched=true;
              final XExpression receiver = ((XMemberFeatureCall)expression).getActualReceiver();
              boolean _matched_1 = false;
              if (receiver instanceof XAbstractFeatureCall) {
                boolean _isTypeLiteral = ((XAbstractFeatureCall)receiver).isTypeLiteral();
                if (_isTypeLiteral) {
                  _matched_1=true;
                  final JvmIdentifiableElement type = ((XAbstractFeatureCall)receiver).getFeature();
                  String _identifier = type.getIdentifier();
                  String _plus = (_identifier + "$");
                  String _concreteSyntaxFeatureName = ((XMemberFeatureCall)expression).getConcreteSyntaxFeatureName();
                  String _plus_1 = (_plus + _concreteSyntaxFeatureName);
                  QualifiedName _lowerCase = this.nameConverter.toQualifiedName(_plus_1).toLowerCase();
                  result.add(_lowerCase);
                }
              }
            }
          }
          if (!_matched) {
            if (expression instanceof XAbstractFeatureCall) {
              boolean _isTypeLiteral = ((XAbstractFeatureCall)expression).isTypeLiteral();
              if (_isTypeLiteral) {
                _matched=true;
                final JvmIdentifiableElement type = ((XAbstractFeatureCall)expression).getFeature();
                if ((type instanceof JvmDeclaredType)) {
                  final Function1<String, Boolean> _function = (String it) -> {
                    QualifiedName _lowerCase = this.nameConverter.toQualifiedName(it).toLowerCase();
                    return Boolean.valueOf(result.add(_lowerCase));
                  };
                  this.registerAllTypes(((JvmType)type), _function);
                }
              }
            }
          }
          final LightweightTypeReference typeRef = types.getActualType(expression);
          if ((typeRef != null)) {
            final Function1<String, Boolean> _function = (String it) -> {
              QualifiedName _lowerCase = this.nameConverter.toQualifiedName(it).toLowerCase();
              return Boolean.valueOf(result.add(_lowerCase));
            };
            this.registerAllTypes(typeRef.getType(), _function);
          }
        }
      }
      EList<EObject> _contents = this.getResource().getContents();
      for (final EObject eobject : _contents) {
        {
          final Function1<JvmIdentifiableElement, LightweightTypeReference> _function = (JvmIdentifiableElement it) -> {
            LightweightTypeReference _xifexpression = null;
            if (((!(it instanceof JvmType)) || (it instanceof JvmDeclaredType))) {
              _xifexpression = types.getActualType(it);
            }
            return _xifexpression;
          };
          final Iterable<LightweightTypeReference> typesOfIdentifiables = IteratorExtensions.<LightweightTypeReference>toIterable(IteratorExtensions.<JvmIdentifiableElement, LightweightTypeReference>map(Iterators.<JvmIdentifiableElement>filter(EcoreUtil.<Object>getAllContents(eobject, true), JvmIdentifiableElement.class), _function));
          for (final LightweightTypeReference typeRef : typesOfIdentifiables) {
            if ((typeRef != null)) {
              final Function1<String, Boolean> _function_1 = (String it) -> {
                QualifiedName _lowerCase = this.nameConverter.toQualifiedName(it).toLowerCase();
                return Boolean.valueOf(result.add(_lowerCase));
              };
              this.registerAllTypes(typeRef.getType(), _function_1);
            }
          }
        }
      }
    }
    Iterables.<QualifiedName>addAll(result, super.getImportedNames());
    final Function1<QualifiedName, Boolean> _function = (QualifiedName it) -> {
      boolean _contains = XtendResourceDescription.primitivesFilter.contains(it.getLastSegment());
      return Boolean.valueOf((!_contains));
    };
    this.importedNames = IterableExtensions.<QualifiedName>toSet(IterableExtensions.<QualifiedName>filter(result, _function));
    return this.importedNames;
  }
  
  public void registerAllTypes(final JvmType type, final Function1<? super String, ? extends Boolean> acceptor) {
    if (((type == null) || type.eIsProxy())) {
      return;
    }
    if (((!this.isLocal(type)) && (acceptor.apply(type.getIdentifier())).booleanValue())) {
      boolean _matched = false;
      if (type instanceof JvmGenericType) {
        _matched=true;
        this.registerAllTypes(((JvmGenericType)type).getDeclaringType(), acceptor);
        JvmTypeReference _extendedClass = null;
        if (((JvmGenericType)type)!=null) {
          _extendedClass=((JvmGenericType)type).getExtendedClass();
        }
        JvmType _type = null;
        if (_extendedClass!=null) {
          _type=_extendedClass.getType();
        }
        this.registerAllTypes(_type, acceptor);
        final Consumer<JvmTypeReference> _function = (JvmTypeReference it) -> {
          JvmType _type_1 = null;
          if (it!=null) {
            _type_1=it.getType();
          }
          this.registerAllTypes(_type_1, acceptor);
        };
        ((JvmGenericType)type).getExtendedInterfaces().forEach(_function);
      }
    }
  }
  
  public boolean isLocal(final JvmType type) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (type instanceof JvmGenericType) {
      _matched=true;
      _switchResult = ((JvmGenericType)type).isLocal();
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
