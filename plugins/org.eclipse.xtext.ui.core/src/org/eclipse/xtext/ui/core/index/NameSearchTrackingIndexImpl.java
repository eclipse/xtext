/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.xtext.index.XtextIndexImpl;
import org.eclipse.xtext.ui.core.builder.impl.ISharedState;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class NameSearchTrackingIndexImpl extends XtextIndexImpl implements ISharedState, IResourceChangeListener {

	@Inject
	public NameSearchTrackingIndexImpl(UpdateableIndex delegate, NamesToURIs namesToURIs) {
		super(delegate);
		this.namesToURI = namesToURIs;
	}

	private NamesToURIs namesToURI;

	public void startLinking(Resource resource) {
		namesToURI.deleteEntries(resource.getURI());
	}

	@Override
	public EObjectDescriptor executeFindEObjectByName(EObject context, String containerName, EClass type, String name) {
		namesToURI.insert(context.eResource().getURI(), name);
		return super.executeFindEObjectByName(context, containerName, type, name);
	}

	@Override
	public Iterable<URI> getPotentiallyInterestedResources(Set<String> names) {
		return namesToURI.findURIs(names);
	}
	
	@Override
	public <T> T executeUpdateCommand(final UpdateCommand<T> updateCommand) {
		return super.executeUpdateCommand(new UpdateCommand<T>() {

			public T execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				return updateCommand.execute(new WrappedUpdater(indexUpdater, queryExecutor, changedNames),
						queryExecutor);
			}
		});
	}

	private Set<String> changedNames = new HashSet<String>();

	public Set<String> getChangedEObjectNames() {
		return changedNames;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_BUILD)
			this.changedNames.clear();
	}

}
