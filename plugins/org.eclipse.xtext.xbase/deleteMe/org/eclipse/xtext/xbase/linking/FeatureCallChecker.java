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
import java.util.EnumSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeConformanceResult;
import org.eclipse.xtext.common.types.util.TypeConformanceResult.Kind;
import org.eclipse.xtext.diagnostics.Diagnostic;
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
import org.eclipse.xtext.xbase.resource.LinkingAssumptions;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.LocalVarDescription;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

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
@SuppressWarnings("deprecation")
public class FeatureCallChecker {

	private PolymorphicDispatcher<String> dispatcher = new PolymorphicDispatcher<String>("_case", 4, 4,
			Collections.singletonList(this));

	@Inject
	private TypeConformanceComputer conformance;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private FeatureCallToJavaMapping featureCall2JavaMapping;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	@Inject
	private LinkingAssumptions linkingAssumptions;
	
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

	public boolean checkTypesWithGenerics(IEObjectDescription input) {
		boolean result = false;
		if (input instanceof JvmFeatureDescription) {
			final JvmFeatureDescription featureDescription = (JvmFeatureDescription) input;
			if (!featureDescription.isGenericsChecked()) {
				Provider<Boolean> validator = new Provider<Boolean>() {
					public Boolean get() {
						Boolean result = Boolean.FALSE;
						ITypeArgumentContext typeContext = featureDescription.getGenericTypeContext();
						if (typeContext != null) {
							if (context instanceof XAbstractFeatureCall
									&& featureDescription.getEObjectOrProxy() instanceof JvmExecutable) {
								JvmExecutable executable = (JvmExecutable) featureDescription.getEObjectOrProxy();
								List<XExpression> actualArguments = featureCall2JavaMapping.getActualArguments(
										(XAbstractFeatureCall) context, executable,
										featureDescription.getImplicitReceiver(),
										featureDescription.getImplicitArgument());
								result = checkTypesWithGenerics(featureDescription, executable, actualArguments, typeContext);
							} else if (context instanceof XConstructorCall
									&& featureDescription.getEObjectOrProxy() instanceof JvmConstructor) {
								List<XExpression> arguments = ((XConstructorCall) context).getArguments();
								result = checkTypesWithGenerics(featureDescription,
										(JvmExecutable) featureDescription.getEObjectOrProxy(), arguments, typeContext);
							}
						}
						featureDescription.setGenericsChecked();
						return result;
					}
				};
				result = doCheck(featureDescription, validator);
			}
		}
		return result;
	}

	protected boolean checkTypesWithGenerics(JvmFeatureDescription featureDescription, JvmExecutable executable,
			List<XExpression> actualArguments, ITypeArgumentContext typeContext) {
		boolean result;
		List<EnumSet<Kind>> allConformanceKinds = areGenericArgumentTypesValid(executable, actualArguments, typeContext);
		for(EnumSet<Kind> conformanceKinds: allConformanceKinds) {
			if (conformanceKinds.contains(Kind.FAILED) || conformanceKinds.contains(Kind.EXCEPTION)) {
				featureDescription.setIssueCode(INVALID_GENERIC_ARGUMENT_TYPES);
				break;
			}
		}
		featureDescription.setArgumentConversionHints(allConformanceKinds);
		result = true;
		return result;
	}
	
