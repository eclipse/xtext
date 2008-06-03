package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.services.XtextMetamodelAccess;

public class XtextMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IMetamodelAccess serviceObject = new XtextMetamodelAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IMetamodelAccess.class;
	}
}
