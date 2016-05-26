/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol

import com.google.inject.Inject
import com.google.inject.Singleton
import io.typefox.lsapi.SymbolInformation
import io.typefox.lsapi.SymbolInformationImpl
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.XtextResource

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DocumentSymbolService {

	@Inject
	extension DocumentExtensions

	@Inject
	extension IQualifiedNameProvider qualifiedNameProvider

	def List<? extends SymbolInformation> getSymbols(XtextResource resource) {
		val symbols = newLinkedHashMap
		val contents = resource.getAllProperContents(true)
		while (contents.hasNext) {
			val obj = contents.next
			val symbol = obj.createSymbol
			if (symbol !== null) {
				symbols.put(obj, symbol)

				val container = obj.container
				val containerSymbol = symbols.get(container)
				symbol.container = containerSymbol?.name
			}
		}
		return symbols.values.toList
	}

	protected def EObject getContainer(EObject obj) {
		return obj.eContainer
	}

	protected def SymbolInformationImpl createSymbol(EObject object) {
		val symbolName = object.symbolName
		if(symbolName === null) return null

		val symbol = new SymbolInformationImpl
		symbol.name = symbolName
		symbol.kind = object.symbolKind
		symbol.location = object.newLocation
		return symbol
	}

	protected def String getSymbolName(EObject object) {
		return object.fullyQualifiedName?.toString
	}

	protected def int getSymbolKind(EObject object) {
		return 0
	}

}
