/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ElementIssueProvider implements IElementIssueProvider {

	public static class Data extends AdapterImpl {
		private Multimap<EObject, Issue> issuesIncludingContents = ArrayListMultimap.create();

		public Multimap<EObject, Issue> getIssuesIncludingContents() {
			return issuesIncludingContents;
		}
		
		protected void addIssue(EObject erroneousElement, Issue issue) {
			if (erroneousElement != null) {
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
		
		@Inject IResourceValidator resourceValidator;
		
		@Inject IBatchTypeResolver typeResolver;
		
		public void attachData(Resource resource) {
			if (findDataAdapter(resource) != null) {
				return;
			}
			List<Issue> issues = collectIssues(resource);
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

		protected List<Issue> collectIssues(Resource resource) {
			List<Issue> issues = newArrayList(resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl));
			synthesizeIssuesForFollowUpErrors(resource, issues);
			return issues;
		}

		protected void synthesizeIssuesForFollowUpErrors(Resource resource, List<Issue> result) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty()) {
				IResolvedTypes resolvedTypes = typeResolver.resolveTypes(contents.get(0));
				for(ILinkingCandidate linkingCandidate: resolvedTypes.getFollowUpErrors()) {
					XExpression expression = linkingCandidate.getExpression();
					IssueImpl issue = new Issue.IssueImpl();
					issue.setUriToProblem(EcoreUtil.getURI(linkingCandidate.getExpression()));
					if (expression instanceof XAbstractFeatureCall)
						issue.setMessage(((XAbstractFeatureCall) expression).getConcreteSyntaxFeatureName() + " cannot be resolved");
					else {
						List<INode> nodes = NodeModelUtils.findNodesForFeature(expression, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
						if (nodes.size() >= 1) {
							issue.setMessage(nodes.get(0).getText() + " cannot be resolved");
						}
					}
					result.add(issue);
				}
			}
		}
		
		public void detachData(Resource resource) {
			resource.eAdapters().remove(findDataAdapter(resource));
		}

		@Override
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

	@Override
	public Iterable<Issue> getIssues(EObject element) {
		if(data == null)
			return emptyList();
		else
			return data.getIssuesIncludingContents().get(element);
	}
}
