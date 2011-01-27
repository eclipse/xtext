/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.featurecalls;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xtend2.linking.XtendSourceAssociator;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2IdentifiableTypeProvider extends IdentifiableTypeProvider {

	@Inject
	private TypesFactory factory;

	@Inject
	private IXExpressionTypeProvider typeProvider;

	@Inject
	private XtendSourceAssociator xtend2SourceAssociator;

	protected JvmTypeReference _type(XtendClass clazz) {
		JvmParameterizedTypeReference typeReference = factory.createJvmParameterizedTypeReference();
		typeReference.setType(clazz.getInferredJvmType());
		return typeReference;
	}

	protected JvmTypeReference _type(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		return typeProvider.getType(func.getExpression());
	}

	protected JvmTypeReference _type(JvmGenericType type) {
		XtendClass xtendClass = xtend2SourceAssociator.getXtendSource(type);
		return (xtendClass != null) ? _type(xtendClass) : super._type(type);
	}

	@Override
	protected JvmTypeReference _type(JvmOperation operation) {
		XtendFunction xtendFunction = xtend2SourceAssociator.getXtendSource(operation);
		return (xtendFunction != null) ? _type(xtendFunction) : super._type(operation);
	}
}
