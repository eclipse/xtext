/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@ImplementedBy(IRenameStrategy.Impl.class)
@SuppressWarnings("all")
public interface IRenameStrategy {
  public static class Impl implements IRenameStrategy {
    @Inject
    private IResourceServiceProvider resourceServiceProvider;
    
    public boolean canHandle(final RenameChange change) {
      return this.resourceServiceProvider.canHandle(change.getTargetURI());
    }
    
    @Override
    public void loadAndWatchResources(final RenameContext context) {
      final Function1<RenameChange, Boolean> _function = (RenameChange it) -> {
        return Boolean.valueOf(this.canHandle(it));
      };
      final Consumer<RenameChange> _function_1 = (RenameChange change) -> {
        final Resource targetResource = context.getResourceSet().getResource(change.getTargetURI().trimFragment(), true);
        EcoreUtil.resolveAll(targetResource);
        context.getChangeSerializer().beginRecordChanges(targetResource);
      };
      IterableExtensions.filter(context.getChanges(), _function).forEach(_function_1);
    }
    
    @Override
    public void applyRename(final RenameContext context) {
      final Function1<RenameChange, Boolean> _function = (RenameChange it) -> {
        return Boolean.valueOf(this.canHandle(it));
      };
      final Consumer<RenameChange> _function_1 = (RenameChange change) -> {
        final EObject target = context.getResourceSet().getEObject(change.getTargetURI(), false);
        if ((target instanceof EObject)) {
          this.doRename(target, change, context);
        }
      };
      IterableExtensions.filter(context.getChanges(), _function).forEach(_function_1);
    }
    
    protected void doRename(final EObject target, final RenameChange change, final RenameContext context) {
      final EAttribute nameAttribute = this.getNameEAttribute(target);
      if ((nameAttribute != null)) {
        target.eSet(nameAttribute, change.getNewName());
      } else {
        String _name = target.eClass().getName();
        String _plus = ("Element of class " + _name);
        String _plus_1 = (_plus + " cannot be renamed.");
        context.getIssues().add(RefactoringIssueAcceptor.Severity.WARNING, _plus_1);
      }
    }
    
    protected EAttribute getNameEAttribute(final EObject target) {
      final Function1<EAttribute, Boolean> _function = (EAttribute it) -> {
        return Boolean.valueOf((Objects.equal(it.getName(), "name") && Objects.equal(it.getEType(), EcorePackage.Literals.ESTRING)));
      };
      return IterableExtensions.<EAttribute>head(IterableExtensions.<EAttribute>filter(target.eClass().getEAllAttributes(), _function));
    }
    
    @Override
    public String getCurrentName(final EObject element) {
      return element.eGet(this.getNameEAttribute(element)).toString();
    }
    
    @Override
    public void applySideEffects(final RenameContext context) {
    }
  }
  
  public abstract void loadAndWatchResources(final RenameContext context);
  
  public abstract void applyRename(final RenameContext context);
  
  public abstract void applySideEffects(final RenameContext context);
  
  public abstract String getCurrentName(final EObject element);
}
