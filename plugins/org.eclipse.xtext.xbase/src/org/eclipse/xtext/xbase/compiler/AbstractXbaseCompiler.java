/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
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
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.JvmExceptions;
import org.eclipse.xtext.xbase.typing.JvmOnlyTypeConformanceComputer;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@NonNullByDefault
public abstract class AbstractXbaseCompiler {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeReferenceSerializer referenceSerializer;
	
	public TypeReferenceSerializer getTypeReferenceSerializer() {
		return referenceSerializer;
	}
	
	@Inject
	private JavaKeywords javaUtils;

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private ITypeProvider typeProvider;

	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	@Inject 
	private IBatchTypeResolver typeResolver;

	protected IBatchTypeResolver getTypeResolver() {
		return typeResolver;
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

	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	protected CommonTypeComputationServices getTypeComputationServices() {
		return services;
	}
	
	protected ITypeReferenceOwner newTypeReferenceOwner(EObject context) {
		return new StandardTypeReferenceOwner(services, context);
	}
	
	protected LightweightTypeReference toLightweight(JvmTypeReference reference, EObject context) {
		return new OwnedConverter(newTypeReferenceOwner(context)).apply(reference);
	}
	
	/**
	 * @deprecated not called anywhere. 
	 */
	@Deprecated
	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}
	
	public ITreeAppendable compile(XExpression obj, ITreeAppendable appendable, JvmTypeReference expectedReturnType) {
		compile(obj, appendable, expectedReturnType, null);
		return appendable;
	}
	
	public ITreeAppendable compileAsJavaExpression(XExpression obj, ITreeAppendable parentAppendable, JvmTypeReference expectedType) {
		ITreeAppendable appendable = parentAppendable.trace(obj, true);
		
		final boolean isPrimitiveVoidExpected = isPrimitiveVoid(expectedType); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = exitComputer.isEarlyExit(obj);
		boolean needsSneakyThrow = needsSneakyThrow(obj, Collections.<JvmTypeReference>emptySet());
		boolean needsToBeWrapped = earlyExit || needsSneakyThrow || !canCompileToJavaExpression(obj, appendable);
		if (needsToBeWrapped) {
			appendable.openScope();
			try {
				if (appendable.hasObject("this")) {
					Object thisElement = appendable.getObject("this");
					if (thisElement instanceof JvmType) {
						appendable.declareVariable(thisElement, ((JvmType) thisElement).getSimpleName()+".this");
						if (appendable.hasObject("super")) {
							Object superElement = appendable.getObject("super");
							if (superElement instanceof JvmType) {
								appendable.declareVariable(superElement, ((JvmType) thisElement).getSimpleName()+".super");
							}
						}
					}
				}
				appendable.append("new ");
				JvmTypeReference procedureOrFunction = null;
				if (isPrimitiveVoidExpected) {
					procedureOrFunction = typeReferences.getTypeForName(Procedures.Procedure0.class, obj);
				} else {
					procedureOrFunction = typeReferences.getTypeForName(Functions.Function0.class, obj, expectedType);
				}
				if (procedureOrFunction != null)
					referenceSerializer.serialize(procedureOrFunction, obj, appendable, false, false, true, false);
				else
					appendable.append("Object");
				appendable.append("() {").increaseIndentation();
				appendable.newLine().append("public ");
				referenceSerializer.serialize(primitives.asWrapperTypeIfPrimitive(expectedType), obj, appendable);
				appendable.append(" apply() {").increaseIndentation();
				if (needsSneakyThrow) {
					appendable.newLine().append("try {").increaseIndentation();
				}
				internalToJavaStatement(obj, appendable, !isPrimitiveVoidExpected && !isPrimitiveVoid && !earlyExit);
				if (!isPrimitiveVoidExpected && !earlyExit) {
						appendable.newLine().append("return ");
						if (isPrimitiveVoid && !isPrimitiveVoidExpected) {
							appendDefaultLiteral(appendable, expectedType);
						} else {
							internalToJavaExpression(obj, appendable);
						}
						appendable.append(";");
				}
				if (needsSneakyThrow) {
					generateCheckedExceptionHandling(obj, appendable);
				}
				appendable.decreaseIndentation().newLine().append("}");
				appendable.decreaseIndentation().newLine().append("}.apply()");
			} finally {
				appendable.closeScope();
			}
		} else {
			internalToJavaExpression(obj, appendable);
		}
		return parentAppendable;
	}
	
