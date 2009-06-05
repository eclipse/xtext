/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.common.editor.outline.transformer.DefaultSemanticModelTransformer;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class EcoreSemanticModelTransformer extends DefaultSemanticModelTransformer {
	
	private AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory());
	
	@Override
	public String getText(EObject object) {
		return provider.getText(object);
	}
	
	@Override
	public Image getImage(EObject object) {
		return provider.getImage(object);
	}
	
}
