/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.copyqualifiedname;

import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Deprecated class by moving base class to core
 * @since 2.4
 * @deprecated Use org.eclipse.xtext.naming.DefaultCopyQualifiedNameService instead
 */
@Deprecated
@SuppressWarnings("all")
public class DefaultCopyQualifiedNameService extends org.eclipse.xtext.naming.DefaultCopyQualifiedNameService implements CopyQualifiedNameService {
}
