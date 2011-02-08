/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FeatureCallCompiler extends LiteralsCompiler {

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;

	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;
	
	protected void _toJavaStatement(final XAbstractFeatureCall expr, final IAppendable b, boolean isReferenced) {
		if (isSpreadingMemberFeatureCall(expr)) {
			prepareSpreadingMemberFeatureCall((XMemberFeatureCall) expr, b);
		} else {
			if (isLocalVarReference(expr)) {
				//do nothing
			} else {
				prepareAllArguments(expr, b);
				if (isReferenced && !isPrimitiveVoid(expr)) {
					Later later = new Later() {
						@Override
						public void exec() {
							featureCalltoJavaExpression(expr, b);
						}
					};
					declareLocalVariable(expr, b, later);
				} else {
					b.append("\n");
					featureCalltoJavaExpression(expr, b);
					b.append(";");
				}
			}
		}
	}

	protected boolean isLocalVarReference(XAbstractFeatureCall expr) {
		if (expr instanceof XFeatureCall) {
			JvmIdentifiableElement feature = expr.getFeature();
			if (feature instanceof XVariableDeclaration || feature instanceof JvmFormalParameter
					|| feature instanceof XCasePart || feature instanceof XSwitchExpression)
				return true;
		}
		return false;
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

	protected void prepareAllArguments(XAbstractFeatureCall expr, IAppendable b) {
		if (expr.getImplicitReceiver()!=null) {
			internalToJavaStatement(expr.getImplicitReceiver(), b, true);
		}
		for (XExpression arg : expr.getExplicitArguments()) {
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
			if (isLocalVarReference(call)) {
				b.append(getJavaVarName(call.getFeature(), b));
			} else {
				b.append(getJavaVarName(call, b));
			}
		}
	}

	protected void featureCalltoJavaExpression(XAbstractFeatureCall call, IAppendable b) {
		if (call instanceof XAssignment) {
			xAssignmentToJavaExpression((XAssignment) call, b);
			return;
		}
		boolean hasReceiver = appendReceiver(call, b);
		if (hasReceiver)
			b.append(".");
		appendFeatureCall(call, b);
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, IAppendable b) {
		if (isStatic(call.getFeature())) {
			b.append(((JvmFeature) call.getFeature()).getDeclaringType().getCanonicalName());
			return true;
		}
		XExpression receiver = featureCallToJavaMapping.getActualReceiver(call);
		if (call instanceof XMemberFeatureCall) {
			XMemberFeatureCall expr = ((XMemberFeatureCall) call);
			if (expr.isNullSafe()) {
				internalToJavaExpression(receiver, b);
				b.append("==null?");
				b.append("(");
				JvmTypeReference type = getTypeProvider().getType(expr);
				b.append(getSerializedForm(type));
				b.append(")null:");
				internalToJavaExpression(receiver, b);
				return true;
			} else if (expr.isSpreading()) {
				throw new UnsupportedOperationException();
			}
		}
		if (receiver != null) {
			internalToJavaExpression(receiver, b);
			return true;
		} else {
			return false;
		}
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
			appendFeatureCall(expr, b);
		} else {
			if (feature instanceof JvmField) {
				boolean appendReceiver = appendReceiver(expr, b);
				if (appendReceiver)
					b.append(".");
				appendFeatureCall(expr, b);
			} else {
				String name = featureNameProvider.getSimpleName(expr.getFeature());
				b.append(makeJavaIdentifier(name));
			}
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
		}
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, IAppendable b) {
		String name = featureNameProvider.getSimpleName(call.getFeature());
		b.append(makeJavaIdentifier(name));
		if (call.getFeature() instanceof JvmOperation) {
			b.append("(");
			List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(call);
			appendArguments(arguments, b);
			b.append(")");
		}
	}

	protected void appendArguments(List<? extends XExpression> eList, IAppendable b) {
		if (eList == null)
			return;
		for (int i = 0; i < eList.size(); i++) {
			XExpression expression = eList.get(i);
			internalToJavaExpression(expression, b);
			if (i + 1 < eList.size())
				b.append(", ");
		}
	}

}
