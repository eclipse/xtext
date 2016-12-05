/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.completion

import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.codeInsight.template.impl.TemplateManagerImpl
import org.eclipse.xtend.core.idea.completion.XtendCodeContextType
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author efftinge - Initial contribution and API
 */
class XtendCodeContextTypeTest extends LightXtendTest {
	
	def void testContexts_01() {
		'''
			class MyClass {
				<caret>
			}
		'''.assertContext(
			is(XtendCodeContextType.Generic),
			is(XtendCodeContextType.Member),
			not(XtendCodeContextType.Statement),
			not(XtendCodeContextType.Expression),
			not(XtendCodeContextType.TemplateExpression)
		)
	}
	
	def void testContexts_02() {
		'''
			class MyClass {
				def <caret> foo() {
				}
			}
		'''.assertContext(
			is(XtendCodeContextType.Generic),
			not(XtendCodeContextType.Member),
			not(XtendCodeContextType.Statement),
			not(XtendCodeContextType.Expression),
			not(XtendCodeContextType.TemplateExpression)
		)
	}
	
	def void testContexts_03() {
		'''
			class MyClass {
				def foo() {
					<caret>
				}
			}
		'''.assertContext(
			is(XtendCodeContextType.Generic),
			not(XtendCodeContextType.Member),
			is(XtendCodeContextType.Statement),
			is(XtendCodeContextType.Expression),
			not(XtendCodeContextType.TemplateExpression)
		)
	}
	
	def void testContexts_04() {
		'''
			class MyClass {
				def boolean foo() {
					if (<caret>foo) {
						return false
					}
					return true
				}
			}
		'''.assertContext(
			is(XtendCodeContextType.Generic),
			not(XtendCodeContextType.Member),
			not(XtendCodeContextType.Statement),
			is(XtendCodeContextType.Expression),
			not(XtendCodeContextType.TemplateExpression)
		)
	}
	
	def void testContexts_05() {
		'''
			class MyClass {
				def foo() '«»''
					<caret>
				'«»''
			}
		'''.assertContext(
			is(XtendCodeContextType.Generic),
			not(XtendCodeContextType.Member),
			not(XtendCodeContextType.Statement),
			not(XtendCodeContextType.Expression),
			is(XtendCodeContextType.TemplateExpression)
		)
	}
	
	protected def assertContext(CharSequence text, ContextTypeAssertion ...contextTypes) {
		val file = configureByText(text.toString)
		for (type : contextTypes) {
			assertEquals('''
				
				Code Context :
						«text»
				
				Should «IF !type.shouldMatch»NOT «ENDIF»match: «type.contextType.toString»
				
			''', 
				type.shouldMatch, type.contextType.isInContext(file, editor.caretModel.offset)
			)
		}
	}
	
	protected def not(Class<? extends TemplateContextType> clazz) {
		val ctxType = findTemplateContext(clazz)
		return new ContextTypeAssertion(ctxType, false)
	}
	
	protected def is(Class<? extends TemplateContextType> clazz) {
		val ctxType = findTemplateContext(clazz)
		return new ContextTypeAssertion(ctxType, true)
	}
	
	protected def findTemplateContext(Class<? extends TemplateContextType> clazz) {
		val result = TemplateManagerImpl.allContextTypes.findFirst[
			clazz.isInstance(it)
		]
		if (result === null) {
			throw new AssertionError("The context type "+clazz.name+" wasn't registered.")
		}
		return result
	}
	
	@Data static class ContextTypeAssertion {
		TemplateContextType contextType
		boolean shouldMatch			
	}
	
}