/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaChangeQueueFiller implements IElementChangedListener {

	@Inject
	private QueuedBuildData queue;

	@Inject
	private BuilderDeltaConverter deltaConverter;

	/**
	 * <p>
	 * This map is used to collect unsubmitted deltas during reconcilation.<br>
	 * A key is a fully qualified name of a compilation unit's name.<br>
	 * A value is a unsubmitted delta for a compilation unit.
	 * </p>
	 */
	private final Multimap<String, Delta> uriToDeltas;

	public JavaChangeQueueFiller() {
		JavaCore.addElementChangedListener(this);
		uriToDeltas = Multimaps.synchronizedListMultimap(ArrayListMultimap.<String, Delta> create());
	}

	public Collection<String> getReconcileTypes() {
		return Collections.unmodifiableCollection(uriToDeltas.keySet());
	}

	public Collection<Delta> getReconcileDeltas(String typeName) {
		return Collections.unmodifiableCollection(uriToDeltas.get(typeName));
	}

	public Collection<Delta> getReconcileDeltas() {
		return Collections.unmodifiableCollection(uriToDeltas.values());
	}

	public void elementChanged(ElementChangedEvent event) {
		final List<Delta> deltas = deltaConverter.convert(event.getDelta());
		if (deltas != null && !deltas.isEmpty()) {
			if (event.getType() == ElementChangedEvent.POST_RECONCILE) {
				putReconcileDeltas(deltas);
			} else {
				List<Delta> changes = unionReconcileDeltas(deltas);
				queue.queueChanges(changes);
			}
		}
	}

	/**
	 * <p>
	 * This method returns union of deltas for the current event and unsubmitted reconcile deltas.
	 * </p>
	 * <p>
	 * If the current event is reverting of a primary working copy to a compilation unit then unsubmitted reconcile
	 * deltas are removed without the further processing.
	 * </p>
	 * 
	 * @param deltas
	 *            a list of all deltas for the current event
	 * @return union of deltas for the current event and unsubmitted deltas for previous reconcile events
	 */
	private List<Delta> unionReconcileDeltas(List<Delta> deltas) {
		List<Delta> result = new ArrayList<Delta>();
		for (Delta delta : deltas) {
			if (commit(delta)) {
				Collection<Delta> reconcileDeltas = uriToDeltas.removeAll(getCompilationUnitName(delta));
				if (reconcileDeltas != null) {
					result.addAll(reconcileDeltas);
				}
			} else if (rollback(delta)) {
				uriToDeltas.removeAll(getCompilationUnitName(delta));
			} else {
				result.add(delta);
			}
		}
		return result;
	}

	/**
	 * <p>
	 * This method stores deltas for the further processing.
	 * </p>
	 * 
	 * @param deltas
	 *            a list of all deltas for the current event
	 * @exception IllegalStateException
	 *                - if a reconcile delta is not an instance of <code>UnsubmittedResourceDescriptionDelta</code>
	 */
	private void putReconcileDeltas(List<Delta> deltas) {
		for (Delta delta : deltas) {
			Preconditions.checkState(unsubmitted(delta), delta);
			uriToDeltas.put(getCompilationUnitName(delta), delta);
		}
	}

	private String getCompilationUnitName(Delta delta) {
		if (delta instanceof CompilationUnitDelta) {
			CompilationUnitDelta compilationUnitDelta = (CompilationUnitDelta) delta;
			return compilationUnitDelta.getCompilationUnitName();
		}
		throw new IllegalStateException("Unknown delta type: " + delta);
	}

	protected boolean unsubmitted(Delta delta) {
		return delta instanceof UnsubmittedResourceDescriptionDelta;
	}

	private boolean rollback(Delta delta) {
		return delta instanceof RollbackResourceDescriptionDelta;
	}

	private boolean commit(Delta delta) {
		return delta instanceof CommitResourceDescriptionDelta;
	}

}
