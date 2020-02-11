/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import java.util.List;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractEditStrategyProvider {

	protected abstract void configure(IEditStrategyAcceptor iEditStrategyAcceptor);
	
	public List<IAutoEditStrategy> getStrategies(final ISourceViewer sourceViewer,final String contentType) {
		final List<IAutoEditStrategy> strategies = Lists.newArrayList();
		configure(new IEditStrategyAcceptor() {
			@Override
			public void accept(IAutoEditStrategy strategy, String type) {
				if (type == null || contentType.equals(type)) {
					if (strategy instanceof ISourceViewerAware) {
						((ISourceViewerAware) strategy).setSourceViewer(sourceViewer);
					}
					if (strategy instanceof VerifyKeyListener) {
						sourceViewer.getTextWidget().addVerifyKeyListener((VerifyKeyListener) strategy);
					}
					strategies.add(strategy);
				}
			}
		});
		return strategies;
	}

	public interface IEditStrategyAcceptor {
		public void accept(IAutoEditStrategy strategy, String contentType);
	}
	
}
