/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@Data
class OriginalElement {
	val AbstractElement original
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@Data
class OriginalGrammar {
	val Grammar original
}