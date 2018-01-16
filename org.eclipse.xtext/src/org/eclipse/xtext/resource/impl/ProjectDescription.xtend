/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.EmfAdaptable
import com.google.common.annotations.Beta
import org.eclipse.xtend.lib.annotations.ToString

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@ToString
@EmfAdaptable class ProjectDescription {
	
	/**
	 * A unique name for this project
	 */
	@Accessors String name
	
	/**
	 * list of logical names of upstream dependencies
	 */
	@Accessors List<String> dependencies = newArrayList
	
}
