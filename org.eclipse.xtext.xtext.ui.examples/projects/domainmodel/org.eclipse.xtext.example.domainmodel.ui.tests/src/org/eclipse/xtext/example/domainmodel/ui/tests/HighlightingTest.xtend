/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHighlightingTest
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class HighlightingTest extends AbstractHighlightingTest {

	@Inject extension XbaseHighlightingConfiguration

	@Before def void setup() throws Exception {
		/*
		 * Xbase-based languages require java project
		 */
		 projectName.createJavaProject
	}

	@Test def package_keyword() {
		'''
			package P {}
		'''.testHighlighting("package", keywordTextStyle)
	}

	@Test def entity_keyword() {
		'''
			entity E {}
		'''.testHighlighting("entity", keywordTextStyle)
	}

	@Test def extends_keyword() {
		'''
			entity A {}
			entity B extends A {}
		'''.testHighlighting("extends", keywordTextStyle)
	}

	@Test def op_keyword() {
		'''
			entity E {
				op m() {}
			}
		'''.testHighlighting("op", keywordTextStyle)
	}

	@Test def import_keyword() {
		'''
			import java.util.List
			entity E {
				adresse : List<String>
			}
		'''.testHighlighting("import", keywordTextStyle)
	}

	@Test def int_keyword() {
		'''
			entity E {
				op m(int b) {}
			}
		'''.testHighlighting("int", keywordTextStyle)
	}

	@Test def boolean_keyword() {
		'''
			entity E {
				op m(boolean b) {}
			}
		'''.testHighlighting("boolean", keywordTextStyle)
	}

	@Test def if_keyword() {
		'''
			entity E {
				op m(boolean b) {
					if (b) 1 else 2
				}
			}
		'''.testHighlighting("if", keywordTextStyle)
	}

	@Test def else_keyword() {
		'''
			entity E {
				op m(boolean b) {
					if (b) 1 else 2
				}
			}
		'''.testHighlighting("else", keywordTextStyle)
	}

	@Test def return_keyword() {
		'''
			entity E {
				op m(boolean b) {
					return if (b) 1 else 2
				}
			}
		'''.testHighlighting("return", keywordTextStyle)
	}

	@Test def instanceof_keyword() {
		'''
			entity A {
				op m(A a) {
					if (a instanceof B) 1 else 2
				}
			}
			entity B extends A {}
		'''.testHighlighting("instanceof", keywordTextStyle)
	}

	@Test def single_line_comment() {
		'''
			// A language to model domain-model elements
			entity E {
			}
		'''.testHighlighting("A language to model domain-model elements", commentTextStyle)
	}

	@Test def multi_line_comment() {
		'''
			/*
			 * A language to model domain-model elements.
			 * Each entity can have properties, operations
			 * and relations to each other.
			 */
			entity E {
			}
		'''.testHighlighting('''
			/*
			 * A language to model domain-model elements.
			 * Each entity can have properties, operations
			 * and relations to each other.
			 */
		''', commentTextStyle)
	}

	@Test def javadoc_comment() {
		'''
			/**
			 * A language to model domain-model elements.
			 * Each entity can have properties, operations
			 * and relations to each other.
			 */
			entity E {
			}
		'''.testHighlighting('''
			/**
			 * A language to model domain-model elements.
			 * Each entity can have properties, operations
			 * and relations to each other.
			 */
		''', commentTextStyle)
	}

	@Test def fixme_task_in_comment() {
		'''
			/**
			 * FIXME
			 */
			entity E {}
		'''.testHighlighting("FIXME", taskTextStyle)
	}

	@Test def todo_task_in_comment() {
		'''
			/**
			 * TODO
			 */
			entity E {}
		'''.testHighlighting("TODO", taskTextStyle)
	}

	@Test def xxx_task_in_comment() {
		'''
			/**
			 * XXX
			 */
			entity E {}
		'''.testHighlighting("XXX", taskTextStyle)
	}

	@Test def single_quoted_string() {
		'''
			entity E {
				a : String
				op m() {
					a = 'foo'
				}
			}
		'''.testHighlighting("'foo'", stringTextStyle)
	}

	@Test def double_quoted_string() {
		'''
			entity E {
				a : String
				op m() {
					a = "foo"
				}
			}
		'''.testHighlighting('"foo"', stringTextStyle)
	}

	@Test def number_literal() {
		'''
			entity E {
				a : int
				op m() {
					a = 100
				}
			}
		'''.testHighlighting('100', numberTextStyle)
	}

}