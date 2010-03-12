/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.query;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.ui.search.ElementQuerySpecification;
import org.eclipse.jdt.ui.search.IMatchPresentation;
import org.eclipse.jdt.ui.search.IQueryParticipant;
import org.eclipse.jdt.ui.search.ISearchRequestor;
import org.eclipse.jdt.ui.search.QuerySpecification;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;
import org.eclipse.xtext.ui.shared.Access;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class QueryParticipant implements IQueryParticipant {

	private final IResourceDescriptions resourceDescriptions;
	
	private final TypeURIHelper typeURIHelper;
	
	private final UIParticipant uiParticipant;
	
	public QueryParticipant() {
		resourceDescriptions = Access.getIResourceDescriptions().get();
		typeURIHelper = new TypeURIHelper();
		uiParticipant = new UIParticipant(resourceDescriptions);
	}
	
	public void search(ISearchRequestor requestor, QuerySpecification query, IProgressMonitor monitor)
			throws CoreException {
		if (!isHandled(query)) {
			return;
		}
		if(monitor == null) {
			monitor = new NullProgressMonitor();
		}
		try {
			if (query instanceof ElementQuerySpecification) {
				ElementQuerySpecification elementQuery = (ElementQuerySpecification) query;
				IJavaElement element = elementQuery.getElement();
				if(element instanceof IType) {
					IType type = (IType) element;
					String signature = Signature.createTypeSignature(type.getFullyQualifiedName(), type.isResolved());
					final URI uri = typeURIHelper.getFullURI(signature, type);
					int numResources = Iterables.size(resourceDescriptions.getAllResourceDescriptions());
					SubMonitor subMonitor = SubMonitor.convert(monitor, numResources);
					subMonitor.subTask("Find references in EMF resources");
					for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
						Iterable<IReferenceDescription> matchingReferenceDescriptors = Iterables.filter(resourceDescription
								.getReferenceDescriptions(), new Predicate<IReferenceDescription>() {
							public boolean apply(IReferenceDescription input) {
								return uri.equals(input.getTargetEObjectUri());
							}
						});
						for (IReferenceDescription matchingReferenceDescription : matchingReferenceDescriptors) {
							requestor.reportMatch(new Match(matchingReferenceDescription, 0, 0));
						}
						if (subMonitor.isCanceled()) {
							return;
						}
						subMonitor.worked(1);
					}
					if(subMonitor.isCanceled()) {
						return;
					}
					subMonitor.worked(1);
				} else {
					return;
				}
			}
		} finally {
			monitor.done();
		}
	}

	public int estimateTicks(QuerySpecification query) {
		if (isHandled(query)) {
			return 250;
		}
		return 0;
	}

	public IMatchPresentation getUIParticipant() {
		return uiParticipant;
	}

	private boolean isHandled(QuerySpecification query) {
		switch(query.getLimitTo()) {
			case IJavaSearchConstants.REFERENCES:
			case IJavaSearchConstants.ALL_OCCURRENCES: {
				break;
			}
			default: {
				return false;
			}
		}
		if (query instanceof ElementQuerySpecification) {
			IJavaElement element = ((ElementQuerySpecification) query).getElement();
			return element.getElementType() == IJavaElement.TYPE;
		}
//		if (query instanceof PatternQuerySpecification) {
//			PatternQuerySpecification patternQuery = (PatternQuerySpecification) query;
//			switch (patternQuery.getSearchFor()) {
//				case IJavaSearchConstants.UNKNOWN:
//				case IJavaSearchConstants.TYPE:
//				case IJavaSearchConstants.CLASS:
//				case IJavaSearchConstants.CLASS_AND_INTERFACE:
//				case IJavaSearchConstants.CLASS_AND_ENUM: {
//					return true;
//				}
//			}
//		}
		return false;
	}
	
	protected static class UIParticipant implements IMatchPresentation {

		private final GlobalDescriptionLabelProvider globalDescriptionsLabelProvider;
		
		private final IURIEditorOpener uriEditorOpener;
		
		private final IResourceDescriptions resourceDescriptions;
		
		public UIParticipant(IResourceDescriptions resourceDescriptions) {
			this.resourceDescriptions = resourceDescriptions;
			uriEditorOpener = Access.getIURIEditorOpener().get();
			this.globalDescriptionsLabelProvider = Access.provider(GlobalDescriptionLabelProvider.class).get();
		}
		
		public ILabelProvider createLabelProvider() {
			return new ILabelProvider() {
				public void removeListener(ILabelProviderListener listener) {
				}
				
				public boolean isLabelProperty(Object element, String property) {
					return false;
				}
				
				public void dispose() {
				}
				
				public void addListener(ILabelProviderListener listener) {
				}
				
				public String getText(Object element) {
					IReferenceDescription referenceDescription = (IReferenceDescription) element;
					URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
					final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
							: containerEObjectURI;
					IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI.trimFragment());
					if (resourceDescription != null) {
						for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
							if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
								return globalDescriptionsLabelProvider.getText(eObjectDescription);
							}
						}
					}
					return "unknown";
				}
				
				public Image getImage(Object element) {
					IReferenceDescription referenceDescription = (IReferenceDescription) element;
					URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
					final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
							: containerEObjectURI;
					IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI.trimFragment());
					if (resourceDescription != null) {
						for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
							if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
								return globalDescriptionsLabelProvider.getImage(eObjectDescription);
							}
						}
					}
					return null;
				}
			};
		}

		public void showMatch(Match match, int currentOffset, int currentLength, boolean activate) {
			Object o = match.getElement();
			if (o instanceof IReferenceDescription) {
				IReferenceDescription descr = (IReferenceDescription) o;
				if (activate) {
					uriEditorOpener.open(descr.getSourceEObjectUri(), descr.getEReference(), descr.getIndexInList(), true);
				}
			}
		}
	}
}
