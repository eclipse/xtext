/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmWildcardTypeReferenceImplCustom extends JvmWildcardTypeReferenceImpl {
	
	@Override
	public String getIdentifier() {
		return NameConcatHelper.computeFor(this, '$', NameConcatHelper.NameType.ID);
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return NameConcatHelper.computeFor(this, innerClassDelimiter, NameConcatHelper.NameType.QUALIFIED);
	}
	
	@Override
	public String getSimpleName() {
		return NameConcatHelper.computeFor(this, '$', NameConcatHelper.NameType.SIMPLE);
	}
	
	@Override
	public JvmType getType() {
		return null;
	}

}
