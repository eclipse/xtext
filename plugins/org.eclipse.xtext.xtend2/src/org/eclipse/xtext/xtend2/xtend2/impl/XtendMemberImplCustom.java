/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendMemberImplCustom extends XtendMemberImpl {

	@Override
	public String getIdentifier() {
		return computeIdentifier();
	}
	
	protected String computeIdentifier() {
		String typeName = getDeclaringType().getIdentifier();
		if (typeName!=null)
			return typeName+"."+getSimpleName();
		return getSimpleName();
	}
}
