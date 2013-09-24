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
import org.eclipse.jdt.core.IType
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class BuilderDeltaConverter extends DeltaConverter {

	@Inject
	new(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper) {
		super(nameConverter, uriHelper)
	}

	override protected convertCompilationUnit(IJavaElementDelta delta, List<Delta> result) {
		super.convertCompilationUnit(delta, result)
		if (delta.primaryWorkingCopy && !delta.fineGrainedDelta && !delta.coarseGrainedDelta) {
			val type = getPrimaryTypeFrom(delta.element as ICompilationUnit)
			if (type != null) {
				result.add(new RollbackResourceDescriptionDelta(type))
			}
		}
	}

	private def isPrimaryWorkingCopy(IJavaElementDelta delta) {
		delta.flags.bitwiseAnd(IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0
	}

	override protected createResourceDescriptionDelta(IProject project, String primaryTypeName,
		IResourceDescription oldDescription, IResourceDescription newDescription) {
		if (oldDescription == null || newDescription == null) {
			return new UnsubmittedResourceDescriptionDelta(primaryTypeName, oldDescription, newDescription);
		}
		return new UnconfirmedStructuralChangesDelta(project, primaryTypeName, oldDescription, newDescription)
	}

}

/**
 * <p>
 * Intances of this delta type are used to rollback unsubmitted deltas for the given primary type.
 * </p>
 */
class RollbackResourceDescriptionDelta implements IResourceDescription.Delta {

	IType primaryType

	new(IType primaryType) {
		Preconditions.checkNotNull(primaryType)
		this.primaryType = primaryType
	}

	def getPrimaryTypeName() {
		primaryType.fullyQualifiedName
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
 * Instances of this delta type are collected for the given primary type during reconcilation.
 * </p>
 */
class UnsubmittedResourceDescriptionDelta extends DefaultResourceDescriptionDelta {

	val String primaryTypeName

	new(String primaryTypeName, IResourceDescription old, IResourceDescription _new) {
		super(old, _new)
		Preconditions.checkNotNull(primaryTypeName)
		this.primaryTypeName = primaryTypeName
	}

	def getPrimaryTypeName() {
		primaryTypeName
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

	new(IProject project, String primaryTypeName, IResourceDescription old, IResourceDescription _new) {
		super(primaryTypeName, old, _new)
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
