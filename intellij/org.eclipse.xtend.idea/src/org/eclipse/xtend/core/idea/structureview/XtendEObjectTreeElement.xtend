/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.structureview.EObjectTreeElement

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendEObjectTreeElement extends EObjectTreeElement {

	boolean isStatic

	@Accessors
	int inheritanceDepth

	def void setStatic(boolean isStatic) {
		this.isStatic = isStatic
	}

	def isStatic() {
		this.isStatic
	}

}