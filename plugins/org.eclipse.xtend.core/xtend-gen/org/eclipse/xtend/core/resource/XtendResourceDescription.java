package org.eclipse.xtend.core.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmGenericType;
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
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class XtendResourceDescription extends DefaultResourceDescription {
  private final Set<String> primitivesFilter = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("boolean", "int", "char", "byte", "short", "long", "double", "float", "void"));
  
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
    final ArrayList<QualifiedName> result = CollectionLiterals.<QualifiedName>newArrayList();
    Iterable<QualifiedName> _importedNames = super.getImportedNames();
    Iterables.<QualifiedName>addAll(result, _importedNames);
    Resource _resource = this.getResource();
    EList<EObject> _contents = _resource.getContents();
    for (final EObject eobject : _contents) {
      {
        final IResolvedTypes types = this.typeResolver.resolveTypes(eobject);
        TreeIterator<Object> _allContents = EcoreUtil.<Object>getAllContents(eobject, true);
        Iterator<XExpression> _filter = Iterators.<XExpression>filter(_allContents, XExpression.class);
        List<XExpression> _list = IteratorExtensions.<XExpression>toList(_filter);
        final Function1<XExpression,LightweightTypeReference> _function = new Function1<XExpression,LightweightTypeReference>() {
            public LightweightTypeReference apply(final XExpression it) {
              LightweightTypeReference _actualType = types.getActualType(it);
              return _actualType;
            }
          };
        final List<LightweightTypeReference> actualTypes = ListExtensions.<XExpression, LightweightTypeReference>map(_list, _function);
        for (final LightweightTypeReference typeRef : actualTypes) {
          JvmType _type = typeRef.getType();
          final Procedure1<String> _function_1 = new Procedure1<String>() {
              public void apply(final String it) {
                QualifiedName _qualifiedName = XtendResourceDescription.this.nameConverter.toQualifiedName(it);
                QualifiedName _lowerCase = _qualifiedName.toLowerCase();
                result.add(_lowerCase);
              }
            };
          this.registerAllTypes(_type, _function_1);
        }
      }
    }
    final Function1<QualifiedName,Boolean> _function = new Function1<QualifiedName,Boolean>() {
        public Boolean apply(final QualifiedName it) {
          String _lastSegment = it.getLastSegment();
          boolean _contains = XtendResourceDescription.this.primitivesFilter.contains(_lastSegment);
          boolean _not = (!_contains);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<QualifiedName> _filter = IterableExtensions.<QualifiedName>filter(result, _function);
    return IterableExtensions.<QualifiedName>toSet(_filter);
  }
  
  public void registerAllTypes(final JvmType type, final Procedure1<? super String> acceptor) {
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      return;
    }
    String _identifier = type.getIdentifier();
    acceptor.apply(_identifier);
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof JvmGenericType) {
        final JvmGenericType _jvmGenericType = (JvmGenericType)type;
        _matched=true;
        JvmTypeReference _extendedClass = _jvmGenericType==null?(JvmTypeReference)null:_jvmGenericType.getExtendedClass();
        JvmType _type = _extendedClass==null?(JvmType)null:_extendedClass.getType();
        this.registerAllTypes(_type, acceptor);
        Iterable<JvmTypeReference> _extendedInterfaces = _jvmGenericType.getExtendedInterfaces();
        final Procedure1<JvmTypeReference> _function = new Procedure1<JvmTypeReference>() {
            public void apply(final JvmTypeReference it) {
              JvmType _type = it==null?(JvmType)null:it.getType();
              XtendResourceDescription.this.registerAllTypes(_type, acceptor);
            }
          };
        IterableExtensions.<JvmTypeReference>forEach(_extendedInterfaces, _function);
      }
    }
  }
}
