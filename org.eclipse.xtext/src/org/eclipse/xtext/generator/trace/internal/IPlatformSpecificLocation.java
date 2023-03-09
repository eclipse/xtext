/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import org.eclipse.xtext.generator.trace.ILocationInResource;

/**
 * SPI for platform specific enhancements to the traced locations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IPlatformSpecificLocation<PlatformResource> extends ILocationInResource {

	/**
	 * @return the storage handle for this location. May be <code>null</code>.
	 */
	PlatformResource getPlatformResource();
	
}
