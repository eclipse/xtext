/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendClassSuperCallReferableImplCustom extends XtendClassSuperCallReferableImpl {

	@Override
	public String getSimpleName() {
		return "super";
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return "super";
	}
	
	@Override
	public String toString() {
		return eClass().getName();
	}
	
}
