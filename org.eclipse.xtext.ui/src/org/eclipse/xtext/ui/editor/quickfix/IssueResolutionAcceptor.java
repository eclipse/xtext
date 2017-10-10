/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.List;
import java.util.function.Consumer;

import org.eclipse.xtext.ui.editor.model.edit.IContextFreeModification;
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

	@Inject
	public IssueResolutionAcceptor(IssueModificationContext.Factory modificationContextFactory) {
		this.modificationContextFactory = modificationContextFactory;
	}

	public void accept(Issue issue, String label, String description, String image, IModification modification) {
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modification));
	}

	public void accept(Issue issue, String label, String description, String image, ISemanticModification semanticModification) {
		SemanticModificationWrapper modificationWrapper = new SemanticModificationWrapper(issue.getUriToProblem(), semanticModification);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modificationWrapper));
	}
	
	/**
	 * @since 2.4
	 */
	public void accept(Issue issue, String label, String description, String image, IModification modification, int relevance) {
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modification, relevance));
	}
	
	/**
	 * @since 2.4
	 */
	public void accept(Issue issue, String label, String description, String image, ISemanticModification semanticModification, int relevance) {
		SemanticModificationWrapper modificationWrapper = new SemanticModificationWrapper(issue.getUriToProblem(), semanticModification);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modificationWrapper, relevance));
	}

	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @since 2.13
	 */
	public void accept(Issue issue, String label, String description, String image, IContextFreeModification modification) {
		accept(issue, label, description, image, modification, 0);
	}

	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @since 2.13
	 */
	public void accept(Issue issue, String label, String description, String image, IContextFreeModification modification, int relevance) {
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				new IContextFreeModification.Wrapper(issue.getUriToProblem(), modification), relevance));
	}
	
	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @since 2.13
	 */
	public void accept(Issue issue, String label, String description, String image, Consumer<FixContext> initializer) {
		accept(issue, label, description, image, initializer, 0);
	}
	
	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @since 2.13
	 */
	public void accept(Issue issue, String label, String description, String image, Consumer<FixContext> initializer, int relevance) {
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				new IContextFreeModification.PreInitializedModification(issue.getUriToProblem(), initializer), relevance));
	}
	
	public List<IssueResolution> getIssueResolutions() {
		return issueResolutions;
	}

}
