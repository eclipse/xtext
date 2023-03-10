/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

import com.google.common.collect.Lists;
import com.google.inject.Binding;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @since 2.7
 */
public interface IQuickOutlineContribution extends IPreferenceStoreInitializer {
	@Retention(RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
	@BindingAnnotation
	public @interface All {
	}

	void register(QuickOutlinePopup quickOutline, IMenuManager dialogMenu);

	void deregister(QuickOutlinePopup quickOutline);

	class Composite implements IQuickOutlineContribution {

		private List<IQuickOutlineContribution> contributions;

		@Inject
		protected void initialize(Injector injector) {
			contributions = Lists.newArrayList();
			List<Binding<IQuickOutlineContribution>> bindings = injector.findBindingsByType(TypeLiteral
					.get(IQuickOutlineContribution.class));
			for (Binding<IQuickOutlineContribution> binding : bindings) {
				contributions.add(injector.getInstance(binding.getKey()));
			}
		}

		@Override
		public void initialize(IPreferenceStoreAccess access) {
			for (IQuickOutlineContribution contribution : contributions)
				contribution.initialize(access);
		}

		@Override
		public void register(QuickOutlinePopup quickOutline, IMenuManager dialogMenu) {
			for (IQuickOutlineContribution contribution : contributions)
				contribution.register(quickOutline, dialogMenu);
			TreeViewer treeViewer = quickOutline.getTreeViewer();
			if (!treeViewer.getTree().isDisposed())
				treeViewer.refresh();
		}

		@Override
		public void deregister(QuickOutlinePopup quickOutline) {
			for (IQuickOutlineContribution contribution : contributions)
				contribution.deregister(quickOutline);
		}
	}
}
