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

	protected final URI associatedPath;
	protected final String associatedProjectName;
	
	public TraceRegion(int myOffset, int myLength, int associatedOffset, int associatedLength, AbstractTraceRegion parent, URI associatedPath, String associatedProjectName) {
		super(myOffset, myLength, associatedOffset, associatedLength, parent);
		this.associatedPath = associatedPath;
		if (parent == null) {
			this.associatedProjectName = associatedProjectName == null ? "<unknown>" : associatedProjectName;
			if (associatedPath == null) {
				throw new IllegalArgumentException("associatedPath may not be null");
			}
 		} else {
 			this.associatedProjectName = associatedProjectName;
 		}
	}

	@Override
	public URI getAssociatedPath() {
		AbstractTraceRegion parent = getParent();
		if (associatedPath == null && parent != null)
			return parent.getAssociatedPath();
		return associatedPath;
	}
	
	@Override
	public String getAssociatedProjectName() {
		AbstractTraceRegion parent = getParent();
		if (associatedProjectName == null && parent != null)
			return parent.getAssociatedProjectName();
		return associatedProjectName;
	}
	
}
