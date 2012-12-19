package bootstrap

import java.util.regex.Pattern
import com.google.inject.Inject

class PostProcessor {
	
	@Inject extension HtmlExtensions
	
	protected Pattern _codePattern

	def protected getCodePattern() {
		if(_codePattern == null)
		 	_codePattern = Pattern::compile(
		 		Pattern::quote(markCodeBegin) + "\\n(\\s*).*?" + Pattern::quote(markCodeEnd), 
		 		Pattern::MULTILINE + Pattern::DOTALL
		 	)
		 _codePattern
	}
	
	def protected unindentCodeBlocks(CharSequence it) {
		var html = it.toString
		var matcher = codePattern.matcher(html)
		while(matcher.find()) {
			var code = matcher.group
			code = code.replace(markCodeBegin, '')
			code = code.replace(markCodeEnd, '')
			code = code.replaceAll(Pattern::quote(matcher.group(1)), '')
			html = html.substring(0, matcher.start) + code + html.substring(matcher.end)
			matcher = codePattern.matcher(html)
		}
		html
	}
	
	def postProcess(CharSequence it) {
		unindentCodeBlocks
	}
}