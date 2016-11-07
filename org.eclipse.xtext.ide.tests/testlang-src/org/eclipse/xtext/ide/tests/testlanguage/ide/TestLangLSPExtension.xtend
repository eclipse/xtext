/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide

import com.google.inject.ImplementedBy
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest
import org.eclipse.xtext.ide.server.DocumentAccess
import org.eclipse.xtext.ide.server.LanguageServerExtension

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl)
interface TestLangLSPExtension extends LanguageServerExtension {
	
	@JsonRequest
	def CompletableFuture<TextOfLineResult> getTextOfLine(TextOfLineParam param)

	static class TextOfLineResult {
		public String text
	}
	static class TextOfLineParam {
		public String uri
		public int line
	}
	
	static class Impl implements LanguageServerExtension, TestLangLSPExtension {

		DocumentAccess access
	
		override getTextOfLine(TextOfLineParam param) {
			return access.doRead(param.uri) [ ctx |
				val start = ctx.document.getOffSet(new Position(param.line, 0 ))
				val end = ctx.document.getOffSet(new Position(param.line + 1, 0 )) -1
				return new TextOfLineResult => [
					text = ctx.document.contents.substring(start, end)
				]
			]
		}
		
		override initialize(DocumentAccess access) {
			this.access = access
		}
		
	}
}
