/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data

/**
 * URIs can also refer to folders and non-Xtext resources.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class ResourceRelocationChange {
	URI fromURI
	URI toURI
	Type type 
	boolean isFile
	
	enum Type {
		COPY, MOVE, RENAME
	}
}