	public String checkWithoutTypes(final IEObjectDescription input) {
		if (input instanceof IValidatedEObjectDescription) {
			final IValidatedEObjectDescription validatedDescription = (IValidatedEObjectDescription) input;
			JvmIdentifiableElement identifiable = validatedDescription.getEObjectOrProxy();
			if (identifiable.eIsProxy())
				identifiable = (JvmIdentifiableElement) EcoreUtil.resolve(identifiable, context);
			String issueCode;
			if (identifiable.eIsProxy())
				issueCode = Diagnostic.LINKING_DIAGNOSTIC;
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
	
	public boolean checkTypesWithoutGenerics(IEObjectDescription input) {
		boolean result = false;
		if (input instanceof JvmFeatureDescription) {
			final JvmFeatureDescription featureDescription = (JvmFeatureDescription) input;
			if (!featureDescription.isTypesChecked()) {
				Provider<Boolean> validator = new Provider<Boolean>() {
					public Boolean get() {
						Boolean result = Boolean.FALSE;
						if (context instanceof XAbstractFeatureCall
								&& featureDescription.getEObjectOrProxy() instanceof JvmExecutable) {
							JvmExecutable executable = (JvmExecutable) featureDescription.getEObjectOrProxy();
							List<XExpression> actualArguments = featureCall2JavaMapping.getActualArguments(
									(XAbstractFeatureCall) context, executable,
									featureDescription.getImplicitReceiver(),
									featureDescription.getImplicitArgument());
							result = checkTypesWithoutGenerics(featureDescription, executable, actualArguments);
						} else if (context instanceof XConstructorCall
								&& featureDescription.getEObjectOrProxy() instanceof JvmConstructor) {
							List<XExpression> arguments = ((XConstructorCall) context).getArguments();
							result = checkTypesWithoutGenerics(featureDescription,
									(JvmExecutable) featureDescription.getEObjectOrProxy(), arguments);
						}
						featureDescription.setTypesChecked();
						return result;
					}
				};
				result = doCheck(featureDescription, validator);
			}
		}
		return result;
	}

	protected boolean checkTypesWithoutGenerics(JvmFeatureDescription featureDescription, JvmExecutable executable,
			List<XExpression> actualArguments) {
		if (!areArgumentTypesValid(executable, actualArguments, featureDescription.getRawTypeContext()))
			featureDescription.setIssueCode(INVALID_ARGUMENT_TYPES);
		return true;
	}

	protected <T> T doCheck(final IValidatedEObjectDescription input, Provider<T> validator) {
		Resource resource = context.eResource();
		if (resource instanceof XbaseResource) {
			JvmIdentifiableElement proxy = (JvmIdentifiableElement) context.eGet(reference, false);
			XAbstractFeatureCall featureCall = null;
			XExpression implicitReceiver = null;
			XExpression implicitArgument = null;
			if (context instanceof XAbstractFeatureCall) {
				featureCall = (XAbstractFeatureCall) context;
			}
			if (input instanceof JvmFeatureDescription) {
				implicitReceiver = ((JvmFeatureDescription) input).getImplicitReceiver();
				implicitArgument = ((JvmFeatureDescription) input).getImplicitArgument();
			}
			T result = linkingAssumptions.assumeLinkedAndRun(
					resource, 
					linkingAssumptions.createAssumption(proxy, input.getEObjectOrProxy(), featureCall, implicitReceiver, implicitArgument), 
					validator);
			return result;
		} else {
			return validator.get();
		}
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param description the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(Object input, Object context, EReference ref, IValidatedEObjectDescription description) {
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
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
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
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
			JvmTypeReference parameterType = rightParam.getParameterType();
			JvmTypeReference rawLowerBound = jvmFeatureDescription.getRawTypeContext().getLowerBound(parameterType);
			JvmTypeReference rawTypeReference = rawTypeHelper.getRawTypeReference(rawLowerBound, context.eResource());
			if (!conformance.isConformant(rawTypeReference, rightOperandType, true)) {
				return INVALID_ARGUMENT_TYPES;
			}
			if (jvmFeatureDescription.getGenericTypeContext() != null) {
				rightOperandType = getTypeProvider().getType(context.getRightOperand(), false);
				JvmTypeReference lowerBound = jvmFeatureDescription.getGenericTypeContext().getLowerBound(parameterType);
				JvmTypeReference typeReference = rawTypeHelper.getRawTypeReference(lowerBound, context.eResource());
				if (!conformance.isConformant(typeReference, rightOperandType, false)) {
					return INVALID_ARGUMENT_TYPES;
				}
			}
		}
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmOperation input, XAssignment context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!jvmFeatureDescription.isValidStaticState()) {
			if (input.isStatic())
				return INSTANCE_ACCESS_TO_STATIC_MEMBER;
			else
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		final int irrelevantArguments = jvmFeatureDescription.getNumberOfIrrelevantArguments();
		if (input.getParameters().size() != (1 + irrelevantArguments))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getValue() != null) {
			JvmTypeReference type = getTypeProvider().getType(context.getValue(), false);
			final JvmFormalParameter valueParam = input.getParameters().get(0 + irrelevantArguments);
			if (!conformance.isConformant(valueParam.getParameterType(), type, true))
				return INVALID_ARGUMENT_TYPES;
			if (!conformance.isConformant(valueParam.getParameterType(), type, false))
				return INVALID_GENERIC_ARGUMENT_TYPES;
		}
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmField input, XAssignment context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!jvmFeatureDescription.isValidStaticState()) {
			if (input.isStatic())
				return INSTANCE_ACCESS_TO_STATIC_MEMBER;
			else
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		// TODO: validate if the field is from the current class or a superclass
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
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
	
	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param description the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmIdentifiableElement input, XFeatureCall context, EReference ref,
			LocalVarDescription description) {
		if (context.isExplicitOperationCallOrBuilderSyntax())
			return LOCAL_VAR_ACCESS_WITH_PARENTHESES;
		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param reference the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmField input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!jvmFeatureDescription.isValidStaticState()) {
			if (input.isStatic())
				return INSTANCE_ACCESS_TO_STATIC_MEMBER;
			else
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		if (context.isExplicitOperationCallOrBuilderSyntax())
			return FIELD_ACCESS_WITH_PARENTHESES;

		return null;
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param ref the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmOperation input, XMemberFeatureCall context, EReference ref,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!jvmFeatureDescription.isValidStaticState()) {
			if (input.isStatic())
				return INSTANCE_ACCESS_TO_STATIC_MEMBER;
			else
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		return checkJvmOperation(input, context, context.isExplicitOperationCallOrBuilderSyntax(),
				jvmFeatureDescription);
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param reference the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmOperation input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (!jvmFeatureDescription.isValidStaticState()) {
			if (!input.isStatic())
				return STATIC_ACCESS_TO_INSTANCE_MEMBER;
		}
		return checkJvmOperation(input, context, context.isExplicitOperationCallOrBuilderSyntax(),
				jvmFeatureDescription);
	}
	
	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param reference the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmConstructor input, XFeatureCall context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		return checkJvmOperation(input, context, context.isExplicitOperationCallOrBuilderSyntax(), jvmFeatureDescription);
	}

