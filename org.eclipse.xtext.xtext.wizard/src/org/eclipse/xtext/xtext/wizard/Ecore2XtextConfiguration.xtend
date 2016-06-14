/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

@Accessors
class Ecore2XtextConfiguration {
	val Set<EPackageInfo> ePackageInfos = newHashSet
	EPackageInfo defaultEPackageInfo
	EClass rootElementClass
}

@Data
class EPackageInfo {
	EPackage ePackage
	URI ePackageImportURI
	URI genmodelURI
	String ePackageJavaFQN
	String bundleID
}