/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.util.Collections;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.web.server.test.HashMapSessionStore;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ResourcePersistenceTest extends AbstractWebServerTest {
  @Test
  public void testLoadFile() {
    try {
      final String resourceContent = "entity foo {}";
      final File file = this.createFile(resourceContent);
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final XtextServiceDispatcher.ServiceDescriptor load = _dispatcher.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)), sessionStore);
      boolean _isHasSideEffects = load.isHasSideEffects();
      Assert.assertFalse(_isHasSideEffects);
      boolean _isHasTextInput = load.isHasTextInput();
      Assert.assertFalse(_isHasTextInput);
      Function0<? extends IServiceResult> _service = load.getService();
      IServiceResult _apply = _service.apply();
      final ResourceContentResult result = ((ResourceContentResult) _apply);
      String _fullText = result.getFullText();
      Assert.assertEquals(resourceContent, _fullText);
      boolean _isDirty = result.isDirty();
      Assert.assertFalse(_isDirty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLoadDummy() {
    try {
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      final String resourceContent = "entity foo {}";
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", "dummy.entities");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", resourceContent);
      XtextServiceDispatcher.ServiceDescriptor update = _dispatcher.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)), sessionStore);
      Function0<? extends IServiceResult> _service = update.getService();
      _service.apply();
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("resource", "dummy.entities");
      XtextServiceDispatcher.ServiceDescriptor load = _dispatcher_1.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_2)), sessionStore);
      Function0<? extends IServiceResult> _service_1 = load.getService();
      IServiceResult _apply = _service_1.apply();
      ResourceContentResult result = ((ResourceContentResult) _apply);
      String _fullText = result.getFullText();
      Assert.assertEquals(resourceContent, _fullText);
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("resource", "dummy.entities");
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_6 = Pair.<String, String>of("deltaReplaceLength", "3");
      XtextServiceDispatcher.ServiceDescriptor _service_2 = _dispatcher_2.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6)), sessionStore);
      update = _service_2;
      Function0<? extends IServiceResult> _service_3 = update.getService();
      _service_3.apply();
      XtextServiceDispatcher _dispatcher_3 = this.getDispatcher();
      Pair<String, String> _mappedTo_7 = Pair.<String, String>of("resource", "dummy.entities");
      XtextServiceDispatcher.ServiceDescriptor _service_4 = _dispatcher_3.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_7)), sessionStore);
      load = _service_4;
      Function0<? extends IServiceResult> _service_5 = load.getService();
      IServiceResult _apply_1 = _service_5.apply();
      result = ((ResourceContentResult) _apply_1);
      String _fullText_1 = result.getFullText();
      Assert.assertEquals("entity bar {}", _fullText_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRevertFile() {
    try {
      final String resourceContent = "entity foo {}";
      final File file = this.createFile(resourceContent);
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final XtextServiceDispatcher.ServiceDescriptor load = _dispatcher.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)), sessionStore);
      Function0<? extends IServiceResult> _service = load.getService();
      _service.apply();
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), sessionStore);
      Function0<? extends IServiceResult> _service_1 = update.getService();
      _service_1.apply();
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      String _name_2 = file.getName();
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("resource", _name_2);
      final XtextServiceDispatcher.ServiceDescriptor revert = _dispatcher_2.getService("/revert", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5)), sessionStore);
      boolean _isHasSideEffects = revert.isHasSideEffects();
      Assert.assertTrue(_isHasSideEffects);
      boolean _isHasTextInput = revert.isHasTextInput();
      Assert.assertFalse(_isHasTextInput);
      Function0<? extends IServiceResult> _service_2 = revert.getService();
      IServiceResult _apply = _service_2.apply();
      final ResourceContentResult result = ((ResourceContentResult) _apply);
      String _fullText = result.getFullText();
      Assert.assertEquals(resourceContent, _fullText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSaveFile() {
    try {
      final File file = this.createFile("entity foo {}");
      final HashMapSessionStore sessionStore = new HashMapSessionStore();
      XtextServiceDispatcher _dispatcher = this.getDispatcher();
      String _name = file.getName();
      Pair<String, String> _mappedTo = Pair.<String, String>of("resource", _name);
      final XtextServiceDispatcher.ServiceDescriptor load = _dispatcher.getService("/load", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)), sessionStore);
      Function0<? extends IServiceResult> _service = load.getService();
      _service.apply();
      XtextServiceDispatcher _dispatcher_1 = this.getDispatcher();
      String _name_1 = file.getName();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name_1);
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("deltaText", "bar");
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("deltaOffset", "7");
      Pair<String, String> _mappedTo_4 = Pair.<String, String>of("deltaReplaceLength", "3");
      final XtextServiceDispatcher.ServiceDescriptor update = _dispatcher_1.getService("/update", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)), sessionStore);
      Function0<? extends IServiceResult> _service_1 = update.getService();
      _service_1.apply();
      XtextServiceDispatcher _dispatcher_2 = this.getDispatcher();
      String _name_2 = file.getName();
      Pair<String, String> _mappedTo_5 = Pair.<String, String>of("resource", _name_2);
      final XtextServiceDispatcher.ServiceDescriptor save = _dispatcher_2.getService("/save", Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5)), sessionStore);
      boolean _isHasSideEffects = save.isHasSideEffects();
      Assert.assertTrue(_isHasSideEffects);
      boolean _isHasTextInput = save.isHasTextInput();
      Assert.assertFalse(_isHasTextInput);
      Function0<? extends IServiceResult> _service_2 = save.getService();
      _service_2.apply();
      final String resourceContent = Files.toString(file, Charsets.UTF_8);
      Assert.assertEquals("entity bar {}", resourceContent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
