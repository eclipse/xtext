package org.eclipse.xtend.core.idea.highlighting

class XtendColorSettingsPage extends XtendBaseColorSettingsPage {
	override String getDemoText() ''' 
		/**
		 * some comment
		 */
		<xbase.annotation>@Annotation</xbase.annotation>
		<xtend.active.annotation>@ActiveAnnotation</xtend.active.annotation>
		class XtendType {
		    String <xbase.field>str</xbase.field> = "string"
		    
		    // <task>TODO: some task</task>
		    Integer i = 5
		    
		    static val <xbase.static.field>staticField</xbase.static.field> = <xbase.static.method.invocation>SomeType.staticMethod</xbase.static.method.invocation>()
		    
		    @Deprecated 
		    def deprecatedMethod(String s) {
		        s.<xbase.extension.method.invacation>extensionMethod</xbase.extension.method.invacation>()
		    }
		    
		    def template() «"'''"»
		        <xtend.richText>This goes right into the output</xtend.richText>
		        <xtend.richText>   indented in output</xtend.richText>
		        <xtend.richText.delimiter>«"«"»</xtend.richText.delimiter>FOR i: 0..10<xtend.richText.delimiter>«"»"»</xtend.richText.delimiter>
		            not indented in output
		        <xtend.richText.delimiter>«"«"»</xtend.richText.delimiter>ENDFOR<xtend.richText.delimiter>«"»"»</xtend.richText.delimiter>
		    «"'''"» 
		}   
	'''

}
