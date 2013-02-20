package org.eclipse.xtext.common.types.shared.jdt38;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.xbase.ui.editor.StacktraceBasedEditorDecider;
import org.eclipse.xtext.xbase.ui.editor.StacktraceBasedEditorDecider.Decision;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 */
@SuppressWarnings("restriction")
public class OriginalEditorSelector implements IEditorAssociationOverride {

	private static final Logger logger = Logger. getLogger(OriginalEditorSelector.class);
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	@Inject
	private ITraceInformation traceInformation;
	
	@Inject
	private IWorkbench workbench;
	
	@Inject
	private StacktraceBasedEditorDecider decisions;
	
	@Inject
	private DebugPluginListener debugPluginListener;
	
	public IEditorDescriptor[] overrideEditors(IEditorInput editorInput, IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		IEditorDescriptor xbaseEditor = findXbaseEditor(editorInput);
		if (xbaseEditor != null) {
			List<IEditorDescriptor> result = Lists.asList(xbaseEditor, editorDescriptors);
			return (IEditorDescriptor[]) result.toArray(new IEditorDescriptor[result.size()]);
		}
		return editorDescriptors;
	}

	public IEditorDescriptor[] overrideEditors(String fileName, IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		IEditorDescriptor xbaseEditor = findXbaseEditor(fileName);
		if (xbaseEditor != null) {
			List<IEditorDescriptor> result = Lists.asList(xbaseEditor, editorDescriptors);
			return (IEditorDescriptor[]) result.toArray(new IEditorDescriptor[result.size()]);
		}
		return editorDescriptors;
	}

	public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput, IContentType contentType, IEditorDescriptor editorDescriptor) {
		IEditorDescriptor result = findXbaseEditor(editorInput);
		if (result != null)
			return result;
		return editorDescriptor;
	}

	public IEditorDescriptor overrideDefaultEditor(String fileName, IContentType contentType, IEditorDescriptor editorDescriptor) {
		IEditorDescriptor result = findXbaseEditor(fileName);
		if (result != null)
			return result;
		return editorDescriptor;
	}
	
	public IEditorDescriptor findXbaseEditor(IEditorInput editorInput) {
		try {
			IFile resource = ResourceUtil.getFile(editorInput);
			if (resource == null)
				return null;
			String favoriteEditor = resource.getPersistentProperty(IDE.EDITOR_KEY);
			if (favoriteEditor != null)
				return null;
			// TODO stay in same editor if local navigation
			Decision decision = decisions.decideAccordingToCaller();
			if (decision == Decision.FORCE_JAVA) {
				return null;
			}
			ITrace traceToSource = traceInformation.getTraceToSource(resource);
			if (traceToSource != null) {
				Iterator<ILocationInResource> sourceInformationIterator = traceToSource.getAllAssociatedLocations().iterator();
				if (sourceInformationIterator.hasNext()) {
					URI uri = sourceInformationIterator.next().getResourceURI();
					return getXtextEditor(uri);
				}
			}
		} catch(Exception e) {
			logger.debug(e.getMessage(), e);
			// ignore
		}
		return null;
	}
	
	protected IEditorDescriptor findXbaseEditor(String name) {
		String file = debugPluginListener.findXtextSourceFileNameForClassFile(name);
		if (file == null)
			return null;
		return getXtextEditor(URI.createURI(file));
	}

	protected IEditorDescriptor getXtextEditor(URI uri) {
		IResourceServiceProvider serviceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
		if (serviceProvider != null) {
			XtextEditorInfo editorInfo = serviceProvider.get(XtextEditorInfo.class);
			if (editorInfo != null) {
				IEditorRegistry editorRegistry = workbench.getEditorRegistry();
				IEditorDescriptor result = editorRegistry.findEditor(editorInfo.getEditorId());
				return result; // null is ok
			}
		}
		return null;
	}

}
