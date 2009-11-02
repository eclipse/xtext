package org.eclipse.xtext.ui.core.editor.info;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.core.editor.model.JavaClassPathResourceForIEditorInputFactory;

public class ResourceForResourceWorkingCopyEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {

	@Override
	public Resource createResource(IEditorInput editorInput) {
		if (editorInput instanceof ResourceWorkingCopyFileEditorInput) {
			return createWorkingCopy((ResourceWorkingCopyFileEditorInput) editorInput);
		} else 	{
			return super.createResource(editorInput);
		}
	}

	private Resource createWorkingCopy(ResourceWorkingCopyFileEditorInput editorInput) {
		try {
			XtextResourceSet xtextResourceSet = createXtextResourceSet(editorInput.getFile());
			Resource workingCopy = xtextResourceSet.createResource(editorInput.getResource().getURI());
			InputStream inputStream = editorInput.getFile().getContents(); 
			try {
				workingCopy.load(inputStream, null);
			} finally {
				inputStream.close();
			}
			return workingCopy;
		} catch(Exception exc) {
			throw new IllegalStateException(exc);
		}
	}
}
