package org.eclipse.xtext.common.types.shared.jdt38;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OriginalEditorSelector implements IEditorAssociationOverride {

	private static final Logger logger = Logger. getLogger(OriginalEditorSelector.class);
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;
	
	@Inject
	private IWorkbench workbench;
	
	public IEditorDescriptor[] overrideEditors(IEditorInput editorInput,
			IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		IEditorDescriptor xbaseEditor = findXbaseEditor(editorInput);
		if (xbaseEditor != null) {
			List<IEditorDescriptor> result = Lists.asList(xbaseEditor, editorDescriptors);
			return (IEditorDescriptor[]) result.toArray(new IEditorDescriptor[result.size()]);
		}
		return editorDescriptors;
	}

	public IEditorDescriptor[] overrideEditors(String fileName,
			IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		return editorDescriptors;
	}

	public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput,
			IContentType contentType, IEditorDescriptor editorDescriptor) {
		IEditorDescriptor result = findXbaseEditor(editorInput);
		if (result != null)
			return result;
		return editorDescriptor;
	}

	public IEditorDescriptor overrideDefaultEditor(String fileName,
			IContentType contentType, IEditorDescriptor editorDescriptor) {
		return editorDescriptor;
	}
	
	public IEditorDescriptor findXbaseEditor(IEditorInput editorInput) {
		try {
			IResource resource = ResourceUtil.getResource(editorInput);
			if (resource == null)
				return null;
			if (resource.getPersistentProperty(IDE.EDITOR_KEY) != null)
				return null;
			// TODO stay in same editor if local navigation
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
						XtextEditorInfo editorInfo = serviceProvider.get(XtextEditorInfo.class);
						if (editorInfo != null) {
							IEditorRegistry editorRegistry = workbench.getEditorRegistry();
							IEditorDescriptor result = editorRegistry.findEditor(editorInfo.getEditorId());
							// null is ok
							return result;
						}
					}
				}
			}
		} catch(Exception e) {
			logger.debug(e.getMessage(), e);
			// ignore
		}
		return null;
	}

}
