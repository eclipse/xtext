/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.server.semanticHighlight.ISemanticHighlightingStyleToTokenMapper;
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService;
import org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring.SemanticHighlightingCalculatorImpl;
import org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring.SemanticHighlightingStyleToTokenMapper;
import org.eclipse.xtext.ide.tests.testlanguage.formatting2.TestLanguageFormatter;
import org.eclipse.xtext.ide.tests.testlanguage.ide.serializer.TestLanguageReferenceUpdater;
import org.eclipse.xtext.ide.tests.testlanguage.signatureHelp.SignatureHelpServiceImpl;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class TestLanguageRuntimeModule extends AbstractTestLanguageRuntimeModule {

	public Class<? extends IFormatter2> bindIFormatter2() {
		return TestLanguageFormatter.class;
	}

	public Class<? extends ISignatureHelpService> bindSignatureHelpService() {
		return SignatureHelpServiceImpl.class;
	}

	@Deprecated
	public Class<? extends  org.eclipse.xtext.ide.server.coloring.IColoringService> bindIColoringService() {
		return org.eclipse.xtext.ide.tests.testlanguage.coloring.ColoringServiceImpl.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculatorImpl.class;
	}

	public Class<? extends ISemanticHighlightingStyleToTokenMapper> bindISemanticHighlightingStyleToTokenMapper() {
		return SemanticHighlightingStyleToTokenMapper.class;
	}

	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return TestLanguageReferenceUpdater.class;
	}

}
