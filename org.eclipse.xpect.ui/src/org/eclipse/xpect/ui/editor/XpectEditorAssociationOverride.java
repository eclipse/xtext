package org.eclipse.xpect.ui.editor;

import java.util.List;

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.eclipse.xpect.ui.editor.ContentTypeHelper.XpectContentType;
import org.eclipse.xpect.ui.internal.XpectActivator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class XpectEditorAssociationOverride implements IEditorAssociationOverride {

	@Inject
	private ContentTypeHelper contentTypeHelper;

	protected XpectContentType getContentType(IEditorInput input) {
		if (input instanceof IFileEditorInput)
			return contentTypeHelper.getContentType(((IFileEditorInput) input).getFile());
		return null;
	}

	@Override
	public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput, IContentType contentType, IEditorDescriptor editorDescriptor) {
		XpectContentType type = getContentType(editorInput);
		switch (type) {
		case XPECT:
			IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
			return registry.findEditor(XpectActivator.ORG_ECLIPSE_XPECT_XPECT);
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
		XpectContentType type = getContentType(editorInput);
		switch (type) {
		case TEXT:
		case XPECT:
			IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
			IEditorDescriptor xpectEditor = registry.findEditor(XpectActivator.ORG_ECLIPSE_XPECT_XPECT);
			List<IEditorDescriptor> editors = Lists.newArrayList(editorDescriptors);
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
