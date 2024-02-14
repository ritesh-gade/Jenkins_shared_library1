def call() {
    sh 'trivy image riteshgade16@gmail.com/youtube:latest > trivyimage.txt'
}
