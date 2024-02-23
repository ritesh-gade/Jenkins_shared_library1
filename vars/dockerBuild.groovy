def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "sudo -A docker build --build-arg REACT_APP_RAPID_API_KEY=8b7a50760fmshf2f98de1ba2ef54p17d3b6jsn48eda812fafa -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
