/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

import org.eclipse.emf.emfindex.store.UpdateableIndex;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexAccess {

	private static UpdateableIndex index;

	public static UpdateableIndex getIndex() {
		return index;
	}

	public static void setIndex(UpdateableIndex instance) {
		index = instance;
	}
}
