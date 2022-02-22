FROM eclipsecbi/fedora-gtk3-mutter:29-gtk3.24
MAINTAINER karsten.thoms@itemis.de

# Back to root for install
USER 0

RUN dnf -y update

# ruby-devel required to install jekyll
# redhat-rpm-config required during jekyll install: gcc: error: /usr/lib/rpm/redhat/redhat-hardened-cc1: No such file or directory

RUN dnf  --assumeyes install jq ruby ruby-devel redhat-rpm-config gcc-c++ @development-tools
RUN gem install therubyracer --source 'https://rubygems.org/'
RUN gem install bundler jekyll jekyll-markdown-block execjs
# Expose Jekyll serve default port
EXPOSE 4000
# Expose YourKit port
EXPOSE 10001

# Create a default user (user 10001 is used by super image, but does not have a name)
RUN useradd --uid 10002 --shell /bin/bash default
USER default
# Super image set HOME variable to /home/vnc
ENV HOME=/home/default
WORKDIR /home/default

RUN echo "/home/vnc/.vnc/xstartup.sh" >> ~/.bashrc
RUN echo "alias ll='ls -al'" >> ~/.bashrc
ENTRYPOINT "/bin/bash"

USER 0
RUN dnf --assumeyes install \
  java-1.8.0-openjdk.x86_64 \
  java-1.8.0-openjdk-src.x86_64 \
  groovy \
  maven \
  hub
USER default

# needed for Xtend MOJO IT tests
ENV M2_HOME=/usr/share/maven
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk

