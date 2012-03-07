/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
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
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typing.JvmOnlyTypeConformanceComputer;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FeatureCallCompiler extends LiteralsCompiler {

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(FeatureCallCompiler.class);

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;

	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private JvmOnlyTypeConformanceComputer jvmConformance;

	@Inject
	private Primitives primitives;

	@Inject
	private ILogicalContainerProvider contextProvider;

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

	protected void _toJavaStatement(final XAbstractFeatureCall expr, ITreeAppendable b, final boolean isReferenced) {
		if (expressionHelper.isShortCircuiteBooleanOperation(expr)) {
			generateShortCircuitInvocation(expr, b);
		} else {
			XExpression receiver = featureCallToJavaMapping.getActualReceiver(expr);
			if (receiver != null) {
				prepareExpression(receiver, b);
			}
			for (XExpression arg : featureCallToJavaMapping.getActualArguments(expr)) {
				prepareExpression(arg, b);
			}
			if (!isReferenced) {
				b.newLine();
				if (!expressionHelper.isJavaStatementExpression(expr)) {
					b.append("/*");
				}
				featureCalltoJavaExpression(expr, b, false);
				b.append(";");
				if (!expressionHelper.isJavaStatementExpression(expr)) {
					b.append("*/");
				}
			} else if (isVariableDeclarationRequired(expr, b)) {
				Later later = new Later() {
					public void exec(ITreeAppendable appendable) {
						featureCalltoJavaExpression(expr, appendable, true);
					}
				};
				declareFreshLocalVariable(expr, b, later);
			}
		}
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

	protected void generateShortCircuitInvocation(final XAbstractFeatureCall binaryOperation, final ITreeAppendable b) {
		XExpression leftOperand = ((XBinaryOperation) binaryOperation).getLeftOperand();
		declareSyntheticVariable(binaryOperation, b);
		prepareExpression(leftOperand, b);
		b.newLine().append("if (");
		if (binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getAndOperator())) {
			b.append("!");
		}
		toJavaExpression(leftOperand, b);
		b.append(") {").increaseIndentation();
		boolean rightOperand = binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getOrOperator());
		b.newLine().append(b.getName(binaryOperation)).append(" = ").append(Boolean.toString(rightOperand)).append(";");

		b.decreaseIndentation().newLine().append("} else {").increaseIndentation();

		if (binaryOperation.getImplicitReceiver() != null) {
			internalToJavaStatement(binaryOperation.getImplicitReceiver(), b, true);
		}
		for (XExpression arg : binaryOperation.getExplicitArguments()) {
			if (arg != leftOperand)
				prepareExpression(arg, b);
		}

		b.newLine().append(b.getName(binaryOperation)).append(" = ");
		featureCalltoJavaExpression(binaryOperation, b, true);
		b.append(";");
		b.decreaseIndentation().newLine().append("}");
	}

	/**
	 * @returns the variable name under which the result of the expression is stored. Returns <code>null</code> if the
	 *          expression hasn't been assigned to a local variable before.
	 */
	protected String getReferenceName(XExpression expr, ITreeAppendable b) {
		if (b.hasName(expr))
			return b.getName(expr);
		if (expr instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) expr;
			if (b.hasName(featureCall.getFeature()))
				return b.getName(featureCall.getFeature());
		}
		return null;
	}

	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XAssignment)
			return true;
		if (expr instanceof XAbstractFeatureCall) {
			JvmIdentifiableElement feature = ((XAbstractFeatureCall) expr).getFeature();
			if (feature instanceof JvmField || feature instanceof JvmFormalParameter) {
				return expr instanceof XMemberFeatureCall && ((XMemberFeatureCall) expr).isNullSafe();
			}
			return !b.hasName(feature);
		}
		return super.isVariableDeclarationRequired(expr, b);
	}

	protected void prepareExpression(XExpression arg, ITreeAppendable b) {
		if (arg instanceof XAbstractFeatureCall && !(((XAbstractFeatureCall) arg).getFeature() instanceof JvmField)
				&& !isVariableDeclarationRequired(arg, b)) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(arg);
			JvmTypeReference type = getTypeProvider().getType(arg);
			if (expectedType != null && !jvmConformance.isConformant(expectedType, type)) {
				String varName = getVarName(((XAbstractFeatureCall) arg).getFeature(), b);
				String finalVariable = b.declareSyntheticVariable(arg, "_converted_" + varName);
				b.newLine().append("final ");
				serialize(type, arg, b);
				b.append(" ").append(finalVariable).append(" = ").append("(");
				serialize(type, arg, b);
				b.append(")").append(varName).append(";");
			}
		} else {
			internalToJavaStatement(arg, b, true);
		}
	}

	protected void _toJavaExpression(XAbstractFeatureCall call, ITreeAppendable b) {
		if (isPrimitiveVoid(call)) {
			b.append("null");
		} else {
			final String referenceName = getReferenceName(call, b);
			if (referenceName != null) {
				b.trace(call, false).append(referenceName);
			} else {
				featureCalltoJavaExpression(call, b, true);
			}
		}
	}

	protected void featureCalltoJavaExpression(final XAbstractFeatureCall call, ITreeAppendable b, boolean isExpressionContext) {
		if (call instanceof XAssignment) {
			xAssignmentToJavaExpression((XAssignment) call, b, isExpressionContext);
		} else {
			boolean hasReceiver = appendReceiver(call, b, isExpressionContext);
			if (hasReceiver) {
				b.append(".");
				b = appendTypeArguments(call, b);
			}
			appendFeatureCall(call, b);
		}
	}

	protected ITreeAppendable appendTypeArguments(final XAbstractFeatureCall call, ITreeAppendable b) {
		if (!call.getTypeArguments().isEmpty()) {
			ILocationData locationData = getLocationWithTypeArguments(call);
			ITreeAppendable typeArgumentsAppendable = b;
			if (locationData != null)
				typeArgumentsAppendable = b.trace(locationData);
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
		} else if (call.getFeature() instanceof JvmExecutable) {
			final JvmExecutable executable = (JvmExecutable) call.getFeature();
			if (!executable.getTypeParameters().isEmpty()) {
				XExpression receiver = featureCallToJavaMapping.getActualReceiver(call);
				final JvmTypeReference receiverType = receiver != null ? getTypeProvider().getType(receiver) : null;
				final JvmTypeReference expectedType = getTypeProvider().getExpectedType(call);
				final List<JvmTypeReference> argumentTypes = Lists.newArrayList();
				for (XExpression argument : featureCallToJavaMapping.getActualArguments(call)) {
					argumentTypes.add(getTypeProvider().getType(argument));
				}

				ITypeArgumentContext typeArgumentContext = getContextProvider().getTypeArgumentContext(
						new TypeArgumentContextProvider.AbstractRequest() {
							@Override
							public JvmFeature getFeature() {
								return executable;
							}

							@Override
							public JvmTypeParameterDeclarator getNearestDeclarator() {
								EObject context = call;
								JvmTypeParameterDeclarator result = null;
								while (context != null && result == null) {
									if (context instanceof JvmTypeParameterDeclarator) {
										result = (JvmTypeParameterDeclarator) context;
									} else {
										JvmIdentifiableElement logicalContainer = contextProvider
												.getLogicalContainer(context);
										if (logicalContainer != null) {
											context = logicalContainer;
										} else {
											context = context.eContainer();
										}
									}
								}
								return result;
							}

							@Override
							public JvmTypeReference getDeclaredType() {
								if (executable instanceof JvmOperation)
									return ((JvmOperation) executable).getReturnType();
								return null;
							}

							@Override
							public JvmTypeReference getReceiverType() {
								return receiverType;
							}

							@Override
							public JvmTypeReference getExpectedType() {
								return expectedType;
							}

							@Override
							public List<JvmTypeReference> getArgumentTypes() {
								return argumentTypes;
							}

							@Override
							public String toString() {
								return "FeatureCallCompiler.featureCalltoJavaExpression [call=" + call + "]";
							}
						});
				List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayList();
				boolean containedUnresolved = false;
				for (int i = 0; i < executable.getTypeParameters().size() && !containedUnresolved; i++) {
					JvmTypeParameter typeParameter = executable.getTypeParameters().get(i);
					JvmTypeReference typeArgument = typeArgumentContext.getBoundArgument(typeParameter);
					if (typeArgument != null) {
						if (isReferenceToForeignTypeParameter(typeArgument, call)) {
							containedUnresolved = true;
						} else if (typeArgument instanceof JvmWildcardTypeReference) {
							containedUnresolved = true;
						} else {
							typeArgument = getPrimitives().asWrapperTypeIfPrimitive(typeArgument);
							typeArgument = resolveMultiType(typeArgument);
							resolvedTypeArguments.add(typeArgument);
						}
					} else {
						containedUnresolved = true;
					}
				}
				if (!containedUnresolved) {
					b.append("<");
					for (int i = 0; i < resolvedTypeArguments.size(); i++) {
						if (i != 0) {
							b.append(", ");
						}
						JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
						serialize(typeArgument, call, b);
					}
					b.append(">");
				}
			}
		}
		return b;
	}

	protected ILocationData getLocationWithTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		List<INode> resultNodes = Lists.newArrayList();
		if (call instanceof XFeatureCall) {
			if (((XFeatureCall) call).getDeclaringType() != null) {
				boolean crossRefSeen = false;
				for (INode child : startNode.getChildren()) {
					if (crossRefSeen) {
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof CrossReference) {
							crossRefSeen = true;
						}
					}
				}
			} else {
				for (INode child : startNode.getChildren()) {
					resultNodes.add(child);
				}
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
		ITextRegionWithLineInformation result = ITextRegionWithLineInformation.EMPTY_REGION;
		for (INode node : resultNodes) {
			if (!isHidden(node)) {
				int length = node.getLength();
				if (length != 0)
					result = result.merge(new TextRegionWithLineInformation(node.getOffset(), length, node
							.getStartLine() - 1, node.getEndLine() - 1));
			}
		}
		if (result.getLength() == 0)
			return null;
		return new LocationData(result.getOffset(), result.getLength(), result.getLineNumber(),
				result.getEndLineNumber(), null, null);
	}

	protected boolean isHidden(INode node) {
		return node instanceof ILeafNode && ((ILeafNode) node).isHidden();
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, ITreeAppendable b, boolean isExpressionContext) {
		if (call instanceof XMemberFeatureCall) {
			XMemberFeatureCall expr = ((XMemberFeatureCall) call);
			if (expr.isNullSafe()) {
				if (isExpressionContext) {
					internalToJavaExpression(expr.getMemberCallTarget(), b);
					b.append("==null?");
					JvmTypeReference type = getTypeProvider().getType(call);
					appendNullValue(type, call, b);
					b.append(":");
				} else {
					b.append("if (");
					internalToJavaExpression(expr.getMemberCallTarget(), b);
					b.append("!=null) ");
				}
			}
		}
		if (isStatic(call.getFeature())) {
			if (expressionHelper.findInlineAnnotation(call) != null) {
				return false;
			}
			if (call instanceof XFeatureCall) {
				XFeatureCall call2 = (XFeatureCall) call;
				if (call2.getDeclaringType() != null) {
					b.append(call2.getDeclaringType());
					return true;
				}
			}
			b.append(((JvmFeature) call.getFeature()).getDeclaringType());
			return true;
		}
		XExpression receiver = featureCallToJavaMapping.getActualReceiver(call);
		if (receiver != null) {
			internalToJavaExpression(receiver, b);
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

//	protected boolean isInlined(XAbstractFeatureCall featureCall) {
//		JvmAnnotationReference inlineAnnotation = findInlineAnnotation(featureCall);
//		return inlineAnnotation != null;
//	}



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
		return featureCallToJavaMapping.isTargetsMemberSyntaxCall(call, call.getFeature(), call.getImplicitReceiver());
	}

	protected boolean isStatic(JvmIdentifiableElement feature) {
		if (feature instanceof JvmOperation) {
			return ((JvmOperation) feature).isStatic();
		} else if (feature instanceof JvmField) {
			return ((JvmField) feature).isStatic();
		}
		return false;
	}

	protected void xAssignmentToJavaExpression(XAssignment expr, ITreeAppendable b, boolean isExpressionContext) {
		final JvmIdentifiableElement feature = expr.getFeature();
		if (feature instanceof JvmOperation) {
			boolean appendReceiver = appendReceiver(expr, b, isExpressionContext);
			if (appendReceiver)
				b.append(".");
			appendFeatureCall(expr, b);
		} else {
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
		}
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		if (expressionHelper.isInlined(call)) {
			appendInlineFeatureCall(call, b);
			return;
		}
		JvmIdentifiableElement feature = call.getFeature();
		String name;
		if (feature instanceof JvmConstructor) {
			JvmDeclaredType constructorContainer = ((JvmConstructor) feature).getDeclaringType();
			JvmIdentifiableElement logicalContainer = contextProvider.getNearestLogicalContainer(call);
			JvmDeclaredType contextType = ((JvmMember) logicalContainer).getDeclaringType();
			if (contextType == constructorContainer)
				name = "this";
			else
				name = "super";
		} else {
			name = featureNameProvider.getSimpleName(feature);
		}
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(call);
			appendArguments(arguments, b);
			b.append(")");
		}
	}

	private Pattern pattern = Pattern.compile("\\$(\\$|[0-9]+)");
	
	protected void appendInlineFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(call);
		String formatString = null;
		List<JvmTypeReference> importedTypes = Lists.newArrayListWithCapacity(2);
		for(JvmAnnotationValue annotationValue: inlineAnnotation.getValues()) {
			if ("value".equals(annotationValue.getValueName())) {
				formatString = ((JvmStringAnnotationValue)annotationValue).getValues().get(0);
			} else if ("imported".equals(annotationValue.getValueName())) {
				JvmTypeAnnotationValue typeAnnotationValue = (JvmTypeAnnotationValue) annotationValue;
				importedTypes.addAll(typeAnnotationValue.getValues());
			}
		}
		if (formatString == null)
			throw new IllegalStateException();
		List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(call);
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
				if (index >= arguments.size() && index < arguments.size() + importedTypes.size()) {
					serialize(importedTypes.get(index - arguments.size()), call, b);
				} else if (index == arguments.size() + importedTypes.size()) {
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
	}
	
	protected void appendArguments(List<? extends XExpression> arguments, ITreeAppendable b) {
		if (arguments == null)
			return;
		for (int i = 0; i < arguments.size(); i++) {
			XExpression argument = arguments.get(i);
			appendArgument(argument, b);
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
		if (referenceName == null && isVariableDeclarationRequired(argument, b)) {
			JvmTypeReference type = getTypeProvider().getExpectedType(argument);
			if (type == null)
				type = getTypeProvider().getType(argument);
			compileAsJavaExpression(argument, b, type);
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

	protected JvmTypeReference getUpperBound(XAbstractFeatureCall call, final EList<JvmTypeConstraint> constraints) {
		JvmTypeReference typeArg;
		if (constraints.isEmpty()) {
			typeArg = getTypeReferences().getTypeForName(Object.class, call);
		} else {
			typeArg = constraints.get(0).getTypeReference();
		}
		return typeArg;
	}

	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return contextProvider;
	}
}
