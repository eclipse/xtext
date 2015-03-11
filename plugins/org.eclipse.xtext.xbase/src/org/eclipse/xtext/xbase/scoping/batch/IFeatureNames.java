/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
