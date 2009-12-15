/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextAnnotation extends Annotation {

	private final IXtextDocument document;
	private final Issue issue;

	public Integer getIssueCode() {
		return issue.getCode();
	}
	
	public IXtextDocument getDocument() {
		return document;
	}
	
	public URI getUriToProblem() {
		return issue.getUriToProblem();
	}
	
	public Issue getIssue() {
		return issue;
	}
	
	public XtextAnnotation(String type, boolean isPersistent, IXtextDocument document, Issue issue) {
		super(type, isPersistent, issue.getMessage());
		this.document = document;
		this.issue = issue;
	}
	
}
