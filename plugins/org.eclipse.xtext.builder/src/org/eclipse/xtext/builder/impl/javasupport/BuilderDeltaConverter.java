/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.builder.impl.UnconfirmedResourceDescriptionDelta;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BuilderDeltaConverter extends DeltaConverter {

	@Inject
	public BuilderDeltaConverter(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper) {
		super(nameConverter, uriHelper);
	}

	@Override
	protected IResourceDescription.Delta createResourceDescriptionDelta(IType type, IResourceDescription old,
			TypeResourceDescription _new) {
		if (type == null || old == null || _new == null)
			return new ChangedResourceDescriptionDelta(old, _new);
		IProject project = type.getJavaProject().getProject();
		return new UnconfirmedResourceDescriptionDelta(project, old, _new);
	}
}
