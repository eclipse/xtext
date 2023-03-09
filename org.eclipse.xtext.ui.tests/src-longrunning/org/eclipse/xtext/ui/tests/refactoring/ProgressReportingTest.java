/**
 * Copyright (c) 2019, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.refactoring;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;

/**
 * @author Christian Schneider - Initial contribution and API
 */
public class ProgressReportingTest extends AbstractResourceRelocationTest {
	public static class TestProgressMonitor extends NullProgressMonitor {
		private ArrayList<String> events = new ArrayList<>();

		private double accumulatedWork = 0.0d;

		@Override
		public void worked(int work) {
			accumulatedWork = accumulatedWork + work;
			events.add("Worked " +work + " (" + accumulatedWork + ")");
		}

		@Override
		public void internalWorked(double work) {
			accumulatedWork = (accumulatedWork + work);
			events.add("InternalWorked " + work + " (" + accumulatedWork + ")");
		}

		@Override
		public void beginTask(String name, int totalWork) {
			events.add("BeginTask " + name + (StringExtensions.isNullOrEmpty(name) ? "(" : " (") + totalWork + ")");
		}

		@Override
		public void subTask(String name) {
			events.add("SubTask " + name);
		}

		@Override
		public void setTaskName(String name) {
			events.add("SetTaskName " + name);
		}

		@Override
		public void done() {
			events.add("Done");
		}

		@Override
		public void setCanceled(boolean value) {
			super.setCanceled(value);
			events.add("Canceled");
		}

		public void assertLogged(List<String> expectation) {
			String eventsDump = IterableExtensions.join(events, "\n");
			String expectedEventsDump = IterableExtensions.join(expectation, "\n");
			if (!eventsDump.startsWith(expectedEventsDump)) {
				throw new ComparisonFailure("", expectedEventsDump, eventsDump);
			}
		}
	}

	@Test
	public void testProgressReportOfRenameCommonDir() throws Exception {
		String model =
				"package foo.bar\n" +
				"element X {\n" +
				"	ref X\n" +
				"}\n";
		IFile x = file("foo/X.fileawaretestlanguage", model);
		String model2 =
				"package foo\n" +
				"element Y {\n" +
				"	ref bar.X\n" +
				"}\n";
		IFile y = file("foo/Y.fileawaretestlanguage", model2);
		ProgressReportingTest.TestProgressMonitor monitor = new ProgressReportingTest.TestProgressMonitor();
		performRename(x.getParent(), "baz", monitor);
		Assert.assertFalse(x.exists());
		Assert.assertFalse(y.exists());
		List<String> expectation = new ArrayList<>();
		expectation.add("BeginTask (44)");
		expectation.add("SetTaskName Checking preconditions...");
		expectation.add("InternalWorked 4.0 (4.0)");
		expectation.add("SetTaskName Checking preconditions...");
		expectation.add("InternalWorked 22.22222222222222 (26.22222222222222)");
		expectation.add("SetTaskName Preparing the refactoring...");
		expectation.add("InternalWorked 1.777777777777778 (28.0)");
		expectation.add("SetTaskName Preparing and applying file changes...");
		expectation.add("InternalWorked 0.8355555555555556 (28.835555555555555)");
		expectation.add("InternalWorked 0.8355555555555556 (29.67111111111111)");
		expectation.add("InternalWorked 0.4177777777777778 (30.08888888888889)");
		expectation.add("InternalWorked 0.4177777777777778 (30.506666666666668)");
		expectation.add("InternalWorked 0.4177777777777778 (30.924444444444447)");
		expectation.add("InternalWorked 0.4177777777777778 (31.342222222222226)");
		expectation.add("SetTaskName Creating text changes...");
		expectation.add("InternalWorked 2.088888888888889 (33.431111111111115)");
		expectation.add("InternalWorked 0.8444444444444444 (34.275555555555556)");
		expectation.add("InternalWorked 0.8355555555555556 (35.111111111111114)");
		expectation.add("InternalWorked 2.2222222222222223 (37.333333333333336)");
		expectation.add("InternalWorked 6.666666666666664 (44.0)");
		expectation.add("Done");
		monitor.assertLogged(expectation);
	}

	protected void performRename(IResource theResource, String theNewName, IProgressMonitor monitor) throws Exception {
		RenameResourceDescriptor renameResourceDescriptor = new RenameResourceDescriptor();
		renameResourceDescriptor.setResourcePath(theResource.getFullPath());
		renameResourceDescriptor.setNewName(theNewName);
		renameResourceDescriptor.setProject(project.getName());
		performRefactoring(renameResourceDescriptor, monitor);
	}
}
