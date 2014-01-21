/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class ReflectionTypeScope extends AbstractTypeScope {

	public ReflectionTypeScope(ReflectionTypeProvider typeProvider, IQualifiedNameConverter qualifiedNameConverter,
			Predicate<IEObjectDescription> filter) {
		super(typeProvider, qualifiedNameConverter, filter);
	}

}
