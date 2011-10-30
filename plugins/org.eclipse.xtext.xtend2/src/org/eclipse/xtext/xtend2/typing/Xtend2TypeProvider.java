/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.resource.Xtend2Resource;
import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Type provider that is aware of Xtend specific expressions and the inferred JVM model.
 */
@Singleton
public class Xtend2TypeProvider extends XbaseWithAnnotationsTypeProvider {

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

//	@Inject
//	private XtendOverridesService overridesService;
//	
	@Inject
	private IEarlyExitComputer earlyExitComputer;
	
	@Inject
	private Primitives primitives;
	
	@Override
	protected JvmTypeReference typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		if (identifiable instanceof JvmGenericType) {
			return _typeForIdentifiable((JvmGenericType)identifiable, rawType);
		} else if (identifiable instanceof XtendClass) {
			return _typeForIdentifiable((XtendClass)identifiable, rawType);
		} else if (identifiable instanceof XtendClassSuperCallReferable) {
			return _typeForIdentifiable((XtendClassSuperCallReferable)identifiable, rawType);
		} else if (identifiable instanceof XtendParameter) {
			return _typeForIdentifiable((XtendParameter)identifiable, rawType);
		} else {
			return super.typeForIdentifiable(identifiable, rawType);
		}
	}
	
	@Override
	protected JvmTypeReference type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		if (expression instanceof RichString) {
			return _type((RichString)expression, rawExpectation, rawType);
		} else if (expression instanceof RichStringForLoop) {
			return _type((RichStringForLoop)expression, rawExpectation, rawType);
		} else if (expression instanceof RichStringIf) {
			return _type((RichStringIf)expression, rawExpectation, rawType);
		} else if (expression instanceof RichStringLiteral) {
			return _type((RichStringLiteral)expression, rawExpectation, rawType);
		} else {
			return super.type(expression, rawExpectation, rawType);
		}
	}
	
	@Override
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index,
			boolean rawType) {
		if (container instanceof CreateExtensionInfo) {
			return _expectedType((CreateExtensionInfo)container, reference, index, rawType);
		} else if (container instanceof RichStringElseIf) {
			return _expectedType((RichStringElseIf)container, reference, index, rawType);
		} else if (container instanceof RichStringForLoop) {
			return _expectedType((RichStringForLoop)container, reference, index, rawType);
		} else if (container instanceof RichStringIf) {
			return _expectedType((RichStringIf)container, reference, index, rawType);
		} else if (container instanceof XtendFunction) {
			return _expectedType((XtendFunction)container, reference, index, rawType);
		} else {
			return super.expectedType(container, reference, index, rawType);
		}
	}
	
	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			if (function.getCreateExtensionInfo()!=null)
				return getTypeReferences().getTypeForName(Void.TYPE, function);
			JvmTypeReference declaredOrInferredReturnType = ((Xtend2Resource)function.eResource()).getDeclaredOrOverriddenReturnType(function);
			if (declaredOrInferredReturnType == null) {
				declaredOrInferredReturnType = getCommonReturnType(function.getExpression(), false);
				if (declaredOrInferredReturnType != null && !earlyExitComputer.isEarlyExit(function.getExpression())) {
					if (!getTypeReferences().is(declaredOrInferredReturnType, Void.TYPE))
						declaredOrInferredReturnType = primitives.asWrapperTypeIfPrimitive(declaredOrInferredReturnType);
				}
			}
			if (declaredOrInferredReturnType == null || getTypeReferences().is(declaredOrInferredReturnType, Void.TYPE))
				return null;
			if (declaredOrInferredReturnType instanceof JvmAnyTypeReference) {
				declaredOrInferredReturnType = getTypeReferences().getTypeForName(Object.class, function);
			}
			return declaredOrInferredReturnType;
		}
		return null;
	}
	
	
	
	
	protected JvmTypeReference _expectedType(CreateExtensionInfo info, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.CREATE_EXTENSION_INFO__CREATE_EXPRESSION) {
			XtendFunction function = EcoreUtil2.getContainerOfType(info, XtendFunction.class);
			JvmTypeReference declaredOrInferredReturnType = ((Xtend2Resource)info.eResource()).getDeclaredOrOverriddenReturnType(function);
			if (declaredOrInferredReturnType == null || getTypeReferences().is(declaredOrInferredReturnType, Void.TYPE))
				return null;
			return declaredOrInferredReturnType;
		}
		return null;
	}
	
	@Override
	public JvmTypeReference getExpectedReturnType(XExpression expr, boolean rawType) {
		JvmTypeReference returnType = super.getExpectedReturnType(expr, rawType);
		if (returnType != null) {
			return returnType;
		}
		XClosure closure = EcoreUtil2.getContainerOfType(expr, XClosure.class);
		if (closure != null)
			return returnType;
		XtendFunction function = EcoreUtil2.getContainerOfType(expr, XtendFunction.class);
		if (function==null)
			return null;
		if (function.getReturnType() != null)
			return function.getReturnType();
		if (function.getCreateExtensionInfo()!=null) {
			if (EcoreUtil.isAncestor(function.getCreateExtensionInfo().getCreateExpression(), expr))
				return ((Xtend2Resource)expr.eResource()).getDeclaredOrOverriddenReturnType(function);
		}
		return getExpectedType(function.getExpression(), rawType);
	}
	
	protected JvmTypeReference _type(RichString richString, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(StringConcatenation.class, richString);
	}

	protected JvmTypeReference _type(RichStringLiteral stringLiteral, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, stringLiteral);
	}
	
	protected JvmTypeReference _type(RichStringIf richStringIf, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(StringConcatenation.class, richStringIf);
	}
	
	protected JvmTypeReference _type(RichStringForLoop richStringFor, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(StringConcatenation.class, richStringFor);
	}
	
	protected JvmTypeReference _expectedType(RichStringIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}
	
	protected JvmTypeReference _expectedType(RichStringElseIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}

	protected JvmTypeReference _expectedType(RichStringForLoop expr, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__BEFORE
				|| reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__SEPARATOR
				|| reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__AFTER)
			return getTypeReferences().getTypeForName(Object.class, expr);
		return _expectedType((XForLoopExpression)expr, reference, index, rawType);
	}

	protected JvmTypeReference _typeForIdentifiable(XtendParameter param, boolean rawType) {
		return param.getParameterType();
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz, boolean rawType) {
		JvmType type = xtend2jvmAssociations.getInferredType(clazz);
		if (type != null) {
			JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
			typeReference.setType(type);
			return typeReference;
		}
		return null;
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendClassSuperCallReferable referable, boolean rawType) {
		final XtendClass xtendClass = referable.getXtendClass();
		JvmTypeReference superType = xtendClass.getExtends();
		if (superType!=null) {
			return superType;
		}
		return getTypeReferences().getTypeForName(Object.class, xtendClass);
	}
	
	private final ThreadLocal<Map<JvmIdentifiableElement, Collection<JvmTypeReference>>> ongoingExceptionComputations = new ThreadLocal<Map<JvmIdentifiableElement, Collection<JvmTypeReference>>>() {
		@Override
		protected Map<JvmIdentifiableElement, Collection<JvmTypeReference>> initialValue() {
			return Maps.newHashMap();
		}
	};
	
	@Override
	public Iterable<JvmTypeReference> getThrownExceptionForIdentifiable(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmOperation) {
			final Set<EObject> associatedElements = xtend2jvmAssociations.getSourceElements(identifiable);
			if (associatedElements == null || associatedElements.isEmpty()) {
				return super.getThrownExceptionForIdentifiable(identifiable);
			}
			Map<JvmIdentifiableElement, Collection<JvmTypeReference>> computations = ongoingExceptionComputations.get();
			Collection<JvmTypeReference> intermediateResult = computations.get(identifiable);
			if (intermediateResult != null)
				return intermediateResult;
			try {
				intermediateResult = Sets.newLinkedHashSet();
				computations.put(identifiable, intermediateResult);
				for (EObject associatedElement : associatedElements) {
					final XtendFunction xtendFunction = (XtendFunction) associatedElement;
					final Iterable<JvmTypeReference> thrownExceptions = getThrownExceptions(xtendFunction);
					Iterables.addAll(intermediateResult, thrownExceptions);
				}
				return intermediateResult;
			} finally {
				computations.remove(identifiable);
			}
		}
		return super.getThrownExceptionForIdentifiable(identifiable);
	}

	protected Iterable<JvmTypeReference> getThrownExceptions(final XtendFunction xtendFunction) {
		Iterable<JvmTypeReference> thrownExceptionTypes = getThrownExceptionTypes(xtendFunction.getExpression());
		if (xtendFunction.getCreateExtensionInfo()==null) {
			return thrownExceptionTypes;
		}
		Iterable<JvmTypeReference> thrownExceptionTypesInCreateExpression = getThrownExceptionTypes(xtendFunction.getCreateExtensionInfo().getCreateExpression());
		return concat(thrownExceptionTypes,thrownExceptionTypesInCreateExpression);
	}
	
}
