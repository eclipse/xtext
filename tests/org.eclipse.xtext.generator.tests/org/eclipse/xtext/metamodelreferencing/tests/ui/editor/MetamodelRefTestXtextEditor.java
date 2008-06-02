package org.eclipse.xtext.metamodelreferencing.tests.ui.editor;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.ui.core.editor.BaseTextEditor;

/**
 * @author Generated with Xtext
 * @generated
 */
public class MetamodelRefTestXtextEditor extends BaseTextEditor {
    
    protected ILanguageDescriptor initializeLanguageDescriptor() {
        return LanguageDescriptorFactory.get("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest");
    }

}
