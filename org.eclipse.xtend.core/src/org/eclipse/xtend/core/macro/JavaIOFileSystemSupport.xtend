/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.macro.file.Path

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JavaIOFileSystemSupport extends AbstractFileSystemSupport {

	override getChildren(URI uri, Path path) {
		new File(uri.toURI).list.map[path.getAbsolutePath(it)]
	}

}
