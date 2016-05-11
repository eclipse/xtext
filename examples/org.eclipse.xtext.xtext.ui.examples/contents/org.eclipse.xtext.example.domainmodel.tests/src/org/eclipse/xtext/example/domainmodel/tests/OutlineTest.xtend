package org.eclipse.xtext.example.domainmodel.tests

import org.eclipse.xtext.example.domainmodel.DomainmodelUiInjectorProvider
import org.eclipse.xtext.example.domainmodel.ui.internal.DomainmodelActivator
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractOutlineTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(DomainmodelUiInjectorProvider))
class OutlineTest extends AbstractOutlineTest {

	override protected getEditorId() {
		DomainmodelActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_DOMAINMODEL_DOMAINMODEL
	}

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
