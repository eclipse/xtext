/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Small facade that allows clients to process their own expressions with
 * a custom control flow when it comes to exceptions.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IThrownExceptionDelegate {

	LightweightTypeReference toLightweightReference(JvmTypeReference exception);

	void accept(LightweightTypeReference type);

	LightweightTypeReference getActualType(XExpression expr);
	
	/**
	 * @since 2.18
	 */
	LightweightTypeReference getActualType(JvmIdentifiableElement identifiable);
	
	/**
	 * @since 2.18
	 */
	IResolvedExecutable getResolvedFeature(JvmExecutable executable, LightweightTypeReference contextType);

	void collectThrownExceptions(XExpression expression);

	IThrownExceptionDelegate catchExceptions(List<LightweightTypeReference> caughtExceptions);

}
