package org.eclipse.xtext.example.domainmodel.ui.tests

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelFactory
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.IImageHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class LabelProviderTest {

	@Inject ILabelProvider labelProvider
	@Inject IImageHelper imageHelper

	val extension DomainmodelFactory = DomainmodelFactory.eINSTANCE

	@Test def package_image() {
		createPackageDeclaration.hasImage("PackageDeclaration.gif")
	}

	@Test def entity_image() {
		createEntity.hasImage("Entity.gif")
	}

	@Test def property_image() {
		createProperty.hasImage("Property.gif")
	}

	@Test def operation_image() {
		createOperation.hasImage("Operation.gif")
	}

	private def hasImage(EObject eObject, String image) {
		val actual = labelProvider.getImage(eObject)
		val expected = imageHelper.getImage(image) 
		expected.assertEquals(actual)
	}

}