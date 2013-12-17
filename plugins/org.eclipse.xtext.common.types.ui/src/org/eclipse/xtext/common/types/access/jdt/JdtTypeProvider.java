/*******************************************************************************
 * Copyright (c) 2009-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.ShadowedTypeException;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JdtTypeProvider extends AbstractJvmTypeProvider implements IJdtTypeProvider {
	
	private final static Logger LOG = Logger.getLogger(JdtTypeProvider.class);

	private static final String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI.segment(0);

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
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess, WorkingCopyOwner workingCopyOwner) {
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
		String signature = getSignature(name);
		if (signature == null)
			return null;
		URI resourceURI = typeUriHelper.createResourceURI(signature);
		if (resourceURI.segment(0) == PRIMITIVES) {
			return findPrimitiveType(signature, resourceURI);
		} else {
			return findObjectType(signature, resourceURI);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	public JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		JvmType result = findTypeByName(name);
		if (result != null || isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return result;
		}
		ClassNameVariants nameVariants = new ClassNameVariants(name);
		while (result == null && nameVariants.hasNext()) {
			String nextVariant = nameVariants.next();
			result = findTypeByName(nextVariant);
		}
		return result;
	}

	@Nullable
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

	@Nullable
	private JvmType findObjectType(@NonNull String signature, @NonNull URI resourceURI) {
		TypeResource resource = getLoadedResourceForJavaURI(resourceURI);
		try {
			JvmType result = findLoadedOrDerivedObjectType(signature, resourceURI, resource);
			if (result != null || resource != null) {
				if (result != null && !canLink(result.getQualifiedName())) {
					return null;
				}
				return result;
			}
			try {
				return findObjectTypeInJavaProject(signature, resourceURI);
			} catch (JavaModelException e) {
				return null;
			} catch (NullPointerException e) { // JDT throws NPEs see https://bugs.eclipse.org/bugs/show_bug.cgi?id=369391
				return null;
			}
		} catch (ShadowedTypeException e) {
			return null;
		}
	}

	@Nullable
	private JvmType findLoadedOrDerivedObjectType(@NonNull String signature, @NonNull URI resourceURI,
			@Nullable TypeResource resource) {
		JvmType result = resource != null ? findTypeBySignature(signature, resource) : null;
		if (result != null) {
			return result;
		}
		result = findObjectTypeInIndex(signature, resourceURI);
		if (result != null) {
			return result;
		}
		return null;
	}

	@Nullable
	private JvmType findObjectTypeInJavaProject(@NonNull String signature, @NonNull URI resourceURI)
			throws JavaModelException {
		IType type = findObjectTypeInJavaProject(resourceURI);
		if (type != null) {
			try {
				return createResourceAndFindType(resourceURI, type, signature);
			} catch (IOException ioe) {
				return null;
			} catch (WrappedException wrapped) {
				if (wrapped.getCause() instanceof IOException) {
					return null;
				}
				throw wrapped;
			}
		}
		return null;
	}

	@Nullable
	private JvmType createResourceAndFindType(@NonNull URI resourceURI, @NonNull IType type, @NonNull String signature)
			throws IOException {
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
	
	private IType findObjectTypeInJavaProject(@NonNull URI resourceURI) throws JavaModelException {
		String topLevelType = resourceURI.segment(resourceURI.segmentCount() - 1);
		int lastDot = topLevelType.lastIndexOf('.');
		String packageName = null;
		String typeName = topLevelType;
		if (lastDot != -1) {
			typeName = typeName.substring(lastDot + 1);
			packageName = topLevelType.substring(0, lastDot);
		}
		IType type = javaProject.findType(packageName, typeName /*, workingCopyOwner */);
		if (type != null && !canLink(type.getFullyQualifiedName())) {
			return null;
		}
		return type;
	}

	private boolean canLink(String typeName) {
		if (typeName == null) {
			return false;
		}
		IndexedJvmTypeAccess indexedJvmTypeAccess = this.getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null && indexedJvmTypeAccess.isIndexingPhase(getResourceSet())) {
			// during indexing we don't see project local types.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=410594
			try {
				IType type = javaProject.findType(typeName);
				if (type != null && type.exists()) {
					IResource underlyingResource = type.getUnderlyingResource();
					if (underlyingResource == null) {
						return true;
					}
					for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots()) {
						if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
							IResource srcUnderlyingResource = root.getUnderlyingResource();
							if (srcUnderlyingResource != null && srcUnderlyingResource.contains(underlyingResource)) {
								return false;
							}
						}
					}
					return true;
				}
			} catch (JavaModelException e) {
				LOG.error(e.getMessage(), e);
			}
			return false;
		}
		return true;
	}

	private JvmType findObjectTypeInIndex(@NonNull String signature, @NonNull URI resourceURI) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(typeUriHelper.getFragment(signature));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet(), true);
			if (candidate instanceof JvmType) {
				return (JvmType) candidate;
			}
		}
		return null;
	}

	@Nullable
	private TypeResource getLoadedResourceForJavaURI(@NonNull URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, false);
		return resource;
	}

	private JvmType findPrimitiveType(@NonNull String signature, @NonNull URI resourceURI) {
		TypeResource resource = (TypeResource) getResourceForJavaURI(resourceURI, true);
		JvmType result = findTypeBySignature(signature, resource);
		return result;
	}

	/**
	 * @since 2.3
	 */
	protected Resource getResourceForJavaURI(@NonNull URI resourceURI, boolean loadOnDemand) {
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
		} catch (JavaModelException e) {
			return null;
		}
	}

	@Nullable
	private IMirror createMirror(@NonNull IType type) {
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
	
	public JdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
