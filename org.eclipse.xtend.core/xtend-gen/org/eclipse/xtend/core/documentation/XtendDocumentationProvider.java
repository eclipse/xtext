/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.documentation;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendDocumentationProvider extends MultiLineCommentDocumentationProvider {
  @Override
  public String getDocumentation(final EObject o) {
    String _xblockexpression = null;
    {
      boolean _shouldBeHandled = this.shouldBeHandled(o);
      boolean _not = (!_shouldBeHandled);
      if (_not) {
        return null;
      }
      _xblockexpression = super.getDocumentation(o);
    }
    return _xblockexpression;
  }

  @Override
  public List<INode> getDocumentationNodes(final EObject o) {
    List<INode> _xblockexpression = null;
    {
      boolean _shouldBeHandled = this.shouldBeHandled(o);
      boolean _not = (!_shouldBeHandled);
      if (_not) {
        return CollectionLiterals.<INode>emptyList();
      }
      _xblockexpression = super.getDocumentationNodes(o);
    }
    return _xblockexpression;
  }

  /**
   * The Xtend parser constructs a synthetic nested AST element to hold annotations which should be ignored as a documentation provider
   */
  public boolean shouldBeHandled(final EObject o) {
    return (!((o instanceof XtendAnnotationTarget) && Objects.equal(o.eContainingFeature(), XtendPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO)));
  }
}
