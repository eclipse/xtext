/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.persistence;

import java.io.IOException;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Service class for loading, saving, and reverting documents. The actual work
 * is done by an implementation of {@link IServerResourceHandler}, so if you
 * want to use this service you must provide such an implementation in the Guice
 * bindings.
 */
@Singleton
public class ResourcePersistenceService {
	@Inject
	private XtextWebDocumentAccess.Factory documentAccessFactory;

	/**
	 * Load the content of a document.
	 */
	public ResourceContentResult load(String resourceId, IServerResourceHandler resourceHandler,
			IServiceContext serviceContext) throws InvalidRequestException {
		XtextWebDocument document = serviceContext.getSession().get(Pair.of(XtextWebDocument.class, resourceId), () -> {
			try {
				return resourceHandler.get(resourceId, serviceContext);
			} catch (IOException ioe) {
				throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.",
						ioe);
			}
		});
		return documentAccessFactory.create(document, false)
				.readOnly(new CancelableUnitOfWork<ResourceContentResult, IXtextWebDocument>() {
					@Override
					public ResourceContentResult exec(IXtextWebDocument it, CancelIndicator cancelIndicator)
							throws Exception {
						return new ResourceContentResult(it.getText(), it.getStateId(), it.isDirty());
					}
				});
	}

	/**
	 * Revert the content of a document to the last saved state.
	 */
	public ResourceContentResult revert(String resourceId, IServerResourceHandler resourceHandler,
			IServiceContext serviceContext) throws InvalidRequestException {
		try {
			XtextWebDocument document = resourceHandler.get(resourceId, serviceContext);
			serviceContext.getSession().put(Pair.of(XtextWebDocument.class, resourceId), document);
			return new ResourceContentResult(document.getText(), document.getStateId(), false);
		} catch (IOException ioe) {
			throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.", ioe);
		}
	}

	/**
	 * Save the content of a document.
	 */
	public DocumentStateResult save(XtextWebDocumentAccess document, IServerResourceHandler resourceHandler,
			IServiceContext serviceContext) throws InvalidRequestException {
		return document.readOnly(new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
			@Override
			public DocumentStateResult exec(IXtextWebDocument it, CancelIndicator cancelIndicator) throws Exception {
				try {
					resourceHandler.put(it, serviceContext);
					it.setDirty(false);
				} catch (IOException ioe) {
					throw new InvalidRequestException.ResourceNotFoundException(ioe.getMessage(), ioe);
				}
				return new DocumentStateResult(it.getStateId());
			}
		});
	}
}
