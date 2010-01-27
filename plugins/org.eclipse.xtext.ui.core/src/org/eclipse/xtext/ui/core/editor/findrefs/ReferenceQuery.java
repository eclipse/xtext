/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.findrefs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceQuery implements ISearchQuery {

	@Inject
	private IResourceDescriptions resourceDescriptions;

	private ReferenceSearchResult searchResult;

	private URI eObjectTargetURI;

	private String label;

	public ReferenceQuery() {
	}

	public void init(URI eObjectTargetURI, String label) {
		this.eObjectTargetURI = eObjectTargetURI;
		this.label = label;
	}

	public boolean canRerun() {
		return true;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public String getLabel() {
		return label;
	}

	public ISearchResult getSearchResult() {
		if(searchResult == null) {
			searchResult = new ReferenceSearchResult(this);
		}
		return searchResult;
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		int numResources = Iterables.size(resourceDescriptions.getAllResourceDescriptions());
		monitor.beginTask("Find Xtext references", numResources);
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			Iterable<IReferenceDescription> matchingReferenceDescriptors = Iterables.filter(resourceDescription
					.getReferenceDescriptions(), new Predicate<IReferenceDescription>() {
				public boolean apply(IReferenceDescription input) {
					return eObjectTargetURI.equals(input.getTargetEObjectUri());
				}
			});
			for (IReferenceDescription matchingReferenceDescription : matchingReferenceDescriptors) {
				searchResult.addMatchingReference(matchingReferenceDescription);
			}
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.worked(1);
		}
		return Status.OK_STATUS;
	}

}
