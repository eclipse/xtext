/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * A marker interface that provides access to commonly used
 * qualified names.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IFeatureNames {

	QualifiedName THIS = QualifiedName.create("this");
	QualifiedName SUPER = QualifiedName.create("super");
	QualifiedName IT = QualifiedName.create("it");
	QualifiedName SELF = QualifiedName.create("self");
	
}
