/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.List;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class CompoundXtextEditorCallback extends AbstractCompoundXtextEditorCallback {

	@Inject
	public CompoundXtextEditorCallback(Injector injector) {
		if (injector != null) {
			List<Binding<IXtextEditorCallback>> bindingsByType = injector.findBindingsByType(TypeLiteral
					.get(IXtextEditorCallback.class));
			for (Binding<IXtextEditorCallback> binding : bindingsByType) {
				try {
					addCallback(binding.getProvider().get());
				} catch (Exception e) {
					handle(e);
				}
			}
			addCallback(injector.getInstance(ObservableEditorCallback.class));
		}
	}
	
}
