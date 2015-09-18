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
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
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
    public XtextAutoBuilderComponentState encode(final ChunkedResourceDescriptions index, final Map<String, Source2GeneratedMapping> module2GeneratedMapping) {
      final Element indexData = this.toXml(index, "xtextIndex");
      final Element module2generatedData = this.toXml(module2GeneratedMapping, "module2generated");
      return new XtextAutoBuilderComponentState(indexData, module2generatedData);
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
  private Element index;
  
  @Tag
  private Element module2generated;
  
  protected XtextAutoBuilderComponentState() {
  }
  
  protected XtextAutoBuilderComponentState(final Element index, final Element module2generated) {
    this.index = index;
    this.module2generated = module2generated;
  }
}
