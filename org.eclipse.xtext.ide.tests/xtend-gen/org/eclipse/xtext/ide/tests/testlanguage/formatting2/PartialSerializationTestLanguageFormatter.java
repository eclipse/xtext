/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.formatting2;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageFormatter extends AbstractFormatter2 {
  protected void _format(final Node obj, @Extension final IFormattableDocument document) {
    List<ISemanticRegion> _keywords = this.textRegionExtensions.regionFor(obj).keywords(";");
    for (final ISemanticRegion r : _keywords) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.append(document.prepend(r, _function), _function_1);
    }
    EList<Node> _children = obj.getChildren();
    for (final Node child : _children) {
      document.<Node>format(child);
    }
  }
  
  public void format(final Object obj, final IFormattableDocument document) {
    if (obj instanceof XtextResource) {
      _format((XtextResource)obj, document);
      return;
    } else if (obj instanceof Node) {
      _format((Node)obj, document);
      return;
    } else if (obj instanceof EObject) {
      _format((EObject)obj, document);
      return;
    } else if (obj == null) {
      _format((Void)null, document);
      return;
    } else if (obj != null) {
      _format(obj, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj, document).toString());
    }
  }
}
