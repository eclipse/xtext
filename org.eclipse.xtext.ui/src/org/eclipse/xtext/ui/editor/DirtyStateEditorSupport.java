/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DirtyStateEditorSupport implements IResourceDescription.Event.Listener, VerifyListener {
	
	private static final Logger LOG = Logger.getLogger(DirtyStateEditorSupport.class);
	
	private static final ISchedulingRule SCHEDULING_RULE = SchedulingRuleFactory.INSTANCE.newSequence();
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class UpdateEditorStateJob extends Job {

		private AtomicInteger coarseGrainedChanges;

		private Queue<IResourceDescription.Delta> pendingChanges;

		protected UpdateEditorStateJob(ISchedulingRule rule) {
			this(rule, Messages.DirtyStateEditorSupport_JobName);
		}
		
		protected UpdateEditorStateJob(ISchedulingRule rule, String name) {
			super(name);
			setRule(rule);
			coarseGrainedChanges = new AtomicInteger();
			pendingChanges = new ConcurrentLinkedQueue<IResourceDescription.Delta>();
		}
		
		protected void scheduleFor(IResourceDescription.Event event) {
			cancel();
			if (event instanceof IResourceDescription.CoarseGrainedEvent)
				coarseGrainedChanges.incrementAndGet();
			else
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
				if (myClient == null) {
					return Status.OK_STATUS;
				}
				final IXtextDocument document = myClient.getDocument();
				if (document == null) {
					return Status.OK_STATUS;
				}
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				int coarseGrainedChangesSeen = coarseGrainedChanges.get();
				final boolean[] isReparseRequired = new boolean[] { coarseGrainedChangesSeen > 0 };
				final Pair<IResourceDescription.Event, Integer> event = mergePendingDeltas();
				Collection<Resource> affectedResources = document.tryReadOnly(
						new IUnitOfWork<Collection<Resource>, XtextResource>() {
					
							@Override
							public Collection<Resource> exec(XtextResource resource) throws Exception {
								if (resource.getResourceSet() == null) {
									return null;
								}
								Collection<Resource> affectedResources = collectAffectedResources(resource, event.getFirst());
								if (monitor.isCanceled())
									throw new OperationCanceledException();
								if (!affectedResources.isEmpty()) {
									return affectedResources;
								}
								if (!isReparseRequired[0]) {
									isReparseRequired[0] = isReparseRequired(resource, event.getFirst());
								}
								return affectedResources;
							}
					
						});
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				unloadAffectedResourcesAndReparseDocument(document, affectedResources, isReparseRequired[0]);
				for (int i = 0; i < event.getSecond(); i++) {
					pendingChanges.poll();
				}
				coarseGrainedChanges.addAndGet(-coarseGrainedChangesSeen);
				return Status.OK_STATUS;
			} catch (OperationCanceledException e) {
				return Status.CANCEL_STATUS;
			} catch (OperationCanceledError e) {
				return Status.CANCEL_STATUS;
			} catch (Throwable e) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error updating dirty state editor", e);
			}
		}

		private void unloadAffectedResourcesAndReparseDocument(final IXtextDocument document,
				final Collection<Resource> affectedResources, boolean reparseRequired) {
			if ((affectedResources == null || affectedResources.isEmpty()) && !reparseRequired) {
				return;
			}
			Assert.isLegal(document instanceof XtextDocument);
			final XtextDocument xtextDocument = (XtextDocument) document;
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
					if (currentClient instanceof IDirtyStateEditorSupportClientExtension)
						((IDirtyStateEditorSupportClientExtension) currentClient).forceReconcile();
					else 
						resource.reparse(document.get());
					if (resourceSet instanceof XtextResourceSet) {
						((XtextResourceSet) resourceSet).markOutdated();
					}
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

		@Override
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

		/**
		 * May return <code>null</code> before EditorPart creation or after its disposal.
		 */
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
	 * @since 2.7
	 */
	public interface IDirtyStateEditorSupportClientExtension {
		void forceReconcile();
	}

	/**
	 * Simple delegate which can remove itself from the dirty
	 * state manager. It is used to discard unmodified
	 * resources which would otherwise cause unexpected conflicts
	 * (see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=340561">bug 340561</a>).
	 */
	private class ClientAwareDirtyResource implements IDirtyResource.NormalizedURISupportExtension, IDirtyResource.ICurrentStateProvidingExtension, IDirtyResource.InitializationAware {

		@Override
		public String getContents() {
			return dirtyResource.getContents();
		}

		@Override
		public String getActualContents() {
			return dirtyResource.getActualContents();
		}

		@Override
		public IResourceDescription getDescription() {
			return dirtyResource.getDescription();
		}

		@Override
		public URI getURI() {
			return dirtyResource.getURI();
		}
		
		private boolean isDirty() {
			return currentClient != null && currentClient.isDirty();
		}
		
		private void discardThisResource() {
			markEditorClean(currentClient);
		}

		@Override
		public URI getNormalizedURI() {
			return dirtyResource.getNormalizedURI();
		}

		@Override
		public ResourceStorageLoadable getResourceStorageLoadable() {
			return dirtyResource.getResourceStorageLoadable();
		}
		
		@Override
		public boolean isInitialized() {
			return dirtyResource.isInitialized();
		}
		
		@Override
		public IResourceDescription getDescriptionIfInitialized() {
			return dirtyResource.getDescriptionIfInitialized();
		}
		
		@Override
		public String getActualContentsIfInitialized() {
			return dirtyResource.getActualContentsIfInitialized();
		}
		
		@Override
		public String getContentsIfInitialized() {
			return dirtyResource.getContentsIfInitialized();
		}
		
		
	}
	
	private static enum State {
		CLEAN, DIRTY, SHOULD_UPDATE
	}
	
	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IStateChangeEventBroker stateChangeEventBroker;
	
	@Inject
	private DocumentBasedDirtyResource dirtyResource;
	
	@Inject(optional=true)
	private IResourceStorageFacade resoureStorageFacade;
	
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
	
	private volatile State state;
	
	public void initializeDirtyStateSupport(IDirtyStateEditorSupportClient client) {
		if (this.currentClient != null)
			throw new IllegalStateException("editor was already assigned"); //$NON-NLS-1$
		this.currentClient = client;
		this.state = State.CLEAN;
		IXtextDocument document = client.getDocument();
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

	@Override
	public void verifyText(VerifyEvent e) {
		if (state == State.DIRTY || !e.doit)
			return;
		e.doit = doVerify();
		if (e.doit)
			state = State.DIRTY;
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
		if (state == State.DIRTY)
			return true;
	
		if (!doVerify())
			return false;
		state = State.DIRTY;
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
		if (this.currentClient == null)
			return;
		else if(this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all."); //$NON-NLS-1$
		client.removeVerifyListener(this);
		stateChangeEventBroker.removeListener(this);
		synchronized (dirtyStateManager) {
			if (dirtyResource.isInitialized()) 
				dirtyStateManager.discardDirtyState(delegatingClientAwareResource);
			IXtextDocument document = client.getDocument();
			if (document == null)
				document = dirtyResource.getUnderlyingDocument();
			if (document != null) {
				dirtyResource.disconnect(document);
			}
		}
		this.delegatingClientAwareResource = null;
		this.currentClient = null;
	}
	
	public void markEditorClean(IDirtyStateEditorSupportClient client) {
		if (this.currentClient == null || this.currentClient != client)
			throw new IllegalStateException("Was configured with another client or not configured at all."); //$NON-NLS-1$
		dirtyStateManager.discardDirtyState(delegatingClientAwareResource);
		state = State.SHOULD_UPDATE;
	}
	
	@Override
	public void descriptionsChanged(final IResourceDescription.Event event) {
		if (!getDirtyResource().isInitialized())
			return;
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			if (delta.getOld() == getDirtyResource().getDescription() || delta.getNew() == getDirtyResource().getDescription())
				return;
		}
		scheduleUpdateEditorJob(event);
	}

	private volatile UpdateEditorStateJob updateEditorStateJob;
	
	public void scheduleUpdateEditorJob(final IResourceDescription.Event event) {
		UpdateEditorStateJob job = updateEditorStateJob;
		if (job == null) {
			job = createUpdateEditorJob();
			updateEditorStateJob = job;
		}
		job.scheduleFor(event); 
	}
	
	/**
	 * @since 2.7
	 */
	public void waitForUpdateEditorJob() throws InterruptedException {
		if(updateEditorStateJob != null)
			updateEditorStateJob.join();
	}
	
	/**
	 * @since 2.9
	 * @noreference This method is not intended to be referenced by clients. Just for testing
	 */
	public UpdateEditorStateJob getUpdateEditorStateJob() {
		return updateEditorStateJob;
	}

	protected UpdateEditorStateJob createUpdateEditorJob() {
		// default is sequential execution to ensure a minimum number of
		// spawned worker threads
		return new UpdateEditorStateJob(SCHEDULING_RULE);
	}
	
	/**
	 * @since 2.7
	 */
	public void announceDirtyState(XtextResource resource) {
		if (resource == null || !dirtyResource.isInitialized())
			return;
		ClientAwareDirtyResource clientAwareResource = delegatingClientAwareResource;
		if (state != State.CLEAN || ((!resource.isTrackingModification() || resource.isModified()) && clientAwareResource.isDirty() && dirtyStateManager.manageDirtyState(clientAwareResource))) {
			synchronized (dirtyStateManager) {
				Manager resourceDescriptionManager = getResourceDescriptionManagerIfOwnLanguage(resource);
				if (resourceDescriptionManager != null) {
					final IResourceDescription newDescription = resourceDescriptionManager.getResourceDescription(resource);
					if (state == State.SHOULD_UPDATE || haveEObjectDescriptionsChanged(newDescription, resourceDescriptionManager)) {
						if(state == State.SHOULD_UPDATE) {
							if(clientAwareResource.isDirty())
								state = State.DIRTY;
							else 
								state = State.CLEAN;
						}
						dirtyResource.copyState(newDescription);
						if (resoureStorageFacade != null && (resource instanceof StorageAwareResource)) {
							try {
								StorageAwareResource storageAwareResource = (StorageAwareResource) resource;
								class MyByteArrayOutputStream extends ByteArrayOutputStream {
									@Override
									public synchronized byte[] toByteArray() {
										return buf;
									}
									public int length() { 
										return count;
									}
								}
								final MyByteArrayOutputStream bout = new MyByteArrayOutputStream();
								ResourceStorageWritable resourceOutputStream = resoureStorageFacade.createResourceStorageWritable(bout);
								resourceOutputStream.writeResource(storageAwareResource);
								dirtyResource.setResourceStorageLoadableProvider(new Provider<ResourceStorageLoadable>() {
									@Override
									public ResourceStorageLoadable get() {
										return resoureStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray(), 0 , bout.length()));
									}
								});
							} catch(IOException e) {
								// something went wrong when writing the resource - stream's content is bogus and not attached to the dirty resource info
								LOG.warn("Cannot persist storage for " + resource.getURI(), e);
							}
						}
						dirtyStateManager.announceDirtyStateChanged(clientAwareResource);
					}
				}
			}
		}
	}
	
	/**
	 * @since 2.7 this should no longer be called.
	 */
	public void modelChanged(XtextResource resource) {
		throw new IllegalStateException("DirtyStateEditorSupport should no longer be called as an IXtextModelListener");
	}
	
	/**
	 * Only for testing
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.7
	 */
	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
	}
	
	/**
	 * @since 2.7
	 */
	protected IResourceDescription.Manager getResourceDescriptionManager(URI resourceURI) {
		return resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI).get(DirtyStateResourceDescription.Manager.class);
	}

	/**
	 * @since 2.8
	 */
	protected IResourceDescription.Manager getResourceDescriptionManagerIfOwnLanguage(XtextResource resource) {
		IResourceServiceProvider rsp = resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
		if (rsp == null)
			return null;
		String uriLanguageName = rsp.get(LanguageInfo.class).getLanguageName();
		String resourceLanguageName = resource.getLanguageName();
		if (!uriLanguageName.equals(resourceLanguageName))
			return null;
		return getResourceDescriptionManager(resource.getURI());
	}

	/**
	 * @deprecated Use {@link #haveEObjectDescriptionsChanged(IResourceDescription, org.eclipse.xtext.resource.IResourceDescription.Manager)}.
	 */
	@Deprecated
	public boolean haveEObjectDescriptionsChanged(final IResourceDescription newDescription) {
		return haveEObjectDescriptionsChanged(newDescription, getResourceDescriptionManager(newDescription.getURI()));
	}

	/**
	 * @since 2.3
	 */
	public boolean haveEObjectDescriptionsChanged(final IResourceDescription newDescription, IResourceDescription.Manager resourceDescriptionManager) {
		boolean haveEObjectDescriptionsChanged = resourceDescriptionManager.createDelta(dirtyResource.getDescription(), newDescription).haveEObjectDescriptionsChanged();
		return haveEObjectDescriptionsChanged;
	}

	protected Collection<Resource> collectAffectedResources(XtextResource resource, IResourceDescription.Event event) {
		List<Resource> result = Lists.newArrayListWithExpectedSize(4);
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			processDelta(delta, resource, result);
		}
		return result;
	}
	
	/**
	 * @since 2.8
	 */
	protected void processDelta(IResourceDescription.Delta delta, Resource context, List<Resource> result) {
		ResourceSet resourceSet = context.getResourceSet();
		Resource resourceInResourceSet = resourceSet.getResource(delta.getUri(), false);
		if(resourceInResourceSet != null && resourceInResourceSet != context) {
			result.add(resourceInResourceSet);
		}
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
		return state == State.DIRTY;
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
