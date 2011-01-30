/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import static org.eclipse.xtext.xbase.validation.FeatureCallValidator.*;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.TypeConverter;

import com.google.inject.Inject;

/**
 * <p>
 * Checks whether a given {@link org.eclipse.xtext.common.types.JvmIdentifiableElement} can possibly be called by a
 * given {@link XAbstractFeatureCall}.
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
public class FeatureCallChecker {

	private PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("_case", 4, 4,
			Collections.singletonList(this));

	@Inject
	private IJvmTypeConformanceComputer conformance;

	@Inject
	private TypeConverter typeConverter;

	@Inject
	private IXExpressionTypeProvider typeProvider;

	public void setTypeProvider(IXExpressionTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected IXExpressionTypeProvider getTypeProvider() {
		return typeProvider;
	}

	private EObject context;
	private EReference reference;

	public void initialize(EObject context, EReference reference) {
		this.context = context;
		this.reference = reference;
	}

	public String check(IEObjectDescription input) {
		if (input instanceof JvmFeatureDescription) {
			final JvmFeatureDescription jvmFeatureDescription = (JvmFeatureDescription) input;
			String issueCode = dispatcher.invoke(jvmFeatureDescription.getJvmFeature(), context, reference,
					jvmFeatureDescription);
			jvmFeatureDescription.setIssueCode(issueCode);
			return issueCode;
		}
		return null;
	}

	protected String _case(Object input, Object context, EReference ref, JvmFeatureDescription jvmFeatureDescription) {
		return null;
	}

	protected String _case(JvmConstructor input, XConstructorCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		final int numberOfArgs = input.getParameters().size();
		if (numberOfArgs != context.getArguments().size())
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (!context.getTypeArguments().isEmpty()
				&& input.getTypeParameters().size() == context.getTypeArguments().size())
			return INVALID_NUMBER_OF_TYPE_ARGUMENTS;
		for (int i = 0; i < numberOfArgs; i++) {
			JvmFormalParameter parameter = input.getParameters().get(i);
			XExpression expression = context.getArguments().get(i);
			JvmTypeReference type = getTypeProvider().getConvertedType(expression);
			if (!conformance.isConformant(parameter.getParameterType(), type))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String _case(JvmOperation input, XBinaryOperation context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		final int callTypeDelta = getCallTypeDelta(jvmFeatureDescription);
		if (input.getParameters().size() != (1 + callTypeDelta))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getRightOperand() != null && context.getLeftOperand() != null) {
			JvmTypeReference type = getTypeProvider().getConvertedType(context.getRightOperand());
			if (type == null)
				return INVALID_ARGUMENT_TYPES;
			final JvmFormalParameter rightParam = input.getParameters().get(0 + callTypeDelta);
			if (!conformance.isConformant(rightParam.getParameterType(), type))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String _case(JvmOperation input, XAssignment context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		final int callTypeDelta = getCallTypeDelta(jvmFeatureDescription);
		if (input.getParameters().size() != (1 + callTypeDelta))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getValue() != null) {
			JvmTypeReference type = getTypeProvider().getConvertedType(context.getValue());
			final JvmFormalParameter valueParam = input.getParameters().get(0 + callTypeDelta);
			if (!isCompatibleArgument(valueParam.getParameterType(), type, context, jvmFeatureDescription))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String _case(JvmField input, XAssignment context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.isFinal())
			return ASSIGNMENT_TARGET_IS_NOT_WRITEABLE;
		if (input.isStatic())
			return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		return null;
	}

	protected String _case(JvmField input, XMemberFeatureCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!context.getMemberCallArguments().isEmpty())
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.isExplicitOperationCall())
			return FIELD_ACCESS_WITH_PARENTHESES;
		if (input.isStatic())
			return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		return null;
	}

	protected String _case(JvmField input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.isStatic())
			return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		if (context.isExplicitOperationCall())
			return FIELD_ACCESS_WITH_PARENTHESES;
		return null;
	}

	protected String _case(JvmOperation input, XMemberFeatureCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.isStatic() && !jvmFeatureDescription.isMemberSyntaxContext()) {
			return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		} else {
			return checkJvmOperation(input, context, context.isExplicitOperationCall(), jvmFeatureDescription,
					context.getMemberCallArguments());
		}
	}

	protected String _case(JvmOperation input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return checkJvmOperation(input, context, context.isExplicitOperationCall(), jvmFeatureDescription,
				context.getFeatureCallArguments());
	}

	protected String _case(JvmOperation input, XUnaryOperation context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.getParameters().size() != 1)
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getOperand() != null) {
			JvmTypeReference operandType = getTypeProvider().getConvertedType(context.getOperand());
			final JvmFormalParameter param = input.getParameters().get(0);
			if (!conformance.isConformant(param.getParameterType(), operandType))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String checkJvmOperation(JvmOperation input, XAbstractFeatureCall context,
			boolean isExplicitOperationCall, JvmFeatureDescription jvmFeatureDescription, EList<XExpression> arguments) {
		final int memberCallDelta = getCallTypeDelta(jvmFeatureDescription);
		if (input.getParameters().size() + memberCallDelta != arguments.size())
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (!(isExplicitOperationCall ^ isSugaredMethodInvocationWithoutParanthesis(jvmFeatureDescription)))
			return METHOD_ACCESS_WITHOUT_PARENTHESES;

		for (int i = 0; i < arguments.size(); i++) {
			XExpression expression = arguments.get(i);
			JvmTypeReference type = getTypeProvider().getConvertedType(expression);
			JvmTypeReference declaredType = input.getParameters().get(i + memberCallDelta).getParameterType();
			if (declaredType==null) 
				return null;
			if (!isCompatibleArgument(declaredType, type, context, jvmFeatureDescription))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected boolean isSugaredMethodInvocationWithoutParanthesis(JvmFeatureDescription jvmFeatureDescription) {
		return jvmFeatureDescription.getKey().indexOf('(') == -1;
	}

	protected boolean isCompatibleArgument(JvmTypeReference declaredType, JvmTypeReference actualType,
			EObject contextElement, JvmFeatureDescription jvmFeatureDescription) {
		return actualType == null
				|| actualType.getCanonicalName().equals("java.lang.Void") // void should be treated as compatible to everything
				|| conformance.isConformant(typeConverter.convert(
						jvmFeatureDescription.getContext().getLowerBound(declaredType), contextElement), actualType);
	}

	protected int getCallTypeDelta(JvmFeatureDescription jvmFeatureDescription) {
		return jvmFeatureDescription.isMemberSyntaxContext() ? 0 : 1;
	}

}
