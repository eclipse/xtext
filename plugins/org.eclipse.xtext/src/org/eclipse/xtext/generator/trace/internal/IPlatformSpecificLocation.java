/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import org.eclipse.xtext.generator.trace.ILocationInResource;

/**
 * SPI for platform specific enhancements to the traced locations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IPlatformSpecificLocation<PlatformResource, PlatformProject> extends ILocationInResource {

	/**
	 * @return the storage handle for this location. May be <code>null</code>.
	 */
	PlatformResource getPlatformResource();
	
	/**
	 * @return the platform specific project representation for this location. Never <code>null</code>.
	 */
	PlatformProject getProject();
	
}
