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
import org.eclipse.xtext.util.internal.Log

@Log
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
	
	/**
	 * Merge the contents of the given manifest into this one.
	 */
	def merge(ManifestAccess other) {
		if (this.path != other.path) {
			LOG.warn('Merging manifest files with different paths: ' + this.path + ', ' + other.path)
		}
		if (this.bundleName != other.bundleName) {
			if (this.bundleName === null)
				this.bundleName = other.bundleName
			else if (other.bundleName !== null)
				LOG.warn('Merging manifest files with different bundle names: ' + this.bundleName + ', ' + other.bundleName)
		}
		if (this.symbolicName != other.symbolicName) {
			if (this.symbolicName === null)
				this.symbolicName = other.symbolicName
			else if (other.symbolicName !== null)
				LOG.warn('Merging manifest files with different symbolic names: ' + this.symbolicName + ', ' + other.symbolicName)
		}
		if (this.version != other.version) {
			LOG.warn('Merging manifest files with different versions: ' + this.version + ', ' + other.version)
		}
		if (this.merge != other.merge) {
			LOG.warn('Merging manifest files with different merging settings.')
		}
		this.exportedPackages.addAll(other.exportedPackages)
		this.requiredBundles.addAll(other.requiredBundles)
		this.importedPackages.addAll(other.importedPackages)
	}
	
}
