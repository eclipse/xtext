package org.eclipse.xtext.example.domainmodel.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import com.google.inject.Inject
import org.junit.Test
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import junit.framework.Assert
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Property

@org.junit.runner.RunWith(typeof(XtextRunner))
@InjectWith(typeof(InjectorProviderCustom))
class ParserTest {
	
	@Inject
	ParseHelper<DomainModel> parser

	@Test
	def void testParsing() {
		val model = parser.parse('''
			package example {
			  entity MyEntity {
			    property : String
			  }
			}
		''')
		
		val pack = model.getElements().get(0) as PackageDeclaration
		Assert::assertEquals("example", pack.getName())
		
		val entity = pack.getElements().get(0) as Entity
		Assert::assertEquals("MyEntity", entity.getName())
		
		val property = entity.getFeatures().get(0) as Property
		Assert::assertEquals("property", property.getName());
		Assert::assertEquals("java.lang.String", property.getType().getIdentifier());
	}
}