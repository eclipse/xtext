/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import static com.google.common.collect.Iterables.*;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Selectors {
	
	public static ISelector selectByName(QualifiedName name) {
		return new ISelector.SelectByName(name);
	}
	
	public static ISelector selectByName(QualifiedName name, ISelector ...selectors) {
		final ISelector.SelectByName selectByName = new ISelector.SelectByName(name);
		selectByName.getDelegateSelectors().addAll(Arrays.asList(selectors));
		return selectByName;
	}
	
	public static ISelector selectByNameIgnoreCase(QualifiedName name) {
		return new ISelector.SelectByName(name, true);
	}
	
	public static ISelector selectByNameIgnoreCase(QualifiedName name, ISelector ...selectors) {
		final ISelector.SelectByName selectByName = new ISelector.SelectByName(name, true);
		selectByName.getDelegateSelectors().addAll(Arrays.asList(selectors));
		return selectByName;
	}
	
	public static ISelector selectByTypeAndName(EClass clazz, QualifiedName name) {
		return selectByName(name, selectByType(clazz));
	}
	
	public static ISelector selectByTypeAndNameIgnoreCase(EClass clazz, QualifiedName name) {
		return selectByNameIgnoreCase(name, selectByType(clazz));
	}
	
	public static ISelector selectByType(final EClass clazz) {
		return new ISelector() {
			public Iterable<IEObjectDescription> applySelector(Iterable<IEObjectDescription> elements) {
				return filter(elements, new Predicate<IEObjectDescription>(){
					public boolean apply(IEObjectDescription input) {
						return EcoreUtil2.isAssignableFrom(clazz, input.getEObjectOrProxy().eClass());
					}});
			}
		};
	}
	
	public static ISelector selectByEObject(final EObject object) {
		return new ISelector.SelectByEObject(object);
	}
	
	public static ISelector selectByEObject(final EObject object, ISelector ...selectors) {
		final ISelector.SelectByEObject selectByEObject = new ISelector.SelectByEObject(object);
		selectByEObject.getDelegateSelectors().addAll(Arrays.asList(selectors));
		return selectByEObject;
	}
}
