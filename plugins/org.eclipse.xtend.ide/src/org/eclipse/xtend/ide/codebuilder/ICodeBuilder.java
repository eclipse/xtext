/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

/**
 * Common interface to generate Java or Xtend code into an {@link IAppendable}.
 * Use {@link CodeBuilderFactory} to obtain an instance.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ICodeBuilder {

	ISourceAppender build(ISourceAppender appendable);

	String getPreview();
	
	String getImage();
	
	Object getOwnerSource();
	
	JvmDeclaredType getOwner();
	
	JvmVisibility getVisibility();
	
	boolean isValid();
	
	interface Xtend extends ICodeBuilder {
		XtendTypeDeclaration getXtendType();
		
		int getInsertOffset();
		
		int getIndentationLevel();
	}
	
	interface Java extends ICodeBuilder {
		IType getIType();
	}

}
