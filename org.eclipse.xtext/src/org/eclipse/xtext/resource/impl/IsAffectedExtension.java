/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * An extension that can be bound to mark resources as affected
 * by a change. For example, if a validation depends on resources that are not
 * directly linked but which need to be considered when they have been changed.
 * 
 * Multiple such extensions can be bound by means of unique Guice binding annotations.
 * 
 * @since 2.22
 */
@Beta
public interface IsAffectedExtension {
	
	static class AllIsAffectedExtensions implements Provider<ImmutableList<IsAffectedExtension>> {

		@Inject
		protected Injector injector;

		@Override
		public ImmutableList<IsAffectedExtension> get() {
			ImmutableList.Builder<IsAffectedExtension> result = ImmutableList.builder();
			List<Binding<IsAffectedExtension>> bindings = injector
					.findBindingsByType(TypeLiteral.get(IsAffectedExtension.class));
			for (Binding<IsAffectedExtension> binding : bindings) {
				IsAffectedExtension extension = binding.getProvider().get();
				if (extension != null) {
					result.add(extension);
				}
			}
			return result.build();
		}

	}
	
	/**
	 * Answers true if the given candidate is impacted by the given delta beyond the default
	 * linking semantics. If the default answered true, an extension is never asked, e.g. it cannot
	 * contradict the default implementation or other extensions by turning their yes into a no.
	 */
	boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context);
}
