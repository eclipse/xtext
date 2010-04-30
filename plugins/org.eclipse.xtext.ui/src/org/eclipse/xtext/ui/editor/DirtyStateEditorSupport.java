/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateEditorSupport implements IXtextModelListener, IResourceDescription.Event.Listener, VerifyListener {
	private static ISchedulingRule SCHEDULING_RULE = SchedulingRuleFactory.INSTANCE.newSequence();
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class UpdateEditorStateJob extends Job {
		private Queue<IResourceDescription.Delta> pendingChanges;

		protected UpdateEditorStateJob(ISchedulingRule rule) {
			this(rule, "Updating editor state");
		}
		
		protected UpdateEditorStateJob(ISchedulingRule rule, String name) {
			super(name);
			setRule(rule);
			pendingChanges = new ConcurrentLinkedQueue<IResourceDescription.Delta>();
		}
		
		protected void scheduleFor(IResourceDescription.Event event) {
			cancel();
			pendingChanges.addAll(event.getDeltas());
			schedule(getDelay());
		}

		protected int getDelay() {
			return 500;
		}
		
		protected Pair<IResourceDescription.Event, Integer> mergePendingDeltas() {
			Map<URI, IResourceDescription.Delta> uriToDelta = Maps.newLinkedHashMap();
			Iterator<IResourceDescription.Delta> iter = pendingChanges.iterator();
			int size = 0;
			while(iter.hasNext()) {
				IResourceDescription.Delta delta = iter.next();
				URI uri = delta.getUri();
				IResourceDescription.Delta prev = uriToDelta.get(uri);
				if (prev == null) {
					uriToDelta.put(uri, delta);
				} else if (prev.getOld() != delta.getNew()){
					uriToDelta.put(uri, createDelta(delta, prev));
				} else {
					uriToDelta.remove(uri);
				}
				size++;
			}
			IResourceDescription.Event event = new ResourceDescriptionChangeEvent(uriToDelta.values(), dirtyStateManager);
			return Tuples.create(event, size);
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			IDirtyStateEditorSupportClient myClient = currentClient;
			if (myClient == null || monitor.isCanceled())
				return Status.OK_STATUS;
			final IXtextDocument document = myClient.getDocument();
			if (document == null)
				return Status.OK_STATUS;
			final boolean[] isReparseRequired = new boolean[] {false};
			final Pair<IResourceDescription.Event,Integer> event = mergePendingDeltas();
			final Collection<Resource> affectedResources = document.readOnly(new IUnitOfWork<Collection<Resource>, XtextResource>() {
				public Collection<Resource> exec(XtextResource resource) throws Exception {
					if (resource == null || resource.getResourceSet() == null)
						return null;
					Collection<Resource> affectedResources = collectAffectedResources(resource, event.getFirst());
					if (monitor.isCanceled())
						return Collections.emptySet();
					isReparseRequired[0] = isReparseRequired(resource, event.getFirst());
					return affectedResources;
				}
			});
			if (monitor.isCanceled())
				return Status.OK_STATUS;
			if (affectedResources != null && !affectedResources.isEmpty() || isReparseRequired[0]) {
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource == null || resource.getResourceSet() == null)
							return;
						ResourceSet resourceSet = resource.getResourceSet();
						if (affectedResources != null) {
							for(Resource affectedResource: affectedResources) {
								affectedResource.unload();
								resourceSet.getResources().remove(affectedResource);
							}
						}
						resource.reparse(document.get());
					}
				});
			}
			for(int i = 0; i < event.getSecond(); i++) {
				pendingChanges.poll();
			}
			return Status.OK_STATUS;
		}
		
	}

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
	
	private volatile IDirtyStateEditorSupportClient currentClient;
	
	private volatile boolean isDirty;
	
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
		if (dirtyResource.isInitialized()) 
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
	
	public void descriptionsChanged(final IResourceDescription.Event event) {
		if (!getDirtyResource().isInitialized())
			return;
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			if (delta.getOld() == getDirtyResource().getDescription() || delta.getNew() == getDirtyResource().getDescription())
				return;
		}
		scheduleUpdateEditorJob(event);
	}

	private UpdateEditorStateJob updateEditorStateJob;
	
	public void scheduleUpdateEditorJob(final IResourceDescription.Event event) {
		UpdateEditorStateJob job = updateEditorStateJob;
		if (job == null) {
			job = createUpdateEditorJob();
			updateEditorStateJob = job;
		}
		job.scheduleFor(event); 
	}

	protected UpdateEditorStateJob createUpdateEditorJob() {
		// default is sequential execution to ensure a minimum number of
		// spawned worker threads
		return new UpdateEditorStateJob(SCHEDULING_RULE);
	}
	
	public void modelChanged(XtextResource resource) {
		if (resource == null || !dirtyResource.isInitialized())
			return;
		if (isDirty || ((!resource.isTrackingModification() || resource.isModified()) && dirtyStateManager.manageDirtyState(dirtyResource))) {
			synchronized (dirtyStateManager) {
				final IResourceDescription newDescription = resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource);
				if (haveEObjectDescriptionsChanged(newDescription)) {
					dirtyResource.copyState(newDescription);
					dirtyStateManager.announceDirtyStateChanged(dirtyResource);
				}
			}
		}
	}

	public boolean haveEObjectDescriptionsChanged(final IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(dirtyResource.getDescription(), newDescription).haveEObjectDescriptionsChanged();
	}
	
	protected Collection<Resource> collectAffectedResources(XtextResource resource, IResourceDescription.Event event) {
		List<Resource> result = Lists.newArrayListWithExpectedSize(4);
		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter converter = resourceSet.getURIConverter();
		Set<URI> normalizedURIs = Sets.newHashSetWithExpectedSize(event.getDeltas().size());
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			if (delta.getNew() != null)
				normalizedURIs.add(converter.normalize(delta.getNew().getURI()));
			else if (delta.getOld() != null)
				normalizedURIs.add(converter.normalize(delta.getOld().getURI()));	
		}
		for(Resource res: resourceSet.getResources()) {
			if (res != resource && res != null) {
				URI normalized = converter.normalize(res.getURI());
				if (normalizedURIs.contains(normalized))
					result.add(res);
			}
		}
		return result;
	}
	
	protected boolean isReparseRequired(XtextResource resource, IResourceDescription.Event event) {
		IResourceDescription.Manager resourceDescriptionManager = resource.getResourceServiceProvider().getResourceDescriptionManager();
		IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			if (resourceDescriptionManager.isAffected(delta, description)) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isDirty() {
		return isDirty;
	}
		
	protected ChangedResourceDescriptionDelta createDelta(IResourceDescription.Delta delta,
			IResourceDescription.Delta prev) {
		return new ChangedResourceDescriptionDelta(prev.getOld(), delta.getNew());
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
