/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.impl.NameConcatHelper.NameType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmParameterizedTypeReferenceImplCustom extends JvmParameterizedTypeReferenceImpl {

	@Override
	public String getIdentifier() {
		return NameConcatHelper.computeFor(this, NameType.ID);
	}
	
	@Override
	public String getSimpleName() {
		return NameConcatHelper.computeFor(this, NameType.SIMPLE);
	}
	
	@Override
	public String getQualifiedName() {
		return NameConcatHelper.computeFor(this, NameType.QUALIFIED);
	}

	

}
