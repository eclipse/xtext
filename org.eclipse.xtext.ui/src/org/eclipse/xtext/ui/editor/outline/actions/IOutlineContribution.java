/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

import com.google.common.collect.Lists;
import com.google.inject.Binding;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IOutlineContribution extends IPreferenceStoreInitializer {

	@Retention(RUNTIME)
	@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface All {}
	
	@Retention(RUNTIME)
	@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface Sort {}

	@Retention(RUNTIME)
	@Target( { ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface LinkWithEditor {}

	void register(OutlinePage outlinePage);

	void deregister(OutlinePage outlinePage);
	
	class Composite implements IOutlineContribution {
		
		private List<IOutlineContribution> contributions;
		
		@Inject
		protected void initialize(Injector injector) {
            contributions = Lists.newArrayList();
			List<Binding<IOutlineContribution>> bindings = injector.findBindingsByType(TypeLiteral
					.get(IOutlineContribution.class));
			for (Binding<IOutlineContribution> binding : bindings) {
				contributions.add(injector.getInstance(binding.getKey()));
			}
		}
		
		@Override
		public void register(OutlinePage outlinePage) {
			for(IOutlineContribution contribution: contributions)
				contribution.register(outlinePage);
			TreeViewer treeViewer = outlinePage.getTreeViewer();
			if(!treeViewer.getTree().isDisposed()) 
				treeViewer.refresh();
		}
		
		@Override
		public void deregister(OutlinePage outlinePage) {
			for(IOutlineContribution contribution: contributions)
				contribution.deregister(outlinePage);
		}
		
		@Override
		public void initialize(IPreferenceStoreAccess access) {
			for(IOutlineContribution contribution: contributions)
				contribution.initialize(access);
		}
	}
}
