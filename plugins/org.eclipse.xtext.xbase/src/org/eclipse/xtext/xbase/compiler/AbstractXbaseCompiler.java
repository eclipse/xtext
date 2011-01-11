/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.IExpectedTypeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.typing.IXbaseTypeProvider;

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

	public void compile(EObject obj, IAppendable appendable) {
		if (isDirectThrowExpression(obj)) {
			internalToJavaStatement(obj, appendable);
		} else {
			internalPrepare(obj, appendable);
			appendable.append("\nreturn ");
			internalToJavaExpression(obj, appendable);
			appendable.append(";");
		}
	}

	protected boolean isDirectThrowExpression(EObject obj) {
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
	private IXbaseTypeProvider typeProvider;

	public void setTypeProvider(IXbaseTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected IXbaseTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Inject
	private IExpectedTypeProvider<JvmTypeReference> expectedTypeProvider;

	public void setExpectedTypeProvider(IExpectedTypeProvider<JvmTypeReference> expectedTypeProvider) {
		this.expectedTypeProvider = expectedTypeProvider;
	}

	public IExpectedTypeProvider<JvmTypeReference> getExpectedTypeProvider() {
		return expectedTypeProvider;
	}

	protected String getReturnTypeName(XExpression expr) {
		final JvmTypeReference type = typeProvider.getType(expr);
		return getSerializedForm(type);
	}

	protected String getSerializedForm(final JvmTypeReference type) {
		return type.getCanonicalName();
	}

	protected String getVarName(EObject ex) {
		if (ex.eContainer() instanceof XExpression || ex.eContainer() instanceof XCatchClause) {
			return getVarName(ex.eContainer()) + "_" + ex.eContainer().eContents().indexOf(ex);
		}
		return "_var";
	}

	protected String makeJavaIdentifier(String name) {
		return name.equals("this") ? "_this" : name;
	}

	protected void declareLocalVariable(XExpression expr, IAppendable b) {
		declareLocalVariable(expr, b, "null");
	}

	protected void declareLocalVariable(XExpression expr, IAppendable b, Object serializedExpression) {
		JvmTypeReference type = getExpectedTypeProvider().getExpectedType(expr);
		if (type == null || type.getCanonicalName().equals(Object.class.getCanonicalName()))
			type = getTypeProvider().getType(expr);
		b.append("\n").append(getSerializedForm(type)).append(" ").append(getVarName(expr)).append(" = ")
				.append(serializedExpression).append(";");
	}
}
