/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.google.common.collect.Iterables;
import com.intellij.util.Base64;
import com.intellij.util.xmlb.annotations.Tag;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jdom.Content;
import org.jdom.Element;
import org.jdom.Text;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextAutoBuilderComponentState {
  public static class Codec {
    private final String SEP = ";";
    
    public XtextAutoBuilderComponentState encode(final IResourceServiceProvider.Registry registry, final ChunkedResourceDescriptions index, final Map<String, Source2GeneratedMapping> module2GeneratedMapping) {
      Element _element = new Element("installedLanguages");
      Map<String, Object> _extensionToFactoryMap = registry.getExtensionToFactoryMap();
      Set<String> _keySet = _extensionToFactoryMap.keySet();
      List<String> _list = IterableExtensions.<String>toList(_keySet);
      List<String> _sort = IterableExtensions.<String>sort(_list);
      String _join = IterableExtensions.join(_sort, this.SEP);
      final Element installedLanguages = _element.addContent(_join);
      final Element indexData = this.toXml(index, "xtextIndex");
      final Element module2generatedData = this.toXml(module2GeneratedMapping, "module2generated");
      return new XtextAutoBuilderComponentState(installedLanguages, indexData, module2generatedData);
    }
    
    protected Element toXml(final Object object, final String name) {
      try {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        try {
          oos.writeObject(object);
          oos.flush();
          final byte[] bytes = baos.toByteArray();
          final String encoded = Base64.encode(bytes);
          Element _element = new Element(name);
          final Procedure1<Element> _function = new Procedure1<Element>() {
            @Override
            public void apply(final Element it) {
              Text _text = new Text(encoded);
              it.addContent(_text);
            }
          };
          return ObjectExtensions.<Element>operator_doubleArrow(_element, _function);
        } finally {
          oos.close();
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public Set<String> decodeInstalledLanguages(final XtextAutoBuilderComponentState state) {
      if ((state.installedLanguages == null)) {
        return null;
      }
      String _text = state.installedLanguages.getText();
      String[] _split = _text.split(this.SEP);
      return IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(_split)));
    }
    
    public ChunkedResourceDescriptions decodeIndex(final XtextAutoBuilderComponentState state) {
      Object _object = this.toObject(state.index);
      return ((ChunkedResourceDescriptions) _object);
    }
    
    public Map<String, Source2GeneratedMapping> decodeModuleToGenerated(final XtextAutoBuilderComponentState state) {
      Object _object = this.toObject(state.module2generated);
      return ((Map<String, Source2GeneratedMapping>) _object);
    }
    
    protected Object toObject(final Element element) {
      try {
        List<Content> _content = element.getContent();
        Iterable<Text> _filter = Iterables.<Text>filter(_content, Text.class);
        Text _head = IterableExtensions.<Text>head(_filter);
        String _text = null;
        if (_head!=null) {
          _text=_head.getText();
        }
        final String content = _text;
        final byte[] bytes = Base64.decode(content);
        final ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        final ObjectInputStream ois = new ObjectInputStream(bais);
        try {
          return ois.readObject();
        } finally {
          ois.close();
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  @Tag
  private Element installedLanguages;
  
  @Tag
  private Element index;
  
  @Tag
  private Element module2generated;
  
  protected XtextAutoBuilderComponentState() {
  }
  
  protected XtextAutoBuilderComponentState(final Element installedLanguages, final Element index, final Element module2generated) {
    this.installedLanguages = installedLanguages;
    this.index = index;
    this.module2generated = module2generated;
  }
}
