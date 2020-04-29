/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.CompilationTemplateAdapter;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @since 2.7
 */
public class JvmTypeExtensions {
	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	public Procedure1<? super ITreeAppendable> getCompilationStrategy(JvmIdentifiableElement it) {
		CompilationStrategyAdapter adapter = Iterables
				.getFirst(Iterables.filter(it.eAdapters(), CompilationStrategyAdapter.class), null);
		if (adapter != null) {
			return adapter.getCompilationStrategy();
		}
		return null;
	}

	public StringConcatenationClient getCompilationTemplate(JvmIdentifiableElement it) {
		CompilationTemplateAdapter adapter = Iterables
				.getFirst(Iterables.filter(it.eAdapters(), CompilationTemplateAdapter.class), null);
		if (adapter != null) {
			return adapter.getCompilationTemplate();
		}
		return null;
	}

	public boolean isSingleSyntheticDefaultConstructor(JvmConstructor it) {
		return it.getParameters().isEmpty() && logicalContainerProvider.getAssociatedExpression(it) == null
				&& getCompilationStrategy(it) == null && getCompilationTemplate(it) == null && IterableExtensions
						.size(Iterables.filter(it.getDeclaringType().getMembers(), JvmConstructor.class)) == 1;
	}

	public boolean isSynthetic(JvmIdentifiableElement element) {
		return getMetaData(element).isSynthetic();
	}

	/**
	 * @since 2.8
	 */
	public boolean isSynthetic(JvmAnnotationReference element) {
		return getMetaData(element).isSynthetic();
	}

	public void setSynthetic(JvmIdentifiableElement element, boolean isSynthetic) {
		getMetaData(element).setSynthetic(isSynthetic);
	}

	/**
	 * @since 2.8
	 */
	public void setSynthetic(JvmAnnotationReference element, boolean isSynthetic) {
		getMetaData(element).setSynthetic(isSynthetic);
	}

	/**
	 * @since 2.8
	 */
	protected JvmIdentifiableMetaData getMetaData(EObject element) {
		JvmIdentifiableMetaData metaData = (JvmIdentifiableMetaData) EcoreUtil.getAdapter(element.eAdapters(),
				JvmIdentifiableMetaData.class);
		if (metaData == null) {
			metaData = new JvmIdentifiableMetaData();
			element.eAdapters().add(metaData);
		}
		return metaData;
	}
}
