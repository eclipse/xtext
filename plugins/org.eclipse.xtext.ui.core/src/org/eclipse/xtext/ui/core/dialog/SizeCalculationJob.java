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
import org.eclipse.xtext.resource.IEObjectDescription;

public class SizeCalculationJob extends Job {

	private static final int TIME_THRESHOLD = 500;

	private static final int HIT_THRESHOLD = 100;

	private Iterator<IEObjectDescription> sizeIterator;

	private int currentSize;

	private final XtextEObjectSearchDialog dialog;

	SizeCalculationJob(XtextEObjectSearchDialog dialog) {
		super(Messages.SizeCalculationJob_SearchJobName);
		this.dialog = dialog;
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
				dialog.updateItemCount(currentSize, false);
			}
			startTime = endTime;
		}
		dialog.updateItemCount(currentSize, true);
		return Status.OK_STATUS;
	}

}