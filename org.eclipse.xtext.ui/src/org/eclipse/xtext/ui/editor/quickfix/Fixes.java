/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Container for @{@link Fix} annotations.
 * 
 * You can mark a method in a {@link AbstractDeclarativeQuickfixProvider} with this annotation to specify which issue codes the method offers quickfixes for.
 * 
 * <code>
@Fixes(@Fix(MyDslValidator.INVALID_NAME), @Fix(MyDslValidator.SOMETHING_ELSE)) public void fixIt(Issue issue, IssueResolutionAcceptor acceptor) { ... }</code>
 * 
 * @author dietrich - Initial contribution and API
 * @since 2.12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Fixes {
	
	Fix[] value();

}
