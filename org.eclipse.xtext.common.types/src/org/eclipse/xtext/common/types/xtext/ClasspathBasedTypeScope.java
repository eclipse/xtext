/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class ClasspathBasedTypeScope extends AbstractTypeScope {

	public ClasspathBasedTypeScope(ClasspathTypeProvider typeProvider, IQualifiedNameConverter qualifiedNameConverter, Predicate<IEObjectDescription> filter) {
		super(typeProvider, qualifiedNameConverter, filter);
	}
	
}
