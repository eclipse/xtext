/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests.types;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeMirror;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OldJdtTypeProvider extends AbstractJvmTypeProvider implements IJdtTypeProvider {
	
	private final IJavaProject javaProject;

	private final TypeURIHelper typeUriHelper;

	private final OldJdtBasedTypeFactory typeFactory;

	private final WorkingCopyOwner workingCopyOwner;
	
	public OldJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		this(javaProject, resourceSet, null);
	}
	
	/**
	 * @since 2.1
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public OldJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this(javaProject, resourceSet, indexedJvmTypeAccess, null);
	}
	
	/**
	 * @since 2.4
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public OldJdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess, WorkingCopyOwner workingCopyOwner) {
		super(resourceSet, indexedJvmTypeAccess);
		if (javaProject == null)
			throw new IllegalArgumentException("javaProject may not be null");
		this.javaProject = javaProject;
		this.typeUriHelper = createTypeURIHelper();
		this.workingCopyOwner = workingCopyOwner;
		this.typeFactory = createTypeFactory();
	}
	
	protected OldJdtBasedTypeFactory createTypeFactory() {
		return new OldJdtBasedTypeFactory(typeUriHelper, workingCopyOwner);
	}

	protected TypeURIHelper createTypeURIHelper() {
		return new TypeURIHelper();
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		String signature = getSignature(name);
		URI resourceURI = typeUriHelper.createResourceURI(signature);
		String resourcePath = resourceURI.path();
		if (resourcePath.startsWith(URIHelperConstants.PRIMITIVES)) {
			return findPrimitiveType(signature, resourceURI);
		} else {
			return findObjectType(signature, resourceURI);
		}
	}
	
	private String getSignature(String name) {
		if (Strings.isEmpty(name))
			throw new IllegalArgumentException("null");
		String signature = null;
		try {
			signature = name.startsWith("[") ? name : Signature.createTypeSignature(name, true);
		} catch (IllegalArgumentException e) {
			return null;
		}
		return signature;
	}
	
	/**
	 * @since 2.4
	 */
	public Map<String, JvmType> findTypesByName(List<String> names) {
		if (names == null) {
			throw new IllegalArgumentException("null");
		}
		Map<String, JvmType> result = Maps.newHashMapWithExpectedSize(names.size());
		findTypesByName(names, result);
		return result;
	}

	private void findTypesByName(List<String> names, Map<String, JvmType> result) {
		List<TypeResource> toBeLoadedResources = Lists.newArrayList();
		List<String> signaturesAndNames = Lists.newArrayList();
		for(String name: names) {
			String signature = getSignature(name);
			URI resourceURI = typeUriHelper.createResourceURI(signature);
			String resourcePath = resourceURI.path();
			if (resourcePath.startsWith(URIHelperConstants.PRIMITIVES)) {
				result.put(name, findPrimitiveType(signature, resourceURI));
			} else {
				JvmType type = findLoadedOrDerivedObjectType(signature, resourceURI);
				if (type != null) {
					result.put(name, type);
				} else {
					if (scheduleLoadObjectType(resourceURI, toBeLoadedResources)) {
						signaturesAndNames.add(signature);
						signaturesAndNames.add(name);
					}
				}
			}
		}
		loadResources(toBeLoadedResources);
		for(int i = 0; i < signaturesAndNames.size(); i+=2) {
			String signature = signaturesAndNames.get(i);
			String name = signaturesAndNames.get(i + 1);
			TypeResource resource = toBeLoadedResources.get(i / 2);
			JvmType type = findTypeBySignature(signature, resource);
			result.put(name, type);
		}
	}
	
	private void loadResources(List<TypeResource> resources) {
		List<IType> types = Lists.newArrayList();
		for(TypeResource resource: resources) {
			JdtTypeMirror mirror = (JdtTypeMirror) resource.getMirror();
			types.add(mirror.getMirroredType());
		}
		List<JvmDeclaredType> producedTypes = typeFactory.createTypes(types, javaProject);
		for(int i = 0; i < types.size(); i++) {
			TypeResource resource = resources.get(i);
			JvmDeclaredType producedType = producedTypes.get(i);
			JdtTypeMirror mirror = (JdtTypeMirror) resource.getMirror();
			mirror.initialize(resource, producedType);
			resource.setLoaded(true);
		}
	}
	
	private boolean scheduleLoadObjectType(URI resourceURI, List<TypeResource> result) {
		try {
			IType jdtType = findObjectTypeInJavaProject(resourceURI);
			if (jdtType != null) {
				TypeResource resource = createResource(resourceURI, jdtType);
				if (resource != null && resource.getMirror() != null) {
					result.add(resource);
					return true;
				}
			}
		} catch(JavaModelException e) {
			// ignore
		}
		return false;
	}

	private JvmType findObjectType(String signature, URI resourceURI) {
		JvmType result = findLoadedOrDerivedObjectType(signature, resourceURI);
		if (result != null) {
			return result;
		}
		try {
			return findObjectTypeInJavaProject(signature, resourceURI);
		} catch (JavaModelException e) {
			return null;
		} catch (NullPointerException e) { // JDT throws NPEs see https://bugs.eclipse.org/bugs/show_bug.cgi?id=369391
			return null;
		}
	}

	private JvmType findLoadedOrDerivedObjectType(String signature, URI resourceURI) {
		JvmType result = findObjectTypeInResourceSet(signature, resourceURI);
		if (result != null) {
			return result;
		}
		result = findObjectTypeInIndex(signature, resourceURI);
		if (result != null) {
			return result;
		}
		return null;
	}

	private JvmType findObjectTypeInJavaProject(String signature, URI resourceURI) throws JavaModelException {
		IType type = findObjectTypeInJavaProject(resourceURI);
		if (type != null) {
			try {
				return createResourceAndFindType(resourceURI, type, signature);
			} catch(IOException ioe) {
				return null;
			} catch(WrappedException wrapped) {
				if (wrapped.getCause() instanceof IOException) {
					return null;
				}
				throw wrapped;
			}
		} 
		return null;
	}

	private JvmType createResourceAndFindType(URI resourceURI, IType type, String signature) throws IOException {
		TypeResource resource = createResource(resourceURI, type);
		resource.load(null);
		return findTypeBySignature(signature, resource);
	}

	private TypeResource createResource(URI resourceURI, IType type) {
		TypeResource resource = new TypeResource(resourceURI);
		resource.setIndexedJvmTypeAccess(getIndexedJvmTypeAccess());
		getResourceSet().getResources().add(resource);
		if (type.exists()) {
			IMirror mirror = createMirror(type);
			resource.setMirror(mirror);
		}
		return resource;
	}
	
	private IType findObjectTypeInJavaProject(URI resourceURI) throws JavaModelException {
		String topLevelType = resourceURI.segment(resourceURI.segmentCount() - 1);
		int lastDot = topLevelType.lastIndexOf('.');
		String packageName = null;
		String typeName = topLevelType;
		if (lastDot != -1) {
			typeName = typeName.substring(lastDot + 1);
			packageName = topLevelType.substring(0, lastDot);
		}
		IType type = javaProject.findType(packageName, typeName /*, workingCopyOwner */);
		return type;
	}

	private JvmType findObjectTypeInIndex(String signature, URI resourceURI) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(typeUriHelper.getFragment(signature));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet());
			if (candidate instanceof JvmType) {
				return (JvmType) candidate;
			}
		}
		return null;
	}

	private JvmType findObjectTypeInResourceSet(String signature, URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, false);
		if (resource != null) {
			JvmType result = findTypeBySignature(signature, resource);
			return result;
		}
		return null;
	}

	private JvmType findPrimitiveType(String signature, URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, true);
		JvmType result = findTypeBySignature(signature, resource);
		return result;
	}

	/**
	 * @since 2.3
	 */
	protected Resource getResourceForJavaURI(URI resourceURI, boolean loadOnDemand) {
		return getResourceSet().getResource(resourceURI, loadOnDemand);
	}
	
	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmType findTypeBySignature(String signature, TypeResource resource) {
		// TODO: Maybe iterate the resource without computing a fragment
		String fragment = typeUriHelper.getFragment(signature);
		return (JvmType) resource.getEObject(fragment);
	}

	/**
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Override
	protected IMirror createMirrorForFQN(String name) {
		try {
			IType type = javaProject.findType(name /*, workingCopyOwner */);
			if (type == null || !type.exists())
				return null;
			return createMirror(type);
		}
		catch (JavaModelException e) {
			return null;
		}
	}

	private IMirror createMirror(IType type) {
		String elementName = type.getElementName();
		if (!elementName.equals(type.getTypeQualifiedName())) {
			// workaround for bug in jdt with binary type names that start with a $ dollar sign
			// e.g. $ImmutableList
			// it manifests itself in a way that allows to retrieve ITypes but one cannot obtain bindings for that type
			return null;
		}
		return new JdtTypeMirror(type, typeFactory);
	}
	
	public IJavaProject getJavaProject() {
		return javaProject;
	}
	
	public TypeURIHelper getTypeUriHelper() {
		return typeUriHelper;
	}
	
	public OldJdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
