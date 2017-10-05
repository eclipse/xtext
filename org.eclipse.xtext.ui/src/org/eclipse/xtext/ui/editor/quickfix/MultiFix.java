/*******************************************************************************
 * Copyright (c) 2017 TypeFox (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xtext.ui.editor.model.edit.IContextFreeModification;
import org.eclipse.xtext.validation.Issue;

/**
 * Marker Annotation for multi-quickfix methods. You can mark a method in a {@link AbstractDeclarativeQuickfixProvider} with this annotation to
 * specify which issue codes the method offers multi-quickfixes for.
 * <code>@MultiFix(MyDslValidator.INVALID_NAME) public void fixIt(Issue issue, IssueResolutionAcceptor acceptor) {...} </code><br>
 * Inside the acceptor the {@link IssueResolutionAcceptor#accept(Issue, String, String, String, IContextFreeModification)} must be used.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MultiFix {
    String value();
}
