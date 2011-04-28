
package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import static junit.framework.Assert.*;

/**
 * Example test
 */
@RunWith(XtextRunner.class)
@InjectWith(InjectorProviderCustom.class)
public class ParserTest {
	
	@Inject
	private ParseHelper<DomainModel> parser;

	@Test
	public void testParsing() throws Exception {
		DomainModel model = parser.parse(
				"package example {" +
				"  entity MyEntity {" +
				"    property : String" +
				"  }" +
				"}");
		
		PackageDeclaration pack = (PackageDeclaration) model.getElements().get(0);
		assertEquals("example", pack.getName());
		
		Entity entity = (Entity) pack.getElements().get(0);
		assertEquals("MyEntity", entity.getName());
		
		Property property = (Property) entity.getFeatures().get(0);
		assertEquals("property", property.getName());
		assertEquals("java.lang.String", property.getType().getIdentifier());
	}
}
