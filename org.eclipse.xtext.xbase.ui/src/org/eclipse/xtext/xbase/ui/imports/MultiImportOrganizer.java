/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.imports;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRefactoringDocumentProvider.EditorDocument;
import org.eclipse.xtext.ui.refactoring.impl.EditorDocumentChange;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.XtextLiveScopeResourceSetProvider;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.ImportOrganizer;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
@Singleton
public class MultiImportOrganizer {

	@Inject
	private IRefactoringDocument.Provider provider;
	@Inject
	private ImportOrganizer importOrganizer;
	@Inject
	private IStorage2UriMapper storageMapper;
	@Inject
	private ReplaceConverter replaceConverter;
	@Inject
	private StatusWrapper status;
	@Inject
	private XtextLiveScopeResourceSetProvider resSetProvider;

	/**
	 * @param files
	 *            ordered by corresponding {@link IProject}
	 * @param mon
	 * @return Creates {@link Change}s for each {@link IFile} using {@link ImportOrganizer}
	 * @throws InterruptedException
	 */
	public List<Change> organizeImports(Multimap<IProject, IFile> files, IProgressMonitor mon)
			throws InterruptedException {
		List<Change> result = Lists.newArrayList();
		for (IProject project : files.keySet()) {
			ResourceSet resSet = resSetProvider.get(project);
			for (IFile file : files.get(project)) {
				mon.subTask("Calculating imports in - " + file.getName());
				URI uri = storageMapper.getUri(file);
				if (uri != null) {
					XtextResource resource = (XtextResource) resSet.getResource(uri, true);
					List<ReplaceRegion> replace = importOrganizer.getOrganizedImportChanges(resource);
					//TODO - find out why \n\n changes are produced, even if there are any unused imports
					if (replace == null || replace.isEmpty()) {
						continue;
					}
					TextEdit textEdit = replaceConverter.convertToTextEdit(replace);
					IRefactoringDocument iRefactoringDocument = provider.get(uri, status);
					if (iRefactoringDocument != null) {
						Change change = iRefactoringDocument.createChange(Messages.OrganizeImports, textEdit);
						if (change instanceof EditorDocumentChange) {
							if (((EditorDocument) iRefactoringDocument).getEditor().isDirty()) {
								((EditorDocumentChange) change).setDoSave(false);
							}
						}
						result.add(change);
					}
				}
				mon.worked(1);
				if (mon.isCanceled()) {
					throw new InterruptedException();
				}
			}
		}
		return result;
	}
}
