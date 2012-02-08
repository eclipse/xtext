/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceRegion extends AbstractStatefulTraceRegion {

	protected final URI toPath;
	protected final String toProjectName;
	
	public TraceRegion(int fromOffset, int fromLength, int toOffset, int toLength, AbstractTraceRegion parent, URI toPath, String toProjectName) {
		super(fromOffset, fromLength, toOffset, toLength, parent);
		this.toPath = toPath;
		if (parent == null) {
			this.toProjectName = toProjectName == null ? "<unknown>" : toProjectName;
			if (toPath == null) {
				throw new IllegalArgumentException("toPath may not be null");
			}
 		} else {
 			this.toProjectName = toProjectName;
 		}
	}

	@Override
	public URI getToPath() {
		AbstractTraceRegion parent = getParent();
		if (toPath == null && parent != null)
			return parent.getToPath();
		return toPath;
	}
	
	@Override
	public String getToProjectName() {
		AbstractTraceRegion parent = getParent();
		if (toProjectName == null && parent != null)
			return parent.getToProjectName();
		return toProjectName;
	}
	
}
