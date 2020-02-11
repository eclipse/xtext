/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.naming;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;

/**
 * Provides qualified names for EObjects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public interface IQualifiedNameProvider extends Function<EObject, QualifiedName> {

	/**
	 * @return the qualified name for the given object, <code>null</code> if this {@link IQualifiedNameProvider} is not
	 *         responsible or if the given object doesn't have qualified name.
	 */
	QualifiedName getFullyQualifiedName(EObject obj);

	abstract class AbstractImpl implements IQualifiedNameProvider {
		@Override
		public QualifiedName apply(EObject from) {
			return getFullyQualifiedName(from);
		}
	}
}
