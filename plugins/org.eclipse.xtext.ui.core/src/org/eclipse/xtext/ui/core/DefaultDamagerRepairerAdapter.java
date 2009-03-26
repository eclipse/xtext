/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.ui.core.editor.IDamagerRepairer;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultDamagerRepairerAdapter extends DefaultDamagerRepairer implements IDamagerRepairer {

	@Inject
	public DefaultDamagerRepairerAdapter(ITokenScanner scanner) {
		super(scanner);
	}

	public final IPresentationDamager getDamager() {
		return this;
	}

	public final IPresentationRepairer getRepairer() {
		return this;
	}

}
