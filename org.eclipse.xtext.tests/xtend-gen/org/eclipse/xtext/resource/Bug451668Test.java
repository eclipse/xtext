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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
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
    try {
      this.with(OptionalEmptyTestLanguageStandaloneSetup.class);
      Bug451668Test.TestResource r = this.<Bug451668Test.TestResource>get(Bug451668Test.TestResource.class);
      URI _createURI = URI.createURI("foo.dummy");
      r.setURI(_createURI);
      StringInputStream _stringInputStream = new StringInputStream("");
      r.load(_stringInputStream, null);
      boolean _isLoaded = r.isLoaded();
      Assert.assertTrue(_isLoaded);
      final int callsBeforeUnload = r.contentsCalls;
      r.unload();
      Assert.assertEquals(callsBeforeUnload, r.contentsCalls);
      boolean _isLoaded_1 = r.isLoaded();
      Assert.assertFalse(_isLoaded_1);
      IParseResult _parseResult = r.getParseResult();
      Assert.assertNull(_parseResult);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
