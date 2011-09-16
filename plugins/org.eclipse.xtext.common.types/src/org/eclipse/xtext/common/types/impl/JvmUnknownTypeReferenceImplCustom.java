/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmUnknownTypeReferenceImplCustom extends JvmUnknownTypeReferenceImpl {

	/**
	 * {@inheritDoc}
	 * 
	 * Returns always <code>null</code>.
	 */
	@Override
	public JvmType getType() {
		return null;
	}
	
	/**
	 * The identifier of a {@link org.eclipse.xtext.common.types.JvmUnknownTypeReference JvmUnknownTypeReference} 
	 * is always "<code>[unknown]</code>".
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		return "[unknown]";
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmUnknownTypeReference JvmUnknownTypeReference} 
	 * is always "<code>[unknown]</code>".
	 */
	@Override
	public String getSimpleName() {
		return "[unknown]";
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmUnknownTypeReference JvmUnknownTypeReference} 
	 * is always "<code>[unknown]</code>".
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return "[unknown]";
	}
	
	@Override
	public String toString() {
		String result = eClass().getName();
		if (exception != null) {
			result = ": " + exception.getMessage() + " (" + exception.getClass() + ")";
		}
		return result;
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitUnknownTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitUnknownTypeReference(this, parameter);
		return result;
	}
	
}
