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
import org.eclipse.jdt.core.IType
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta
import org.eclipse.xtext.builder.builderState.IBuilderState

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class BuilderDeltaConverter extends DeltaConverter {

	@Inject
	new(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper, IBuilderState builderState) {
		super(nameConverter, uriHelper, builderState)
	}

	override createStructureChangeDelta(IType type, IResourceDescription oldDescription,
		IResourceDescription newDescription) {
		return new UnconfirmedStructuralChangesDelta(type, oldDescription, newDescription)
	}

}

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 */
class UnconfirmedStructuralChangesDelta extends ChangedResourceDescriptionDelta {

	var buildNumber = -1

	val IType type

	new(IType type, IResourceDescription old, IResourceDescription _new) {
		super(old, _new)
		Preconditions.checkNotNull(type)
		Preconditions.checkNotNull(old)
		Preconditions.checkNotNull(_new)
		this.type = type
	}

	def getBuildNumber() {
		buildNumber
	}

	def setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber
	}

	def getProject() {
		type.javaProject.project
	}

}
