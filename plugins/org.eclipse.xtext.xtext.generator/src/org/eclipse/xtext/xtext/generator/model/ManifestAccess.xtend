/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ManifestAccess {
	
	String path = 'MANIFEST.MF'
	
	String bundleName
	
	String symbolicName
	
	String version = '0.0.1.qualifier'
	
	boolean merge = true
	
	val Set<String> exportedPackages = newHashSet
	
	val Set<String> requiredBundles = newHashSet
	
	val Set<String> importedPackages = newHashSet
	
}
