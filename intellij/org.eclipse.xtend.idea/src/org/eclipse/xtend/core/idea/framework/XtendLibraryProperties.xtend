/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.framework

import com.intellij.openapi.roots.libraries.LibraryProperties

/**
 * @author kosyakov - Initial contribution and API
 */
final class XtendLibraryProperties extends LibraryProperties<XtendLibraryProperties> {

	override equals(Object obj) {
		return obj instanceof XtendLibraryProperties
	}

	override hashCode() {
		0
	}

	override getState() {
		null
	}

	override loadState(XtendLibraryProperties state) {
	}


}
