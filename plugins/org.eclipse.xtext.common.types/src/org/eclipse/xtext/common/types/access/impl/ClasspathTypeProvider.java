/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassFinder;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProvider extends AbstractRuntimeJvmTypeProvider {

	private static class JavaURIConverter implements URIConverter {
		private final URIConverter existing;
		private ClassLoader classLoader;

		private JavaURIConverter(URIConverter existing) {
			this.existing = existing;
		}

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

		public Map<URI, URI> getURIMap() {
			return existing.getURIMap();
		}

		public EList<URIHandler> getURIHandlers() {
			return existing.getURIHandlers();
		}

		public URIHandler getURIHandler(URI uri) {
			return existing.getURIHandler(uri);
		}

		public EList<ContentHandler> getContentHandlers() {
			return existing.getContentHandlers();
		}

		public InputStream createInputStream(URI uri) throws IOException {
			return existing.createInputStream(uri);
		}

		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			return existing.createInputStream(uri, options);
		}

		public OutputStream createOutputStream(URI uri) throws IOException {
			return existing.createOutputStream(uri);
		}

		public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
			return existing.createOutputStream(uri, options);
		}

		public void delete(URI uri, Map<?, ?> options) throws IOException {
			existing.delete(uri, options);
		}

		public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
			return existing.contentDescription(uri, options);
		}

		public boolean exists(URI uri, Map<?, ?> options) {
			return existing.exists(uri, options);
		}

		public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
			return existing.getAttributes(uri, options);
		}

		public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
			existing.setAttributes(uri, attributes, options);
		}

	}

	private final BinaryClassFinder classFinder;
	
	private final ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory;
	
	private final ClassLoader classLoader;
	
	private final ClassFileBytesAccess readerAccess;
	
	public ClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(resourceSet, indexedJvmTypeAccess);
		this.classLoader = classLoader;
		readerAccess = createClassFileReaderAccess(); 
		classFinder = createBinaryClassFinder(classLoader);
		typeFactory = createDeclaredTypeFactory(readerAccess, classLoader);
		((JavaURIConverter)resourceSet.getURIConverter()).classLoader = classLoader;
	}
	
	protected ClassFileBytesAccess createClassFileReaderAccess() {
		return new ClassFileBytesAccess();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Also registers an URI converter that can resolve resource URIs that point
	 * to nested types to their outermost declarator.
	 */
	@Override
	protected void registerProtocol(ResourceSet resourceSet) {
		super.registerProtocol(resourceSet);
		final URIConverter existing = resourceSet.getURIConverter();
		resourceSet.setURIConverter(new JavaURIConverter(existing));
	}
	
	protected BinaryClassFinder createBinaryClassFinder(ClassLoader classLoader) {
		return new BinaryClassFinder(classLoader);
	}

	protected ITypeFactory<BinaryClass, JvmDeclaredType> createDeclaredTypeFactory(ClassFileBytesAccess readerAccess, ClassLoader classLoader) {
		return new DeclaredTypeFactory(readerAccess, classLoader);
	}

	public ITypeFactory<BinaryClass, JvmDeclaredType> getDeclaredTypeFactory() {
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
		URI resourceURI = clazz.getResourceURI();
		if (indexedJvmTypeAccess != null) {
			URI proxyURI = resourceURI.appendFragment(clazz.getURIFragment());
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
		String fragment = clazz.getURIFragment();
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		} 
		return result;
	}


}
