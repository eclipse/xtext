/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtend.core.xtend.XtendFile;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendInterfaceImplCustom extends XtendInterfaceImpl {

	@Override
	public boolean isStatic() {
		return !(eContainer() instanceof XtendFile);
	}

	@Override
	public boolean isFinal() {
		return false;
	}
	
	@Override
	public boolean isStrictFloatingPoint() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "strictfp")) 
				return true;
		}
		return false;
	}
	
}
