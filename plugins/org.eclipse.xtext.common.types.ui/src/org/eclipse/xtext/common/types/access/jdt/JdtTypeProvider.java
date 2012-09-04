/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeProvider extends AbstractJvmTypeProvider implements IJdtTypeProvider {
	
	private final IJavaProject javaProject;

	private final TypeURIHelper typeUriHelper;

	private final JdtBasedTypeFactory typeFactory;

	private final WorkingCopyOwner workingCopyOwner;
	
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		this(javaProject, resourceSet, null);
	}
	
	/**
	 * @since 2.1
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this(javaProject, resourceSet, indexedJvmTypeAccess, null);
	}
	
	/**
	 * @since 2.4
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess, WorkingCopyOwner workingCopyOwner) {
		super(resourceSet, indexedJvmTypeAccess);
		if (javaProject == null)
			throw new IllegalArgumentException("javaProject may not be null");
		this.javaProject = javaProject;
		this.typeUriHelper = createTypeURIHelper();
		this.workingCopyOwner = workingCopyOwner;
		this.typeFactory = createTypeFactory();
	}
	
	protected JdtBasedTypeFactory createTypeFactory() {
		return new JdtBasedTypeFactory(typeUriHelper, workingCopyOwner);
	}

	protected TypeURIHelper createTypeURIHelper() {
		return new TypeURIHelper();
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		if (Strings.isEmpty(name))
			throw new IllegalArgumentException("null");
		String signature = null;
		try {
			signature = name.startsWith("[") ? name : Signature.createTypeSignature(name, true);
		} catch (IllegalArgumentException e) {
			return null;
		}
		URI resourceURI = typeUriHelper.createResourceURI(signature);
		String resourcePath = resourceURI.path();
		if (resourcePath.startsWith(URIHelperConstants.PRIMITIVES)) {
			TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, true);
			JvmType result = findTypeBySignature(signature, resource);
			return result;
		} else {
			TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, false);
			if (resource != null) {
				JvmType result = findTypeBySignature(signature, resource);
				return result;
			}
			IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
			if (indexedJvmTypeAccess != null) {
				URI proxyURI = resourceURI.appendFragment(typeUriHelper.getFragment(signature));
				EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet());
				if (candidate instanceof JvmType) {
					return (JvmType) candidate;
				}
			}
			String topLevelType = resourceURI.segment(resourceURI.segmentCount() - 1);
			try {
				int lastDot = topLevelType.lastIndexOf('.');
				String packageName = null;
				String typeName = topLevelType;
				if (lastDot != -1) {
					typeName = typeName.substring(lastDot + 1);
					packageName = topLevelType.substring(0, lastDot);
				}
				if (javaProject.findType(packageName, typeName) != null) {
					resource = (TypeResource) getResourceForJavaURI(resourceURI, true);
					JvmType result = findTypeBySignature(signature, resource);
					return result;
				} else {
					return null;
				}
			} catch (JavaModelException e) {
				return null;
			} catch (NullPointerException e) { // JDT throws NPEs see https://bugs.eclipse.org/bugs/show_bug.cgi?id=369391
				return null;
			}
		}
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
			IType type = javaProject.findType(name);
			if (type == null || !type.exists())
				return null;
			String elementName = type.getElementName();
			if (!elementName.equals(type.getTypeQualifiedName())) {
				// workaround for bug in jdt with binary type names that start with a $ dollar sign
				// e.g. $ImmutableList
				// it manifests itself in a way that allows to retrieve ITypes but one cannot obtain bindings for that type
				return null;
			}
			return new JdtTypeMirror(type, typeFactory);
		}
		catch (JavaModelException e) {
			return null;
		}
	}
	
	public IJavaProject getJavaProject() {
		return javaProject;
	}
	
	public TypeURIHelper getTypeUriHelper() {
		return typeUriHelper;
	}
	
	public JdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
