/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public abstract class AbstractLocationInResource implements ILocationInResource {
	private final AbstractTrace trace;
	private AbsoluteURI absoluteURI;

	protected AbstractLocationInResource(AbstractTrace trace) {
		this.trace = trace;
	}

	@Override
	public abstract SourceRelativeURI getSrcRelativeResourceURI();
	protected abstract int getOffset();
	protected abstract int getLength();
	protected abstract int getLineNumber();
	protected abstract int getEndLineNumber();
	
	@Override
	public ITextRegionWithLineInformation getTextRegion() {
		ITextRegionWithLineInformation result = new TextRegionWithLineInformation(getOffset(), getLength(), getLineNumber(), getEndLineNumber());
		return result;
	}
	
	@Override
	public AbsoluteURI getAbsoluteResourceURI() {
		if (absoluteURI == null) {
			absoluteURI = trace.resolvePath(getSrcRelativeResourceURI());
		}
		return absoluteURI;
	}
	
	@Override
	public InputStream getContents() throws IOException {
		return trace.getContents(getSrcRelativeResourceURI());
	}
	
	@Override
	public IProjectConfig getProjectConfig() {
		return trace.getLocalProjectConfig();
	}
	
	@Override
	public LanguageInfo getLanguage() {
		LanguageInfo result = trace.findLanguage(getAbsoluteResourceURI());
		return result;
	}
	
	protected AbstractTrace getTrace() {
		return trace;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " @ " + getTextRegion();
	}
	
}
