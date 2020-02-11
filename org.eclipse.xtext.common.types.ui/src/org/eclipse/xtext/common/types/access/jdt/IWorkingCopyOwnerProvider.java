/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
@ImplementedBy(WorkingCopyOwnerProvider.class)
public interface IWorkingCopyOwnerProvider {
	public WorkingCopyOwner getWorkingCopyOwner(final IJavaProject javaProject, final ResourceSet resourceset);
	
	IWorkingCopyOwnerProvider DEFAULT = new IWorkingCopyOwnerProvider() {
		@Override
		public WorkingCopyOwner getWorkingCopyOwner(IJavaProject javaProject, ResourceSet resourceset) {
			return DefaultWorkingCopyOwner.PRIMARY;
		}
	};
}
