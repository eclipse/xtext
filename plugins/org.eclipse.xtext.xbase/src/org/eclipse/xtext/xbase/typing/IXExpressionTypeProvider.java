/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(XExpressionTypeProvider.class)
public interface IXExpressionTypeProvider extends ITypeProvider<JvmTypeReference, XExpression> {

	public JvmTypeReference getConvertedType(XExpression astNode);
	
}
