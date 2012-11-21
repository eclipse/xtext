/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.ArrayListMultimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ElementIssueProvider implements IElementIssueProvider {

	public static class Factory {
		
		@Inject IJvmModelAssociations associations;
		
		public IElementIssueProvider create(Resource resource, List<Issue> issues) {
			return new ElementIssueProvider(resource, issues, associations);
		}
	}
	
	private ArrayListMultimap<EObject, Issue> issuesForElement = ArrayListMultimap.create();

	private ArrayListMultimap<EObject, Issue> issuesIncludingContents = ArrayListMultimap.create();

	protected ElementIssueProvider(Resource resource, List<Issue> issues, IJvmModelAssociations associations) {
		for (Issue issue : issues) {
			URI uriToProblem = issue.getUriToProblem();
			if (uriToProblem != null && uriToProblem.trimFragment().equals(resource.getURI())) {
				EObject erroneousElement = resource.getEObject(uriToProblem.fragment());
				setIssue(erroneousElement, issue);
				for(EObject jvmElement: associations.getJvmElements(erroneousElement)) {
					setIssue(jvmElement, issue);
				}
			}
		}
	}

	protected void setIssue(EObject erroneousElement, Issue issue) {
		if (erroneousElement != null) {
			issuesForElement.put(erroneousElement, issue);
			EObject currentContainer = erroneousElement;
			do {
				issuesIncludingContents.put(currentContainer, issue);
				currentContainer = currentContainer.eContainer();
			} while (currentContainer != null);
		}
	}

	public List<Issue> getIssues(EObject element, boolean includeContents) {
		return (includeContents) ? issuesIncludingContents.get(element) : issuesForElement.get(element);
	}
}
