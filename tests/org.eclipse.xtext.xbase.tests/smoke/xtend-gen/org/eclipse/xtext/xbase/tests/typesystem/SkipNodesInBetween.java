/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractSmokeTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipNodesInBetween extends AbstractSmokeTest {
  public void assertNonSmoking(final String input) throws Exception {
    final XExpression expression = this.expression(input);
    boolean _notEquals = ObjectExtensions.operator_notEquals(expression, null);
    if (_notEquals) {
      Resource _eResource = expression.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      ReplaceRegion region = null;
      BidiTreeIterable<INode> _asTreeIterable = rootNode.getAsTreeIterable();
      for (final INode node : _asTreeIterable) {
        {
          final int offset = node.getTotalOffset();
          final int length = node.getTotalLength();
          boolean _notEquals_1 = (length != 0);
          if (_notEquals_1) {
            boolean _or = false;
            boolean _or_1 = false;
            boolean _equals = ObjectExtensions.operator_equals(region, null);
            if (_equals) {
              _or_1 = true;
            } else {
              int _offset = region.getOffset();
              boolean _notEquals_2 = (_offset != offset);
              _or_1 = (_equals || _notEquals_2);
            }
            if (_or_1) {
              _or = true;
            } else {
              int _length = region.getLength();
              boolean _notEquals_3 = (_length != length);
              _or = (_or_1 || _notEquals_3);
            }
            if (_or) {
              ReplaceRegion _replaceRegion = new ReplaceRegion(offset, length, "");
              region = _replaceRegion;
              StringBuilder _stringBuilder = new StringBuilder(input);
              final StringBuilder builder = _stringBuilder;
              region.applyTo(builder);
              String _string = builder.toString();
              this.processExpression(_string);
            }
          }
        }
      }
    }
  }
}
