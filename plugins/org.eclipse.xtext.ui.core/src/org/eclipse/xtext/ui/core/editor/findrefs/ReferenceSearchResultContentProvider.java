package org.eclipse.xtext.ui.core.editor.findrefs;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ReferenceSearchResultContentProvider implements ITreeContentProvider {

	@Inject
	private IResourceDescriptions resourceDescriptions;

	private List<ReferenceSearchViewTreeNode> rootElements;

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ReferenceSearchViewTreeNode) {
			return Iterables.newArray(((ReferenceSearchViewTreeNode) parentElement).getChildren(), ReferenceSearchViewTreeNode.class);
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return ((ReferenceSearchViewTreeNode) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return !((ReferenceSearchViewTreeNode) element).getChildren().isEmpty();
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (rootElements == null) {
			return new Object[0];
		}
		return Iterables.newArray(rootElements, ReferenceSearchViewTreeNode.class);
	}

	public void dispose() {
		rootElements = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof ReferenceSearchResult) {
			if (rootElements != null) {
				rootElements.clear();
			}
			for (IReferenceDescription referenceDescription : ((ReferenceSearchResult) newInput)
					.getMatchingReferences()) {
				URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
				final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
						: containerEObjectURI;
				IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
						.trimFragment());
				if (resourceDescription != null) {
					ReferenceSearchViewTreeNode resourceNode = resourceNode(resourceDescription);
					for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
						if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
							new ReferenceSearchViewTreeNode(resourceNode, eObjectURI, eObjectDescription);
						}
					}
				}
			}
			viewer.refresh();
		}
	}

	private ReferenceSearchViewTreeNode resourceNode(IResourceDescription resourceDescription) {
		if (rootElements == null) {
			rootElements = Lists.newArrayList();
		}
		for (ReferenceSearchViewTreeNode node : rootElements) {
			if (node.getURI().equals(resourceDescription.getURI())) {
				return node;
			}
		}
		ReferenceSearchViewTreeNode node = new ReferenceSearchViewTreeNode(null, resourceDescription.getURI(), resourceDescription);
		rootElements.add(node);
		return node;
	}

}