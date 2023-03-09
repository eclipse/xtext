/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.actions;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IActionContributor {
	/**
	 * hook used to contribute any actions on editor start up.
	 */
	public void contributeActions(XtextEditor editor);
	
	public void editorDisposed(XtextEditor editor);
	
	/**
	 * composite action contributor delegating call to all registered {@link IActionContributor}
	 */
	public class CompositeImpl implements IActionContributor {
		
		@Inject
		private Injector injector;

		private List<IActionContributor> children = newArrayList();

		@Override
		public void contributeActions(XtextEditor editor) {
			List<Binding<IActionContributor>> bindingsByType = injector.findBindingsByType(TypeLiteral.get(IActionContributor.class));
			for (Binding<IActionContributor> binding : bindingsByType) {
				IActionContributor actionContributor = injector.getInstance(binding.getKey());
				actionContributor.contributeActions(editor);
				children.add(actionContributor);
			}
		}
		
		@Override
		public void editorDisposed(XtextEditor editor) {
			for (IActionContributor actionContributor: children) {
				actionContributor.editorDisposed(editor);
			}
		}

	}
}
