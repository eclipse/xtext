/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.CompositeModificationWrapper;
import org.eclipse.xtext.ui.editor.model.edit.ICompositeModification;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IMultiModification;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.MultiModificationWrapper;
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
		IModification modificationWrapper = new SemanticModificationWrapper(issue.getUriToProblem(), semanticModification);
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
		IModification modificationWrapper = new SemanticModificationWrapper(issue.getUriToProblem(), semanticModification);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue),
				modificationWrapper, relevance));
	}

	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @see IMultiModification
	 * 
	 * @since 2.13
	 */
	public <T extends EObject> void acceptMulti(Issue issue, String label, String description, String image,
			IMultiModification<T> modification) {
		acceptMulti(issue, label, description, image, modification, 0);
	}
	
	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @see IMultiModification
	 * 
	 * @since 2.13
	 */
	public <T extends EObject> void acceptMulti(Issue issue, String label, String description, String image,
			IMultiModification<T> modification, int relevance) {
		IModification wrapper = new MultiModificationWrapper(issue, modification);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue), wrapper, relevance));
	}

	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @see ICompositeModification
	 * 
	 * @since 2.13
	 */
	public  <T extends EObject> void acceptMulti(Issue issue, String label, String description, String image, ICompositeModification<T> modification) {
		acceptMulti(issue, label, description, image, modification, 0);
	}

	/**
	 * Use as for a multi-quickfix methods.<br>
	 * This method will be called multiple times if more than one issue was selected to fix.
	 * 
	 * @see ICompositeModification
	 * 
	 * @since 2.13
	 */
	public <T extends EObject> void acceptMulti(Issue issue, String label, String description, String image, ICompositeModification<T> modification,
			int relevance) {
		IModification wrapper = new CompositeModificationWrapper(issue, modification);
		issueResolutions.add(new IssueResolution(label, description, image, modificationContextFactory.createModificationContext(issue), wrapper, relevance));
	}

	public List<IssueResolution> getIssueResolutions() {
		return issueResolutions;
	}

}
