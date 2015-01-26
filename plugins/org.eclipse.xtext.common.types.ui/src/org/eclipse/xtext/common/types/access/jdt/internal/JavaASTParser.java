/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTRequestor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObjectToInt;
import org.eclipse.jdt.internal.core.BinaryMember;
import org.eclipse.jdt.internal.core.CancelableProblemFactory;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.SourceRefElement;
import org.eclipse.jdt.internal.core.util.DOMFinder;

/**
 * Internal copy of the ASTParser class from JDT to make certain functionality
 * available in the field of working copies.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class JavaASTParser {

	private static final int API_LEVEL; // AST.JLS8;
	
	static {
		int[] languageLevels = new int[] { 8, 4, 3 };
		int winner = -1;
		for(int languageLevel: languageLevels) {
			try {
				ASTParser.newParser(languageLevel);
				winner = languageLevel;
				break;
			} catch(IllegalArgumentException e) {
				// continue
			}
		}
		API_LEVEL = winner;
	}
	
	private final JavaProjectAccess javaProjectAccess;
	private Map<Object, Object> options;

	public JavaASTParser(JavaProjectAccess useMe) {
		this.javaProjectAccess = useMe;
		@SuppressWarnings("unchecked")
		Map<Object, Object> options = useMe.getJavaProject().getOptions(true);
		options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.DISABLED);
		this.options = options;
	}

	public IBinding[] createBindings(IJavaElement[] elements) {
		if (this.javaProjectAccess == null)
			throw new IllegalStateException("project or classpath not specified"); //$NON-NLS-1$
		int flags = ICompilationUnit.IGNORE_METHOD_BODIES;
		return resolve(elements, API_LEVEL, this.options, flags, null);
	}
	
	/* A list of int */
	static class IntArrayList {
		public int[] list = new int[5];
		public int length = 0;

		public void add(int i) {
			if (this.list.length == this.length) {
				System.arraycopy(this.list, 0, this.list = new int[this.length * 2], 0, this.length);
			}
			this.list[this.length++] = i;
		}
	}
	
	public IBinding[] resolve(
			final IJavaElement[] elements,
			int apiLevel,
			Map<?, ?> compilerOptions,
			int flags,
			IProgressMonitor monitor) {
		
			final int length = elements.length;
			final HashMap<Object, IntArrayList> sourceElementPositions = new HashMap<Object, IntArrayList>(); // a map from ICompilationUnit to int[] (positions in elements)
			int cuNumber = 0;
			final HashtableOfObjectToInt binaryElementPositions = new HashtableOfObjectToInt(); // a map from String (binding key) to int (position in elements)
			for (int i = 0; i < length; i++) {
				IJavaElement element = elements[i];
				if (!(element instanceof SourceRefElement))
					throw new IllegalStateException(element + " is not part of a compilation unit or class file"); //$NON-NLS-1$
				Object cu = element.getAncestor(IJavaElement.COMPILATION_UNIT);
				if (cu != null) {
					// source member
					IntArrayList intList = sourceElementPositions.get(cu);
					if (intList == null) {
						sourceElementPositions.put(cu, intList = new IntArrayList());
						cuNumber++;
					}
					intList.add(i);
				} else {
					// binary member
					try {
						String key = ((BinaryMember) element).getKey(true/*open to get resolved info*/);
						binaryElementPositions.put(key, i);
					} catch (JavaModelException e) {
						throw new IllegalArgumentException(element + " does not exist"); //$NON-NLS-1$
					}
				}
			}
			ICompilationUnit[] cus = new ICompilationUnit[cuNumber];
			sourceElementPositions.keySet().toArray(cus);

			int bindingKeyNumber = binaryElementPositions.size();
			String[] bindingKeys = new String[bindingKeyNumber];
			binaryElementPositions.keysToArray(bindingKeys);

			class Requestor extends ASTRequestor {
				
				IBinding[] bindings = new IBinding[length];
				@Override
				public void acceptAST(ICompilationUnit source, CompilationUnit ast) {
					// TODO (jerome) optimize to visit the AST only once
					IntArrayList intList = sourceElementPositions.get(source);
					for (int i = 0; i < intList.length; i++) {
						final int index = intList.list[i];
						SourceRefElement element = (SourceRefElement) elements[index];
						DOMFinder finder = new DOMFinder(ast, element, true/*resolve binding*/);
						try {
							finder.search();
						} catch (JavaModelException e) {
							throw new IllegalArgumentException(element + " does not exist"); //$NON-NLS-1$
						}
						this.bindings[index] = finder.foundBinding;
					}
				}
				@Override
				public void acceptBinding(String bindingKey, IBinding binding) {
					int index = binaryElementPositions.get(bindingKey);
					this.bindings[index] = binding;
				}
			}
			Requestor requestor = new Requestor();
			resolve(cus, bindingKeys, requestor, apiLevel, compilerOptions, flags, monitor);
			return requestor.bindings;
		}
	
	public void resolve(
			ICompilationUnit[] compilationUnits,
			String[] bindingKeys,
			ASTRequestor requestor,
			int apiLevel,
			Map<?, ?> options,
			int flags,
			IProgressMonitor monitor) {

			org.eclipse.xtext.common.types.access.jdt.internal.CancelableNameEnvironment environment = null;
			CancelableProblemFactory problemFactory = null;
			try {
				if (monitor != null) {
					int amountOfWork = (compilationUnits.length + bindingKeys.length) * 2; // 1 for beginToCompile, 1 for resolve
					monitor.beginTask("", amountOfWork); //$NON-NLS-1$
				}
				environment = javaProjectAccess.getNameEnvironment();
				problemFactory = new CancelableProblemFactory(monitor);
				CompilerOptions compilerOptions = getCompilerOptions(options, (flags & ICompilationUnit.ENABLE_STATEMENTS_RECOVERY) != 0);
				compilerOptions.ignoreMethodBodies = (flags & ICompilationUnit.IGNORE_METHOD_BODIES) != 0;
				CompilationUnitResolverAccess resolver = new CompilationUnitResolverAccess(environment, compilerOptions, problemFactory, javaProjectAccess.nameEnvironment != null);
				resolver.resolve(compilationUnits, bindingKeys, requestor, apiLevel, options, javaProjectAccess.getWorkingCopyOwner(), flags);
				if (NameLookup.VERBOSE) {
					System.out.println(Thread.currentThread() + " TIME SPENT in NameLoopkup#seekTypesInSourcePackage: " + environment.nameLookup.timeSpentInSeekTypesInSourcePackage + "ms");  //$NON-NLS-1$ //$NON-NLS-2$
					System.out.println(Thread.currentThread() + " TIME SPENT in NameLoopkup#seekTypesInBinaryPackage: " + environment.nameLookup.timeSpentInSeekTypesInBinaryPackage + "ms");  //$NON-NLS-1$ //$NON-NLS-2$
				}
			} catch (JavaModelException e) {
				// project doesn't exist -> simple parse without resolving
				ASTParser newParser = ASTParser.newParser(apiLevel);
				newParser.setIgnoreMethodBodies(true);
				newParser.setStatementsRecovery(false);
				newParser.setWorkingCopyOwner(javaProjectAccess.getWorkingCopyOwner());
				newParser.setCompilerOptions(options);
				newParser.setProject(javaProjectAccess.getJavaProject());
				newParser.setResolveBindings(false);
				newParser.createASTs(compilationUnits, bindingKeys, requestor, monitor);
			} finally {
				if (monitor != null) monitor.done();
			}
		}
	
	private static CompilerOptions getCompilerOptions(Map<?, ?> options, boolean statementsRecovery) {
		CompilerOptions compilerOptions = new CompilerOptions(options);
		compilerOptions.performMethodsFullRecovery = statementsRecovery;
		compilerOptions.performStatementsRecovery = statementsRecovery;
		compilerOptions.parseLiteralExpressionsAsConstants = false;
		compilerOptions.storeAnnotations = true /*store annotations in the bindings*/;
		compilerOptions.ignoreSourceFolderWarningOption = true;
		return compilerOptions;
	}
	
}


