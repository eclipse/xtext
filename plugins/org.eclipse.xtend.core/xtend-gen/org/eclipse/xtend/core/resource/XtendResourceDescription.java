package org.eclipse.xtend.core.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
    boolean _equals = Objects.equal(this.lookup, null);
    if (_equals) {
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
    boolean _notEquals = (!Objects.equal(this.importedNames, null));
    if (_notEquals) {
      return this.importedNames;
    }
    final HashSet<QualifiedName> result = CollectionLiterals.<QualifiedName>newHashSet();
    Resource _resource = this.getResource();
    EList<EObject> _contents = _resource.getContents();
    final EObject astRoot = IterableExtensions.<EObject>head(_contents);
    boolean _notEquals_1 = (!Objects.equal(astRoot, null));
    if (_notEquals_1) {
      final IResolvedTypes types = this.typeResolver.resolveTypes(astRoot);
      TreeIterator<Object> _allContents = EcoreUtil.<Object>getAllContents(astRoot, true);
      Iterable<Object> _iterable = IteratorExtensions.<Object>toIterable(_allContents);
      Iterable<XExpression> _filter = Iterables.<XExpression>filter(_iterable, XExpression.class);
      for (final XExpression expression : _filter) {
        {
          boolean _matched = false;
          if (expression instanceof XMemberFeatureCall) {
            boolean _and = false;
            boolean _and_1 = false;
            JvmIdentifiableElement _feature = ((XMemberFeatureCall)expression).getFeature();
            boolean _notEquals_2 = (!Objects.equal(_feature, null));
            if (!_notEquals_2) {
              _and_1 = false;
            } else {
              JvmIdentifiableElement _feature_1 = ((XMemberFeatureCall)expression).getFeature();
              boolean _eIsProxy = _feature_1.eIsProxy();
              _and_1 = _eIsProxy;
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _isExplicitOperationCallOrBuilderSyntax = ((XMemberFeatureCall)expression).isExplicitOperationCallOrBuilderSyntax();
              boolean _not = (!_isExplicitOperationCallOrBuilderSyntax);
              _and = _not;
            }
            if (_and) {
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
                  QualifiedName _qualifiedName = this.nameConverter.toQualifiedName(_plus_1);
                  QualifiedName _lowerCase = _qualifiedName.toLowerCase();
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
                  final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
                    @Override
                    public Boolean apply(final String it) {
                      QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                      QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                      return Boolean.valueOf(result.add(_lowerCase));
                    }
                  };
                  this.registerAllTypes(((JvmType)type), _function);
                }
              }
            }
          }
          final LightweightTypeReference typeRef = types.getActualType(expression);
          boolean _notEquals_2 = (!Objects.equal(typeRef, null));
          if (_notEquals_2) {
            JvmType _type = typeRef.getType();
            final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
              @Override
              public Boolean apply(final String it) {
                QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                return Boolean.valueOf(result.add(_lowerCase));
              }
            };
            this.registerAllTypes(_type, _function);
          }
        }
      }
      Resource _resource_1 = this.getResource();
      EList<EObject> _contents_1 = _resource_1.getContents();
      for (final EObject eobject : _contents_1) {
        {
          TreeIterator<Object> _allContents_1 = EcoreUtil.<Object>getAllContents(eobject, true);
          Iterator<JvmIdentifiableElement> _filter_1 = Iterators.<JvmIdentifiableElement>filter(_allContents_1, JvmIdentifiableElement.class);
          final Function1<JvmIdentifiableElement, LightweightTypeReference> _function = new Function1<JvmIdentifiableElement, LightweightTypeReference>() {
            @Override
            public LightweightTypeReference apply(final JvmIdentifiableElement it) {
              LightweightTypeReference _xifexpression = null;
              boolean _or = false;
              if ((!(it instanceof JvmType))) {
                _or = true;
              } else {
                _or = (it instanceof JvmDeclaredType);
              }
              if (_or) {
                _xifexpression = types.getActualType(it);
              }
              return _xifexpression;
            }
          };
          Iterator<LightweightTypeReference> _map = IteratorExtensions.<JvmIdentifiableElement, LightweightTypeReference>map(_filter_1, _function);
          final Iterable<LightweightTypeReference> typesOfIdentifiables = IteratorExtensions.<LightweightTypeReference>toIterable(_map);
          for (final LightweightTypeReference typeRef : typesOfIdentifiables) {
            boolean _notEquals_2 = (!Objects.equal(typeRef, null));
            if (_notEquals_2) {
              JvmType _type = typeRef.getType();
              final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
                @Override
                public Boolean apply(final String it) {
                  QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                  QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                  return Boolean.valueOf(result.add(_lowerCase));
                }
              };
              this.registerAllTypes(_type, _function_1);
            }
          }
        }
      }
    }
    Iterable<QualifiedName> _importedNames = super.getImportedNames();
    Iterables.<QualifiedName>addAll(result, _importedNames);
    final Function1<QualifiedName, Boolean> _function = new Function1<QualifiedName, Boolean>() {
      @Override
      public Boolean apply(final QualifiedName it) {
        String _lastSegment = it.getLastSegment();
        boolean _contains = XtendResourceDescription.primitivesFilter.contains(_lastSegment);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<QualifiedName> _filter_1 = IterableExtensions.<QualifiedName>filter(result, _function);
    Set<QualifiedName> _set = IterableExtensions.<QualifiedName>toSet(_filter_1);
    this.importedNames = _set;
    return this.importedNames;
  }
  
  public void registerAllTypes(final JvmType type, final Function1<? super String, ? extends Boolean> acceptor) {
    boolean _or = false;
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _eIsProxy = type.eIsProxy();
      _or = _eIsProxy;
    }
    if (_or) {
      return;
    }
    boolean _and = false;
    boolean _isLocal = this.isLocal(type);
    boolean _not = (!_isLocal);
    if (!_not) {
      _and = false;
    } else {
      String _identifier = type.getIdentifier();
      Boolean _apply = acceptor.apply(_identifier);
      _and = (_apply).booleanValue();
    }
    if (_and) {
      boolean _matched = false;
      if (type instanceof JvmGenericType) {
        _matched=true;
        JvmDeclaredType _declaringType = ((JvmGenericType)type).getDeclaringType();
        this.registerAllTypes(_declaringType, acceptor);
        JvmTypeReference _extendedClass = null;
        if (((JvmGenericType)type)!=null) {
          _extendedClass=((JvmGenericType)type).getExtendedClass();
        }
        JvmType _type = null;
        if (_extendedClass!=null) {
          _type=_extendedClass.getType();
        }
        this.registerAllTypes(_type, acceptor);
        Iterable<JvmTypeReference> _extendedInterfaces = ((JvmGenericType)type).getExtendedInterfaces();
        final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
          @Override
          public void apply(final JvmTypeReference it) {
            JvmType _type = null;
            if (it!=null) {
              _type=it.getType();
            }
            XtendResourceDescription.this.registerAllTypes(_type, acceptor);
          }
        };
        IterableExtensions.<JvmTypeReference>forEach(_extendedInterfaces, _function);
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
