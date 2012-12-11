/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsage {
	private String text;
	
	private ITextRegion textRegion;
	
	private JvmMember context;
	
	public TypeUsage(String text, ITextRegion textRegion, JvmMember context) {
		this.text = text;
		this.textRegion = textRegion;
		this.context = context;
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
}