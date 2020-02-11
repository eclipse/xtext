/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceManagerTest {
  @Test
  public void testDoRead() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("string foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final URI path = this.operator_mappedTo("MyType1.testlang", _builder);
    this.workspaceManger.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(path)), CollectionLiterals.<URI>emptyList(), null);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Test {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Test foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String inMemContents = _builder_1.toString();
    this.workspaceManger.didOpen(path, Integer.valueOf(1), inMemContents).build(null);
    final Function2<Document, XtextResource, String> _function = (Document $0, XtextResource $1) -> {
      return $0.getContents();
    };
    Assert.assertEquals(inMemContents, this.workspaceManger.<String>doRead(path, _function));
  }
  
  @Inject
  protected WorkspaceManager workspaceManger;
  
  @Inject
  @Extension
  protected UriExtensions uriExtensions;
  
  @Before
  public void setup() {
    try {
      ServerModule _serverModule = new ServerModule();
      final Injector injector = Guice.createInjector(_serverModule);
      injector.injectMembers(this);
      File _file = new File("./test-data/test-project");
      this.root = _file;
      boolean _mkdirs = this.root.mkdirs();
      boolean _not = (!_mkdirs);
      if (_not) {
        Files.cleanFolder(this.root, null, true, false);
      }
      this.root.deleteOnExit();
      final Procedure2<URI, Iterable<Issue>> _function = (URI $0, Iterable<Issue> $1) -> {
        this.diagnostics.put($0, IterableExtensions.<Issue>toList($1));
      };
      this.workspaceManger.initialize(this.uriExtensions.withEmptyAuthority(URI.createFileURI(this.root.getAbsolutePath())), _function, null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void cleanup() {
    try {
      boolean _exists = this.root.exists();
      if (_exists) {
        Files.cleanFolder(this.root, null, true, true);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Map<URI, List<Issue>> diagnostics = CollectionLiterals.<URI, List<Issue>>newHashMap();
  
  protected File root;
  
  public URI operator_mappedTo(final String path, final CharSequence contents) {
    try {
      final File file = new File(this.root, path);
      file.getParentFile().mkdirs();
      file.createNewFile();
      FileWriter _fileWriter = new FileWriter(file);
      final Procedure1<FileWriter> _function = (FileWriter it) -> {
        try {
          it.write(contents.toString());
          it.close();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<FileWriter>operator_doubleArrow(_fileWriter, _function);
      return URI.createFileURI(file.getAbsolutePath());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
