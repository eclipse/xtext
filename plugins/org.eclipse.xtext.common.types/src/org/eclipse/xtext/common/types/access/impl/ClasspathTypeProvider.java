/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProvider extends AbstractJvmTypeProvider {

	private final ClassFinder classFinder;
	
	private final DeclaredTypeFactory declaredTypeFactory;
	
	private final ClassURIHelper uriHelper;
	
	public ClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(resourceSet, indexedJvmTypeAccess);
		classFinder = createClassFinder(classLoader);
		uriHelper = createClassURIHelper();
		declaredTypeFactory = createDeclaredTypeFactory();
	}
	
	@Deprecated
	public ClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet) {
		this(classLoader, resourceSet, null);
	}

	protected ClassFinder createClassFinder(ClassLoader classLoader) {
		return new ClassFinder(classLoader);
	}

	protected DeclaredTypeFactory createDeclaredTypeFactory() {
		return new DeclaredTypeFactory(uriHelper);
	}

	protected ClassURIHelper createClassURIHelper() {
		return new ClassURIHelper();
	}
	
	public ClassURIHelper getClassURIHelper() {
		return uriHelper;
	}
	
	public DeclaredTypeFactory getDeclaredTypeFactory() {
		return declaredTypeFactory;
	}

	public ClassFinder getClassFinder() {
		return classFinder;
	}

	@Override
	public JvmType findTypeByName(String name) {
		IndexedJvmTypeAccess indexedJvmTypeAccess = getIndexedJvmTypeAccess();
		try {
			/*
			 * TODO Since most types are top level types, we could try to find a dollar sign in the name
			 * and only use the class loaded in that case (lastIndexOf('.') to and subsequent indexOf('$')). 
			 * The uri for top level types is easily created from the FQN.
			 * Important note: Primitives (esp boolean and int) are used quite often and identified
			 * by the classFinder before the class loader is used. Thus the primitives URI has to be created propertly.
			 * Otherwise we would suffer a performance penalty. 
			 */
			
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily the best
			Class<?> clazz = classFinder.forName(name);
			URI resourceURI = uriHelper.createResourceURI(clazz);
			if (indexedJvmTypeAccess != null) {
				URI proxyURI = resourceURI.appendFragment(uriHelper.getFragment(clazz));
				EObject candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, getResourceSet());
				if (candidate instanceof JvmType)
					return (JvmType) candidate;
			}
			TypeResource result = (TypeResource) getResourceSet().getResource(resourceURI, true);
			return findTypeByClass(clazz, result);
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, indexedJvmTypeAccess);
		} catch (NoClassDefFoundError e) { 
			/* 
			 * Error will be thrown if the contents of the binary class file does not match the expectation (transitively).
			 * See java.lang.ClassLoader.defineClass(String, byte[], int, int, ProtectionDomain)
			 */
			return tryFindTypeInIndex(name, indexedJvmTypeAccess);
		}
	}

	protected JvmType tryFindTypeInIndex(String name, IndexedJvmTypeAccess indexAccess) {
		if (indexAccess != null) {
			int index = name.indexOf('$');
			if (index < 0)
				index = name.indexOf('[');
			String qualifiedNameString = index < 0 ? name : name.substring(0, index);
			List<String> nameSegments = Strings.split(qualifiedNameString, '.');
			QualifiedName qualifiedName = QualifiedName.create(nameSegments);
			EObject candidate = indexAccess.getIndexedJvmType(qualifiedName, name, getResourceSet());
			if (candidate instanceof JvmType)
				return (JvmType) candidate;
		}
		return null;
	}
	
	@Override
	protected IMirror createMirrorForFQN(String name) {
		try {
			Class<?> clazz = classFinder.forName(name);
			return createMirror(clazz);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	public ClassMirror createMirror(Class<?> clazz) {
		return ClassMirror.createClassMirror(clazz, declaredTypeFactory);
	}
	
	public JvmType findTypeByClass(Class<?> clazz, Resource resource) {
		// TODO: Maybe iterate the resource without computing a fragment
		String fragment = uriHelper.getFragment(clazz);
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		} 
		return result;
	}

}
