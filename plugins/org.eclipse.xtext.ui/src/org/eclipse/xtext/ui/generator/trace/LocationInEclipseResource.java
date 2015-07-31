/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.LocationInResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class LocationInEclipseResource extends LocationInResource implements ILocationInEclipseResource {

	public LocationInEclipseResource(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI srcRelativeResourceURI, AbstractEclipseTrace trace) {
		super(offset, length, lineNumber, endLineNumber, srcRelativeResourceURI, trace);
	}
	
	@Override
	protected AbstractEclipseTrace getTrace() {
		return (AbstractEclipseTrace) super.getTrace();
	}
	
	@Override
	public IStorage getPlatformResource() {
		return getTrace().findStorage(getSrcRelativeResourceURI(), getProject());
	}

	@Override
	public IProject getProject() {
		return getTrace().getLocalProject();
	}

}
