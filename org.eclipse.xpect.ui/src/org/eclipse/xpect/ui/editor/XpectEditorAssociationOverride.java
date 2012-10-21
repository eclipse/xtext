package org.eclipse.xpect.ui.editor;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.eclipse.xpect.ui.internal.XpectActivator;
import org.eclipse.xpect.ui.util.ContentTypeUtil;
import org.eclipse.xpect.ui.util.ContentTypeUtil.XpectContentType;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class XpectEditorAssociationOverride implements IEditorAssociationOverride {

	@Inject
	private ContentTypeUtil contentTypeHelper;

	private final IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();

	private final IEditorDescriptor xpectEditor = registry.findEditor(XpectActivator.ORG_ECLIPSE_XPECT_XPECT);

	protected IFile getFile(IEditorInput input) {
		if (input instanceof IFileEditorInput)
			return ((IFileEditorInput) input).getFile();
		return null;
	}

	@Override
	public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput, IContentType contentType, IEditorDescriptor editorDescriptor) {
		IFile file = getFile(editorInput);
		XpectContentType type = contentTypeHelper.getContentType(file);
		switch (type) {
		case XPECT:
			if (file != null)
				for (IEditorDescriptor desc : registry.getEditors(file.getName()))
					if (desc.getId().endsWith("withXpect"))
						return desc;
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
		XpectContentType type = contentTypeHelper.getContentType(getFile(editorInput));
		switch (type) {
		case XPECT:
			List<IEditorDescriptor> editors = Lists.newArrayList(editorDescriptors);
			editors.add(xpectEditor);
			return editors.toArray(new IEditorDescriptor[editors.size()]);
		default:
			List<IEditorDescriptor> editors2 = Lists.newArrayList();
			for (IEditorDescriptor desc : editorDescriptors)
				if (!desc.getId().endsWith("withXpect"))
					editors2.add(desc);
			return editors2.toArray(new IEditorDescriptor[editors2.size()]);
		}
	}

	@Override
	public IEditorDescriptor[] overrideEditors(String fileName, IContentType contentType, IEditorDescriptor[] editorDescriptors) {
		return editorDescriptors;
	}

}
