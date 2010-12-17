/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceDescriptionSorter {

	@Inject
	private IWorkspace workspace;
	
	public Multimap<IProject, IReferenceDescription> sortByProject(
			Iterable<IReferenceDescription> referenceDescriptions) {
		Multimap<IProject, IReferenceDescription> referencesByProject = HashMultimap.create();
		for (IReferenceDescription referenceDescription : referenceDescriptions) {
			URI sourceEObjectUri = referenceDescription.getSourceEObjectUri();
			String projectName = sourceEObjectUri.segment(1);
			IProject project = workspace.getRoot().getProject(projectName);
			referencesByProject.put(project, referenceDescription);
		}
		return referencesByProject;
	}

	public Multimap<URI, IReferenceDescription> sortByResource(Iterable<IReferenceDescription> referenceDescriptions) {
		Multimap<URI, IReferenceDescription> referencesByResourceURI = HashMultimap.create();
		for (IReferenceDescription referenceDescription : referenceDescriptions) {
			URI sourceResourceUri = referenceDescription.getSourceEObjectUri().trimFragment();
			referencesByResourceURI.put(sourceResourceUri, referenceDescription);
		}
		return referencesByResourceURI;
	}


}
