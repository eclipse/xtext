/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.annotations.typing.XbaseWithAnnotationsTypeProvider;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Type provider that is aware of Xtend specific expressions and the inferred JVM model.
 */
@Deprecated
@Singleton
public class XtendTypeProvider extends XbaseWithAnnotationsTypeProvider {

	@Inject
	private IXtendJvmAssociations xtendjvmAssociations;

	@Inject
	private IEarlyExitComputer earlyExitComputer;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private ReturnTypeProvider returnTypeProvider;
	
	@Override
	protected JvmTypeReference typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		if (identifiable instanceof JvmGenericType) {
			return _typeForIdentifiable((JvmGenericType)identifiable, rawType);
		} else if (identifiable instanceof XtendClass) {
			return _typeForIdentifiable((XtendClass)identifiable, rawType);
		} else if (identifiable instanceof XtendInterface) {
			return _typeForIdentifiable((XtendInterface)identifiable, rawType);
		} else if (identifiable instanceof XtendEnum) {
			return _typeForIdentifiable((XtendEnum)identifiable, rawType);
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
		} else if (container instanceof XtendConstructor) {
			return _expectedType((XtendConstructor)container, reference, index, rawType);
		} else {
			return super.expectedType(container, reference, index, rawType);
		}
	}
	
	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.XTEND_EXECUTABLE__EXPRESSION) {
			if (function.getCreateExtensionInfo()!=null)
				return getTypeReferences().getTypeForName(Void.TYPE, function);
			JvmTypeReference declaredOrInferredReturnType = returnTypeProvider.getDeclaredOrOverriddenReturnType(function);
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
	
	protected JvmTypeReference _expectedType(XtendConstructor constructor, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.XTEND_EXECUTABLE__EXPRESSION) {
			return getTypeReferences().getTypeForName(Void.TYPE, constructor);
		}
		return null;
	}
	
	protected JvmTypeReference _expectedType(CreateExtensionInfo info, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.CREATE_EXTENSION_INFO__CREATE_EXPRESSION) {
			XtendFunction function = EcoreUtil2.getContainerOfType(info, XtendFunction.class);
			JvmTypeReference declaredOrInferredReturnType = returnTypeProvider.getDeclaredOrOverriddenReturnType(function);
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
				return returnTypeProvider.getDeclaredOrOverriddenReturnType(function);
		}
		return getExpectedType(function.getExpression(), rawType);
	}
	
	protected JvmTypeReference _type(RichString richString, JvmTypeReference rawExpectation, boolean rawType) {
		JvmTypeReference stringType = getTypeReferences().getTypeForName(String.class, richString);
		if(getTypeReferences().is(getExpectedType(richString, rawType), String.class))
			return stringType;
		return getTypeReferences().getTypeForName(CharSequence.class, richString);
	}

	protected JvmTypeReference _type(RichStringLiteral stringLiteral, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(CharSequence.class, stringLiteral);
	}
	
	protected JvmTypeReference _type(RichStringIf richStringIf, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(CharSequence.class, richStringIf);
	}
	
	protected JvmTypeReference _type(RichStringForLoop richStringFor, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(CharSequence.class, richStringFor);
	}
	
	protected JvmTypeReference _expectedType(RichStringIf container, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.RICH_STRING_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(CharSequence.class, container);
	}
	
	protected JvmTypeReference _expectedType(RichStringElseIf container, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.RICH_STRING_ELSE_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(CharSequence.class, container);
	}

	protected JvmTypeReference _expectedType(RichStringForLoop expr, EReference reference, int index, boolean rawType) {
		if (reference == XtendPackage.Literals.RICH_STRING_FOR_LOOP__BEFORE
				|| reference == XtendPackage.Literals.RICH_STRING_FOR_LOOP__SEPARATOR
				|| reference == XtendPackage.Literals.RICH_STRING_FOR_LOOP__AFTER)
			return getTypeReferences().getTypeForName(Object.class, expr);
		return _expectedType((XForLoopExpression)expr, reference, index, rawType);
	}

	protected JvmTypeReference _typeForIdentifiable(XtendParameter param, boolean rawType) {
		return param.getParameterType();
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz, boolean rawType) {
		JvmType type = xtendjvmAssociations.getInferredType(clazz);
		if (type != null) {
			JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
			typeReference.setType(type);
			return typeReference;
		}
		return null;
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendInterface interfaze, boolean rawType) {
		JvmType type = xtendjvmAssociations.getInferredType(interfaze);
		if (type != null) {
			JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
			typeReference.setType(type);
			return typeReference;
		}
		return null;
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendEnum enam, boolean rawType) {
		JvmType type = xtendjvmAssociations.getInferredType(enam);
		if (type != null) {
			JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
			typeReference.setType(type);
			return typeReference;
		}
		return null;
	}
	
}
