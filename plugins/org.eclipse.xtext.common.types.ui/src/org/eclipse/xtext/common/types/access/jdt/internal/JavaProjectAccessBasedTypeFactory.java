/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.access.jdt.AbstractJdtBasedTypeFactory;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class JavaProjectAccessBasedTypeFactory extends AbstractJdtBasedTypeFactory implements ITypeFactory<IType, JvmDeclaredType>, ITypeFactory.OptionsAware<IType, JvmDeclaredType> {

	private StoppedTask resolveBinding = Stopwatches.forTask("resolve binding (JavaProjectAccessBasedTypeFactory)");
	
	private JavaProjectAccess javaProjectAccess;

	protected JavaProjectAccessBasedTypeFactory(TypeURIHelper uriHelper, JavaProjectAccess javaProjectAccess) {
		super(uriHelper);
		this.javaProjectAccess = javaProjectAccess;
	}

	@Override
	protected WorkingCopyOwner getWorkingCopyOwner() {
		return javaProjectAccess.getWorkingCopyOwner();
	}

	@Override
	protected IBinding doResolveBindings(IType jdtType, IJavaProject javaProject) {
		JavaProjectAccess useMe = javaProjectAccess.access(javaProject);
		JavaASTParser parser = new JavaASTParser(useMe);
		IBinding binding = resolveBindings(jdtType, parser);
		if (binding == null) {
			IJavaProject fallbackProject = jdtType.getJavaProject();
			// fallback to the project of the given jdtType if it is different from the explicitly given project
			if (!fallbackProject.equals(javaProject)) {
				binding = resolveBindings(jdtType, new JavaASTParser(javaProjectAccess.access(fallbackProject)));
				if (binding == null) {
					throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + 
							"' in context of projects '" + javaProject.getElementName() + "' and '" + fallbackProject.getElementName() + "'.");
				}
			} else {
				throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + "' in context of project '" + javaProject.getElementName() + "'.");
			}
		}
		return binding;
	}
	
	private IBinding resolveBindings(IType jdtType, JavaASTParser parser) {
		resolveBinding.start();

		IBinding[] bindings = parser.createBindings(new IJavaElement[] { jdtType });
		resolveBinding.stop();
		return bindings[0];
	}

}
