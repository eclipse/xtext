/*******************************************************************************
 * Copyright (c) 2006, 2009 IBM Corporation and others.
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

import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.IVisitsTestTrees;
import org.eclipse.jdt.internal.junit4.runner.JUnit4Identifier;
import org.junit.runner.Description;
import org.junit.runner.Request;

@SuppressWarnings("restriction")
public class JUnit4TestClassReference extends JUnit4TestReference {
	protected final Class<?> fClass;

	public JUnit4TestClassReference(Class<?> clazz, String[] failureNames) {
		Request request = Request.aClass(clazz);
		if (failureNames != null) {
			request = request.sortWith(new FailuresFirstSorter(failureNames));
		}
		fRunner = request.getRunner();

		fClass = clazz;
	}

	public int countTestCases() {
		return fRunner.testCount();
	}

	public String getName() {
		return fClass.getName();
	}

	public void sendTree(final IVisitsTestTrees notified) {
		sendDescriptionTree(notified, fRunner.getDescription());
	}

	private void sendDescriptionTree(final IVisitsTestTrees notified, org.junit.runner.Description description) {
		if (description.isTest()) {
			notified.visitTreeEntry(new JUnit4Identifier(description), false, 1);
		} else {
			notified.visitTreeEntry(new JUnit4Identifier(description), true, description.getChildren().size());
			for (Description child : description.getChildren()) {
				sendDescriptionTree(notified, child);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JUnit4TestReference))
			return false;

		JUnit4TestReference ref = (JUnit4TestReference) obj;
		return (ref.getIdentifier().equals(getIdentifier()));
	}

	@Override
	public int hashCode() {
		return fClass.hashCode();
	}

	public ITestIdentifier getIdentifier() {
		return new JUnit4Identifier(fRunner.getDescription());
	}
}
