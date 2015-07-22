/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	/* @Nullable */ LanguageInfo getLanguage();
	
	/**
	 * @return the EMF resource URI for this location. May be <code>null</code> if the 
	 * resource is not an EMF resource.
	 */
	/* @Nullable */ AbsoluteURI getAbsoluteResourceURI();
	
	/**
	 * Returns the URI of this resource relative to the classpath if applicable. Otherwise
	 * the URI relative to the project root.
	 */
	/* @Nullable */ SourceRelativeURI getSrcRelativeResourceURI();
	
//	/**
//	 * @return the more specific {@link org.eclipse.emf.ecore.EObject object} {@link URI}
//	 * for this location. May be <code>null</code> if the resource itself is empty or if this
//	 * resource is not an EMF resource.
//	 */
//	/* @Nullable */ URI getEObjectURI();
	
	/* @NonNull */ InputStream getContents() throws IOException;
	
	/**
	 * @return the project configuration for this location. Never <code>null</code>.
	 */
	IProjectConfig getProjectConfig();
	
//	/**
//	 * Returns the encoding that should be used to read the contents of the resource that contains this
//	 * location.
//	 */
//	Charset getEncoding();
	
	/**
	 * @return the range in the resource. May be <code>null</code>.
	 */
	/* @Nullable */ ITextRegionWithLineInformation getTextRegion();
}