/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;
import org.eclipse.xtext.xbase.typing.XExpressionExpectedTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseCompiler {

	public static interface LateCode {
		void execute();
	}

	private PolymorphicDispatcher<Void> prepareExpressionDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_prepare", 2, 2, this);

	private PolymorphicDispatcher<Void> toJavaExprDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaExpression", 2, 2, this);

	private PolymorphicDispatcher<Void> toJavaStatementDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaStatement", 2, 2, this);

	public void compile(XExpression obj, IAppendable appendable) {
		if (isEarlyMethodInterruption(obj)) {
			internalToJavaStatement(obj, appendable);
		} else {
			internalPrepare(obj, appendable);
			appendable.append("\nreturn ");
			internalToJavaExpression(obj, appendable);
			appendable.append(";");
		}
	}

	/**
	 * whether the given expression compiles to a java statement that leaves the method (i.e. return or throw statement)
	 */
	protected boolean isEarlyMethodInterruption(XExpression obj) {
		if (obj instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) obj;
			return isEarlyMethodInterruption(block.getExpressions().get(block.getExpressions().size() - 1));
		}
		if (obj instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryCatch = (XTryCatchFinallyExpression) obj;
			boolean isExit = isEarlyMethodInterruption(tryCatch.getExpression());
			for (XCatchClause catchClause : tryCatch.getCatchClauses()) {
				if (!isExit)
					return false;
				isExit = isEarlyMethodInterruption(catchClause.getExpression());
			}
			return isExit;
		}
		if (obj instanceof XIfExpression) {
			XIfExpression ifExpr = (XIfExpression) obj;
			return isEarlyMethodInterruption(ifExpr.getThen()) && ifExpr.getElse() != null
					&& isEarlyMethodInterruption(ifExpr.getElse());
		}
		return obj instanceof XThrowExpression;
	}

	protected void internalPrepare(EObject obj, IAppendable builder) {
		prepareExpressionDispatcher.invoke(obj, builder);
	}

	protected void internalToJavaExpression(final EObject obj, final IAppendable appendable) {
		toJavaExprDispatcher.invoke(obj, appendable);
	}

	protected void internalToJavaStatement(EObject obj, IAppendable builder) {
		toJavaStatementDispatcher.invoke(obj, builder);
	}

	public void _prepare(XExpression func, IAppendable b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _toJavaExpression(XExpression func, IAppendable b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _toJavaStatement(XExpression func, IAppendable b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _prepare(Void func, IAppendable b) {
		throw new NullPointerException();
	}

	public void _toJavaExpression(Void func, IAppendable b) {
		throw new NullPointerException();
	}

	public void _toJavaStatement(Void func, IAppendable b) {
		throw new NullPointerException();
	}

	@Inject
	private IXExpressionTypeProvider typeProvider;

	public void setTypeProvider(IXExpressionTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected IXExpressionTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Inject
	private IdentifiableTypeProvider identifiableTypeProvider;

	public void setIdentifiableTypeProvider(IdentifiableTypeProvider identifiableTypeProvider) {
		this.identifiableTypeProvider = identifiableTypeProvider;
	}

	protected IdentifiableTypeProvider getIdentifiableTypeProvider() {
		return identifiableTypeProvider;
	}

	@Inject
	private XExpressionExpectedTypeProvider expectedTypeProvider;

	public void setExpectedTypeProvider(XExpressionExpectedTypeProvider expectedTypeProvider) {
		this.expectedTypeProvider = expectedTypeProvider;
	}

	public XExpressionExpectedTypeProvider getExpectedTypeProvider() {
		return expectedTypeProvider;
	}

	protected String getReturnTypeName(XExpression expr) {
		final JvmTypeReference type = typeProvider.getConvertedType(expr);
		return getSerializedForm(type);
	}

	protected String getSerializedForm(final JvmTypeReference type) {
		return type.getCanonicalName();
	}

	protected String getJavaVarName(Object ex, IAppendable appendable) {
		final String varName = getVarName(ex, appendable);
		if (varName == null) {
			return null;
		}
		return makeJavaIdentifier(varName);
	}

	protected String getVarName(Object ex, IAppendable appendable) {
		String name = appendable.getName(ex);
		return name;
	}

	protected String declareNameInVariableScope(EObject declaration, IAppendable appendable) {
		final String favoriteVariableName = getFavoriteVariableName(declaration);
		final String varName = appendable.declareVariable(declaration, favoriteVariableName);
		return makeJavaIdentifier(varName);
	}

	@Inject
	private IdentifiableSimpleNameProvider nameProvider;

	public void setNameProvider(IdentifiableSimpleNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	protected IdentifiableSimpleNameProvider getNameProvider() {
		return nameProvider;
	}

	protected String getFavoriteVariableName(EObject ex) {
		if (ex instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) ex).getName();
		}
		if (ex instanceof JvmFormalParameter) {
			return ((JvmFormalParameter) ex).getName();
		}
		if (ex instanceof XAbstractFeatureCall) {
			String name = nameProvider.getSimpleName(((XAbstractFeatureCall) ex).getFeature());
			int indexOf = name.indexOf('(');
			if (indexOf != -1) {
				name = name.substring(0, indexOf);
			}
			indexOf = name.lastIndexOf('.');
			if (indexOf != -1) {
				name = name.substring(indexOf + 1);
			}
			if (name.startsWith("get") && name.length() > 3)
				return name.substring(3);
			if (name.startsWith("to") && name.length() > 2)
				return name.substring(2);
			return name;
		}
		return ex.eClass().getName().toLowerCase();
	}

	protected String makeJavaIdentifier(String name) {
		//TODO escape all Java keywords
		return name.equals("this") ? "_this" : name;
	}

	protected void declareLocalVariable(XExpression expr, final IAppendable b) {
		declareLocalVariable(expr, b, "null");
	}

	protected void declareLocalVariable(XExpression expr, final IAppendable b, final String expression) {
		declareLocalVariable(expr, b, new Later() {
			@Override
			public void exec() {
				b.append(expression);
			}
		});
	}

	protected void declareLocalVariable(XExpression expr, IAppendable b, Later expression) {
//		JvmTypeReference type = getExpectedTypeProvider().getExpectedType(expr);
//		if (type == null || type.getCanonicalName().equals(Object.class.getCanonicalName()))
		JvmTypeReference type = getTypeProvider().getConvertedType(expr);
		final String varName = declareNameInVariableScope(expr, b);
		b.append("\n").append(getSerializedForm(type)).append(" ").append(varName).append(" = ");
		expression.exec();
		b.append(";");
	}
}