	/**
	 * @param input the input element (dispatch parameter). 
	 * @param context the context element (dispatch parameter).
	 * @param reference the reference that potentially points from {@code context} to {@code input} (dispatch parameter).
	 * @param jvmFeatureDescription the description for the {@code input} (dispatch parameter).
	 */
	protected String _case(JvmOperation input, XUnaryOperation context, EReference reference,
			JvmFeatureDescription jvmFeatureDescription) {
		if (input.getParameters().size() != 1)
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (context.getOperand() != null) {
			JvmTypeReference operandType = getTypeProvider().getType(context.getOperand(), true);
			final JvmFormalParameter param = input.getParameters().get(0);
			if (!conformance.isConformant(param.getParameterType(), operandType, true))
				return INVALID_ARGUMENT_TYPES;
			if (!conformance.isConformant(param.getParameterType(), operandType))
				return INVALID_GENERIC_ARGUMENT_TYPES;
		}
		return null;
	}

	protected String checkJvmOperation(JvmExecutable executable, XAbstractFeatureCall featureCall,
			boolean isExplicitOperationCall, JvmFeatureDescription jvmFeatureDescription) {
		List<XExpression> actualArguments = featureCall2JavaMapping.getActualArguments(
				featureCall, 
				executable,
				jvmFeatureDescription.getImplicitReceiver(),
				jvmFeatureDescription.getImplicitArgument());
		if (!isValidNumberOfArguments(executable, actualArguments))
			return INVALID_NUMBER_OF_ARGUMENTS;
		if (!isExplicitOperationCall && !isSugaredMethodInvocationWithoutParanthesis(jvmFeatureDescription))
			return METHOD_ACCESS_WITHOUT_PARENTHESES;
		if (isExplicitOperationCall && isSugaredMethodInvocationWithoutParanthesis(jvmFeatureDescription)) {
			return METHOD_ACCESS_WITHOUT_PARENTHESES;
		}
		if (!featureCall.getTypeArguments().isEmpty() // raw type or type inference
				&& executable.getTypeParameters().size() != featureCall.getTypeArguments().size())
			return INVALID_NUMBER_OF_TYPE_ARGUMENTS;
		return null;
	}

