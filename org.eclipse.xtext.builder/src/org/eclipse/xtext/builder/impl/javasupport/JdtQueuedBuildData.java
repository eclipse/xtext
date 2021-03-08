/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.impl.IQueuedBuildDataContribution;
import org.eclipse.xtext.common.types.ui.notification.JavaBuilderState;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Singleton;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@Singleton
public class JdtQueuedBuildData implements IQueuedBuildDataContribution {

	private Map<String, JavaBuilderState> javaBuildState;

	private Map<String, JavaBuilderState> javaBuildStateCopy;

	private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas;

	private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltasCopy;

	@Override
	public void reset() {
		javaBuildState = new HashMap<>();
		unconfirmedDeltas = new ArrayList<>();
	}

	@Override
	public void reset(IProject project) {
		javaBuildState.remove(project.getName());
	}

	/**
	 * Public for testing purpose
	 */
	public Collection<UnconfirmedStructuralChangesDelta> getUnconfirmedDeltas() {
		return unconfirmedDeltas;
	}

	@Override
	public boolean queueChange(IResourceDescription.Delta delta) {
		if (delta instanceof UnconfirmedStructuralChangesDelta) {
			UnconfirmedStructuralChangesDelta ucDelta = (UnconfirmedStructuralChangesDelta) delta;
			IProject project = ucDelta.getProject();
			JavaBuilderState state = javaBuildState.get(project.getName());
			if (state == null) {
				state = JavaBuilderState.getLastBuiltState(project);
				javaBuildState.put(project.getName(), state);
			}
			ucDelta.setBuildNumber(state.getBuildNumber().intValue());
			unconfirmedDeltas.add(ucDelta);
			return true;
		}
		return false;
	}

	@Override
	public boolean needsRebuild(IProject project, Collection<IResourceDescription.Delta> deltas) {
		JavaBuilderState oldState = javaBuildState.get(project.getName());
		JavaBuilderState newState = JavaBuilderState.getLastBuiltState(project);

		final Procedure1<UnconfirmedStructuralChangesDelta> processor;
		if (oldState == null || oldState.getLastStructuralBuildTime() != newState.getLastStructuralBuildTime()) {
			processor = (delta) -> {
				Set<QualifiedName> structurallyChangedTypes = newState.getStructurallyChangedTypes();
				if (namesIntersect(delta.getNew(), structurallyChangedTypes) //
						|| namesIntersect(delta.getOld(), structurallyChangedTypes)) {
					deltas.add(delta);
				}
			};
		} else {
			processor = null;
		}

		return doNeedRebuild(newState, processor);
	}

	protected boolean doNeedRebuild(JavaBuilderState javaBuilderState, Procedure1<? super UnconfirmedStructuralChangesDelta> processor) {
		Iterator<UnconfirmedStructuralChangesDelta> ucDeltas = unconfirmedDeltas.iterator();
		int buildNumber = javaBuilderState.getBuildNumber().intValue();
		IProject project = javaBuilderState.getProject();
		while (ucDeltas.hasNext()) {
			UnconfirmedStructuralChangesDelta ucDelta = ucDeltas.next();
			if ((ucDelta.getBuildNumber() < buildNumber)
					&& ucDelta.getProject().equals(project)) {
				ucDeltas.remove();
				if (processor != null) {
					processor.apply(ucDelta);
				}
			}
		}
		return !unconfirmedDeltas.isEmpty();
	}

	protected boolean namesIntersect(IResourceDescription resourceDescription, Set<QualifiedName> names) {
		if (resourceDescription == null) {
			return false;
		}
		for (IEObjectDescription objectDescription : resourceDescription.getExportedObjects()) {
			if (names.contains(objectDescription.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void createCheckpoint() {
		javaBuildStateCopy = new HashMap<>(javaBuildState);
		unconfirmedDeltasCopy = new ArrayList<>(unconfirmedDeltas);
	}

	@Override
	public void discardCheckpoint() {
		javaBuildStateCopy = null;
		unconfirmedDeltasCopy = null;
	}

	@Override
	public void rollback() {
		javaBuildState.clear();
		javaBuildState.putAll(javaBuildStateCopy);
		unconfirmedDeltas.clear();
		unconfirmedDeltas.addAll(unconfirmedDeltasCopy);
	}
}
