/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.lang;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

public class CreateElementType extends IElementType {

	private final IElementType elementType;
	private final CreateCallback createCallback;

	public CreateElementType(IElementType elementType, CreateCallback createCallback) {
		super(CreateElementType.class.getName(), elementType.getLanguage(), false);
		this.elementType = elementType;
		this.createCallback = createCallback;
	}
	
	public IElementType getElementType() {
		return elementType;
	}
	
	public CreateCallback getCreateCallback() {
		return createCallback;
	}
	
	@Override
	public String toString() {
		return "CreateElementType [" + elementType.toString() + "]";
	}

	public interface CreateCallback {

		void onCreate(ASTNode composite);
		
	}

}
