/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.info;

import java.io.InputStream;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * @author Michael Clay
 * @author Jan Koehnlein
 */
public class ResourceForResourceWorkingCopyEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {

	@Override
	public Resource createResource(IEditorInput editorInput) {
		if (editorInput instanceof ResourceWorkingCopyFileEditorInput) {
			return createWorkingCopy((ResourceWorkingCopyFileEditorInput) editorInput);
		} else {
			return super.createResource(editorInput);
		}
	}

	protected Resource createWorkingCopy(ResourceWorkingCopyFileEditorInput editorInput) {
		try {
			ResourceSet resourceSet = getResourceSet(editorInput.getFile());
			Resource workingCopy = resourceSet.createResource(editorInput.getResource().getURI());
			InputStream inputStream = editorInput.getFile().getContents();
			try {
				workingCopy.load(inputStream, Collections.singletonMap(XtextResource.OPTION_ENCODING, editorInput.getEncoding()));
			} finally {
				inputStream.close();
			}
			return workingCopy;
		} catch (Exception exc) {
			throw new IllegalStateException(exc);
		}
	}
}
