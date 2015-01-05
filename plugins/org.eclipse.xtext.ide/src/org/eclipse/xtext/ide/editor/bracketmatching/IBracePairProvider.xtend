/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.bracketmatching

import java.util.Set

/**
 * <p>
 * Provides a set of definitions for brace pairs that need to be matched when
 * editing code.
 * </p> 
 * 
 * @author kosyakov - Initial contribution and API
 */
interface IBracePairProvider {

	/**
	 * Returns a set of definitions for brace pairs that need to be matched when
	 * editing code.
	 */
	def Set<BracePair> getPairs()

}