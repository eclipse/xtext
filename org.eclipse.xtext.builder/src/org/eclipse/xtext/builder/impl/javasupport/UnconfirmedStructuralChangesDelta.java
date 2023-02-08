/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 * 
 * They are created by the {@link org.eclipse.xtext.common.types.ui.notification.DeltaConverter} which is
 * producing deltas based on {@link IJavaElementDelta jdt deltas}. After the Java compiler ran, the 
 * old state of the class files for the changed types can be compared to the new state for these files
 * and the unconfirmed delta can be confirmed or discarded.
 */
public class UnconfirmedStructuralChangesDelta extends ChangedResourceDescriptionDelta {
	private int buildNumber = -1;

	private final IType type;

	public UnconfirmedStructuralChangesDelta(IType type, IResourceDescription oldDesc, IResourceDescription newDesc) {
		super(oldDesc, newDesc);
		Preconditions.checkNotNull(type);
		Preconditions.checkNotNull(oldDesc);
		Preconditions.checkNotNull(newDesc);
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
