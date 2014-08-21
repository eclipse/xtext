/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
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

import java.util.List;

import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.IVisitsTestTrees;
import org.eclipse.jdt.internal.junit4.runner.JUnit4Identifier;
import org.junit.runner.Description;
import org.junit.runner.Request;

@SuppressWarnings("restriction")
public class JUnit4TestMethodReference extends JUnit4TestReference {
	private final Description fDescription;

	public JUnit4TestMethodReference(Class<?> clazz, String methodName, String[] failureNames) {
		Request request = Request.classWithoutSuiteMethod(clazz);
		Description rootDesc = request.getRunner().getDescription();
		Description desc = findDescriptionInTree(rootDesc, clazz.getName(), methodName);
		if (desc != null) {
			this.fDescription = desc;
			request = request.filterWith(new SetBasedFilter(desc));
		} else {
			System.err.println("Could not find \nclass:" + clazz.getName() + " \ntest:" + methodName + "\ninside:\n" + toString(rootDesc));
			this.fDescription = rootDesc;
		}
		if (failureNames != null) {
			request = request.sortWith(new FailuresFirstSorter(failureNames));
		}
		this.fRunner = request.getRunner();
	}

	private String toString(Description desc) {
		StringBuilder builder = new StringBuilder(desc.toString());
		List<Description> children = desc.getChildren();
		if (!children.isEmpty()) {
			builder.append(" {");
			for (Description obj : children) {
				builder.append("\n  ");
				builder.append(toString(obj).replace("\n", "\n  "));
			}
			builder.append("\n}");
		}
		return builder.toString();
	}

	public String getName() {
		return fDescription.toString();
	}

	public void sendTree(final IVisitsTestTrees notified) {
		sendDescriptionTree(notified, fDescription);
	}

	private Description findDescriptionInTree(Description desc, String expectClass, String expectedName) {
		if (expectedName.equals(desc.getDisplayName()) || (expectedName.equals(desc.getMethodName()) && expectClass.equals(desc.getClassName())))
			return desc;
		for (Description child : desc.getChildren()) {
			Description result = findDescriptionInTree(child, expectClass, expectedName);
			if (result != null)
				return result;
		}
		return null;
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
		if (!(obj instanceof JUnit4TestMethodReference))
			return false;

		JUnit4TestMethodReference ref = (JUnit4TestMethodReference) obj;
		return (ref.fDescription.equals(fDescription));
	}

	@Override
	public int hashCode() {
		return fDescription.hashCode();
	}

	@Override
	public String toString() {
		return fDescription.toString();
	}

	public ITestIdentifier getIdentifier() {
		return new JUnit4Identifier(fDescription);
	}

	@Override
	public int countTestCases() {
		return 1;
	}
}
