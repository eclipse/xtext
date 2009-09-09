/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.TypeResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProvider extends AbstractTypeProvider {

	private final ClassLoader classLoader;
	
	private final PrimitiveTypeProvider primitiveTypeProvider;
	
	private final DeclaredTypeProvider declaredTypeProvider;
	
	private final ClassURIHelper uriHelper;
	
	public ClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet) {
		super(resourceSet);
		this.classLoader = classLoader;
		primitiveTypeProvider = new PrimitiveTypeProvider();
		uriHelper = new ClassURIHelper();
		declaredTypeProvider = new DeclaredTypeProvider(uriHelper);
	}
	
	@Override
	public Type findTypeByName(String name) {
		try {
			Class<?> clazz = findClassByName(name);
			URI resourceURI = uriHelper.createResourceURI(clazz);
			TypeResource result = (TypeResource) getResourceSet().getResource(resourceURI, true);
			return findTypeByClass(clazz, result);
		}
		catch (Exception e) {
			throw new TypeNotFoundException("Type: '" + name + "' is not available." , e);
		}
	}

	public Class<?> findClassByName(String name) throws ClassNotFoundException {
		try {
			return Class.forName(normalizeClassName(name), false, classLoader);
		} catch(ClassNotFoundException e) {
			Class<?> result = Primitives.forName(name);
			if (result == null)
				throw e;
			return result;
		}
	}
	
	public String normalizeClassName(String className) {
		if (className.charAt(0) == '[' || className.charAt(className.length() - 1)!=']') 
			// assume a valid name if we have the default array notation
			return className;
		String tempClassName = className;
		int idx = tempClassName.length() - 1;
		StringBuilder result = new StringBuilder(className.length());
		while(tempClassName.charAt(idx) == ']') {
			result.append('[');
			idx-=2;
		}
		tempClassName = tempClassName.substring(0, idx + 1);
		if (Boolean.TYPE.getName().equals(tempClassName)) {
			result.append('Z');
		} else if (Byte.TYPE.getName().equals(tempClassName)) {
			result.append('B');
		} else if (Character.TYPE.getName().equals(tempClassName)) {
			result.append('C');
		} else if (Double.TYPE.getName().equals(tempClassName)) {
			result.append('D');
		} else if (Float.TYPE.getName().equals(tempClassName)) {
			result.append('F');
		} else if (Integer.TYPE.getName().equals(tempClassName)) {
			result.append('I');
		} else if (Long.TYPE.getName().equals(tempClassName)) {
			result.append('J');
		} else if (Short.TYPE.getName().equals(tempClassName)) {
			result.append('S');
		} else {
			result.append('L');
			result.append(tempClassName);
			result.append(';');
		}
		return result.toString();
	}
	
	public ClassMirror createMirror(Class<?> clazz) {
		return ClassMirror.createClassMirror(clazz, declaredTypeProvider);
	}
	
	@Override
	public IMirror createMirror(URI resourceURI) {
		if (resourceURI.hasFragment())
			throw new IllegalArgumentException("Cannot create mirror for uri '" + resourceURI.toString() + "'");
		String name = resourceURI.path();
		try {
			if (ClassURIHelper.PRIMITIVES.equals(name))
				return new PrimitiveMirror(primitiveTypeProvider);
			if (!name.startsWith(ClassURIHelper.OBJECTS))
				throw new IllegalArgumentException("Invalid resource uri '" + resourceURI.toString() + "'");
			name = name.substring(ClassURIHelper.OBJECTS.length());
			Class<?> clazz = findClassByName(name);
			return createMirror(clazz);
		}
		catch (ClassNotFoundException e) {
			throw new TypeNotFoundException("uri: " + resourceURI.toString() + ", opaquePart: " + name, e);
		}
	}
	
	public Type findTypeByClass(Class<?> clazz, Resource resource) {
		// TODO: Maybe iterate the resource without the computing a fragment
		String fragment = uriHelper.getFragment(clazz);
		Type result = (Type) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
//			result = createType(clazz);
//			resource.getContents().add(result);
		} 
		return result;
//		if (clazz.isPrimitive()) {
//			
//			for(EObject object: resource.getContents()) {
//				if (object instanceof PrimitiveType) {
//					PrimitiveType primitive = (PrimitiveType) object;
//					if (primitive.getName().equals(clazz.getName())) {
//						return primitive;
//					}
//				} else {
//					org.eclipse.xtext.common.types.Void _void = (org.eclipse.xtext.common.types.Void) object;
//					if (_void.getCanonicalName().equals(clazz.getName())) {
//						return _void;
//					}
//				}
//			}
//			Type result = createType(clazz);
//			resource.getContents().add(result);
//			return result;
//		}
//		if (clazz.isArray()) {
//			Class<?> componentClass = clazz.getComponentType();
//			ComponentType componentType = (ComponentType) findOrCreateType(componentClass, resource);
//			if (componentType.getArrayType() == null) {
//				ArrayType result = TypesFactory.eINSTANCE.createArrayType();
//				componentType.setArrayType(result);
//			}
//			return componentType.getArrayType();
//		}
	}

}
