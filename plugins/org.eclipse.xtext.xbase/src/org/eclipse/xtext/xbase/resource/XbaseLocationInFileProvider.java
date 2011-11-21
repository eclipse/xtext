/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseLocationInFileProvider extends DefaultLocationInFileProvider {
	
	@Override
	public ITextRegion getSignificantTextRegion(EObject element) {
		if(element instanceof XSwitchExpression && ((XSwitchExpression)element).getLocalVarName() != null) {
			 return getLocationOfAttribute(element, XbasePackage.Literals.XSWITCH_EXPRESSION__LOCAL_VAR_NAME, -1, true);
		}
		return super.getSignificantTextRegion(element);
	}

}
