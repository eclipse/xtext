package org.eclipse.xtext.ui.editor.info;

import java.io.InputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * @author Michael Clay
 */
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
			ResourceSet resourceSet = getResourceSet(editorInput.getFile());
			Resource workingCopy = resourceSet.createResource(editorInput.getResource().getURI());
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
