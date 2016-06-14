/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib.util;

import java.util.IdentityHashMap;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@SuppressWarnings("all")
class ToStringContext {
	public final static ToStringContext INSTANCE = new ToStringContext();

	private final static IdentityHashMap<Object, Boolean> currentlyProcessed = new IdentityHashMap<Object, Boolean>();

	public boolean startProcessing(final Object obj) {
		return ToStringContext.currentlyProcessed.put(obj, Boolean.TRUE) == null;
	}

	public void endProcessing(final Object obj) {
		ToStringContext.currentlyProcessed.remove(obj);
	}
}
