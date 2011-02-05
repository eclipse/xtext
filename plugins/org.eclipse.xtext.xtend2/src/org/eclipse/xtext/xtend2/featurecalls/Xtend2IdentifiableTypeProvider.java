/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.featurecalls;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.TypesService;
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
	
	@Inject
	private TypesService typeService;

	protected JvmTypeReference _type(XtendClass clazz, boolean selfContained) {
		JvmParameterizedTypeReference typeReference = factory.createJvmParameterizedTypeReference();
		typeReference.setType(clazz.getInferredJvmType());
		return typeReference;
	}

	private ThreadLocal<Set<XtendFunction>> currentComputation = new ThreadLocal<Set<XtendFunction>>();
	
	protected JvmTypeReference _type(XtendFunction func, boolean selfContained) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		Set<XtendFunction> computations = getCurrentComputation(); 
		if (computations.add(func)) {
			try {
				return typeProvider.getType(func.getExpression());
			} finally {
				computations.remove(func);
			}
		} else {
			return typeService.getTypeForName(Object.class, func);
		}
	}

	protected Set<XtendFunction> getCurrentComputation() {
		Set<XtendFunction> set = currentComputation.get();
		if (set == null) {
			set = newHashSet();
			currentComputation.set(set);
		}
		return set;
	}

	protected JvmTypeReference _type(JvmGenericType type, boolean selfContained) {
		XtendClass xtendClass = xtend2SourceAssociator.getXtendSource(type);
		return (xtendClass != null) ? _type(xtendClass, selfContained) : null;
	}

	@Override
	protected JvmTypeReference _type(JvmOperation operation, boolean selfContained) {
		XtendFunction xtendFunction = xtend2SourceAssociator.getXtendSource(operation);
		return (xtendFunction != null) ? _type(xtendFunction, selfContained) : super._type(operation, selfContained);
	}
}
