/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.shared;

import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderModule;
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.idea.shared.IdeaJavaSupport;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaSharedModule extends StandaloneBuilderModule {
  @Override
  protected void configure() {
    super.configure();
    AnnotatedBindingBuilder<JavaSupport> _bind = this.<JavaSupport>bind(JavaSupport.class);
    _bind.to(IdeaJavaSupport.class);
  }
}
