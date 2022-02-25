/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.StatefulResourceDescription;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchResultEvents.Added;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchResultEvents.Reset;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceSearchResultContentProvider implements ITreeContentProvider, ISearchResultListener,
		IResourceDescription.Event.Listener {

	private IResourceDescriptions resourceDescriptions;

	private List<ReferenceSearchViewTreeNode> rootNodes;

	private TreeViewer viewer;

	private List<SearchResultEvent> batchedSearchResultEvents;

	private volatile boolean isUIUpdateScheduled;

	@Inject
	public ReferenceSearchResultContentProvider(IResourceDescriptions resourceDescriptions) {
		batchedSearchResultEvents = new ArrayList<>();
		this.resourceDescriptions = resourceDescriptions;
		attachListenerToIndex(resourceDescriptions);
	}

	/**
	 * @since 2.22
	 */
	protected void attachListenerToIndex(IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
			((IResourceDescription.Event.Source) resourceDescriptions).addListener(this);
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ReferenceSearchViewTreeNode) {
			return ((ReferenceSearchViewTreeNode) parentElement).getChildren().toArray(new ReferenceSearchViewTreeNode[0]);
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return ((ReferenceSearchViewTreeNode) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return !((ReferenceSearchViewTreeNode) element).getChildren().isEmpty();
		}
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (rootNodes == null || rootNodes.isEmpty()) {
			return new Object[0];
		}
		return rootNodes.toArray(new ReferenceSearchViewTreeNode[0]);
	}

	@Override
	public void dispose() {
		detachListenerFromIndex();
		rootNodes = null;
		synchronized (batchedSearchResultEvents) {
			batchedSearchResultEvents.clear();
		}
		ITreeContentProvider.super.dispose();
	}

	/**
	 * @since 2.22
	 */
	protected void detachListenerFromIndex() {
		if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
			((IResourceDescription.Event.Source) resourceDescriptions).removeListener(this);
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		synchronized (viewer) {
			if (rootNodes != null) {
				rootNodes.clear();
			}
			if (oldInput instanceof ReferenceSearchResult) {
				((ReferenceSearchResult) oldInput).removeListener(this);
			}
			if (newInput instanceof ReferenceSearchResult && viewer instanceof TreeViewer) {
				((ReferenceSearchResult) newInput).addListener(this);
				this.viewer = (TreeViewer) viewer;
				for (IReferenceDescription referenceDescription : ((ReferenceSearchResult) newInput)
						.getMatchingReferences()) {
					addReference(referenceDescription, false);
				}
			}
		}
	}

	private void addReference(IReferenceDescription referenceDescription, boolean isUpdateViewer) {
		URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
		final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
				: containerEObjectURI;
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
				.trimFragment());
		if (resourceDescription != null) {
			ReferenceSearchViewTreeNode resourceNode = resourceNode(resourceDescription, isUpdateViewer);
			ReferenceSearchViewTreeNode referenceNode = null;
			for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
				if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
					referenceNode = new ReferenceSearchViewTreeNode(resourceNode, referenceDescription,
							eObjectDescription);
					break;
				}
			}
			if (referenceNode == null && resourceNode != null)
				new ReferenceSearchViewTreeNode(resourceNode, referenceDescription, referenceDescription);
		}
	}

	private ReferenceSearchViewTreeNode resourceNode(IResourceDescription resourceDescription, boolean isUpdateViewer) {
		if (rootNodes == null) {
			rootNodes = new ArrayList<>();
		}
		for (ReferenceSearchViewTreeNode node : rootNodes) {
			Object nodeDescription = node.getDescription();
			if (nodeDescription instanceof IResourceDescription) {
				if (((IResourceDescription) nodeDescription).getURI().equals(resourceDescription.getURI())) {
					return node;
				}
			}
		}
		ReferenceSearchViewTreeNode node = new ReferenceSearchViewTreeNode(null, resourceDescription,
				resourceDescription);
		rootNodes.add(node);
		if (isUpdateViewer) {
			viewer.add(viewer.getInput(), node);
		}
		return node;
	}

	@Override
	public void searchResultChanged(final SearchResultEvent e) {
		synchronized (batchedSearchResultEvents) {
			batchedSearchResultEvents.add(e);
		}
		if (!isUIUpdateScheduled) {
			isUIUpdateScheduled = true;
			new UIUpdater().schedule();
		}
	}

	private class UIUpdater extends UIJob {

		public UIUpdater() {
			super(Messages.ReferenceSearchResultContentProvider_label);
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			isUIUpdateScheduled = false;
			List<SearchResultEvent> events;
			synchronized (batchedSearchResultEvents) {
				events = new ArrayList<>(batchedSearchResultEvents);
				batchedSearchResultEvents.clear();
			}
			for (SearchResultEvent event : events) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				if (event instanceof Added) {
					addReference(((Added) event).getReferenceDescription(), true);
				} else if (event instanceof Reset) {
					if (rootNodes != null && !rootNodes.isEmpty()) {
						synchronized (viewer) {
							viewer.remove(viewer.getInput(), rootNodes.toArray());
							rootNodes = null;
						}
					}
				}
			}
			viewer.refresh();
			expandToFirstChild();
			return Status.OK_STATUS;
		}
	}
	

	private void expandToFirstChild() {
		if (rootNodes != null && !rootNodes.isEmpty()){
			ReferenceSearchViewTreeNode[] rootNodesArray = rootNodes.toArray(new ReferenceSearchViewTreeNode[0]);
			//find the top element
			viewer.getComparator().sort(viewer, rootNodesArray);
			
			ReferenceSearchViewTreeNode topElement = rootNodesArray[0];
			Object[] firstChildren = topElement.getChildren().toArray();
			
			if (firstChildren.length > 0) {
				viewer.getComparator().sort(viewer, firstChildren);
				viewer.setSelection(new StructuredSelection(firstChildren[0]), true);
			}
		}
	}

	@Override
	public void descriptionsChanged(final Event event) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (rootNodes != null) {
					for (Delta delta : event.getDeltas()) {
						if (!(delta.getNew() instanceof StatefulResourceDescription)) {
							for (Iterator<ReferenceSearchViewTreeNode> i = rootNodes.iterator(); i.hasNext();) {
								ReferenceSearchViewTreeNode rootNode = i.next();
								if (((IResourceDescription) rootNode.getDescription()).getURI().equals(delta.getUri())) {
									if (delta.getNew() == null) {
										i.remove();
										viewer.remove(rootNode);
										break;
									} else {
										Iterable<IReferenceDescription> newReferenceDescriptions = delta.getNew()
												.getReferenceDescriptions();
										List<ReferenceSearchViewTreeNode> removedReferenceNodes = new ArrayList<>();
										for (ReferenceSearchViewTreeNode referenceNode : rootNode.getChildren()) {
											URI referenceSourceURI = ((IReferenceDescription) referenceNode
													.getDescription()).getSourceEObjectUri();
											if (!Iterables.any(newReferenceDescriptions, input -> input.getSourceEObjectUri().equals(referenceSourceURI))) {
												removedReferenceNodes.add(referenceNode);
											}
										}
										for (ReferenceSearchViewTreeNode removedReferenceNode : removedReferenceNodes) {
											rootNode.removeChild(removedReferenceNode);
										}
										if (rootNode.getChildren().isEmpty()) {
											i.remove();
											viewer.remove(rootNode);
											break;
										} else {
											viewer.remove(rootNode, removedReferenceNodes.toArray());
										}
									}
								}
							}
						}
					}
				}
			}
		});
	}
	
	public void remove (ReferenceSearchViewTreeNode... nodes) {
		for (ReferenceSearchViewTreeNode node : nodes) {
			if (!rootNodes.remove(node)) { // if not top-level node then recurse into children
				rootNodes.forEach(n -> remove(node, n));
			}
		}
	}
	
	/**
	 * @since 2.18
	 */
	protected void remove (ReferenceSearchViewTreeNode toRemove, ReferenceSearchViewTreeNode from) {
		from.removeChild(toRemove);
		from.getChildren().forEach(childNode -> remove(toRemove, childNode));
	}
	
}