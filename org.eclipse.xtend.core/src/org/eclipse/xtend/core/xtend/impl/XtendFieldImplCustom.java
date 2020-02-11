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

import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendFieldImplCustom extends XtendFieldImpl {

	@Override
	public boolean isExtension() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "extension")) 
				return true;
		}
		return false;
	}

	@Override
	protected JvmVisibility getDefaultVisibility() {
		if(getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType)
			return JvmVisibility.PUBLIC;
		else 
			return JvmVisibility.PRIVATE;
	}
	
	@Override
	public boolean isFinal() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "var")) 
				return false;
			if(equal(modifier, "val") || equal(modifier, "final")) 
				return true;
		}
		return getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType;
	}
	
	@Override
	public boolean isStatic() {
		return super.isStatic() ? true 
				: getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType;
	}
	
	@Override
	public boolean isVolatile() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "volatile")) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isTransient() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "transient")) 
				return true;
		}
		return false;
	}
}
