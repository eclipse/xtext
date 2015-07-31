/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificLocation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public interface ILocationInEclipseResource extends IPlatformSpecificLocation<IStorage, IProject> {
}
