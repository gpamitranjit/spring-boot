You need to generate the SSH public/private keys in PEM format without passphrase using below command

$ ssh-keygen -m PEM -t rsa -b 4096

Then you have to copy the file content of "id_rsa.pub" and add it to server's list of known keys

Then you have to copy the file content of "id_rsa" and paste as the value of private-key for below config server property

"spring.cloud.config.server.git.privateKey"


symmetric key encryption is achieved using below configuration in .properties file

"encrypt.key"
