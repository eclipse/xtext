/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Portable URIs are based on names and therefore are independent of the concrete file pathes and fuile names the
 * of resources.
 * 
 * A portable URI is really a resource URI to the client URI and a fragment that contains the information to retrieve the
 * referenced element using the global scoping. That is it contains
 * <ul>
 *   <li>the qualified name of a container of the target element
 *   <li>the type of that container
 *   <li>the path from that container to the actual target element
 * </ul>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@SuppressWarnings("all")
public class PortableURIs {
  @Data
  public static class PortableFragmentDescription {
    private final EClass descriptionEClass;
    
    private final QualifiedName descriptionQualifiedName;
    
    private final String descriptionRelativeFragment;
    
    public PortableFragmentDescription(final EClass descriptionEClass, final QualifiedName descriptionQualifiedName, final String descriptionRelativeFragment) {
      super();
      this.descriptionEClass = descriptionEClass;
      this.descriptionQualifiedName = descriptionQualifiedName;
      this.descriptionRelativeFragment = descriptionRelativeFragment;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.descriptionEClass== null) ? 0 : this.descriptionEClass.hashCode());
      result = prime * result + ((this.descriptionQualifiedName== null) ? 0 : this.descriptionQualifiedName.hashCode());
      return prime * result + ((this.descriptionRelativeFragment== null) ? 0 : this.descriptionRelativeFragment.hashCode());
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
      if (this.descriptionEClass == null) {
        if (other.descriptionEClass != null)
          return false;
      } else if (!this.descriptionEClass.equals(other.descriptionEClass))
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
      b.add("descriptionEClass", this.descriptionEClass);
      b.add("descriptionQualifiedName", this.descriptionQualifiedName);
      b.add("descriptionRelativeFragment", this.descriptionRelativeFragment);
      return b.toString();
    }
    
    @Pure
    public EClass getDescriptionEClass() {
      return this.descriptionEClass;
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
  private EPackage.Registry packageRegistry;
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  /**
   * @return whether the given string is a portable URI fragment
   */
  public boolean isPortableURIFragment(final String uriFragment) {
    return uriFragment.startsWith(PortableURIs.PORTABLE_SCHEME);
  }
  
  /**
   * Resolves a given portable URI fragment against the given resource.
   * 
   * @param resource the resource from which global scope to look up the EObject
   * @param portableFragment the portable fragment pointing to the to be resolved EObject
   * 
   * @return the EObject for the given portableURIFragment
   */
  public EObject resolve(final StorageAwareResource resource, final String portableFragment) {
    final PortableURIs.PortableFragmentDescription desc = this.fromFragmentString(portableFragment);
    final EReference mock = EcoreFactory.eINSTANCE.createEReference();
    mock.setEType(desc.descriptionEClass);
    final IScope scope = this.globalScopeProvider.getScope(resource, mock, Predicates.<IEObjectDescription>alwaysTrue());
    final IEObjectDescription description = IterableExtensions.<IEObjectDescription>head(scope.getElements(desc.descriptionQualifiedName));
    if ((description == null)) {
      return null;
    }
    final EObject container = EcoreUtil.resolve(description.getEObjectOrProxy(), resource);
    return this.getEObject(container, desc.descriptionRelativeFragment);
  }
  
  /**
   * Creates and returns a portable URI from the given resource to the targetURI.
   * Returns <code>null</code> is no portable URI can be constructed, which is the case if the
   * targetObject is not itself exported or is a child of an exported EObject.
   * 
   * @param sourceResource the resource from which the EObject should later be resolved
   * @param targetURI the target URI that should be resolvable by the created portable URI
   * 
   * @return a portable URI or <code>null</code>
   */
  public URI toPortableURI(final StorageAwareResource sourceResource, final URI targetURI) {
    Resource _resource = sourceResource.getResourceSet().getResource(targetURI.trimFragment(), false);
    EObject _eObject = null;
    if (_resource!=null) {
      _eObject=_resource.getEObject(targetURI.fragment());
    }
    final EObject to = _eObject;
    boolean _or = false;
    if ((to == null)) {
      _or = true;
    } else {
      Resource _eResource = to.eResource();
      ResourceSet _resourceSet = null;
      if (_eResource!=null) {
        _resourceSet=_eResource.getResourceSet();
      }
      boolean _tripleNotEquals = (_resourceSet != null);
      _or = _tripleNotEquals;
    }
    if (_or) {
      final URI result = this.toPortableURI(sourceResource, to);
      if ((result != null)) {
        return result;
      }
    }
    return null;
  }
  
  /**
   * Creates and returns a portable URI from the global scope.
   * Returns <code>null</code> is no portable URI can be constructed, which is the case if the
   * targetObject is not itself exported or is a child of an exported EObject.
   * 
   * @param sourceResource the resource from which the EObject should later be resolved
   * @param targetObject the target object that should be resolvable by the created portable URI
   * 
   * @return a portable URI or <code>null</code>
   */
  public URI toPortableURI(final StorageAwareResource sourceResource, final EObject targetObject) {
    if (((targetObject == null) || targetObject.eIsProxy())) {
      return sourceResource.getURI().appendFragment(StorageAwareResource.UNRESOLVABLE_FRAGMENT);
    }
    final String portableFragment = this.getPortableURIFragment(targetObject);
    if ((portableFragment != null)) {
      return sourceResource.getURI().appendFragment(portableFragment);
    }
    return null;
  }
  
  /**
   * @return a portable URI fragment, or <code>null</code> if the give EObject isn't itself or is not contained in an exported EObjectDescription
   */
  protected String getPortableURIFragment(final EObject obj) {
    final IResourceDescriptions descriptions = this.resourceDescriptionsProvider.getResourceDescriptions(obj.eResource());
    final IResourceDescription desc = descriptions.getResourceDescription(obj.eResource().getURI());
    if ((desc == null)) {
      return null;
    }
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      boolean _xblockexpression = false;
      {
        final EObject possibleContainer = EcoreUtil.resolve(it.getEObjectOrProxy(), obj.eResource());
        _xblockexpression = (Objects.equal(obj, possibleContainer) || EcoreUtil.isAncestor(obj, possibleContainer));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final IEObjectDescription containerDesc = IterableExtensions.<IEObjectDescription>findFirst(desc.getExportedObjects(), _function);
    if ((containerDesc != null)) {
      final PortableURIs.PortableFragmentDescription fragmentDescription = this.createPortableFragmentDescription(containerDesc, obj);
      return this.toFragmentString(fragmentDescription);
    }
    return null;
  }
  
  protected PortableURIs.PortableFragmentDescription createPortableFragmentDescription(final IEObjectDescription desc, final EObject target) {
    final EObject possibleContainer = EcoreUtil.resolve(desc.getEObjectOrProxy(), target);
    final String fragmentToTarget = this.getFragment(target, possibleContainer);
    EClass _eClass = desc.getEClass();
    QualifiedName _qualifiedName = desc.getQualifiedName();
    return new PortableURIs.PortableFragmentDescription(_eClass, _qualifiedName, fragmentToTarget);
  }
  
  protected String toFragmentString(final PortableURIs.PortableFragmentDescription desc) {
    final String eclassUriAsString = URI.encodeFragment(EcoreUtil.getURI(desc.descriptionEClass).toString(), false);
    final List<String> segments = desc.descriptionQualifiedName.getSegments();
    String _encodeFragment = URI.encodeFragment(IterableExtensions.join(segments, ":"), false);
    String uriFragment = ((((PortableURIs.PORTABLE_SCHEME + "#") + eclassUriAsString) + "#") + _encodeFragment);
    if ((desc.descriptionRelativeFragment != null)) {
      String _uriFragment = uriFragment;
      String _encodeFragment_1 = URI.encodeFragment(desc.descriptionRelativeFragment, false);
      String _plus = ("#" + _encodeFragment_1);
      uriFragment = (_uriFragment + _plus);
    }
    return uriFragment;
  }
  
  protected PortableURIs.PortableFragmentDescription fromFragmentString(final String fragmentString) {
    final Iterator<String> segments = Splitter.on("#").split(fragmentString).iterator();
    segments.next();
    final URI eClassURI = URI.createURI(URI.decode(segments.next()));
    final EPackage ePackage = this.packageRegistry.getEPackage(eClassURI.trimFragment().toString());
    Resource _eResource = null;
    if (ePackage!=null) {
      _eResource=ePackage.eResource();
    }
    EObject _eObject = null;
    if (_eResource!=null) {
      _eObject=_eResource.getEObject(eClassURI.fragment());
    }
    final EClass eClass = ((EClass) _eObject);
    final QualifiedName qname = QualifiedName.create(IterableExtensions.<String>toList(Splitter.on(":").split(URI.decode(segments.next()))));
    String _xifexpression = null;
    boolean _hasNext = segments.hasNext();
    if (_hasNext) {
      _xifexpression = URI.decode(segments.next());
    }
    final String fragment = _xifexpression;
    EClass _elvis = null;
    if (eClass != null) {
      _elvis = eClass;
    } else {
      _elvis = EcorePackage.Literals.EOBJECT;
    }
    return new PortableURIs.PortableFragmentDescription(_elvis, qname, fragment);
  }
  
  /**
   * Computes a fragment to the child relative from the given container.
   * 
   * @param fromContainer the container EObject from which the fragment path is computed
   * @param toChild the target EObject which can be found using the fromContainer and resulting fragment path
   * 
   * @return a fragment path from the given container to the child, or <code>null</null> is fromContainer == toChild
   * 
   * @see #getEObject(EObject,String)
   */
  public String getFragment(final EObject fromContainer, final EObject toChild) {
    boolean _equals = Objects.equal(fromContainer, toChild);
    if (_equals) {
      return null;
    }
    InternalEObject lastChild = ((InternalEObject) toChild);
    InternalEObject lastContainer = lastChild.eInternalContainer();
    String result = lastContainer.eURIFragmentSegment(lastChild.eContainingFeature(), lastChild);
    while (((lastContainer != null) && (!Objects.equal(fromContainer, lastContainer)))) {
      {
        lastChild = lastContainer;
        lastContainer = lastContainer.eInternalContainer();
        if ((lastContainer == null)) {
          throw new IllegalStateException(("No more containers for element " + lastChild));
        }
        String _eURIFragmentSegment = lastContainer.eURIFragmentSegment(lastChild.eContainingFeature(), lastChild);
        String _plus = (_eURIFragmentSegment + "/");
        String _plus_1 = (_plus + result);
        result = _plus_1;
      }
    }
    return result;
  }
  
  /**
   * Finds an EObject for the given context EObject and fragment.
   * 
   * @param from the EObject from which the path should be resolved
   * @param toFragment the fragment
   * 
   * @return the resolved EObject based. If the given fragment is <code>null</null>, the given EObject itself will be returned.
   */
  public EObject getEObject(final EObject from, final String toFragment) {
    if ((toFragment == null)) {
      return from;
    }
    final Iterable<String> splitted = Splitter.on("/").split(toFragment);
    final Function2<EObject, String, EObject> _function = (EObject $0, String $1) -> {
      return ((InternalEObject) $0).eObjectForURIFragmentSegment($1);
    };
    return IterableExtensions.<String, EObject>fold(splitted, from, _function);
  }
}
