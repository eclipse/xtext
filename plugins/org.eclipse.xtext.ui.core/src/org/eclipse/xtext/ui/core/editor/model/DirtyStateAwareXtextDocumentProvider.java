/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateAwareXtextDocumentProvider extends XtextDocumentProvider {
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * @author Sebastian Zarnekow
	 */
	protected static class ReferencedResourcesUpdater implements IStateChangeEventBroker.IStateChangeEventListener {
		private final XtextDocument document;
		
		private ReferencedResourcesUpdater(XtextDocument document) {
			this.document = document;
		}

		public void onStateChanged(IStateChangeEventBroker sender, final ImmutableCollection<URI> affectedURIs) {
			final Collection<Resource> affectedResources = document.readOnly(new IUnitOfWork<Collection<Resource>, XtextResource>() {
				public Collection<Resource> exec(XtextResource resource) throws Exception {
					if (resource == null || resource.getResourceSet() == null)
						return null;
					Collection<Resource> affectedResources = collectAffectedResources(resource, affectedURIs);
					return affectedResources;
				}
				
				protected Collection<Resource> collectAffectedResources(XtextResource resource, final ImmutableCollection<URI> affectedURIs) {
					List<Resource> result = Lists.newArrayListWithExpectedSize(2);
					ResourceSet resourceSet = resource.getResourceSet();
					URIConverter converter = resourceSet.getURIConverter();
					Set<URI> normalizedAffected = Sets.newHashSetWithExpectedSize(affectedURIs.size());
					for(URI original: affectedURIs) {
						normalizedAffected.add(converter.normalize(original));
					}
					EcoreUtil.resolveAll(resource);
					for(Resource res: resourceSet.getResources()) {
						if (res != resource) {
							URI normalized = converter.normalize(res.getURI());
							if (normalizedAffected.contains(normalized))
								result.add(res);
						}
					}
					return result;
				}
			});
			if (affectedResources != null && !affectedResources.isEmpty()) {
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						ResourceSet resourceSet = resource.getResourceSet();
						for(Resource affectedResource: affectedResources) {
							affectedResource.unload();
							resourceSet.getResources().remove(affectedResource);
						}
						resource.reparse(document.get());
					}
				});
			}
		}
	}
	
	protected static class XtextModelListener implements IXtextModelListener {

		private final XtextDocument document;
		private final IDirtyStateManager dirtyStateManager;

		public XtextModelListener(XtextDocument document, IDirtyStateManager dirtyStateManager) {
			this.document = document;
			this.dirtyStateManager = dirtyStateManager;
		}

		public void modelChanged(XtextResource resource) {
			// TODO: Discard dirty state on save, rollback and on close
			dirtyStateManager.announceDirtyStateChanged(document.getDirtyResource());
		}
		
	}
	
	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IStateChangeEventBroker stateChangeEventBroker;
	
	public IDirtyStateManager getDirtyStateManager() {
		return dirtyStateManager;
	}

	public void setDirtyStateManager(IDirtyStateManager dirtyStateManager) {
		this.dirtyStateManager = dirtyStateManager;
	}

	public IStateChangeEventBroker getStateChangeEventBroker() {
		return stateChangeEventBroker;
	}

	public void setStateChangeEventBroker(IStateChangeEventBroker stateChangeEventBroker) {
		this.stateChangeEventBroker = stateChangeEventBroker;
	}

	private final List<IStateChangeEventBroker.IStateChangeEventListener> registeredListeners =	Lists.newArrayList();

	@Override
	protected XtextDocument createEmptyDocument() {
		XtextDocument result = super.createEmptyDocument();
		result.addModelListener(createXtextModelListener(result));
		ReferencedResourcesUpdater listener = createReferencedResourceUpdater(result);
		registeredListeners.add(listener);
		stateChangeEventBroker.addListener(listener);
		return result;
	}

	private XtextModelListener createXtextModelListener(XtextDocument document) {
		return new XtextModelListener(document, dirtyStateManager);
	}

	private ReferencedResourcesUpdater createReferencedResourceUpdater(XtextDocument result) {
		return new ReferencedResourcesUpdater(result);
	}

	@Override
	protected void setupDocument(Object element, IDocument document) {
		super.setupDocument(element, document);
	}

	@Override
	protected void disconnected() {
		super.disconnected();
		for (IStateChangeEventBroker.IStateChangeEventListener listener : registeredListeners) {
			stateChangeEventBroker.removeListener(listener);
		}
		registeredListeners.clear();
	}
}
