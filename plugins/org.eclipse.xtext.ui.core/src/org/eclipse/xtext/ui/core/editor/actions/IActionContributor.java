/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.actions;

import java.util.List;

import org.eclipse.xtext.ui.core.editor.XtextEditor;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IActionContributor {
	/**
	 * hook used to contribute any actions on editor start up.
	 */
	public void contributeActions(XtextEditor editor);
	
	
	/**
	 * composite action contributor delegating call to all registered {@link IActionContributor}
	 */
	@Singleton
	public class CompositeImpl implements IActionContributor {
		
		@Inject
		private Injector injector;

		public void contributeActions(XtextEditor editor) {
			List<Binding<IActionContributor>> bindingsByType = injector.findBindingsByType(TypeLiteral.get(IActionContributor.class));
			for (Binding<IActionContributor> binding : bindingsByType) {
				IActionContributor actionContributor = injector.getInstance(binding.getKey());
				actionContributor.contributeActions(editor);
			}
		}

	}
}
