/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.2
 */
public class QuickOutlineFilterAndSorter extends OutlineFilterAndSorter {

	@Override
	protected boolean isSortingEnabled() {
		return true;
	}
}
