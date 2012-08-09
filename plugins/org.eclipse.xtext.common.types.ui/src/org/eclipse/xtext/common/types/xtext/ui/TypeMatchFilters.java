/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.NameLookup.Answer;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider.Filter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class TypeMatchFilters {
	
	private TypeMatchFilters() {
		throw new AssertionError("May not be instantiated.");
	}
	
	public static ITypesProposalProvider.Filter all() {
		return new All();
	}
	
	/**
	 * @since 2.0
	 */
	public static ITypesProposalProvider.Filter all(int searchFor) {
		return new All(searchFor);
	}
	
	public static ITypesProposalProvider.Filter none() {
		return new None();
	}
	
	public static ITypesProposalProvider.Filter not(ITypesProposalProvider.Filter filter) {
		return new Not(filter);
	}
	
	public static ITypesProposalProvider.Filter and(ITypesProposalProvider.Filter... filter) {
		return new And(filter);
	}
	
	public static ITypesProposalProvider.Filter or(ITypesProposalProvider.Filter... filter) {
		return new Or(filter);
	}
	
	public static ITypesProposalProvider.Filter canInstantiate() {
		return new CanInstantiate();
	}
	
	public static ITypesProposalProvider.Filter isPublic() {
		return new IsPublic();
	}
	
	/**
	 * @since 2.2
	 */
	public static boolean isInternalClass(char[] simpleTypeName,
				char[][] enclosingTypeNames) {
		if (simpleTypeName[0] == '$')
			return true;
		if (enclosingTypeNames.length >= 1) {
			if (enclosingTypeNames[0][0] == '$')
				return true;
		}
		return false;
	}
	
	public static class All implements ITypesProposalProvider.Filter {
		
		private final int searchFor;

		/**
		 * @since 2.0
		 */
		public All(int searchFor) {
			this.searchFor = searchFor;
		}
		
		public All() {
			this(IJavaSearchConstants.TYPE);
		}

		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			if (isInternalClass(simpleTypeName, enclosingTypeNames)) {
				return false;
			}
			return true;
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return searchFor;
		}
	}
	
	public static class None implements ITypesProposalProvider.Filter {
		
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return false;
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return IJavaSearchConstants.TYPE;
		}
	}
	
	public static class Not implements ITypesProposalProvider.Filter {
		
		private final Filter delegate;
		
		public Not(ITypesProposalProvider.Filter delegate) {
			this.delegate = delegate;
		}
		
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return !delegate.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return delegate.getSearchFor();
		}
	}
	
	public static class And implements ITypesProposalProvider.Filter {
		
		private final Filter[] delegates;
		
		public And(ITypesProposalProvider.Filter[] delegates) {
			this.delegates = delegates;
			if (delegates.length < 1)
				throw new IllegalArgumentException("Cannot 'and' empty delegates");
		}
		
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			boolean result = true;
			int i = 0;
			while(result && i < delegates.length) {
				result = delegates[i].accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
				i++;
			}
			return result;
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return delegates[0].getSearchFor();
		}
	}
	
	public static class Or implements ITypesProposalProvider.Filter {
		
		private final Filter[] delegates;
		
		public Or(ITypesProposalProvider.Filter[] delegates) {
			this.delegates = delegates;
			if (delegates.length < 1)
				throw new IllegalArgumentException("Cannot 'or' empty delegates");
		}
		
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			boolean result = false;
			int i = 0;
			while(!result && i < delegates.length) {
				result = delegates[i].accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
				i++;
			}
			return result;
		}

		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return delegates[0].getSearchFor();
		}
	}
	
	public static class CanInstantiate implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			if (isInternalClass(simpleTypeName, enclosingTypeNames)) {
				return false;
			}
			return !Flags.isAbstract(modifiers) && !Flags.isInterface(modifiers);
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return IJavaSearchConstants.CLASS;
		}
	}
	
	/**
	 * @since 2.3
	 */
	public static class NonRestrictedAccess implements ITypesProposalProvider.Filter {
		
		private final static Logger log = Logger.getLogger(TypeMatchFilters.NonRestrictedAccess.class);
		
		private NameLookup nameLookup;

		public NonRestrictedAccess(IJavaProject project) {
			try {
				this.nameLookup = ((JavaProject) project).newNameLookup(new ICompilationUnit[0]);
			} catch (JavaModelException e) {
				log.error(e);
			}
		}

		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
				String path) {
			final String name = new String(packageName) + "." + new String(simpleTypeName);
			Answer answer = nameLookup.findType(name, false, NameLookup.ACCEPT_ALL, true);
			return answer != null && !answer.ignoreIfBetter();
		}

		public int getSearchFor() {
			return IJavaSearchConstants.TYPE;
		}
		
	}

	public static class IsPublic implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			if (isInternalClass(simpleTypeName, enclosingTypeNames)) {
				return false;
			}
			return Flags.isPublic(modifiers);
		}
		
		/**
		 * @since 2.0
		 */
		public int getSearchFor() {
			return IJavaSearchConstants.TYPE;
		}
	}

}
