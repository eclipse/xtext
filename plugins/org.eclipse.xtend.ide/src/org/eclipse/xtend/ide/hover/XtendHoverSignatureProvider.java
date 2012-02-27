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
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.ui.hover.DefaultDeclarativeHoverSignatureProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendHoverSignatureProvider extends DefaultDeclarativeHoverSignatureProvider {

	@Inject
	protected IXtendJvmAssociations associations;

	protected String _signature(XtendClass clazz) {
		return _signature(associations.getInferredType(clazz));
	}

	protected String _imageTag(XtendClass clazz) {
		return _imageTag(associations.getInferredType(clazz));
	}

	protected String _signature(XtendFunction function) {
		return _signature(associations.getDirectlyInferredOperation(function));
	}

	protected String _imageTag(XtendFunction function) {
		return _imageTag(associations.getDirectlyInferredOperation(function));
	}

	protected String _signature(XtendField field) {
		return _signature(associations.getJvmField(field));
	}

	protected String _imageTag(XtendField field) {
		return _imageTag(associations.getJvmField(field));
	}

	protected String _signature(XtendParameter parameter) {
		return _signature(getFormalParameter(parameter));
	}

	protected String _imageTag(XtendParameter parameter) {
		return _imageTag(getFormalParameter(parameter));
	}

	protected String _signature(XtendConstructor constructor) {
		return _signature(associations.getInferredConstructor(constructor));
	}
	
	protected String _imageTag(XtendConstructor constructor) {
		return _imageTag(associations.getInferredConstructor(constructor));
	}
	
	private JvmFormalParameter getFormalParameter(XtendParameter parameter) {
		Set<EObject> jvmElements = associations.getJvmElements(parameter);
		if (jvmElements.size() > 0) {
			return (JvmFormalParameter) Lists.newArrayList(jvmElements).get(0);
		} else
			return null;
	}

}
