if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

./gradlew \
  clean cleanGenerateXtext build createLocalMavenRepo \
  -Dmaven.repo.local=$(pwd)/.m2/repository \
  -PcompileXtend=true \
  -PJENKINS_URL=$JENKINS_URL \
  -PignoreTestFailures=true \
  --refresh-dependencies \
  --continue
