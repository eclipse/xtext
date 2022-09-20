/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.xtext.ide.serializer.IChangeSerializer.IModification;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2.Options;

import com.google.inject.Inject;

/**
 * @author Heinrich Weichert
 *
 * @since 2.24
 *
 */
public class DiagnosticResolutionAcceptor {

	private List<DiagnosticResolution> resolutions = new ArrayList<>();

	private DiagnosticModificationContext.Factory modificationContextFactory;

	@Inject
	public DiagnosticResolutionAcceptor(DiagnosticModificationContext.Factory modificationContextFactory) {
		this.modificationContextFactory = modificationContextFactory;
	}

	public void accept(String label, IModification<EObject> modification) {
		resolutions.add(new DiagnosticResolution(label, modificationContextFactory, (diagnostic, object) -> modification));
	}

	/**
	 * @since 2.27
	 */
	public void accept(String label, ISemanticModification modification) {
		resolutions.add(new DiagnosticResolution(label, modificationContextFactory, modification));
	}

	/**
	 * @since 2.27
	 */
	public void accept(String label, ITextModification modification) {
		resolutions.add(new DiagnosticResolution(label, modificationContextFactory, modification));
	}

	public List<DiagnosticResolution> getDiagnosticResolutions(Options options, Diagnostic diagnostic) {
		resolutions.forEach(resolution -> resolution.configure(options, diagnostic));
		return resolutions;
	}

}
