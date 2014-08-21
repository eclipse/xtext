/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LaunchShortcutUtil {

	public static IStructuredSelection replaceWithJavaElementDelegates(IStructuredSelection sel) {
		Object[] selection = sel.toArray();
		Object[] result = new Object[selection.length];
		for (int i = 0; i < selection.length; i++) {
			Object s = selection[i];
			if (s == null || s instanceof IJavaElement || s instanceof JUnitJavaElementDelegate || !(s instanceof IAdaptable))
				result[i] = s;
			else {
				IAdaptable adaptable = (IAdaptable) s;
				JUnitJavaElementDelegate delegate = (JUnitJavaElementDelegate) adaptable.getAdapter(JUnitJavaElementDelegate.class);
				result[i] = delegate != null ? delegate : s;
			}
		}
		StructuredSelection newSelection = new StructuredSelection(result);
		return newSelection;
	}

}
