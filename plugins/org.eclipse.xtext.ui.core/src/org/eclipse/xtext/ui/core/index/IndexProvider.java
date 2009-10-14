/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

import org.eclipse.emf.emfindex.store.UpdateableIndex;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexProvider implements Provider<UpdateableIndex> {

	public UpdateableIndex get() {
		return IndexAccess.getIndex();
	}
	
}
