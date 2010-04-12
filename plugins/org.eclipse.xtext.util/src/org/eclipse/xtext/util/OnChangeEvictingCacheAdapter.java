/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.util.OnChangeEvictingCache.CacheAdapter;

/**
 * @author svenefftinge - Initial contribution and API
 * @deprecated use {@link OnChangeEvictingCache} instead
 */
@Deprecated
public class OnChangeEvictingCacheAdapter extends OnChangeEvictingCache.CacheAdapter {
	public static CacheAdapter getOrCreate(Notifier notifier) {
		return new OnChangeEvictingCache().getOrCreate(notifier);
	}
}
