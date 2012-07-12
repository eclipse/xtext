package org.eclipse.xtend.core.formatting

class RendererConfiguration { 
	@Property String lineSeparator
	@Property String indentation
	@Property int indentationLength = 4
	@Property int maxLineWidth = 80
	
	def getIndentation(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_indentation].join 
		else 
			""
	}
	
	def getWrap(int levels) {
		if(levels > 0) 
			(0..levels - 1).map[_lineSeparator].join 
		else 
			""
	}
}