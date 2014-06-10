/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
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
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DirtyStateEditorSupport implements IXtextModelListener, IResourceDescription.Event.Listener, VerifyListener {
	
	private final static Logger LOG = Logger.getLogger(DirtyStateEditorSupport.class);
	
	private static ISchedulingRule SCHEDULING_RULE = SchedulingRuleFactory.INSTANCE.newSequence();
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class UpdateEditorStateJob extends Job {

		private boolean coarseGrainedChange;

		private Queue<IResourceDescription.Delta> pendingChanges;

		protected UpdateEditorStateJob(ISchedulingRule rule) {
			this(rule, Messages.DirtyStateEditorSupport_JobName);
		}
		
		protected UpdateEditorStateJob(ISchedulingRule rule, String name) {
			super(name);
			setRule(rule);
			pendingChanges = new ConcurrentLinkedQueue<IResourceDescription.Delta>();
		}
		
		protected void scheduleFor(IResourceDescription.Event event) {
			cancel();
			coarseGrainedChange = coarseGrainedChange || event instanceof IResourceDescription.CoarseGrainedEvent;
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
			IResourceDescription.Event event = new ResourceDescriptionChangeEvent(uriToDelta.values());
			return Tuples.create(event, size);
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			try {
				IDirtyStateEditorSupportClient myClient = currentClient;
				if (myClient == null || monitor.isCanceled()) {
					return Status.OK_STATUS;
				}
				final IXtextDocument document = myClient.getDocument();
				if (document == null) {
					return Status.OK_STATUS;
				}
				final boolean[] isReparseRequired = new boolean[] { coarseGrainedChange };
				final Pair<IResourceDescription.Event, Integer> event = mergePendingDeltas();
				Collection<Resource> affectedResources = document.readOnly(
						new IUnitOfWork<Collection<Resource>, XtextResource>() {
					
							public Collection<Resource> exec(XtextResource resource) throws Exception {
								if (resource == null || resource.getResourceSet() == null) {
									return null;
								}
								Collection<Resource> affectedResources = collectAffectedResources(resource, event.getFirst());
								if (monitor.isCanceled() || !affectedResources.isEmpty()) {
									return affectedResources;
								}
								if (!isReparseRequired[0]) {
									isReparseRequired[0] = isReparseRequired(resource, event.getFirst());
								}
								return affectedResources;
							}
					
						});
				if (monitor.isCanceled()) {
					return Status.OK_STATUS;
				}
				try {
					unloadAffectedResourcesAndReparseDocument(document, affectedResources, isReparseRequired[0]);
					for (int i = 0; i < event.getSecond(); i++) {
						pendingChanges.poll();
					}
					return Status.OK_STATUS;
				} finally {
					coarseGrainedChange = false;	
				}
			} catch (Throwable e) {
				LOG.error("Error updating dirty state editor", e);
				return Status.OK_STATUS;
			}
		}

		private void unloadAffectedResourcesAndReparseDocument(final IXtextDocument document,
				final Collection<Resource> affectedResources, boolean reparseRequired) {
			if ((affectedResources == null || affectedResources.isEmpty()) && !reparseRequired) {
				return;
			}
			Assert.isLegal(document instanceof XtextDocument);
			XtextDocument xtextDocument = (XtextDocument) document;
			xtextDocument.internalModify(new IUnitOfWork.Void<XtextResource>() {

				@Override
				public void process(XtextResource resource) throws Exception {
					if (resource == null || resource.getResourceSet() == null) {
						return;
					}
					ResourceSet resourceSet = resource.getResourceSet();
					if (affectedResources != null) {
						for (Resource affectedResource : affectedResources) {
							affectedResource.unload();
							resourceSet.getResources().remove(affectedResource);
						}
					}
					resource.reparse(document.get());
				}

			});
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
			String title = Messages.DirtyStateEditorSupport_ConcurrentChangeDialog_Title;
			String message = Messages.DirtyStateEditorSupport_ConcurrentChangeDialog_Message;
			return MessageDialog.openQuestion(client.getShell(), title, message);
		}
		
	}
	
	/**
	 * Minimal required interface for clients. Allows easy mocking.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public interface IDirtyStateEditorSupportClient {

		IXtextDocument getDocument();

		boolean isDirty();
		
		/**
		 * May return <code>null</code> in headless environments.
		 */
		Shell getShell();

		void addVerifyListener(VerifyListener listener);

		void removeVerifyListener(VerifyListener listener);
		
	}
	
	/**
	 * Simple delegate which can remove itself from the dirty
	 * state manager. It is used to discard unmodified
	 * resources which would otherwise cause unexpected conflicts
	 * (see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=340561">bug 340561</a>).
	 */
	private class ClientAwareDirtyResource implements IDirtyResource.NormalizedURISupportExtension {

		public String getContents() {
			return dirtyResource.getContents();
		}

		public String getActualContents() {
			return dirtyResource.getActualContents();
		}

		public IResourceDescription getDescription() {
			return dirtyResource.getDescription();
		}

		public URI getURI() {
			return dirtyResource.getURI();
		}
		
		private boolean isDirty() {
			return currentClient != null && currentClient.isDirty();
		}
		
		private void discardThisResource() {
			markEditorClean(currentClient);
		}

		public URI getNormalizedURI() {
			return dirtyResource.getNormalizedURI();
		}
		
	}
	
	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IStateChangeEventBroker stateChangeEventBroker;
	
	@Inject
	private DocumentBasedDirtyResource dirtyResource;
	
	/*
	 * The client aware dirty resource is used as a delegate
	 * since it exposes some more information than the document
	 * based resource (which cannot be modified since it's API).
	 */
	private ClientAwareDirtyResource delegatingClientAwareResource;
	
	@Inject
	private IConcurrentEditingCallback concurrentEditingWarningDialog;
	
	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	@Inject(optional=true)
	private DescriptionUtils descriptionUtils;
	
	@Inject(optional=true)
	private IValidationJobScheduler validationJobScheduler;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	private volatile IDirtyStateEditorSupportClient currentClient;
	
	private volatile boolean isDirty;
	
	public void initializeDirtyStateSupport(IDirtyStateEditorSupportClient client) {
		if (this.currentClient != null)
			throw new IllegalStateException("editor was already assigned"); //$NON-NLS-1$
		this.currentClient = client;
		this.isDirty = false;
		IXtextDocument document = client.getDocument();
		document.addModelListener(this);
		initDirtyResource(document);
		stateChangeEventBroker.addListener(this);
		client.addVerifyListener(this);
		scheduleValidationJobIfNecessary();
	}
	
	private void scheduleValidationJobIfNecessary() {
		if (validationJobScheduler != null && currentClient != null) {
			validationJobScheduler.scheduleInitialValidation(currentClient.getDocument());
		}
	}

	public void verifyText(VerifyEvent e) {
		if (isDirty || !e.doit)
			return;
		e.doit = doVerify();
		if (e.doit)
			isDirty = true;
	}
	
	public boolean doVerify() {
		if (!dirtyStateManager.manageDirtyState(delegatingClientAwareResource)) {
			if (dirtyStateManager instanceof DirtyStateManager) {
				IDirtyResource other = ((DirtyStateManager) dirtyStateManager).getDirtyResource(delegatingClientAwareResource.getURI());
				if (other instanceof ClientAwareDirtyResource) {
					ClientAwareDirtyResource clientAwareDirtyResource = (ClientAwareDirtyResource) other;
					if (!clientAwareDirtyResource.isDirty()) {
						clientAwareDirtyResource.discardThisResource();
						return doVerify();
					}
				}
			}
			if (!isConcurrentEditingIgnored()) {
				dirtyStateManager.discardDirtyState(delegatingClientAwareResource);
				return false;
			}
		}
		return true;
	}
	
	public boolean isEditingPossible(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all."); //$NON-NLS-1$
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
		delegatingClientAwareResource = new ClientAwareDirtyResource();
	}
	
	public void removeDirtyStateSupport(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all."); //$NON-NLS-1$
		client.removeVerifyListener(this);
		stateChangeEventBroker.removeListener(this);
		if (dirtyResource.isInitialized()) 
			dirtyStateManager.discardDirtyState(delegatingClientAwareResource);
		IXtextDocument document = client.getDocument();
		if (document == null)
			document = dirtyResource.getUnderlyingDocument();
		if (document != null) {
			dirtyResource.disconnect(document);
			document.removeModelListener(this);
		}
		this.delegatingClientAwareResource = null;
		this.currentClient = null;
	}
	
	public void markEditorClean(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all."); //$NON-NLS-1$
		dirtyStateManager.discardDirtyState(delegatingClientAwareResource);
		isDirty = false;
		IResourceDescription cleanDescription = resourceDescriptions.getResourceDescription(delegatingClientAwareResource.getURI());
		if (cleanDescription != null)
			dirtyResource.copyState(cleanDescription);
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
		if (isDirty || ((!resource.isTrackingModification() || resource.isModified()) && delegatingClientAwareResource.isDirty() && dirtyStateManager.manageDirtyState(delegatingClientAwareResource))) {
			synchronized (dirtyStateManager) {
				IResourceDescription.Manager resourceDescriptionManager = resource.getResourceServiceProvider().getResourceDescriptionManager();
				final IResourceDescription newDescription = resourceDescriptionManager.getResourceDescription(resource);
				if (haveEObjectDescriptionsChanged(newDescription, resourceDescriptionManager)) {
					dirtyResource.copyState(newDescription);
					dirtyStateManager.announceDirtyStateChanged(delegatingClientAwareResource);
				}
			}
		}
	}

	/**
	 * @deprecated Use {@link #haveEObjectDescriptionsChanged(IResourceDescription, org.eclipse.xtext.resource.IResourceDescription.Manager)}.
	 */
	@Deprecated
	public boolean haveEObjectDescriptionsChanged(final IResourceDescription newDescription) {
		IResourceDescription.Manager resourceDescriptionManager = resourceServiceProviderRegistry.getResourceServiceProvider(newDescription.getURI()).getResourceDescriptionManager();
		return haveEObjectDescriptionsChanged(newDescription, resourceDescriptionManager);
	}

	/**
	 * @since 2.3
	 */
	public boolean haveEObjectDescriptionsChanged(final IResourceDescription newDescription, IResourceDescription.Manager resourceDescriptionManager) {
		return resourceDescriptionManager.createDelta(dirtyResource.getDescription(), newDescription).haveEObjectDescriptionsChanged();
	}

	protected Collection<Resource> collectAffectedResources(XtextResource resource, IResourceDescription.Event event) {
		List<Resource> result = Lists.newArrayListWithExpectedSize(4);
		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter converter = resourceSet.getURIConverter();
		Set<URI> normalizedURIs = Sets.newHashSetWithExpectedSize(event.getDeltas().size());
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			normalizedURIs.add(converter.normalize(delta.getUri()));
		}
		List<Resource> resources = resourceSet.getResources();
		for(int i = 0; i< resources.size(); i++) {
			Resource res = resources.get(i);
			if (res != resource && res != null) {
				URI uri = res.getURI();
				try {
					uri = converter.normalize(uri);
				} catch (org.eclipse.xtext.resource.ClasspathUriResolutionException e) {
					// ignore, since the classpath might be broken.
				}
				if (normalizedURIs.contains(uri))
					result.add(res);
			}
		}
		return result;
	}
	
	protected boolean isReparseRequired(XtextResource resource, IResourceDescription.Event event) {
		IResourceDescription.Manager resourceDescriptionManager = resource.getResourceServiceProvider().getResourceDescriptionManager();
		IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
		if (resourceDescriptionManager.isAffected(event.getDeltas(), description, resourceDescriptions)) {
			return true;
		}
		if (!isDirty() && !dirtyStateManager.hasContent(resource.getURI())) {
			IResourceDescription originalDescription = resourceDescriptions.getResourceDescription(resource.getURI());
			if (originalDescription != null && descriptionUtils != null) {
				Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(originalDescription);
				for(IResourceDescription.Delta delta: event.getDeltas()) {
					if (delta.haveEObjectDescriptionsChanged() && outgoingReferences.contains(delta.getUri()))
						return true;
				}
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

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setDirtyStateManager(IDirtyStateManager dirtyStateManager) {
		this.dirtyStateManager = dirtyStateManager;
	}

	public IStateChangeEventBroker getStateChangeEventBroker() {
		return stateChangeEventBroker;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setStateChangeEventBroker(IStateChangeEventBroker stateChangeEventBroker) {
		this.stateChangeEventBroker = stateChangeEventBroker;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setConcurrentEditingWarningDialog(IConcurrentEditingCallback concurrentEditingWarningDialog) {
		this.concurrentEditingWarningDialog = concurrentEditingWarningDialog;
	}

	public IConcurrentEditingCallback getConcurrentEditingWarningDialog() {
		return concurrentEditingWarningDialog;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setDirtyResource(DocumentBasedDirtyResource dirtyResource) {
		this.dirtyResource = dirtyResource;
	}

	public DocumentBasedDirtyResource getDirtyResource() {
		return dirtyResource;
	}

	/**
	 * @since 2.1
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}
}
