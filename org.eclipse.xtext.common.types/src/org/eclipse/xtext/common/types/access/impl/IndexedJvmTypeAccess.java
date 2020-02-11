/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Splitter;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IndexedJvmTypeAccess {
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	@Inject
	private CompilerPhases compilerPhases;
	
	@Inject
	InnerClassNameVariants innerClassNameVariants;

	public boolean isIndexingPhase(Notifier notifier) {
		return compilerPhases.isIndexing(notifier);
	}
	
	/**
	 * Locate and resolve a {@link JvmType} in the context of the given resource set. It'll try to
	 * decode the qualified name from the URI and find an instance with that name in the {@link IResourceDescriptions
	 * index}. Short-circuits to a resource that is already available in the resource set.
	 * 
	 * @param javaObjectURI
	 *            the uri of the to-be-loaded instance. It is expected to be a Java-scheme URI. May not be
	 *            <code>null</code>.
	 * @param resourceSet
	 *            the context resource set. May not be <code>null</code>.
	 * @return the located instance. May be <code>null</code>.
	 */
	public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet) throws UnknownNestedTypeException {
		return getIndexedJvmType(javaObjectURI, resourceSet, false);
	}
	
	public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet, boolean throwShadowedException) throws UnknownNestedTypeException {
		if (resourceSet != null) {
			URI withoutFragment = javaObjectURI.trimFragment();
			if (resourceSet instanceof ResourceSetImpl) {
				// if the resource uri is already available in the resource set, try to find it directly
				Map<URI, Resource> resourceMap = ((ResourceSetImpl) resourceSet).getURIResourceMap();
				if (resourceMap != null && resourceMap.containsKey(withoutFragment)) {
					EObject result = resourceSet.getEObject(javaObjectURI, true);
					if (result != null) {
						return result;
					}
				}
			}
			String fqn = withoutFragment.segment(withoutFragment.segmentCount() - 1);
			final String base = fqn;
			Iterator<String> variants = innerClassNameVariants.variantsFor(base);
			EObject jvmType = null;
			while (jvmType == null && variants.hasNext()) {
				fqn = variants.next();
				List<String> fqnSegments = Strings.split(fqn, '.');
				QualifiedName qualifiedName = QualifiedName.create(fqnSegments);
				jvmType = getIndexedJvmType(qualifiedName, javaObjectURI.fragment(), resourceSet, throwShadowedException);
			}
			return jvmType;
		}
		return null;
	}
	
	public EObject getIndexedJvmType(QualifiedName qualifiedName, String fragment, ResourceSet resourceSet) throws UnknownNestedTypeException {
		return getIndexedJvmType(qualifiedName, fragment, resourceSet, false);
	}
	
	public EObject getIndexedJvmType(QualifiedName qualifiedName, String fragment, ResourceSet resourceSet, boolean throwShadowedException) throws UnknownNestedTypeException {
		if (resourceSet != null) {
			IResourceDescriptions descriptions = resourceDescriptionsProvider.getResourceDescriptions(resourceSet);
			Iterable<IEObjectDescription> candidates = descriptions.getExportedObjects(TypesPackage.Literals.JVM_TYPE, qualifiedName, false);
			Iterator<IEObjectDescription> iterator = candidates.iterator();
			if (iterator.hasNext()) {
				EObject result = findAccessibleType(fragment, resourceSet, iterator);
				if (result != null) {
					return result;
				}
			}
			if (throwShadowedException && descriptions instanceof IShadowedResourceDescriptions) {
				if (((IShadowedResourceDescriptions) descriptions).isShadowed(TypesPackage.Literals.JVM_TYPE, qualifiedName, false)) {
					throw new ShadowedTypeException("The type '"+qualifiedName+"' is locally shadowed.");
				}
			}
		}
		return null;
	}

	/**
	 * Returns the first type that was found in the index. May be overridden to honor visibility semantics.
	 * The given iterator is never empty.
	 * @since 2.8
	 */
	protected EObject findAccessibleType(String fragment, ResourceSet resourceSet, Iterator<IEObjectDescription> fromIndex) throws UnknownNestedTypeException {
		IEObjectDescription description = fromIndex.next();
		return getAccessibleType(description, fragment, resourceSet);
	}

	/**
	 * Read and resolve the EObject from the given description and navigate to its children according
	 * to the given fragment.
	 * @since 2.8
	 */
	protected EObject getAccessibleType(IEObjectDescription description, String fragment, ResourceSet resourceSet) throws UnknownNestedTypeException {
		EObject typeProxy = description.getEObjectOrProxy();
		if (typeProxy.eIsProxy()) {
			typeProxy = EcoreUtil.resolve(typeProxy, resourceSet);
		}
		if (!typeProxy.eIsProxy() && typeProxy instanceof JvmType) {
			if (fragment != null) {
				EObject result = resolveJavaObject((JvmType) typeProxy, fragment);
				if (result != null)
					return result;
			} else
				return typeProxy;
		}
		return null;
	}
	
	/**
	 * Locate a locale type with the given fragment. Does not consider types that
	 * are defined in operations or constructors as inner classes.
	 */
	public EObject resolveJavaObject(JvmType rootType, String fragment) throws UnknownNestedTypeException {
		if (fragment.endsWith("[]")) {
			return resolveJavaArrayObject(rootType, fragment);
		}
		int slash = fragment.indexOf('/'); 
		if (slash != -1) {
			if (slash == 0)
				return null;
			String containerFragment = fragment.substring(0, slash);
			EObject container = resolveJavaObject(rootType, containerFragment);
			if (container != null) {
				String parameterName = fragment.substring(slash + 1);
				if (container instanceof JvmTypeParameterDeclarator) {
					JvmTypeParameterDeclarator executable = (JvmTypeParameterDeclarator) container;
					for(JvmTypeParameter parameter: executable.getTypeParameters()) {
						if (parameter.getName().equals(parameterName))
							return parameter;
					}
				} 
			}
		} else {
			if (rootType.getIdentifier().equals(fragment)) {
				return rootType;
			}
			if (!fragment.startsWith(rootType.getIdentifier())) {
				return null;
			}
			int rootNameLength = rootType.getIdentifier().length();
			char sep = fragment.charAt(rootNameLength);
			Iterator<String> iter = Splitter.on(sep).split(fragment.substring(rootNameLength+1)).iterator();
			JvmDeclaredType current = (JvmDeclaredType) rootType;
			while (iter.hasNext()) {
				String segment = iter.next();
				Iterator<JvmDeclaredType> members = current.findAllNestedTypesByName(segment).iterator();
				if (members.hasNext()) {
					current = members.next();
				} else {
					throw new UnknownNestedTypeException("Couldn't resolve nested type for "+rootType.getIdentifier()+" and fragment "+fragment);
				}
			}
			return current;
		}
		return null;	
	}

	public EObject resolveJavaArrayObject(JvmType rootType, String fragment) throws UnknownNestedTypeException {
		JvmComponentType component = (JvmComponentType) resolveJavaObject(rootType, fragment.substring(0, fragment.length() - 2));
		if (component == null)
			return null;
		return component.getArrayType();
	}

	@SuppressWarnings("serial")
	public static class ShadowedTypeException extends RuntimeException {
		public ShadowedTypeException() {
			super();
		}
		public ShadowedTypeException(String message) {
			super(message);
		}
	}
	
	/**
	 * This exception is raised if a matching top level type was found in the index but there is no nested type
	 * with the requested name.
	 */
	@SuppressWarnings("serial")
	public static class UnknownNestedTypeException extends RuntimeException {
		public UnknownNestedTypeException() {
			super();
		}
		public UnknownNestedTypeException(String message) {
			super(message);
		}
	}
}
