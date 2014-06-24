/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   David Saff (saff@mit.edu) - initial API and implementation
 *             (bug 102632: [JUnit] Support for JUnit 4.)
 *******************************************************************************/

package org.eclipse.jdt.junit4.runtime.patch;

import org.junit.runner.Description;
import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;

@SuppressWarnings("restriction")
public class JUnit4Identifier implements ITestIdentifier {
	private final Description fPlan;

	public JUnit4Identifier(Description plan) {
		this.fPlan = plan;
	}

	public String getName() {
		return fPlan.getDisplayName();
	}

	@Override
	public int hashCode() {
		return fPlan.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JUnit4Identifier))
			return false;

		JUnit4Identifier id = (JUnit4Identifier) obj;
		return fPlan.equals(id.fPlan);
	}

}
