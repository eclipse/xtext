/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Stephane Galland - Change visibilities of convertion functions.
 */
public class TypeConvertingCompiler extends AbstractXbaseCompiler {

	@Override
	protected final void internalToJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
		LightweightTypeReference expectedType = getLightweightExpectedType(obj);
		
		internalToConvertedExpression(obj, appendable, expectedType);
	}

	@Override
	protected void internalToConvertedExpression(final XExpression obj, ITreeAppendable appendable,
			/* @Nullable */ LightweightTypeReference toBeConvertedTo) {
		if (toBeConvertedTo != null) {
			LightweightTypeReference actualType = getLightweightType(obj);
			if (actualType.isPrimitiveVoid()) {
				actualType = toBeConvertedTo;
			}
			if (isToBeCastedAnyType(actualType, obj, appendable)) {
				if (!toBeConvertedTo.getJavaIdentifier().equals(actualType.getJavaIdentifier())) {
					doCastConversion(toBeConvertedTo, appendable, new Later() {
						@Override
						public void exec(ITreeAppendable appendable) {
							appendable = appendable.trace(obj, true);
							internalToConvertedExpression(obj, appendable);
						}
					});
					return;
				}
			}
			if (!toBeConvertedTo.getUniqueIdentifier().equals(actualType.getUniqueIdentifier())) {
				doConversion(toBeConvertedTo, actualType, appendable, obj, new Later() {
					@Override
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
			if (mustInsertTypeCast(obj, actualType)) {
				doCastConversion(actualType, appendable, new Later() {
					@Override
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		} else {
			LightweightTypeReference actualType = getLightweightType(obj);
			if (obj instanceof XAbstractFeatureCall && mustInsertTypeCast(obj, actualType)){
				doCastConversion(actualType, appendable, new Later() {
					@Override
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		}
		final ITreeAppendable trace = appendable.trace(obj, true);
		internalToConvertedExpression(obj, trace);
	}

	/**
	 * On Java-level the any-type is represented as java.lang.Object as there is no subtype of everything (i.e. type for null).
	 * So, when the values are used we need to manually cast them to whatever is expected.
	 * 
	 *  This method tells us whether such a cast is needed.
	 */
	private boolean isToBeCastedAnyType(LightweightTypeReference actualType, XExpression obj, ITreeAppendable appendable) {
		if (actualType instanceof AnyTypeReference) {
			if (getReferenceName(obj, appendable) != null)
				return true;
			else if (obj instanceof XBlockExpression) {
				XBlockExpression blockExpression = (XBlockExpression) obj;
				EList<XExpression> expressions = blockExpression.getExpressions();
				if (expressions.isEmpty())
					return false;
				if (expressions.size() > 1)
					return true;
				XExpression last = expressions.get(0);
				return isToBeCastedAnyType(actualType, last, appendable);
			}
		}
		return false;
	}

	private boolean mustInsertTypeCast(XExpression expression, LightweightTypeReference actualType) {
		IResolvedTypes resolvedTypes = getResolvedTypes(expression);
		if (mustCheckForMandatoryTypeCast(resolvedTypes, expression)) {
			if (expression instanceof XAbstractFeatureCall) {
				LightweightTypeReference featureType = resolvedTypes.getActualType(((XAbstractFeatureCall) expression).getFeature());
				if (featureType != null && !featureType.isMultiType() && actualType.isAssignableFrom(featureType)) {
					return false;
				}
				if (featureType != null && featureType.isMultiType()) {
					JvmTypeReference compliantTypeReference = featureType.toJavaCompliantTypeReference();
					if (actualType.isAssignableFrom(featureType.getOwner().toLightweightTypeReference(compliantTypeReference))) {
						return false;
					}
				}
			}
			if (expression.eContainer() instanceof XCastedExpression) {
				XCastedExpression castedExpression = (XCastedExpression) expression.eContainer();
				LightweightTypeReference castedExpressionType = getResolvedTypes(castedExpression).getActualType(castedExpression);
				if (castedExpressionType != null) {
					return actualType.getType() != castedExpressionType.getType();	
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean mustCheckForMandatoryTypeCast(IResolvedTypes resolvedTypes, XExpression expression) {
		if (resolvedTypes.isRefinedType(expression)) {
			return true;
		}
		LightweightTypeReference actualType = resolvedTypes.getActualType(expression);
		if (actualType != null && actualType.isMultiType()) {
			return true;
		}
		return false;
	}

	protected void internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable) {
		super.internalToJavaExpression(obj, appendable);
	}

	protected void doConversion(final LightweightTypeReference left, final LightweightTypeReference right,
			final ITreeAppendable appendable, XExpression context, final Later expression) {
		if(left.isPrimitive() && !right.isPrimitive()) {
			if (right.isAny()) {
				convertWrapperToPrimitive(left, left, context, appendable, expression);
			} else {
				convertWrapperToPrimitive(right, right.getPrimitiveIfWrapperType(), context, appendable, expression);
			}
		} else if (right.isPrimitive() && !left.isPrimitive()) {
			convertPrimitiveToWrapper(right, right.getWrapperTypeIfPrimitive(), appendable, expression);
		} else if (right.isMultiType()) {
			convertMultiType(left, (CompoundTypeReference) right, context, appendable, expression);
		} else if (right.isArray() && !left.isArray() && left.isSubtypeOf(Iterable.class)) {
			convertArrayToList(left, appendable, context, expression);
		} else if (isJavaConformant(left, right)) {
			if (mustInsertTypeCast(context, left)) {
				doCastConversion(left, appendable, expression);
			} else {
				expression.exec(appendable);
			}
		} else if (left.isArray() && !right.isArray() && right.isSubtypeOf(Iterable.class)) {
			convertListToArray(left, appendable, expression);
		} else if ((isFunction(left) && isFunction(right) || isProcedure(left) && isProcedure(right)) && left.getType() == right.getType()) {
			doCastConversion(left, appendable, expression);
		} else if (isFunction(right) || (isFunction(left) && findImplementingOperation(right) != null)) {
			convertFunctionType(left, right, appendable, expression);
		} else if (isProcedure(right) || (isProcedure(left) && findImplementingOperation(right) != null)) {
			convertFunctionType(left, right, appendable, expression);
		} else if (mustInsertTypeCast(context, left)) {
			doCastConversion(left, appendable, expression);
		} else {
			expression.exec(appendable);
		}
	}
	
	/* @Nullable */
	protected JvmOperation findImplementingOperation(LightweightTypeReference closureType) {
		return getTypeComputationServices().getFunctionTypes().findImplementingOperation(closureType);
	}
	
	private void doCastConversion(final LightweightTypeReference castTo, final ITreeAppendable b, final Later expression) {
		b.append("((");
		b.append(castTo);
		b.append(")");
		expression.exec(b);
		b.append(")");
	}
	
	private boolean isFunction(LightweightTypeReference typeReference) {
		return identifierStartWith(typeReference, Functions.class.getCanonicalName());
	}
	
	private boolean isProcedure(LightweightTypeReference typeReference) {
		return identifierStartWith(typeReference, Procedures.class.getCanonicalName());		
	}
	
	private boolean identifierStartWith(LightweightTypeReference typeReference, String prefix) {
		JvmType type = typeReference.getType();
		if (type == null)
			return false;
		String identifier = type.getIdentifier();
		if (identifier != null)
			return identifier.startsWith(prefix);
		return false;
	}

	private void convertMultiType(LightweightTypeReference expectation, CompoundTypeReference multiType, XExpression context,
			ITreeAppendable b, Later expression) {
		LightweightTypeReference castTo = null;
		List<LightweightTypeReference> components = multiType.getMultiTypeComponents();
		ITypeReferenceOwner owner = multiType.getOwner();
		LightweightTypeReference commonType = owner.getServices().getTypeConformanceComputer().getCommonSuperType(components, owner);
		if (!isJavaConformant(expectation, commonType)) {
			for(LightweightTypeReference candidate: multiType.getMultiTypeComponents()) {
				if (isJavaConformant(expectation, candidate)) {
					castTo = candidate;
					break;
				}
			}
		}
		if (castTo != null && mustInsertTypeCast(context, castTo)) {
			b.append("((");
			b.append(castTo);
			b.append(")");
			expression.exec(b);
			b.append(")");
		} else {
			expression.exec(b);
		}
	}

	private void convertFunctionType(LightweightTypeReference lightweightExpectedType, final LightweightTypeReference functionType,
			ITreeAppendable appendable, Later expression) {
		if (lightweightExpectedType.isSynonym()) {
			throw new IllegalStateException();
		}
		if (lightweightExpectedType.isType(Object.class)
				|| lightweightExpectedType.getUniqueIdentifier().equals(functionType.getUniqueIdentifier())) {
			// same raw type but different type parameters
			// at this point we know that we are compatible so we have to convince the Java compiler about that ;-)
			if (!isJavaConformant(lightweightExpectedType, functionType)) {
				// insert a cast
				appendable.append("(");
				appendable.append(lightweightExpectedType);
				appendable.append(")");
			}
			expression.exec(appendable);
			return;
		}
		JvmOperation operation = findImplementingOperation(lightweightExpectedType);
		if (operation == null) {
			throw new IllegalStateException("expected type " + lightweightExpectedType + " not mappable from " + functionType);
		}
		appendable.append("new ");
		FunctionTypeReference functionTypeReference = lightweightExpectedType.tryConvertToFunctionTypeReference(false);
		if (functionTypeReference == null)
			throw new IllegalStateException("Expected type does not seem to be a SAM type");
		appendable.append(functionTypeReference.toInstanceTypeReference());
		appendable.append("() {");
		appendable.increaseIndentation().increaseIndentation();
		appendable.newLine().append("public ");
		LightweightTypeReference returnType = functionTypeReference.getReturnType();
		if (returnType == null)
			throw new IllegalStateException("Could not find return type");
		appendable.append(returnType);
		appendable.append(" ").append(operation.getSimpleName()).append("(");
		List<JvmFormalParameter> params = operation.getParameters();
		for (int i = 0; i < params.size(); i++) {
			if (i != 0)
				appendable.append(", ");
			JvmFormalParameter p = params.get(i);
			final String name = p.getName();
			appendable.append(functionTypeReference.getParameterTypes().get(i));
			appendable.append(" ").append(name);
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		try {
			appendable.openScope();
			reassignThisInClosure(appendable, operation.getDeclaringType());
			if (!(operation.getReturnType().getType() instanceof JvmVoid))
				appendable.newLine().append("return ");
			else
				appendable.newLine();
			expression.exec(appendable);
			appendable.append(".");
			JvmOperation actualOperation = findImplementingOperation(functionType);
			appendable.append(actualOperation.getSimpleName());
			appendable.append("(");
			for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
				JvmFormalParameter p = iterator.next();
				final String name = p.getName();
				appendable.append(name);
				if (iterator.hasNext())
					appendable.append(", ");
			}
			// workaround until we have proper target typing with cast expressions
			// a lambda without explicit parameter list may be casted to something with fewer params
			// thus we have to add additional params here
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=445487#c4
			for(int i = params.size(); i < actualOperation.getParameters().size(); i++) {
				if (i != 0) {
					appendable.append(", ");
				}
				appendable.append("null");
			}
			appendable.append(");");
		} finally {
			appendable.closeScope();
		}
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
		appendable.decreaseIndentation().decreaseIndentation();
		appendable.newLine().append("}");
	}
	
	protected void reassignThisInClosure(final ITreeAppendable b, JvmType rawClosureType) {
		boolean registerClosureAsThis = rawClosureType instanceof JvmGenericType;
		if (b.hasObject("this")) {
			Object element = b.getObject("this");
			if (element instanceof JvmType) {
				// Don't reassign if the types are equal, since the 'this' of the enclosing type is shadowed
				if (element != rawClosureType)
					doReassignThisInClosure(b, (JvmType) element);
			} else {
				registerClosureAsThis = false;
			}
		}
		if (registerClosureAsThis) {
			b.declareVariable(rawClosureType, "this");
		}
	}

	protected void doReassignThisInClosure(final ITreeAppendable b, JvmType prevType) {
		final String proposedName = prevType.getSimpleName()+".this";
		if (!b.hasObject(proposedName)) {
			b.declareSyntheticVariable(prevType, proposedName);
			if (b.hasObject("super")) {
				Object superElement = b.getObject("super");
				if (superElement instanceof JvmType) {
					// Don't reassign the super of the enclosing type if it has already been reassigned
					String superVariable = b.getName(superElement);
					if ("super".equals(superVariable)) {
						b.declareSyntheticVariable(superElement, prevType.getSimpleName()+".super");
					}
				}
			}
		}
	}

	private void convertListToArray(
			final LightweightTypeReference arrayTypeReference, 
			final ITreeAppendable appendable,
			final Later expression) {
		appendable.append("((");
		appendable.append(arrayTypeReference);
		appendable.append(")");
		appendable.append(Conversions.class);
		appendable.append(".unwrapArray(");
		expression.exec(appendable);
		LightweightTypeReference rawTypeArrayReference = arrayTypeReference.getRawTypeReference();
		appendable.append(", ");
		appendable.append(rawTypeArrayReference.getComponentType());
		appendable.append(".class))");
	}

	private void convertArrayToList(final LightweightTypeReference left, final ITreeAppendable appendable, XExpression context,
			final Later expression) {
		if (!(context.eContainer() instanceof XCastedExpression)) {
			if (context.eContainer() instanceof XAbstractFeatureCall) {
				appendable.append("((");
			} else {
				appendable.append("(");
			}
			appendable.append(left);
			appendable.append(")");
		}
		appendable.append(Conversions.class);
		appendable.append(".doWrapArray(");
		expression.exec(appendable);
		if (!(context.eContainer() instanceof XCastedExpression)) {
			if (context.eContainer() instanceof XAbstractFeatureCall) {
				appendable.append("))");
			} else {
				appendable.append(")");
			}
		} else {
			appendable.append(")");
		}
	}

	/** Convert a primitive expression (number, char, boolean) to its wrapper equivalent.
	 *
	 * @param primitive unused in this context but useful for inheritors.
	 * @param wrapper the wrapper type to convert to.
	 * @param appendable the receiver of the convertion.
	 * @param expression the expression to convert.
	 */
	protected void convertPrimitiveToWrapper(
			final LightweightTypeReference primitive, 
			final LightweightTypeReference wrapper, 
			final ITreeAppendable appendable,
			final Later expression) {
		appendable.append(wrapper);
		appendable.append(".");
		appendable.append("valueOf(");
		expression.exec(appendable);
		appendable.append(")");
	}
	
	protected List<XExpression> normalizeBlockExpression(Collection<XExpression> expr) {
		List<XExpression> result  = Lists.newArrayListWithExpectedSize(expr.size());
		for(XExpression e:expr)
			result.add(normalizeBlockExpression(e));
		return result;
	}

	protected XExpression normalizeBlockExpression(XExpression expr) {
		if (expr instanceof XBlockExpression) {
			XBlockExpression block = ((XBlockExpression) expr);
			if (block.getExpressions().size() == 1)
				return normalizeBlockExpression(block.getExpressions().get(0));
		}
		return expr;
	}


	/** Convert a wrapper expression (number, char, boolean) to its primitive equivalent.
	 *
	 * @param wrapper unused in this context but useful for inheritors.
	 * @param primitive the primitive type to convert to.
	 * @param context the context of the convertion, i.e. the containing expression.
	 * @param appendable the receiver of the convertion.
	 * @param expression the expression to convert.
	 */
	protected void convertWrapperToPrimitive(
			final LightweightTypeReference wrapper, 
			final LightweightTypeReference primitive, 
			XExpression context, 
			final ITreeAppendable appendable,
			final Later expression) {
		XExpression normalized = normalizeBlockExpression(context);
		if (normalized instanceof XAbstractFeatureCall && !(context.eContainer() instanceof XAbstractFeatureCall)) {
			// Avoid javac bug
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=410797
			// TODO make that dependent on the compiler version (javac 1.7 fixed that bug)
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) normalized;
			if (featureCall.isStatic()) {
				JvmIdentifiableElement feature = featureCall.getFeature();
				if (feature instanceof JvmOperation) {
					if (!((JvmOperation) feature).getTypeParameters().isEmpty()) {
						appendable.append("(");
						appendable.append(primitive);
						appendable.append(") ");
						expression.exec(appendable);
						return;
					}
				}
			}
		}
		appendable.append("(");
		if (mustInsertTypeCast(context, wrapper)) {
			appendable.append("(");
			appendable.append(wrapper);
			appendable.append(") ");
		} 
		expression.exec(appendable);
		appendable.append(")");
		appendable.append(".");
		appendable.append(primitive);
		appendable.append("Value()");
	}
	
}
