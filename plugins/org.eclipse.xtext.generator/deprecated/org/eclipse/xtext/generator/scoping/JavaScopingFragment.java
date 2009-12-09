/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtext.generator.CompositeGeneratorFragment;
import org.eclipse.xtext.generator.exporting.SimpleNamesFragment;

/**
 * An {@link IGeneratorFragment} to create Java-based scoping.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @deprecated Superseded by {@link SimpleNamesFragment} and {@link ImportURIScopingFragment}
 */
@Deprecated
public class JavaScopingFragment extends CompositeGeneratorFragment {
	
	public JavaScopingFragment() {
		addFragment(new SimpleNamesFragment());
		addFragment(new ImportURIScopingFragment());
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		issues.addWarning("The JavaScopingFragment has been deprecated. It delegates to the SimpleNamesFragment and the ImportURIScopingFragment.");
		issues.addWarning("To learn more about exported names and visible elements, please have a look at the QualifiedNamesFragment and the ImportNamespacesFragment, too.");
	}
	
}
