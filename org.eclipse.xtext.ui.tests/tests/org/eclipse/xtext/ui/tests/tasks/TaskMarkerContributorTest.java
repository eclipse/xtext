/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.tasks;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class TaskMarkerContributorTest extends AbstractXtextTests {
	@Inject
	private TaskMarkerContributor markerContributor;

	@Before
	public void setup() {
		setInjector(TestsActivator.getInstance()
				.getInjector(TestsActivator.ORG_ECLIPSE_XTEXT_UI_TESTS_EDITOR_CONTENTASSIST_DOMAINMODELTESTLANGUAGE));
		injectMembers(this);
	}

	@Test
	public void testMarkerCreation() throws Exception {
		// @formatter:off
		String model =
				"/*\n" +
				" * TODO foo\n" +
				" * FIXME bar\n" +
				"*/\n";
		// @formatter:on
		IFile file = IResourcesSetupUtil.createFile("foo/foo.domainModelTest", model);
		XtextResource resource = getResource(file);
		markerContributor.updateMarkers(file, resource, new NullProgressMonitor());
		IMarker[] markers = file.findMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO);
		Arrays.sort(markers, Comparator.comparing((IMarker it) -> {
			try {
				return it.getAttribute(IMarker.LINE_NUMBER).toString();
			} catch (CoreException e) {
				throw new AssertionError(e);
			}
		}));
		Assert.assertEquals(2, markers.length);
		Assert.assertEquals("TODO foo", markers[0].getAttribute(IMarker.MESSAGE));
		Assert.assertEquals(2, markers[0].getAttribute(IMarker.LINE_NUMBER));
		Assert.assertEquals(6, markers[0].getAttribute(IMarker.CHAR_START));
		Assert.assertEquals(14, markers[0].getAttribute(IMarker.CHAR_END));
		Assert.assertEquals(IMarker.PRIORITY_NORMAL, markers[0].getAttribute(IMarker.PRIORITY));
		Assert.assertEquals("line 2", markers[0].getAttribute(IMarker.LOCATION));
		Assert.assertEquals("FIXME bar", markers[1].getAttribute(IMarker.MESSAGE));
		Assert.assertEquals(3, markers[1].getAttribute(IMarker.LINE_NUMBER));
		Assert.assertEquals(18, markers[1].getAttribute(IMarker.CHAR_START));
		Assert.assertEquals(27, markers[1].getAttribute(IMarker.CHAR_END));
		Assert.assertEquals(IMarker.PRIORITY_HIGH, markers[1].getAttribute(IMarker.PRIORITY));
		Assert.assertEquals("line 3", markers[1].getAttribute(IMarker.LOCATION));
	}

	public XtextResource getResource(IFile file) throws Exception {
		return getResource(IResourcesSetupUtil.fileToString(file), URI.createFileURI(file.getFullPath().toString()).toString());
	}

	@After
	public void cleanUp() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}
}
