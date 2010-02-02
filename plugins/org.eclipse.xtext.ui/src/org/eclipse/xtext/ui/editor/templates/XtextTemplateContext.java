/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * Represents an extended version of class {@link DocumentTemplateContext} to provide additional Xtext related
 * information and services for resolving a <code>Template</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContext extends DocumentTemplateContext {

	private final ContentAssistContext contentAssistContext;
	
	private final IScopeProvider scopeProvider;

	public XtextTemplateContext(TemplateContextType type, IDocument document, Position position,
			ContentAssistContext contentAssistContext, IScopeProvider scopeProvider) {
		super(type, document, position);
		this.contentAssistContext = contentAssistContext;
		this.scopeProvider = scopeProvider;
	}

	/**
	 * @return the contentAssistContext
	 */
	public ContentAssistContext getContentAssistContext() {
		return contentAssistContext;
	}

	/**
	 * @return the linkingCandidatesService
	 */
	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}


}