/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.compiler.IAppendable.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.lib.Conversions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FeatureCallCompiler extends LiteralsCompiler {

	protected void _prepare(XAbstractFeatureCall expr, IAppendable b) {
		if (isVoid(expr)) {
			internalToJavaStatement(expr, b);
		} else if (isSpreadingMemberFeatureCall(expr)) {
			prepareMemberFeatureCall((XMemberFeatureCall) expr, b);
		} else {
			if (expr instanceof XFeatureCall
					&& (expr.getFeature() instanceof XVariableDeclaration || expr.getFeature() instanceof JvmFormalParameter)) {
				//do nothing
			} else {
				for (XExpression arg : expr.getAllArguments()) {
					internalPrepare(arg, b);
				}
				IAppendable appendable = new IAppendable.StringBuilderBasedAppendable();
				featureCalltoJavaExpression(expr, appendable);
				JvmTypeReference original = getTypeProvider().getType(expr);
				JvmTypeReference converted = getTypeProvider().getConvertedType(expr);
				final boolean noConversion = EcoreUtil.equals(converted, original);
				if (!noConversion) {
					appendable = doConversion(converted, original, appendable);
				}
				declareLocalVariable(expr, b, appendable);
			}
		}
	}

	protected void prepareMemberFeatureCall(XMemberFeatureCall expr, IAppendable b) {
		for (XExpression arg : expr.getAllArguments()) {
			internalPrepare(arg, b);
		}
		declareLocalVariable(expr, b, Lists.class.getCanonicalName() + ".newArrayList()");
		b.append("\nfor(");
		final String varName = getVarName(expr) + "_spread";
		b.append(varName).append(" : ");
		internalToJavaExpression(expr.getMemberCallTarget(), b);
		b.append(") {");
		b.append("\n").append(getVarName(expr)).append("add(");
		b.append(varName).append(".");
		appendFeatureCall(expr.getFeature(), expr.getActualArguments(), b);
		b.append(";");
	}

	protected boolean isSpreadingMemberFeatureCall(XAbstractFeatureCall expr) {
		return expr instanceof XMemberFeatureCall && ((XMemberFeatureCall) expr).isSpreading();
	}

	protected IAppendable doConversion(JvmTypeReference left, JvmTypeReference right, Object expressionAsJavaCode) {
		StringBuilderBasedAppendable appendable = new IAppendable.StringBuilderBasedAppendable();
		if (right.getType() instanceof JvmArrayType) {
			appendable.append("(").append(getSerializedForm(left)).append(")");
			appendable.append(Conversions.class.getCanonicalName()).append(".doWrapArray(")
					.append(expressionAsJavaCode).append(")");
		} else if (left != null && left.getType() instanceof JvmArrayType) {
			appendable.append("(").append(getSerializedForm(left)).append(")");
			appendable.append(Conversions.class.getCanonicalName()).append(".unwrapArray(")
					.append(expressionAsJavaCode).append(")");
		} else {
			appendable.append(expressionAsJavaCode);
		}
		return appendable;
	}

	protected void _toJavaStatement(XAbstractFeatureCall expr, IAppendable b) {
		if (isSpreadingMemberFeatureCall(expr)) {
			prepareMemberFeatureCall((XMemberFeatureCall) expr, b);
		} else {
			for (XExpression arg : expr.getAllArguments()) {
				internalPrepare(arg, b);
			}
			b.append("\n");
			featureCalltoJavaExpression(expr, b);
			b.append(";");
		}
	}

	protected void _toJavaExpression(XAbstractFeatureCall call, IAppendable b) {
		if (isVoid(call)) {
			b.append("null");
		} else if (isSpreadingMemberFeatureCall(call)) {
			b.append(getVarName(call));
		} else {
			String expression = null;
			if (call.getFeature() instanceof XVariableDeclaration) {
				expression = makeJavaIdentifier(((XVariableDeclaration) call.getFeature()).getName());
			} else if (call.getFeature() instanceof JvmFormalParameter) {
				expression = makeJavaIdentifier(((JvmFormalParameter) call.getFeature()).getName());
			} else {
				expression = getVarName(call);
			}
			JvmTypeReference expectedType = getExpectedTypeProvider().getExpectedType(call);
			if (expectedType != null) {
				JvmTypeReference actualType = getTypeProvider().getConvertedType(call);
				if (!EcoreUtil.equals(expectedType, actualType)) {
					b.append(doConversion(expectedType, actualType, expression));
					return;
				}
			}
			b.append(expression);
		}
	}

	protected boolean isVoid(XAbstractFeatureCall expr) {
		return getTypeProvider().getConvertedType(expr).getCanonicalName().equals(Void.class.getCanonicalName());
	}

	protected void featureCalltoJavaExpression(XAbstractFeatureCall call, IAppendable b) {
		if (call instanceof XAssignment) {
			xAssignmentToJavaExpression((XAssignment) call, b);
			return;
		}
		boolean hasReceiver = appendReceiver(call, b);
		if (hasReceiver)
			b.append(".");
		appendFeatureCall(call.getFeature(), call.getActualArguments(), b);
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, IAppendable b) {
		if (isStatic(call.getFeature())) {
			b.append(((JvmFeature)call.getFeature()).getDeclaringType().getCanonicalName());
			return true;
		}
		if (call instanceof XMemberFeatureCall) {
			XMemberFeatureCall expr = ((XMemberFeatureCall) call);
			if (expr.isNullSafe()) {
				internalToJavaExpression(expr.getMemberCallTarget(), b);
				b.append("==null?");
				b.append("(");
				JvmTypeReference type = getTypeProvider().getConvertedType(expr);
				b.append(getSerializedForm(type));
				b.append(")null:");
				internalToJavaExpression(expr.getMemberCallTarget(), b);
				return true;
			} else if (expr.isSpreading()) {
				throw new UnsupportedOperationException();
			}
		}
		XExpression receiver = call.getActualReceiver();
		if (receiver!=null) {
			internalToJavaExpression(receiver, b);
			return true;
		} else {
			return false;
		}
	}

	protected boolean isMemberCall(XAbstractFeatureCall call) {
		return call.isTargetsMemberSyntaxCall();
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
		boolean appendReceiver = appendReceiver(expr, b);
		if (appendReceiver)
			b.append(".");
		if (feature instanceof JvmOperation) {
			appendFeatureCall(expr.getFeature(), expr.getActualArguments(), b);
		} else {
			appendFeatureCall(expr.getFeature(), null, b);
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
		}
	}
	
	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;

	protected void appendFeatureCall(JvmIdentifiableElement target, List<? extends XExpression> arguments, IAppendable b) {
		String name = featureNameProvider.getSimpleName(target);
		b.append(makeJavaIdentifier(name));
		if (target instanceof JvmOperation) {
			b.append("(");
			appendArguments(arguments, b);
			b.append(")");
		}
	}

	protected void appendArguments(List<? extends XExpression> eList, IAppendable b) {
		if (eList==null)
			return;
		for (int i = 0; i < eList.size(); i++) {
			XExpression expression = eList.get(i);
			internalToJavaExpression(expression, b);
			if (i + 1 < eList.size())
				b.append(", ");
		}
	}

}
