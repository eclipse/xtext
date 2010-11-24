/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureDescription extends EObjectDescription {

	private TypeArgumentContext context;
	private String shadowingString;

	public JvmFeatureDescription(QualifiedName qualifiedName, JvmFeature element, TypeArgumentContext context, String shadowingString) {
		super(qualifiedName, element, Collections.<String,String>emptyMap(),false);
		this.context = context;
		this.shadowingString = shadowingString;
	}
	
	public JvmFeature getJvmFeature() {
		return (JvmFeature) getEObjectOrProxy();
	}

	public TypeArgumentContext getContext() {
		return context;
	}
	
	public String getKey() {
		return shadowingString;
	}
	
	@Override
	public String toString() {
		return shadowingString;
	}
	
}
