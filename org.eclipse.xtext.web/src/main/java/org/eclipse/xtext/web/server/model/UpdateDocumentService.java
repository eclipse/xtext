/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;

import com.google.inject.Singleton;

/**
 * Service class for document updates. This service only makes sense with a
 * stateful server, where the server-side document representation is updated
 * after each modification. This can greatly improve response times compared to
 * the stateless alternative, where the full text content is sent with each
 * service request.
 */
@Singleton
public class UpdateDocumentService {
	/**
	 * Update the state identifier and return it. A background process is started
	 * where the given text is assigned to the document and the services registered
	 * in {@link PrecomputedServiceRegistry} are invoked.
	 */
	public DocumentStateResult updateFullText(XtextWebDocumentAccess document, String fullText)
			throws InvalidRequestException {
		return document.modify(new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
			@Override
			public DocumentStateResult exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				doc.setDirty(true);
				doc.createNewStateId();
				return new DocumentStateResult(doc.getStateId());
			}
		}, new CancelableUnitOfWork<Object, IXtextWebDocument>() {
			@Override
			public Object exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				doc.setText(fullText);
				return null;
			}
		});
	}

	/**
	 * Update the state identifier and return it. A background process is started
	 * where the given text change is applied to the document and the services
	 * registered in {@link PrecomputedServiceRegistry} are invoked.
	 */
	public DocumentStateResult updateDeltaText(XtextWebDocumentAccess document, String deltaText, int offset,
			int replaceLength) throws InvalidRequestException {
		return document.modify(new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
			@Override
			public DocumentStateResult exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				doc.setDirty(true);
				doc.createNewStateId();
				return new DocumentStateResult(doc.getStateId());
			}
		}, new CancelableUnitOfWork<Object, IXtextWebDocument>() {
			@Override
			public Object exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				if (offset <= doc.getText().length()) {
					doc.updateText(deltaText, offset, replaceLength);
				}
				return null;
			}
		});
	}

	/**
	 * Return the current state identifier. If the services registered in
	 * {@link PrecomputedServiceRegistry} are not cached yet, they are invoked in a
	 * background process.
	 */
	public DocumentStateResult getStateId(XtextWebDocumentAccess document) throws InvalidRequestException {
		return document.modify(new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
			@Override
			public DocumentStateResult exec(IXtextWebDocument doc, CancelIndicator cancelIndicator) throws Exception {
				return new DocumentStateResult(doc.getStateId());
			}
		});
	}
}
