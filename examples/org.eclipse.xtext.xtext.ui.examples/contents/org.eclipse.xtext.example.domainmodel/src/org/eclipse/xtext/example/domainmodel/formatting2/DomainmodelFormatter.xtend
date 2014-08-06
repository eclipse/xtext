package org.eclipse.xtext.example.domainmodel.formatting2;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.formatting2.IFormattableDocument;

class DomainmodelFormatter extends org.eclipse.xtext.xbase.formatting2.XbaseFormatter {

	def protected dispatch void format(DomainModel domainmodel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attribtues, cross references, etc. 
		format(domainmodel.getImportSection(), document);
		for (AbstractElement elements : domainmodel.getElements()) {
			format(elements, document);
		}
	}

	def protected dispatch void format(PackageDeclaration packagedeclaration, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attribtues, cross references, etc. 
		for (AbstractElement elements : packagedeclaration.getElements()) {
			format(elements, document);
		}
	}

	def protected dispatch void format(Entity entity, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attribtues, cross references, etc. 
		format(entity.getSuperType(), document);
		for (Feature features : entity.getFeatures()) {
			format(features, document);
		}
	}

	def protected dispatch void format(Property property, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attribtues, cross references, etc. 
		format(property.getType(), document);
	}

	def protected dispatch void format(Operation operation, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attribtues, cross references, etc. 
		for (JvmFormalParameter params : operation.getParams()) {
			format(params, document);
		}
		format(operation.getType(), document);
		format(operation.getBody(), document);
	}
}
