/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextProjectHelper {

	public static final String NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature";

	private static final Logger log = Logger.getLogger(XtextProjectHelper.class);

	public static boolean hasNature(IProject project) {
		try {
			if (project.isAccessible()) {
				return project.hasNature(NATURE_ID);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

}
