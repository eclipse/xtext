/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;

/**
 * Base class for damager / repairer implementations. Inherits everything from a default implementation.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDamagerRepairer extends DefaultDamagerRepairer implements IDamagerRepairer {

	protected AbstractDamagerRepairer(ITokenScanner scanner) {
		super(scanner);
	}

	public final IPresentationDamager getDamager() {
		return this;
	}

	public final IPresentationRepairer getRepairer() {
		return this;
	}

}
