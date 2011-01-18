/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlinePage extends OutlinePage {

	@Override
	protected int getDefaultExpansionLevel() {
		return 2;
	}
}
