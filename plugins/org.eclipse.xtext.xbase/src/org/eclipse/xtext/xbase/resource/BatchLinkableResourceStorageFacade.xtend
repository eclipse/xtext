/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import java.io.InputStream
import java.io.OutputStream
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
	
	override createResourceStorageInputStream(InputStream in) {
		return new BatchLinkableResourceStorageInputStream(in)
	}
	
	override createResourceStorageOutputStream(OutputStream out) {
		return new BatchLinkableResourceStorageOutputStream(out)
	}
	
} 