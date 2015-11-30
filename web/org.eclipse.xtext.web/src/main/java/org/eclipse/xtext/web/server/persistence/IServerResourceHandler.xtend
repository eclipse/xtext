/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import com.google.inject.ImplementedBy
import java.io.IOException
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocument

/**
 * Interface for <em>get</em> and <em>put</em> operations on documents. Implementations can
 * use arbitrary persistence technology for performing these operations.
 */
@ImplementedBy(NullImpl)
interface IServerResourceHandler {
	
	def XtextWebDocument get(String resourceId, IServiceContext serviceContext) throws IOException
	
	def void put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException
	
	static class NullImpl implements IServerResourceHandler {
		override get(String resourceId, IServiceContext serviceContext) throws IOException {
			throw new IOException("This server does not support resource handling.")
		}
		override put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException {
			throw new IOException("This server does not support resource handling.")
		}
	}
	
}