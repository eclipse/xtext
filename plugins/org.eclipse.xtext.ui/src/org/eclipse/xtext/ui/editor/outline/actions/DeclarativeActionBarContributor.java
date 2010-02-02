/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import java.lang.reflect.Method;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.editor.outline.actions.IActionBarContributor.DefaultActionBarContributor;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DeclarativeActionBarContributor extends DefaultActionBarContributor {

	@Override
	protected void addToolbarActions() {
		super.addToolbarActions();
		
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("add")) {
				if (method.getReturnType().equals(Action.class)) {
					Class<?>[] parameterTypes = method.getParameterTypes();
					if ((parameterTypes.length == 1) && (parameterTypes[0].equals(XtextContentOutlinePage.class))) {
						boolean wasAccessible = method.isAccessible();
						method.setAccessible(true);
						try {
							Object invocationResult = method.invoke(this, getOutlinePage());
							if (invocationResult instanceof Action) {
								Action action = (Action) invocationResult;
								add(action);
							}
						}
						catch (Exception e) {
							e.printStackTrace();
						}
						finally {
							method.setAccessible(wasAccessible);
						}
					}
				}
			}
		}
	}
}
