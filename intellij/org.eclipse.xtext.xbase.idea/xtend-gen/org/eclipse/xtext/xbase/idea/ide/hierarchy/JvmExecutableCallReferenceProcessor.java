/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.ide.hierarchy;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.ide.hierarchy.call.CallHierarchyNodeDescriptor;
import com.intellij.ide.hierarchy.call.CallReferenceProcessor;
import com.intellij.ide.hierarchy.call.JavaCallHierarchyData;
import com.intellij.ide.util.treeView.NodeDescriptor;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMember;
import com.intellij.psi.PsiReference;
import java.util.Map;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.XtextPsiReference;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmExecutableCallReferenceProcessor implements CallReferenceProcessor {
  @Inject
  @Extension
  private IPsiLogicalContainerProvider _iPsiLogicalContainerProvider;
  
  private final IXtextLanguage language;
  
  public JvmExecutableCallReferenceProcessor(final IXtextLanguage language) {
    language.injectMembers(this);
    this.language = language;
  }
  
  @Override
  public boolean process(final PsiReference reference, final JavaCallHierarchyData data) {
    if ((reference instanceof XtextPsiReference)) {
      PsiElement _element = ((XtextPsiReference)reference).getElement();
      Language _language = _element.getLanguage();
      boolean _notEquals = (!Objects.equal(_language, this.language));
      if (_notEquals) {
        return true;
      }
      PsiElement _element_1 = ((XtextPsiReference)reference).getElement();
      final PsiElement element = this._iPsiLogicalContainerProvider.getNearestLogicalContainer(_element_1);
      final PsiMember key = CallHierarchyNodeDescriptor.getEnclosingElement(element);
      boolean _equals = Objects.equal(key, null);
      if (_equals) {
        return true;
      }
      final Map<PsiMember, NodeDescriptor> methodToDescriptorMap = data.getResultMap();
      /* methodToDescriptorMap; */
      synchronized (methodToDescriptorMap) {
        {
          NodeDescriptor _get = methodToDescriptorMap.get(key);
          CallHierarchyNodeDescriptor callHierarchyNodeDescriptor = ((CallHierarchyNodeDescriptor) _get);
          boolean _equals_1 = Objects.equal(callHierarchyNodeDescriptor, null);
          if (_equals_1) {
            Project _project = data.getProject();
            NodeDescriptor _nodeDescriptor = data.getNodeDescriptor();
            CallHierarchyNodeDescriptor _callHierarchyNodeDescriptor = new CallHierarchyNodeDescriptor(_project, 
              ((CallHierarchyNodeDescriptor) _nodeDescriptor), element, false, true);
            callHierarchyNodeDescriptor = _callHierarchyNodeDescriptor;
            methodToDescriptorMap.put(key, callHierarchyNodeDescriptor);
          } else {
            boolean _hasReference = callHierarchyNodeDescriptor.hasReference(reference);
            boolean _not = (!_hasReference);
            if (_not) {
              callHierarchyNodeDescriptor.incrementUsageCount();
            }
          }
          callHierarchyNodeDescriptor.addReference(reference);
        }
      }
      return false;
    }
    return true;
  }
}
