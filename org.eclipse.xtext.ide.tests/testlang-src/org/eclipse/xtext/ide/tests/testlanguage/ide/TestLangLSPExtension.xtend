/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide

import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest
import com.google.inject.ImplementedBy
import org.eclipse.xtext.ide.server.LanguageServerExtension
import org.eclipse.lsp4j.jsonrpc.CompletableFutures

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl)
interface TestLangLSPExtension extends LanguageServerExtension {
	@JsonNotification
	def void sayHello()

	@JsonRequest
	def CompletableFuture<Text> getFullText(Text param)

	static class Text {
		public String text
	}
	
	static class Impl implements LanguageServerExtension, TestLangLSPExtension {

		private String text = ""
	
		override sayHello() {
			if (text.length > 0) {
				throw LanguageServerExtension.NOT_HANDLED_EXCEPTION
			}
			text += "Hello "
		}
	
		override getFullText(Text param) {
			CompletableFutures.computeAsync [
				return new Text => [
					text = this.text + param.text
				]
			]
		}
	}
}
