/*******************************************************************************
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testing;

import com.google.inject.Singleton;

/**
 * Basically copied from {@link org.junit.rules.TemporaryFolder}
 * which looks different in different junit versions and does not reset
 * the private field {@link #folder} on the {@link #after()} event.
 * 
 * Another change is that the folder is only created on demand.
 * 
 * The TemporaryFolder Rule allows creation of files and folders that are
 * guaranteed to be deleted when the test method finishes (whether it passes or
 * fails):
 * 
 * <pre>
 * public static class HasTempFolder {
 * 	&#064;Rule
 * 	public TemporaryFolder folder= new TemporaryFolder();
 * 
 * 	&#064;Test
 * 	public void testUsingTempFolder() throws IOException {
 * 		File createdFile= folder.newFile(&quot;myfile.txt&quot;);
 * 		File createdFolder= folder.newFolder(&quot;subfolder&quot;);
 * 		// ...
 * 	}
 * }
 * </pre>
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @deprecated Use {@link org.eclipse.xtext.testing.TemporaryFolder} instead
 * 
 * @since 2.7
 */
@Deprecated(since = "2.38", forRemoval = true)
@Singleton
public class TemporaryFolder extends org.eclipse.xtext.testing.TemporaryFolder {

}

