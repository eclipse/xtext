/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.functions;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.JvmFeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FunctionConversion {
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeArgumentContext.Provider contextProvider;
	
	private interface FuncDesc {
		JvmTypeReference getReturnType();
		Iterable<? extends JvmTypeReference> getParamTypes();
	}
	
	private static class FunctionRefFuncDef implements FuncDesc {
		private List<? extends JvmTypeReference> arguments;
		
		public JvmTypeReference getReturnType() {
			return arguments.get(arguments.size()-1);
		}
		public Iterable<? extends JvmTypeReference> getParamTypes() {
			if (arguments.size()==1) {
				return emptyList();
			} else {
				return arguments.subList(0, arguments.size()-1);
			}
		}
	}
	
	private static class JvmOperationFuncDef implements FuncDesc {
		private JvmOperation delegate;
		public JvmTypeReference getReturnType() {
			return delegate.getReturnType();
		}
		public Iterable<JvmTypeReference> getParamTypes() {
			return transform(delegate.getParameters(), new Function<JvmFormalParameter,JvmTypeReference>() {
				public JvmTypeReference apply(JvmFormalParameter from) {
					return from.getParameterType();
				}
			});
		}
	}
	
	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		FuncDesc leftDesc = toFuncDesc(left);
		FuncDesc rightDesc = toFuncDesc(right);
		if (leftDesc==null || rightDesc==null)
			return false;
		TypeArgumentContext leftCtx = contextProvider.get(left);
		TypeArgumentContext rightCtx = contextProvider.get(right);
		return isConformant(leftDesc,leftCtx,rightDesc,rightCtx);
	}
	
	protected FuncDesc toFuncDesc(JvmTypeReference left) {
		if (isFunction(left)) {
			FunctionRefFuncDef result = new FunctionRefFuncDef();
			result.arguments = ((JvmParameterizedTypeReference) left).getArguments();
			return result;
		} 
		JvmOperation operation = findSingleMethod(left);
		if (operation==null)
			return null;
		JvmOperationFuncDef result = new JvmOperationFuncDef();
		result.delegate = operation;
		return result;
	}

	protected boolean isConformant(FuncDesc left, TypeArgumentContext leftCtx, FuncDesc right, TypeArgumentContext rightCtx) {
		final Iterable<? extends JvmTypeReference> paramTypes = left.getParamTypes();
		Iterator<? extends JvmTypeReference> leftIter = paramTypes.iterator();
		final Iterable<? extends JvmTypeReference> paramTypes2 = right.getParamTypes();
		Iterator<? extends JvmTypeReference> rightIter = paramTypes2.iterator();
		while (leftIter.hasNext() && rightIter.hasNext()) {
			JvmTypeReference leftType = leftIter.next();
			JvmTypeReference rightType = rightIter.next();
			final JvmTypeReference convertedLeftParam = leftCtx.resolve(leftType);
			final JvmTypeReference convertedRightParam = rightCtx.resolve(rightType);
			if (!conformanceComputer.isConformant(convertedLeftParam, convertedRightParam))
				return false;
		}
		if (leftIter.hasNext() || rightIter.hasNext()) // params left?
			return false;
		return conformanceComputer.isConformant(leftCtx.resolve(left.getReturnType()),rightCtx.resolve(right.getReturnType()));
	}

	@Inject
	private JvmFeatureOverridesService overridesService;
	
	public JvmOperation findSingleMethod(JvmTypeReference type) {
		Iterable<JvmOperation> features = filter(overridesService.getAllJvmFeatures(type),JvmOperation.class);
		JvmOperation operation = null;
		for (JvmOperation op: features) {
			if (isValidFunction(op)) {
				if (operation == null)
					operation = op;
				else
					return null;
			}
		}
		return operation;
	}

	protected boolean isValidFunction(JvmOperation op) {
		if (op.getVisibility() == JvmVisibility.PUBLIC) {
			if (Object.class.getName().equals(op.getDeclaringType().getCanonicalName()))
				return false;
			final String name = op.getSimpleName();
			if (name.equals("toString") && op.getParameters().isEmpty())
				return false;
			if (name.equals("equals") && op.getParameters().size()==1)
				return false;
			if (name.equals("hashCode") && op.getParameters().isEmpty())
				return false;
			return true;
		}
		return false;
	}

	public boolean isFunction(JvmTypeReference right) {
		return right.getCanonicalName().startsWith(Functions.class.getCanonicalName());
	}

}
