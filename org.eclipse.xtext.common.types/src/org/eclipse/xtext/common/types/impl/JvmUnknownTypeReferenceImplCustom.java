/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
		if (qualifiedName == null)
			return "[unknown]";
		return qualifiedName;
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmUnknownTypeReference JvmUnknownTypeReference} 
	 * is always "<code>[unknown]</code>".
	 */
	@Override
	public String getSimpleName() {
		if (qualifiedName == null)
			return "[unknown]";
		int idx = qualifiedName.lastIndexOf('.');
		int dollar = qualifiedName.lastIndexOf('$');
		int max = Math.max(idx, dollar);
		if (max != -1 && max < qualifiedName.length() - 1) {
			return qualifiedName.substring(max + 1);
		}
		return qualifiedName;
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmUnknownTypeReference JvmUnknownTypeReference} 
	 * is always "<code>[unknown]</code>".
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (qualifiedName == null)
			return "[unknown]";
		return qualifiedName;
	}
	
	@Override
	public String getQualifiedName() {
		if (qualifiedName == null)
			return "[unknown]";
		return qualifiedName;
	}
	
	@Override
	public String toString() {
		String result = eClass().getName();
		if (qualifiedName != null) {
			result = result + ": " + qualifiedName;
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
