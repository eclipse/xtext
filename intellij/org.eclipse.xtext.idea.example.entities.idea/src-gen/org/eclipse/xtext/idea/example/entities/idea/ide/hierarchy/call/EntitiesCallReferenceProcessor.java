package org.eclipse.xtext.idea.example.entities.idea.ide.hierarchy.call;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

public class EntitiesCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public EntitiesCallReferenceProcessor() {
		super(EntitiesLanguage.INSTANCE);
	}

}
