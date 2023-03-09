/**
 * Copyright (c) 2018, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.symbol;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Maps an EObject to the corresponding {@link DocumentSymbol document symbol}.
 */
@Beta
@Singleton
public class DocumentSymbolMapper {
	/**
	 * Provides {@link DocumentSymbol#detail detail} for a {@link DocumentSymbol document symbol}.
	 * <p>
	 * Always returns an empty string by default.
	 * 
	 * @see DocumentSymbol#detail
	 */
	@Beta
	@Singleton
	public static class DocumentSymbolDetailsProvider {
		public String getDetails(EObject object) {
			return "";
		}
	}

	/**
	 * Provides a human-readable name for the document symbol.
	 * 
	 * @see DocumentSymbol#name
	 */
	@Beta
	@Singleton
	public static class DocumentSymbolNameProvider {
		@Inject
		private IQualifiedNameProvider qualifiedNameProvider;

		public String getName(EObject object) {
			return getName(object != null ? qualifiedNameProvider.getFullyQualifiedName(object) : null);
		}

		public String getName(IEObjectDescription description) {
			return getName(description != null ? description.getName() : null);
		}

		protected String getName(QualifiedName qualifiedName) {
			if (qualifiedName != null) {
				return qualifiedName.toString();
			}
			return null;
		}
	}

	/**
	 * Provides the {@link SymbolKind symbol kind} information for the document symbol.
	 * 
	 * @see DocumentSymbol#kind
	 */
	@Beta
	@Singleton
	public static class DocumentSymbolKindProvider {
		public SymbolKind getSymbolKind(EObject object) {
			return getSymbolKind(object != null ? object.eClass() : null);
		}

		public SymbolKind getSymbolKind(IEObjectDescription description) {
			return this.getSymbolKind(description != null ? description.getEClass() : null);
		}

		protected SymbolKind getSymbolKind(EClass clazz) {
			return SymbolKind.Property;
		}
	}

	/**
	 * Provides {@link DocumentSymbol#range range} and {@link DocumentSymbol#selectionRange selection range} for a
	 * document symbol.
	 * 
	 * @see DocumentSymbol#range
	 * @see DocumentSymbol#selectionRange
	 */
	@Beta
	@Singleton
	public static class DocumentSymbolRangeProvider {
		@Inject
		private DocumentExtensions documentExtensions;

		/**
		 * The range enclosing this symbol not including leading/trailing whitespace but everything else like comments.
		 */
		public Range getRange(EObject object) {
			Location newFullLocation = documentExtensions.newFullLocation(object);
			if (newFullLocation != null) {
				return newFullLocation.getRange();
			}
			return null;
		}

		/**
		 * The range that should be selected and revealed when this symbol is being picked, e.g the name of a function.
		 */
		public Range getSelectionRange(EObject object) {
			Location newLocation = documentExtensions.newLocation(object);
			if (newLocation != null) {
				return newLocation.getRange();
			}
			return null;
		}
	}

	/**
	 * Determines whether a document symbol can be marked as {@link DocumentSymbol#deprecated deprecated}.
	 * 
	 * @see DocumentSymbol#deprecated
	 */
	@Beta
	@Singleton
	public static class DocumentSymbolDeprecationInfoProvider {
		public boolean isDeprecated(EObject object) {
			return false;
		}

		public boolean isDeprecated(IEObjectDescription description) {
			return false;
		}
	}

	@Inject
	private DocumentSymbolMapper.DocumentSymbolNameProvider nameProvider;

	@Inject
	private DocumentSymbolMapper.DocumentSymbolKindProvider kindProvider;

	@Inject
	private DocumentSymbolMapper.DocumentSymbolRangeProvider rangeProvider;

	@Inject
	private DocumentSymbolMapper.DocumentSymbolDetailsProvider detailsProvider;

	@Inject
	private DocumentSymbolMapper.DocumentSymbolDeprecationInfoProvider deprecationInfoProvider;

	/**
	 * Converts the {@code EObject} argument into a {@link DocumentSymbol document symbol} without the
	 * {@link DocumentSymbol#children children} information filled in.
	 */
	public DocumentSymbol toDocumentSymbol(EObject object) {
		DocumentSymbol documentSymbol = new DocumentSymbol();
		String objectName = nameProvider.getName(object);
		if (objectName != null) {
			documentSymbol.setName(objectName);
		}
		SymbolKind objectKind = kindProvider.getSymbolKind(object);
		if (objectKind != null) {
			documentSymbol.setKind(objectKind);
		}
		Range objectRange = rangeProvider.getRange(object);
		if (objectRange != null) {
			documentSymbol.setRange(objectRange);
		}
		Range objectSelectionRange = rangeProvider.getSelectionRange(object);
		if (objectSelectionRange != null) {
			documentSymbol.setSelectionRange(objectSelectionRange);
		}
		documentSymbol.setDetail(detailsProvider.getDetails(object));
		documentSymbol.setDeprecated(deprecationInfoProvider.isDeprecated(object));
		documentSymbol.setChildren(new ArrayList<>());
		return documentSymbol;
	}
}
