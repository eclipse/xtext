/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(XbaseTypeProvider.class)
public interface ITypeArgumentContextHelper {

	ITypeArgumentContext getTypeArgumentContext(
			XAbstractFeatureCall featureCall,
			List<XExpression> actualArguments,
			Provider<JvmTypeReference> receiverTypeProvider,
			JvmIdentifiableElement feature);

	ITypeArgumentContext getTypeArgumentContext(
			XConstructorCall constructorCall, 
			JvmConstructor constructor);

}
