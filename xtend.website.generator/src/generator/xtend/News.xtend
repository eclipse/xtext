package generator.xtend

class News extends AbstractXtendWebsite {

	override path() {
		"news.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	override javaScriptDocumentStart() {
		'''
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<script type="text/javascript">
			google.load("feeds", "1");
			</script>
		'''+ super.javaScriptDocumentStart().toString
	}
	
	override jsOnLoad() {
		'''
		var feed = new google.feeds.Feed("http://xtendnews.blogspot.com/feeds/posts/default?orderby=published&foo="+new Date().getTime());
		feed.load(function(result) {
			if (!result.error) {
				var container = document.getElementById("feed");
				var html = '<h1>Latest News</h1><hr>'
				for (var i = 0; i < result.feed.entries.length; i++) {
					var entry = result.feed.entries[i];
					var div = document.createElement("div");
					div.appendChild(document.createTextNode(entry.title));
					container.appendChild(div);
					var stringEntry = '<div class="row"><div class="span1">&nbsp;</div><div class="span10">'
									+ '<h2>'+entry.title+' <small>published '+new Date(entry.publishedDate).toDateString()+' by '+ entry.author+'</small></h2>'
			        				+ '<p>' + entry.content+'</p>'
			        				+ '</div><div class="span1">&nbsp;</div></div>'
					var html = html + stringEntry
				}
				container.innerHTML = html
			}
		});
		''' + super.jsOnLoad().toString
	}
	
	override contents() '''
		<div id="page">
			<div class="inner">
				<div class="container clearfix" id="feed">
					<h1>Loading Latest News...</h1>
				</div>
			</div>
		</div>
	'''
	
}