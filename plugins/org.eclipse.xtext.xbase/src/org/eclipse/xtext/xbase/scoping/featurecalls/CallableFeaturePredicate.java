/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.typing.TypeConverter;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * <p>
 * Checks whether a given {@link org.eclipse.xtext.common.types.JvmIdentifyableElement} can possibly be called by a
 * given {@link XAbstractFeatureCall}.
 * </p>
 * <p>
 * Note that the {@link XAbstractFeatureCall} not necessarily needs to be complete. Any guards for any missing
 * information should be skipped. This ensures, that this predicate can also be used in the context of content assist.
 * </p>
 * <p>
 * Taken from section <a href="http://java.sun.com/docs/books/jls/third_edition/html/expressions.html#316811">15.12.2.1
 * Identify Potentially Applicable Methods</a> of the Java Language Specification, the following rules are applied:
 * </p>
 * <ol>
 * <li>The arity of the member is lesser or equal to the arity of the method invocation.</li>
 * <li>If the member is a variable arity method with arity n, the arity of the method invocation is greater or equal to
 * n-1.</li>
 * <li>If the member is a fixed arity method with arity n, the arity of the method invocation is equal to n.</li>
 * <li>If the method invocation includes explicit type parameters, and the member is a generic method, then the number
 * of actual type parameters is equal to the number of formal type parameters.</li>
 * </ol>
 * 
 * @author Sven Efftinge
 */
public class CallableFeaturePredicate implements Predicate<IEObjectDescription> {

	private PolymorphicDispatcher<Boolean> dispatcher = new PolymorphicDispatcher<Boolean>("_case", 4, 4,
			Collections.singletonList(this));

	@Inject
	private IJvmTypeConformanceComputer confomance;

	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;

	@Inject
	private TypeConverter typeConverter;
	
	private EObject context;
	private EReference reference;
	
	public void initialize(EObject context, EReference reference) {
		this.context = context;
		this.reference = reference;
	}
	
	public boolean apply(IEObjectDescription input) {
		if (input instanceof JvmFeatureDescription) {
			final JvmFeatureDescription jvmFeatureDescription = (JvmFeatureDescription)input;
			return dispatch_case(jvmFeatureDescription.getJvmFeature(), context, reference, jvmFeatureDescription);
		}
		return true;
	}

	protected boolean dispatch_case(EObject input, EObject context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return dispatcher.invoke(input, context, reference, jvmFeatureDescription);
	}

	protected boolean _case(Object input, Object context, EReference ref, JvmFeatureDescription jvmFeatureDescription) {
		return false;
	}

	protected boolean _case(JvmOperation input, XBinaryOperation op, EReference ref, JvmFeatureDescription jvmFeatureDescription) {
		if (input.getParameters().size() != 1)
			return false;
		if (op.getRightOperand() != null && op.getLeftOperand() != null) {
			JvmTypeReference type = typeProvider.getType(op.getLeftOperand(),
					ITypeProvider.Context.<JvmTypeReference> newCtx());
			if (!confomance.isConformant(input.getParameters().get(0).getParameterType(), type))
				return false;
		}
		return true;
	}

	protected boolean _case(JvmOperation input, XAssignment op, EReference ref, JvmFeatureDescription jvmFeatureDescription) {
		if (input.getParameters().size() != 1)
			return false;
		if (op.getValue() != null) {
			JvmTypeReference type = typeProvider.getType(op.getValue(),
					ITypeProvider.Context.<JvmTypeReference> newCtx());
			if (!isCompatibleArgument(input.getParameters().get(0).getParameterType(), type, op, jvmFeatureDescription))
				return false;
		}
		return true;
	}

	protected boolean _case(JvmField input, XAssignment op, EReference ref, JvmFeatureDescription jvmFeatureDescription) {
		return !input.isFinal() && !input.isStatic();
	}

	protected boolean _case(XVariableDeclaration input, XAssignment op, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		return input.isWriteable();
	}

	protected boolean _case(JvmOperation input, XMemberFeatureCall op, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		EList<XExpression> arguments = op.getMemberCallArguments();
		return checkJvmOperation(input, op, op.isExplicitOperationCall(), jvmFeatureDescription, arguments);
	}

	protected boolean _case(JvmField input, XMemberFeatureCall op, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!op.getMemberCallArguments().isEmpty() || op.isExplicitOperationCall())
			return false;
		
		return !input.isStatic();
	}

	protected boolean checkJvmOperation(JvmOperation input, XAbstractFeatureCall context, boolean isExplicitOperationCall, JvmFeatureDescription jvmFeatureDescription,
			EList<XExpression> arguments) {
		if (input.getParameters().size() != arguments.size())
			return false;
		if (!isExplicitOperationCall && !isSugaredMethodInvocationWithoutParanthesis(jvmFeatureDescription))
			return false;
		
		for (int i = 0; i < arguments.size(); i++) {
			XExpression expression = arguments.get(i);
			JvmTypeReference type = typeProvider.getType(expression, ITypeProvider.Context.<JvmTypeReference> newCtx());
			JvmTypeReference declaredType = input.getParameters().get(i).getParameterType();
			if (!isCompatibleArgument(declaredType, type, context, jvmFeatureDescription))
				return false;
		}
		return true;
	}

	protected boolean isSugaredMethodInvocationWithoutParanthesis(JvmFeatureDescription jvmFeatureDescription) {
		return jvmFeatureDescription.getKey().indexOf('(')==-1;
	}

	protected boolean isCompatibleArgument(JvmTypeReference declaredType, JvmTypeReference actualType,
			EObject contextElement, JvmFeatureDescription jvmFeatureDescription) {
		return actualType == null
				|| actualType.getCanonicalName().equals("java.lang.Void")
				|| confomance.isConformant(typeConverter.convert(jvmFeatureDescription.getContext().resolve(declaredType), contextElement),
						actualType);
	}

	protected boolean _case(XVariableDeclaration input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return true;
	}

	protected boolean _case(JvmFormalParameter param, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return true;
	}
	
	protected boolean _case(JvmField param, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return !param.isStatic() && !context.isExplicitOperationCall();
	}

	protected boolean _case(JvmOperation param, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (param.isStatic()) {
			return false;
		} else {
			boolean result = checkJvmOperation(param, context, context.isExplicitOperationCall(), jvmFeatureDescription, context.getArguments());
			return result;
		}
	}

	protected boolean _case(JvmOperation param, XUnaryOperation context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return param.getParameters().isEmpty();
	}

}
