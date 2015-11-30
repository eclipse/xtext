/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.web.server.IServiceContext

/**
 * Provider for document instances.
 */
@ImplementedBy(DefaultImpl)
interface IWebDocumentProvider {
	
	/**
	 * Creates and configures a document. The resourceId may be {@code null}, which means that
	 * the request should be processed in stateless mode. Fetching the session from the service
	 * context should be avoided in this case.
	 */
	def XtextWebDocument get(String resourceId, IServiceContext serviceContext)
	
	/**
	 * The default implementation creates one document synchronizer per session. If stateless
	 * mode is requested, each document gets its own synchronizer.
	 */
	class DefaultImpl implements IWebDocumentProvider {
		
		@Inject Provider<DocumentSynchronizer> synchronizerProvider
		
		override get(String resourceId, IServiceContext serviceContext) {
			val synchronizer =
				if (resourceId === null)
					synchronizerProvider.get
				else
					serviceContext.session.get(DocumentSynchronizer, [synchronizerProvider.get])
			new XtextWebDocument(resourceId, synchronizer)
		}
		
	}
	
}