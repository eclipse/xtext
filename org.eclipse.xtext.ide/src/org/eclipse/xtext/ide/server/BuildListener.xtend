/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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