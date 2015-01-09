package bootstrap

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xdoc.xdoc.Anchor
import org.eclipse.xtext.xdoc.xdoc.ChapterRef
import org.eclipse.xtext.xdoc.xdoc.Code
import org.eclipse.xtext.xdoc.xdoc.CodeBlock
import org.eclipse.xtext.xdoc.xdoc.CodeRef
import org.eclipse.xtext.xdoc.xdoc.Emphasize
import org.eclipse.xtext.xdoc.xdoc.Identifiable
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import org.eclipse.xtext.xdoc.xdoc.Item
import org.eclipse.xtext.xdoc.xdoc.Link
import org.eclipse.xtext.xdoc.xdoc.OrderedList
import org.eclipse.xtext.xdoc.xdoc.Ref
import org.eclipse.xtext.xdoc.xdoc.Section2Ref
import org.eclipse.xtext.xdoc.xdoc.SectionRef
import org.eclipse.xtext.xdoc.xdoc.Table
import org.eclipse.xtext.xdoc.xdoc.TableData
import org.eclipse.xtext.xdoc.xdoc.TableRow
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup
import org.eclipse.xtext.xdoc.xdoc.TextPart
import org.eclipse.xtext.xdoc.xdoc.Todo
import org.eclipse.xtext.xdoc.xdoc.UnorderedList
import org.eclipse.xtext.xdoc.xdoc.XdocPackage$Literals

import static bootstrap.ParagraphState.*
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmDeclaredType

class ArtificialIds extends AdapterImpl {
	public Map<Identifiable, String> artificialHrefs = newHashMap() 	
}

class HtmlExtensions {
	
	@Inject extension CodeRefs
	@Inject extension ImageExtensions
	@Inject extension TargetPaths

	def href(Identifiable it) {
		targetPath + "#" + hrefId
	}

	def hrefId(Identifiable id) {
		val it = switch id {
			ChapterRef : id.chapter
			SectionRef : id.section
			Section2Ref : id.section2
			default : id
		}
		if(name != null) { 
			name 
		} else if(artificialHrefIds.containsKey(it)) {
			artificialHrefIds.get(it)
		} else {
			val newHref = '_'+artificialHrefIds.size()
			artificialHrefIds.put(it, newHref)
			newHref
		}  
	}
	
	def protected artificialHrefIds(Identifiable id) {
		val adapters = id.eResource.resourceSet.eAdapters
		val adapter = adapters.filter(typeof(ArtificialIds)).head 
						?: (new ArtificialIds => [
							adapters.add(it)
						])
		return adapter.artificialHrefs
	}
	
	
	def protected dispatch CharSequence toHtml(TextOrMarkup it, ParagraphState state) {
		val innerState = if (state == NONE) IN_PARAGRAPH else state  
		val contentsToHtml = contents.toHtml(innerState).toString.trim
		if(!contentsToHtml.nullOrEmpty) {
			if(state == NONE) {
				val result = '''
					<p>
						«contentsToHtml»
					</p>
				'''
				result
			} else {
				contentsToHtml
			}
		} else {
			''
		}
		
	}
	
	def toHtmlText(Object element) {
		toHtml(element, IN_PARAGRAPH)
	}

	def toHtmlParagraph(Object element) {
		toHtml(element, NONE)
	}

	def protected dispatch CharSequence toHtml(List<EObject> it, ParagraphState state) {
		map[toHtml(state)].join
	}

	def protected dispatch CharSequence toHtml(TextPart it, ParagraphState state) '''«text.quote»'''
	
	def protected dispatch CharSequence toHtml(Emphasize it, ParagraphState state) '''<strong>«contents.toHtml(state)»</strong>'''

	def protected dispatch CharSequence toHtml(Anchor it, ParagraphState state) '''
		<a name="«name.quote»"></a>
	'''
	
	def protected dispatch CharSequence toHtml(Ref it, ParagraphState state) '''<a href="«ref.href»">«contents.toHtml(state)»</a>'''
	
	def protected dispatch CharSequence toHtml(OrderedList it, ParagraphState state) { '''
			<ol>
				«FOR item:items»
					«item.toHtml(state)»
				«ENDFOR»
			</ol>
		'''.insert(state)
	}
	
	def protected dispatch CharSequence toHtml(Item it, ParagraphState state) '''
		<li>«contents.toHtml(IN_LISTITEM)»</li>
	'''
	
