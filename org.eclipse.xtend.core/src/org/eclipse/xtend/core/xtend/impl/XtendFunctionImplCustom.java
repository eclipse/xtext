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
public class XtendFunctionImplCustom extends XtendFunctionImpl {
	
	@Override
	public boolean isDispatch() {
		for (String modifier: getModifiers()) { 
			if (equal(modifier, "dispatch")) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isOverride() {
		for (String modifier: getModifiers()) { 
			if (equal(modifier, "override")) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isAbstract() {
		return getExpression() == null && !isNative();
	}
	
	@Override
	public boolean isStrictFloatingPoint() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "strictfp")) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isNative() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "native")) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isSynchonized() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "synchronized")) 
				return true;
		}
		return false;
	}
	
}
