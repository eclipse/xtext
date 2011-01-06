/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseImportedNamespaceScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	protected List<ImportNormalizer> getImplicitImports() {
		return singletonList(new ImportNormalizer(QualifiedName.create("java","lang"), true));
	}
}
