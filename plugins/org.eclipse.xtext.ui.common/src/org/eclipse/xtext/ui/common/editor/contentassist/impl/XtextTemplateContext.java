/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Represents an extended version of class {@link DocumentTemplateContext} to provide additional Xtext related 
 * information and services for resolving a <code>Template</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContext extends DocumentTemplateContext {

	private IContentAssistContext contentAssistContext;

	private IScopeProvider scopeProvider;

	private IMetamodelAccess metamodelAccess;

	public XtextTemplateContext(TemplateContextType type, IDocument document, Position position,
			IContentAssistContext contentAssistContext, IScopeProvider scopeProvider,
			IMetamodelAccess metamodelAccess) {
		super(type, document, position);
		this.contentAssistContext = contentAssistContext;
		this.scopeProvider = scopeProvider;
		this.metamodelAccess = metamodelAccess;
	}

	/**
	 * @return the contentAssistContext
	 */
	public IContentAssistContext getContentAssistContext() {
		return contentAssistContext;
	}

	/**
	 * @return the linkingCandidatesService
	 */
	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	/**
	 * @return the metamodelAccess
	 */
	public IMetamodelAccess getMetamodelAccess() {
		return metamodelAccess;
	}

}