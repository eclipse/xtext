/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import org.eclipse.emf.emfindex.Index;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexAccess {
	
	private static Index index;

	public static Index getIndex() {
		return index;
	}

	public static void setIndex(Index instance) {
		index = instance;
	}
}
