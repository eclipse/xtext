/**
 * Copyright (c) 2017, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.codeActions;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jan Koehnlein
 * 
 * @since 2.18
 * 
 * Contributors: 
 *   Rubén Porras Campo (Avaloq Evolution AG) - Add method to get fix methods.
 */
public interface ICodeActionService2 {
	class Options {
		private Document document;

		private Resource resource;
		
		private String uri;

		private ILanguageServerAccess languageServerAccess;

		private CodeActionParams codeActionParams;

		private CancelIndicator cancelIndicator;

		public Document getDocument() {
			return document;
		}

		public void setDocument(Document document) {
			this.document = document;
		}

		public Resource getResource() {
			return resource;
		}

		public void setResource(Resource resource) {
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

		/**
		 * @since 2.28
		 */
		public String getURI() {
			return uri;
		}

		/**
		 * @since 2.28
		 */
		public void setURI(String uri) {
			this.uri = uri;
		}
	}

	List<Either<Command, CodeAction>> getCodeActions(ICodeActionService2.Options options);
}