	protected void appendDefaultLiteral(ITreeAppendable b, @Nullable JvmTypeReference type) {
		if (type != null && getPrimitives().isPrimitive(type)) {
			Primitive primitiveKind = getPrimitives().primitiveKind((JvmPrimitiveType) type.getType());
			switch (primitiveKind) {
				case Boolean:
					b.append("false");
					break;
				default:
					b.append("0");
					break;
			}
		} else {
			b.append("null");
		}
	}
	
	protected void generateCheckedExceptionHandling(XExpression obj, ITreeAppendable appendable) {
		String name = appendable.declareSyntheticVariable(new Object(), "_e");
		appendable.decreaseIndentation().newLine().append("} catch (Throwable "+name+") {").increaseIndentation();
		final JvmType findDeclaredType = typeReferences.findDeclaredType(Exceptions.class, obj);
		if (findDeclaredType == null) {
			appendable.append("COMPILE ERROR : '"+Exceptions.class.getCanonicalName()+"' could not be found on the classpath!");
		} else {
			appendable.newLine().append("throw ");
			appendable.append(findDeclaredType);
			appendable.append(".sneakyThrow(");
			appendable.append(name);
			appendable.append(");");
		}
		appendable.decreaseIndentation().newLine().append("}");
	}
	
	protected boolean canCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(expression);
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof XExpression) {
				if (!internalCanCompileToJavaExpression((XExpression) next, appendable))
					return false;
			}
		}
		return true;
	}
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		return getReferenceName(expression, appendable) != null || !isVariableDeclarationRequired(expression, appendable);
	}
	
	public ITreeAppendable compile(XExpression obj, ITreeAppendable parentAppendable, @Nullable JvmTypeReference expectedReturnType, @Nullable Set<JvmTypeReference> declaredExceptions) {
		if (declaredExceptions == null) {
			declaredExceptions = newHashSet();
			assert declaredExceptions != null;
		}
		ITreeAppendable appendable = parentAppendable.trace(obj, true);
		final boolean isPrimitiveVoidExpected = isPrimitiveVoid(expectedReturnType); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = exitComputer.isEarlyExit(obj);
		boolean needsSneakyThrow = needsSneakyThrow(obj, declaredExceptions);
		if (needsSneakyThrow && isPrimitiveVoidExpected && hasJvmConstructorCall(obj)) {
			compileWithJvmConstructorCall((XBlockExpression) obj, appendable);
			return parentAppendable;
		}
		if (needsSneakyThrow) {
			appendable.newLine().append("try {").increaseIndentation();
		}
		internalToJavaStatement(obj, appendable, !isPrimitiveVoidExpected && !isPrimitiveVoid && !earlyExit);
		if (!isPrimitiveVoidExpected && !earlyExit) {
				appendable.newLine().append("return ");
				if (isPrimitiveVoid && !isPrimitiveVoidExpected) {
					appendDefaultLiteral(appendable, expectedReturnType);
				} else {
					internalToJavaExpression(obj, appendable);
				}
				appendable.append(";");
		}
		if (needsSneakyThrow) {
			generateCheckedExceptionHandling(obj, appendable);
		}
		return parentAppendable;
	}
	
	protected void compileWithJvmConstructorCall(XBlockExpression obj, ITreeAppendable apendable) {
		EList<XExpression> expressions = obj.getExpressions();
		internalToJavaStatement(expressions.get(0), apendable.trace(obj, false), false);
		if (expressions.size() == 1) {
			return;
		}
		
		apendable.newLine().append("try {").increaseIndentation();
		
		ITreeAppendable b = apendable.trace(obj, false);
		for (int i = 1; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			internalToJavaStatement(ex, b, false);
		}
		
		generateCheckedExceptionHandling(obj, apendable);
	}
	
	protected boolean hasJvmConstructorCall(XExpression obj) {
		if (!(obj instanceof XBlockExpression)) {
			return false;
		}
		XBlockExpression blockExpression = (XBlockExpression) obj;
		EList<XExpression> expressions = blockExpression.getExpressions();
		if (expressions.isEmpty()) {
			return false;
		}
		XExpression expr = expressions.get(0);
		if (!(expr instanceof XFeatureCall)) {
			return false;
		}
		XFeatureCall featureCall = (XFeatureCall) expr;
		return featureCall.getFeature() instanceof JvmConstructor;
	}

	protected boolean needsSneakyThrow(XExpression obj, Collection<JvmTypeReference> declaredExceptions) {
		Iterable<JvmTypeReference> types = typeProvider.getThrownExceptionTypes(obj);
		Iterable<JvmTypeReference> exceptions = jvmExceptions.findUnhandledExceptions(obj, types, declaredExceptions);
		return ! Iterables.isEmpty(exceptions);
	}
	
	/**
	 * this one trims the outer block
	 */
	public ITreeAppendable compile(XBlockExpression expr, ITreeAppendable b, JvmTypeReference expectedReturnType) {
		final boolean isPrimitiveVoidExpected = isPrimitiveVoid(expectedReturnType); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(expr);
		final boolean earlyExit = exitComputer.isEarlyExit(expr);
		final boolean isImplicitReturn = !isPrimitiveVoidExpected && !isPrimitiveVoid && !earlyExit;
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b.trace(ex, true), false);
			} else {
				internalToJavaStatement(ex, b.trace(ex, true), isImplicitReturn);
				if (isImplicitReturn) {
					b.newLine().append("return (");
					internalToConvertedExpression(ex, b, getType(expr));
					b.append(");");
				}
			}
		}
		return b;
	}

	protected boolean isPrimitiveVoid(JvmTypeReference typeRef) {
		return typeReferences.is(typeRef, Void.TYPE);
	}

	protected JvmTypeReference getType(XExpression expr) {
		return getTypeProvider().getType(expr);
	}
	
	protected abstract void internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable,
			@Nullable JvmTypeReference toBeConvertedTo);
	
	protected boolean isPrimitiveVoid(XExpression xExpression) {
		JvmTypeReference type = getType(xExpression);
		return isPrimitiveVoid(type);
	}

	protected final void internalToJavaStatement(XExpression obj, ITreeAppendable builder, boolean isReferenced) {
		final ITreeAppendable trace = builder.trace(obj, true);
		doInternalToJavaStatement(obj, trace, isReferenced);
	}

	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable builder, boolean isReferenced) {
		_toJavaStatement(obj, builder, isReferenced);
	}
	
	public void toJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
		internalToJavaExpression(obj, appendable.trace(obj, true));
	}
	
	public void toJavaStatement(final XExpression obj, final ITreeAppendable appendable, boolean isReferenced) {
		internalToJavaStatement(obj, appendable.trace(obj, true), isReferenced);
	}

	protected void internalToJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
		_toJavaExpression(obj, appendable);
	}

	/**
	 * @param b the appendable, unused, but necessary for dispatching purpose
	 * @param isReferenced unused, but necessary for dispatching purpose
	 */
	public void _toJavaStatement(XExpression func, ITreeAppendable b, boolean isReferenced) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	/**
	 * @param b the appendable, unused, but necessary for dispatching purpose
	 */
	public void _toJavaExpression(XExpression func, ITreeAppendable b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	protected void serialize(final JvmTypeReference type, EObject context, ITreeAppendable appendable) {
		serialize(type, context, appendable, false, true);
	}
	
	protected void serialize(final JvmTypeReference type, EObject context, ITreeAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard) {
		serialize(type, context, appendable, withoutConstraints, paramsToWildcard, false, true);
	}
	
	protected void serialize(final JvmTypeReference type, EObject context, ITreeAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		referenceSerializer.serialize(type, context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
	}
	
	protected boolean isReferenceToForeignTypeParameter(final JvmTypeReference reference, EObject context) {
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			return !referenceSerializer.isLocalTypeParameter(context, (JvmTypeParameter) type);
		}
		return false;
	}

	protected JvmTypeReference resolveMultiType(JvmTypeReference typeRef, EObject context) {
		return referenceSerializer.resolveMultiType(typeRef, context);
	}
	
	protected String getVarName(Object ex, ITreeAppendable appendable) {
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
		if(ex instanceof JvmArrayType) {
			return getFavoriteVariableName(((JvmArrayType) ex).getComponentType());
		}
		if(ex instanceof JvmType) {
			return "_" + Strings.toFirstLower(((JvmType) ex).getSimpleName());
		}
		if (ex instanceof JvmIdentifiableElement) {
			return ((JvmIdentifiableElement) ex).getSimpleName();
		}
		if (ex instanceof XAbstractFeatureCall) {
			String name = nameProvider.getSimpleName(((XAbstractFeatureCall) ex).getFeature());
			if (name == null) {
				throw new IllegalStateException("name may not be null");
			}
			int indexOf = name.indexOf('(');
			if (indexOf != -1) {
				name = name.substring(0, indexOf);
			}
			indexOf = name.lastIndexOf('.');
			if (indexOf != -1) {
				name = name.substring(indexOf + 1);
			}
			if (name.startsWith(OperatorMapping.OP_PREFIX))
				name = Strings.toFirstLower(name.substring(OperatorMapping.OP_PREFIX.length()));
			else if (name.startsWith("get") && name.length() > 3)
				name = Strings.toFirstLower(name.substring(3));
			else if (name.startsWith("to") && name.length() > 2)
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
		return javaUtils.isJavaKeyword(name) ? name+"_" : name;
	}
	
	protected void declareSyntheticVariable(final XExpression expr, ITreeAppendable b) {
		declareFreshLocalVariable(expr, b, new Later() {
			public void exec(ITreeAppendable appendable) {
				appendable.append(getDefaultValueLiteral(expr));
			}
		});
	}

	protected String getDefaultValueLiteral(XExpression expr) {
		JvmTypeReference type = getTypeForVariableDeclaration(expr);
		if (primitives.isPrimitive(type)) {
			if (primitives.primitiveKind((JvmPrimitiveType) type.getType()) == Primitive.Boolean) {
				return "false";
			} else {
				return "(" + type.getQualifiedName() + ") 0";
			}
		}
		return "null";
	}

	protected void declareFreshLocalVariable(XExpression expr, ITreeAppendable b, Later expression) {
		JvmTypeReference type = getTypeForVariableDeclaration(expr);
		final String proposedName = makeJavaIdentifier(getFavoriteVariableName(expr));
		final String varName = b.declareSyntheticVariable(expr, proposedName);
		b.newLine();
		serialize(type,expr,b);
		b.append(" ").append(varName).append(" = ");
		expression.exec(b);
		b.append(";");
	}

	protected JvmTypeReference getTypeForVariableDeclaration(XExpression expr) {
		JvmTypeReference type = getType(expr);
		//TODO we need to replace any occurrence of JvmAnyTypeReference with a better match from the expected type
		if (type instanceof JvmAnyTypeReference || isPrimitiveVoid(type)) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(expr);
			if (expectedType == null) {
				expectedType = getTypeProvider().getExpectedReturnType(expr, false);
				if (expectedType == null) {
					expectedType = getTypeProvider().getCommonReturnType(expr, true);
				}
			}
			if (expectedType != null && !isPrimitiveVoid(expectedType)) {
				type = expectedType;
			}
		}
		return type;
	}

	/**
	 * whether an expression needs to be declared in a statement
	 * If an expression has side effects this method must return true for it.
	 * @param expr the checked expression
	 * @param b the appendable which represents the current compiler state
	 */
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		return true;
	}
	
	protected TypeConformanceComputer getTypeConformanceComputer() {
		return typeConformanceComputer;
	}

	/**
	 * @return the variable name under which the result of the expression is stored. Returns <code>null</code> if the
	 *          expression hasn't been assigned to a local variable before.
	 */
	@Nullable
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
	
}
