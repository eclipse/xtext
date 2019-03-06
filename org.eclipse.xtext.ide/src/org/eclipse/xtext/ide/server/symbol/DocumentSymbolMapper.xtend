/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol

import com.google.common.annotations.Beta
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.SymbolKind
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Maps an EObject to the corresponding {@link DocumentSymbol document symbol}.
 */
@Beta
@Singleton
class DocumentSymbolMapper {

	@Inject
	DocumentSymbolNameProvider nameProvider;

	@Inject
	DocumentSymbolKindProvider kindProvider;

	@Inject
	DocumentSymbolRangeProvider rangeProvider;

	@Inject
	DocumentSymbolDetailsProvider detailsProvider;

	@Inject
	DocumentSymbolDeprecationInfoProvider deprecationInfoProvider;

	/**
	 * Converts the {@code EObject} argument into a {@link DocumentSymbol document symbol} without
	 * the {@link DocumentSymbol#children children} information filled in.
	 */
	def DocumentSymbol toDocumentSymbol(EObject object) {
		return new DocumentSymbol => [
			val objectName = nameProvider.getName(object)
			if (objectName !== null) {
				name = objectName;
			}
			val objectKind = kindProvider.getSymbolKind(object);
			if (objectKind !== null) {
				kind = objectKind
			}
			val objectRange = rangeProvider.getRange(object);
			if (objectRange !== null) {
				range = objectRange
			}
			val objectSelectionRange = rangeProvider.getSelectionRange(object);
			if (objectSelectionRange !== null) {
				selectionRange = objectSelectionRange
			}
			detail = detailsProvider.getDetails(object);
			deprecated = deprecationInfoProvider.isDeprecated(object);
			children = newArrayList;
		];
	}

	/**
	 * Provides {@link DocumentSymbol#detail detail} for a {@link DocumentSymbol document symbol}.
	 * <p>
	 * Always returns with an empty string by default.
	 * 
	 * @see DocumentSymbol#detail
	 */
	@Beta
	@Singleton
	static class DocumentSymbolDetailsProvider {

		def String getDetails(EObject object) {
			return '';
		}

	}

	/**
	 * Provides a human-readable name for the document symbol.
	 * 
	 * @see DocumentSymbol#name
	 */
	@Beta
	@Singleton
	static class DocumentSymbolNameProvider {

		@Inject
		extension IQualifiedNameProvider;

		def String getName(EObject object) {
			return object?.fullyQualifiedName.name;
		}

		def String getName(IEObjectDescription description) {
			return description?.name.name;
		}

		protected def String getName(QualifiedName qualifiedName) {
			return qualifiedName?.toString;
		}

	}

	/**
	 * Provides the {@link SymbolKind symbol kind} information for the document symbol.
	 * 
	 * @see DocumentSymbol#kind
	 */
	@Beta
	@Singleton
	static class DocumentSymbolKindProvider {

		def SymbolKind getSymbolKind(EObject object) {
			return object?.eClass.symbolKind;
		}

		def SymbolKind getSymbolKind(IEObjectDescription description) {
			return description?.EClass.symbolKind;
		}

		protected def SymbolKind getSymbolKind(EClass clazz) {
			return SymbolKind.Property;
		}
	}

	/**
	 * Provides {@link DocumentSymbol#range range} and {@link DocumentSymbol#selectionRange selection range} for a document symbol.
	 * 
	 * @see DocumentSymbol#range
	 * @see DocumentSymbol#selectionRange
	 */
	@Beta
	@Singleton
	static class DocumentSymbolRangeProvider {

		@Inject
		extension DocumentExtensions;

		/**
		 * The range enclosing this symbol not including leading/trailing whitespace but everything else
		 * like comments.
		 */
		def Range getRange(EObject object) {
			return object.newFullLocation?.range;
		}

		/**
		 * The range that should be selected and revealed when this symbol is being picked, e.g the name of a function.
		 */
		def Range getSelectionRange(EObject object) {
			return object.newLocation?.range;
		}

	}

	/**
	 * Determines whether a document symbol can be marked as {@link DocumentSymbol#deprecated deprecated}.
	 * 
	 * @see DocumentSymbol#deprecated
	 */
	@Beta
	@Singleton
	static class DocumentSymbolDeprecationInfoProvider {

		def boolean isDeprecated(EObject object) {
			return false;
		}

		def boolean isDeprecated(IEObjectDescription description) {
			return false;
		}

	}

}
