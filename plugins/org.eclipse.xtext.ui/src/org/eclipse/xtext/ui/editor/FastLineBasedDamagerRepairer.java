/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.rules.ITokenScanner;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FastLineBasedDamagerRepairer extends AbstractDamagerRepairer{

	@Inject
	public FastLineBasedDamagerRepairer(ITokenScanner scanner) {
		super(scanner);
	}

}
