/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.dialog;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EObjectDescriptionContentProvider implements ILazyContentProvider {

	private Iterable<IEObjectDescription> matches;

	private int currentCount;

	private Iterator<IEObjectDescription> currentIterator;

	private TableViewer viewer;

	private SizeCalculationJob sizeCalculationJob;
	
	private Label statusLabel;

	public EObjectDescriptionContentProvider(Label statusLabel) {
		this.statusLabel = statusLabel;
	}
	
	public void dispose() {
		viewer = null;
		matches = null;
		statusLabel = null;
		sizeCalculationJob.cancel();
		sizeCalculationJob = null;
	}

	@SuppressWarnings("unchecked")
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TableViewer) viewer;
		if (newInput instanceof Iterable<?>) {
			matches = (Iterable<IEObjectDescription>) newInput;
			reset();
			startSizeCalculation();
			viewer.refresh();
		}
	}

	public void updateElement(int index) {
		if (index < currentCount) {
			reset();
		}
		for (; index > currentCount && currentIterator.hasNext(); ++currentCount) {
			currentIterator.next();
		}
		if (currentIterator.hasNext()) {
			++currentCount;
			viewer.replace(currentIterator.next(), index);
		}
	}

	private void reset() {
		currentCount = 0;
		currentIterator = matches.iterator();
	}

	private void startSizeCalculation() {
		if (viewer != null) {
			if (sizeCalculationJob != null) {
				sizeCalculationJob.cancel();
				try {
					sizeCalculationJob.join();
				} catch (InterruptedException e) {
					sizeCalculationJob = new SizeCalculationJob();
				}
			} else {
				sizeCalculationJob = new SizeCalculationJob();
			}
			updateStatusLabel(false);
			sizeCalculationJob.init(matches);
			sizeCalculationJob.schedule();
		}
	}

	private void updateStatusLabel(boolean isFinished) {
		if(statusLabel != null) {
			statusLabel.setText((isFinished) ? "" : "Searching...");
		}
	}
	
	private final class SizeCalculationJob extends Job {

		private static final int TIME_THRESHOLD = 500;

		private static final int HIT_THRESHOLD = 100;

		private Iterator<IEObjectDescription> sizeIterator;

		private int currentSize;

		private SizeCalculationJob() {
			super("Calculate result size");
			setSystem(true);
		}

		public void init(Iterable<IEObjectDescription> matchResult) {
			this.sizeIterator = matchResult.iterator();
			currentSize = 0;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			long startTime = System.currentTimeMillis();
			while (sizeIterator.hasNext()) {
				sizeIterator.next();
				long endTime = System.currentTimeMillis();
				++currentSize;
				if (currentSize % HIT_THRESHOLD == 0 || endTime - startTime > TIME_THRESHOLD) {
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					updateItemCount(false);
				}
				startTime = endTime;
			}
			updateItemCount(true);
			return Status.OK_STATUS;
		}

		private void updateItemCount(final boolean isFinished) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (viewer != null) {
						viewer.setItemCount(currentSize);
					}
					updateStatusLabel(isFinished);
				}
			});
		}
	}
}