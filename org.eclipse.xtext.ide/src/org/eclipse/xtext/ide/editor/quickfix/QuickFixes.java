/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;

/**
 * Annotation Container for @{@link QuickFix} annotations. You can mark a method in a
 * {@link AbstractDeclarativeIdeQuickfixProvider} with this annotation to specify which issue codes the method offers
 * quick-fixes for. 

 * @author Heinrich Weichert
 * 
 * @since 2.24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Beta
public @interface QuickFixes {

	QuickFix[] value();

}
