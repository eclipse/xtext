package org.eclipse.xtext.ui.compare;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.ResourceNode;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.ui.team.AbstractTeamHandler;
import org.eclipse.emf.compare.util.EclipseModelUtils;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.history.IFileHistory;
import org.eclipse.team.core.history.IFileHistoryProvider;
import org.eclipse.team.core.history.IFileRevision;
import org.eclipse.team.internal.ui.history.FileRevisionTypedElement;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * Slightly modified version of o.e.emf.compare.ui.internal.RevisionComparisonHandler required to support the resolving
 * of classpath based uris e.g. classpath:/org/eclipse/xtext/Xtext.ecore.
 * 
 * @author Michael Clay
 * @see XtextResourceSet
 * @see org.eclipse.xtext.resource.IClasspathUriResolver
 */
@SuppressWarnings("restriction")
public class XtextTeamHandler extends AbstractTeamHandler {
	@Inject
	protected IResourceSetProvider resourceSetProvider;
	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	/** This will be set to true if the left resource cannot be loaded. */
	private boolean leftIsRemote;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ui.team.AbstractTeamHandler#isLeftRemote()
	 */
	@Override
	public boolean isLeftRemote() {
		return leftIsRemote;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ui.team.AbstractTeamHandler#loadResources(org.eclipse.compare.structuremergeviewer.ICompareInput)
	 */
	@Override
	public boolean loadResources(ICompareInput input) throws IOException, CoreException {
		if (canHandle(input)) {
			leftIsRemote = false;
			leftResource = loadLeftResource(input);
			rightResource = loadRightResource(input);
			ancestorResource = loadAncestorResource(input);
			return true;
		}
		return false;
	}

	protected boolean canHandle(ICompareInput input) {
		if (input == null || (input.getLeft() == null && input.getRight() == null)) {
			return false;
		}
		boolean rightSideIsFileRevision = input.getRight() instanceof FileRevisionTypedElement;
		boolean isValidRightSide = isValidElement(input.getLeft());
		boolean isValidLeftSide = isValidElement(input.getRight());
		return rightSideIsFileRevision && (isValidLeftSide && isValidRightSide);
	}

	protected boolean isValidElement(ITypedElement typedElement) {
		return (typedElement == null || fileExtensionProvider.isValid(typedElement.getType()));
	}

	protected Resource loadAncestorResource(ICompareInput input) throws CoreException {
		Resource ancestorResource = null;
		ITypedElement ancestor = input.getAncestor();
		ResourceSet ancestorResourceSet = createResourceSet(input, ancestor);
		if (ancestor != null) {
			IFileRevision ancestorRevision = ((FileRevisionTypedElement) ancestor).getFileRevision();
			try {
				EObject eObject = ModelUtils.load(((IStreamContentAccessor) ancestor).getContents(),
						ancestor.getName(), ancestorResourceSet);
				if (eObject != null) {
					ancestorResource = eObject.eResource();
				}
				ancestorResourceSet.setURIConverter(new RevisionedURIConverter(ancestorRevision));
			} catch (final IOException e) {
				// Couldn't load ancestor resource, create an empty one
				ancestorResource = ancestorResourceSet.createResource(URI.createURI(ancestor.getName()));
			}
		}
		return ancestorResource;
	}

	protected Resource loadRightResource(ICompareInput input) throws CoreException {
		Resource rightResource = null;
		ITypedElement right = input.getRight();
		ResourceSet rightResourceSet = createResourceSet(input, right);
		IFileRevision rightRevision = ((FileRevisionTypedElement) right).getFileRevision();
		try {
			EObject eObject = ModelUtils.load(((IStreamContentAccessor) right).getContents(), right.getName(),
					rightResourceSet);
			if (eObject != null) {
				rightResource = eObject.eResource();
			}
			rightResourceSet.setURIConverter(new RevisionedURIConverter(rightRevision));
		} catch (final IOException e) {
		}
		if (rightResource == null) {
			// We couldn't load the remote resource. Considers it has been added to the repository
			rightResource = rightResourceSet.createResource(URI.createURI(right.getName()));
			// Set the left as remote to disable merge facilities
			leftIsRemote = true;
		}
		return rightResource;
	}

	protected Resource loadLeftResource(ICompareInput input) throws CoreException {
		Resource leftResource = null;
		ITypedElement left = input.getLeft();
		ResourceSet leftResourceSet = createResourceSet(input, left);
		if (left instanceof FileRevisionTypedElement) {
			try {
				EObject eObject = ModelUtils.load(((IStreamContentAccessor) left).getContents(), left.getName(),
						leftResourceSet);
				if (eObject != null) {
					leftResource = eObject.eResource();
				}
				leftResourceSet.setURIConverter(new RevisionedURIConverter(((FileRevisionTypedElement) left)
						.getFileRevision()));
			} catch (final IOException e) {
			}
			if (leftResource == null) {
				// We couldn't load the resource. Considers it has been deleted
				leftResource = leftResourceSet.createResource(URI.createURI(left.getName()));
				// Set the left as remote to disable merge facilities
				leftIsRemote = true;
			}
		} else if (((ResourceNode) left).getResource().isAccessible()) {
			try {
				leftResource = EclipseModelUtils.load(((ResourceNode) left).getResource().getFullPath(),
						leftResourceSet).eResource();
			} catch (IOException e) {
				leftResource = leftResourceSet.createResource(URI.createURI(left.getName()));
				leftIsRemote = true;
			}
		} else {
			leftResource = leftResourceSet.createResource(URI.createPlatformResourceURI(((ResourceNode) left)
					.getResource().getFullPath().toOSString(), true));
			// resource has been deleted. We set it as "remote" to disable merge facilities
			leftIsRemote = true;
		}
		return leftResource;
	}

	protected ResourceSet createResourceSet(ICompareInput input, ITypedElement typedElement) {
		IResource resource = null;
		if (typedElement instanceof ResourceNode) {
			resource = ((ResourceNode) typedElement).getResource();
		} else if (typedElement instanceof FileRevisionTypedElement) {
			FileRevisionTypedElement fileRevisionTypedElement = (FileRevisionTypedElement) typedElement;
			IFileRevision fileRevision = fileRevisionTypedElement.getFileRevision();
			if (fileRevision.getURI() != null) {
				IPath path = URIUtil.toPath(fileRevision.getURI());
				String segment = (path != null && path.segmentCount() > 0) ? path.segment(0) : null;
				resource = null != segment ? getWorkspaceRoot().findMember(segment) : null;
			}
		}
		return resourceSetProvider.get(null != resource ? resource.getProject() : null);
	}

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	/* (non-javadoc) most of the behavior here has been copied from o.e.emf.compare.ui.intenal.RevisionComparisonHandler.RevisionedURIConverter */
	private class RevisionedURIConverter extends ExtensibleURIConverterImpl {
		/** The revision of the base model. This revision's timestamp will be used to resolve proxies. */
		private final IFileRevision baseRevision;

		/**
		 * This default constructor will add our own URI Handler to the top of the handlers list.
		 * 
		 * @param revision
		 *            Revision of the base model.
		 */
		public RevisionedURIConverter(IFileRevision revision) {
			super();
			baseRevision = revision;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.ecore.resource.URIConverter#createInputStream(org.eclipse.emf.common.util.URI)
		 */
		@Override
		public InputStream createInputStream(URI uri) throws IOException {
			InputStream stream = null;
			if (uri.isPlatformPlugin() || uri.toString().matches("(\\.\\./)+?plugins/.*")) { //$NON-NLS-1$
				stream = super.createInputStream(uri);
			} else {
				try {
					// We'll have to change the EMF URI to find the IFile it points to
					URI deresolvedURI = uri;

					final IStorage storage = baseRevision.getStorage(null);
					if (uri.isRelative()) {
						// Current revision, yet the proxy could point to a file that has changed since.
						if (storage instanceof IFile) {
							final IFile file = (IFile) storage;
							deresolvedURI = uri.resolve(URI.createURI(file.getLocationURI().toString()));
						} else {
							final IResource stateFile = getWorkspaceRoot().findMember(storage.getFullPath());
							deresolvedURI = uri.resolve(URI.createURI(stateFile.getLocationURI().toString()));
						}
					}
					deresolvedURI = deresolvedURI.deresolve(URI.createURI(getWorkspaceRoot().getLocationURI()
							.toString() + '/'));

					final IResource targetFile = getWorkspaceRoot().findMember(
							new Path(deresolvedURI.trimFragment().toString()));

					if (targetFile != null) {
						stream = openRevisionStream(targetFile);
					}
				} catch (final CoreException e) {
					stream = super.createInputStream(uri);
				}
			}
			return stream;
		}

		protected IWorkspaceRoot getWorkspaceRoot() {
			return EcorePlugin.getWorkspaceRoot();
		}

		/**
		 * This will open an InputStream on the first revision of <code>target</code> which timeStamp is inferior to
		 * that of {@link #baseRevision}.
		 * 
		 * @param target
		 *            The resource we seek a revision of.
		 * @return InputStream on the first revision of <code>target</code> which timeStamp is inferior to that of
		 *         {@link #baseRevision}.
		 */
		private InputStream openRevisionStream(IResource target) throws CoreException {
			final IProject project = target.getProject();
			final RepositoryProvider provider = RepositoryProvider.getProvider(project);
			InputStream stream = null;
			if (provider != null) {
				final IFileHistoryProvider historyProvider = provider.getFileHistoryProvider();
				final IFileHistory history = historyProvider.getFileHistoryFor(target, IFileHistoryProvider.NONE,
						new NullProgressMonitor());

				if (history != null) {
					IFileRevision soughtRevision = null;
					for (final IFileRevision revision : history.getFileRevisions()) {
						if (revision.getTimestamp() <= baseRevision.getTimestamp()) {
							soughtRevision = revision;
							break;
						}
					}
					if (soughtRevision != null) {
						stream = soughtRevision.getStorage(new NullProgressMonitor()).getContents();
					}
				}
			}
			if (stream == null) {
				IFileState soughtState = null;
				// This project is not connected to a repository. Search through local history
				for (final IFileState state : ((IFile) target).getHistory(new NullProgressMonitor())) {
					if (state.getModificationTime() <= baseRevision.getTimestamp()) {
						soughtState = state;
						break;
					}
				}
				if (soughtState != null) {
					stream = soughtState.getContents();
				} else {
					stream = ((IFile) target).getContents();
				}
			}
			return stream;
		}
	}

}
