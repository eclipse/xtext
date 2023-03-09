/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CfgUtil {

	protected static class IsCall<E> implements Predicate<E> {

		protected Cfg<E, ?> cfg;

		public IsCall(Cfg<E, ?> cfg) {
			super();
			this.cfg = cfg;
		}

		@Override
		public boolean apply(E input) {
			return cfg.getCall(input) != null;
		}

	}

	public <E, T> Multimap<E, E> getCallers(Cfg<E, T> cfg) {
		Multimap<E, E> result = ArrayListMultimap.create();
		getCallers(cfg, cfg.getRoot(), result);
		return result;
	}

	protected <E, T> void getCallers(Cfg<E, T> cfg, E root, Multimap<E, E> callers) {
		for (E call : new ProductionUtil().getAllChildren(cfg, root)) {
			E called = cfg.getCall(call);
			if (called != null) {
				boolean contained = callers.containsKey(called) || called == cfg.getRoot();
				callers.put(called, call);
				if (!contained)
					getCallers(cfg, called, callers);
			}
		}
	}
}
