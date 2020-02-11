/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import static org.eclipse.xtext.util.Strings.*;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendClassImplCustom extends XtendClassImpl {
	
	@Override
	public boolean isAbstract() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "abstract")) 
				return true;
			if(equal(modifier, "final")) 
				return false;
		}
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
