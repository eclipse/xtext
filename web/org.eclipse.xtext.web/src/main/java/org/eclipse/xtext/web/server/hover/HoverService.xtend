package org.eclipse.xtext.web.server.hover

import com.google.inject.Inject
import com.google.inject.Singleton
import org.apache.log4j.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ide.labels.AlternativeImageDescription
import org.eclipse.xtext.ide.labels.DecoratedImageDescription
import org.eclipse.xtext.ide.labels.IImageDescription
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider
import org.eclipse.xtext.ide.labels.INameLabelProvider
import org.eclipse.xtext.ide.labels.SimpleImageDescription
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

@Singleton
class HoverService {

	static val LOG = Logger.getLogger(HoverService) 
	
	@Inject extension EObjectAtOffsetHelper  
	@Inject extension IEObjectDocumentationProvider 
	@Inject extension IImageDescriptionProvider 
	@Inject extension INameLabelProvider 
	
	def HoverResult getHover(XtextWebDocumentAccess document, int offset) {
		document.readOnly[ it, cancelIndicator |
			var element = resolveElementAt(resource, offset)
			val nameLabel = element?.nameLabel?.surroundWithDiv('element-name')
			if(nameLabel != null) {
				val titleHtml = element.imageDescription.addIconDivs(nameLabel).surroundWithDiv('hover')
				val bodyHtml = (element.documentation ?: '').surroundWithDiv('hover')
				val result = new HoverResult(titleHtml, bodyHtml)
				LOG.trace(result)
				result
			} else {
				null
			}
		]
	}	
	
	protected def String addIconDivs(IImageDescription it, String nameHtml) {
		switch it {
			SimpleImageDescription:
				nameHtml.surroundWithDiv(imageID + '-icon')
			AlternativeImageDescription:
				nameHtml.surroundWithDiv(imageIDs.map[it + '-icon'])
			DecoratedImageDescription:
				(decorators + #[baseImage]).fold(nameHtml, [$1.addIconDivs($0)])
		}
	}
	
	protected def String surroundWithDiv(String html, String... divClasses) '''
		<div class="«divClasses.map[it].join(' ')»">
			«html»
		</div>
	'''
}