/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.jdt.core.Flags;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
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
	
	public static class All implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return true;
		}
	}
	
	public static class None implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return false;
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
	}
	
	public static class CanInstantiate implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return !Flags.isAbstract(modifiers) && !Flags.isInterface(modifiers);
		}
	}

	public static class IsPublic implements ITypesProposalProvider.Filter {
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			return Flags.isPublic(modifiers);
		}
	}
}
