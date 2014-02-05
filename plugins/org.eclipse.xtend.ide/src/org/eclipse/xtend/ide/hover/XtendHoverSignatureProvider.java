/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XtendHoverSignatureProvider extends XbaseDeclarativeHoverSignatureProvider {

	@Inject
	protected IXtendJvmAssociations associations;

	protected String _signature(XtendClass clazz, boolean typeAtEnd) {
		return clazz.getName() + hoverUiStrings.typeParameters(clazz.getTypeParameters());
	}

	protected String _signature(XtendFunction function, boolean typeAtEnd) {
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(function);
		String returnTypeString = "void";
		JvmTypeReference returnType = inferredOperation.getReturnType();
		if (returnType != null) {
			if (returnType instanceof JvmAnyTypeReference) {
				throw new IllegalStateException();
			} else {
				returnTypeString = returnType.getSimpleName();
			}
		}
		String signature = function.getName() + hoverUiStrings.parameters(inferredOperation)
				+ getThrowsDeclaration(inferredOperation);
		String typeParameter = uiStrings.typeParameters(function.getTypeParameters());
		if(typeParameter != null && typeParameter.length() > 0){
			return typeParameter + " " + returnTypeString + " " + signature;
		}
		return returnTypeString + " " + signature;
	}

	protected String _signature(XtendField field, boolean typeAtEnd) {
		if (field.getName() == null && field.isExtension())
			return field.getType().getSimpleName();
		JvmField jvmField = associations.getJvmField(field);
		if (jvmField != null) {
			JvmTypeReference type = jvmField.getType();
			if (type != null) {
				if (field.getName() == null)
					return type.getSimpleName();
				return type.getSimpleName() + " " + field.getName();
			}
		}
		if (field.getName() == null)
			return "";
		return field.getName();
	}

	protected String _signature(XtendParameter parameter, boolean typeAtEnd) {
		EObject container = parameter.eContainer();
		JvmTypeReference type = parameter.getParameterType();
		if (type != null) {
			String signature = parameter.getName();
			String signatureOfFather = getSimpleSignature(container);
			if(signatureOfFather != null){
				signature += JavaElementLabels.CONCAT_STRING + signatureOfFather;
			}
			if (typeAtEnd)
				return signature + " : " + type.getSimpleName();
			return type.getSimpleName() + " " + signature;
		}
		return parameter.getName();
	}

	protected String _signature(XtendConstructor constructor, boolean typeAtEnd) {
		JvmConstructor inferredConstructor = associations.getInferredConstructor(constructor);
		XtendClass xtendClazz = EcoreUtil2.getContainerOfType(constructor, XtendClass.class);
		return xtendClazz.getName() + hoverUiStrings.parameters(inferredConstructor)
				+ getThrowsDeclaration(inferredConstructor);
	}

	protected String _signature(XtendInterface interfaze , boolean typeAtEnd){
		return interfaze.getName();
	}

	protected String _signature(XtendEnum enu , boolean typeAtEnd){
		return enu.getName();
	}

	protected String _signature(XtendAnnotationType anno , boolean typeAtEnd){
		return anno.getName();
	}

	@Override
	protected String getSimpleSignature(EObject container) {
		if(container instanceof XtendFunction){
			XtendFunction function = (XtendFunction) container;
			JvmOperation inferredOperation = associations.getDirectlyInferredOperation(function);
			return function.getName() + uiStrings.parameters(inferredOperation);
		}
		else if (container instanceof XtendConstructor){
			XtendConstructor constructor = (XtendConstructor) container;
			XtendClass xtendClazz = EcoreUtil2.getContainerOfType(constructor, XtendClass.class);
			JvmConstructor inferredConstructor = associations.getInferredConstructor(constructor);
			return xtendClazz.getName() + " " + uiStrings.parameters(inferredConstructor);
		}
		return super.getSimpleSignature(container);
	}
	
	@Override
	public String getImageTag(EObject object) {
		if(object instanceof XtendParameter)
			return super.getImageTag(getFormalParameter(object));
		return super.getImageTag(object);
	}
	
	private JvmFormalParameter getFormalParameter(EObject parameter) {
		Set<EObject> jvmElements = associations.getJvmElements(parameter);
		if (jvmElements.size() > 0) {
			return (JvmFormalParameter) Lists.newArrayList(jvmElements).get(0);
		} else
			return null;
	}

}
