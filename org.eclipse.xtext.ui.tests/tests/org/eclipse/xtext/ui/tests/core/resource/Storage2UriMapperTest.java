/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperTest extends Assert {
	
	private IProject project;

	@Before
	public void createProjectFoo() throws Exception {
		project = createProject("foo");
	}
	
	@After
	public void deleteProjectFoo() throws Exception {
		project.delete(true, new NullProgressMonitor());
	}
	
	@Test public void testSimpleFileInProject() throws Exception {
		IFile file = createFile("foo/bar/baz.txt", "");
		
		Storage2UriMapperImpl mapper = new Storage2UriMapperImpl() {
			@Override
			public boolean isValidUri(URI uri, IStorage storage) {
				return true;
			}
		};
		mapper.setUriValidator(new UriValidator() {
			@Override
			public boolean isValid(URI uri, IStorage storage) {
				return true;
			}
			
			@Override
			public boolean isPossiblyManaged(IStorage storage) {
				return true;
			}
		});
		URI uri = mapper.getUri(file);
		assertEquals(URI.createPlatformResourceURI(file.getFullPath().toString(),true),uri);
		assertEquals(file,mapper.getStorages(uri).iterator().next().getFirst());
	}
}
