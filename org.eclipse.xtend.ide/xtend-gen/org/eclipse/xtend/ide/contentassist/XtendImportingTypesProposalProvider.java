/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
  @Override
  protected ConfigurableCompletionProposal.IReplacementTextApplier createTextApplier(final ContentAssistContext context, final IScope typeScope, final IQualifiedNameConverter qualifiedNameConverter, final IValueConverter<String> valueConverter) {
    final Predicate<IEObjectDescription> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return (!Objects.equal(_name, XtendImportedNamespaceScopeProvider.OLD_DATA_ANNOTATION));
    };
    final FilteringScope scope = new FilteringScope(typeScope, _function);
    return super.createTextApplier(context, scope, qualifiedNameConverter, valueConverter);
  }
}
