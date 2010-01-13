package org.eclipse.xtext.example.gmf.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;
import org.eclipse.xtext.example.gmf.entities.Entity;
import org.eclipse.xtext.example.gmf.entities.Property;
import org.eclipse.xtext.example.gmf.entities.SimpleProperty;
import org.eclipse.xtext.validation.Check;
 

public class EntitiesJavaValidator extends AbstractEntitiesJavaValidator {

	@Check
	public void checkEntityNameStartsWithCapital(Entity entity) {
		if (!Character.isUpperCase(entity.getName().charAt(0))) {
			warning("Name should start with a capital letter", EntitiesPackage.ENTITY__NAME);
		}
	}

	@Check
	public void checkPropertyNameStartsWithCapital(Property property) {
		if (!Character.isLowerCase(property.getName().charAt(0))) {
			warning("Name should start with a lower case letter", EntitiesPackage.ENTITY__NAME);
		}
	}

	@Check
	public void noNameCollision(Property property) {
		noNameCollision(property, property.eContainer().eContents(), EntitiesPackage.Literals.PROPERTY__NAME);
	}

	@Check
	public void noNameCollision(Entity entity) {
		noNameCollision(entity, entity.eContainer().eContents(), EntitiesPackage.Literals.PROPERTY__NAME);
	}
	
	private void noNameCollision(EObject eObject, List<EObject> siblings, EStructuralFeature nameFeature) {
		String name = (String) eObject.eGet(nameFeature);
		for (EObject sibling : siblings) {
			if(name.equals(sibling.eGet(nameFeature)) && eObject != sibling) {
				error("Duplicate name", nameFeature.getFeatureID());
			}
		}
	}
	
	@Check 
	public void simplePropertyTypeIsSet(SimpleProperty s) {
		if(s.getType() == null) {
			error("Property must have a type", EntitiesPackage.SIMPLE_PROPERTY__NAME);
		}
	}
}
