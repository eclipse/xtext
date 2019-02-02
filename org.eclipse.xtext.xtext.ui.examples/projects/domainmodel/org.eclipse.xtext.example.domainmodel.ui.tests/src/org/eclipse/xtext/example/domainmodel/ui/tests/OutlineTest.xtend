package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractOutlineTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class OutlineTest extends AbstractOutlineTest {

	@Test def void testOutline() {
		'''
			entity Foo {
				name : String
				op doStuff(String x) : String {
					return x + ' ' + this.name
				}
			}
		'''.assertAllLabels(
			'''
				Foo
				  name : String
				  doStuff(String) : String
			'''
		)
	}

	@Test def void testOutlineWithPackage() {
		'''
			package mypackage {
				entity Foo {
					name : String
					op doStuff(String x) : String {
						return x + ' ' + this.name
					}
				}
			}
		'''.assertAllLabels(
			'''
				mypackage
				  Foo
				    name : String
				    doStuff(String) : String
			'''
		)
	}
}
