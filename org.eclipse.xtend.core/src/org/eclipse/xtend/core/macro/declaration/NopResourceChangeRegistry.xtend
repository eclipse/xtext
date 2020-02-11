/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.emf.common.util.URI

class NopResourceChangeRegistry implements IResourceChangeRegistry {
	
	override registerExists(String path, URI uri) {
	}
	
	override registerGetCharset(String string, URI uri) {
	}
	
	override registerGetChildren(String string, URI uri) {
	}
	
	override registerGetContents(String string, URI uri) {
	}
	
	override registerCreateOrModify(String string, URI uri) {
	}
	
	override discardCreateOrModifyInformation(URI uri) {
	}
	
}