/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug451668Test extends AbstractXtextTests {
  public static class TestResource extends DerivedStateAwareResource {
    private int contentsCalls = 0;
    
    @Override
    public synchronized EList<EObject> getContents() {
      this.contentsCalls++;
      return super.getContents();
    }
  }
  
  @Test
  public void testUnloadAndGetContents() throws IOException {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Class<OptionalEmptyTestLanguageStandaloneSetup> to Class<? extends ISetup>");
  }
}
