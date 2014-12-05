/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class PortableURIs {
  @Data
  public static class PortableFragmentDescription {
    private final String descriptionEClassName;
    
    private final QualifiedName descriptionQualifiedName;
    
    private final String descriptionRelativeFragment;
    
    public PortableFragmentDescription(final String descriptionEClassName, final QualifiedName descriptionQualifiedName, final String descriptionRelativeFragment) {
      super();
      this.descriptionEClassName = descriptionEClassName;
      this.descriptionQualifiedName = descriptionQualifiedName;
      this.descriptionRelativeFragment = descriptionRelativeFragment;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.descriptionEClassName== null) ? 0 : this.descriptionEClassName.hashCode());
      result = prime * result + ((this.descriptionQualifiedName== null) ? 0 : this.descriptionQualifiedName.hashCode());
      result = prime * result + ((this.descriptionRelativeFragment== null) ? 0 : this.descriptionRelativeFragment.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      PortableURIs.PortableFragmentDescription other = (PortableURIs.PortableFragmentDescription) obj;
      if (this.descriptionEClassName == null) {
        if (other.descriptionEClassName != null)
          return false;
      } else if (!this.descriptionEClassName.equals(other.descriptionEClassName))
        return false;
      if (this.descriptionQualifiedName == null) {
        if (other.descriptionQualifiedName != null)
          return false;
      } else if (!this.descriptionQualifiedName.equals(other.descriptionQualifiedName))
        return false;
      if (this.descriptionRelativeFragment == null) {
        if (other.descriptionRelativeFragment != null)
          return false;
      } else if (!this.descriptionRelativeFragment.equals(other.descriptionRelativeFragment))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("descriptionEClassName", this.descriptionEClassName);
      b.add("descriptionQualifiedName", this.descriptionQualifiedName);
      b.add("descriptionRelativeFragment", this.descriptionRelativeFragment);
      return b.toString();
    }
    
    @Pure
    public String getDescriptionEClassName() {
      return this.descriptionEClassName;
    }
    
    @Pure
    public QualifiedName getDescriptionQualifiedName() {
      return this.descriptionQualifiedName;
    }
    
    @Pure
    public String getDescriptionRelativeFragment() {
      return this.descriptionRelativeFragment;
    }
  }
  
  public final static String PORTABLE_SCHEME = "portable";
  
  @Inject
  private IGlobalScopeProvider globalScopeProvider;
  
  @Inject
  private LazyURIEncoder lazyURIencoder;
  
  public boolean isPortableURIFragment(final String uriFragment) {
    return uriFragment.startsWith(PortableURIs.PORTABLE_SCHEME);
  }
  
  public EObject resolve(final StorageAwareResource resource, final String portableFragment) {
    final PortableURIs.PortableFragmentDescription desc = this.fromFragmentString(portableFragment);
    final EReference mock = EcoreFactory.eINSTANCE.createEReference();
    mock.setEType(EcorePackage.Literals.EOBJECT);
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    final IScope scope = this.globalScopeProvider.getScope(resource, mock, _alwaysTrue);
    Iterable<IEObjectDescription> _elements = scope.getElements(desc.descriptionQualifiedName);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        EClass _eClass = it.getEClass();
        String _name = _eClass.getName();
        return Boolean.valueOf(Objects.equal(_name, desc.descriptionEClassName));
      }
    };
    final IEObjectDescription description = IterableExtensions.<IEObjectDescription>findFirst(_elements, _function);
    boolean _equals = Objects.equal(description, null);
    if (_equals) {
      return null;
    }
    EObject _eObjectOrProxy = description.getEObjectOrProxy();
    final EObject container = EcoreUtil.resolve(_eObjectOrProxy, resource);
    return this.getEObject(container, desc.descriptionRelativeFragment);
  }
  
  public URI toPortableURI(final StorageAwareResource res, final URI uri, final String fragment) {
    boolean _and = false;
    URI _uRI = res.getURI();
    boolean _equals = Objects.equal(_uRI, uri);
    if (!_equals) {
      _and = false;
    } else {
      boolean _isCrossLinkFragment = this.lazyURIencoder.isCrossLinkFragment(res, fragment);
      _and = _isCrossLinkFragment;
    }
    if (_and) {
      final EObject result = res.getEObject(fragment);
      boolean _or = false;
      boolean _equals_1 = Objects.equal(result, null);
      if (_equals_1) {
        _or = true;
      } else {
        boolean _eIsProxy = result.eIsProxy();
        _or = _eIsProxy;
      }
      if (_or) {
        return uri.appendFragment(StorageAwareResource.UNRESOLVABLE_FRAGMENT);
      } else {
        final String portableFragment = this.getPortableURIFragment(result);
        boolean _notEquals = (!Objects.equal(portableFragment, null));
        if (_notEquals) {
          URI _uRI_1 = res.getURI();
          return _uRI_1.appendFragment(portableFragment);
        }
      }
    }
    ResourceSet _resourceSet = res.getResourceSet();
    final Resource resource = _resourceSet.getResource(uri, false);
    boolean _notEquals_1 = (!Objects.equal(resource, null));
    if (_notEquals_1) {
      final EObject obj = resource.getEObject(fragment);
      boolean _notEquals_2 = (!Objects.equal(obj, null));
      if (_notEquals_2) {
        final String portableFragment_1 = this.getPortableURIFragment(obj);
        boolean _notEquals_3 = (!Objects.equal(portableFragment_1, null));
        if (_notEquals_3) {
          URI _uRI_2 = res.getURI();
          return _uRI_2.appendFragment(portableFragment_1);
        }
      }
    }
    return uri.appendFragment(fragment);
  }
  
  protected String getPortableURIFragment(final EObject obj) {
    Resource _eResource = obj.eResource();
    final Resource res = _eResource;
    boolean _matched = false;
    if (!_matched) {
      if (res instanceof XtextResource) {
        _matched=true;
        IResourceServiceProvider _resourceServiceProvider = ((XtextResource)res).getResourceServiceProvider();
        IResourceDescription.Manager _resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
        Resource _eResource_1 = obj.eResource();
        final IResourceDescription desc = _resourceDescriptionManager.getResourceDescription(_eResource_1);
        Iterable<IEObjectDescription> _exportedObjects = desc.getExportedObjects();
        final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
          public Boolean apply(final IEObjectDescription it) {
            boolean _xblockexpression = false;
            {
              EObject _eObjectOrProxy = it.getEObjectOrProxy();
              final EObject possibleContainer = EcoreUtil.resolve(_eObjectOrProxy, res);
              boolean _or = false;
              boolean _equals = Objects.equal(obj, possibleContainer);
              if (_equals) {
                _or = true;
              } else {
                boolean _isAncestor = EcoreUtil.isAncestor(obj, possibleContainer);
                _or = _isAncestor;
              }
              _xblockexpression = _or;
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        final IEObjectDescription containerDesc = IterableExtensions.<IEObjectDescription>findFirst(_exportedObjects, _function);
        boolean _notEquals = (!Objects.equal(containerDesc, null));
        if (_notEquals) {
          final String fragment = this.createPortableURIFragment(containerDesc, obj);
          return fragment;
        }
      }
    }
    return null;
  }
  
  protected String createPortableURIFragment(final IEObjectDescription desc, final EObject target) {
    EObject _eObjectOrProxy = desc.getEObjectOrProxy();
    final EObject possibleContainer = EcoreUtil.resolve(_eObjectOrProxy, target);
    final String fragmentToTarget = this.getFragment(target, possibleContainer);
    EClass _eClass = desc.getEClass();
    String _name = _eClass.getName();
    QualifiedName _qualifiedName = desc.getQualifiedName();
    final PortableURIs.PortableFragmentDescription portableDescription = new PortableURIs.PortableFragmentDescription(_name, _qualifiedName, fragmentToTarget);
    return this.toFragmentString(portableDescription);
  }
  
  protected String toFragmentString(final PortableURIs.PortableFragmentDescription desc) {
    final String typeName = desc.descriptionEClassName;
    final List<String> segments = desc.descriptionQualifiedName.getSegments();
    String _join = IterableExtensions.join(segments, ":");
    String uriFragment = ((((PortableURIs.PORTABLE_SCHEME + "#") + typeName) + "#") + _join);
    boolean _notEquals = (!Objects.equal(desc.descriptionRelativeFragment, null));
    if (_notEquals) {
      String _uriFragment = uriFragment;
      uriFragment = (_uriFragment + ("#" + desc.descriptionRelativeFragment));
    }
    return uriFragment;
  }
  
  protected PortableURIs.PortableFragmentDescription fromFragmentString(final String fragmentString) {
    Splitter _on = Splitter.on("#");
    Iterable<String> _split = _on.split(fragmentString);
    final Iterator<String> segments = _split.iterator();
    segments.next();
    final String eClassName = segments.next();
    Splitter _on_1 = Splitter.on(":");
    String _next = segments.next();
    Iterable<String> _split_1 = _on_1.split(_next);
    List<String> _list = IterableExtensions.<String>toList(_split_1);
    final QualifiedName qname = QualifiedName.create(_list);
    String _xifexpression = null;
    boolean _hasNext = segments.hasNext();
    if (_hasNext) {
      _xifexpression = segments.next();
    }
    final String fragment = _xifexpression;
    return new PortableURIs.PortableFragmentDescription(eClassName, qname, fragment);
  }
  
  protected String getFragment(final EObject fromContainer, final EObject toChild) {
    boolean _equals = Objects.equal(fromContainer, toChild);
    if (_equals) {
      return null;
    }
    InternalEObject lastChild = ((InternalEObject) toChild);
    InternalEObject lastContainer = lastChild.eInternalContainer();
    EStructuralFeature _eContainingFeature = lastChild.eContainingFeature();
    String result = lastContainer.eURIFragmentSegment(_eContainingFeature, lastChild);
    while (((!Objects.equal(lastContainer, null)) && (!Objects.equal(fromContainer, lastContainer)))) {
      {
        lastChild = lastContainer;
        InternalEObject _eInternalContainer = lastContainer.eInternalContainer();
        lastContainer = _eInternalContainer;
        boolean _equals_1 = Objects.equal(lastContainer, null);
        if (_equals_1) {
          throw new IllegalStateException(("No more containers for element " + lastChild));
        }
        EStructuralFeature _eContainingFeature_1 = lastChild.eContainingFeature();
        String _eURIFragmentSegment = lastContainer.eURIFragmentSegment(_eContainingFeature_1, lastChild);
        String _plus = (_eURIFragmentSegment + "/");
        String _plus_1 = (_plus + result);
        result = _plus_1;
      }
    }
    return result;
  }
  
  protected EObject getEObject(final EObject from, final String toFragment) {
    boolean _equals = Objects.equal(toFragment, null);
    if (_equals) {
      return from;
    }
    Splitter _on = Splitter.on("/");
    final Iterable<String> splitted = _on.split(toFragment);
    final Function2<EObject, String, EObject> _function = new Function2<EObject, String, EObject>() {
      public EObject apply(final EObject $0, final String $1) {
        return ((InternalEObject) $0).eObjectForURIFragmentSegment($1);
      }
    };
    return IterableExtensions.<String, EObject>fold(splitted, from, _function);
  }
}
