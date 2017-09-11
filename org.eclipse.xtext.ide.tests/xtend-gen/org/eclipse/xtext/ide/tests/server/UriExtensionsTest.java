/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import javax.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class UriExtensionsTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Test
  public void testConversion() {
    Assert.assertEquals("file:///dir/name.ext", this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/name.ext")));
  }
  
  @Test
  public void testFileUriConversion() {
    Assert.assertEquals("file:///dir/name.ext", this._uriExtensions.toPath(URI.createFileURI("/dir/name.ext")));
  }
  
  @Test
  public void testFilesWithSpaces() {
    Assert.assertEquals("file:///dir/Foo Bar.testlang", this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/Foo Bar.testlang")));
  }
  
  @Test
  public void testFilesWithCyrillicSymbols() {
    Assert.assertEquals("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang", 
      this._uriExtensions.toPath(this._uriExtensions.toUri("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang")));
  }
  
  @Test
  public void testFolderIsPrefix() {
    File directory = new File("./test-data/test-project");
    URI uri = this._uriExtensions.toUri(this._uriExtensions.toPath(URI.createFileURI(directory.getAbsolutePath())));
    Assert.assertTrue(uri.isPrefix());
  }
}
