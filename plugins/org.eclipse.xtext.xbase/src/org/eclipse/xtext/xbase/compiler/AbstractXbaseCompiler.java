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
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseCompiler {

	@Inject
	private TypeReferences typeReferences;
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	/**
	 * Public for testing purpose.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}

	@Inject
	private ITypeProvider typeProvider;

	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	@Inject
	private IEarlyExitComputer exitComputer;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private Primitives primitives;
	
	protected Primitives getPrimitives() {
		return primitives;
	}

	private PolymorphicDispatcher<Void> toJavaExprDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaExpression", 2, 2, this);

	private PolymorphicDispatcher<Void> toJavaStatementDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaStatement", 3, 3, this);

	public IAppendable compile(XExpression obj, IAppendable appendable, JvmTypeReference expectedReturnType) {
		final boolean isPrimitiveVoidExpected = typeReferences.is(expectedReturnType, Void.TYPE); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = exitComputer.isEarlyExit(obj);
		internalToJavaStatement(obj, appendable, !isPrimitiveVoidExpected && !isPrimitiveVoid && !earlyExit);
		if (!isPrimitiveVoidExpected && !earlyExit) {
				appendable.append("\nreturn ");
				if (isPrimitiveVoid && !isPrimitiveVoidExpected) {
					appendable.append("null");
				} else {
					internalToJavaExpression(obj, appendable);
				}
				appendable.append(";");
		}
		return appendable;
	}
	
	protected boolean isPrimitiveVoid(XExpression xExpression) {
		JvmTypeReference type = getTypeProvider().getType(xExpression);
		return typeReferences.is(type, Void.TYPE);
	}

	protected void internalToJavaStatement(XExpression obj, IAppendable builder, boolean isReferenced) {
		toJavaStatementDispatcher.invoke(obj, builder, isReferenced);
	}
	
	public void toJavaExpression(final XExpression obj, final IAppendable appendable) {
		internalToJavaExpression(obj, appendable);
	}
	
	public void toJavaStatement(final XExpression obj, final IAppendable appendable, boolean isReferenced) {
		internalToJavaStatement(obj, appendable, isReferenced);
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

	protected void serialize(final JvmTypeReference type, EObject context, IAppendable appendable) {
		serialize(type, context, appendable, false, true);
	}
	protected void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard) {
		serialize(type, context, appendable, withoutConstraints, paramsToWildcard, false, true);
	}
	
	protected void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (!withoutConstraints) {
				appendable.append("?");
			}
			if (!wildcard.getConstraints().isEmpty()) {
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmLowerBound) {
						if (!withoutConstraints)
							appendable.append(" super ");
						serialize(constraint.getTypeReference(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
						return;
					}
				}
				boolean first = true;
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						if (first) {
							if (!withoutConstraints)
								appendable.append(" extends ");
							first = false;
						} else {
							if (withoutConstraints)
								throw new IllegalStateException("cannot have two upperbounds if type should be printed without constraints");
							appendable.append(" & ");
						}
						serialize(constraint.getTypeReference(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
					}
				}
			} else if (withoutConstraints) {
				appendable.append("Object");
			}
		} else if (type instanceof JvmGenericArrayTypeReference) {
			serialize(((JvmGenericArrayTypeReference) type).getComponentType(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, true);
			appendable.append("[]");
		} else if (type instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) type;
			if ((paramsToWildcard || paramsToObject) && parameterized.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter parameter = (JvmTypeParameter) parameterized.getType();
				if (context == null)
					throw new IllegalArgumentException("argument may not be null if parameters have to be replaced by wildcards");
				if (!isLocalTypeParameter(context, parameter)) {
					if (paramsToWildcard)
						appendable.append("?");
					else
						appendable.append("Object");
					return;
				}
			}
			JvmType jvmType = allowPrimitives ? type.getType() : primitives.asWrapperTypeIfPrimitive(type).getType();
			appendable.append(jvmType);
			if (!parameterized.getArguments().isEmpty()) {
				appendable.append("<");
				for(int i = 0; i < parameterized.getArguments().size(); i++) {
					if (i != 0) {
						appendable.append(",");
					}
					serialize(parameterized.getArguments().get(i), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
				}
				appendable.append(">");
			}
		} else if (type instanceof JvmAnyTypeReference) {
			appendable.append(type.getType());
		} else if (type instanceof JvmMultiTypeReference) {
			serialize(resolveMultiType(type), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else {
			throw new IllegalArgumentException(type==null ? null : type.toString());
		}
	}

	protected boolean isLocalTypeParameter(EObject context, JvmTypeParameter parameter) {
		return EcoreUtil.isAncestor(parameter.getDeclarator(), context);
	}
	
	protected JvmTypeReference resolveMultiType(JvmTypeReference reference) {
		if (reference instanceof JvmMultiTypeReference) {
			JvmTypeReference result = typeConformanceComputer.getCommonSuperType(((JvmMultiTypeReference) reference).getReferences());
			if (result instanceof JvmMultiTypeReference)
				return resolveMultiType(result);
			return result;
		}
		return reference;
	}
	
	protected String getVarName(Object ex, IAppendable appendable) {
		String name = appendable.getName(ex);
		return name;
	}

	protected String declareNameInVariableScope(EObject declaration, IAppendable appendable) {
		final String favoriteVariableName = makeJavaIdentifier(getFavoriteVariableName(declaration));
		final String varName = appendable.declareVariable(declaration, favoriteVariableName);
		return varName;
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
		if (ex instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) ex).getSimpleName();
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
		if (ex instanceof XConstructorCall) {
			String name = ((XConstructorCall) ex).getConstructor().getSimpleName();
			return "_"+Strings.toFirstLower(name);
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
		if (primitives.isPrimitive(type)) {
			if (primitives.primitiveKind((JvmPrimitiveType) type.getType()) == Primitive.Boolean) {
				return "false";
			} else {
				return "(" + type.getQualifiedName() + ") 0";
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
		//TODO we need to replace any occurrence of JvmAnyTypeReference with a better match from the expected type
		if (type instanceof JvmAnyTypeReference) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(expr);
			if (expectedType!=null && !(expectedType.getType() instanceof JvmTypeParameter))
				type = expectedType;
		}
		String varName = declareNameInVariableScope(expr, b);
		b.append("\n");
		serialize(type,expr,b);
		b.append(" ").append(varName).append(" = ");
		expression.exec();
		b.append(";");
	}

	/**
	 * whether an expression needs to be declared in a statement
	 * If an expression has side effects this method must return true for it.
	 */
	protected boolean isVariableDeclarationRequired(XExpression expr, IAppendable b) {
		return true;
	}
	
	protected TypeConformanceComputer getTypeConformanceComputer() {
		return typeConformanceComputer;
	}
}
