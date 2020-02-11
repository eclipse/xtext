/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.uriHell.LoadedByClasspathFromModelFolderURITest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class LoadedByClasspathFromModelFolderURITest2 extends LoadedByClasspathFromModelFolderURITest {
  @Override
  public URI getResourceURI() {
    return URI.createURI("platform:/resource/org.eclipse.xtext.tests/src/org/eclipse/xtext/resource/ecore/utf8.ecore");
  }
  
  @Override
  public URI getPackagedResourceURI() {
    return URI.createURI("classpath:/org/eclipse/xtext/resource/ecore/utf8.ecore");
  }
}
