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
	
	
	protected String _hoverSignature(XtendClass clazz) {
		return _hoverSignature(associations.getInferredType(clazz));
	}
	
	protected String _hoverSignature(XtendFunction function) {
		return _hoverSignature(associations.getDirectlyInferredOperation(function));
	}
		
	protected String _hoverSignature(XtendField field){
		return _hoverSignature(associations.getJvmField(field));
	}
	
	protected String _hoverSignature(XtendParameter parameter){
		Set<EObject> jvmElements = associations.getJvmElements(parameter);
		if(jvmElements.size() > 0){
			return _hoverSignature((JvmFormalParameter)Lists.newArrayList(jvmElements).get(0));
		}
		return null;
	}
	protected String _hoverSignature(XtendConstructor constructor){
		return _hoverSignature(associations.getInferredConstructor(constructor));
	}
	
}
