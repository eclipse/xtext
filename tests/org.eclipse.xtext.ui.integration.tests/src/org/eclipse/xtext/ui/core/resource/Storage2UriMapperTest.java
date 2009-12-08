/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperTest extends TestCase {
	
	public void testSimpleFileInProject() throws Exception {
		createProject("foo");
		IFile file = createFile("foo/bar/baz.txt", "");
		
		Storage2UriMapperImpl mapper = new Storage2UriMapperImpl() {
			@Override
			protected boolean isValidUri(URI uri) {
				return true;
			}
		};
		URI uri = mapper.getUri(file);
		assertEquals(URI.createPlatformResourceURI(file.getFullPath().toString(),true),uri);
		assertEquals(file,mapper.getStorages(uri).iterator().next());
	}
}
