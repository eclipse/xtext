/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(TypeProvider.class)
public interface ITypeProvider {

	/**
	 * @return the fully-resolved expected type of the given expression, if a correct, fully-linkable model is given.
	 *         Returns <code>null</code> if no special type is expected
	 * 
	 */
	public JvmTypeReference getExpectedType(XExpression expression);

	/**
	 * @return the fully-resolved type of the {@link XExpression}, if a correct, fully-linkable model is given.
	 *         <code>null</code> indicates a problem during resolution.
	 */
	public JvmTypeReference getType(XExpression expression);

	/**
	 * @return the fully-resolved type of the {@link JvmIdentifiableElement}, if a correct, fully-linkable model is
	 *         given. <code>null</code> indicates a problem during resolution. given.
	 */
	public JvmTypeReference getTypeForIdentifiable(JvmIdentifiableElement identifiableElement);

}
