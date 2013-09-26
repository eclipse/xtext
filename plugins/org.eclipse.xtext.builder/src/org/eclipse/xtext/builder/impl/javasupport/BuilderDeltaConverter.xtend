/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport

import com.google.common.base.Preconditions
import com.google.inject.Inject
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IJavaElementDelta
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class BuilderDeltaConverter extends DeltaConverter {

	@Inject
	new(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper) {
		super(nameConverter, uriHelper)
	}

	override protected convertChangedCompilationUnit(IJavaElementDelta it, List<Delta> result) {
		if (primaryWorkingCopy) {
			result.add(rollback)
		}
		super.convertChangedCompilationUnit(it, result)
		if (primaryResource) {
			result.add(commit)
		}
	}

	private def isPrimaryWorkingCopy(IJavaElementDelta delta) {
		delta.flags.bitwiseAnd(IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0
	}

	private def isPrimaryResource(IJavaElementDelta delta) {
		delta.flags.bitwiseAnd(IJavaElementDelta.F_PRIMARY_RESOURCE) != 0
	}
	
	override protected createContentChangeDelta(ICompilationUnit it, IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new UnsubmittedResourceDescriptionDelta(compilationUnitName, oldDescription, newDescription);
	}
	
	override protected createStructureChangeDelta(ICompilationUnit it, IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new UnconfirmedStructuralChangesDelta(project, compilationUnitName, oldDescription, newDescription)
	}

	def rollback(IJavaElementDelta it) {
		new RollbackResourceDescriptionDelta(compilationUnitName)
	}

	def commit(IJavaElementDelta it) {
		new CommitResourceDescriptionDelta(compilationUnitName)
	}

	def getCompilationUnitName(IJavaElementDelta it) {
		switch element : element {
			ICompilationUnit: element.compilationUnitName
			default: null
		}
	}

	def getCompilationUnitName(ICompilationUnit compilationUnit) {
		val fileName = compilationUnit.elementName
		val packageFragment = compilationUnit.parent as IPackageFragment
		return '''«IF !packageFragment.defaultPackage»«packageFragment.elementName».«ENDIF»«fileName»'''
	}

	def getProject(ICompilationUnit it) {
		val javaProject = javaProject
		if (javaProject == null) {
			return null
		}
		javaProject.project
	}

}

interface CompilationUnitDelta extends IResourceDescription.Delta {

	def String getCompilationUnitName()

}

class AbstractCompilationUnitDelta implements CompilationUnitDelta {

	val String compilationUnitName

	new(String compilationUnitName) {
		Preconditions.checkNotNull(compilationUnitName, "compilationUnitName cannot be null")
		this.compilationUnitName = compilationUnitName
	}

	override getCompilationUnitName() {
		compilationUnitName
	}

	override getNew() {
		null
	}

	override getOld() {
		null
	}

	override getUri() {
		null
	}

	override haveEObjectDescriptionsChanged() {
		false
	}

}

/**
 * <p>
 * Intances of this delta type are used to rollback unsubmitted deltas for the given compilation unit.
 * </p>
 */
class RollbackResourceDescriptionDelta extends AbstractCompilationUnitDelta {

	new(String compilationUnitName) {
		super(compilationUnitName)
	}

}

/**
 * <p>
 * Intances of this delta type are used to commit unsubmitted deltas for the given compilation unit.
 * </p>
 */
class CommitResourceDescriptionDelta extends AbstractCompilationUnitDelta {

	new(String compilationUnitName) {
		super(compilationUnitName)
	}

}

/**
 * <p>
 * Instances of this delta type are collected for the given compilation unit during reconcilation.
 * </p>
 */
class UnsubmittedResourceDescriptionDelta extends ChangedResourceDescriptionDelta implements CompilationUnitDelta {

	val String compilationUnitName

	new(String compilationUnitName, IResourceDescription old, IResourceDescription _new) {
		super(old, _new)
		Preconditions.checkNotNull(compilationUnitName, "compilationUnitName cannot be null")
		this.compilationUnitName = compilationUnitName
	}

	override getCompilationUnitName() {
		compilationUnitName
	}

}

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 */
class UnconfirmedStructuralChangesDelta extends UnsubmittedResourceDescriptionDelta {

	var buildNumber = -1

	val IProject project

	new(IProject project, String compilationUnitName, IResourceDescription old, IResourceDescription _new) {
		super(compilationUnitName, old, _new)
		Preconditions.checkNotNull(project)
		Preconditions.checkNotNull(old)
		Preconditions.checkNotNull(_new)
		this.project = project
	}

	def getBuildNumber() {
		buildNumber
	}

	def setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber
	}

	def getProject() {
		project
	}

}
