/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnonymousClassImplCustom extends AnonymousClassImpl {

	@Override
	public boolean isAnonymous() {
		return true;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isFinal() {
		return true;
	}
}
