/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import java.util.List;

import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
@ImplementedBy(IReconcilingStrategyFactory.Default.class)
public interface IReconcilingStrategyFactory {

	IReconcilingStrategy create(ISourceViewer sourceViewer);

	class Default implements IReconcilingStrategyFactory {
		@Inject
		private Injector injector;

		public IReconcilingStrategy create(ISourceViewer sourceViewer) {
			Module reconcileStrategyModule = createReconcileStrategyModule(sourceViewer);
			Injector reconcileStrategyInjector = injector.createChildInjector(reconcileStrategyModule);
			XtextDocumentReconcileStrategy xtextReconcilingStrategy = createReconcilingStrategy(
					reconcileStrategyInjector, XtextDocumentReconcileStrategy.class);
			XtextSpellingReconcileStrategy spellingReconcilingStrategy = createReconcilingStrategy(
					reconcileStrategyInjector, XtextSpellingReconcileStrategy.class);
			CompositeReconcilingStrategy compositeReconcilingStrategy = createReconcilingStrategy(
					reconcileStrategyInjector, CompositeReconcilingStrategy.class);
			List<IReconcilingStrategy> reconcilingStrategies = Lists.<IReconcilingStrategy> newArrayList(
					xtextReconcilingStrategy, spellingReconcilingStrategy);
			compositeReconcilingStrategy.setReconcilingStrategies(reconcilingStrategies);
			return compositeReconcilingStrategy;
		}

		protected Module createReconcileStrategyModule(final ISourceViewer sourceViewer) {
			return new Module() {

				public void configure(Binder binder) {
					binder.bind(ISourceViewer.class).toInstance(sourceViewer);
				}
			};
		}

		protected <T extends IReconcilingStrategy> T createReconcilingStrategy(Injector reconcileStrategyInjector,
				Class<T> type) {
			Provider<T> provider = reconcileStrategyInjector.getProvider(type);
			return provider.get();
		}

	}
}
