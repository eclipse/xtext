/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.resource;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperTest extends Assert {
	
	@Test public void testSimpleFileInProject() throws Exception {
		createProject("foo");
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
