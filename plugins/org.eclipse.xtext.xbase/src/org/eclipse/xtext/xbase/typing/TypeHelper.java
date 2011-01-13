/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static org.eclipse.xtext.xbase.XbasePackage.*;

import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeHelper {

	public boolean isLiteral(XExpression expr) {
		switch(expr.eClass().getClassifierID()) {
			case XCLOSURE:
			case XBOOLEAN_LITERAL:
			case XINT_LITERAL:
			case XNULL_LITERAL:
			case XSTRING_LITERAL:
			case XTYPE_LITERAL:
				return true;
			default: 
				return false;
		}
	}
}
