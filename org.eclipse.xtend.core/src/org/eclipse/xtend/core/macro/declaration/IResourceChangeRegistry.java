/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.URI;

public interface IResourceChangeRegistry {
	void registerExists(String path, URI uri);
	void registerGetCharset(String string, URI uri);
	void registerGetChildren(String string, URI uri);
	void registerGetContents(String string, URI uri);
	void registerCreateOrModify(String string, URI uri);
	void discardCreateOrModifyInformation(URI uri);
}
