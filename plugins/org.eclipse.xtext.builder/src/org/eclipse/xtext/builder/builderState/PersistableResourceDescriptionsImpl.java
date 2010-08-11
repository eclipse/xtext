/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptionsImpl extends AbstractBuilderState {

	/*
	 * TODO: Move to own compilation unit.
	 */
	@ImplementedBy(EMFBasedPersister.class)
	public interface PersistedStateProvider {
		Iterable<IResourceDescription> load();
	}
	
	@Override
	protected ImmutableList<Delta> doUpdate(ResourceSet resourceSet, Set<URI> toBeAddedOrUpdated,
			Set<URI> toBeRemoved, final Map<URI, IResourceDescription> newMap, SubMonitor subMonitor) {
		resourceSet.eAdapters().add(new ShadowingResourceDescriptions.Adapter(this, toBeAddedOrUpdated, toBeRemoved));
		resourceSet.getLoadOptions().put(AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		Collection<Delta> deltas = transitiveUpdate(resourceSet, toBeAddedOrUpdated, toBeRemoved, subMonitor.newChild(1));
		
		Set<Delta> copiedDeltas = Sets.newHashSet();
		
		SubMonitor deltaMonitor = SubMonitor.convert(subMonitor.newChild(1), "Update resource descriptions", deltas.size());
		int total = deltas.size();
		int current = 1;
		try {
			for (Delta delta : deltas) {
				if (deltaMonitor.isCanceled())
					return ImmutableList.of();
				deltaMonitor.subTask("Update resource description " + current + " of " + total);
				DefaultResourceDescriptionDelta copiedDelta = new DefaultResourceDescriptionDelta(delta.getOld(),
						createNew(delta, toBeAddedOrUpdated));
				copiedDeltas.add(copiedDelta);
				if (delta.getNew() == null) {
					newMap.remove(copiedDelta.getOld().getURI());
				} else {
					newMap.put(copiedDelta.getNew().getURI(), copiedDelta.getNew());
				}
				current++;
				deltaMonitor.worked(1);
			}
		} finally {
			deltaMonitor.done();
		}
		ImmutableList<Delta> immutableDeltas = ImmutableList.copyOf(copiedDeltas);
		doValidate(resourceSet, immutableDeltas, subMonitor.newChild(1));
		return immutableDeltas;
	}
	
	protected void doValidate(ResourceSet rs, ImmutableList<Delta> deltas, IProgressMonitor monitor) {
		updateMarkers(rs, deltas, monitor);
	}

	private IResourceDescription createNew(Delta delta, Set<URI> toBeAddedOrUpdated) {
		if (delta.getNew() == null)
			return null;
		IResourceDescription toCopy = delta.getNew();
		ResourceDescriptionImpl copied = BuilderStateUtil.create(toCopy);
		return copied;
	}

}
