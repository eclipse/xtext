/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @deprecated Use functionality in {@link org.eclipse.xtext.scoping.Scopes} instead
 */
@Deprecated
public abstract class ScopedElements {
	private ScopedElements() {
	}

	@Deprecated
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final EClass typeToFilter,
			final Function<EObject, String> nameFunc) {
		return Scopes.allInResource(resource, typeToFilter, nameFunc);
	}

	@Deprecated
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final Predicate<EObject> predicate,
			final Function<EObject, String> nameFunc) {
		return Scopes.allInResource(resource,predicate,nameFunc);
	}
	
	@Deprecated
	public static Iterable<IEObjectDescription> allInResource(final Resource resource, final Predicate<EObject> filter,final Function<EObject, String> nameFunc, boolean skipDuplicates) {
		return Scopes.allInResource(resource, filter, nameFunc, skipDuplicates);
	}

}
