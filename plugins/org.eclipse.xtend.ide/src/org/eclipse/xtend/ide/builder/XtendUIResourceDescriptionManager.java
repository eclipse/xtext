/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionManager;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtendUIResourceDescriptionManager extends XtendResourceDescriptionManager {

	@Inject
	private IWorkspaceRoot workspaceRoot;
	
	@Override
	public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) {
		// skip collecting the outgoing references since we don't index references anyway
//		Set<URI> outgoingReferences = getDescriptionUtils().collectOutgoingReferences(candidate);
//		if (!outgoingReferences.isEmpty()) {
//			for (IResourceDescription.Delta delta : deltas)
//				if (hasChanges(delta, candidate) && outgoingReferences.contains(delta.getUri()))
//					return true;
//		}
		
		// this is a tradeoff - we could either check whether a given delta uri is contained
		// in a reachable container and check for intersecting names afterwards, or we can do
		// the other way round
		// unfortunately there is no way to decide reliably which algorithm scales better
		// note that this method is called for each description so we have something like a 
		// number of deltas x number of resources which is not really nice
		List<IContainer> containers = null;
		Collection<QualifiedName> importedNames = getImportedNames(candidate);
		Set<String> checkedProjects = Sets.newHashSet();
		for (IResourceDescription.Delta delta : deltas) {
			if (hasChanges(delta, candidate)) {
				// not a java resource - delta's resource should be contained in a visible container
				// as long as we did not delete the resource
				URI uri = delta.getUri();
				if ((uri.isPlatform() || uri.isArchive()) && delta.getNew() != null) {
					if (containers == null)
						containers = getContainerManager().getVisibleContainers(candidate, context);
					boolean descriptionIsContained = false;
					for (int i = 0; i < containers.size() && !descriptionIsContained; i++) {
						descriptionIsContained = containers.get(i).hasResourceDescription(uri);
					}
					if (!descriptionIsContained && !isProjectDependency(uri, candidate.getURI(), checkedProjects)) {
						return false;
					}
				}
				if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
					return true;
				}
			}
		}
		return false;
    }

	private boolean isProjectDependency(URI deltaURI, URI candidateURI, Set<String> checkedProjects) {
		if (deltaURI.isPlatformResource() && candidateURI.isPlatformResource()) {
			// replace escape sequence e.g. %20 by a proper char, e.g. ' ' (blank)
			String deltaProjectName = URI.decode(deltaURI.segment(1));
			// avoid checking the same project again
			if (checkedProjects.add(deltaProjectName)) {
				IProject deltaProject = workspaceRoot.getProject(deltaProjectName);
				// check if the delta is for a resource from an IJavaProject
				if (deltaProject.isAccessible() && JavaCore.create(deltaProject).exists()) {
					// same here, replace escape sequences by proper chars
					String candidateProjectName = URI.decode(candidateURI.segment(1));
					IProject candidateProject = workspaceRoot.getProject(candidateProjectName);
					if (candidateProject.isAccessible() && JavaCore.create(deltaProject).exists()) {
						try {
							if (Arrays.asList(candidateProject.getReferencedProjects()).contains(deltaProject)) {
								return true;
							}
						} catch (CoreException e) {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	
}
