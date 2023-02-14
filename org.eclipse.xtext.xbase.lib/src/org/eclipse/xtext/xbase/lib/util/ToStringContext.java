/**
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.lib.util;

import com.google.common.annotations.GwtCompatible;
import java.util.IdentityHashMap;

/**
 * On GWT we just use a static variable instead of a ThreadLocal
 */
@GwtCompatible(emulated = true)
class ToStringContext {

	public final static ToStringContext INSTANCE = new ToStringContext();

	private final static ThreadLocal<IdentityHashMap<Object, Boolean>> currentlyProcessed = new ThreadLocal<IdentityHashMap<Object, Boolean>>() {
		@Override
		public IdentityHashMap<Object, Boolean> initialValue() {
			return new IdentityHashMap<Object, Boolean>();
		}
	};

	public boolean startProcessing(final Object obj) {
		return ToStringContext.currentlyProcessed.get().put(obj, Boolean.TRUE) == null;
	}

	public void endProcessing(final Object obj) {
		ToStringContext.currentlyProcessed.get().remove(obj);
	}
}