/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.uriHell.AbstractURIHandlerWithEcoreTest;
import org.eclipse.xtext.resource.uriHell.UnexpectedProxiesException;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class LoadedByClasspathFromMavenStructureTest extends AbstractURIHandlerWithEcoreTest {
  @Override
  public URI getResourceURI() {
    return URI.createURI("platform:/resource/org.eclipse.xtext/src/main/org/eclipse/xtext/Xtext.ecore");
  }
  
  @Override
  public URI getPackagedResourceURI() {
    return URI.createURI("classpath:/org/eclipse/xtext/Xtext.ecore");
  }
  
  @Override
  public URI getReferencedURI() {
    return URI.createURI("platform:/resource/org.eclipse.xtext.test/src/org/eclipse/xtext/resource/mydsl.ecore");
  }
  
  @Override
  public URI getPackagedReferencedURI() {
    URL url = this.classLoader.getResource("org/eclipse/xtext/resource/mydsl.ecore");
    if ((url == null)) {
      url = this.classLoader.getResource("/org/eclipse/xtext/resource/mydsl.ecore");
    }
    final String urlAsString = url.toString();
    return URI.createURI(urlAsString);
  }
  
  @Test(expected = UnexpectedProxiesException.class)
  @Override
  public void testLoadResourceWithPackagedURIs() {
    super.testLoadResourceWithPackagedURIs();
  }
}
