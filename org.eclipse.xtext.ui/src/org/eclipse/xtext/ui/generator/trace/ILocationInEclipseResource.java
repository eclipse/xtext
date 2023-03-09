/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificLocation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public interface ILocationInEclipseResource extends IPlatformSpecificLocation<IStorage> {
}
