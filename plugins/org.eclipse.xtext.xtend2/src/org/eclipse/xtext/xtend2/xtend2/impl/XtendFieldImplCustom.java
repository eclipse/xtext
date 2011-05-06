/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.xtext.xtend2.xtend2.XtendClass;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendFieldImplCustom extends XtendFieldImpl {

	@Override
	public String getIdentifier() {
		return getQualifiedName();
	}
	
	@Override
	public String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return eContainer != null ? ((XtendClass) eContainer()).getQualifiedName(innerClassDelimiter) + "." + getName()
				: getName();
	}
}
