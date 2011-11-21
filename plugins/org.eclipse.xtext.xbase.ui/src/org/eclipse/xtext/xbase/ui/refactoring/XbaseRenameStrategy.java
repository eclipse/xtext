/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseRenameStrategy extends DefaultRenameStrategy {
	@Override
	protected EAttribute getNameAttribute(EObject targetElement) {
		if (targetElement instanceof XSwitchExpression) {
			return XbasePackage.Literals.XSWITCH_EXPRESSION__LOCAL_VAR_NAME;
		}
		return super.getNameAttribute(targetElement);
	}

}
