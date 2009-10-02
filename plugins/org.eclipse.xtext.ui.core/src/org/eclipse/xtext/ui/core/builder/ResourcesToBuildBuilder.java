/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder.IEObjectDescriptorIndexer;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder.IEReferenceDescriptorIndexer;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourcesToBuildBuilder {

	private UpdateableIndex index;

	@Inject
	public ResourcesToBuildBuilder(UpdateableIndex index) {
		this.index = index;
	}

	public void doBuild(final String project, final List<ResourceToBuild> resourcesToBuild,
			final IProgressMonitor monitor) {
		for (final ResourceToBuild r : resourcesToBuild) {
			if (monitor.isCanceled())
				return;
			r.unloadAndRemove(monitor);
			if (!r.isRemoveOnly())
				r.loadEmfResource(monitor);
		}

		indexEObjectsAndEReferences(project, resourcesToBuild, monitor);

		for (final ResourceToBuild r : resourcesToBuild) {
			if (monitor.isCanceled())
				return;
			if (!r.isRemoveOnly()) {
				List<Map<String, Object>> result = r.validate(monitor);

				IResource iResource = r.getIResource();
				if (iResource != null)
					AddMarkersOperation.run(iResource, result, true, monitor);
				r.doBuild(monitor);
			}
		}

	}

	protected void indexEObjectsAndEReferences(final String project, final List<ResourceToBuild> resourcesToBuild,
			final IProgressMonitor monitor) {
		if (index == null)
			return;

		/*
		 * IMPORTANT
		 * First index all EObjectDescriptors before indexing any EReferenceDescriptors.
		 * This is because the linking in Xtext is usually based on EObjectDescriptors.
		 */
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(final IndexUpdater x, QueryExecutor queryExecutor) {
				x.createContainer(project, null);
				for (final ResourceToBuild r : resourcesToBuild) {
					if (monitor.isCanceled())
						return null;
					x.deleteResource(r.getUri());
					if (!r.isRemoveOnly()) {
						x.createOrUpdateResource(project, r.getUri(), System.currentTimeMillis(), null);
						r.indexEObjects(new IEObjectDescriptorIndexer() {
							public void index(String name, EObject obj, Map<String, Serializable> userData) {
								String uriFragment = obj.eResource().getURIFragment(obj);
								x.createOrUpdateEObject(r.getUri(), uriFragment, name, obj.eClass(), userData);
							}
						}, monitor);
					}
				}
				return null;
			}
		});
		
		index.executeUpdateCommand(new UpdateCommand<Void>() {
			public Void execute(final IndexUpdater x, QueryExecutor queryExecutor) {
				for (final ResourceToBuild r : resourcesToBuild) {
					if (monitor.isCanceled())
						return null;
					if (!r.isRemoveOnly()) {
						r.indexEReferences(new IEReferenceDescriptorIndexer() {

							public void index(EObject from, EObject to, EReference reference) {
								String sourceFragment = from.eResource().getURIFragment(from);
								URI targetEObjectURI = EcoreUtil.getURI(to);
								x.createOrUpdateEReference(r.getUri(), sourceFragment, targetEObjectURI, reference, null);
							}
						}, monitor);
					}
				}
				return null;
			}
		});
	}

}
