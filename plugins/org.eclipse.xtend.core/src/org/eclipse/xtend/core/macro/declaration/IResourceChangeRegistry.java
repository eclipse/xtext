/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
