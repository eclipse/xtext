/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.reference.ui.Activator;
import org.eclipse.xtext.ui.service.ILabelProvider;
import org.eclipse.xtext.ui.service.impl.BuiltInLabelProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceGrammarLabelProvider extends BuiltInLabelProvider implements ILabelProvider {
	private Image rubberDuck;

	@Override
	public Image getIcon(EObject object) {
		try {
			if ("Spielzeug".equals(object.eClass().getName())
					&& "Ente".equals(object.eGet(object.eClass().getEAttributes().get(0)))) {
				if (rubberDuck == null)
					rubberDuck = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/rubber_duck.png")
							.createImage();
				return rubberDuck;
			}
		}
		catch (Throwable t) {
		}
		return super.getIcon(object);
	}
}
