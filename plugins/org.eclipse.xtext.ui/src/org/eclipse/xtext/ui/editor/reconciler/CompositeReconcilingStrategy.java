/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;

import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class CompositeReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {
	private Logger log = Logger.getLogger(CompositeReconcilingStrategy.class);
	private List<IReconcilingStrategy> reconcilingStrategies = Lists.newArrayList();

	public void setReconcilingStrategies(List<IReconcilingStrategy> reconcilingStrategies) {
		Assert.isNotNull(reconcilingStrategies, "parameter 'reconcilingStrategies' must not be null");
		this.reconcilingStrategies = reconcilingStrategies;
	}

	public List<IReconcilingStrategy> getReconcilingStrategies() {
		return Collections.unmodifiableList(reconcilingStrategies);
	}

	public CompositeReconcilingStrategy() {
		super();
	}

	public CompositeReconcilingStrategy(List<IReconcilingStrategy> reconcilingStrategies) {
		super();
		setReconcilingStrategies(reconcilingStrategies);
	}

	public void setDocument(IDocument document) {
		for (IReconcilingStrategy reconcilingStrategy : reconcilingStrategies) {
			try {
				reconcilingStrategy.setDocument(document);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		for (IReconcilingStrategy reconcilingStrategy : reconcilingStrategies) {
			try {
				reconcilingStrategy.reconcile(dirtyRegion, subRegion);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	public void reconcile(IRegion partition) {
		for (IReconcilingStrategy reconcilingStrategy : reconcilingStrategies) {
			try {
				reconcilingStrategy.reconcile(partition);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		for (IReconcilingStrategy reconcilingStrategy : reconcilingStrategies) {
			if (reconcilingStrategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) reconcilingStrategy;
				try {
					extension.setProgressMonitor(monitor);
				} catch (Exception e) {
					handleException(e);
				}
			}
		}
	}

	public void initialReconcile() {
		for (IReconcilingStrategy reconcilingStrategy : reconcilingStrategies) {
			if (reconcilingStrategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) reconcilingStrategy;
				try {
					extension.initialReconcile();
				} catch (Exception e) {
					handleException(e);
				}
			}
		}
	}

	protected void handleException(Exception e) {
		log.error(e.getMessage(), e);
	}

}
