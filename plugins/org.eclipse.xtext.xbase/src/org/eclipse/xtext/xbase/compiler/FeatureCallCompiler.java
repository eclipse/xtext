/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
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
	
	protected void _toJavaStatement(final XAbstractFeatureCall expr, final IAppendable b, boolean isReferenced) {
		if (isSpreadingMemberFeatureCall(expr)) {
			prepareSpreadingMemberFeatureCall((XMemberFeatureCall) expr, b);
		} else {
			if (expressionHelper.isShortCircuiteBooleanOperation(expr)) {
				generateShortCircuitInvocation(expr, b);
			} else {
				if (expr.getImplicitReceiver() != null) {
					internalToJavaStatement(expr.getImplicitReceiver(), b, true);
				}
				for (XExpression arg : expr.getExplicitArguments()) {
					prepareExpression(arg, b);
				}
				if (!isVariableDeclarationRequired(expr, b)) {
					// nothing to do
				} else {
					if (isReferenced && !isPrimitiveVoid(expr)) {
						Later later = new Later() {
							@Override
							public void exec() {
								featureCalltoJavaExpression(expr, b);
							}
						};
						declareSyntheticVariable(expr, b, later);
					} else {
						b.append("\n");
						featureCalltoJavaExpression(expr, b);
						b.append(";");
					}
				}
			}
		}
	}
	
	protected void _toJavaStatement(final XFeatureCall expr, final IAppendable b, boolean isReferenced) {
		if (expr.getFeature() instanceof JvmConstructor) {
			b.append("\n");
			featureCalltoJavaExpression(expr, b, true);
			b.append(";");
		} else {
			_toJavaStatement((XAbstractFeatureCall) expr, b, isReferenced);
		}
	}

	protected void generateShortCircuitInvocation(final XAbstractFeatureCall binaryOperation,
			final IAppendable b) {
		XExpression leftOperand = ((XBinaryOperation)binaryOperation).getLeftOperand();
		declareSyntheticVariable(binaryOperation, b);
		prepareExpression(leftOperand, b);
		b.append("\nif (");
		if (binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getAndOperator())) {
			b.append("!");
		}
		toJavaExpression(leftOperand, b);
		b.append(") {").increaseIndentation();
		boolean rightOperand = binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getOrOperator());
		b.append("\n").append(b.getName(binaryOperation)).append(" = ").append(Boolean.toString(rightOperand)).append(";");
		
		b.decreaseIndentation().append("\n} else {").increaseIndentation();
		
		if (binaryOperation.getImplicitReceiver()!=null) {
			internalToJavaStatement(binaryOperation.getImplicitReceiver(), b, true);
		}
		for (XExpression arg : binaryOperation.getExplicitArguments()) {
			if (arg!=leftOperand)
				prepareExpression(arg, b);
		}
		
		b.append("\n").append(b.getName(binaryOperation)).append(" = ");
		featureCalltoJavaExpression(binaryOperation, b);
		b.append(";");
		b.decreaseIndentation().append("\n}");
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, IAppendable b) {
		if (expr instanceof XAssignment)
			return true;
		if (expr instanceof XAbstractFeatureCall) {
			JvmIdentifiableElement feature = ((XAbstractFeatureCall)expr).getFeature();
			if (feature instanceof JvmField 
				|| feature instanceof JvmFormalParameter)
				return false;
			return b.getName(feature)==null;
		}
		return super.isVariableDeclarationRequired(expr,b);
	}

	protected void prepareSpreadingMemberFeatureCall(XMemberFeatureCall expr, IAppendable b) {
		throw new UnsupportedOperationException("spread operator not yet supported");
//		prepareAllArguments(expr, b);
//		declareLocalVariable(expr, b, Lists.class.getCanonicalName() + ".newArrayList()");
//		b.append("\nfor(");
//		final String varName = getJavaVarName(expr, b) + "_spread";
//		b.append(makeJavaIdentifier(varName)).append(" : ");
////		toConvertedJavaExpression(expr, b);
//		b.append(") {");
//		b.append("\n").append(getJavaVarName(expr, b)).append("add(");
//		b.append(varName).append(".");
//		appendFeatureCall(expr, b);
//		b.append(";");
	}
	
	protected void prepareExpression(XExpression arg, IAppendable b) {
		if (arg instanceof XAbstractFeatureCall && !(((XAbstractFeatureCall)arg).getFeature() instanceof JvmField) && !isVariableDeclarationRequired(arg,b)) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(arg);
			JvmTypeReference type = getTypeProvider().getType(arg);
			if (expectedType != null && !jvmConformance.isConformant( expectedType, type ) ) {
				String varName = getVarName(((XAbstractFeatureCall) arg).getFeature(), b);
				String finalVariable = b.declareSyntheticVariable(Tuples.create("Convertable", arg), "_typeConverted_" + varName);
				b.append("\n")
					.append("final ");
				serialize(type,arg,b);
				b.append(" ")
					.append(finalVariable)
					.append(" = ")
					.append("(");
				serialize(type,arg,b);
				b.append(")")
					.append(varName)
					.append(";");
			}	
		} else {
			internalToJavaStatement(arg, b, true);
		}
	}

	protected boolean isSpreadingMemberFeatureCall(XAbstractFeatureCall expr) {
		return expr instanceof XMemberFeatureCall && ((XMemberFeatureCall) expr).isSpreading();
	}
	
	protected void _toJavaExpression(XAbstractFeatureCall call, IAppendable b) {
		if (isPrimitiveVoid(call)) {
			b.append("null");
		} else if (isSpreadingMemberFeatureCall(call)) {
			throw new UnsupportedOperationException();
			//			b.append(getVarName(call));
		} else {
			if (!isVariableDeclarationRequired(call,b)) {
				if (call.getFeature() instanceof JvmField) {
					if (isStatic(call.getFeature())) {
						b.append(((JvmFeature) call.getFeature()).getDeclaringType());
						b.append(".");
					} else {
						XExpression receiver = featureCallToJavaMapping.getActualReceiver(call);
						if (receiver!=null) {
							internalToJavaExpression(receiver, b);
							b.append(".");
						}
					}
					b.append(call.getFeature().getSimpleName());
				} else {
					if (b.getName(call.getFeature()) == null) {
						String variableName = getFavoriteVariableName(call.getFeature());
						if (log.isInfoEnabled())
							log.info("The variable '"+variableName+"' has not been declared.");
						b.declareSyntheticVariable(call.getFeature(), variableName);
					}
					final String varName = getVarName(call.getFeature(), b);
					b.append(varName);
				}
			} else {
				b.append(getVarName(call, b));
			}
		}
	}

	protected void featureCalltoJavaExpression(final XAbstractFeatureCall call, IAppendable b) {
		featureCalltoJavaExpression(call, b, false);
	}
	
	protected void featureCalltoJavaExpression(final XAbstractFeatureCall call, IAppendable b, boolean unpreparedArguments) {
		if (call instanceof XAssignment) {
			xAssignmentToJavaExpression((XAssignment) call, b);
			return;
		}
		boolean hasReceiver = appendReceiver(call, b);
		if (hasReceiver) {
			b.append(".");
			if (!call.getTypeArguments().isEmpty()) {
				b.append("<");
				for(int i = 0; i < call.getTypeArguments().size(); i++) {
					if (i != 0) {
						b.append(", ");
					}
					JvmTypeReference typeArgument = call.getTypeArguments().get(i);
					serialize(typeArgument, call, b);
				}
				b.append(">");
			} else if (call.getFeature() instanceof JvmExecutable) {
				final JvmExecutable executable = (JvmExecutable) call.getFeature();
				if (!executable.getTypeParameters().isEmpty()) {
					XExpression receiver = featureCallToJavaMapping.getActualReceiver(call);
					final JvmTypeReference receiverType = receiver != null
						? getTypeProvider().getType(receiver)
						: null;
					final JvmTypeReference expectedType = getTypeProvider().getExpectedType(call);
					final List<JvmTypeReference> argumentTypes = Lists.newArrayList();
					for(XExpression argument: featureCallToJavaMapping.getActualArguments(call)) {
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
									while(context != null && result == null) {
										if (context instanceof JvmTypeParameterDeclarator) {
											result = (JvmTypeParameterDeclarator) context;
										} else {
											JvmIdentifiableElement logicalContainer = contextProvider.getLogicalContainer(context);
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
							}
					);
					List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayList();
					boolean containedUnresolved = false;
					for(int i = 0; i < executable.getTypeParameters().size() && !containedUnresolved; i++) {
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
						for(int i = 0; i < resolvedTypeArguments.size(); i++) {
							if (i != 0) {
								b.append(", ");
							}
							JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
							serialize(typeArgument,call,b);
						}
						b.append(">");
					}
				}
			}
		}
		appendFeatureCall(call, b, unpreparedArguments);
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, IAppendable b) {
		if (call instanceof XMemberFeatureCall) {
			XMemberFeatureCall expr = ((XMemberFeatureCall) call);
			if (expr.isNullSafe()) {
				internalToJavaExpression(expr.getMemberCallTarget(), b);
				b.append("==null?");
				JvmTypeReference type = getTypeProvider().getType(call);
				appendNullValue(type,call,b);
				b.append(":");
			} else if (expr.isSpreading()) {
				throw new UnsupportedOperationException();
			}
		}
		if (isStatic(call.getFeature())) {
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
		
	protected void appendNullValue(JvmTypeReference type, EObject context, IAppendable b) {
		if(!primitives.isPrimitive(type)) {
			b.append("(");
			serialize(type, context,b);
			b.append(")");
			b.append("null");
		} else {
			b.append(getDefaultLiteral((JvmPrimitiveType)type.getType()));
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
		throw new IllegalArgumentException("Unkown primitive "+name);
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

	protected void xAssignmentToJavaExpression(XAssignment expr, IAppendable b) {
		final JvmIdentifiableElement feature = expr.getFeature();
		if (feature instanceof JvmOperation) {
			boolean appendReceiver = appendReceiver(expr, b);
			if (appendReceiver)
				b.append(".");
			appendFeatureCall(expr, b, false);
		} else {
			if (feature instanceof JvmField) {
				boolean appendReceiver = appendReceiver(expr, b);
				if (appendReceiver)
					b.append(".");
				appendFeatureCall(expr, b, false);
			} else {
				String name = b.getName(expr.getFeature());
				b.append(name);
			}
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
		}
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, IAppendable b, boolean forceArgumentsAsExpression) {
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
		b.append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(call);
			appendArguments(arguments, (JvmExecutable)feature, call, b, forceArgumentsAsExpression);
			b.append(")");
		}
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

	protected void appendArguments(List<? extends XExpression> arguments, JvmExecutable executable, XExpression context, IAppendable b, boolean forceArgumentsAsExpression) {
		if (arguments == null)
			return;
		for (int i = 0; i < arguments.size(); i++) {
			XExpression argument = arguments.get(i);
			if (forceArgumentsAsExpression) {
				JvmTypeReference type = getTypeProvider().getExpectedType(argument);
				if (type == null)
					type = getTypeProvider().getType(argument);
				compileAsJavaExpression(argument, b, type);
			} else {
				internalToJavaExpression(argument, b);
			}
			if (i + 1 < arguments.size())
				b.append(", ");
		}
	}

}
