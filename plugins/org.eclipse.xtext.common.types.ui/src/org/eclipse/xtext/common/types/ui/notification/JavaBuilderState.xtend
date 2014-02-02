/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification

import java.util.Set
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.eclipse.core.resources.IProject
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable
import org.eclipse.jdt.internal.core.builder.State
import org.eclipse.jdt.internal.core.builder.StringSet
import org.eclipse.xtext.naming.QualifiedName

import static org.eclipse.jdt.internal.core.JavaModelManager.*

/**
 * @since 2.5
 * @author Anton Kosyakov - Initial contribution and API
 */
class JavaBuilderState {

	private val static LOG = Logger.getLogger(JavaBuilderState);

	val State state

	val IProject project

	var Integer buildNumber

	var SimpleLookupTable references

	var Long lastStructuralBuildTime

	var Set<QualifiedName> structurallyChangedTypes

	private new(IProject project, State state) {
		this.project = project
		this.state = state
	}

	def getProject() {
		project
	}

	static def getLastBuiltState(IJavaElement it) {
		val javaProject = javaProject
		if (javaProject == null) {
			return null
		}
		javaProject.project.lastBuiltState
	}

	static def getLastBuiltState(IProject it) {
		new JavaBuilderState(it,
			switch state : javaModelManager.getLastBuiltState(it, null) {
				State: state
				default: null
			})
	}

	def getLastStructuralBuildTime() {
		if (lastStructuralBuildTime != null) {
			return lastStructuralBuildTime
		}
		if (state == null) {
			return lastStructuralBuildTime = -1l
		}
		lastStructuralBuildTime = state.readField("lastStructuralBuildTime", -1l) as Long
	}

	def getBuildNumber() {
		if (buildNumber != null) {
			return buildNumber
		}
		if (state == null) {
			return buildNumber = -1
		}
		buildNumber = state.readField("buildNumber", -1) as Integer
	}

	def getStructurallyChangedTypes() {
		if (structurallyChangedTypes != null) {
			return structurallyChangedTypes
		}
		structurallyChangedTypes = newHashSet
		switch types : state?.readField("structurallyChangedTypes", null) {
			StringSet: {
				for (name : types.values) {
					if (name != null) {
						structurallyChangedTypes += QualifiedName.create(name.split("/"))
					}
				}
			}
		}
		structurallyChangedTypes
	}

	/**
	 * <p>
	 * Return types which are direct children of a given package.
	 * </p>
	 */
	def dispatch getQualifiedTypeNames(IPackageFragment it) {
		val qualifiedTypeNames = <String>newLinkedHashSet
		val references = getReferences
		if (references == null) {
			return qualifiedTypeNames
		}
		val packageName = elementName
		val resource = it.resource
		if (resource == null)
			return qualifiedTypeNames
		val packagePath = resource.projectRelativePath
		val srcPathSegmentCount = packageFragmentRoot.resource.projectRelativePath.segmentCount
		for (key : references.keyTable) {
			switch typeLocator : key {
				String: {
					val typeLocatorPath = javaProject.project.getFile(typeLocator).projectRelativePath
					if (packagePath.isPrefixOf(typeLocatorPath)) {
						val qulifiedPath = typeLocatorPath.removeFirstSegments(srcPathSegmentCount).removeFileExtension
						val typePackageName = qulifiedPath.removeLastSegments(1).toString.replace('/', '.')
						if (packageName.equals(typePackageName)) {
							val simpleTypeName = qulifiedPath.lastSegment.toString
							qualifiedTypeNames += typeLocator.getQualifiedTypeNames(packageName, simpleTypeName)
						}
					}
				}
			}
		}
		qualifiedTypeNames
	}

	/**
	 * <p>
	 * Return types which are children of a given compilation unit.
	 * </p>
	 */
	def dispatch getQualifiedTypeNames(ICompilationUnit it) {
		typeLocator.getQualifiedTypeNames(packageName, simplePrimaryTypeName)
	}

	private def IPackageFragmentRoot getPackageFragmentRoot(IJavaElement it) {
		switch parent : parent {
			IPackageFragmentRoot: parent
			default: parent.packageFragmentRoot
		}
	}

	private def getQualifiedTypeNames(String typeLocator, String packageName, String simpleName) {
		val typeNames = state?.getDefinedTypeNamesFor(typeLocator)
		if (typeNames == null) {
			return <String>newLinkedHashSet(getQualifedTypeName(packageName, simpleName))
		}
		val qualifiedTypeNames = <String>newLinkedHashSet
		typeNames.forEach [
			qualifiedTypeNames += getQualifedTypeName(packageName, new String(it))
		]
		qualifiedTypeNames
	}

	private def String getQualifedTypeName(String packageName, String simpleTypeName) {
		if (packageName == null) {
			return simpleTypeName
		}
		'''«packageName».«simpleTypeName»'''
	}

	private def getTypeLocator(ICompilationUnit it) {
		resource.projectRelativePath.toString
	}

	private def getPackageName(ICompilationUnit it) {
		switch parent : parent {
			IPackageFragment case !parent.defaultPackage: parent.elementName
			default: null
		}
	}

	private def getSimplePrimaryTypeName(ICompilationUnit it) {
		val elementName = elementName
		elementName.substring(0, elementName.lastIndexOf('.'))
	}

	private def SimpleLookupTable getReferences() {
		if (references != null) {
			return references
		}
		if (state == null) {
			return null
		}
		references = switch references : state.readField("references", null) {
			SimpleLookupTable: references
			default: null
		}
	}

	private def readField(Object instance, String fieldName, Object defaultValue) {
		try {
			val field = instance.class.getDeclaredField(fieldName)
			field.accessible = true
			val value = field.get(instance)
			if (value != null) {
				return value
			}
			return defaultValue
		} catch (Exception e) {
			if (LOG.isEnabledFor(Level.ERROR)) {
				LOG.error(e);
			}
			return defaultValue;
		}
	}

}
