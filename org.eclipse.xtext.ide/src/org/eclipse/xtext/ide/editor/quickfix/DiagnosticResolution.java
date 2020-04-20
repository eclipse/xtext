/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.ide.editor.quickfix.DiagnosticModificationContext.Factory;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IChangeSerializer.IModification;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options;
import org.eclipse.xtext.ide.server.rename.ChangeConverter2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Heinrich Weichert
 *
 * @since 2.24
 */
public class DiagnosticResolution {

	private String label;

	private IModification<EObject> modification;

	private Factory factory;

	private int relevance;

	private Options options;

	public DiagnosticResolution(String label, Factory modificationContextFactory, IModification<EObject> modification) {
		this(label, modificationContextFactory, modification, 0);
	}

	public DiagnosticResolution(String label, Factory modificationContext, IModification<EObject> modification,
			int relevance) {
		this.label = label;
		this.factory = modificationContext;
		this.modification = modification;
		this.relevance = relevance;
	}

	public int getRelevance() {
		return relevance;
	}

	public String getLabel() {
		return label;
	}

	public WorkspaceEdit apply() {
		DiagnosticModificationContext modificationContext = factory.createModificationContext();
		try {
			XtextResource resource = options.getResource();
			URI uri = resource.getURI();
			ILanguageServerAccess access = options.getLanguageServerAccess();

			WorkspaceEdit edit = new WorkspaceEdit();
			ChangeConverter2 changeConverter = modificationContext.getConverterFactory().create(edit, access);

			ResourceSet resourceSet = access.newLiveScopeResourceSet(uri);
			XtextResource tmpResource = (XtextResource) resourceSet.getResource(uri, true);

			CodeActionParams params = options.getCodeActionParams();

			int offset = options.getDocument().getOffSet(params.getRange().getStart());
			EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
			EObject obj = helper.resolveContainedElementAt(tmpResource, offset);

			IChangeSerializer serializer = modificationContext.getSerializer();
			serializer.addModification(obj, modification);
			serializer.applyModifications(changeConverter);

			return edit;
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	void configure(Options options) {
		this.options = options;
	}
}
