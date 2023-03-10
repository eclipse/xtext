/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Sorts reference descriptions by project and by resource to allow efficient processing later on.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceDescriptionSorter {

	@Inject
	private ProjectUtil projectUtil;

	public Multimap<IProject, IReferenceDescription> sortByProject(Iterable<IReferenceDescription> referenceDescriptions) {
		Multimap<IProject, IReferenceDescription> referencesByProject = HashMultimap.create();
		for (IReferenceDescription referenceDescription : referenceDescriptions) {
			URI sourceResourceUri = referenceDescription.getSourceEObjectUri().trimFragment();
			IProject project = projectUtil.getProject(sourceResourceUri);
			if(project != null) {
				referencesByProject.put(project, referenceDescription);
			}
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
