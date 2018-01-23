/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
