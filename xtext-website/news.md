---
layout: default
---
<div id="page">  
	<div class="inner">
		<div class="container clearfix">
			{% for post in site.categories.news limit:10 %}
				<div class="post">
					<h2><a href="{{ site.baseurl }}/{{ post.url }}">{{ post.title }}</a><small>&nbsp;&nbsp;&nbsp;{{ post.date | date: "%b %-d, %Y" }}</small></h2>
					{{ post.content }}
					<br/>
				</div>
			{% endfor %}
		</div>
  	</div>
</div>