package org.eclipse.xtext.dummy.ui.editor;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.ui.core.editor.BaseTextEditor;

/**
 * @author Generated with Xtext
 * @generated
 */
public class DummyLanguageXtextEditor extends BaseTextEditor {
    
    protected ILanguageDescriptor initializeLanguageDescriptor() {
        return LanguageDescriptorFactory.get("org.eclipse.xtext.dummy.DummyLanguage");
    }

}
