/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * Describes the location in a given file or storage. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.3
 */
public interface ILocationInResource {
	
	/**
	 * @return the language that this resource belongs to. May be <code>null</code>.
	 */
	LanguageInfo getLanguage();
	
	/**
	 * @return the EMF resource URI for this location. May be <code>null</code> if the 
	 * resource is not an EMF resource.
	 */
	AbsoluteURI getAbsoluteResourceURI();
	
	/**
	 * Returns the URI of this resource relative to the classpath if applicable. Otherwise
	 * the URI relative to the project root.
	 */
	SourceRelativeURI getSrcRelativeResourceURI();
	
	/**
	 * Returns the contents of the resource. May be <code>null</code>.
	 */
	InputStream getContents() throws IOException;
	
	/**
	 * @return the project configuration for this location. Never <code>null</code>.
	 */
	IProjectConfig getProjectConfig();
	
	/**
	 * @return the range in the resource. May be <code>null</code>.
	 */
	ITextRegionWithLineInformation getTextRegion();
	
}