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
		return _signature(associations.getInferredType(clazz), false);
	}

	protected String _signature(XtendFunction function, boolean typeAtEnd) {
		return _signature(associations.getDirectlyInferredOperation(function),false);
	}

	protected String _signature(XtendField field, boolean typeAtEnd) {
		return _signature(associations.getJvmField(field), false);
	}

	protected String _signature(XtendParameter parameter, boolean typeAtEnd) {
		return _signature(getFormalParameter(parameter), false);
	}

	protected String _signature(XtendConstructor constructor, boolean typeAtEnd) {
		return _signature(associations.getInferredConstructor(constructor), false);
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
