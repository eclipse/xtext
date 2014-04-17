package org.eclipse.xtend.core.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
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
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
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
  private final static Set<String> primitivesFilter = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("boolean", "int", "char", "byte", "short", "long", "double", "float", "void"));
  
  private IBatchTypeResolver typeResolver;
  
  private IQualifiedNameConverter nameConverter;
  
  public XtendResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    super(resource, strategy);
  }
  
  public XtendResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy, final IResourceScopeCache cache, final IBatchTypeResolver typeResolver, final IQualifiedNameConverter nameConverter) {
    super(resource, strategy, cache);
    this.typeResolver = typeResolver;
    this.nameConverter = nameConverter;
  }
  
  protected EObjectDescriptionLookUp getLookUp() {
    boolean _equals = Objects.equal(this.lookup, null);
    if (_equals) {
      List<IEObjectDescription> _computeExportedObjects = this.computeExportedObjects();
      EObjectDescriptionLookUp _eObjectDescriptionLookUp = new EObjectDescriptionLookUp(_computeExportedObjects);
      this.lookup = _eObjectDescriptionLookUp;
    }
    return this.lookup;
  }
  
  public Iterable<QualifiedName> getImportedNames() {
    final HashSet<QualifiedName> result = CollectionLiterals.<QualifiedName>newHashSet();
    Resource _resource = this.getResource();
    EList<EObject> _contents = _resource.getContents();
    for (final EObject eobject : _contents) {
      {
        final IResolvedTypes types = this.typeResolver.resolveTypes(eobject);
        TreeIterator<Object> _allContents = EcoreUtil.<Object>getAllContents(eobject, true);
        Iterator<XExpression> _filter = Iterators.<XExpression>filter(_allContents, XExpression.class);
        final Function1<XExpression, LightweightTypeReference> _function = new Function1<XExpression, LightweightTypeReference>() {
          public LightweightTypeReference apply(final XExpression it) {
            return types.getActualType(it);
          }
        };
        Iterator<LightweightTypeReference> _map = IteratorExtensions.<XExpression, LightweightTypeReference>map(_filter, _function);
        final Iterable<LightweightTypeReference> actualTypes = IteratorExtensions.<LightweightTypeReference>toIterable(_map);
        for (final LightweightTypeReference typeRef : actualTypes) {
          boolean _notEquals = (!Objects.equal(typeRef, null));
          if (_notEquals) {
            JvmType _type = typeRef.getType();
            final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
              public Boolean apply(final String it) {
                QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                return Boolean.valueOf(result.add(_lowerCase));
              }
            };
            this.registerAllTypes(_type, _function_1);
          }
        }
        TreeIterator<Object> _allContents_1 = EcoreUtil.<Object>getAllContents(eobject, true);
        Iterator<JvmIdentifiableElement> _filter_1 = Iterators.<JvmIdentifiableElement>filter(_allContents_1, JvmIdentifiableElement.class);
        final Function1<JvmIdentifiableElement, LightweightTypeReference> _function_2 = new Function1<JvmIdentifiableElement, LightweightTypeReference>() {
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
        Iterator<LightweightTypeReference> _map_1 = IteratorExtensions.<JvmIdentifiableElement, LightweightTypeReference>map(_filter_1, _function_2);
        final Iterable<LightweightTypeReference> typesOfIdentifiables = IteratorExtensions.<LightweightTypeReference>toIterable(_map_1);
        for (final LightweightTypeReference typeRef_1 : typesOfIdentifiables) {
          boolean _notEquals_1 = (!Objects.equal(typeRef_1, null));
          if (_notEquals_1) {
            JvmType _type_1 = typeRef_1.getType();
            final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
              public Boolean apply(final String it) {
                QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                return Boolean.valueOf(result.add(_lowerCase));
              }
            };
            this.registerAllTypes(_type_1, _function_3);
          }
        }
      }
    }
    Iterable<QualifiedName> _importedNames = super.getImportedNames();
    Iterables.<QualifiedName>addAll(result, _importedNames);
    final Function1<QualifiedName, Boolean> _function = new Function1<QualifiedName, Boolean>() {
      public Boolean apply(final QualifiedName it) {
        String _lastSegment = it.getLastSegment();
        boolean _contains = XtendResourceDescription.primitivesFilter.contains(_lastSegment);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<QualifiedName> _filter = IterableExtensions.<QualifiedName>filter(result, _function);
    return IterableExtensions.<QualifiedName>toSet(_filter);
  }
  
  public void registerAllTypes(final JvmType type, final Function1<? super String, ? extends Boolean> acceptor) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      return;
    }
    boolean _or = false;
    boolean _isLocal = this.isLocal(type);
    boolean _not = (!_isLocal);
    if (_not) {
      _or = true;
    } else {
      String _identifier = type.getIdentifier();
      Boolean _apply = acceptor.apply(_identifier);
      _or = (_apply).booleanValue();
    }
    if (_or) {
      boolean _matched = false;
      if (!_matched) {
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
  }
  
  public boolean isLocal(final JvmType type) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof JvmGenericType) {
        _matched=true;
        _switchResult = ((JvmGenericType)type).isLocal();
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
