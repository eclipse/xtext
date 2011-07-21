/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.LocalVarDescription;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

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
	private XbaseTypeConformanceComputer conformance;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private FeatureCallToJavaMapping featureCall2JavaMapping;

	public void setTypeProvider(ITypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}

	private EObject context;
	private EReference reference;

	public void initialize(EObject context, EReference reference) {
		this.context = context;
		this.reference = reference;
	}

	public String check(IEObjectDescription input) {
		if (input instanceof IValidatedEObjectDescription) {
			final IValidatedEObjectDescription validatedDescription = (IValidatedEObjectDescription) input;
			JvmIdentifiableElement identifiable = validatedDescription.getEObjectOrProxy();
			if (identifiable.eIsProxy())
				identifiable = (JvmIdentifiableElement) EcoreUtil.resolve(identifiable, context);
			String issueCode;
			if (identifiable.eIsProxy())
				issueCode = UNRESOLVABLE_PROXY;
			else if (!validatedDescription.isValid()) {
				if (Strings.isEmpty(validatedDescription.getIssueCode()))
					issueCode = FEATURE_NOT_VISIBLE;
				else
					return validatedDescription.getIssueCode();
			} else
				issueCode = dispatcher.invoke(identifiable, context, reference, validatedDescription);
			validatedDescription.setIssueCode(issueCode);
			return issueCode;
		}
		return null;
	}

	protected String _case(Object input, Object context, EReference ref, IValidatedEObjectDescription description) {
		return null;
	}

	protected String _case(JvmConstructor input, XConstructorCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		List<XExpression> arguments = context.getArguments();
		if (!isValidNumberOfArguments(input, arguments))
			return INVALID_NUMBER_OF_ARGUMENTS;
		// expected constructor type argument count is the sum of the declaring type's type parameters and the constructors type parameters 
		int expectedTypeArguments = input.getTypeParameters().size()
				+ ((JvmTypeParameterDeclarator) input.getDeclaringType()).getTypeParameters().size();
		if ((!context.getTypeArguments().isEmpty()) // raw type or inferred arguments
				&& expectedTypeArguments != context.getTypeArguments().size())
			return INVALID_NUMBER_OF_TYPE_ARGUMENTS;
		// TODO check type parameter bounds against type arguments 
		if (!areArgumentTypesValid(input, arguments, jvmFeatureDescription.getContext()))
			return INVALID_ARGUMENT_TYPES;
		return null;
	}

	protected String _case(JvmOperation input, XBinaryOperation context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		final int irrelevantArguments = jvmFeatureDescription.getNumberOfIrrelevantArguments();
		if (input.getParameters().size()-irrelevantArguments != 1)
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getRightOperand() != null && context.getLeftOperand() != null) {
			JvmTypeReference rightOperandType = getTypeProvider().getType(context.getRightOperand(), true);
			if (rightOperandType == null)
				return INVALID_ARGUMENT_TYPES;
			final JvmFormalParameter rightParam = input.getParameters().get(0 + irrelevantArguments);
			if (!conformance.isConformant(rightParam.getParameterType(), rightOperandType, true))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String _case(JvmOperation input, XAssignment context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		final int irrelevantArguments = jvmFeatureDescription.getNumberOfIrrelevantArguments();
		if (input.getParameters().size() != (1 + irrelevantArguments))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getValue() != null) {
			JvmTypeReference type = getTypeProvider().getType(context.getValue(), true);
			final JvmFormalParameter valueParam = input.getParameters().get(0 + irrelevantArguments);
			if (!isCompatibleArgument(valueParam.getParameterType(), type))
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
	
	protected String _case(JvmIdentifiableElement input, XFeatureCall context, EReference ref,
			LocalVarDescription description) {
		if (context.isExplicitOperationCall())
			return LOCAL_VAR_ACCESS_WITH_PARENTHESES;
		return null;
	}

	protected String _case(JvmField input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (context.getDeclaringType() == null) {
			if (input.isStatic())
				return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		} else {
			if (!input.isStatic())
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		if (context.isExplicitOperationCall())
			return FIELD_ACCESS_WITH_PARENTHESES;
			
		return null;
	}

	protected String _case(JvmOperation input, XMemberFeatureCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.isStatic()
				&& input.getParameters().size() == context.getMemberCallArguments().size()) {
			return INSTANCE_ACCESS_TO_STATIC_MEMBER;
		} else {
			return checkJvmOperation(input, context, context.isExplicitOperationCall(), jvmFeatureDescription,
					context.getMemberCallArguments());
		}
	}

	protected String _case(JvmOperation input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (context.getDeclaringType() != null) {
			if (!input.isStatic())
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		return checkJvmOperation(input, context, context.isExplicitOperationCall(), jvmFeatureDescription,
				context.getFeatureCallArguments());
	}

	protected String _case(JvmOperation input, XUnaryOperation context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.getParameters().size() != 1)
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getOperand() != null) {
			JvmTypeReference operandType = getTypeProvider().getType(context.getOperand(), true);
			final JvmFormalParameter param = input.getParameters().get(0);
			if (!conformance.isConformant(param.getParameterType(), operandType, true))
				return INVALID_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String checkJvmOperation(JvmOperation input, XAbstractFeatureCall context,
			boolean isExplicitOperationCall, JvmFeatureDescription jvmFeatureDescription, EList<XExpression> arguments) {
		List<XExpression> actualArguments = featureCall2JavaMapping.getActualArguments(context, input,
				jvmFeatureDescription.getImplicitReceiver());
		if (!isValidNumberOfArguments(input, actualArguments))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (!isExplicitOperationCall && !isSugaredMethodInvocationWithoutParanthesis(jvmFeatureDescription))
			return METHOD_ACCESS_WITHOUT_PARENTHESES;
		if (!context.getTypeArguments().isEmpty() // raw type or type inference
				&& input.getTypeParameters().size() != context.getTypeArguments().size())
			return INVALID_NUMBER_OF_TYPE_ARGUMENTS;
		if (!areArgumentTypesValid(input, actualArguments, jvmFeatureDescription.getContext()))
			return INVALID_ARGUMENT_TYPES;
		return null;
	}

	protected boolean areArgumentTypesValid(JvmExecutable exectuable, List<XExpression> arguments, TypeArgumentContext typeArgumentContext) {
		int numberOfParameters = exectuable.getParameters().size();
		int parametersToCheck = exectuable.isVarArgs() ? numberOfParameters - 1 : numberOfParameters;
		for (int i = 0; i < parametersToCheck; i++) {
			JvmTypeReference parameterType = exectuable.getParameters().get(i).getParameterType();
			if (parameterType == null)
				return true;
			if (typeArgumentContext != null) {
				parameterType = typeArgumentContext.getLowerBound(parameterType);
			}
			XExpression argument = arguments.get(i);
			JvmTypeReference argumentType = getTypeProvider().getType(argument, true);
			if (!isCompatibleArgument(parameterType, argumentType))
				return false;
		}
		if (exectuable.isVarArgs()) {
			int lastParamIndex = numberOfParameters - 1;
			JvmTypeReference lastParameterType = exectuable.getParameters().get(lastParamIndex).getParameterType();
			// TODO resolve array type's lower bound
			if (!(lastParameterType.getType() instanceof JvmArrayType))
				throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
			JvmTypeReference varArgType = ((JvmArrayType) lastParameterType.getType()).getComponentType();
			if (arguments.size() == numberOfParameters) {
				XExpression lastArgument = arguments.get(lastParamIndex);
				JvmTypeReference lastArgumentType = getTypeProvider().getType(lastArgument, true);
				if (isCompatibleArgument(lastParameterType, lastArgumentType))
					return true;
				if (!isCompatibleArgument(varArgType, lastArgumentType))
					return false;
			} else {
				for (int i = lastParamIndex; i < arguments.size(); i++) {
					XExpression argumentExpression = arguments.get(i);
					JvmTypeReference argumentType = getTypeProvider().getType(argumentExpression, true);
					if (!isCompatibleArgument(varArgType, argumentType))
						return false;
				}
			}
		}
		return true;
	}

	protected boolean isValidNumberOfArguments(JvmExecutable executable, List<XExpression> arguments) {
		final int numberOfParameters = executable.getParameters().size();
		if (executable.getParameters().size() != arguments.size()) {
			if (!executable.isVarArgs())
				return false;
			else if (numberOfParameters - 1 > arguments.size())
				return false;
		}
		return true;
	}

	protected boolean isSugaredMethodInvocationWithoutParanthesis(JvmFeatureDescription jvmFeatureDescription) {
		return jvmFeatureDescription.getKey().indexOf('(') == -1;
	}

	protected boolean isCompatibleArgument(JvmTypeReference declaredType, JvmTypeReference actualType) {
		if (actualType == null)
			return true;
		if (actualType.getType() instanceof JvmTypeParameter) {
			JvmTypeParameter type = (JvmTypeParameter) actualType.getType();
			if (type.getConstraints().isEmpty())
				return true;
			for (JvmTypeConstraint constraint : type.getConstraints()) {
				if (isCompatibleArgument(declaredType, constraint.getTypeReference()))
					return true;
			}
			return false;
		}
		return conformance.isConformant(declaredType, actualType, true);
	}

}
