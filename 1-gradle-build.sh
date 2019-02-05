if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

./gradlew \
  clean cleanGenerateXtext build createLocalMavenRepo \
  -PuseJenkinsSnapshots=true \
  -PJENKINS_URL=$JENKINS_URL \
  -PcompileXtend=true \
  -PignoreTestFailures=true \
  --refresh-dependencies \
  --continue \
  $@
