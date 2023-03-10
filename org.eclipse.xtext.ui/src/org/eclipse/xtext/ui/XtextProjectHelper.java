/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.google.common.base.Preconditions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextProjectHelper {

	public static final String NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature"; //$NON-NLS-1$
	public static final String BUILDER_ID = "org.eclipse.xtext.ui.shared.xtextBuilder"; //$NON-NLS-1$

	private static final Logger log = Logger.getLogger(XtextProjectHelper.class);

	public static boolean hasNature(IProject project) {
		Preconditions.checkNotNull(project);
		try {
			if (project.isAccessible()) {
				return project.hasNature(NATURE_ID);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	/**
	 * @since 2.4
	 */
	public static boolean hasBuilder(IProject project) {
		Preconditions.checkNotNull(project);
		if (project.isAccessible()) {
			try {
				for (ICommand command : project.getDescription().getBuildSpec()) {
					if (BUILDER_ID.equals(command.getBuilderName())) {
						return true;
					}
				}
			} catch (CoreException e) {
				log.error("Can't build due to an exception.", e);
			}
		}
		return false;
	}

}
