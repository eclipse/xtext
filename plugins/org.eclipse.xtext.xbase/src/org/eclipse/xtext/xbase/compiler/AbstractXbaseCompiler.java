/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Sets.*;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.JvmExceptions;
import org.eclipse.xtext.xbase.typing.JvmOnlyTypeConformanceComputer;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseCompiler {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeReferenceSerializer referenceSerializer;
	
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
	private JvmOnlyTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private JvmExceptions jvmExceptions;
	
	protected Primitives getPrimitives() {
		return primitives;
	}

	private PolymorphicDispatcher<Void> toJavaExprDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaExpression", 2, 2, this);

	private PolymorphicDispatcher<Void> toJavaStatementDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_toJavaStatement", 3, 3, this);

	public IAppendable compile(XExpression obj, IAppendable appendable, JvmTypeReference expectedReturnType) {
		return compile(obj, appendable, expectedReturnType, null);
	}
	
	public IAppendable compileAsJavaExpression(XExpression obj, IAppendable appendable, JvmTypeReference expectedType) {
		final boolean isPrimitiveVoidExpected = typeReferences.is(expectedType, Void.TYPE); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = exitComputer.isEarlyExit(obj);
		boolean needsSneakyThrow = needsSneakyThrow(obj, Collections.<JvmTypeReference>emptySet());
		boolean needsToBeWrapped = earlyExit || needsSneakyThrow || isVariableDeclarationRequired(obj, appendable);
		if (needsToBeWrapped) {
			appendable.openScope();
			try {
				Object thisElement = appendable.getObject("this");
				if (thisElement instanceof JvmType) {
					appendable.declareVariable(thisElement, ((JvmType) thisElement).getSimpleName()+".this");
					Object superElement = appendable.getObject("super");
					if (superElement instanceof JvmType) {
						appendable.declareVariable(superElement, ((JvmType) thisElement).getSimpleName()+".super");
					}
				}
				appendable.append("new ");
				JvmTypeReference procedureOrFunction = null;
				if (isPrimitiveVoidExpected) {
					procedureOrFunction = typeReferences.getTypeForName(Procedures.Procedure0.class, obj);
				} else {
					procedureOrFunction = typeReferences.getTypeForName(Functions.Function0.class, obj, expectedType);
				}
				referenceSerializer.serialize(procedureOrFunction, obj, appendable, false, false, true, false);
				appendable.append("() {").increaseIndentation();
				appendable.append("\npublic ");
				referenceSerializer.serialize(primitives.asWrapperTypeIfPrimitive(expectedType), obj, appendable);
				appendable.append(" apply() {").increaseIndentation();
				if (needsSneakyThrow) {
					appendable.append("\ntry {").increaseIndentation();
				}
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
				if (needsSneakyThrow) {
					String name = appendable.declareSyntheticVariable(new Object(), "_e");
					appendable.decreaseIndentation().append("\n} catch (Exception "+name+") {").increaseIndentation();
					appendable.append("\nthrow ");
					appendable.append(typeReferences.findDeclaredType(Exceptions.class, obj));
					appendable.append(".sneakyThrow(");
					appendable.append(name);
					appendable.append(");");
					appendable.decreaseIndentation().append("\n}");
				}
				appendable.decreaseIndentation().append("\n}");
				appendable.decreaseIndentation().append("\n}.apply()");
			} finally {
				appendable.closeScope();
			}
		} else {
			internalToJavaExpression(obj, appendable);
		}
		return appendable;
	}
	
	protected boolean canCompileToJavaExpression(XExpression expression, IAppendable appendable) {
		// TODO improve this decision, e.g. static methods with expression-args are ok
		return !isVariableDeclarationRequired(expression, appendable);
	}
	
	public IAppendable compile(XExpression obj, IAppendable appendable, JvmTypeReference expectedReturnType, Set<JvmTypeReference> declaredExceptions) {
		if (declaredExceptions == null)
			declaredExceptions = newHashSet();
		final boolean isPrimitiveVoidExpected = typeReferences.is(expectedReturnType, Void.TYPE); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = exitComputer.isEarlyExit(obj);
		boolean needsSneakyThrow = needsSneakyThrow(obj, declaredExceptions);
		if (needsSneakyThrow) {
			appendable.append("\ntry {").increaseIndentation();
		}
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
		if (needsSneakyThrow) {
			String name = appendable.declareSyntheticVariable(new Object(), "_e");
			appendable.decreaseIndentation().append("\n} catch (Exception "+name+") {").increaseIndentation();
			appendable.append("\nthrow ");
			appendable.append(typeReferences.findDeclaredType(Exceptions.class, obj));
			appendable.append(".sneakyThrow(");
			appendable.append(name);
			appendable.append(");");
			appendable.decreaseIndentation().append("\n}");
		}
		return appendable;
	}

	protected boolean needsSneakyThrow(XExpression obj, Set<JvmTypeReference> declaredExceptions) {
		Iterable<JvmTypeReference> types = typeProvider.getThrownExceptionTypes(obj);
		Iterable<JvmTypeReference> exceptions = jvmExceptions.findUnhandledExceptions(obj, types, declaredExceptions);
		return ! Iterables.isEmpty(exceptions);
	}
	
	/**
	 * this one trims the outer block
	 */
	public IAppendable compile(XBlockExpression expr, IAppendable b, JvmTypeReference expectedReturnType) {
		final boolean isPrimitiveVoidExpected = typeReferences.is(expectedReturnType, Void.TYPE); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(expr);
		final boolean earlyExit = exitComputer.isEarlyExit(expr);
		final boolean isImplicitReturn = !isPrimitiveVoidExpected && !isPrimitiveVoid && !earlyExit;
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b, false);
			} else {
				internalToJavaStatement(ex, b, isImplicitReturn);
				if (isImplicitReturn) {
					b.append("\nreturn (");
					internalToConvertedExpression(ex, b, null);
					b.append(");");
				}
			}
		}
		return b;
	}
	
	protected abstract void internalToConvertedExpression(final XExpression obj, final IAppendable appendable,
			JvmTypeReference toBeConvertedTo);
	
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
		referenceSerializer.serialize(type, context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
	}
	
	protected boolean isReferenceToForeignTypeParameter(final JvmTypeReference reference, EObject context) {
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			return !referenceSerializer.isLocalTypeParameter(context, (JvmTypeParameter) type);
		}
		return false;
	}

	protected JvmTypeReference resolveMultiType(JvmTypeReference typeRef) {
		return referenceSerializer.resolveMultiType(typeRef);
	}
	
	protected String getVarName(Object ex, IAppendable appendable) {
		String name = appendable.getName(ex);
		return name;
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
	
	protected void declareSyntheticVariable(final XExpression expr, final IAppendable b) {
		declareSyntheticVariable(expr, b, new Later() {
			@Override
			public void exec() {
				b.append(getDefaultValueLiteral(expr));
			}
		});
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

	/**
	 * TODO rename this method to 'declareFreshLocalVariable' after 2.1.x
	 */
	protected void declareSyntheticVariable(XExpression expr, IAppendable b, Later expression) {
		JvmTypeReference type = getTypeProvider().getType(expr);
		//TODO we need to replace any occurrence of JvmAnyTypeReference with a better match from the expected type
		if (type instanceof JvmAnyTypeReference) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(expr);
			if (expectedType!=null && !(expectedType.getType() instanceof JvmTypeParameter))
				type = expectedType;
		}
		final String proposedName = makeJavaIdentifier(getFavoriteVariableName(expr));
		final String varName = b.declareSyntheticVariable(expr, proposedName);
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
