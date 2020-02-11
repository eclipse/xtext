/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 */
public class UnconfirmedStructuralChangesDelta extends ChangedResourceDescriptionDelta {
	private int buildNumber = -1;

	private final IType type;

	public UnconfirmedStructuralChangesDelta(IType type, IResourceDescription oldDesc, IResourceDescription newDesc) {
		super(oldDesc, newDesc);
		Preconditions.<IType> checkNotNull(type);
		Preconditions.<IResourceDescription> checkNotNull(oldDesc);
		Preconditions.<IResourceDescription> checkNotNull(newDesc);
		this.type = type;
	}

	public int getBuildNumber() {
		return this.buildNumber;
	}

	public int setBuildNumber(int buildNumber) {
		return this.buildNumber = buildNumber;
	}

	public IProject getProject() {
		return this.type.getJavaProject().getProject();
	}
}
