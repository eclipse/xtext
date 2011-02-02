/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.featurecalls;

import static com.google.common.collect.Iterables.*;

import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.typing.AbstractTypeProvider;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.functions.FunctionConversion;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IdentifiableTypeProvider extends AbstractTypeProvider<JvmTypeReference, JvmIdentifiableElement> {
	
	@Inject
	private IXExpressionTypeProvider expressionTypeProvider;
	
	@Inject
	private TypeArgumentContext.Provider typeArgCtxProvider;
	
	@Inject
	private SuperTypeCollector collector;
	
	@Inject
	private FunctionConversion functionConversion;
	
	@Inject
	private TypesFactory factory;
	
	public void setExpressionTypeProvider(IXExpressionTypeProvider expressionTypeProvider) {
		this.expressionTypeProvider = expressionTypeProvider;
	}
	
	protected JvmTypeReference _type(XSwitchExpression object) {
		if (object.getLocalVarName() != null) {
			final JvmTypeReference convertedType = expressionTypeProvider.getType(object.getSwitch());
			return convertedType;
		}
		return null;
	}

	protected JvmTypeReference _type(XCasePart object) {
		if (object.getTypeGuard() != null) {
			return object.getTypeGuard();
		}
		return null;
	}

	protected JvmTypeReference _type(XVariableDeclaration object) {
		if (object.getType() != null)
			return object.getType();
		return expressionTypeProvider.getType(object.getRight());
	}

	protected JvmTypeReference _type(JvmFormalParameter parameter) {
		if (parameter.getParameterType() == null) {
			if (parameter.eContainer() instanceof XClosure) {
				final XClosure closure = (XClosure)parameter.eContainer();
				JvmTypeReference type = expressionTypeProvider.getExpectedType(closure);
				int indexOf = closure.getFormalParameters().indexOf(parameter);
				JvmOperation operation = functionConversion.findSingleMethod(type);
				if (indexOf < operation.getParameters().size()) {
					JvmFormalParameter declaredParam = operation.getParameters().get(indexOf);
					TypeArgumentContext context = typeArgCtxProvider.get(type);
					return context.resolve(declaredParam.getParameterType());
				}
				return null;
			} else if (parameter.eContainer() instanceof XForLoopExpression) {
				XForLoopExpression forLoop = (XForLoopExpression) parameter.eContainer();
				JvmParameterizedTypeReference reference = (JvmParameterizedTypeReference) expressionTypeProvider.getType(forLoop
						.getForExpression());
				TypeArgumentContext context = typeArgCtxProvider.get(reference);
				final String iterableName = Iterable.class.getName();
				if (!reference.getType().getCanonicalName().equals(iterableName)) {
					try {
						final Set<JvmTypeReference> collectSuperTypes = collector.collectSuperTypes(reference);
						reference = (JvmParameterizedTypeReference) find(collectSuperTypes,
								new Predicate<JvmTypeReference>() {
									public boolean apply(JvmTypeReference input) {
										return input.getType().getCanonicalName().equals(iterableName);
									}
								});
					} catch (NoSuchElementException e) {
						return null;
					}
				}
				final JvmTypeReference resolveContravariant = context.getUpperBound((reference).getArguments().get(0));
				return resolveContravariant;
			}
		}
		return parameter.getParameterType();
	}

	protected JvmTypeReference _type(JvmConstructor constructor) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(constructor.getDeclaringType());
		return reference;
	}

	protected JvmTypeReference _type(JvmField field) {
		return field.getType();
	}

	protected JvmTypeReference _type(JvmOperation operation) {
		return operation.getReturnType();
	}
}
