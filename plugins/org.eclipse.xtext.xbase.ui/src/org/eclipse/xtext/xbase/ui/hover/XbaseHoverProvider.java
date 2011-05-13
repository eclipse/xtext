/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseHoverProvider extends DefaultEObjectHoverProvider {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Override
	protected String getFirstLine(EObject o) {
		if (o instanceof JvmIdentifiableElement) {
			JvmTypeReference type = typeProvider.getTypeForIdentifiable((JvmIdentifiableElement) o);
			return getFirstLine(type, o);
		}
		return super.getFirstLine(o);
	}

	protected String getFirstLine(JvmTypeReference type, EObject o) {
		String typeString = "";
		if (type != null) {
			if (type instanceof JvmAnyTypeReference) {
				typeString = "null ";
			} else {
				typeString = type.getSimpleName() + " ";
			}
		}
		String label = getFirstLineLabel(o);
		String plain = typeString + (label != null ? label : "");
		return "<b>" + toHtml(plain) + "</b>";
	}

	protected String getFirstLineLabel(EObject o) {
		// TODO: should this be part of the XCasePart#getSimpleName?
		if (o instanceof XCasePart && o.eContainer() instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) o.eContainer();
			if (switchExpression != null) {
				if (switchExpression.getLocalVarName() != null)
					return switchExpression.getLocalVarName();
				if (switchExpression.getSwitch() instanceof XFeatureCall) {
					XFeatureCall call = (XFeatureCall) switchExpression.getSwitch();
					if (call.getFeature() != null)
						return call.getFeature().getSimpleName();
				}
			}
		}
		String label = getLabel(o);
		return label;
	}
	
	protected String toHtml(String plain) {
		String result = plain.replace("<", "&lt;").replace(">", "&gt;");
		return result;
	}

	@Override
	protected boolean hasHover(EObject o) {
		return o instanceof JvmIdentifiableElement || super.hasHover(o);
	}
	
	protected ITypeProvider getTypeProvider() {
		return typeProvider;
	}
}
