/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types.shared;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.ConstantBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.xtext.JvmIdentifiableQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.service.LanguageSpecific;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaSharedCommonTypesModule implements Module {
  @Override
  public void configure(final Binder binder) {
    AnnotatedConstantBindingBuilder _bindConstant = binder.bindConstant();
    Named _named = Names.named(Constants.FILE_EXTENSIONS);
    ConstantBindingBuilder _annotatedWith = _bindConstant.annotatedWith(_named);
    _annotatedWith.to("java");
    AnnotatedBindingBuilder<IQualifiedNameProvider> _bind = binder.<IQualifiedNameProvider>bind(IQualifiedNameProvider.class);
    _bind.to(JvmIdentifiableQualifiedNameProvider.class);
    AnnotatedBindingBuilder<IPsiModelAssociations> _bind_1 = binder.<IPsiModelAssociations>bind(IPsiModelAssociations.class);
    LinkedBindingBuilder<IPsiModelAssociations> _annotatedWith_1 = _bind_1.annotatedWith(LanguageSpecific.class);
    _annotatedWith_1.to(PsiModelAssociations.class);
  }
}