	protected boolean areArgumentTypesValid(JvmExecutable exectuable, List<XExpression> arguments, ITypeArgumentContext typeArgumentContext) {
		int numberOfParameters = exectuable.getParameters().size();
		int parametersToCheck = exectuable.isVarArgs() ? numberOfParameters - 1 : numberOfParameters;
		for (int i = 0; i < parametersToCheck && i<arguments.size(); i++) {
			JvmTypeReference parameterType = exectuable.getParameters().get(i).getParameterType();
			if (parameterType == null)
				return true;
			JvmTypeReference lowerBound = typeArgumentContext.getLowerBound(parameterType);
			JvmTypeReference rawType = rawTypeHelper.getRawTypeReference(lowerBound, exectuable.eResource());
			XExpression argument = arguments.get(i);
			JvmTypeReference argumentType = getTypeProvider().getType(argument, rawType, true);
			if (!conformance.isConformant(rawType, argumentType, true))
				return false;
		}
		if (exectuable.isVarArgs()) {
			int lastParamIndex = numberOfParameters - 1;
			JvmTypeReference lastParameterType = exectuable.getParameters().get(lastParamIndex).getParameterType();
			JvmTypeReference lastParameterLowerBound = typeArgumentContext.getLowerBound(lastParameterType);
			JvmTypeReference lastParameterRawType = rawTypeHelper.getRawTypeReference(lastParameterLowerBound, exectuable.eResource());
			if (!(lastParameterRawType instanceof JvmGenericArrayTypeReference))
				throw new IllegalStateException("Unexpected var arg type: " + lastParameterRawType);
			JvmTypeReference varArgRawType = ((JvmGenericArrayTypeReference) lastParameterRawType).getComponentType();
			if (arguments.size() == numberOfParameters) {
				XExpression lastArgument = arguments.get(lastParamIndex);
				JvmTypeReference lastArgumentType = getTypeProvider().getType(lastArgument, lastParameterRawType, true);
				if (conformance.isConformant(lastParameterRawType, lastArgumentType, true))
					return true;
				lastArgumentType = getTypeProvider().getType(lastArgument, varArgRawType, true);
				if (!conformance.isConformant(varArgRawType, lastArgumentType, true))
					return false;
			} else {
				for (int i = lastParamIndex; i < arguments.size(); i++) {
					XExpression argumentExpression = arguments.get(i);
					JvmTypeReference argumentType = getTypeProvider().getType(argumentExpression, varArgRawType, true);
					if (!conformance.isConformant(varArgRawType, argumentType, true))
						return false;
				}
			}
		}
		return true;
	}
	
	protected List<EnumSet<TypeConformanceResult.Kind>> areGenericArgumentTypesValid(JvmExecutable exectuable, List<XExpression> arguments, ITypeArgumentContext typeArgumentContext) {
		List<EnumSet<TypeConformanceResult.Kind>> result = Lists.newArrayList();
		int numberOfParameters = exectuable.getParameters().size();
		int parametersToCheck = exectuable.isVarArgs() ? numberOfParameters - 1 : numberOfParameters;
		for (int i = 0; i < parametersToCheck && i<arguments.size(); i++) {
			JvmTypeReference parameterType = exectuable.getParameters().get(i).getParameterType();
			if (parameterType != null) {
				JvmTypeReference lowerBound = typeArgumentContext.getLowerBound(parameterType);
	//			JvmTypeReference rawType = rawTypeHelper.getRawTypeReference(lowerBound, exectuable.eResource());
				XExpression argument = arguments.get(i);
				JvmTypeReference argumentType = getTypeProvider().getType(argument);
				TypeConformanceResult conformanceResult = conformance.isConformant(lowerBound, argumentType, new TypeConformanceComputationArgument(false, false, true));
				result.add(conformanceResult.getKinds());
			}
		}
		if (exectuable.isVarArgs()) {
			int lastParamIndex = numberOfParameters - 1;
			JvmTypeReference lastParameterType = exectuable.getParameters().get(lastParamIndex).getParameterType();
			JvmTypeReference lastParameterLowerBound = typeArgumentContext.getLowerBound(lastParameterType);
			if (!(lastParameterLowerBound instanceof JvmGenericArrayTypeReference))
				throw new IllegalStateException("Unexpected var arg type: " + lastParameterLowerBound);
			JvmTypeReference varArgRawType = ((JvmGenericArrayTypeReference) lastParameterLowerBound).getComponentType();
			if (arguments.size() == numberOfParameters) {
				XExpression lastArgument = arguments.get(lastParamIndex);
				JvmTypeReference lastArgumentType = getTypeProvider().getType(lastArgument, false);
				TypeConformanceResult conformanceResult = conformance.isConformant(lastParameterLowerBound, lastArgumentType, new TypeConformanceComputationArgument(false, false, true));
				if (conformanceResult.isConformant()) {
					result.add(conformanceResult.getKinds());
				} else {
					conformanceResult = conformance.isConformant(varArgRawType, lastArgumentType, new TypeConformanceComputationArgument(false, false, true));
					result.add(conformanceResult.getKinds());
				}
			} else {
				for (int i = lastParamIndex; i < arguments.size(); i++) {
					XExpression argumentExpression = arguments.get(i);
					JvmTypeReference argumentType = getTypeProvider().getType(argumentExpression, false);
					TypeConformanceResult conformanceResult = conformance.isConformant(varArgRawType, argumentType, new TypeConformanceComputationArgument(false, false, true));
					result.add(conformanceResult.getKinds());
				}
			}
		}
		return result;
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

}
