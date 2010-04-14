/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import java.lang.reflect.Method;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

/**
 * When closing the popup {@link XtextEditor}, the keybindings are lost. This tool offers a hack to restore them.
 * 
 * @author koehnlein
 */
public class PartReactivationUtil {

	/**
	 * Hack: Reactivate the given editor to restore its keybindings. Unfortunately that only works by switching to
	 * another part and back. If there is no other part, we use Java reflection to unset the active part first.
	 * 
	 * @param partToBeReactivated
	 */
	public static void forceReactivation(IWorkbenchPart partToBeReactivated) {
		try {
			IWorkbenchPage page = partToBeReactivated.getSite().getPage();
			IWorkbenchPart otherVisiblePart = findOtherVisiblePart(page, partToBeReactivated);
			if (otherVisiblePart != null) {
				page.activate(otherVisiblePart);
			} else {
				// evil reflective call of invisible method
				// TODO: method does not exist in 3.5.2 
				Method declaredMethod = page.getClass().getDeclaredMethod("setActivePart", IWorkbenchPart.class,
						Boolean.TYPE);
				declaredMethod.setAccessible(true);
				declaredMethod.invoke(page, null, true);
			}
			page.activate(partToBeReactivated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IWorkbenchPart findOtherVisiblePart(IWorkbenchPage page, IWorkbenchPart partToBeReactivated) {
		IViewReference[] viewReferences = page.getViewReferences();
		if (viewReferences != null) {
			for (IViewReference viewReference : viewReferences) {
				// hmmm, getPartState does always return IWorkbenchPage.STATE_RESTORED
				if (page.getPartState(viewReference) == IWorkbenchPage.STATE_RESTORED) {
					IViewPart part = viewReference.getView(false);
					if (part != null && part != partToBeReactivated) {
						return part;
					}
				}
			}
		}
		return null;
	}

}
