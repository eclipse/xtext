package org.xpect.ui.editor;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.xpect.registry.ILanguageInfo;
import org.xpect.ui.XpectPluginActivator;
import org.xpect.ui.util.ContentTypeUtil;
import org.xpect.ui.util.ContentTypeUtil.XpectContentType;
import org.xpect.util.URIDelegationHandler;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XpectEditorAssociationOverride implements IEditorAssociationOverride {

	@Inject
	private ContentTypeUtil contentTypeHelper;

	private final IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();

	@Inject
	private URIDelegationHandler uriHandler;
	private final IEditorDescriptor xpectEditor = registry.findEditor(XpectPluginActivator.XPECT_EDITOR_ID);
	private final IEditorDescriptor xtEditor = registry.findEditor(XpectPluginActivator.XT_EDITOR_ID);

	protected IFile getFile(IEditorInput input) {
		if (input instanceof IFileEditorInput)
			return ((IFileEditorInput) input).getFile();
		return null;
	}

	protected boolean isXtFile(IFile file) {
		String extension = uriHandler.getOriginalFileExtension(file.getName());
		return extension != null && ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(extension) != null;
	}

	@Override
	public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput, IContentType contentType, IEditorDescriptor editorDescriptor) {
		IFile file = getFile(editorInput);
		XpectContentType type = contentTypeHelper.getContentType(file);
		switch (type) {
		case XPECT:
			if (isXtFile(file))
				return xtEditor;
			return xpectEditor;
		default:
			return editorDescriptor;
		}
	}

	@Override
	public IEditorDescriptor overrideDefaultEditor(String fileName, IContentType contentType, IEditorDescriptor editorDescriptor) {
		return editorDescriptor;
	}

	@Override
	public IEditorDescriptor[] overrideEditors(IEditorInput editorInput, IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		IFile file = getFile(editorInput);
		XpectContentType type = contentTypeHelper.getContentType(file);
		switch (type) {
		case XPECT:
			Set<IEditorDescriptor> editors = Sets.newLinkedHashSet();
			Collections.addAll(editors, editorDescriptors);
			String extension = uriHandler.getOriginalFileExtension(file.getName());
			if (extension != null && ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(extension) != null) {
				Collections.addAll(editors, registry.getEditors("*." + extension));
				editors.add(xtEditor);
			}
			editors.add(xpectEditor);
			return editors.toArray(new IEditorDescriptor[editors.size()]);
		default:
			return editorDescriptors;
		}
	}

	@Override
	public IEditorDescriptor[] overrideEditors(String fileName, IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		return editorDescriptors;
	}

}
