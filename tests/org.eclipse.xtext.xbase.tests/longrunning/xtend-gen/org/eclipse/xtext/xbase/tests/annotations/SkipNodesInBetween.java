/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.annotations;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.tests.annotations.AbstractSmokeTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipNodesInBetween extends AbstractSmokeTest {
  public void assertNonSmoking(final String input) throws Exception {
    Resource _newResource = this.newResource(input);
    final XtextResource resource = ((XtextResource) _newResource);
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
            boolean _notEquals = (_offset != offset);
            _or_1 = _notEquals;
          }
          if (_or_1) {
            _or = true;
          } else {
            int _length = region.getLength();
            boolean _notEquals_1 = (_length != length);
            _or = _notEquals_1;
          }
          if (_or) {
            ReplaceRegion _replaceRegion = new ReplaceRegion(offset, length, "");
            region = _replaceRegion;
            String _text = rootNode.getText();
            final StringBuilder builder = new StringBuilder(_text);
            region.applyTo(builder);
            String _string = builder.toString();
            this.processExpression(_string);
          }
        }
      }
    }
  }
}
