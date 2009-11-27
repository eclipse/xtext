/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateEditorSupport implements IXtextModelListener, IResourceDescription.Event.Listener, VerifyListener {
	
	/**
	 * Allows to mock the user decision in unit tests.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	@ImplementedBy(InteractiveConcurrentEditingQuestion.class)
	public interface IConcurrentEditingCallback {
		/**
		 * @return <code>true</code> if the concurrent editing warning should be ignored.
		 */
		boolean isConcurrentEditingIgnored(IDirtyStateEditorSupportClient client);
	}
	
	public static class InteractiveConcurrentEditingQuestion implements IConcurrentEditingCallback {

		public boolean isConcurrentEditingIgnored(IDirtyStateEditorSupportClient client) {
			String title = "Resource was edited concurrently.";
			String message = "The resource is currently edited in another editor. Do you want to continue?";
			return MessageDialog.openQuestion(client.getShell(), title, message);
		}
		
	}
	
	/**
	 * Minimal required interface for clients. Allows easy mocking.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public interface IDirtyStateEditorSupportClient {

		IXtextDocument getDocument();

		/**
		 * May return <code>null</code> in headless environments.
		 */
		Shell getShell();

		void addVerifyListener(VerifyListener listener);

		void removeVerifyListener(VerifyListener listener);
		
	}
	
	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IStateChangeEventBroker stateChangeEventBroker;
	
	@Inject
	private DocumentBasedDirtyResource dirtyResource;
	
	@Inject
	private IConcurrentEditingCallback concurrentEditingWarningDialog;
	
	private IDirtyStateEditorSupportClient currentClient;
	
	private boolean isDirty;
	
	public void initializeDirtyStateSupport(IDirtyStateEditorSupportClient client) {
		if (this.currentClient != null)
			throw new IllegalStateException("editor was already assigned");
		this.currentClient = client;
		this.isDirty = false;
		IXtextDocument document = client.getDocument();
		document.addModelListener(this);
		initDirtyResource(document);
		stateChangeEventBroker.addListener(this);
		client.addVerifyListener(this);
	}
	
	public void verifyText(VerifyEvent e) {
		if (isDirty || !e.doit)
			return;
		e.doit = doVerify();
		if (e.doit)
			isDirty = true;
	}
	
	public boolean doVerify() {
		if (!dirtyStateManager.manageDirtyState(dirtyResource)) {
			if (!isConcurrentEditingIgnored()) {
				dirtyStateManager.discardDirtyState(dirtyResource);
				return false;
			}
		}
		return true;
	}
	
	public boolean isEditingPossible(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all.");
		if (isDirty)
			return true;
	
		if (!doVerify())
			return false;
		isDirty = true;
		return true;
	}

	protected boolean isConcurrentEditingIgnored() {
		return concurrentEditingWarningDialog.isConcurrentEditingIgnored(currentClient);
	}

	protected void initDirtyResource(IXtextDocument document) {
		dirtyResource.connect(document);
	}
	
	public void removeDirtyStateSupport(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all.");
		client.removeVerifyListener(this);
		stateChangeEventBroker.removeListener(this);
		dirtyStateManager.discardDirtyState(dirtyResource);
		IXtextDocument document = client.getDocument();
		if (document == null)
			document = dirtyResource.getUnderlyingDocument();
		if (document != null) {
			dirtyResource.disconnect(document);
			document.removeModelListener(this);
		}
		this.currentClient = null;
	}
	
	public void markEditorClean(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all.");
		dirtyStateManager.discardDirtyState(dirtyResource);
		isDirty = false;
	}
	
	public void descriptionsChanged(IResourceDescription.Event event) {
		final Set<URI> uris = Sets.newHashSet();
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			if (delta.getNew() != null)
				uris.add(delta.getNew().getURI());
			else if (delta.getOld() != null)
				uris.add(delta.getOld().getURI());
		}
		final IXtextDocument document = currentClient.getDocument();
		final Collection<Resource> affectedResources = document.readOnly(new IUnitOfWork<Collection<Resource>, XtextResource>() {
			public Collection<Resource> exec(XtextResource resource) throws Exception {
				if (resource == null || resource.getResourceSet() == null)
					return null;
				Collection<Resource> affectedResources = collectAffectedResources(resource, uris);
				return affectedResources;
			}
			
			protected Collection<Resource> collectAffectedResources(XtextResource resource, final Collection<URI> affectedURIs) {
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
	
	public void modelChanged(XtextResource resource) {
		if (resource == null)
			return;
		if (isDirty || dirtyStateManager.manageDirtyState(dirtyResource)) {
			synchronized (dirtyResource) {
				dirtyResource.copyState(resource);
				dirtyStateManager.announceDirtyStateChanged(dirtyResource);
			}
		}
	}
		
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

	public void setConcurrentEditingWarningDialog(IConcurrentEditingCallback concurrentEditingWarningDialog) {
		this.concurrentEditingWarningDialog = concurrentEditingWarningDialog;
	}

	public IConcurrentEditingCallback getConcurrentEditingWarningDialog() {
		return concurrentEditingWarningDialog;
	}

	public void setDirtyResource(DocumentBasedDirtyResource dirtyResource) {
		this.dirtyResource = dirtyResource;
	}

	public DocumentBasedDirtyResource getDirtyResource() {
		return dirtyResource;
	}
}
