/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Trace extends RuntimeException {

	private static final long serialVersionUID = -7108374937397858920L;

	private final Object object;

	private final Tracer ctx;

	public Trace(Tracer ctx, Object object, String message) {
		super(message);
		this.ctx = ctx;
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public Tracer getTracer() {
		return ctx;
	}
}
