/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.common.base.Predicates
import com.google.common.base.Splitter
import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.scoping.IGlobalScopeProvider

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
class PortableURIs {
	
	public static val PORTABLE_SCHEME = "portable"
	
	@Inject IGlobalScopeProvider globalScopeProvider
	@Inject EPackage.Registry packageRegistry
	@Inject ResourceDescriptionsProvider resourceDescriptionsProvider
	
	/**
	 * @return whether the given string is a portable URI fragment
	 */
	def boolean isPortableURIFragment(String uriFragment) {
		uriFragment.startsWith(PORTABLE_SCHEME)
	}
	
	/**
	 * Resolves a given portable URI fragment against the given resource.
	 * 
	 * @param resource the resource from which global scope to look up the EObject
	 * @param portableFragment the portable fragment pointing to the to be resolved EObject
	 * 
	 * @return the EObject for the given portableURIFragment
	 */
	def EObject resolve(StorageAwareResource resource, String portableFragment) {
		val desc = fromFragmentString(portableFragment)
		val mock = EcoreFactory.eINSTANCE.createEReference
		mock.EType = desc.descriptionEClass
		val scope = globalScopeProvider.getScope(resource, mock, Predicates.alwaysTrue)
		val description = scope.getElements(desc.descriptionQualifiedName).head
		if (description === null) {
			return null
		}
		val container = EcoreUtil.resolve(description.EObjectOrProxy, resource)
		return getEObject(container, desc.descriptionRelativeFragment)
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
	def URI toPortableURI(StorageAwareResource sourceResource, URI targetURI) {
		val to = sourceResource.resourceSet.getResource(targetURI.trimFragment, false)?.getEObject(targetURI.fragment)
		// if it points to some registered ecore, there's no resourceSet and the result is not portable 
		if (to === null || to.eResource?.resourceSet !== null) {
			val result = toPortableURI(sourceResource, to);
			if (result !== null) {
				return result
			}
		}
		return null
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
	def URI toPortableURI(StorageAwareResource sourceResource, EObject targetObject) {
		if (targetObject === null || targetObject.eIsProxy) {
			return sourceResource.URI.appendFragment(StorageAwareResource.UNRESOLVABLE_FRAGMENT)
		}
		val portableFragment = getPortableURIFragment(targetObject)
		if (portableFragment !== null) {
			return sourceResource.URI.appendFragment(portableFragment)
		}
		return null
	}
	
	/**
	 * @return a portable URI fragment, or <code>null</code> if the give EObject isn't itself or is not contained in an exported EObjectDescription
	 */
	protected def String getPortableURIFragment(EObject obj) {
		val descriptions = resourceDescriptionsProvider.getResourceDescriptions(obj.eResource)
		val desc = descriptions.getResourceDescription(obj.eResource.URI)
		if (desc === null) {
			return null
		}
		val containerDesc = desc.exportedObjects.findFirst [
			val possibleContainer = EcoreUtil.resolve(EObjectOrProxy, obj.eResource)
			obj==possibleContainer || EcoreUtil.isAncestor(obj, possibleContainer)
		]
		if (containerDesc !== null) {
			val fragmentDescription = createPortableFragmentDescription(containerDesc, obj)
			return toFragmentString(fragmentDescription)
		}
		return null
	}
	
	protected def PortableFragmentDescription createPortableFragmentDescription(IEObjectDescription desc, EObject target) {
		val possibleContainer = EcoreUtil.resolve(desc.EObjectOrProxy, target)
		val fragmentToTarget = getFragment(target, possibleContainer)
		return new PortableFragmentDescription(desc.EClass, desc.qualifiedName, fragmentToTarget)
	}
	
	protected def String toFragmentString(PortableFragmentDescription desc) {
		val eclassUriAsString = URI.encodeFragment(EcoreUtil.getURI(desc.descriptionEClass).toString, false)
		val segments = desc.descriptionQualifiedName.segments
		var uriFragment = PORTABLE_SCHEME + '#' + eclassUriAsString + '#'+ URI.encodeFragment(segments.join(':'), false)
		if (desc.descriptionRelativeFragment !== null) {
			uriFragment += '#' + URI.encodeFragment(desc.descriptionRelativeFragment, false)
		}
		return uriFragment
	}
	
	protected def PortableFragmentDescription fromFragmentString(String fragmentString) {
		val segments = Splitter.on('#').split(fragmentString).iterator
		segments.next // skip first
		val eClassURI = URI.createURI(URI.decode(segments.next))
		val ePackage = packageRegistry.getEPackage(eClassURI.trimFragment.toString)
		val eClass = ePackage?.eResource?.getEObject(eClassURI.fragment) as EClass
		val qname = QualifiedName.create(Splitter.on(':').split(URI.decode(segments.next)).toList)
		val fragment = if (segments.hasNext) {
			URI.decode(segments.next)
		}
		return new PortableFragmentDescription(eClass?:EcorePackage.Literals.EOBJECT, qname, fragment)
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
	def String getFragment(EObject fromContainer, EObject toChild) {
		if (fromContainer == toChild)
			return null
		var lastChild = toChild as InternalEObject
		var lastContainer = lastChild.eInternalContainer
		var result = lastContainer.eURIFragmentSegment(lastChild.eContainingFeature, lastChild)
		while (lastContainer !== null && fromContainer != lastContainer) {
			lastChild = lastContainer
			lastContainer = lastContainer.eInternalContainer
			if (lastContainer === null) {
				throw new IllegalStateException("No more containers for element "+lastChild)
			}
			result = lastContainer.eURIFragmentSegment(lastChild.eContainingFeature, lastChild)+'/'+result
		}
		return result
	}
	
	/**
	 * Finds an EObject for the given context EObject and fragment.
	 * 
	 * @param from the EObject from which the path should be resolved
	 * @param toFragment the fragment
	 * 
	 * @return the resolved EObject based. If the given fragment is <code>null</null>, the given EObject itself will be returned.
	 */
	def EObject getEObject(EObject from, String toFragment) {
		if (toFragment === null)
			return from
		val splitted = Splitter.on("/").split(toFragment)
		return splitted.fold(from) [ 
			($0 as InternalEObject).eObjectForURIFragmentSegment($1)
		]
	}
	
	@Data static class PortableFragmentDescription {
		EClass descriptionEClass
		QualifiedName descriptionQualifiedName
		String descriptionRelativeFragment
	}
}
