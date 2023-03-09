/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Streams;
import com.google.inject.Inject;

/**
 * Portable URIs are based on names and therefore are independent of the concrete file paths and file names of the
 * resources.
 * 
 * A portable URI is really a resource URI to the client URI and a fragment that contains the information to retrieve
 * the referenced element using the global scoping. That is it contains
 * <ul>
 * <li>the qualified name of a container of the target element
 * <li>the type of that container
 * <li>the path from that container to the actual target element
 * </ul>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class PortableURIs {

	public static class PortableFragmentDescription {
		private final EClass descriptionEClass;

		private final QualifiedName descriptionQualifiedName;

		private final String descriptionRelativeFragment;

		public PortableFragmentDescription(EClass descriptionEClass, QualifiedName descriptionQualifiedName,
				String descriptionRelativeFragment) {
			this.descriptionEClass = descriptionEClass;
			this.descriptionQualifiedName = descriptionQualifiedName;
			this.descriptionRelativeFragment = descriptionRelativeFragment;
		}

		public EClass getDescriptionEClass() {
			return descriptionEClass;
		}

		public QualifiedName getDescriptionQualifiedName() {
			return descriptionQualifiedName;
		}

		public String getDescriptionRelativeFragment() {
			return descriptionRelativeFragment;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((descriptionEClass == null) ? 0 : descriptionEClass.hashCode());
			result = prime * result + ((descriptionQualifiedName == null) ? 0 : descriptionQualifiedName.hashCode());
			result = prime * result
					+ ((descriptionRelativeFragment == null) ? 0 : descriptionRelativeFragment.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PortableFragmentDescription other = (PortableFragmentDescription) obj;
			if (descriptionEClass == null) {
				if (other.descriptionEClass != null)
					return false;
			} else if (!descriptionEClass.equals(other.descriptionEClass))
				return false;
			if (descriptionQualifiedName == null) {
				if (other.descriptionQualifiedName != null)
					return false;
			} else if (!descriptionQualifiedName.equals(other.descriptionQualifiedName))
				return false;
			if (descriptionRelativeFragment == null) {
				if (other.descriptionRelativeFragment != null)
					return false;
			} else if (!descriptionRelativeFragment.equals(other.descriptionRelativeFragment))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PortableFragmentDescription [descriptionEClass=" + descriptionEClass + ", descriptionQualifiedName="
					+ descriptionQualifiedName + ", descriptionRelativeFragment=" + descriptionRelativeFragment + "]";
		}

	}

	public static final String PORTABLE_SCHEME = "portable";

	@Inject
	private IGlobalScopeProvider globalScopeProvider;

	@Inject
	private EPackage.Registry packageRegistry;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	/**
	 * @return whether the given string is a portable URI fragment
	 */
	public boolean isPortableURIFragment(String uriFragment) {
		return uriFragment.startsWith(PortableURIs.PORTABLE_SCHEME);
	}

	/**
	 * Resolves a given portable URI fragment against the given resource.
	 * 
	 * @param resource
	 *            the resource from which global scope to look up the EObject
	 * @param portableFragment
	 *            the portable fragment pointing to the to be resolved EObject
	 * 
	 * @return the EObject for the given portableURIFragment
	 */
	public EObject resolve(StorageAwareResource resource, String portableFragment) {
		PortableURIs.PortableFragmentDescription desc = fromFragmentString(portableFragment);
		EReference mock = EcoreFactory.eINSTANCE.createEReference();
		mock.setEType(desc.descriptionEClass);
		IScope scope = globalScopeProvider.getScope(resource, mock, Predicates.<IEObjectDescription>alwaysTrue());
		Optional<IEObjectDescription> description = Streams.stream( //
				scope.getElements(desc.descriptionQualifiedName)).findFirst();
		return description.map(d -> {
			EObject container = EcoreUtil.resolve(d.getEObjectOrProxy(), resource);
			return getEObject(container, desc.descriptionRelativeFragment);
		}).orElse(null);
	}

	/**
	 * Creates and returns a portable URI from the given resource to the targetURI. Returns <code>null</code> if no
	 * portable URI can be constructed, which is the case if the targetObject is not itself exported or is a child of an
	 * exported EObject.
	 * 
	 * @param sourceResource
	 *            the resource from which the EObject should later be resolved
	 * @param targetURI
	 *            the target URI that should be resolvable by the created portable URI
	 * 
	 * @return a portable URI or <code>null</code>
	 */
	public URI toPortableURI(StorageAwareResource sourceResource, URI targetURI) {
		EObject object = sourceResource.getResourceSet().getEObject(targetURI, false);
		// if it points to some registered ecore, there's no resourceSet and the result is not portable
		if (object == null || object.eResource().getResourceSet() != null) {
			return toPortableURI(sourceResource, object);
		}
		return null;
	}

	/**
	 * Creates and returns a portable URI from the global scope. Returns <code>null</code> if no portable URI can be
	 * constructed, which is the case if the targetObject is not itself exported or is a child of an exported EObject.
	 * 
	 * @param sourceResource
	 *            the resource from which the EObject should later be resolved
	 * @param targetObject
	 *            the target object that should be resolvable by the created portable URI
	 * 
	 * @return a portable URI or <code>null</code>
	 */
	public URI toPortableURI(StorageAwareResource sourceResource, EObject targetObject) {
		if (targetObject == null || targetObject.eIsProxy()) {
			return sourceResource.getURI().appendFragment(StorageAwareResource.UNRESOLVABLE_FRAGMENT);
		}
		String portableFragment = getPortableURIFragment(targetObject);
		if (portableFragment != null) {
			return sourceResource.getURI().appendFragment(portableFragment);
		}
		return null;
	}

	/**
	 * @return a portable URI fragment, or <code>null</code> if the give EObject isn't itself or is not contained in an
	 *         exported EObjectDescription
	 */
	protected String getPortableURIFragment(EObject obj) {
		IResourceDescriptions descriptions = resourceDescriptionsProvider.getResourceDescriptions(obj.eResource());
		IResourceDescription desc = descriptions.getResourceDescription(obj.eResource().getURI());
		if (desc == null) {
			return null;
		}
		return Streams.stream(desc.getExportedObjects()).filter(description -> {
			EObject possibleContainer = EcoreUtil.resolve(description.getEObjectOrProxy(), obj.eResource());
			return EcoreUtil.isAncestor(obj, possibleContainer);
		}).map(containerDesc -> {
			PortableFragmentDescription fragmentDescription = createPortableFragmentDescription(containerDesc, obj);
			return toFragmentString(fragmentDescription);
		}).findFirst().orElse(null);
	}

	protected PortableURIs.PortableFragmentDescription createPortableFragmentDescription(IEObjectDescription desc,
			EObject target) {
		EObject possibleContainer = EcoreUtil.resolve(desc.getEObjectOrProxy(), target);
		String fragmentToTarget = getFragment(target, possibleContainer);
		return new PortableURIs.PortableFragmentDescription(desc.getEClass(), desc.getQualifiedName(),
				fragmentToTarget);
	}

	protected String toFragmentString(PortableURIs.PortableFragmentDescription desc) {
		String eclassUriAsString = URI.encodeFragment(EcoreUtil.getURI(desc.descriptionEClass).toString(), false);
		List<String> segments = desc.descriptionQualifiedName.getSegments();
		String uriFragment = PortableURIs.PORTABLE_SCHEME + "#" + eclassUriAsString + "#"
				+ URI.encodeFragment(Joiner.on(':').join(segments), false);
		if (desc.descriptionRelativeFragment != null) {
			uriFragment += "#" + URI.encodeFragment(desc.descriptionRelativeFragment, false);
		}
		return uriFragment;
	}

	protected PortableURIs.PortableFragmentDescription fromFragmentString(String fragmentString) {
		Iterator<String> segments = Splitter.on("#").split(fragmentString).iterator();
		segments.next(); // skip first
		URI eClassURI = URI.createURI(URI.decode(segments.next()));
		EPackage ePackage = this.packageRegistry.getEPackage(eClassURI.trimFragment().toString());
		EClass eClass = EcorePackage.Literals.EOBJECT;
		if (ePackage != null) {
			Resource resource = ePackage.eResource();
			if (resource != null) {
				eClass = (EClass) resource.getEObject(eClassURI.fragment());
			}
		}
		QualifiedName qname = QualifiedName.create(Splitter.on(":").splitToList(URI.decode(segments.next())));
		String fragment = segments.hasNext() ? URI.decode(segments.next()) : null;
		return new PortableURIs.PortableFragmentDescription(eClass, qname, fragment);
	}

	/**
	 * Computes a fragment to the child relative from the given container.
	 * 
	 * @param fromContainer
	 *            the container EObject from which the fragment path is computed
	 * @param toChild
	 *            the target EObject which can be found using the fromContainer and resulting fragment path
	 * 
	 * @return a fragment path from the given container to the child, or <code>null</null> is fromContainer == toChild
	 * 
	 * @see #getEObject(EObject,String)
	 * @throws IllegalArgumentException if the child is not a child of the given container.
	 */
	public String getFragment(EObject fromContainer, EObject toChild) throws IllegalArgumentException {
		return Strings.emptyToNull(EcoreUtil.getRelativeURIFragmentPath(fromContainer, toChild));
	}

	/**
	 * Finds an EObject for the given context EObject and fragment.
	 * 
	 * @param from
	 *            the EObject from which the path should be resolved
	 * @param toFragment
	 *            the fragment
	 * 
	 * @return the resolved EObject based. If the given fragment is <code>null</null>, the given EObject itself will be
	 *         returned.
	 */
	public EObject getEObject(EObject from, String toFragment) {
		if (toFragment == null) {
			return from;
		}
		return EcoreUtil.getEObject(from, toFragment);
	}
}
