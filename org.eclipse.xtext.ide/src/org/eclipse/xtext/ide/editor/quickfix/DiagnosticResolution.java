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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtext.ide.editor.quickfix.DiagnosticModificationContext.Factory;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IChangeSerializer.IModification;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.TextEditAcceptor;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options;
import org.eclipse.xtext.ide.server.rename.ChangeConverter2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.MoreCollectors;

/**
 * @author Heinrich Weichert
 *
 * @since 2.24
 */
public class DiagnosticResolution {

	private String label;

	private ISemanticModification modification;

	private final ITextModification textModification;

	private Factory factory;

	private int relevance;

	private Options options;

	@Deprecated//(forRemoval=true,since="2.27")
	public DiagnosticResolution(String label, Factory modificationContextFactory,  IModification<EObject> modification) {
		this(label, modificationContextFactory, (diagnostic, object) -> modification, 0);
	}

	@Deprecated//(forRemoval=true,since="2.27")
	public DiagnosticResolution(String label, Factory modificationContextFactory,  IModification<EObject> modification, int relevance) {
		this(label, modificationContextFactory, (diagnostic, object) -> modification, relevance);
	}

	/**
	 * @since 2.27
	 */
	public DiagnosticResolution(String label, Factory modificationContextFactory, ITextModification textModification) {
		this(label, modificationContextFactory, textModification, 0);
	}

	/**
	 * @since 2.27
	 */
	public DiagnosticResolution(String label, Factory modificationContextFactory, ITextModification textModification, int relevance) {
		this.label = label;
		this.factory = modificationContextFactory;
		this.modification = null;
		this.textModification = textModification;
		this.relevance = relevance;
	}

	/**
	 * @since 2.27
	 */
	public DiagnosticResolution(String label, Factory modificationContextFactory, ISemanticModification modification) {
		this(label, modificationContextFactory, modification, 0);
	}

	/**
	 * @since 2.27
	 */
	public DiagnosticResolution(String label, Factory modificationContext, ISemanticModification modification,
			int relevance) {
		this.label = label;
		this.factory = modificationContext;
		this.modification = modification;
		this.textModification = null;
		this.relevance = relevance;
	}

	public int getRelevance() {
		return relevance;
	}

	public String getLabel() {
		return label;
	}

	public WorkspaceEdit apply() {
		try {
			Resource resource = options.getResource();
			URI uri = resource.getURI();

			CodeActionParams params = options.getCodeActionParams();
			Document document = options.getDocument();
			int offset = document.getOffSet(params.getRange().getStart());
			EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();
			ILanguageServerAccess access = options.getLanguageServerAccess();
			ResourceSet resourceSet = access.newLiveScopeResourceSet(uri);
			XtextResource tmpResource = (XtextResource) resourceSet.getResource(uri, true);
			EObject obj = helper.resolveContainedElementAt(tmpResource, offset);

			WorkspaceEdit edit = new WorkspaceEdit();
			Diagnostic diagnostic = params.getContext().getDiagnostics().stream().collect(MoreCollectors.onlyElement());
			if (modification != null) {
				DiagnosticModificationContext modificationContext = factory.createModificationContext();
				ChangeConverter2 changeConverter = modificationContext.getConverterFactory().create(edit, access);
				IChangeSerializer serializer = modificationContext.getSerializer();
				serializer.addModification(obj, modification.apply(diagnostic, obj));
				serializer.applyModifications(changeConverter);
			} else {
				TextEditAcceptor textEditAcceptor = new TextEditAcceptor(edit, access);
				textEditAcceptor.accept(uri.toString(), document, textModification.apply(diagnostic, obj, document));
			}
			return edit;
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	void configure(Options options) {
		this.options = options;
	}
}
