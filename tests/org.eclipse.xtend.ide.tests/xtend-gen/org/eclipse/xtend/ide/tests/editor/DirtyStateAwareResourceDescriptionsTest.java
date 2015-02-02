/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.DirtyStateAwareResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateAwareResourceDescriptionsTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  private DirtyStateAwareResourceDescriptions dirtyStateAwareResourceDescriptions;
  
  @Before
  public void start() {
    try {
      this._workbenchTestHelper.closeWelcomePage();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void close() {
    try {
      this._workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDerivedJvmTypeInDelta() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class NoDebuggingCase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void call(NoDebuggingAcceptor inner) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(inner) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}   ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("interface NoDebuggingAcceptor {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def void accept(String typeImport)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("} ");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor editor = this._workbenchTestHelper.openEditor("foo.xtend", model);
      IXtextDocument _document = editor.getDocument();
      int _length = model.length();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class NoDebuggingCase {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void call() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("println() ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("} ");
      _builder_1.newLine();
      _builder_1.append("}");
      _document.replace(0, _length, _builder_1.toString());
      final IResourceDescription.Event events = this.waitForChangeEvent();
      final ImmutableList<IResourceDescription.Delta> deltas = events.getDeltas();
      int _size = deltas.size();
      Assert.assertEquals(3, _size);
      final Procedure1<IResourceDescription.Delta> _function = new Procedure1<IResourceDescription.Delta>() {
        @Override
        public void apply(final IResourceDescription.Delta d) {
          URI _uri = d.getUri();
          String _string = _uri.toString();
          InputOutput.<String>println(_string);
        }
      };
      IterableExtensions.<IResourceDescription.Delta>forEach(deltas, _function);
      IResourceDescription.Delta _get = deltas.get(0);
      URI _uri = _get.getUri();
      String _string = _uri.toString();
      Assert.assertEquals("platform:/resource/test.project/src/foo.xtend", _string);
      IResourceDescription.Delta _get_1 = deltas.get(1);
      URI _uri_1 = _get_1.getUri();
      String _string_1 = _uri_1.toString();
      Assert.assertEquals("java:/Objects/NoDebuggingCase", _string_1);
      IResourceDescription.Delta _get_2 = deltas.get(2);
      URI _uri_2 = _get_2.getUri();
      String _string_2 = _uri_2.toString();
      Assert.assertEquals("java:/Objects/NoDebuggingCase$NoDebuggingAcceptor", _string_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IResourceDescription.Event waitForChangeEvent() {
    try {
      IResourceDescription.Event _xblockexpression = null;
      {
        final ArrayList<IResourceDescription.Event> events = CollectionLiterals.<IResourceDescription.Event>newArrayList();
        final ArrayList<Boolean> listenToEvent = CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true));
        final IResourceDescription.Event.Listener _function = new IResourceDescription.Event.Listener() {
          @Override
          public void descriptionsChanged(final IResourceDescription.Event e) {
            Boolean _head = IterableExtensions.<Boolean>head(listenToEvent);
            if ((boolean) _head) {
              listenToEvent.set(0, Boolean.valueOf(false));
              events.add(e);
              DirtyStateAwareResourceDescriptionsTest.this.dirtyStateAwareResourceDescriptions.removeListener(this);
            }
          }
        };
        this.dirtyStateAwareResourceDescriptions.addListener(_function);
        final int maxAttempts = 5;
        int attempt = 0;
        while (((IterableExtensions.<Boolean>head(listenToEvent)).booleanValue() && (attempt < maxAttempts))) {
          {
            Thread.sleep(100);
            attempt = (attempt + 1);
          }
        }
        _xblockexpression = IterableExtensions.<IResourceDescription.Event>head(events);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
