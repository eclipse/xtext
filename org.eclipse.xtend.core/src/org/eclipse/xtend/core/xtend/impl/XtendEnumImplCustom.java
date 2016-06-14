/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.xtend.core.xtend.XtendFile;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendEnumImplCustom extends XtendEnumImpl {

	@Override
	public boolean isFinal() {
		return true;
	}

	@Override
	public boolean isStatic() {
		return !(eContainer() instanceof XtendFile);
	}
}
