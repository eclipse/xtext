/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.search;

import java.util.Collection;
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
			matches.add(iterator.next());
			long endTime = System.currentTimeMillis();
			if (matches.size() == dialog.getHeightInChars() || endTime - startTime > TIME_THRESHOLD) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				dialog.updateMatches(sortedCopy(matches), false);
				startTime = endTime;
			}
		}
		dialog.updateMatches(sortedCopy(matches), true);
		return Status.OK_STATUS;
	}
	
	private Collection<IEObjectDescription> sortedCopy(Iterable<IEObjectDescription> list) {
		return Lists.sortedCopy(matches, new Comparator<IEObjectDescription>() {
			public int compare(IEObjectDescription o1, IEObjectDescription o2) {
				int diff = o1.getQualifiedName().compareToIgnoreCase(o2.getQualifiedName());
				if(diff==0) {
					diff = o1.getEClass().getName().compareToIgnoreCase(o2.getEClass().getName());
					if(diff==0) {
						diff = o1.getEObjectURI().toString().compareTo(o2.getEObjectURI().toString());
					}
				}
				return diff;
			}
		});
	}

}