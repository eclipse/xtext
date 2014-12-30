/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.linking.lazy.LazyURIEncoder

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
	@Inject LazyURIEncoder lazyURIencoder
	
	def boolean isPortableURIFragment(String uriFragment) {
		uriFragment.startsWith(PORTABLE_SCHEME)
	}
	
	def EObject resolve(StorageAwareResource resource, String portableFragment) {
		val desc = fromFragmentString(portableFragment)
		val mock = EcoreFactory.eINSTANCE.createEReference
		mock.EType = EcorePackage.Literals.EOBJECT
		val scope = globalScopeProvider.getScope(resource, mock, Predicates.alwaysTrue)
		val description = scope.getElements(desc.descriptionQualifiedName).findFirst[
			EClass.name == desc.descriptionEClassName
		]
		if (description == null) {
			return null
		}
		val container = EcoreUtil.resolve(description.EObjectOrProxy, resource)
		return getEObject(container, desc.descriptionRelativeFragment)
	}
	
	def URI toPortableURI(StorageAwareResource res, URI uri, String fragment) {
		if (res.URI == uri && lazyURIencoder.isCrossLinkFragment(res, fragment)) {
			// try resolve
			val result = res.getEObject(fragment)
			if (result==null || result.eIsProxy) {
				//this means it is an unresolvable lazy link, we won't be able to resolve it later
				return uri.appendFragment(StorageAwareResource.UNRESOLVABLE_FRAGMENT)
			} else {
				val portableFragment = getPortableURIFragment(result)
				if (portableFragment != null) {
					return res.URI.appendFragment(portableFragment)
				} 
			}
		}
		val resource = res.resourceSet.getResource(uri, false)
		if (resource != null) {
			val obj = resource.getEObject(fragment)
			if (obj != null) {
				val portableFragment = getPortableURIFragment(obj)
				if (portableFragment != null) {
					return res.URI.appendFragment(portableFragment)
				}
			}
		}
		return uri.appendFragment(fragment)
	}
	
	protected def String getPortableURIFragment(EObject obj) {
		switch res : obj.eResource {
			XtextResource : {
				val desc = res.resourceServiceProvider.resourceDescriptionManager.getResourceDescription(obj.eResource)
				val containerDesc = desc.exportedObjects.findFirst [
					val possibleContainer = EcoreUtil.resolve(EObjectOrProxy, res)
					obj==possibleContainer || EcoreUtil.isAncestor(obj, possibleContainer)
				]
				if (containerDesc != null) {
					val fragment = createPortableURIFragment(containerDesc, obj)
					return fragment
				}
			}
		}
		return null
	}
	
	protected def String createPortableURIFragment(IEObjectDescription desc, EObject target) {
		val possibleContainer = EcoreUtil.resolve(desc.EObjectOrProxy, target)
		val fragmentToTarget = getFragment(target, possibleContainer)
		val portableDescription = new PortableFragmentDescription(desc.EClass.name, desc.qualifiedName, fragmentToTarget)
		return toFragmentString(portableDescription)
	}
	
	protected def String toFragmentString(PortableFragmentDescription desc) {
		val typeName = desc.descriptionEClassName
		val segments = desc.descriptionQualifiedName.segments
		//TODO use safe delimiter algorithm (library)
		var uriFragment = PORTABLE_SCHEME + '#' + typeName + '#'+ segments.join(':')
		if (desc.descriptionRelativeFragment != null) {
			uriFragment += '#' + desc.descriptionRelativeFragment
		}
		return uriFragment
	}
	
	protected def PortableFragmentDescription fromFragmentString(String fragmentString) {
		val segments = Splitter.on('#').split(fragmentString).iterator
		segments.next // skip first
		val eClassName = segments.next
		val qname = QualifiedName.create(Splitter.on(':').split(segments.next).toList)
		val fragment = if (segments.hasNext) {
			segments.next
		}
		return new PortableFragmentDescription(eClassName, qname, fragment)
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
	public def String getFragment(EObject fromContainer, EObject toChild) {
		if (fromContainer == toChild)
			return null
		var lastChild = toChild as InternalEObject
		var lastContainer = lastChild.eInternalContainer
		var result = lastContainer.eURIFragmentSegment(lastChild.eContainingFeature, lastChild)
		while (lastContainer != null && fromContainer != lastContainer) {
			lastChild = lastContainer
			lastContainer = lastContainer.eInternalContainer
			if (lastContainer == null) {
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
	public def EObject getEObject(EObject from, String toFragment) {
		if (toFragment == null)
			return from
		val splitted = Splitter.on("/").split(toFragment)
		return splitted.fold(from) [ 
			($0 as InternalEObject).eObjectForURIFragmentSegment($1)
		]
	}
	
	@Data static class PortableFragmentDescription {
		String descriptionEClassName
		QualifiedName descriptionQualifiedName
		String descriptionRelativeFragment
	}
}