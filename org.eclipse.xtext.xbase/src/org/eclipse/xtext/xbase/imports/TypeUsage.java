/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsage {
	private JvmDeclaredType usedType;
	private String usedTypeName;
	private String suffix;
	private ITextRegion textRegion;
	private JvmMember context;

	public TypeUsage(JvmDeclaredType usedType, String suffix, ITextRegion textRegion, JvmMember context) {
		this.usedType = usedType;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = suffix;
	}
	
	public TypeUsage(JvmDeclaredType usedType, ITextRegion textRegion, JvmMember context) {
		this.usedType = usedType;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = "";
	}
	
	public TypeUsage(String usedTypeName, String suffix, ITextRegion textRegion, JvmMember context) {
		this.usedTypeName = usedTypeName;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = suffix;
	}
	
	public JvmDeclaredType getUsedType() {
		return usedType;
	}
	
	public String getUsedTypeName() {
		return usedTypeName;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public ITextRegion getTextRegion() {
		return textRegion;
	}
	
	public JvmMember getContext() {
		return context;
	}

	public String getContextPackageName() {
		return getPackageName(context);
	}
	
	protected String getPackageName(JvmMember context) {
		if(context.getDeclaringType() != null)
			return getPackageName(context.getDeclaringType());
		if(context instanceof JvmDeclaredType) 
			return ((JvmDeclaredType)context).getPackageName();
		else  
			return null;
	}


}