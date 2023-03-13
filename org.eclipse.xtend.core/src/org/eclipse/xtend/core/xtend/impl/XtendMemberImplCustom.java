/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendMemberImplCustom extends XtendMemberImpl {

	@Override
	public EList<XAnnotation> getAnnotations() {
		if (getAnnotationInfo()!=null) {
			return getAnnotationInfo().getAnnotations();
		}
		return super.getAnnotations();
	}
	
	@Override
	public boolean isFinal() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "abstract")) 
				return false;
			if(equal(modifier, "final")) 
				return true;
		}
		return false;
	}

	@Override
	public boolean isStatic() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "static")) 
				return true;
		}
		return false;
	}
	
	protected JvmVisibility getDefaultVisibility() {
		return JvmVisibility.PUBLIC;
	}
	
	@Override
	public JvmVisibility getDeclaredVisibility() {
		for(String modifier: getModifiers()) {
			if(equal(modifier, "public")) 
				return JvmVisibility.PUBLIC;
			if(equal(modifier, "package")) 
				return JvmVisibility.DEFAULT;
			if(equal(modifier, "protected")) 
				return JvmVisibility.PROTECTED;
			if(equal(modifier, "private")) 
				return JvmVisibility.PRIVATE;
		}
		return null;
	}
	
	@Override
	public JvmVisibility getVisibility() {
		JvmVisibility declaredVisibility = getDeclaredVisibility();
		return declaredVisibility == null ? getDefaultVisibility() : declaredVisibility;
	}
}
