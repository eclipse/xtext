/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.launching;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LaunchShortcutUtil {
	
	public static IStructuredSelection replaceWithJavaElementDelegates(IStructuredSelection selection, Class<? extends JavaElementDelegate> delegateType) {
		Object[] originalSelection = selection.toArray();
		Object[] fakeSelection = new Object[originalSelection.length];
		for(int i = 0; i < originalSelection.length; i++) {
			Object original = originalSelection[i];
			if (original == null || original instanceof IJavaElement || original instanceof JavaElementDelegate || !(original instanceof IAdaptable)) {
				fakeSelection[i] = original;
			} else {
				
				JavaElementDelegate javaElementDelegate = Adapters.adapt(original, delegateType);
				if (javaElementDelegate != null) {
					fakeSelection[i] = javaElementDelegate;
				} else {
					fakeSelection[i] = original;
				}
			}
		}
		StructuredSelection newSelection = new StructuredSelection(fakeSelection);
		return newSelection;
	}
	
}
