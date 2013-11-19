/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.typesystem.AbstractXtendCompilerSmokeTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipNodesInBetweenXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
  public XtendFile file(final String string, final boolean validate) throws Exception {
    XtextResourceSet _resourceSet = this.getResourceSet();
    URI _createURI = URI.createURI("abcdefg.xtend");
    final Resource resource = _resourceSet.createResource(_createURI);
    StringInputStream _stringInputStream = new StringInputStream(string);
    resource.load(_stringInputStream, null);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final XtendFile file = ((XtendFile) _head);
    return file;
  }
  
  public void assertNonSmoking(final CharSequence input) throws Exception {
    final String string = input.toString();
    final XtendFile file = this.file(string, false);
    boolean _notEquals = (!Objects.equal(file, null));
    if (_notEquals) {
      Resource _eResource = file.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      ReplaceRegion region = null;
      BidiTreeIterable<INode> _asTreeIterable = rootNode.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        {
          final int offset = node.getTotalOffset();
          final int length = node.getTotalLength();
          if ((length != 0)) {
            boolean _or = false;
            boolean _or_1 = false;
            boolean _equals = Objects.equal(region, null);
            if (_equals) {
              _or_1 = true;
            } else {
              int _offset = region.getOffset();
              boolean _notEquals_1 = (_offset != offset);
              _or_1 = (_equals || _notEquals_1);
            }
            if (_or_1) {
              _or = true;
            } else {
              int _length = region.getLength();
              boolean _notEquals_2 = (_length != length);
              _or = (_or_1 || _notEquals_2);
            }
            if (_or) {
              ReplaceRegion _replaceRegion = new ReplaceRegion(offset, length, "");
              region = _replaceRegion;
              String _text = rootNode.getText();
              StringBuilder _stringBuilder = new StringBuilder(_text);
              final StringBuilder builder = _stringBuilder;
              region.applyTo(builder);
              String _string = builder.toString();
              this.processFile(_string);
            }
          }
        }
      }
    }
  }
}
