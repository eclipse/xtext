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
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.ui.editor.model.edit.IssueUtil;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
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
		Iterable<IStorage> storages = mapper.getStorages(uri);
		for (IStorage iStorage : storages) {
			if (iStorage instanceof IFile) {
				try {
					IMarker[] markers;
					markers = ((IFile) iStorage).findMarkers(EValidator.MARKER, true, 1);
					for (IMarker iMarker : markers) {
						result.add(issueUtil.createIssue(iMarker));
					}
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}
	
	public static class Access {
		public static IssuesProvider get() {
			return Activator.getDefault().getInjector().getInstance(IssuesProvider.class);
		}
	}
}
