/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.bracketmatching

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Defines a single pair of braces which need to be matched when editing code.
 * 
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
class BracePair {
	val String leftBrace
	val String rightBrace
	val boolean structural
}