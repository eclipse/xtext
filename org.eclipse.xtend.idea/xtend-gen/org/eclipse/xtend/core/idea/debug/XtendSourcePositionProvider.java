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
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
    return this.getOriginalIfExists(context, descriptor.getName());
  }
  
  protected SourcePosition getOriginalIfExists(final DebuggerContextImpl context, final String name) {
    final PsiElement ele = context.getContextElement();
    if ((ele instanceof LeafXtextPsiElement)) {
      final EObject eobj = ((LeafXtextPsiElement)ele).getINode().getSemanticElement();
      if ((eobj == null)) {
        return null;
      }
      final IScope scope = this.scopeProvider.getScope(eobj, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
      final IEObjectDescription element = scope.getSingleElement(QualifiedName.create(name));
      if (((element != null) && Objects.equal(element.getEObjectOrProxy().eResource(), eobj.eResource()))) {
        final ICompositeNode node = NodeModelUtils.getNode(element.getEObjectOrProxy());
        if ((node != null)) {
          final int offset = node.getOffset();
          return SourcePosition.createFromOffset(((LeafXtextPsiElement)ele).getXtextFile(), offset);
        }
      }
    }
    return null;
  }
}
