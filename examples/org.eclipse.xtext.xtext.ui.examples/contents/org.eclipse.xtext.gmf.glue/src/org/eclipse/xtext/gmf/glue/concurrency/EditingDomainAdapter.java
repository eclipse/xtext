package org.eclipse.xtext.gmf.glue.concurrency;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Lifecycle;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.shared.Access;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class EditingDomainAdapter extends AdapterImpl implements ResourceSetListener,
		TransactionalEditingDomainListener {

	public static class Factory extends AdapterFactoryImpl {
		@Override
		public boolean isFactoryForType(Object type) {
			return super.isFactoryForType(type == EditingDomainAdapter.class);
		}

		@Override
		protected Object resolve(Object object, Object type) {
			if (object instanceof TransactionalEditingDomain) {
				return adapt(((TransactionalEditingDomain) object).getResourceSet(), type);
			}
			return super.resolve(object, type);
		}

		@Override
		protected Adapter createAdapter(Notifier target) {
			if (target instanceof ResourceSet) {
				return new EditingDomainAdapter(TransactionUtil.getEditingDomain(target));
			} else {
				return null;
			}
		}
	}

	private final TransactionalEditingDomain editingDomain;

	private IDirtyStateManager dirtyStateManager;

	private Map<URI, IDirtyResource> uri2dirtyResource;

	private static final Logger LOG = Logger.getLogger(EditingDomainAdapter.class);

	protected EditingDomainAdapter(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
		editingDomain.addResourceSetListener(this);
		dirtyStateManager = Access.getIDirtyStateManager().get();
		uri2dirtyResource = Maps.newHashMap();
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		lifecycle.addTransactionalEditingDomainListener(this);
	}

	public NotificationFilter getFilter() {
		return null;
	}

	public boolean isAggregatePrecommitListener() {
		return true;
	}

	public boolean isPostcommitOnly() {
		return false;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public void resourceSetChanged(ResourceSetChangeEvent event) {
		List<URI> remainingURIs = Lists.newArrayList(uri2dirtyResource.keySet());
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if (resource instanceof XtextResource) {
				XtextResource xtextResource = (XtextResource) resource;
				remainingURIs.remove(xtextResource.getURI());
				IDirtyResource dirtyResource = uri2dirtyResource.get(xtextResource.getURI());
				if (xtextResource.isModified()) {
					if (dirtyResource == null) {
						createAndRegisterDirtyState(xtextResource);
					}
				} else {
					if (dirtyResource != null) {
						uri2dirtyResource.remove(xtextResource.getURI());
						dirtyStateManager.discardDirtyState(dirtyResource);
					}
				}
			}
		}
		// removed resources
		for (URI remainingURI : remainingURIs) {
			IDirtyResource dirtyResource = uri2dirtyResource.get(remainingURI);
			dirtyStateManager.discardDirtyState(dirtyResource);
			uri2dirtyResource.remove(remainingURI);
		}
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		List<XtextResource> resourcesWithConflicts = null;
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			if (resource instanceof XtextResource && resource.isModified()) {
				XtextResource xtextResource = (XtextResource) resource;
				IDirtyResource dirtyResource = uri2dirtyResource.get(xtextResource.getURI());
				if (dirtyResource == null) {
					if (!createAndRegisterDirtyState(xtextResource)) {
						if (resourcesWithConflicts == null) {
							resourcesWithConflicts = Lists.newArrayList();
						}
						resourcesWithConflicts.add(xtextResource);
					}
				}
			}
		}
		if (resourcesWithConflicts != null) {
			if (queryApplyChanges()) {
				for (XtextResource resourceWithConflicts : resourcesWithConflicts) {
					try {
						IDirtyResource dirtyResource = createDirtyResource(resourceWithConflicts);
						// assert resource is serializable
						dirtyResource.getContents();
						dirtyStateManager.announceDirtyStateChanged(dirtyResource);
					} catch (Exception exc) {
						LOG.error("Error serializing resource", exc);
					}
				}
			} else {
				throw new RollbackException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Transaction aborted by user"));
			}
		}
		return null;
	}

	protected boolean createAndRegisterDirtyState(XtextResource xtextResource) {
		IDirtyResource dirtyResource = createDirtyResource(xtextResource);
		if (dirtyResource == null) {
			return true;
		} else {
			boolean isSuccess = dirtyStateManager.manageDirtyState(dirtyResource);
			if (isSuccess) {
				uri2dirtyResource.put(xtextResource.getURI(), dirtyResource);
			}
			return isSuccess;
		}
	}

	protected IDirtyResource createDirtyResource(XtextResource xtextResource) {
		IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(xtextResource.getURI());
		if (resourceServiceProvider == null) {
			return null;
		}
		return new SimpleDirtyResource(xtextResource, resourceServiceProvider);
	}

	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		dispose();
	}

	public void dispose() {
		if (uri2dirtyResource != null) {
			for (IDirtyResource dirtyResource : uri2dirtyResource.values()) {
				dirtyStateManager.discardDirtyState(dirtyResource);
			}
			uri2dirtyResource = null;
		}
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		if (lifecycle != null) {
			lifecycle.removeTransactionalEditingDomainListener(this);
		}
		editingDomain.removeResourceSetListener(this);
	}

	protected boolean queryApplyChanges() {
		DialogPrompter dialogPrompter = new DialogPrompter();
		Display.getDefault().syncExec(dialogPrompter);
		boolean yesResult = dialogPrompter.isYesResult();
		return yesResult;
	}

	protected class DialogPrompter implements Runnable {

		private boolean isYesResult;

		public boolean isYesResult() {
			return isYesResult;
		}

		public void run() {
			Shell shell = Display.getDefault().getActiveShell();
			isYesResult = MessageDialog.open(MessageDialog.QUESTION, shell, "Concurrent Modification",
					"Other editors have a modified version of models you are going to change.\n"
							+ "If apply your changes you are loosing the possibility to save the others.\n"
							+ "Apply changes anyway?", SWT.NONE);
		}
	}

	public void transactionClosed(TransactionalEditingDomainEvent event) {
		// do nothing
	}

	public void transactionClosing(TransactionalEditingDomainEvent event) {
		// do nothing
	}

	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		// do nothing
	}

	public void transactionStarted(TransactionalEditingDomainEvent event) {
		// do nothing
	}

	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// do nothing
	}

}
