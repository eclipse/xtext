/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.LongExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Stephane Galland - Add support of JvmCustomAnnotationValue into isConstantExpression.
 */
public class FeatureCallCompiler extends LiteralsCompiler {

	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private Primitives primitives;

	@Inject
	private ILogicalContainerProvider contextProvider;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XAbstractFeatureCall) {
			_toJavaExpression((XAbstractFeatureCall) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}

	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XFeatureCall) {
			_toJavaStatement((XFeatureCall) obj, appendable, isReferenced);
		} else if (obj instanceof XAbstractFeatureCall) {
			_toJavaStatement((XAbstractFeatureCall) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}

	protected boolean nullSafeMemberFeatureCallExpressionNeedsPreparation(XExpression argument, ITreeAppendable b) {
		if (b.hasName(argument))
			return false;
		if (argument instanceof JvmField || argument instanceof JvmFormalParameter)
			return false;
		return true;
	}
	
	protected void _toJavaStatement(final XAbstractFeatureCall expr, ITreeAppendable b, final boolean isReferenced) {
		if (expr.isTypeLiteral()) {
			generateComment(new Later() {
				@Override
				public void exec(ITreeAppendable appendable) {
					internalToJavaExpression(expr, appendable);
				}
			}, b, isReferenced);
		} else if (expressionHelper.isShortCircuitOperation(expr)) {
			final XBinaryOperation binaryOperation = (XBinaryOperation) expr;
			final XExpression leftOperand = binaryOperation.getLeftOperand();
			final XExpression rightOperand = binaryOperation.getRightOperand();
			// we can inline boolean operations where both operands can be generated as expressions
			if (isReferenced
				&& expressionHelper.isBooleanAndOrOr(expr) 
				&& canCompileToJavaExpression(leftOperand, b) 
				&& canCompileToJavaExpression(rightOperand, b)) {
				return;
			}
			generateShortCircuitInvocation(expr, b);
		} else {
			if (expr instanceof XMemberFeatureCall && ((XMemberFeatureCall) expr).isNullSafe()) {
				compileNullSafeFeatureCall((XMemberFeatureCall) expr, b, isReferenced);
			} else {
				XExpression receiver = getActualReceiver(expr);
				if (receiver != null) {
					prepareExpression(receiver, b);
				}
				for (XExpression arg : getActualArguments(expr)) {
					prepareExpression(arg, b);
				}
				if (!isReferenced) {
					b.newLine();
					if (!expressionHelper.hasSideEffects(expr, false)) {
						b.append("/* ");
					}
					try {
						featureCalltoJavaExpression(expr, b, false);
						b.append(";");
					} finally {
						if (!expressionHelper.hasSideEffects(expr, false)) {
							b.append(" */");
						}
					}
				} else if (isVariableDeclarationRequired(expr, b, true)) {
					Later later = new Later() {
						@Override
						public void exec(ITreeAppendable appendable) {
							featureCalltoJavaExpression(expr, appendable, true);
						}
					};
					declareFreshLocalVariable(expr, b, later);
				}
			}
		}
	}

	protected ITreeAppendable appendLeftOperand(final XAbstractFeatureCall expr, ITreeAppendable appendable, boolean isExpressionContext) {
		XBinaryOperation binaryOperation = (XBinaryOperation) expr;
		XAbstractFeatureCall leftOperand = (XAbstractFeatureCall) binaryOperation.getLeftOperand();
		JvmIdentifiableElement feature = leftOperand.getFeature();
		if (appendable.hasName(feature)) {
			return appendable.append(appendable.getName(feature));
		}
		boolean hasReceiver = appendReceiver(leftOperand, appendable, isExpressionContext);
		if (hasReceiver) {
			appendable.append(".");
		}
		return appendable.append(feature.getSimpleName());
	}

	protected boolean needMultiAssignment(XAbstractFeatureCall expr) {
		if (expr instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) expr;
			return binaryOperation.isReassignFirstArgument();
		}
		return false;
	}

	private void compileNullSafeFeatureCall(final XMemberFeatureCall expr, ITreeAppendable b, final boolean isReferenced) {
		XExpression memberCallTarget = normalizeBlockExpression(expr.getMemberCallTarget());
		if (!isReferenced) {
			if (!expressionHelper.hasSideEffects(expr, false)) {
				b.append("/* ");
			}
			try {
				if (nullSafeMemberFeatureCallExpressionNeedsPreparation(memberCallTarget, b))
					prepareExpression(memberCallTarget, b);
				b.newLine().append("if (");
				internalToJavaExpression(memberCallTarget, b);
				b.append("!=null) {").increaseIndentation();
				for (XExpression arg : getActualArguments(expr)) {
					if (nullSafeMemberFeatureCallExpressionNeedsPreparation(arg, b))
						prepareExpression(arg, b);
				}
				b.newLine();
				featureCalltoJavaExpression(expr, b, false);
				b.append(";");
			} finally {
				b.decreaseIndentation().newLine().append("}");
				if (!expressionHelper.hasSideEffects(expr, false)) {
					b.append(" */");
				}
			}
		} else if (isVariableDeclarationRequired(expr, b)) {
			Later later = new Later() {
				@Override
				public void exec(ITreeAppendable appendable) {
					appendNullValueUntyped(getTypeForVariableDeclaration(expr), expr, appendable);
				}
			};
			if (nullSafeMemberFeatureCallExpressionNeedsPreparation(memberCallTarget, b))
				prepareExpression(memberCallTarget, b);
			declareFreshLocalVariable(expr, b, later);
			b.newLine().append("if (");
			internalToJavaExpression(memberCallTarget, b);
			b.append("!=null) {").increaseIndentation();
			try {
				for (XExpression arg : getActualArguments(expr)) {
					if (nullSafeMemberFeatureCallExpressionNeedsPreparation(arg, b))
						prepareExpression(arg, b);
				}
				b.newLine();
				b.append(b.getName(expr));
				b.append("=");
				featureCalltoJavaExpression(expr, b, true);
				b.append(";");
			} finally {
				b.decreaseIndentation().newLine().append("}");
			}
		}
	}
	
	protected XAbstractFeatureCall getFeatureCall(final XExpression argument) {
		EObject expr = argument.eContainer();
		if (expr instanceof XAbstractFeatureCall) {
			return (XAbstractFeatureCall) expr;
		}
		if (expr instanceof XBlockExpression) {
			XBlockExpression blockExpression = (XBlockExpression) expr;
			if (blockExpression.getExpressions().size() == 1)
				return getFeatureCall(blockExpression);
		}
		return null;
	}

	protected List<XExpression> getActualArguments(final XAbstractFeatureCall expr) {
		List<XExpression> actualArguments = expr.getActualArguments();
		return Lists.transform(actualArguments, new Function<XExpression, XExpression>() {
			@Override
			public XExpression apply(XExpression e) {
				return normalizeBlockExpression(e);
			}
		});
	}

	/* @Nullable */
	protected XExpression getActualReceiver(final XAbstractFeatureCall expr) {
		return expr.getActualReceiver();
	}
	
	protected void _toJavaStatement(final XFeatureCall expr, final ITreeAppendable b, boolean isReferenced) {
		// if it's a call to this() or super() make sure the arguments are forced to be compiled to expressions.
		if (expr.getFeature() instanceof JvmConstructor) {
			b.newLine();
			featureCalltoJavaExpression(expr, b, false);
			b.append(";");
		} else {
			_toJavaStatement((XAbstractFeatureCall) expr, b, isReferenced);
		}
	}

	protected void generateShortCircuitInvocation(final XAbstractFeatureCall featureCall, final ITreeAppendable b) {
		final XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
		final XExpression leftOperand = binaryOperation.getLeftOperand();
		final XExpression rightOperand = binaryOperation.getRightOperand();
		declareSyntheticVariable(binaryOperation, b);
		boolean isElvis = binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getElvisOperator());
		prepareExpression(leftOperand, b);
		if(isElvis) {
			b.newLine().append("if (");
			toJavaExpression(leftOperand, b);
			b.append(" != null) {").increaseIndentation();
			b.newLine().append(b.getName(binaryOperation)).append(" = ");
			toJavaExpression(leftOperand, b);
			b.append(";");
		} else {
			b.newLine().append("if (");
			if (binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getAndOperator())) {
				b.append("!");
			}
			toJavaExpression(leftOperand, b);
			b.append(") {").increaseIndentation();
			b.newLine().append(b.getName(binaryOperation)).append(" = ");
			b.append(Boolean.toString(binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getOrOperator()))).append(";");
		}
		b.decreaseIndentation().newLine().append("} else {").increaseIndentation();
		if (binaryOperation.getImplicitReceiver() != null) {
			internalToJavaStatement(binaryOperation.getImplicitReceiver(), b, true);
		}
		prepareExpression(rightOperand, b);
		b.newLine().append(b.getName(binaryOperation)).append(" = ");
		toJavaExpression(rightOperand, b);
		b.append(";");
		b.decreaseIndentation().newLine().append("}");
	}
	
	@Override
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		if (expression instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) expression;
			if (binaryOperation.isReassignFirstArgument()) {
				return false;
			}
		}
		if (expression instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
			if (isPrimitiveVoid(featureCall)) {
				return false;
			}
			for (XExpression arg : featureCall.getActualArguments()) {
				if (!this.internalCanCompileToJavaExpression(arg, appendable)) {
					return false;
				}
			}
			if (featureCall.getActualReceiver() != null && !internalCanCompileToJavaExpression(featureCall.getActualReceiver(), appendable)) {
				return false;
			}
			if (featureCall instanceof XMemberFeatureCall) {
				return !((XMemberFeatureCall) featureCall).isNullSafe();
			}
			return true;
		} else if (expression instanceof XConstructorCall) {
			XConstructorCall constructorCall = (XConstructorCall) expression;
			for (XExpression arg : constructorCall.getArguments()) {
				if (!this.internalCanCompileToJavaExpression(arg, appendable)) {
					return false;
				}
			}
			return true;
		}
		return super.internalCanCompileToJavaExpression(expression, appendable);
	}
	
	protected boolean isVariableDeclarationRequired(XMemberFeatureCall expr, @SuppressWarnings("unused") ITreeAppendable b) {
		return expr.isNullSafe();
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b, boolean recursive) {
		if (recursive && isVariableDeclarationRequired(getFeatureCall(expr), expr, b)) {
			return true;
		}
		final EStructuralFeature eContainingFeature = expr.eContainingFeature();
		if (eContainingFeature == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			if (((XMemberFeatureCall) expr.eContainer()).isNullSafe()) {
				if (expr instanceof XFeatureCall) {
					JvmIdentifiableElement feature = ((XFeatureCall) expr).getFeature();
					if (feature instanceof JvmField || feature instanceof JvmFormalParameter)
						return false;
					return !b.hasName(feature);
				}
				return !b.hasName(expr);
			} else {
				return false;
			}
		}
		if (eContainingFeature == XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND) {
			XBinaryOperation binaryOperation = (XBinaryOperation) expr.eContainer();
			if (binaryOperation.isReassignFirstArgument()) {
				return true;
			}
		}
		if (expr instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) expr;
			if (binaryOperation.isReassignFirstArgument()) {
				return true;
			}
		}
		if (expr instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expr;
			if (featureCall.isTypeLiteral() || featureCall.isPackageFragment()) {
				return false;
			}
			// we need to prefer expressions for constant expressions, so they get compiled correctly.
			// a binary or unary operator is constant if its method is annotated with @Inline(..., constantExpression=true)
			// and all arguments don't require variableDeclarations.
			if (isPotentialJavaOperation(featureCall)) {
				JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(featureCall);
				if (inlineAnnotation == null)
					return true;
				for (XExpression argument : featureCall.getActualArguments()) {
					if (isVariableDeclarationRequired(argument, b, recursive)) {
						return true;
					}
					if (argument instanceof XInstanceOfExpression && isVariableDeclarationRequired(((XInstanceOfExpression) argument).getExpression(), b, recursive)) {
						return true;
					}
					if (argument instanceof XCastedExpression && isVariableDeclarationRequired(((XCastedExpression) argument).getTarget(), b, recursive)) {
						return true;
					}
				}
				for (JvmAnnotationValue value: inlineAnnotation.getValues()) {
					if (value instanceof JvmBooleanAnnotationValue && value.getValueName().equals("constantExpression")) {
						EList<Boolean> values = ((JvmBooleanAnnotationValue )value).getValues();
						if (!values.isEmpty()) {
							return !values.get(0);
						}
					}
				}
				return true;
			}
			
			if (featureCall instanceof XMemberFeatureCall && isVariableDeclarationRequired((XMemberFeatureCall) featureCall, b))
				return true;
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature instanceof JvmField || feature instanceof JvmFormalParameter)
				return false;
			if (eContainingFeature == XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS
					|| eContainingFeature == XbasePackage.Literals.XASSIGNMENT__VALUE
					|| eContainingFeature == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS) {
				return false;
			}
			return !b.hasName(feature);
		}
		return super.isVariableDeclarationRequired(expr, b, recursive);
	}
	
	protected boolean isVariableDeclarationRequired(XAbstractFeatureCall featureCall, XExpression expression, ITreeAppendable b) {
		if (featureCall == null) 
			return false;
		
		XExpression actualReceiver = normalizeBlockExpression(getActualReceiver(featureCall));
		List<XExpression> arguments = getActualArguments(featureCall);
		
		XExpression argument = normalizeBlockExpression(expression);
		
		int argumentIndex = -1;
		if (actualReceiver != argument) {
			argumentIndex = arguments.indexOf(argument);
			if (argumentIndex == -1)
				return false;
		}
		
		if (!expressionHelper.hasSideEffects(argument))
			return false;
		
		int startIndex = argumentIndex + 1;
		int endIndex = arguments.size();
		for (int i = startIndex; i < endIndex; i++) {
			if (isVariableDeclarationRequired(arguments.get(i), b, false))
				return true;
		}
		return false;
	}

	private boolean isPotentialJavaOperation(XAbstractFeatureCall featureCall) {
		if (featureCall.isOperation()) {
			return true;
		}
		if (featureCall.eClass() == XbasePackage.Literals.XMEMBER_FEATURE_CALL && featureCall.isStatic() && featureCall.isExtension() && featureCall.getActualArguments().size() == 2) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature.eClass() == TypesPackage.Literals.JVM_OPERATION) {
				JvmDeclaredType declarator = ((JvmOperation) feature).getDeclaringType();
				if (IntegerExtensions.class.getName().equals(declarator.getIdentifier()) || LongExtensions.class.getName().equals(declarator.getIdentifier())) {
					String simpleName = feature.getSimpleName();
					if (simpleName.startsWith("bitwise") || simpleName.startsWith("shift")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	protected void prepareExpression(XExpression arg, ITreeAppendable b) {
		if (arg instanceof XAbstractFeatureCall && !(((XAbstractFeatureCall) arg).getFeature() instanceof JvmField)
				&& !isVariableDeclarationRequired(arg, b, true)) {
			// we have to convert the given value in a later step and the
			// conversion code may produce an anonymous class of the expected type
			// where the implementation needs to reference the value of this expression
			// thus we have to make sure that the value is stored in a final variable
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) arg;
			// check for final modifier
			if (featureCall.getFeature() instanceof XVariableDeclaration) {
				XVariableDeclaration variableDeclaration = (XVariableDeclaration) featureCall.getFeature();
				if (!variableDeclaration.isWriteable()) {
					internalToJavaStatement(arg, b, true);
				} else {
					LightweightTypeReference expectedType = getLightweightExpectedType(arg);
					LightweightTypeReference type = getLightweightType(arg);
					if (expectedType != null && !isJavaConformant(expectedType, type)) {
						String varName = getVarName(((XAbstractFeatureCall) arg).getFeature(), b);
						String finalVariable = b.declareSyntheticVariable(arg, "_converted_" + varName);
						b.newLine().append("final ");
						b.append(type);
						b.append(" ").append(finalVariable).append(" = ").append("(");
						b.append(type);
						b.append(")").append(varName).append(";");
					}
				}
				return;
			} else if (featureCall.getFeature() instanceof JvmFormalParameter) {
				// always final
				internalToJavaStatement(arg, b, true);
				return;
			}
		}
		
		internalToJavaStatement(arg, b, true);
		if (b.hasName(arg)) {
			// TODO investigate to generate all synthetic vars as final
			// but we'd have to revise the strategy for branch expressions, than.
			LightweightTypeReference type = getTypeForVariableDeclaration(arg);
			LightweightTypeReference expectation = getLightweightExpectedType(arg);
			if (expectation != null && type.isFunctionType() && !isJavaConformant(expectation, type)) {
				String mutableName = b.removeName(arg);
				String finalNameProposal = "_final" + mutableName;
				String finalName = b.declareSyntheticVariable(arg, finalNameProposal);
				b.newLine();
				b.append("final ");
				b.append(type);
				b.append(" ").append(finalName).append(" = ");
				b.append(mutableName);
				b.append(";");
			}
		}
	}
	
	protected void _toJavaExpression(XAbstractFeatureCall call, ITreeAppendable b) {
		if (call.isTypeLiteral()) {
			b.append((JvmType) call.getFeature()).append(".class");
		} else if (isPrimitiveVoid(call)) {
			throw new IllegalArgumentException("feature yields 'void'");
		} else {
			final String referenceName = getReferenceName(call, b);
			if (referenceName != null) {
				if (call instanceof XFeatureCall || call instanceof XMemberFeatureCall) {
					b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(referenceName);
				} else {
					b.trace(call, false).append(referenceName);
				}
			} else {
				featureCalltoJavaExpression(call, b, true);
			}
		}
	}

	private static boolean isConstantExpression(JvmAnnotationReference reference) {
		for (final JvmAnnotationValue annotationValue: reference.getValues()) {
			if ("constantExpression".equals(annotationValue.getValueName())) {
				if (annotationValue instanceof JvmBooleanAnnotationValue) {
					return ((JvmBooleanAnnotationValue) annotationValue).getValues().get(0).booleanValue();
				} else if (annotationValue instanceof JvmCustomAnnotationValue) {
					final EObject value = ((JvmCustomAnnotationValue) annotationValue).getValues().get(0);
					if (value instanceof XBooleanLiteral) {
						return ((XBooleanLiteral) value).isIsTrue();
					}
				}
			}
		}
		return false;
	}

	protected void featureCalltoJavaExpression(final XAbstractFeatureCall call, ITreeAppendable b, boolean isExpressionContext) {
		if (call instanceof XAssignment) {
			assignmentToJavaExpression((XAssignment) call, b, isExpressionContext);
		} else {
			if (needMultiAssignment(call)) {
				appendLeftOperand(call, b, isExpressionContext).append(" = ");
			}
			final JvmAnnotationReference annotationRef = this.expressionHelper.findInlineAnnotation(call);
			if (annotationRef == null || !isConstantExpression(annotationRef)) {
				boolean hasReceiver = appendReceiver(call, b, isExpressionContext);
				if (hasReceiver) {
					b.append(".");
					b = appendTypeArguments(call, b);
				}
			}
			appendFeatureCall(call, b);
		}
	}

	protected ITreeAppendable appendTypeArguments(final XAbstractFeatureCall call, ITreeAppendable original) {
		ILocationData completeLocationData = getLocationWithTypeArguments(call);
		ITreeAppendable completeFeatureCallAppendable = completeLocationData != null ? original.trace(completeLocationData) : original;
		if (!call.getTypeArguments().isEmpty()) {
			/*
			 * We want to create the following trace regions
			 *  receiver.  < type ,  arguments >   name ( 'param' )
			 * |         || [    ]  [         ] ||[    ] [       ] |||
			 * |         |[                     ][                 ]||
			 * |         [                                          ]|
			 * [                                                     ]
			 */
			ILocationData argumentsLocationData = null;
			if (completeLocationData != null) {
				argumentsLocationData = getLocationOfTypeArguments(call);
			}
			ITreeAppendable typeArgumentsAppendable = argumentsLocationData != null ? completeFeatureCallAppendable.trace(argumentsLocationData) : completeFeatureCallAppendable;
			typeArgumentsAppendable.append("<");
			for (int i = 0; i < call.getTypeArguments().size(); i++) {
				if (i != 0) {
					typeArgumentsAppendable.append(", ");
				}
				JvmTypeReference typeArgument = call.getTypeArguments().get(i);
				ITreeAppendable singleTypeArgumentAppendable = typeArgumentsAppendable.trace(typeArgument, false);
				serialize(typeArgument, call, singleTypeArgumentAppendable);
			}
			typeArgumentsAppendable.append(">");
			ILocationData featureAndArgumentLocation = null;
			if (completeLocationData != null) {
				if (argumentsLocationData != null) {
					featureAndArgumentLocation = getLocationWithoutTypeArguments(call);
				}
			}
			ITreeAppendable result = featureAndArgumentLocation != null ? completeFeatureCallAppendable.trace(featureAndArgumentLocation) : completeFeatureCallAppendable;
			return result;
		} else if (call.getFeature() instanceof JvmExecutable) {
			final JvmExecutable executable = (JvmExecutable) call.getFeature();
			if (!executable.getTypeParameters().isEmpty()) {
				List<LightweightTypeReference> typeArguments = getResolvedTypes(call).getActualTypeArguments(call);
				List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayList();
				boolean containedUnresolved = false;
				for (int i = 0; i < executable.getTypeParameters().size() && !containedUnresolved; i++) {
					LightweightTypeReference typeArgument = typeArguments.get(i);
					if (typeArgument != null) {
						if (typeArgument.isWildcard()) {
							containedUnresolved = true;
						} else {
							resolvedTypeArguments.add(typeArgument.toJavaCompliantTypeReference());
						}
					} else {
						containedUnresolved = true;
					}
				}
				if (!containedUnresolved) {
					completeFeatureCallAppendable.append("<");
					for (int i = 0; i < resolvedTypeArguments.size(); i++) {
						if (i != 0) {
							completeFeatureCallAppendable.append(", ");
						}
						JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
						serialize(typeArgument, call, completeFeatureCallAppendable);
					}
					completeFeatureCallAppendable.append(">");
				}
			}
		}
		return completeFeatureCallAppendable;
	}
	
	/* @Nullable */
	protected ILocationData getLocationWithoutTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall || call instanceof XMemberFeatureCall) {
				boolean featureReferenceSeen = false;
				for (INode child : startNode.getChildren()) {
					if (featureReferenceSeen) {
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof CrossReference) {
							Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
							if (assignment != null && "feature".equals(assignment.getFeature())) {
								featureReferenceSeen = true;
								resultNodes.add(child);
							}
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	/* @Nullable */
	protected ILocationData getLocationWithTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall) {
				for (INode child : startNode.getChildren()) {
					resultNodes.add(child);
				}
			} else if (call instanceof XMemberFeatureCall) {
				boolean keywordSeen = false;
				for (INode child : startNode.getChildren()) {
					if (keywordSeen) {
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							keywordSeen = true;
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}
	
	/* @Nullable */
	protected ILocationData getLocationOfTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall) {
				for (INode child : startNode.getChildren()) {
					if (child.getGrammarElement() instanceof CrossReference)
						break;
					resultNodes.add(child);
				}
			} else if (call instanceof XMemberFeatureCall) {
				boolean keywordSeen = false;
				for (INode child : startNode.getChildren()) {
					if (keywordSeen) {
						if (child.getGrammarElement() instanceof CrossReference)
							break;
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							keywordSeen = true;
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	/* @Nullable */
	protected ILocationData toLocationData(List<INode> nodes) {
		ITextRegionWithLineInformation result = ITextRegionWithLineInformation.EMPTY_REGION;
		for (INode node : nodes) {
			if (!isHidden(node)) {
				ITextRegionWithLineInformation region = node.getTextRegionWithLineInformation();
				if (region.getLength() != 0) {
					result = result.merge(new TextRegionWithLineInformation(region.getOffset(), region.getLength(), region.getLineNumber() - 1, region.getEndLineNumber() - 1));
				}
			}
		}
		if (result.getLength() == 0)
			return null;
		return new LocationData(result.getOffset(), result.getLength(), result.getLineNumber(),
				result.getEndLineNumber(), null);
	}

	protected boolean isHidden(INode node) {
		return node instanceof ILeafNode && ((ILeafNode) node).isHidden();
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, ITreeAppendable b, @SuppressWarnings("unused") boolean isExpressionContext) {
		if (call.isStatic()) {
			if (expressionHelper.findInlineAnnotation(call) != null) {
				return false;
			}
			if (call instanceof XMemberFeatureCall) {
				XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) call;
				if (memberFeatureCall.isStaticWithDeclaringType()) {
					XAbstractFeatureCall target = (XAbstractFeatureCall) memberFeatureCall.getMemberCallTarget();
					JvmType declaringType = (JvmType) target.getFeature();
					b.trace(target, false).append(declaringType);
					return true;
				}
			}
			b.append(((JvmFeature) call.getFeature()).getDeclaringType());
			return true;
		}
		XExpression receiver = getActualReceiver(call);
		if (receiver != null) {
			internalToJavaExpression(receiver, b);
			if (receiver instanceof XAbstractFeatureCall) {
				// some local types have a reference name bound to the empty string
				// which is the reason why we have to check for an empty string as a valid
				// reference name here
				// see AnonymousClassCompilerTest.testCapturedLocalVar_04
				// if it turns out that we have to deal with generics there too, we may
				// have to create a field in the synthesized local class with a unique
				// name that points to 'this'
				if (((XAbstractFeatureCall) receiver).getFeature() instanceof JvmType) {
					String referenceName = getReferenceName(receiver, b);
					if (referenceName != null && referenceName.length() == 0) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	protected void appendNullValue(JvmTypeReference type, EObject context, ITreeAppendable b) {
		if (!primitives.isPrimitive(type)) {
			if (!(type.getType() instanceof JvmVoid)) {
				b.append("(");
				serialize(type, context, b);
				b.append(")");
			}
			b.append("null");
		} else {
			b.append(getDefaultLiteral((JvmPrimitiveType) type.getType()));
		}
	}
	
	protected void appendNullValueUntyped(LightweightTypeReference type, @SuppressWarnings("unused") EObject context, ITreeAppendable b) {
		if (!type.isPrimitive()) {
			b.append("null");
		} else {
			b.append(getDefaultLiteral((JvmPrimitiveType) type.getType()));
		}
	}

	protected String getDefaultLiteral(JvmPrimitiveType primitiveType) {
		final String name = primitiveType.getIdentifier();
		if (Boolean.TYPE.getName().equals(name)) {
			return "false";
		}
		if (Integer.TYPE.getName().equals(name)) {
			return "0";
		}
		if (Byte.TYPE.getName().equals(name)) {
			return "(byte) 0";
		}
		if (Short.TYPE.getName().equals(name)) {
			return "(short) 0";
		}
		if (Character.TYPE.getName().equals(name)) {
			return "(char) 0";
		}
		if (Long.TYPE.getName().equals(name)) {
			return "0l";
		}
		if (Float.TYPE.getName().equals(name)) {
			return "0f";
		}
		if (Double.TYPE.getName().equals(name)) {
			return "0.0";
		}
		throw new IllegalArgumentException("Unkown primitive " + name);
	}

	protected boolean isMemberCall(XAbstractFeatureCall call) {
		return !call.isStatic();
	}
	
	protected boolean isReferenceToSelf(XFeatureCall featureCall, JvmType type) {
		return !featureCall.isTypeLiteral() && !featureCall.isPackageFragment()
				&& type.equals(featureCall.getFeature())
				&& IFeatureNames.SELF.getFirstSegment().equals(featureCall.getConcreteSyntaxFeatureName());
	}

	protected void assignmentToJavaExpression(XAssignment expr, ITreeAppendable b, boolean isExpressionContext) {
		final JvmIdentifiableElement feature = expr.getFeature();
		if (feature instanceof JvmOperation) {
			boolean appendReceiver = appendReceiver(expr, b, isExpressionContext);
			if (appendReceiver)
				b.append(".");
			appendFeatureCall(expr, b);
		} else {
			boolean isArgument = expr.eContainer() instanceof XAbstractFeatureCall;
			if (isArgument) {
				EStructuralFeature containingFeature = expr.eContainingFeature();
				if (containingFeature == XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS 
						|| containingFeature == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS) {
					isArgument = false;
				} else {
					b.append("(");
				}
			}
			if (feature instanceof JvmField) {
				boolean appendReceiver = appendReceiver(expr, b, isExpressionContext);
				if (appendReceiver)
					b.append(".");
				appendFeatureCall(expr, b);
			} else {
				String name = b.getName(expr.getFeature());
				b.append(name);
			}
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
			if (isArgument) {
				b.append(")");
			}
		}
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		if (expressionHelper.isInlined(call)) {
			appendInlineFeatureCall(call, b);
			return;
		}
		JvmIdentifiableElement feature = call.getFeature();
		String name = null;
		if (feature instanceof JvmConstructor) {
			JvmDeclaredType constructorContainer = ((JvmConstructor) feature).getDeclaringType();
			JvmIdentifiableElement logicalContainer = contextProvider.getNearestLogicalContainer(call);
			JvmDeclaredType contextType = ((JvmMember) logicalContainer).getDeclaringType();
			if (contextType == constructorContainer)
				name = "this";
			else
				name = "super";
		} else if(feature != null) {
			if (b.hasName(feature)) {
				name = b.getName(feature);
			} else {
				name = featureNameProvider.getSimpleName(feature);
			}
		}
		if(name == null)
			name = "/* name is null */";
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = getActualArguments(call);
			if (!arguments.isEmpty()) {
				XExpression receiver = null;
				if (call instanceof XMemberFeatureCall) {
					receiver = ((XMemberFeatureCall) call).getMemberCallTarget();
				} else if (call instanceof XAssignment) {
					receiver = ((XAssignment) call).getAssignable();
				}
				boolean shouldBreakFirstArgument = receiver == null || arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
		}
	}

	private Pattern pattern = Pattern.compile("\\$(\\$|[0-9]+)");
	
	@Inject IBatchTypeResolver batchTypeResolver;
	
	protected void appendInlineFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(call);
		String formatString = null;
		List<JvmTypeReference> importedTypes = Lists.newArrayListWithCapacity(2);
		for(JvmAnnotationValue annotationValue: inlineAnnotation.getValues()) {
			if ("value".equals(annotationValue.getValueName()) || null == annotationValue.getValueName()) {
				if (annotationValue instanceof JvmStringAnnotationValue) {
					formatString = ((JvmStringAnnotationValue)annotationValue).getValues().get(0);
				} else if (annotationValue instanceof JvmCustomAnnotationValue) {
					JvmCustomAnnotationValue customAnnotationValue = (JvmCustomAnnotationValue) annotationValue;
					if (customAnnotationValue.getValues().size() == 1) {
						if (customAnnotationValue.getValues().get(0) instanceof XStringLiteral) {
							formatString = ((XStringLiteral)customAnnotationValue.getValues().get(0)).getValue();
						}
					}
				}
				
			} else if ("imported".equals(annotationValue.getValueName())) {
				if (annotationValue instanceof JvmTypeAnnotationValue) {					
					JvmTypeAnnotationValue typeAnnotationValue = (JvmTypeAnnotationValue) annotationValue;
					importedTypes.addAll(typeAnnotationValue.getValues());
				} else if (annotationValue instanceof JvmCustomAnnotationValue) {					
					JvmCustomAnnotationValue customAnnotationValue = (JvmCustomAnnotationValue) annotationValue;
					if (customAnnotationValue.getValues().size() == 1) {
						if (customAnnotationValue.getValues().get(0) instanceof XListLiteral) {
							EList<XExpression> elements = ((XListLiteral)customAnnotationValue.getValues().get(0)).getElements();
							for (XExpression e : elements) {
								LightweightTypeReference lightweightType = getLightweightType(e);
								if (lightweightType != null && lightweightType.isType(Class.class)) {
									importedTypes.add(lightweightType.toTypeReference());
								}
							}
						}
					}
				} else {
					throw new IllegalStateException("Unhandled 'imported' AnnotationValue type " + annotationValue.getClass());
				}
			}
		}
		if (formatString == null)
			throw new IllegalStateException();
		boolean inlineCallNeedsParenthesis = inlineCallNeedsParenthesis(call, formatString);
		if (inlineCallNeedsParenthesis) {
			b.append("(");
		}
		
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(call);
		List<XExpression> arguments = getActualArguments(call);
		Matcher matcher = pattern.matcher(formatString);
		int prevEnd = 0;
		while(matcher.find()) {
			int start = matcher.start();
			if (start != prevEnd) {
				b.append(formatString.substring(prevEnd, start));
			}
			String indexOrDollar = matcher.group(1);
			if ("$".equals(indexOrDollar)) {
				b.append("$");
			} else {
				int index = Integer.parseInt(indexOrDollar) - 1;
				int numberImports = importedTypes.size();
				int numberArguments = arguments.size();
				if (index > numberArguments+numberImports) {
					List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(call);
					LightweightTypeReference typeArgument = typeArguments.get(index - (numberArguments+numberImports+1));
					serialize(typeArgument.getRawTypeReference().toTypeReference(), call, b);
				} else if (index >= numberArguments && index < numberArguments + numberImports) {
					serialize(importedTypes.get(index - numberArguments), call, b);
				} else if (index == numberArguments + numberImports) {
					appendTypeArguments(call, b);
				} else {
					XExpression argument = arguments.get(index);
					appendArgument(argument, b, index > 0);
				}
			}
			prevEnd = matcher.end();
		}
		if (prevEnd != formatString.length()) {
			b.append(formatString.substring(prevEnd));
		}
		if (inlineCallNeedsParenthesis) {
			b.append(")");
		}
	}
	
	protected boolean inlineCallNeedsParenthesis(XAbstractFeatureCall call, String formatString) {
		String trimmedFormatString = formatString.trim();
		if (trimmedFormatString.startsWith("(")) {
			return false;
		}
		if (call.eContainer() instanceof XMemberFeatureCall && call.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall mfc = (XMemberFeatureCall) call.eContainer();
			JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(mfc);
			if (inlineAnnotation != null) {
				return true;
			}
			if (mfc.isExtension()) {
				return false;
			}
			return !trimmedFormatString.endsWith(")");
		}
		return false;
	}
	
	protected void appendArguments(List<? extends XExpression> arguments, ITreeAppendable b) {
		appendArguments(arguments, b, true);
	}
	
	protected void appendArguments(List<? extends XExpression> arguments, ITreeAppendable b, boolean shouldWrapLine) {
		for (int i = 0; i < arguments.size(); i++) {
			XExpression argument = arguments.get(i);
			appendArgument(argument, b, shouldWrapLine || i > 0);
			if (i + 1 < arguments.size())
				b.append(", ");
		}
	}
	
	protected void appendArgument(XExpression argument, ITreeAppendable b) {
		appendArgument(argument, b, true);
	}
	
	protected void appendArgument(XExpression argument, ITreeAppendable b, boolean doLineWrappingIfSourceWasWrapped) {
		final String referenceName = getReferenceName(argument, b);
		/*
		 * This is done to support better debugging experience.
		 * Consider the following xbase expression:
		 * 
		 * foo(
		 *   new String())
		 *   
		 *  The compiler could translate that to a single line, but then the two lines in the source would map
		 *  to the same line in the Java code, so it's not possible to have two steps. 
		 *  Therefore we add a newline in the Java if the user had one the expression defined in a new line.
		 */
		final boolean needsNewLine = doLineWrappingIfSourceWasWrapped && referenceName == null && isDeclaredInNewLine(argument);
		if (needsNewLine) {
			b.increaseIndentation();
			b.newLine();
		}
		if (referenceName == null && isVariableDeclarationRequired(argument, b, true)) {
			if (canCompileToJavaExpression(argument, b)) {
				internalToJavaExpression(argument, b);
			} else {
				LightweightTypeReference type = getLightweightExpectedType(argument);
				if (type == null)
					type = getLightweightType(argument);
				compileAsJavaExpression(argument, b, type);
			}
		} else {
			internalToJavaExpression(argument, b);
		}
		if (needsNewLine) {
			b.decreaseIndentation();
		}
	}
	
	protected boolean isDeclaredInNewLine(XExpression obj) {
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node != null) {
			int line = -1;
			for(ILeafNode n : node.getLeafNodes()) {
				if (n.isHidden() && line == -1)
					line = n.getStartLine();
				if (!n.isHidden() && line != -1)
					return line != n.getStartLine();
			}
		}
		return false;
	}

	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return contextProvider;
	}
	
	protected ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}
}
