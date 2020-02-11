/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated If your generated {@link org.eclipse.xtext.ui.refactoring.IRenameStrategy} inherits form this, it is no
 *             longer being used as soon as you regenerate. In most cases the bound {@link DefaultJvmModelRenameStrategy} 
 *             should work fine for you. If not, inherit from {@link DefaultJvmModelRenameStrategy} instead. 
 *             See <a>https://bugs.eclipse.org/bugs/show_bug.cgi?id=363559} for details.</a>
 */
@Deprecated
public abstract class AbstractJvmModelRenameStrategy extends DefaultJvmModelRenameStrategy {
}
