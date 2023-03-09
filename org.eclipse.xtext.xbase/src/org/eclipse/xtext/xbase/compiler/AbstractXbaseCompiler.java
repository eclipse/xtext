/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.JavaVersion.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.conformance.RawTypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseCompiler {

	@Inject
	private TypeReferenceSerializer referenceSerializer;
	
	public TypeReferenceSerializer getTypeReferenceSerializer() {
		return referenceSerializer;
	}
	
	@Inject
	private CommonTypeComputationServices services;

	@Inject
	private JavaKeywords javaUtils;

	@Inject 
	private IBatchTypeResolver typeResolver;

	// TODO doublecheck usage of this one
	@Inject
	private IEarlyExitComputer exitComputer;
	
	private IBatchTypeResolver getTypeResolver() {
		return typeResolver;
	}
	
	/* @Nullable */
	protected JvmType findKnownTopLevelType(Class<?> rawType, Notifier context) {
		if (rawType.isArray()) {
			throw new IllegalArgumentException(rawType.getCanonicalName());
		}
		if (rawType.isPrimitive()) {
			throw new IllegalArgumentException(rawType.getName());
		}
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet == null) {
			return null;
		}
		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(rawType.getName()), true);
		List<EObject> resourceContents = typeResource.getContents();
		if (resourceContents.isEmpty())
			return null;
		JvmType type = (JvmType) resourceContents.get(0);
		return type;
	}
	
	/* @Nullable */
	protected JvmType findKnownType(Class<?> rawType, Notifier context) {
		if (rawType.isArray()) {
			throw new IllegalArgumentException(rawType.getCanonicalName());
		}
		if (rawType.isPrimitive()) {
			throw new IllegalArgumentException(rawType.getName());
		}		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet == null) {
			return null;
		}
		Class<?> declaringClass = rawType.getDeclaringClass();
		if (declaringClass == null) {
			return findKnownTopLevelType(rawType, resourceSet);
		}
		JvmType result = (JvmType) resourceSet.getEObject(URIHelperConstants.OBJECTS_URI.appendSegment(declaringClass.getName()).appendFragment(rawType.getName()), true);
		return result;
	}
	
	protected CommonTypeComputationServices getTypeComputationServices() {
		return services;
	}
	
	protected ITypeReferenceOwner newTypeReferenceOwner(EObject context) {
		return new StandardTypeReferenceOwner(services, context);
	}
	
	protected LightweightTypeReference toLightweight(JvmTypeReference reference, EObject context) {
		return newTypeReferenceOwner(context).toLightweightTypeReference(reference);
	}
	
	public ITreeAppendable compile(XExpression obj, ITreeAppendable appendable, LightweightTypeReference expectedReturnType) {
		compile(obj, appendable, expectedReturnType, null);
		return appendable;
	}
	
	public ITreeAppendable compileAsJavaExpression(XExpression obj, ITreeAppendable parentAppendable, JvmTypeReference expectedType) {
		LightweightTypeReference converted = null;
		if (expectedType != null) {
			converted = newTypeReferenceOwner(obj).toLightweightTypeReference(expectedType);
		}
		return compileAsJavaExpression(obj, parentAppendable, converted);
	}
	
	public ITreeAppendable compileAsJavaExpression(XExpression obj, ITreeAppendable parentAppendable, LightweightTypeReference expectedType) {
		ITreeAppendable appendable = parentAppendable.trace(obj, true);
		if (expectedType == null) {
			expectedType = getLightweightReturnType(obj);
			if (expectedType == null) {
				expectedType = getLightweightType(obj);
			}
		}
		final boolean isPrimitiveVoidExpected = expectedType.isPrimitiveVoid(); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = isEarlyExit(obj);
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
				JvmType procedureOrFunction = null;
				if (isPrimitiveVoidExpected) {
					procedureOrFunction = findKnownType(Procedures.Procedure0.class, obj);
				} else {
					procedureOrFunction = findKnownType(Functions.Function0.class, obj);
				}
				if (procedureOrFunction != null) {
					appendable.append(procedureOrFunction);
					if (!isPrimitiveVoidExpected) {
						appendable.append("<");
						appendable.append(expectedType.getWrapperTypeIfPrimitive());
						appendable.append(">");
					}
				} else {
					appendable.append("Object");
				}
				appendable.append("() {").increaseIndentation();
				GeneratorConfig config = appendable.getGeneratorConfig();
				if (config != null && config.getJavaSourceVersion().isAtLeast(JAVA6)) {
					appendable.newLine().append("@").append(Override.class);
				}
				appendable.newLine().append("public ");
				appendable.append(expectedType.getWrapperTypeIfPrimitive());
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
					generateCheckedExceptionHandling(appendable);
				}
				appendable.decreaseIndentation().newLine().append("}");
				appendable.decreaseIndentation().newLine().append("}.apply()");
				if (expectedType.isPrimitive()) {
					appendable.append(".").append(expectedType.getSimpleName()).append("Value()");
				}
			} finally {
				appendable.closeScope();
			}
		} else {
			internalToJavaExpression(obj, appendable);
		}
		return parentAppendable;
	}
	
	protected void appendDefaultLiteral(ITreeAppendable b, /* @Nullable */ LightweightTypeReference type) {
		if (type != null && type.isPrimitive()) {
			Primitive primitiveKind = type.getPrimitiveKind();
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
	
	protected void generateCheckedExceptionHandling(ITreeAppendable appendable) {
		String name = appendable.declareSyntheticVariable(new Object(), "_e");
		appendable.decreaseIndentation().newLine().append("} catch (").append(Throwable.class).append(" ").append(name).append(") {").increaseIndentation();
		appendable.newLine().append("throw ");
		appendable.append(Exceptions.class);
		appendable.append(".sneakyThrow(");
		appendable.append(name);
		appendable.append(");");
		appendable.decreaseIndentation().newLine().append("}");
	}
	
	protected boolean canCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		return internalCanCompileToJavaExpression(expression, appendable);
	}
	
	/**
	 * @param expression to be used by subtypes 
	 * @param appendable to be used by subtypes
	 */
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		return true;
	}
	
	public ITreeAppendable compile(XExpression obj, ITreeAppendable parentAppendable, /* @Nullable */ JvmTypeReference expectedReturnType, /* @Nullable */ Set<JvmTypeReference> declaredExceptions) {
		LightweightTypeReference converted = null;
		if (expectedReturnType != null) {
			converted = newTypeReferenceOwner(obj).toLightweightTypeReference(expectedReturnType);
		}
		return compile(obj, parentAppendable, converted, declaredExceptions);
	}
	
	public ITreeAppendable compile(XExpression obj, ITreeAppendable parentAppendable, /* @Nullable */ LightweightTypeReference expectedReturnType, /* @Nullable */ Set<JvmTypeReference> declaredExceptions) {
		if (declaredExceptions == null) {
			declaredExceptions = newHashSet();
			assert declaredExceptions != null;
		}
		ITreeAppendable appendable = parentAppendable.trace(obj, true);
		final boolean isPrimitiveVoidExpected = expectedReturnType.isPrimitiveVoid(); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(obj);
		final boolean earlyExit = isEarlyExit(obj);
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
				internalToConvertedExpression(obj, appendable, expectedReturnType);
			}
			appendable.append(";");
		}
		if (needsSneakyThrow) {
			generateCheckedExceptionHandling(appendable);
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
		
		generateCheckedExceptionHandling(apendable);
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
		IResolvedTypes resolvedTypes = getResolvedTypes(obj);
		List<LightweightTypeReference> thrownExceptions = resolvedTypes.getThrownExceptions(obj);
		return (hasUnhandledException(thrownExceptions, declaredExceptions));
	}
	
	protected boolean hasUnhandledException(List<LightweightTypeReference> thrownExceptions, Collection<JvmTypeReference> declaredExceptions) {
		for(LightweightTypeReference thrownException: thrownExceptions) {
			if (!thrownException.isSubtypeOf(RuntimeException.class) && !thrownException.isSubtypeOf(Error.class)) {
				if (isUnhandledException(thrownException, declaredExceptions)) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isUnhandledException(LightweightTypeReference thrownException, Collection<JvmTypeReference> declaredExceptions) {
		for(JvmTypeReference declaredException: declaredExceptions) {
			if (thrownException.isSubtypeOf(declaredException.getType())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * this one trims the outer block
	 */
	public ITreeAppendable compile(XBlockExpression expr, ITreeAppendable b, LightweightTypeReference expectedReturnType) {
		final boolean isPrimitiveVoidExpected = expectedReturnType.isPrimitiveVoid(); 
		final boolean isPrimitiveVoid = isPrimitiveVoid(expr);
		final boolean earlyExit = isEarlyExit(expr);
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
					internalToConvertedExpression(ex, b, expectedReturnType);
					b.append(");");
				}
			}
		}
		return b;
	}

	protected boolean isEarlyExit(XExpression expr) {
		return exitComputer.isEarlyExit(expr);
	}

	protected boolean isPrimitiveVoid(JvmTypeReference typeRef) {
		JvmType type = typeRef.getType();
		if (type instanceof JvmVoid) {
			return !type.eIsProxy();
		}
		return false;
	}

	protected JvmTypeReference getType(XExpression expr) {
		LightweightTypeReference actualType = getLightweightType(expr);
		if (actualType != null)
			return actualType.toTypeReference();
		return null;
	}
	
	protected JvmTypeReference getType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference actualType = getLightweightType(identifiable);
		if (actualType != null)
			return actualType.toTypeReference();
		return null;
	}

	protected LightweightTypeReference getLightweightType(XExpression expr) {
		IResolvedTypes resolvedTypes = getResolvedTypes(expr);
		LightweightTypeReference actualType = resolvedTypes.getActualType(expr);
		return actualType;
	}
	
	protected LightweightTypeReference getLightweightType(JvmIdentifiableElement identifiable) {
		IResolvedTypes resolvedTypes = getResolvedTypes(identifiable);
		LightweightTypeReference actualType = resolvedTypes.getActualType(identifiable);
		return actualType;
	}
	
//	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement identifiable) {
//		IResolvedTypes resolvedTypes = getResolvedTypes(identifiable);
//		JvmTypeReference result = resolvedTypes.getDeclaredType(identifiable);
//		return result;
//	}
	
	protected LightweightTypeReference getLightweightReturnType(XExpression expr) {
		IResolvedTypes resolvedTypes = getResolvedTypes(expr);
		LightweightTypeReference returnType = resolvedTypes.getReturnType(expr);
		return returnType;
	}

	protected IResolvedTypes getResolvedTypes(EObject obj) {
		return getTypeResolver().resolveTypes(obj);
	}
	
	protected JvmTypeReference getExpectedType(XExpression expr) {
		LightweightTypeReference expectedType = getLightweightExpectedType(expr);
		if (expectedType != null)
			return expectedType.toTypeReference();
		return null;
	}
	
	protected LightweightTypeReference getLightweightExpectedType(XExpression expr) {
		IResolvedTypes resolvedTypes = getResolvedTypes(expr);
		LightweightTypeReference expectedType = resolvedTypes.getExpectedType(expr);
		return expectedType;
	}
	
	protected abstract void internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable,
			/* @Nullable */ LightweightTypeReference toBeConvertedTo);
	
	protected boolean isPrimitiveVoid(XExpression xExpression) {
		LightweightTypeReference type = getLightweightType(xExpression);
		return type != null && type.isPrimitiveVoid();
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
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) ex;
			JvmIdentifiableElement feature = featureCall.getFeature();
			String name;
			if (feature == null || feature.eIsProxy()) {
				if (featureCall instanceof XBinaryOperation || featureCall instanceof XUnaryOperation) {
					name = featureCall.eClass().getName();
				} else {
					name = featureCall.getConcreteSyntaxFeatureName();
				}
			} else {
				name = nameProvider.getSimpleName(feature);
			}
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
			JvmConstructor constructor = ((XConstructorCall) ex).getConstructor();
			String name = constructor != null && !constructor.eIsProxy() ? constructor.getSimpleName() : "instance";
			return "_"+Strings.toFirstLower(name);
		}
		return "_"+Strings.toFirstLower(ex.eClass().getName().toLowerCase());
	}

	protected String makeJavaIdentifier(String name) {
		return javaUtils.isJavaKeyword(name) ? name+"_" : name;
	}
	
	protected boolean isJavaConformant(LightweightTypeReference left, LightweightTypeReference right) {
		boolean result = (services.getTypeConformanceComputer().isConformant(
				left, right,
				RawTypeConformanceComputer.ALLOW_PRIMITIVE_WIDENING | RawTypeConformanceComputer.ALLOW_RAW_TYPE_CONVERSION | RawTypeConformanceComputer.ALLOW_BOXING | RawTypeConformanceComputer.ALLOW_UNBOXING) & RawTypeConformanceComputer.SUCCESS) != 0;
		return result;
	}
	
	protected void declareSyntheticVariable(final XExpression expr, ITreeAppendable b) {
		declareFreshLocalVariable(expr, b, new Later() {
			@Override
			public void exec(ITreeAppendable appendable) {
				appendable.append(getDefaultValueLiteral(expr));
			}
		});
	}

	protected String getDefaultValueLiteral(XExpression expr) {
		LightweightTypeReference type = getTypeForVariableDeclaration(expr);
		if (type.isPrimitive()) {
			if (type.getPrimitiveKind() == Primitives.Primitive.Boolean) {
				return "false";
			} else {
				return "(" + type.getSimpleName() + ") 0";
			}
		}
		return "null";
	}

	protected void declareFreshLocalVariable(XExpression expr, ITreeAppendable b, Later expression) {
		LightweightTypeReference type = getTypeForVariableDeclaration(expr);
		final String proposedName = makeJavaIdentifier(getFavoriteVariableName(expr));
		final String varName = b.declareSyntheticVariable(expr, proposedName);
		b.newLine();
		b.append(type);
		b.append(" ").append(varName).append(" = ");
		expression.exec(b);
		b.append(";");
	}

	protected LightweightTypeReference getTypeForVariableDeclaration(XExpression expr) {
		IResolvedTypes resolvedTypes = getResolvedTypes(expr);
		LightweightTypeReference actualType = resolvedTypes.getActualType(expr);
		if (actualType.isPrimitiveVoid()) {
			LightweightTypeReference expectedType = resolvedTypes.getExpectedType(expr);
			if (expectedType == null) {
				expectedType = resolvedTypes.getExpectedReturnType(expr);
				if (expectedType == null) {
					expectedType = resolvedTypes.getReturnType(expr);
				}
			}
			if (expectedType != null && !expectedType.isPrimitiveVoid()) {
				actualType = expectedType;
			}
		}
		return actualType;
	}

	/**
	 * whether an expression needs to be declared in a statement
	 * If an expression has side effects this method must return true for it.
	 * @param expr the checked expression
	 * @param b the appendable which represents the current compiler state
	 * @deprecated use {@link #isVariableDeclarationRequired(XExpression, ITreeAppendable, boolean)} instead.
	 */
	@Deprecated
	protected final boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		return isVariableDeclarationRequired(expr, b, true);
	}

	/**
	 * whether an expression needs to be declared in a statement
	 * If an expression has side effects this method must return true for it.
	 * @param expr the checked expression
	 * @param b the appendable which represents the current compiler state
	 * @param recursive determines if the siblings of the expression shall be investigated too to determine the is variable declaration required status
	 */
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b, boolean recursive) {
		return true;
	}

	/**
	 * @return the variable name under which the result of the expression is stored. Returns <code>null</code> if the
	 *          expression hasn't been assigned to a local variable before.
	 */
	/* @Nullable */
	protected String getReferenceName(XExpression expr, ITreeAppendable b) {
		if (b.hasName(expr))
			return b.getName(expr);
		if (expr instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) expr;
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (b.hasName(feature))
				return b.getName(feature);
		}
		return null;
	}
	
}
