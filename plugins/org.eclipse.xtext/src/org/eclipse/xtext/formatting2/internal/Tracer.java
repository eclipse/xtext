/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.IdentityHashMap;

import org.eclipse.xtext.util.Exceptions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class Tracer {

	private static class Root extends Tracer {
		private final IdentityHashMap<Object, Trace> traces = new IdentityHashMap<Object, Trace>();

		@Override
		public Tracer fork(Object ctx) {
			return new Sub(this, ctx);
		}

		@Override
		public Trace get(Object obj) {
			return traces.get(obj);
		}

		@Override
		protected Root getRoot() {
			return this;
		}

	}

	private static class Sub extends Tracer {
		private final Object ctx;
		private final Tracer parent;
		private final Tracer.Root root;

		public Sub(Tracer parent, Object ctx) {
			super();
			this.root = parent.getRoot();
			this.parent = parent;
			this.ctx = ctx;
		}

		@Override
		public Tracer fork(Object ctx) {
			return new Sub(this, ctx);
		}

		@Override
		public Trace get(Object obj) {
			return root.get(obj);
		}

		@Override
		protected Root getRoot() {
			return root;
		}

	}

	public static Tracer create() {
		return new Root();
	}

	public abstract Tracer fork(Object ctx);

	public abstract Trace get(Object obj);

	protected abstract Tracer.Root getRoot();

	public void trace(Object object, String message) {
		Root root = getRoot();
		Trace trace = new Trace(this, object, message);
		Throwable throwable = root.traces.get(object);
		if (throwable == null)
			root.traces.put(object, trace);
		else
			Exceptions.addSuppressed(throwable, trace);
	}

	public void trace(Object object) {
		trace(object, null);
	}
}
