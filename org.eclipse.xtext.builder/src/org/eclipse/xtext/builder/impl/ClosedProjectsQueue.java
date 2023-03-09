/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Singleton;

/**
 * A queue of resources that are supposed to be removed from the Xtext index. The work is encapsulated by a ClosedProjectsQueue.Task.
 * 
 * @since 2.17
 */
@Beta
@Singleton
public class ClosedProjectsQueue {

	/**
	 * @since 2.18
	 */
	private static final Logger log = Logger.getLogger(ClosedProjectsQueue.class);

	/**
	 * The system property {@code org.eclipse.xtext.builder.impl.ClosedProjectsQueue.MAX_ATTEMPTS} can be used to change the maximum number
	 * of attempts. Defaults to {@code 10}.
	 * 
	 * @since 2.18
	 */
	private static final int MAX_ATTEMPTS = Integer.getInteger("org.eclipse.xtext.builder.impl.ClosedProjectsQueue.MAX_ATTEMPTS", 10);

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
		/**
		 * A counter of the number of attempted reschedules so far.
		 * 
		 * If a task was rescheduled more than {@link #MAX_ATTEMPTS} times, it won't be rescheduled again.
		 * 
		 * @since 2.18
		 */
		private final int attempt;

		/**
		 * @since 2.18
		 */
		protected Task(ImmutableSet<String> projectNames, ToBeBuilt toBeBuilt, int attempt) {
			this.projectNames = projectNames;
			this.toBeBuilt = toBeBuilt;
			this.attempt = attempt;
		}

		protected Task(ImmutableSet<String> projectNames, ToBeBuilt toBeBuilt) {
			this(projectNames, toBeBuilt, 1);
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
		 * Add the tasks again to the top of the queue. If it was attemtped
		 */
		public void reschedule() {
			Set<URI> toBeDeleted = toBeBuilt.getToBeDeleted();
			if (toBeDeleted != null && !toBeDeleted.isEmpty()) {
				if (attempt > MAX_ATTEMPTS && MAX_ATTEMPTS > 0) {
					log.error("Attempt to reschedule task more than " + attempt + " times.", new Throwable());
				} else {
					ToBeBuilt scheduleMe = new ToBeBuilt();
					scheduleMe.getToBeDeleted().addAll(toBeDeleted);
					insert(projectNames, scheduleMe, attempt + 1);
				}
			}
		}

		public ImmutableSet<String> getProjectNames() {
			return projectNames;
		}

		public ToBeBuilt getToBeBuilt() {
			return toBeBuilt;
		}

		/**
		 * @since 2.18
		 */
		public int getAttempt() {
			return attempt;
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
	public void enqueue(Set<String> projectNames, ToBeBuilt toBeBuilt) {
		internalQueue.addLast(new Task(ImmutableSet.copyOf(projectNames), toBeBuilt));
	}

	/**
	 * Add the given projects to the beginning of the build queue.
	 *
	 * @param projectNames
	 *            the projects to be cleaned.
	 * @param toBeBuilt
	 *            their contents.
	 * @param attempt
	 *            the counter for the number of attempts.
	 * 
	 * @since 2.18
	 */
	public void insert(Set<String> projectNames, ToBeBuilt toBeBuilt, int attempt) {
		internalQueue.addFirst(new Task(ImmutableSet.copyOf(projectNames), toBeBuilt, attempt));
	}
	
	/**
	 * Add the given projects to the beginning of the build queue.
	 *
	 * @param projectNames
	 *            the projects to be cleaned.
	 * @param toBeBuilt
	 *            their contents.
	 */
	public void insert(Set<String> projectNames, ToBeBuilt toBeBuilt) {
		internalQueue.addFirst(new Task(ImmutableSet.copyOf(projectNames), toBeBuilt));
	}

	/**
	 * Return the next task that contains all the enqueued projects.
	 *
	 * @return the normalized task that has all the stuff that is to be done.
	 */
	public Task exhaust() {
		Set<String> projectNames = new LinkedHashSet<>();
		ToBeBuilt toBeBuilt = new ToBeBuilt();
		Set<URI> toBeDeleted = toBeBuilt.getToBeDeleted();
		Task next = internalQueue.poll();
		int attempt = 1;
		while (next != null) {
			attempt = Math.max(attempt, next.attempt);
			Set<URI> nextToBeDeleted = next.toBeBuilt.getToBeDeleted();
			if (nextToBeDeleted != null && !nextToBeDeleted.isEmpty()) {
				projectNames.addAll(next.projectNames);
				toBeDeleted.addAll(nextToBeDeleted);
			}
			next = internalQueue.poll();
		}
		return new Task(ImmutableSet.copyOf(projectNames), toBeBuilt, attempt);
	}

}