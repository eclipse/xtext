/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.outline;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

/**
 * @author Peter Friese - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class QuickOutlineFragment extends AbstractGeneratorFragment {

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui"
		};
	}

}
