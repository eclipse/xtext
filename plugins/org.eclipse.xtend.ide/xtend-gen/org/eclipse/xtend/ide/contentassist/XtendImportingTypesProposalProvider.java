/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendImportingTypesProposalProvider extends ImportingTypesProposalProvider {
  protected ConfigurableCompletionProposal.IReplacementTextApplier createTextApplier(final ContentAssistContext context, final IScope typeScope, final IQualifiedNameConverter qualifiedNameConverter, final IValueConverter<String> valueConverter) {
    ConfigurableCompletionProposal.IReplacementTextApplier _xblockexpression = null;
    {
      final Predicate<IEObjectDescription> _function = new Predicate<IEObjectDescription>() {
        public boolean apply(final IEObjectDescription it) {
          QualifiedName _name = it.getName();
          return (!Objects.equal(_name, XtendImportedNamespaceScopeProvider.OLD_DATA_ANNOTATION));
        }
      };
      final FilteringScope scope = new FilteringScope(typeScope, _function);
      _xblockexpression = super.createTextApplier(context, scope, qualifiedNameConverter, valueConverter);
    }
    return _xblockexpression;
  }
}
