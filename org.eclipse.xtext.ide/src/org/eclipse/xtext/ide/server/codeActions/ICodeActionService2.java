/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.codeActions;

import java.util.List;

import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jan Koehnlein
 * @since 2.18
 */
public interface ICodeActionService2 {
	class Options {
		private Document document;

		private XtextResource resource;

		private ILanguageServerAccess languageServerAccess;

		private CodeActionParams codeActionParams;

		private CancelIndicator cancelIndicator;

		public Document getDocument() {
			return document;
		}

		public void setDocument(Document document) {
			this.document = document;
		}

		public XtextResource getResource() {
			return resource;
		}

		public void setResource(XtextResource resource) {
			this.resource = resource;
		}

		public ILanguageServerAccess getLanguageServerAccess() {
			return languageServerAccess;
		}

		public void setLanguageServerAccess(ILanguageServerAccess languageServerAccess) {
			this.languageServerAccess = languageServerAccess;
		}

		public CodeActionParams getCodeActionParams() {
			return codeActionParams;
		}

		public void setCodeActionParams(CodeActionParams codeActionParams) {
			this.codeActionParams = codeActionParams;
		}

		public CancelIndicator getCancelIndicator() {
			return this.cancelIndicator;
		}

		public void setCancelIndicator(CancelIndicator cancelIndicator) {
			this.cancelIndicator = cancelIndicator;
		}
	}

	List<Either<Command, CodeAction>> getCodeActions(ICodeActionService2.Options options);
}
