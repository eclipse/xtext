/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.lang.reflect.Field;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.builder.StringSet;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class QueuedBuildData {
	
	private static final Logger LOG = Logger.getLogger(QueuedBuildData.class);
	
	private class JavaBuilderState {
		
		long lastStructuralBuildTime = -1;
		
		int buildNumber = -1;
		
		Set<QualifiedName> structurallyChangedTypes = Sets.newHashSet();

		@Override
		public String toString() {
			return "[buildNo=" + buildNumber + ";lastStructuralBuildTime=" + lastStructuralBuildTime
					+ ";structurallyChangedTypes=" + structurallyChangedTypes + "]";
		}
		
	}
	
	private Collection<IResourceDescription.Delta> deltas;
	private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas;
	private LinkedList<URI> uris;
	private Map<String, LinkedList<URI>> projectNameToChangedResource;
	
	private Map<String, JavaBuilderState> javaBuildState;

	@Inject
	private IStorage2UriMapper mapper;

	public QueuedBuildData() {
		reset();
	}
	
	public void reset() {
		uris = Lists.newLinkedList();
		deltas = Lists.newArrayList();
		unconfirmedDeltas = Lists.newArrayList();
		javaBuildState = Maps.newHashMap();
		projectNameToChangedResource = Maps.newHashMap();
	}
	
	public Collection<UnconfirmedStructuralChangesDelta> getUnconfirmedDeltas() {
		return Collections.unmodifiableCollection(unconfirmedDeltas);
	}

	protected Object readField(Object obj, String field, Object defaultValue) {
		try {
			Field f = obj.getClass().getDeclaredField(field);
			f.setAccessible(true);
			Object object = f.get(obj);
			if (object != null)
				return object;
			return defaultValue;
		} catch (Exception e) {
			if (LOG.isEnabledFor(Level.ERROR)) {
				LOG.error(e);
			}
			return defaultValue;
		}
	}

	protected boolean namesIntersect(IResourceDescription desc, Set<QualifiedName> names) {
		if (desc != null)
			for (IEObjectDescription name : desc.getExportedObjects())
				if (names.contains(name.getQualifiedName()))
					return true;
		return false;
	}

	protected JavaBuilderState readJavaBuilderState(IProject project) {
		JavaBuilderState state = new JavaBuilderState();
		Object jdtState = JavaModelManager.getJavaModelManager().getLastBuiltState(project, null);
		if (jdtState != null) {
			StringSet types = (StringSet) readField(jdtState, "structurallyChangedTypes", null);
			if (types != null)
				for (String name : types.values)
					if (name != null)
						state.structurallyChangedTypes.add(QualifiedName.create(name.split("/")));
			state.lastStructuralBuildTime = (Long) readField(jdtState, "lastStructuralBuildTime", -1l);
			state.buildNumber = (Integer) readField(jdtState, "buildNumber", -1);
		}
		return state;
	}

	public synchronized boolean tryConfirmAllChanges(IProject project) {
		JavaBuilderState oldState = javaBuildState.get(project.getName());
		JavaBuilderState newState = readJavaBuilderState(project);
		if (oldState == null || oldState.lastStructuralBuildTime != newState.lastStructuralBuildTime) {
			Iterator<UnconfirmedStructuralChangesDelta> iterator = unconfirmedDeltas.iterator();
			while (iterator.hasNext()) {
				UnconfirmedStructuralChangesDelta unconfirmed = iterator.next();
				if (unconfirmed.getBuildNumber() < newState.buildNumber && unconfirmed.getProject().equals(project)) {
					iterator.remove();
					if (namesIntersect(unconfirmed.getNew(), newState.structurallyChangedTypes)
							|| namesIntersect(unconfirmed.getOld(), newState.structurallyChangedTypes))
						deltas.add(new ChangedResourceDescriptionDelta(unconfirmed.getOld(), unconfirmed.getNew()));
				}
			}
		} else {
			Iterator<UnconfirmedStructuralChangesDelta> iterator = unconfirmedDeltas.iterator();
			while (iterator.hasNext()) {
				UnconfirmedStructuralChangesDelta unconfirmed = iterator.next();
				if (unconfirmed.getBuildNumber() < newState.buildNumber && unconfirmed.getProject().equals(project))
					iterator.remove();
			}
		}
		javaBuildState.put(project.getName(), newState);
		return unconfirmedDeltas.isEmpty();
	}
			
	public synchronized void queueChanges(Collection<IResourceDescription.Delta> deltas) {
		if (deltas != null && !deltas.isEmpty()) {
			for (IResourceDescription.Delta delta : deltas) {
				if (delta instanceof UnconfirmedStructuralChangesDelta) {
					UnconfirmedStructuralChangesDelta unconfirmend = (UnconfirmedStructuralChangesDelta) delta;
					IProject project = unconfirmend.getProject();
					JavaBuilderState state = javaBuildState.get(project.getName());
					if (state == null) {
						javaBuildState.put(project.getName(), state = readJavaBuilderState(project));
					}
					unconfirmend.setBuildNumber(state.buildNumber);
					this.unconfirmedDeltas.add(unconfirmend);
				} else {
					this.deltas.add(delta);
				}
			}
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
