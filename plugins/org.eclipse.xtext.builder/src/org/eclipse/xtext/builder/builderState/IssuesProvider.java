/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IssuesProvider {
	
	private final static Logger log = Logger.getLogger(IssuesProvider.class);
	
	@Inject
	private IStorage2UriMapper mapper;
	
	@Inject
	private IssueUtil issueUtil;
	
	public List<Issue> getPersistedIssues(URI uri) {
		List<Issue> result = Lists.newArrayList();
		Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(uri);
		for (Pair<IStorage, IProject> storageToProject : storages) {
			IStorage iStorage = storageToProject.getFirst();
			if (iStorage instanceof IFile) {
				try {
					IMarker[] markers;
					markers = ((IFile) iStorage).findMarkers(EValidator.MARKER, true, 1);
					for (IMarker iMarker : markers) {
						Issue issue = issueUtil.createIssue(iMarker);
						if(issue != null)
							result.add(issue);
					}
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}
	
}
