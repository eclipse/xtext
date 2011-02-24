/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseCompiler {

	public static interface LateCode {
		void execute();
	}

	@Inject
	private TypeReferences typeReferences;
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}

	@Inject
	private ITypeProvider typeProvider;

	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}

	private PolymorphicDispatcher<Void> toJavaExprDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaExpression", 2, 2, this);

	private PolymorphicDispatcher<Void> toJavaStatementDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaStatement", 3, 3, this);

	public void compile(XExpression obj, IAppendable appendable) {
		boolean generateImplicitReturn = !isPrimitiveVoid(obj);
		compile(obj, appendable, generateImplicitReturn);
	}
	
	public void compile(XExpression obj, IAppendable appendable, boolean generateImplicitReturn) {
		internalToJavaStatement(obj, appendable, generateImplicitReturn);
		if (generateImplicitReturn) {
			appendable.append("\nreturn ");
			internalToJavaExpression(obj, appendable);
			appendable.append(";");
		}
	}
	
	protected boolean isPrimitiveVoid(XExpression xExpression) {
		JvmTypeReference type = getTypeProvider().getType(xExpression);
		return typeReferences.is(type, Void.TYPE);
	}

	protected void internalToJavaStatement(XExpression obj, IAppendable builder, boolean isReferenced) {
		toJavaStatementDispatcher.invoke(obj, builder, isReferenced);
	}

	protected void internalToJavaExpression(final XExpression obj, final IAppendable appendable) {
		toJavaExprDispatcher.invoke(obj, appendable);
	}

	public void _toJavaStatement(XExpression func, IAppendable b, boolean isReferenced) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _toJavaExpression(XExpression func, IAppendable b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _toJavaStatement(Void func, IAppendable b, boolean isReferenced) {
		throw new NullPointerException();
	}

	public void _toJavaExpression(Void func, IAppendable b) {
		throw new NullPointerException();
	}

	protected String getReturnTypeName(XExpression expr) {
		final JvmTypeReference type = typeProvider.getType(expr);
		return getSerializedForm(type);
	}

	protected String getSerializedForm(final JvmTypeReference type) {
		return getSerializedForm(type, null, false, false);
	}
	
	protected String getSerializedForm(final JvmTypeReference type, XExpression context, boolean withoutConstraints, boolean paramsToWildcard) {
		StringBuilder result = new StringBuilder();
		getSerializedForm(type, context, result, withoutConstraints, paramsToWildcard);
		return result.toString();
	}
	
	protected void getSerializedForm(final JvmTypeReference type, XExpression context, StringBuilder result, boolean withoutConstraints, boolean paramsToWildcard) {
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (!withoutConstraints) {
				result.append("?");
			}
			if (!wildcard.getConstraints().isEmpty()) {
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmLowerBound) {
						if (!withoutConstraints)
							result.append(" super ");
						getSerializedForm(constraint.getTypeReference(), context, result, withoutConstraints, paramsToWildcard);
						return;
					}
				}
				boolean first = true;
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						if (first) {
							if (!withoutConstraints)
								result.append(" extends ");
							first = false;
						} else {
							if (withoutConstraints)
								throw new IllegalStateException("cannot have two upperbounds if type should be printed without constraints");
							result.append(" & ");
						}
						getSerializedForm(constraint.getTypeReference(), context, result, withoutConstraints, paramsToWildcard);
					}
				}
			} else if (withoutConstraints) {
				result.append("java.lang.Object");
			}
		} else if (type instanceof JvmGenericArrayTypeReference) {
			getSerializedForm(((JvmGenericArrayTypeReference) type).getComponentType(), context, result, withoutConstraints, paramsToWildcard);
			result.append("[]");
		} else if (type instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) type;
			if (paramsToWildcard && parameterized.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter parameter = (JvmTypeParameter) parameterized.getType();
				if (context == null)
					throw new IllegalArgumentException("argument may not be null if parameters have to be replaced by wildcards");
				if (!EcoreUtil.isAncestor(parameter.getDeclarator(), context)) {
					result.append("?");
					return;
				}
			}
			result.append(getSerializedForm(type.getType()));
			if (!parameterized.getArguments().isEmpty()) {
				result.append("<");
				for(int i = 0; i < parameterized.getArguments().size(); i++) {
					if (i != 0) {
						result.append(", ");
					}
					getSerializedForm(parameterized.getArguments().get(i), context, result, withoutConstraints, paramsToWildcard);
				}
				result.append(">");
			}
		} else {
			throw new IllegalArgumentException(type==null?null:type.toString());
		}
	}
	
	protected String getSerializedForm(final JvmType type) {
		return type.getQualifiedName('.');
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
				name = Strings.toFirstLower(name.substring(3));
			if (name.startsWith("to") && name.length() > 2)
				name = Strings.toFirstLower(name.substring(2));
			return "_"+name;
		}
		return "_"+Strings.toFirstLower(ex.eClass().getName().toLowerCase());
	}

	protected String makeJavaIdentifier(String name) {
		//TODO escape all Java keywords
		return name.equals("this") ? "_this" : name;
	}

	protected void declareLocalVariable(XExpression expr, final IAppendable b) {
		declareLocalVariable(expr, b, getDefaultValueLiteral(expr));
	}

	protected String getDefaultValueLiteral(XExpression expr) {
		JvmTypeReference type = getTypeProvider().getType(expr);
		if (type.getType() instanceof JvmPrimitiveType) {
			String name = type.getIdentifier();
			if ("boolean".equals(name)) {
				return "false";
			} else {
				return "(" + name + ")-1";
			}
		}
		return "null";
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
		JvmTypeReference type = getTypeProvider().getType(expr);
		String varName = declareNameInVariableScope(expr, b);
		b.append("\n").append(getSerializedForm(type, expr, false, true)).append(" ").append(varName).append(" = ");
		expression.exec();
		b.append(";");
	}
}
