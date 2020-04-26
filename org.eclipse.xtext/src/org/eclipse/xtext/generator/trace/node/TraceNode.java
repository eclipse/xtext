/**
 * Copyright (c) 2017, 2020 TypeFox (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtext.generator.trace.ILocationData;

/**
 * A trace node maps the text generated through its children to a source location.
 * 
 * @author Sven Efftinge - initial contribution and API
 */
public class TraceNode extends CompositeGeneratorNode {
	private ILocationData sourceLocation;

	public TraceNode(ILocationData sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	private boolean useForDebugging;

	public ILocationData getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(ILocationData sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public boolean isUseForDebugging() {
		return useForDebugging;
	}

	public void setUseForDebugging(boolean useForDebugging) {
		this.useForDebugging = useForDebugging;
	}
}
