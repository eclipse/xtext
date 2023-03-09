/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ReflectionTypeProvider extends AbstractRuntimeJvmTypeProvider {

	private final ClassFinder classFinder;
	
	private final ReflectionTypeFactory reflectionTypeFactory;
	
	private final ReflectURIHelper uriHelper;
	
	@Deprecated
	public ReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this(classLoader, resourceSet, indexedJvmTypeAccess, null);
	}
	
	public ReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess, TypeResourceServices services) {
		super(resourceSet, indexedJvmTypeAccess, services);
		classFinder = createClassFinder(classLoader);
		uriHelper = createClassURIHelper();
		reflectionTypeFactory = createDeclaredTypeFactory();
	}
	
	@Deprecated
	public ReflectionTypeProvider(ClassLoader classLoader, ResourceSet resourceSet) {
		this(classLoader, resourceSet, null);
	}
	
	protected ClassFinder createClassFinder(ClassLoader classLoader) {
		return new ClassFinder(classLoader);
	}

	protected ReflectionTypeFactory createDeclaredTypeFactory() {
		return new ReflectionTypeFactory(uriHelper);
	}

	protected ReflectURIHelper createClassURIHelper() {
		return new ReflectURIHelper();
	}
	
	public ReflectURIHelper getClassURIHelper() {
		return uriHelper;
	}
	
	public ReflectionTypeFactory getDeclaredTypeFactory() {
		return reflectionTypeFactory;
	}

	public ClassFinder getClassFinder() {
		return classFinder;
	}
	
	@Override
	public JvmType findTypeByName(String name) {
		try {
			// seems to be the only reliable way to locate nested types
			// since dollar signs are a quite good indicator but not necessarily the best
			Class<?> clazz = classFinder.forName(name);
			return findTypeByClass(clazz);
		} catch (UnknownNestedTypeException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, true);
		} catch (NoClassDefFoundError e) { 
			/* 
			 * Error will be thrown if the contents of the binary class file does not match the expectation (transitively).
			 * See java.lang.ClassLoader.defineClass(String, byte[], int, int, ProtectionDomain)
			 */
			return tryFindTypeInIndex(name, true);
		}
	}

	/**
	 * @since 2.4
	 */
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
			Class<?> clazz = findClassByName(name);
			return findTypeByClass(clazz);
		} catch (ClassNotFoundExceptionWithBaseName e) {
			String outerName = e.getBaseName();
			JvmType outer = doFindTypeByName(outerName);
			if (outer instanceof JvmDeclaredType) {
				String nestedNames = name.substring(outerName.length() + 1);
				List<String> segments = Strings.split(nestedNames, ".");
				return findNestedType((JvmDeclaredType) outer, segments, 0);
			}
			return null;
		} catch (ClassNotFoundException e) {
			return tryFindTypeInIndex(name, false);
		} catch (NoClassDefFoundError e) { 
			/* 
			 * Error will be thrown if the contents of the binary class file does not match the expectation (transitively).
			 * See java.lang.ClassLoader.defineClass(String, byte[], int, int, ProtectionDomain)
			 */
			return tryFindTypeInIndex(name, false);
		} catch (UnknownNestedTypeException e) {
			return null;
		}
	}

	private JvmType findTypeByClass(Class<?> clazz) throws UnknownNestedTypeException {
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

	private Class<?> findClassByName(String name) throws ClassNotFoundException {
		try {
			Class<?> clazz = classFinder.forName(name);
			return clazz;
		} catch(ClassNotFoundException exception) {
			int index = name.lastIndexOf('.');
			if (index <= 0) {
				throw exception;
			}
			String baseName = name.substring(0, index);
			try {
				Class<?> resolvedOuterClass = findClassByName(baseName);
				baseName = resolvedOuterClass.getName();
			} catch (ClassNotFoundException baseNameException) {
				throw exception;
			}
			final String validBaseName = baseName;
			try {
				String binaryName = baseName + '$' + name.substring(index + 1);
				Class<?> clazz = classFinder.forName(binaryName);
				return clazz;
			} catch(ClassNotFoundException e) {
				throw new ClassNotFoundExceptionWithBaseName(validBaseName);
			}
		}
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
		return ClassMirror.createClassMirror(clazz, reflectionTypeFactory);
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
