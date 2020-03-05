/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.bracketmatching;

import java.util.Set;

/**
 * <p>
 * Provides a set of definitions for brace pairs that need to be matched when
 * editing code.
 * </p> 
 * 
 * @author kosyakov - Initial contribution and API
 */
public interface IBracePairProvider {

	/**
	 * Returns a set of definitions for brace pairs that need to be matched when
	 * editing code.
	 */
	Set<BracePair> getPairs();

}