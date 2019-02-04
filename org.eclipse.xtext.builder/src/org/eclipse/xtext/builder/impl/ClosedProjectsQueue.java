/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.eclipse.emf.common.util.URI;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Singleton;

/**
 * A queue of resources that are supposed to be removed from the Xtext index.
 * The work is encapsulated by a ClosedProjectsQueue.Task.
 * 
 * @since 2.17
 */
@Beta
@Singleton
public class ClosedProjectsQueue {

	/**
	 * Encapsulates the changes that need to be performed after one or more projects have been removed / closed.
	 */
	public class Task {
		/**
		 * The names of the projects as encapsulated by this task.
		 */
		private final ImmutableSet<String> projectNames;
		/**
		 * The built data for this task.
		 */
		private final ToBeBuilt toBeBuilt;

		protected Task(ImmutableSet<String> projectNames, ToBeBuilt toBeBuilt) {
			this.projectNames = projectNames;
			this.toBeBuilt = toBeBuilt;
		}

		/**
		 * Returns true if the is an empty task.
		 *
		 * @return true if empty.
		 */
		public boolean isEmpty() {
			return toBeBuilt.getToBeDeleted().isEmpty();
		}

		/**
		 * Add the tasks again to the top of the queue.
		 */
		public void reschedule() {
			Set<URI> toBeDeleted = toBeBuilt.getToBeDeleted();
			if (toBeDeleted != null && !toBeDeleted.isEmpty()) {
				ToBeBuilt scheduleMe = new ToBeBuilt();
				scheduleMe.getToBeDeleted().addAll(toBeDeleted);
				insert(projectNames, scheduleMe);
			}
		}
		
		public ImmutableSet<String> getProjectNames() {
			return projectNames;
		}
		
		public ToBeBuilt getToBeBuilt() {
			return toBeBuilt;
		}
	}

	/**
	 * Use a concurrent linked queue internally to allow concurrent read and add operations.
	 */
	private final Deque<Task> internalQueue = new ConcurrentLinkedDeque<>();

	/**
	 * Add the given projects to the end of the build queue.
	 *
	 * @param projectNames
	 *            the projects to be cleaned.
	 * @param toBeBuilt
	 *            their contents.
	 */
	protected void enqueue(Set<String> projectNames, ToBeBuilt toBeBuilt) {
		internalQueue.addLast(new Task(ImmutableSet.copyOf(projectNames), toBeBuilt));
	}

	/**
	 * Add the given projects to the beginning of the build queue.
	 *
	 * @param projectNames
	 *            the projects to be cleaned.
	 * @param toBeBuilt
	 *            their contents.
	 */
	protected void insert(Set<String> projectNames, ToBeBuilt toBeBuilt) {
		internalQueue.addFirst(new Task(ImmutableSet.copyOf(projectNames), toBeBuilt));
	}

	/**
	 * Return the next task that contains all the enqueued projects.
	 *
	 * @return the normalized task that has all the stuff that is to be done.
	 */
	protected Task exhaust() {
		Set<String> projectNames = new LinkedHashSet<>();
		ToBeBuilt toBeBuilt = new ToBeBuilt();
		Set<URI> toBeDeleted = toBeBuilt.getToBeDeleted();
		Task next = internalQueue.poll();
		while (next != null) {
			Set<URI> nextToBeDeleted = next.toBeBuilt.getToBeDeleted();
			if (nextToBeDeleted != null && !nextToBeDeleted.isEmpty()) {
				projectNames.addAll(next.projectNames);
				toBeDeleted.addAll(nextToBeDeleted);
			}
			next = internalQueue.poll();
		}
		return new Task(ImmutableSet.copyOf(projectNames), toBeBuilt);
	}

}