/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.corext.util.TypeFilter;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider.Filter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class TypeMatchFilters {
	
	private TypeMatchFilters() {
		throw new AssertionError("May not be instantiated.");
	}
	
	/**
	 * @deprecated use {@link #isNotInternal()} instead
	 */
	@Deprecated
	public static ITypesProposalProvider.Filter all() {
		return new All();
	}
	
	/**
	 * @since 2.0
	 * @deprecated use {@link #isNotInternal(int)} instead
	 */
	@Deprecated
	public static ITypesProposalProvider.Filter all(int searchFor) {
		return new All(searchFor);
	}
	
	/**
	 * @since 2.9
	 */
	public static ITypesProposalProvider.Filter isNotInternal() {
		return new IsNotInternal();
	}
	
	/**
	 * @since 2.9
	 */
	public static ITypesProposalProvider.Filter isNotInternal(int searchFor) {
		return new IsNotInternal(searchFor);
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
	 * @since 2.9
	 */
	public static ITypesProposalProvider.Filter isAcceptableByPreference() {
		return new AcceptableByPreference();
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

	/**
	 * @since 2.9
	 */
	public static abstract class AbstractFilter implements ITypesProposalProvider.Filter {
		
		private final int searchFor;

		public AbstractFilter(int searchFor) {
			this.searchFor = searchFor;
		}
		
		public AbstractFilter() {
			this(IJavaSearchConstants.TYPE);
		}
		
		@Override
		public int getSearchFor() {
			return searchFor;
		}
	}

	/**
	 * @deprecated Use {@link IsNotInternal} instead
	 */
	@Deprecated
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

		@Override
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
		@Override
		public int getSearchFor() {
			return searchFor;
		}
	}
	
	/**
	 * This filter will accept all types except for internal classes (class names starting with $ character).
	 * @since 2.9
	 */
	public static class IsNotInternal extends AbstractFilter {
		public IsNotInternal(int searchFor) {
			super(searchFor);
		}
		
		public IsNotInternal() {
			super();
		}

		@Override
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			if (isInternalClass(simpleTypeName, enclosingTypeNames)) {
				return false;
			}
			return true;
		}
	}
	
	
	public static class None implements ITypesProposalProvider.Filter {
		
		@Override
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return false;
		}
		
		/**
		 * @since 2.0
		 */
		@Override
		public int getSearchFor() {
			return IJavaSearchConstants.TYPE;
		}
	}
	
	public static class Not implements ITypesProposalProvider.Filter {
		
		private final Filter delegate;
		
		public Not(ITypesProposalProvider.Filter delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return !delegate.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
		}
		
		/**
		 * @since 2.0
		 */
		@Override
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
		
		@Override
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
		@Override
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
		
		@Override
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
		@Override
		public int getSearchFor() {
			return delegates[0].getSearchFor();
		}
	}
	
	public static class CanInstantiate implements ITypesProposalProvider.Filter {
		@Override
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
		@Override
		public int getSearchFor() {
			return IJavaSearchConstants.CLASS;
		}
	}
	
	public static class IsPublic implements ITypesProposalProvider.Filter {
		@Override
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
		@Override
		public int getSearchFor() {
			return IJavaSearchConstants.TYPE;
		}
	}

	/**
	 * Restricts types by consideration of the JDT type filter preference.
	 * @since 2.9
	 */
	public static class AcceptableByPreference implements ITypesProposalProvider.Filter {
		private final int searchFor;

		public AcceptableByPreference() {
			this(IJavaSearchConstants.TYPE);
		}
		
		public AcceptableByPreference(int searchFor) {
			this.searchFor = searchFor;
		}
		
		@Override
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
				String path) {
			return !TypeFilter.isFiltered(packageName, simpleTypeName);
		}
		
		@Override
		public int getSearchFor() {
			return searchFor;
		}
	}

}
