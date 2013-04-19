/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsage {
	private String text;
	
	private ITextRegion textRegion;
	
	private JvmMember context;

	private boolean staticAccess;

	private boolean noDelimiter;

	public TypeUsage(String text, ITextRegion textRegion, JvmMember context, boolean staticAccess, boolean noDelimiter) {
		this.text = text;
		this.textRegion = textRegion;
		this.context = context;
		this.staticAccess = staticAccess;
		this.noDelimiter = noDelimiter;
	}
	
	public boolean isStaticAccess() {
		return staticAccess;
	}
	
	public boolean isTrailingDelimiterSuppressed() {
		return noDelimiter;
	}
	
	public String getText() {
		return text;
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