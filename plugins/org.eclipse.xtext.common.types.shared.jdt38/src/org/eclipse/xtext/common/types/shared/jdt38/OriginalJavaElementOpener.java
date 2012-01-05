/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared.jdt38;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.ui.IJavaElementEditorOpener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OriginalJavaElementOpener implements IJavaElementEditorOpener {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;
	
	public static class EditorHandle implements IJavaElementEditorOpener.IOpenableEditor {

		private final IDerivedMemberAwareEditorOpener opener;
		private final URI sourceResourceURI;
		private final IMember member;
		private final boolean activate;

		public EditorHandle(IDerivedMemberAwareEditorOpener opener,
				URI sourceResourceURI, IMember member, boolean activate) {
			this.opener = opener;
			this.sourceResourceURI = sourceResourceURI;
			this.member = member;
			this.activate = activate;
		}

		public IEditorPart open() throws PartInitException {
			return opener.open(sourceResourceURI, member, activate);
		}

		public void reveal() {
			opener.open(sourceResourceURI, member, true);
			return;
		}
		
	}
	
	public IJavaElementEditorOpener.IOpenableEditor openInEditor(IJavaElement element, boolean activate, boolean reveal) {
		return tryCreateHandle(element, activate);
	}

	/**
	 * @param element
	 * @param activate
	 * @return
	 */
	private IJavaElementEditorOpener.IOpenableEditor tryCreateHandle(
			IJavaElement element, boolean activate) {
		if (element instanceof IMember) {
			try {
				// TODO stay in same editor if local navigation
				IResource resource = element.getResource();
				if (resource instanceof IFile) {
					IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers((IFile) resource);
					if (markers.length != 1)
						return null;
					IMarker marker = markers[0];
					String source = derivedResourceMarkers.getSource(marker);
					if (source != null) {
						URI sourceResourceURI = URI.createURI(source).trimFragment();
						IResourceServiceProvider serviceProvider = resourceServiceProviderRegistry
								.getResourceServiceProvider(sourceResourceURI);
						if (serviceProvider != null) {
							IDerivedMemberAwareEditorOpener opener = serviceProvider.get(IDerivedMemberAwareEditorOpener.class);
							if (opener != null) {
								return new EditorHandle(opener, sourceResourceURI, (IMember) element, activate);
							}
						}
					}
				}
			} catch(CoreException e) { 
				// ignore
			}
		}
		return null;
	}

	public IJavaElementEditorOpener.IOpenableEditor revealInEditor(IEditorPart part, IJavaElement element) {
		if (part instanceof XtextEditor) {
			return tryCreateHandle(element, true);
		}
		return null;
	}
	
	public IOpenableEditor revealInEditor(IEditorPart part, int offset,
			int length) {
		// TODO implement as soon as trace information is available.
		return null;
	}
}
