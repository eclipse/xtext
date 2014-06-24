/*******************************************************************************
 * Copyright (c) 2009 SpringSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andrew Eisenberg - initial API and implementation
 *     Andrew Eisenberg <andrew@eisenberg.as> - [JUnit] Rerun failed first does not work with JUnit4 - https://bugs.eclipse.org/bugs/show_bug.cgi?id=140392
 *******************************************************************************/

package org.eclipse.jdt.junit4.runtime.patch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.junit.runner.Description;

/**
 * Comparator for descriptions to sort according to inclusion in a failure list.
 * A description is considered to have failures if its name or one of its
 * transitive children's names are in the failures list. If neither or both have
 * failures, returns 0.
 * 
 * @since 3.6
 */
public class FailuresFirstSorter implements Comparator<Description> {

	private final Set<String> failuresList;

	/**
	 * Creates a sorter.
	 * 
	 * @param failuresList
	 *            list of failed tests based on the description's display string
	 */
	public FailuresFirstSorter(String[] failuresList) {
		this.failuresList = new HashSet<String>(Arrays.asList(failuresList));
	}

	/**
	 * Compares two descriptions based on the failure list.
	 * 
	 * @param d1
	 *            the first Description to compare with
	 * @param d2
	 *            the second Description to compare with
	 * @return -1 if only d1 has failures, 1 if only d2 has failures, 0
	 *         otherwise
	 */
	public int compare(Description d1, Description d2) {
		boolean d1HasFailures = hasFailures(d1);
		boolean d2HasFailures = hasFailures(d2);

		if (d1HasFailures) {
			return -1;
		} else if (d2HasFailures) {
			return 1;
		} else { // ((d1HasFailures && d2HasFailures) || (!d1HasFailures &&
					// !d2HasFailures))
			return 0;
		}
	}

	private boolean hasFailures(Description d) {
		if (failuresList.contains(d.getDisplayName())) {
			return true;
		} else {
			for (Description child : d.getChildren()) {
				if (hasFailures(child)) {
					return true;
				}
			}
		}
		return false;
	}

}
