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

	final ClassFinder classFinder;
	
	private final DeclaredTypeFactory declaredTypeFactory;
	
	private final ClassURIHelper uriHelper;
	
	public ClasspathTypeProvider(ClassLoader classLoader, ResourceSet resourceSet) {
		super(resourceSet);
		classFinder = new ClassFinder(classLoader);
		uriHelper = new ClassURIHelper();
		declaredTypeFactory = new DeclaredTypeFactory(uriHelper);
	}
	
	@Override
	public Type findTypeByName(String name) {
		try {
			Class<?> clazz = classFinder.forName(name);
			URI resourceURI = uriHelper.createResourceURI(clazz);
			TypeResource result = (TypeResource) getResourceSet().getResource(resourceURI, true);
			return findTypeByClass(clazz, result);
		}
		catch (ClassNotFoundException e) {
			throw new TypeNotFoundException("Type: '" + name + "' is not available." , e);
		}
	}
	
	@Override
	protected IMirror createMirrorForFQN(String name) throws TypeNotFoundException {
		try {
			Class<?> clazz = classFinder.forName(name);
			return createMirror(clazz);
		} catch (ClassNotFoundException e) {
			throw new TypeNotFoundException(name, e);
		}
	}
	
	public ClassMirror createMirror(Class<?> clazz) {
		return ClassMirror.createClassMirror(clazz, declaredTypeFactory);
	}
	
	public Type findTypeByClass(Class<?> clazz, Resource resource) {
		// TODO: Maybe iterate the resource without computing a fragment
		String fragment = uriHelper.getFragment(clazz);
		Type result = (Type) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		} 
		return result;
	}

}
