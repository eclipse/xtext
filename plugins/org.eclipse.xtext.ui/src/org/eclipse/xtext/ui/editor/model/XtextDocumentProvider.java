/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextDocumentProvider extends TextFileDocumentProvider implements IDocumentProvider {

	private final ILanguageDescriptor languageDescriptor;

	protected class XtextFileInfo extends FileInfo {
		public IEditorModel xtextEditorModel;

		public XtextFileInfo() {
		}
	}

	public XtextDocumentProvider(ILanguageDescriptor languageDescriptor) {
		this.languageDescriptor = languageDescriptor;
	}

	public IEditorModel getModel(Object element) {
		FileInfo info = getFileInfo(element);
		if (info instanceof XtextFileInfo) {
			XtextFileInfo xtextFileInfo = (XtextFileInfo) info;
			return xtextFileInfo.xtextEditorModel;
		}
		return null;

	}

	protected IEditorModel createXtextEditorModel(Object element, IDocument document, IAnnotationModel annotationModel) {
		return new XtextEditorModel(document, languageDescriptor);
	}

	protected FileInfo createFileInfo(Object element) throws CoreException {
		FileInfo info = super.createFileInfo(element);
		if (!(info instanceof XtextFileInfo)) {
			return null;
		}

		XtextFileInfo xtextFileInfo = (XtextFileInfo) info;
		IAnnotationModel annotationModel = xtextFileInfo.fTextFileBuffer.getAnnotationModel();
		IResourceFactory resourceFactory = ServiceRegistry.getService(languageDescriptor, IResourceFactory.class);
		String pathName = ((IURIEditorInput) element).getURI().toString();
		Resource resource = resourceFactory.createResource(URI.createPlatformResourceURI(pathName, true));
		Assert.isNotNull(resource);
		IDocument document = info.fTextFileBuffer.getDocument();

		IEditorModel xtextEditorModel = createXtextEditorModel(element, document, annotationModel);
		xtextEditorModel.install();
		xtextFileInfo.xtextEditorModel = xtextEditorModel;

		return xtextFileInfo;
	}

	protected void disposeFileInfo(Object element, FileInfo info) {
		if (info instanceof XtextFileInfo) {
			XtextFileInfo xtextFileInfo = (XtextFileInfo) info;
			if (xtextFileInfo.xtextEditorModel != null) {
				IDocument doc = xtextFileInfo.fTextFileBuffer.getDocument();
				Object lock = null;
				if (doc instanceof ISynchronizable) {
					lock = ((ISynchronizable) doc).getLockObject();
				}
				else {
					lock = xtextFileInfo.xtextEditorModel;
				}
				xtextFileInfo.xtextEditorModel.uninstall();
				if (lock == null) {
					xtextFileInfo.xtextEditorModel = null;
				}
				else {
					synchronized (lock) {
						xtextFileInfo.xtextEditorModel = null;
					}
				}
			}
		}
		super.disposeFileInfo(element, info);
	}

	protected FileInfo createEmptyFileInfo() {
		return new XtextFileInfo();
	}

}
