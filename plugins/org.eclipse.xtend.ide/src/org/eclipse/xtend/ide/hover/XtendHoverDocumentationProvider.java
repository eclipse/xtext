/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.typing.XtendOverridesService;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendHoverDocumentationProvider extends XbaseHoverDocumentationProvider {
	
	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private XtendOverridesService overridesService;
	
	@Override
	protected String handleSuperMethodReferences(EObject context) {
		StringBuffer buffer = new StringBuffer();
		if (context instanceof XtendFunction) {
			XtendFunction function = (XtendFunction) context;
			if (function.isOverride()) {
				JvmOperation overwritten = overridesService.findOverriddenOperation(function);
				buffer.append("<div>"); //$NON-NLS-1$
				buffer.append("<b>"); //$NON-NLS-1$
				buffer.append("Overrides:"); //$NON-NLS-1$
				buffer.append("</b> "); //$NON-NLS-1$
				buffer.append(createMethodInTypeLinks(overwritten));
				buffer.append("</div>"); //$NON-NLS-1$
			}
		}
		return buffer.toString();
	}
}
