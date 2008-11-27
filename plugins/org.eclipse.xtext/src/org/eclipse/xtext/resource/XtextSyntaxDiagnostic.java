/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource.Diagnostic;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSyntaxDiagnostic implements Diagnostic {

	private final SyntaxError error;

	public XtextSyntaxDiagnostic(SyntaxError error) {
		this.error = error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.resource.XtextResource.Diagnostic#getLength()
	 */
	public int getLength() {
		return error.getNode().getLength();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.resource.XtextResource.Diagnostic#getOffset()
	 */
	public int getOffset() {
		return error.getNode().getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Diagnostic#getColumn()
	 */
	public int getColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Diagnostic#getLine()
	 */
	public int getLine() {
		return error.getNode().getLine();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Diagnostic#getLocation()
	 */
	public String getLocation() {
		if (error.eResource() != null)
			return error.eResource().getURI().toString();
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Diagnostic#getMessage()
	 */
	public String getMessage() {
		return error.getMessage();
	}

}
