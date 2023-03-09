/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker Annotation for quickfix methods. You can mark a method in a {@link AbstractDeclarativeQuickfixProvider} with this annotation to
 * specify which issue codes the method offers quickfixes for.
 * <code>@Fix(MyDslValidator.INVALID_NAME) public void fixIt(Issue issue, IssueResolutionAcceptor acceptor) {...} </code>. The annotation is
 * <code>@Repeatable</code> so you can specfiy it multiple times. Alternatively you can add the annotations to a @{@link Fixes} annotation
 * <code>@Fixes(@Fix(MyDslValidator.INVALID_NAME), @Fix(MyDslValidator.SOMETHING_ELSE))</code>.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Jan Koehnlein
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Fixes.class)
public @interface Fix {
    String value();
}
