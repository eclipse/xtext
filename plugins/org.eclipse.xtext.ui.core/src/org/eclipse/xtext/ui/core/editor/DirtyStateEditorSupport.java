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
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateEditorSupport implements IXtextModelListener, IStateChangeEventBroker.IStateChangeEventListener, VerifyListener {
	
	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IStateChangeEventBroker stateChangeEventBroker;
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected static class EditorBasedDirtyResource implements IDirtyResource {
		
		private final XtextEditor editor;
		private final URI uri;

		protected EditorBasedDirtyResource(XtextEditor editor) {
			this.editor = editor;
			uri = editor.getDocument().readOnly(new IUnitOfWork<URI, XtextResource>(){
				public URI exec(XtextResource state) throws Exception {
					return state.getURI();
				}
			});
		}
		
		public URI getURI() {
			return uri;
		}

		public Iterable<String> getImportedNames() {
			// TODO implement me
			return null;
		}

		public Iterable<IEObjectDescription> getExportedObjects() {
			// TODO implement me
			return null;
		}

		public String getContents() {
			return editor.getDocument().get();
		}
	}

	private XtextEditor editor;
	
	private boolean isDirty;
	
	private IDirtyResource dirtyResource;
	
	public void initializeDirtyStateSupport(XtextEditor editor) {
		if (this.editor != null)
			throw new IllegalStateException("editor was already assigned");
		this.editor = editor;
		this.isDirty = false;
		IXtextDocument document = editor.getDocument();
		document.addModelListener(this);
		stateChangeEventBroker.addListener(this);
		dirtyResource = createDirtyResource(editor);
		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		widget.addVerifyListener(this);
	}
	
	public void verifyText(VerifyEvent e) {
		if (isDirty || !e.doit)
			return;
	
		if (!dirtyStateManager.manageDirtyState(dirtyResource)) {
			if (!showConcurrentEditingWarning()) {
				e.doit = false;
				dirtyStateManager.discardDirtyState(dirtyResource);
				return;
			}
		}
		isDirty = true;
	}
	
	public boolean isEditingPossible(XtextEditor editor) {
		if (this.editor != editor)
			throw new IllegalStateException("has been configured with another editor");
		if (isDirty)
			return true;
	
		if (!dirtyStateManager.manageDirtyState(dirtyResource)) {
			if (!showConcurrentEditingWarning()) {
				dirtyStateManager.discardDirtyState(dirtyResource);
				return false;
			}
		}
		isDirty = true;
		return true;
	}

	protected boolean showConcurrentEditingWarning() {
		String title = "Resource was edited concurrently.";
		String message = "The resource is currently edited in another editor. Do you want to continue?";
		return MessageDialog.openQuestion(editor.getEditorSite().getShell(), title, message);
	}

	protected IDirtyResource createDirtyResource(XtextEditor editor) {
		return new EditorBasedDirtyResource(editor);
	}
	
	public void removeDirtyStateSupport(XtextEditor editor) {
		if (this.editor != editor)
			throw new IllegalStateException("has been configured with another editor");
		stateChangeEventBroker.removeListener(this);
		dirtyStateManager.discardDirtyState(dirtyResource);
		ISourceViewer sourceViewer = editor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		widget.removeVerifyListener(this);
		this.editor = null;
	}
	
	public void markEditorClean(XtextEditor editor) {
		if (this.editor != editor)
			throw new IllegalStateException("has been configured with another editor");
		dirtyStateManager.discardDirtyState(dirtyResource);
		isDirty = false;
	}
	
	public void onStateChanged(IStateChangeEventBroker sender, final ImmutableCollection<URI> affectedURIs) {
		final IXtextDocument document = editor.getDocument();
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
		// TODO: should this be run in a job? (see ResourceAwareXtextDocumentProvider)
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
		if (isDirty || dirtyStateManager.manageDirtyState(dirtyResource))
			dirtyStateManager.announceDirtyStateChanged(dirtyResource);
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
}
