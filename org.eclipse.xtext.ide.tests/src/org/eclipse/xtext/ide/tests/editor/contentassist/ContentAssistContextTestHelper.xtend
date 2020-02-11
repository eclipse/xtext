/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.contentassist

import com.google.common.base.Preconditions
import com.google.inject.Inject
import java.util.concurrent.Executors
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.TextRegion

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class ContentAssistContextTestHelper {
	@Inject FileExtensionProvider fileExtension
	@Inject IResourceFactory resFactory
	@Inject ValidationTestHelper validator

	@Accessors String document
	@Accessors ParserRule entryPoint
	@Accessors String cursor = "<|>"

	def private XtextResource parse(String doc) {
		val uri = URI.createURI("dummy." + fileExtension.primaryFileExtension)
		val res = resFactory.createResource(uri) as XtextResource
		new XtextResourceSet().resources += res
		if (entryPoint !== null) {
			res.entryPoint = entryPoint
		}
		res.load(new StringInputStream(doc), emptyMap)
		validator.assertNoErrors(res)
		return res
	}

	def String firstSetGrammarElementsToString(ContentAssistContextFactory factory) {
		val offset = document.indexOf(cursor)
		Preconditions.checkArgument(offset >= 0, "you forgot to provide a cursor")
		val doc = document.replace(cursor, "")
		val res = parse(doc)
		factory.pool = Executors.newCachedThreadPool
		val ctxs = factory.create(doc, new TextRegion(0, 0), offset, res)
		val f = new GrammarElementTitleSwitch().showAssignments.showQualified.showRule
		return '''
			«FOR ctx : ctxs.indexed»
				context«ctx.key» {
					«FOR ele:ctx.value.firstSetGrammarElements»
						«ele.eClass.name»: «f.apply(ele)»
					«ENDFOR»
				}
			«ENDFOR»
		'''
	}
}