	def protected dispatch CharSequence toHtml(UnorderedList it, ParagraphState state) { '''
			<ul>
				«FOR item:items»
					«item.toHtml(state)»
				«ENDFOR»
			</ul>
		'''.insert(state)
	}
	
	def protected dispatch CharSequence toHtml(ImageRef it, ParagraphState state) {
		val dimension = it.dimension
		val caption = it.caption?.trim
		'''
			<div class="thumbnail">
				<img src="«path»" alt="«caption»" «IF dimension!=null»width="«dimension.width»" height="«dimension.height»"«ENDIF»>
			</div>
		'''.insert(state)
	}
	
	def protected dispatch CharSequence toHtml(Todo it, ParagraphState state) {
		println("TODO: " + text)
		return ""
	}
	
	def protected dispatch CharSequence toHtml(CodeRef it, ParagraphState state) {
		val sourceCodeURI = element?.sourceCodeURI
		val javaDocURI = element?.javaDocURI
		'''
		«IF javaDocURI != null
			»<a href="«javaDocURI»">«
		ENDIF»«
		IF altText != null
			»«altText.toHtml(state)»«
		ELSE
			»<abbr title="«element?.identifier»">«
			IF element instanceof JvmAnnotationType
				»@«
			ENDIF
			»«element?.printName?.trim»</abbr>«
		ENDIF»«
		IF javaDocURI != null 
			»</a>«
		ENDIF»«
		IF sourceCodeURI!=null
			» <a href="«sourceCodeURI»">(src)</a>«
		ENDIF»'''
	}
	
	def String printName(JvmIdentifiableElement e) {
		(if (e.eContainer instanceof JvmIdentifiableElement) {
			printName(e.eContainer as JvmIdentifiableElement)+'.'
		} else '') + e.simpleName
	}
	
	def protected dispatch CharSequence toHtml(Code it, ParagraphState state) {
		contents.quote
	}
	
	def protected dispatch CharSequence toHtml(CodeBlock it, ParagraphState state) {
		val code = contents.toHtml(state).toString
		if (code.contains('\n') || eContainer?.eContainingFeature == XdocPackage$Literals::ABSTRACT_SECTION__CONTENTS && switch x:eContainer {
			TextOrMarkup: 
				x.contents.size == 1
			default: false
		}) {
			'''<pre class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'» linenums">«markCodeBegin»
			«code.trimCode»«markCodeEnd»</pre>'''.insert(state)
		} else {
			'''<code class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'»">«code.trimCode»</code>'''
		}
	}
	
	def protected dispatch CharSequence toHtml(Link it, ParagraphState state) '''<a href="«url»">«text»</a>'''

	def protected dispatch CharSequence toHtml(Table it, ParagraphState state) { '''
			<table class="table table-bordered table-condensed">
			«FOR row:rows»
				«row.toHtml(state)»
			«ENDFOR»
			</table>
		'''.insert(state)
	}
	
	def protected dispatch CharSequence toHtml(TableRow it, ParagraphState state) '''
		<tr>«data.toHtml(state)»</tr>
	'''
	
	def protected dispatch CharSequence toHtml(TableData it, ParagraphState state) '''
		<td>«contents.toHtml(state)»</td>
	'''
	
	def protected dispatch CharSequence toHtml(EObject it, ParagraphState state) {
		println("Missing toHtml for " + eClass.name)
		""
	}
	
	def markCodeBegin() {
		'###xdoc code begin###'
	}	
	def markCodeEnd() {
		'###xdoc code end###'
	}	
	
	def protected insert(CharSequence content, ParagraphState state) {
		if(state == IN_PARAGRAPH) '''
			</p>
			«content»
			<p>
		''' else content
	}
	
	def protected trimCode(String it) {
		if(nullOrEmpty) 
			return ''
		var start = 0
		while(start < length()-1 && (substring(start, start+1) == ' ' || substring(start,start+1) == '\t'))
			start = start + 1;
		if(substring(start,start+1) =='\n')
			start = start + 1;
		var end = length()-1
		while(end >0 && Character::isWhitespace(charAt(end)))
			end = end - 1
		substring(start, end+1)
	}
	
	def protected quote(CharSequence it) {
		toString.replace('&', '&amp;')
			.replace('<', '&lt;').replace('>', '&gt;')
			.replace('«', '&laquo;').replace('»', '&raquo;')
			.replace('\\[', '[').replace('\\]',']')
			.replace('´',"'").replace('`',"'")
	}

}