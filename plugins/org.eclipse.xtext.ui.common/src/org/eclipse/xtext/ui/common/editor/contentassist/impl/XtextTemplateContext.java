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
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.ILinkingCandidatesService;

/**
 * Represents an extended version of class {@link DocumentTemplateContext} to provide additional Xtext related 
 * information and services for resolving a <code>Template</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContext extends DocumentTemplateContext {

	private IContentAssistContext contentAssistContext;

	private ILinkingCandidatesService linkingCandidatesService;

	private IMetamodelAccess metamodelAccess;

	public XtextTemplateContext(TemplateContextType type, IDocument document, Position position,
			IContentAssistContext contentAssistContext, ILinkingCandidatesService linkingCandidatesService,
			IMetamodelAccess metamodelAccess) {
		super(type, document, position);
		this.contentAssistContext = contentAssistContext;
		this.linkingCandidatesService = linkingCandidatesService;
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
	public ILinkingCandidatesService getLinkingCandidatesService() {
		return linkingCandidatesService;
	}

	/**
	 * @return the metamodelAccess
	 */
	public IMetamodelAccess getMetamodelAccess() {
		return metamodelAccess;
	}

}