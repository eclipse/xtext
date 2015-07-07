package org.eclipse.xtext.idea.sdomain.idea.highlighting

import com.intellij.openapi.options.colors.AttributesDescriptor
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage

class SDomainColorSettingsPage extends AbstractColorSettingsPage {
	AttributesDescriptor[] descriptors

	new() {
		SDomainLanguage.INSTANCE.injectMembers(this)
	}

	override getDemoText() {
		'''
			entity Foo {
				// comment
			}
		'''
	}

	override AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			descriptors = #[
				createDescriptor("Keywords", SDomainSyntaxHighlighter.KEYWORD),
				createDescriptor("Numbers", SDomainSyntaxHighlighter.NUMBER),
				createDescriptor("Comments", SDomainSyntaxHighlighter.COMMENT),
				createDescriptor("Strings", SDomainSyntaxHighlighter.STRING)
			]
		}
		return descriptors
	}

	override String getDisplayName() {
		return SDomainLanguage.INSTANCE.displayName
	}

}
