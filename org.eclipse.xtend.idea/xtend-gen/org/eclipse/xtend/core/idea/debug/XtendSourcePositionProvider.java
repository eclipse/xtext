/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.debug;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.debugger.SourcePosition;
import com.intellij.debugger.engine.SourcePositionProvider;
import com.intellij.debugger.impl.DebuggerContextImpl;
import com.intellij.debugger.ui.tree.NodeDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XbasePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSourcePositionProvider extends SourcePositionProvider {
  @Inject
  private IScopeProvider scopeProvider;
  
  public XtendSourcePositionProvider() {
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  protected SourcePosition computeSourcePosition(final NodeDescriptor descriptor, final Project project, final DebuggerContextImpl context, final boolean nearest) {
    String _name = descriptor.getName();
    return this.getOriginalIfExists(context, _name);
  }
  
  protected SourcePosition getOriginalIfExists(final DebuggerContextImpl context, final String name) {
    final PsiElement ele = context.getContextElement();
    if ((ele instanceof LeafXtextPsiElement)) {
      INode _iNode = ((LeafXtextPsiElement)ele).getINode();
      final EObject eobj = _iNode.getSemanticElement();
      boolean _equals = Objects.equal(eobj, null);
      if (_equals) {
        return null;
      }
      final IScope scope = this.scopeProvider.getScope(eobj, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
      QualifiedName _create = QualifiedName.create(name);
      final IEObjectDescription element = scope.getSingleElement(_create);
      if (((!Objects.equal(element, null)) && Objects.equal(element.getEObjectOrProxy().eResource(), eobj.eResource()))) {
        EObject _eObjectOrProxy = element.getEObjectOrProxy();
        final ICompositeNode node = NodeModelUtils.getNode(_eObjectOrProxy);
        boolean _notEquals = (!Objects.equal(node, null));
        if (_notEquals) {
          final int offset = node.getOffset();
          BaseXtextFile _xtextFile = ((LeafXtextPsiElement)ele).getXtextFile();
          return SourcePosition.createFromOffset(_xtextFile, offset);
        }
      }
    }
    return null;
  }
}
