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