/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ElementIssueProvider implements IElementIssueProvider {

	public static class Data extends AdapterImpl {
		private Multimap<EObject, Issue> issuesForElement = ArrayListMultimap.create();

		private Multimap<EObject, Issue> issuesIncludingContents = ArrayListMultimap.create();

		public Multimap<EObject, Issue> getIssuesForElement() {
			return issuesForElement;
		}
		
		public Multimap<EObject, Issue> getIssuesIncludingContents() {
			return issuesIncludingContents;
		}
		
		protected void addIssue(EObject erroneousElement, Issue issue) {
			if (erroneousElement != null) {
				issuesForElement.put(erroneousElement, issue);
				EObject currentContainer = erroneousElement;
				do {
					issuesIncludingContents.put(currentContainer, issue);
					currentContainer = currentContainer.eContainer();
				} while (currentContainer != null);
			}
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return Data.class == type;
		}
	}
	
	public static class Factory implements IElementIssueProvider.Factory {
		
		@Inject IJvmModelAssociations associations;
		
		public void attachData(Resource resource, List<Issue> issues) {
			Data adapter = new Data();
			for (Issue issue : issues) {
				URI uriToProblem = issue.getUriToProblem();
				if (uriToProblem != null && uriToProblem.trimFragment().equals(resource.getURI())) {
					EObject erroneousElement = resource.getEObject(uriToProblem.fragment());
					adapter.addIssue(erroneousElement, issue);
					for(EObject jvmElement: associations.getJvmElements(erroneousElement)) {
						adapter.addIssue(jvmElement, issue);
					}
				}
			}
			resource.eAdapters().add(adapter);
		}
		
		public void detachData(Resource resource) {
			resource.eAdapters().remove(findDataAdapter(resource));
		}

		public IElementIssueProvider get(Resource resource) {
			Data data = findDataAdapter(resource);
			return new ElementIssueProvider(data);
		}

		protected Data findDataAdapter(Resource resource) {
			return (Data) EcoreUtil.getAdapter(resource.eAdapters(), Data.class);
		}

	}

	private Data data;
	
	protected ElementIssueProvider(Data data) {
		this.data = data;
	}

	public Iterable<Issue> getIssues(EObject element, boolean includeContents) {
		if(data == null)
			return emptyList();
		else
			return (includeContents) 
				? data.getIssuesIncludingContents().get(element) 
				: data.getIssuesForElement().get(element);
	}
}
