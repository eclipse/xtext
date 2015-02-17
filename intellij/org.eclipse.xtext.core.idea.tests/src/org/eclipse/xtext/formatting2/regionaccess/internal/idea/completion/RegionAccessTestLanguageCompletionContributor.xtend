package org.eclipse.xtext.formatting2.regionaccess.internal.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;

class RegionAccessTestLanguageCompletionContributor extends AbstractRegionAccessTestLanguageCompletionContributor {
	new() {
		this(RegionAccessTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


