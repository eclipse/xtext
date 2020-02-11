/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import org.eclipse.xtext.resource.IResourceDescription
import java.util.List

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface BuildListener {
	
	def void afterBuild(List<IResourceDescription.Delta> deltas)
	
}