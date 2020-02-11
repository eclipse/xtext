/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IUnwrappableServiceResult

/**
 * Result object returned by the generator service. This object is usually not sent in
 * JSON format, but the content itself is returned to the client.
 */
@Data
@ToString(skipNulls = true)
class GeneratorResult implements IUnwrappableServiceResult {
	
	String name
	String contentType
	String content
	
}