/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.ide.hierarchy;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.ide.hierarchy.HierarchyNodeDescriptor;
import com.intellij.ide.hierarchy.HierarchyTreeStructure;
import com.intellij.ide.hierarchy.call.CallHierarchyNodeDescriptor;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMember;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.searches.OverridingMethodsSearch;
import com.intellij.util.Query;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmExecutableCalleeMethodsTreeStructure extends HierarchyTreeStructure {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  private final String scopeType;
  
  public JvmExecutableCalleeMethodsTreeStructure(final Project project, final PsiMethod method, final String scopeType) {
    super(project, new CallHierarchyNodeDescriptor(project, null, method, true, false));
    Language _language = method.getLanguage();
    ((IXtextLanguage) _language).injectMembers(this);
    this.scopeType = scopeType;
  }
  
  @Override
  protected Object[] buildChildren(final HierarchyNodeDescriptor it) {
    Collection<CallHierarchyNodeDescriptor> _calledMethods = this.getCalledMethods(it);
    Collection<CallHierarchyNodeDescriptor> _overridingMethods = this.getOverridingMethods(it);
    return ((Object[])Conversions.unwrapArray(Iterables.<CallHierarchyNodeDescriptor>concat(_calledMethods, _overridingMethods), Object.class));
  }
  
  protected Collection<CallHierarchyNodeDescriptor> getOverridingMethods(final HierarchyNodeDescriptor descriptor) {
    PsiMethod _method = this.getMethod(descriptor);
    Query<PsiMethod> _search = OverridingMethodsSearch.search(_method, true);
    Iterable<PsiMethod> _inScope = this.inScope(_search);
    return this.toDescriptors(_inScope, descriptor);
  }
  
  protected Collection<CallHierarchyNodeDescriptor> getCalledMethods(final HierarchyNodeDescriptor descriptor) {
    Collection<CallHierarchyNodeDescriptor> _xblockexpression = null;
    {
      PsiMethod _method = this.getMethod(descriptor);
      PsiElement _primarySourceElement = this._iPsiJvmModelAssociations.getPrimarySourceElement(_method);
      final EObject sourceElement = this._iPsiModelAssociations.getEObject(_primarySourceElement);
      boolean _equals = Objects.equal(sourceElement, null);
      if (_equals) {
        return CollectionLiterals.<CallHierarchyNodeDescriptor>emptySet();
      }
      List<XAbstractFeatureCall> _eAllOfType = EcoreUtil2.<XAbstractFeatureCall>eAllOfType(sourceElement, XAbstractFeatureCall.class);
      final Function1<XAbstractFeatureCall, JvmIdentifiableElement> _function = new Function1<XAbstractFeatureCall, JvmIdentifiableElement>() {
        @Override
        public JvmIdentifiableElement apply(final XAbstractFeatureCall it) {
          return it.getFeature();
        }
      };
      List<JvmIdentifiableElement> _map = ListExtensions.<XAbstractFeatureCall, JvmIdentifiableElement>map(_eAllOfType, _function);
      Iterable<JvmExecutable> _filter = Iterables.<JvmExecutable>filter(_map, JvmExecutable.class);
      final Function1<JvmExecutable, PsiElement> _function_1 = new Function1<JvmExecutable, PsiElement>() {
        @Override
        public PsiElement apply(final JvmExecutable it) {
          return JvmExecutableCalleeMethodsTreeStructure.this._iPsiModelAssociations.getPsiElement(it);
        }
      };
      Iterable<PsiElement> _map_1 = IterableExtensions.<JvmExecutable, PsiElement>map(_filter, _function_1);
      Iterable<PsiMethod> _filter_1 = Iterables.<PsiMethod>filter(_map_1, PsiMethod.class);
      Iterable<PsiMethod> _inScope = this.inScope(_filter_1);
      _xblockexpression = this.toDescriptors(_inScope, descriptor);
    }
    return _xblockexpression;
  }
  
  protected Iterable<PsiMethod> inScope(final Iterable<PsiMethod> methods) {
    Iterable<PsiMethod> _xblockexpression = null;
    {
      HierarchyNodeDescriptor _baseDescriptor = this.getBaseDescriptor();
      PsiElement _targetElement = ((CallHierarchyNodeDescriptor) _baseDescriptor).getTargetElement();
      final PsiMethod baseMethod = ((PsiMethod) _targetElement);
      final PsiClass baseClass = baseMethod.getContainingClass();
      final Function1<PsiMethod, Boolean> _function = new Function1<PsiMethod, Boolean>() {
        @Override
        public Boolean apply(final PsiMethod method) {
          return Boolean.valueOf(JvmExecutableCalleeMethodsTreeStructure.this.isInScope(baseClass, method, JvmExecutableCalleeMethodsTreeStructure.this.scopeType));
        }
      };
      _xblockexpression = IterableExtensions.<PsiMethod>filter(methods, _function);
    }
    return _xblockexpression;
  }
  
  protected Collection<CallHierarchyNodeDescriptor> toDescriptors(final Iterable<PsiMethod> methods, final HierarchyNodeDescriptor descriptor) {
    Collection<CallHierarchyNodeDescriptor> _xblockexpression = null;
    {
      final LinkedHashMap<PsiMethod, CallHierarchyNodeDescriptor> nodeDescriptors = CollectionLiterals.<PsiMethod, CallHierarchyNodeDescriptor>newLinkedHashMap();
      for (final PsiMethod calledMethod : methods) {
        {
          final CallHierarchyNodeDescriptor nodeDescriptor = nodeDescriptors.get(calledMethod);
          boolean _equals = Objects.equal(nodeDescriptor, null);
          if (_equals) {
            CallHierarchyNodeDescriptor _callHierarchyNodeDescriptor = new CallHierarchyNodeDescriptor(this.myProject, descriptor, calledMethod, false, false);
            nodeDescriptors.put(calledMethod, _callHierarchyNodeDescriptor);
          } else {
            nodeDescriptor.incrementUsageCount();
          }
        }
      }
      _xblockexpression = nodeDescriptors.values();
    }
    return _xblockexpression;
  }
  
  protected PsiMethod getMethod(final HierarchyNodeDescriptor descriptor) {
    PsiMethod _xblockexpression = null;
    {
      final PsiMember method = ((CallHierarchyNodeDescriptor) descriptor).getEnclosingElement();
      PsiMethod _xifexpression = null;
      if ((method instanceof PsiMethod)) {
        _xifexpression = ((PsiMethod)method);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
