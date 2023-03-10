/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Lists;

public class IteratorJob extends Job {

	private static final int TIME_THRESHOLD = 250;

	private Iterator<IEObjectDescription> iterator;

	private List<IEObjectDescription> matches;

	private final XtextEObjectSearchDialog dialog;

	public IteratorJob(XtextEObjectSearchDialog dialog) {
		super(Messages.IteratorJob_SearchJobName);
		this.dialog = dialog;
		setSystem(true);
	}

	public void init(Iterable<IEObjectDescription> matchResult) {
		this.iterator = matchResult.iterator();
		matches = Lists.newArrayList();
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		long startTime = System.currentTimeMillis();
		while (iterator.hasNext()) {
			IEObjectDescription next = iterator.next();
			if (next.getQualifiedName() != null && next.getEObjectURI() != null && next.getEClass() != null) {
				matches.add(next);
				long endTime = System.currentTimeMillis();
				if (matches.size() == dialog.getHeightInChars() || endTime - startTime > TIME_THRESHOLD) {
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					dialog.updateMatches(sortedCopy(matches), false);
					startTime = System.currentTimeMillis();
				}
			}
		}
		dialog.updateMatches(sortedCopy(matches), true);
		return Status.OK_STATUS;
	}

	private Collection<IEObjectDescription> sortedCopy(Iterable<IEObjectDescription> list) {
		List<IEObjectDescription> result = Lists.newArrayList(matches);
		Collections.sort(result, new Comparator<IEObjectDescription>() {
			@Override
			public int compare(IEObjectDescription o1, IEObjectDescription o2) {
				int diff = o1.getQualifiedName().compareToIgnoreCase(o2.getQualifiedName());
				if (diff == 0) {
					String className1 = o1.getEClass().getName();
					String className2 = o2.getEClass().getName();
					if(className1 == null)
						diff = className2 == null ? 0 : -1;
					else
						diff = className2 == null ? 1 : className1.compareToIgnoreCase(className2);
					if (diff == 0) {
						diff = o1.getEObjectURI().toString().compareTo(o2.getEObjectURI().toString());
					}
				}
				return diff;
			}
		});
		return result;
	}

}