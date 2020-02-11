/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Called to rename an element in the {@link IChangeSerializer} based refactoring.
 * 
 * Clients may extend the {@link DefaultImpl} to customize the behavior or implement
 * this interface directly.
 * 
 * Changes are usually performed in the The {@link RenameContext}
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public interface IRenameStrategy2 {
  class DefaultImpl implements IRenameStrategy2 {
    @Inject
    private IResourceServiceProvider resourceServiceProvider;
    
    public boolean canHandle(final RenameChange change) {
      return this.resourceServiceProvider.canHandle(change.getTargetURI());
    }
    
    @Override
    public void applyRename(final RenameContext context) {
      final Function1<RenameChange, Boolean> _function = (RenameChange it) -> {
        return Boolean.valueOf(this.canHandle(it));
      };
      final Consumer<RenameChange> _function_1 = (RenameChange change) -> {
        final IChangeSerializer.IModification<EObject> _function_2 = (EObject it) -> {
          this.doRename(it, change, context);
        };
        context.addModification(change, _function_2);
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
  }
  
  void applyRename(final RenameContext context);
}
