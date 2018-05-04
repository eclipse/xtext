How to Test the Website
=======================

The website is generated with [Jekyll](http://jekyllrb.com).
```
gem install bundler jekyll jekyll-markdown-block
```
To generate the website, run
```
  jekyll build --unpublished
```
You will find the result in the `_site` folder. You can test it locally with
```
  jekyll serve --unpublished
```
which will start a [server](http://127.0.0.1:4000) displaying the site. The server also listens for file changes and
automatically rebuilds the website.

Ruby Troubleshooting
--------------------

- On Linux/Mac OS we recommend using [RVM](https://rvm.io/) to manage your Ruby installations
- On Windows you will have to install the [development kit](https://github.com/oneclick/rubyinstaller/wiki/Development-Kit)

### For hudson:

```
rvm autolibs disable
rvm install ruby-2.2.0
rvm use 2.2.0
~/.rvm/rubies/ruby-2.2.0/bin/gem install jekyll
~/.rvm/rubies/ruby-2.2.0/bin/gem install bundler
~/.rvm/rubies/ruby-2.2.0/bin/gem install jekyll-markdown-block
```
