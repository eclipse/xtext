/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.binary.signatures.SignatureURIHelper;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassReaderTypeProvider extends AbstractRuntimeJvmTypeProvider {

	private final BinaryClassFinder classFinder;
	
	private final ClassReaderTypeFactory typeFactory;
	
	private final SignatureURIHelper uriHelper;

	private final ClassLoader classLoader;
	
	public ClassReaderTypeProvider(ClassLoader classLoader, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(resourceSet, indexedJvmTypeAccess);
		this.classLoader = classLoader;
		classFinder = createClassFinder(classLoader);
		uriHelper = createSignatureURIHelper();
		typeFactory = createClassReaderTypeFactory(classLoader);
	}
	
	@Override
	protected void registerProtocol(ResourceSet resourceSet) {
		super.registerProtocol(resourceSet);
		final URIConverter existing = resourceSet.getURIConverter();
		resourceSet.setURIConverter(new ExtensibleURIConverterImpl() {
			@Override
			public URI normalize(URI uri) {
				if (URIHelperConstants.PROTOCOL.equals(uri.scheme())) {
					String qualifiedName = uri.lastSegment();
					if (qualifiedName.lastIndexOf('$') != -1) {
						String outermostClassName = new BinaryClass(qualifiedName, classLoader).getOutermostClassName();
						return URIHelperConstants.OBJECTS_URI.appendSegment(outermostClassName);
					}
					return uri;
				}
				return existing.normalize(uri);
			}

			@Override
			public EList<URIHandler> getURIHandlers() {
				return existing.getURIHandlers();
			}

			@Override
			public URIHandler getURIHandler(URI uri) {
				return existing.getURIHandler(uri);
			}

			@Override
			public EList<ContentHandler> getContentHandlers() {
				return existing.getContentHandlers();
			}

			@Override
			public OutputStream createOutputStream(URI uri) throws IOException {
				return existing.createOutputStream(uri);
			}

			@Override
			public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
				return existing.createOutputStream(uri, options);
			}

			@Override
			public InputStream createInputStream(URI uri) throws IOException {
				return existing.createInputStream(uri);
			}

			@Override
			public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
				return existing.createInputStream(uri, options);
			}

			@Override
			public void delete(URI uri, Map<?, ?> options) throws IOException {
				existing.delete(uri, options);
			}

			@Override
			public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
				return existing.contentDescription(uri, options);
			}

			@Override
			public boolean exists(URI uri, Map<?, ?> options) {
				return existing.exists(uri, options);
			}

			@Override
			public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
				return existing.getAttributes(uri, options);
			}

			@Override
			public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
				existing.setAttributes(uri, attributes, options);
			}

			@Override
			public Map<URI, URI> getURIMap() {
				return existing.getURIMap();
			}
			
		});
	}
	
	protected BinaryClassFinder createClassFinder(ClassLoader classLoader) {
		return new BinaryClassFinder(classLoader);
	}

	protected ClassReaderTypeFactory createClassReaderTypeFactory(ClassLoader classLoader) {
		return new ClassReaderTypeFactory(uriHelper, classLoader);
	}

	protected SignatureURIHelper createSignatureURIHelper() {
		return new SignatureURIHelper();
	}
	
	public SignatureURIHelper getSignatureURIHelper() {
		return uriHelper;
	}
	
	public ClassReaderTypeFactory getTypeFactory() {
		return typeFactory;
	}

	public BinaryClassFinder getClassFinder() {
		return classFinder;
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		try {
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily the best
			BinaryClass clazz = classFinder.forName(name);
			return findTypeByClass(clazz);
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, true);
		}
	}
	
	@Override
	public TypeResource createResource(URI uri) {
		String qualifiedName = uri.lastSegment();
		if (qualifiedName.lastIndexOf('$') != -1) {
			String outermostClassName = new BinaryClass(qualifiedName, classLoader).getOutermostClassName();
			return super.createResource(URIHelperConstants.OBJECTS_URI.appendSegment(outermostClassName));
		}
		return super.createResource(uri);
	}

	@Override
	public JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		if (isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return findTypeByName(name);
		}
		return doFindTypeByName(name);
	}

	private JvmType doFindTypeByName(String name) {
		try {
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily the best
			BinaryClass clazz = findClassByName(name);
			return findTypeByClass(clazz);
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, false);
		}
	}

	private JvmType findTypeByClass(BinaryClass clazz) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		URI resourceURI = uriHelper.createResourceURI(clazz);
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(uriHelper.getFragment(clazz));
			EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet());
			if (candidate instanceof JvmType)
				return (JvmType) candidate;
		}
		TypeResource result = (TypeResource) getResourceSet().getResource(resourceURI, true);
		return findTypeByClass(clazz, result);
	}

	private BinaryClass findClassByName(String name) throws ClassNotFoundException {
		try {
			BinaryClass clazz = classFinder.forName(name);
			return clazz;
		} catch(ClassNotFoundException exception) {
			int index = name.lastIndexOf('.');
			if (index <= 0) {
				throw exception;
			}
			String baseName = name.substring(0, index);
			try {
				BinaryClass resolvedOuterClass = findClassByName(baseName);
				baseName = resolvedOuterClass.getName();
			} catch (ClassNotFoundException baseNameException) {
				throw exception;
			}
			BinaryClass clazz = classFinder.forName(baseName + '$' + name.substring(index + 1));
			return clazz;
		}
	}

	protected JvmType tryFindTypeInIndex(String name, boolean binaryNestedTypeDelimiter) {
		TypeInResourceSetAdapter adapter = (TypeInResourceSetAdapter) EcoreUtil.getAdapter(getResourceSet().eAdapters(), TypeInResourceSetAdapter.class);
		if (adapter != null) {
			return adapter.tryFindTypeInIndex(name, this, binaryNestedTypeDelimiter);
		} else {
			return doTryFindInIndex(name, binaryNestedTypeDelimiter);
		}
	}

	@Override
	protected IMirror createMirrorForFQN(String name) {
		try {
			BinaryClass clazz = classFinder.forName(name);
			return createMirror(clazz);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public BinaryClassMirror createMirror(BinaryClass clazz) {
		return BinaryClassMirror.createClassMirror(clazz, typeFactory);
	}
	
	public JvmType findTypeByClass(BinaryClass clazz, Resource resource) {
		// TODO: Maybe iterate the resource without computing a fragment
		String fragment = uriHelper.getFragment(clazz);
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		} 
		return result;
	}

}
