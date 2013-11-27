/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContributionRegistry;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class QueuedBuildData {

	public static class CompositeContribution implements QueuedBuildDataContribution {

		private final List<? extends QueuedBuildDataContribution> components;

		public CompositeContribution(List<? extends QueuedBuildDataContribution> components) {
			this.components = components;
			
		}
		
		public void reset() {
			for (int i = 0; i < components.size(); i++) {
				components.get(i).reset();
			}
		}

		public boolean doQueueChange(Delta delta) {
			for(int i = 0; i < components.size(); i++) {
				QueuedBuildDataContribution contribution = components.get(i);
				if (contribution.doQueueChange(delta)) {
					return true;
				}
			}
			return false;
		}

		public boolean doNeedRebuild(IProject project, Collection<Delta> deltas) {
			for(int i = 0; i < components.size(); i++) {
				QueuedBuildDataContribution contribution = components.get(i);
				if (contribution.doNeedRebuild(project, deltas)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	public static class NullContribution implements QueuedBuildDataContribution {

		public void reset() {
			// nothing to do
		}

		public boolean doQueueChange(Delta delta) {
			// nothing to do
			return false;
		}

		public boolean doNeedRebuild(IProject project, Collection<Delta> deltas) {
			// nothing to do
			return false;
		}
		
	}
	
	private LinkedList<URI> uris;
	private Collection<IResourceDescription.Delta> deltas;
	private Map<String, LinkedList<URI>> projectNameToChangedResource;
	
	private final IStorage2UriMapper mapper;
	private QueuedBuildDataContribution contribution;

	@Inject
	public QueuedBuildData(IStorage2UriMapper mapper) {
		this.mapper = mapper;
	}
	
	@Inject
	private void initializeContributions(SharedStateContributionRegistry registry) {
		contribution = getQueuedBuildDataContribution(registry.getContributedInstances(QueuedBuildDataContribution.class));
		reset();
	}
	
	/**
	 * Public for testing purpose
	 * 
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public QueuedBuildData(IStorage2UriMapper mapper, QueuedBuildDataContribution contribution) {
		this.mapper = mapper;
		this.contribution = contribution;
		reset();
	}
	
	private QueuedBuildDataContribution getQueuedBuildDataContribution(ImmutableList<? extends QueuedBuildDataContribution> contributions) {
		switch(contributions.size()) {
			case 0: return new NullContribution();
			case 1: return contributions.get(0);
			default: return new CompositeContribution(contributions);
		}
	}
	
	public void reset() {
		uris = Lists.newLinkedList();
		deltas = Lists.newArrayList();
		projectNameToChangedResource = Maps.newHashMap();
		contribution.reset();
	}

	/**
	 * <p>
	 * Returns <code>true</code> if rebuild is required; otherwise <code>false</code>.
	 * </p>
	 * 
	 * @param project
	 *            - a project
	 * @return <code>true</code> if rebuild is required; otherwise <code>false</code>
	 */
	public synchronized boolean needRebuild(IProject project) {
		return contribution.doNeedRebuild(project, deltas);
	}
	
	public synchronized void queueChanges(@NonNull List<IResourceDescription.Delta> deltas) {
		for(int i=0, size=deltas.size(); i < size; i++) {
			queueChange(deltas.get(i));
		}
	}
	
	public synchronized void queueChange(@NonNull IResourceDescription.Delta delta) {
		if (!contribution.doQueueChange(delta)) {
			deltas.add(delta);
		}
	}

	public synchronized void queueURIs(Collection<URI> uris) {
		if (uris != null && !uris.isEmpty()) {
			for (URI uri : uris) {
				queueURI(uri);
			}
		}
	}

	public void queueURI(URI uri) {
		Iterable<Pair<IStorage, IProject>> iterable = mapper.getStorages(uri);
		boolean associatedWithProject = false;
		for (Pair<IStorage, IProject> pair : iterable) {
			IProject project = pair.getSecond();
			if (XtextProjectHelper.hasNature(project) && XtextProjectHelper.hasBuilder(project)) {
				String projectName = project.getName();
				LinkedList<URI> list = projectNameToChangedResource.get(projectName);
				if (list == null) {
					list = Lists.newLinkedList();
					projectNameToChangedResource.put(projectName, list);
				}
				list.add(uri);
				associatedWithProject = true;
			}
		}
		if (!associatedWithProject) {
			this.uris.add(uri);
		}
	}

	public Collection<IResourceDescription.Delta> getAndRemovePendingDeltas() {
		Collection<IResourceDescription.Delta> result = deltas;
		deltas = Lists.newArrayList();
		return result;
	}

	public boolean isEmpty(String projectName) {
		return deltas.isEmpty() && getQueue(projectName).isEmpty();
	}

	public Queue<URI> getQueue(String projectName) {
		final LinkedList<URI> list = projectNameToChangedResource.get(projectName);
		if (list == null)
			return uris;
		return new AbstractQueue<URI>() {

			public boolean offer(URI o) {
				return list.offer(o);
			}

			public URI poll() {
				if (uris.isEmpty())
					return list.poll();
				return uris.poll();
			}

			public URI peek() {
				if (uris.isEmpty())
					return list.peek();
				return uris.peek();
			}

			@Override
			public Iterator<URI> iterator() {
				return Iterators.concat(uris.iterator(), list.iterator());
			}

			@Override
			public int size() {
				return uris.size() + list.size();
			}
		};
	}

	public Iterable<URI> getAllRemainingURIs() {
		return Iterables.concat(uris, Iterables.concat(projectNameToChangedResource.values()));
	}

	protected IStorage2UriMapper getMapper() {
		return mapper;
	}

	protected Collection<IResourceDescription.Delta> getDeltas() {
		return deltas;
	}

	protected Map<String, LinkedList<URI>> getProjectNameToChangedResource() {
		return projectNameToChangedResource;
	}

	protected LinkedList<URI> getUris() {
		return uris;
	}
}
