/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.List;

import org.eclipse.xtext.ui.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.SemanticModificationWrapper;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IssueResolutionAcceptor {

	private List<IssueResolution> issueResolutions = Lists.newArrayList();

	private IssueModificationContext.Factory modificationContextFactory;

	private IDocumentEditor documentEditor;
	
	@Inject
	public IssueResolutionAcceptor(IssueModificationContext.Factory modificationContextFactory, IDocumentEditor documentEditor) {
		this.modificationContextFactory = modificationContextFactory;
		this.documentEditor = documentEditor;
	}

	public void accept(Issue issue, String label, String description, String image, IModification modification) {
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modification));
	}

	public void accept(Issue issue, String label, String description, String image, ISemanticModification semanticModification) {
		SemanticModificationWrapper modificationWrapper = new SemanticModificationWrapper(issue.getUriToProblem(), semanticModification, documentEditor);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modificationWrapper));
	}

	public List<IssueResolution> getIssueResolutions() {
		return issueResolutions;
	}

}
